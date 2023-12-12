
import java.util.Date;

/**
 * Класс Person
 */
public class Person {

    String firstName;
    String secondName;
    String lastName;
    Date birthDay;
    String phoneNumber;
    Character sx = '-';

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
 
    public Character getSx() {
        return sx;
    }
    public void setSx(Character sx) {
        this.sx = sx;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Фамилия: " + lastName + "\n" 
            + "Имя:     " + firstName + "\n"
            + "Отчество: " + lastName + "\n"
            + "Дата рожд.:" + getBirthDay() + "\n"
            + "Номер тел.: " + phoneNumber + "\n"
            + "Пол:     " + sx.toString();
    } 
}