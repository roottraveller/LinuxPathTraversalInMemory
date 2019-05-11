package service.impl;

import exception.ApplicationException;
import repository.Cache;
import repository.impl.InMemoryCache;
import service.Command;

public class PresentWorkingDirectory implements Command {

    private final static Cache CACHE = InMemoryCache.getInstance();

    @Override
    public void execute(String arg) throws ApplicationException {
        String pwdStr = (String) CACHE.get("pwdStr");
        System.out.println("PATH:\t" + pwdStr);
    }

}
