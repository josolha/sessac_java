package example0807.kiosk;

public class CustomException extends Exception{
    public int code;

    public CustomException(String message, int code){
        super(message);
        this.code = code;
    }
}
