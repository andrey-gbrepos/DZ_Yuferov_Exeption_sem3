import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;


public class Model {
    

/**
 * Для работы с файлом
 */
 String line;
 File nameFile;
 Path filePath;
 BufferedReader reader;
 FileWriter writer;

/**
 * Записывает строку в файл
 * @param result
 */
 public void writeTofile(String result, String lastName){
   nameFile = new File(lastName+".txt");
   try {
    if (nameFile.createNewFile() ) {
        writer = new FileWriter(nameFile, true);
        writer.append("\n"+result);
        writer.flush();
    }
    else {
        writer = new FileWriter(nameFile, true);
        writer.append("\n"+result);
        writer.flush();
    }
} catch (Exception e) {
 //e.printStackTrace();
} finally {
 System.out.println(line);
    }
}



}

