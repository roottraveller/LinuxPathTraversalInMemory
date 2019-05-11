import exception.ApplicationException;
import exception.InvalidInputException;
import repository.Cache;
import repository.impl.InMemoryCache;
import service.CommandsEnum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private final static Cache CACHE = InMemoryCache.getInstance();

    public static void main(String[] args) throws IOException {
        CommandsEnum.SESSION.command.execute("clear");
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                String pwdStr = (String) CACHE.get("pwdStr");
                System.out.print(pwdStr+"$ ");
                String[] inputArgs = in.readLine().split(" ");

                try {
                    if(inputArgs.length==0) {
                        throw new InvalidInputException();
                    }
                    CommandsEnum commandsEnum = CommandsEnum.fromName(inputArgs[0].trim());
                    if(null == commandsEnum) {
                        throw new InvalidInputException();
                    }
                    else {
                        if(inputArgs.length<2) {
                            commandsEnum.command.execute(null);
                        }
                        else {
                            commandsEnum.command.execute(inputArgs[1].trim());
                        }
                    }
                } catch (ApplicationException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
