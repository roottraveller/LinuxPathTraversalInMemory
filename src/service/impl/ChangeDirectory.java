package service.impl;

import exception.ApplicationException;
import exception.InvalidPathException;
import model.Directory;
import repository.Cache;
import repository.impl.InMemoryCache;
import service.Command;

public class ChangeDirectory implements Command {


    private final static Cache CACHE = InMemoryCache.getInstance();

    @Override
    public void execute(String arg) throws ApplicationException {
        if(null == arg || "".equals(arg) || "/".equals(arg)) {
            CACHE.put("pwd", Directory.ROOT, -1);
            CACHE.put("pwdStr", Directory.ROOT.getPWD(), -1);
            System.out.println("SUCC: REACHED");
            return;
        }
        Directory targetDir = (Directory) CACHE.get("pwd");
        if(arg.startsWith("/")) {
            targetDir = Directory.ROOT;
            arg = arg.substring(1);
        }
        String dirNames[] = arg.split("/");
        int i;
        for(i=0;i < dirNames.length; i++) {
            targetDir = targetDir.getChildren().get(dirNames[i]);
        }
        if(i!=dirNames.length || targetDir == null) {
            throw new InvalidPathException();
        }
        else {
            CACHE.put("pwd", targetDir, -1);
            CACHE.put("pwdStr", targetDir.getPWD(), -1);
            System.out.println("SUCC: REACHED");
        }


    }
}
