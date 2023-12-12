

public class EnterPhoneExeption  extends RuntimeException {
    public EnterPhoneExeption(){
            super("Номер телефона должен состоять не более чем из 11 цифр " + "\n" +
            "и не должен содержать строковых символов.");
    }
}
