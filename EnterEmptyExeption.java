public class EnterEmptyExeption extends RuntimeException{
    public EnterEmptyExeption(){
    super("Введено пустое значение. Пожалуйста повторите ввод. " + "\n" +
    "Что бы оставить поле пустым, введите некорректное значение и подтвердите ввод.");
    }
}
