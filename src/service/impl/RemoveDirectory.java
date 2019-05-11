package service.impl;

import exception.ApplicationException;
import exception.DirectoryNotFoundException;
import model.Directory;
import repository.Cache;
import repository.impl.InMemoryCache;
import service.Command;

public class RemoveDirectory implements Command {

    private final static Cache CACHE = InMemoryCache.getInstance();

    @Override
    public void execute(String arg) throws ApplicationException {
        Directory pwd = (Directory) CACHE.get("pwd");
        if (pwd.getChildren().get(arg) != null) {
            pwd.getChildren().remove(arg);
            CACHE.put("pwd", pwd, -1);
            CACHE.put("pwdStr", pwd.getPWD(), -1);
        } else {
            throw new DirectoryNotFoundException();
        }

    }
}
