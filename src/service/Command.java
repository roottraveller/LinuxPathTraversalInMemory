package service;


import exception.ApplicationException;

public interface Command {

    void execute(String arg) throws ApplicationException;
}
