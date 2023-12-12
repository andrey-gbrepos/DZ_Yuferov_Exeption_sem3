
/**
 * Модуль управления
 */
public class Controller {
    private Model model;
    private View view;
    private Person person;
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        person = new Person();
    }   
    /**
     * Заполняет объект Person по пунктам
     */
    public void fillingData(){
        int code = -1;
        System.out.println("Программа сохраняет в файл персональные данные. Файлу присваивается название по фамилии.");
        System.out.println();
        while (code == -1) code = view.invitetoEnterGender(person);
        code = -1;
          while (code == -1) code = view.invitetoEnterFio(person);
        code = -1;
        while (code == -1)code = view.invitetoEnterDate(person);
         code = -1;    
        while (code == -1) code = view.invitetoEnterPhone(person);
        System.out.println("Введены следующие данные: ");
        System.out.println(person);
        int choice =0;
        do{
        System.out.println("Выберите действие:");
        
        System.out.println("1. Записать в файл   2. Выйти");
    
        choice = Integer.parseInt(view.getUserInput("Введите номер операции: "));
        
        switch (choice) {
            case 1:
                model.writeTofile(person.toString(), person.getLastName());
                System.out.println("Данные сохранены в файле " + person.getLastName()+".txt");
                break;
           
            case 2:
               
                break;
            default:
                System.out.println("Попробуйте еще раз");
                break;
        }
    }while (choice != 2);
        System.out.println();
    }
    /**
     * Запуск программы
     */
    public void runPersonWriter() {

        int choice;
        do {
        fillingData();
        System.out.println("Что дальше?");
        System.out.println("1. Продолжить     2. Выйти из программы");
        choice = Integer.parseInt(view.getUserInput("Введите номер операции: "));
        switch (choice) {
        case 1:
        
        break;
        case 2:
         System.out.println("Программа завершена.");
        break;
        
        default:
        System.out.println("Неверный выбор. Попробуйте еще раз.");
        }
        } while (choice != 2);
        }
}
