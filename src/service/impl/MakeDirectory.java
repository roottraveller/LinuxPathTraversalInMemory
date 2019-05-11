package service.impl;

import exception.ApplicationException;
import exception.DirectoryAlreadyExistsException;
import model.Directory;
import repository.Cache;
import repository.impl.InMemoryCache;
import service.Command;

public class MakeDirectory implements Command {

    private final static Cache CACHE = InMemoryCache.getInstance();

    @Override
    public void execute(String arg) throws ApplicationException {
        Directory pwd = (Directory) CACHE.get("pwd");
        if (pwd.getChildren().get(arg) != null) {
            throw new DirectoryAlreadyExistsException();
        } else {
            Directory newDir = new Directory(arg, pwd);
            pwd.getChildren().put(arg, newDir);
            CACHE.put("pwd", pwd, -1);
            CACHE.put("pwdStr", pwd.getPWD(), -1);
            System.out.println("SUCC: CREATED");
        }
    }

}
