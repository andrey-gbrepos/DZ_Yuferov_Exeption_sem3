import java.time.DateTimeException;

public class EnterDateExeption extends DateTimeException{
   public EnterDateExeption(String dat){
     super("Введенное значение " + dat + "Дата рождения должна быть в пределах 100 лет" + "\n" 
     + "В случае подтверждения поле останется пустым");
   }
}
