package exceptions;

public class WrongPasswordException extends Exception{

    private String password;

    public WrongPasswordException(String message, String password) {
        super(message);
        this.password = password;
    }

    @Override
    public String toString() {
        return "WrongPasswordException{" +
                "password='" + password + '\'' +
                "} " + super.toString();
    }
}
