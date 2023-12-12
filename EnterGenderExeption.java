public class EnterGenderExeption extends RuntimeException{
    public EnterGenderExeption(){
        super("Не корректное значение. В случае подтверждения поле останется пустым.");
}
}
