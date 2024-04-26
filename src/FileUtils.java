import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileUtils {
    private static String FILE_NAME = "myfile.txt";

    private FileUtils() {

    }

    public static void createFile() {
        File file = new File(FILE_NAME);

        try {
            if (file.createNewFile()) {
                System.out.println("file has been created");
            } else {
                System.out.println("Error");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeInFile(String text){
        try{

            FileWriter fileWriter = new FileWriter(FILE_NAME);
            fileWriter.write(text);
            fileWriter.close();


        }catch (IOException E){

        }
    }

    public static void readFromFile(){
        File file = new File(FILE_NAME);

        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch (IOException e) {

        }
    }

    private static void deleteFile(){
        File file = new File(FILE_NAME);
        file.delete();
    }
}
