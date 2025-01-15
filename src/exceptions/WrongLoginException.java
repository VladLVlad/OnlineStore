package exceptions;

public class WrongLoginException extends Exception{

    private String login;

    public WrongLoginException(String message, String login) {
        super(message);
        this.login = login;
    }

    @Override
    public String toString() {
        return "WrongLoginException{" +
                "login='" + login + '\'' +
                "} " + super.toString();
    }
}
