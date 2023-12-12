public class EnterFioExeption extends RuntimeException {
    public EnterFioExeption (){
        super("В имени присутствуют не строковые символы. В случае подтверждения поле имени останется пустым.");
    }
}
