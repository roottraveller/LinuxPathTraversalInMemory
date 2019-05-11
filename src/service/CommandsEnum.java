package service;

import service.impl.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandsEnum {
    LS("ls", new ListDirectories()),
    MKDIR("mkdir", new MakeDirectory()),
    CD("cd", new ChangeDirectory()),
    PWD("pwd", new PresentWorkingDirectory()),
    RM("rm", new RemoveDirectory()),
    SESSION("session", new Session());

    public String name;
    public Command command;

    CommandsEnum(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    private static final Map<String,CommandsEnum> ENUM_MAP;
    static {
        Map<String,CommandsEnum> map = new ConcurrentHashMap<String, CommandsEnum>();
        for (CommandsEnum instance : CommandsEnum.values()) {
            map.put(instance.name,instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }
    public static CommandsEnum fromName(String name){
        return ENUM_MAP.get(name);
    }

}
