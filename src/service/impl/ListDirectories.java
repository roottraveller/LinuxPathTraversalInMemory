package service.impl;

import exception.ApplicationException;
import model.Directory;
import repository.Cache;
import repository.impl.InMemoryCache;
import service.Command;

public class ListDirectories implements Command {

    private final static Cache CACHE = InMemoryCache.getInstance();


    @Override
    public void execute(String arg) throws ApplicationException {
        Directory pwd = (Directory) CACHE.get("pwd");
        System.out.println("DIRS:\t"+pwd.listChildDirNames());
    }
}
