
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class View {

Scanner scanner; 
 /**
  * Метод для ввода номера телефона состоящего 
  * из цифр, длиной не более 11 цифр.
  * @param person
  * @return
  */
public Integer invitetoEnterPhone(Person person){
    Integer erCode = -1;
    System.out.println();
    String phoneNumber = getUserInput("Введите номер телефона (не более 11 цифр): ");
    try{
        if(phoneNumber == "") throw new EnterEmptyExeption();
    }catch (EnterEmptyExeption e){
        System.out.println(e.getMessage());
        return erCode;
    }
    try {
        Double.parseDouble(phoneNumber); // Проверка на цифры
        person.setPhoneNumber(phoneNumber);
        if(phoneNumber.length() > 11) throw new EnterPhoneExeption();
    } catch (NumberFormatException e) {
        // TODO: handle exception
       System.out.println("Номер содержит строковые символы. В случае подтверждения будет сохранено пустое поле.");
        person.setPhoneNumber(null);
    }catch (EnterPhoneExeption e){
        System.out.println(e.getMessage());
        return erCode;
    }
        System.out.println("телефон: " + person.getPhoneNumber());
    int code = 0;
    while (code == 0){
    code = unCorrectEntering();  
    }
    if(code == 1) erCode = 1;
    return erCode;
    }

/**
 * Метод для ввода гендерного пола. Принимает два значения f - жен. m - муж.
 * В противном случае сохраняет "-".
 * @param person
 * @return
 */
public Integer invitetoEnterGender(Person person) { 
    Integer erCode = -1;
    System.out.println();
    String sx = getUserInput("Введите пол f - жен. m - муж.: ");
    try{
        if(sx.equals("")) throw new EnterEmptyExeption();
    }catch (EnterEmptyExeption e){
        System.err.println(e.getMessage());
        return erCode;
    }
    try{
       if(sx.equals("m")|| sx.equals("f")) {
        System.out.println("пол: " + sx);person.setSx(sx.charAt(0));
    }else{
           throw new EnterGenderExeption();  
    }
    }catch (EnterGenderExeption e){
        System.out.println(e.getMessage());
    }
    int code = unCorrectEntering(); 
    if(code == 1) erCode = 1;
    return erCode;
}
/**
 * Метод определяет, состоит ли строка только из строковых символов.
 * Если да - возвращает true, иначе - false.
 * @param name
 * @return
 */
public boolean checkSimbolInName(String name){
    name = name.replaceAll("\\s", "");
    for (int i = 0; i < name.length(); i++) {
        if (!Character.isLetter(name.charAt(i)))  return false;
    } 
    return true;
    }

/*
 * Метод для ввода данных фамилии имени и отчества.
 */
public Integer invitetoEnterFio(Person person) { 
    Integer erCode = -1;
    System.out.println();
    String fullName = getUserInput("Введите фамилию, имя и отчество через пробел (на латинице)"+"\n"+ " и нажмите ENTER: ");
    
    String[] lstdata = fullName.split("\\s");
    try{
        if(lstdata[0] == "") throw new EnterEmptyExeption();
    }catch (EnterEmptyExeption e){
        System.out.println(e.getMessage());
        return erCode;
    }
    try{                            //Получение данных из строки
    person.setLastName(lstdata[0]);
    person.setFirstName(lstdata[1]);
    person.setLastName(lstdata[2]);
    }catch (EnterEmptyExeption e){
        System.out.println(e.getMessage());
        return erCode;
    }catch (ArrayIndexOutOfBoundsException e){
       System.out.println("Введены не полные данные.");
        }
        try{
        if( !checkSimbolInName(fullName)) throw new EnterFioExeption();
        if(lstdata.length == 1) person.setLastName(lstdata[0]);
        else {
            person.setLastName(lstdata[0]);
            person.setFirstName(lstdata[1]);      
        }
    }catch (EnterFioExeption e){
        System.out.println(e.getMessage());
        person.setLastName(null);   //Запись данных в обЪект person
        person.setFirstName(null);
        person.setSecondName(null);
    }
        System.out.println("Введено имя: "+ person.getLastName() + " "
                                        + person.getFirstName() + " "
                                        + person.getSecondName());
         int code = 0;
    while (code == 0){
    code = unCorrectEntering();  
    }
    if(code == 1) erCode = 1;
    return erCode;
    }
    
/*
 * Метод для ввода даты в формате dd/MM/yyyy.
 */
public Integer invitetoEnterDate(Person person)  {
    Integer erCode = -1;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println();
    String dat = getUserInput("Введите дату рождения в формате dd/mm/yyyy: ");
    try{
        if(dat == "") throw new EnterEmptyExeption();
    }catch (EnterEmptyExeption e){
        System.out.println(e.getMessage());
        return erCode;
    }
   Date parsingDate;
      try {
         parsingDate = date.parse(dat);
      }catch (ParseException e) {
        System.out.println("Введеное значение не соответствует формату даты."+"\n" +
                            "В случае подтверждения поле останется пустым.");
         parsingDate = null; 
      }
      if(parsingDate != null){
      try{
        String[] dateTointeger = dat.split("/");
        if(Integer.parseInt(dateTointeger[2]) > 2023  || Integer.parseInt(dateTointeger[2])<1923)
        throw new EnterDateExeption(dat);
      }catch (EnterDateExeption e){
        System.out.println(e.getMessage());
        parsingDate = null;
      }
    }
      person.setBirthDay(parsingDate);
      System.out.println("Дата рождения: "+ person.getBirthDay());
    int code = 0;
    while (code == 0){
    code = unCorrectEntering();  
    }
    if(code == 1) erCode = 1;
    return erCode;
}



public Integer unCorrectEntering (){
    
    System.out.println("1. Подтвердить   2. Скорректировать");
    switch (getUserInput("Ваш выбор?: ")) {
        case "1":
            return 1;
        case "2":
            return 2;
        default:
            System.out.println("Введено некорректное значние.");
            return 0;     
    }

}
/**
 * Получает введенные данные с консоли
 * @param prompt
 * @return
 */   
public String getUserInput(String prompt) {
System.out.print(prompt);
String tmpVal="";
scanner = new Scanner(System.in);
try {   
     tmpVal = scanner.nextLine(); 
     return tmpVal;
}catch (Exception e) {
     System.out.println("Введено не корректное значение. Пожалуйста повторите выбор");
     return tmpVal;
 }  

}

}