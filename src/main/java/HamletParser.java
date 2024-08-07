import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public static void writeFile(String s){
        try {
            FileWriter fileWriter = new FileWriter("newHamlet.txt");
            fileWriter.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String replaceHamlet(String text){
        Pattern p = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        String newText = m.replaceAll("Leon");
        return newText;
    }

    public static String replaceHoratio(String text){
        Pattern p = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        String newText = m.replaceAll("Tariq");
        return newText;
    }

    public static void main(String[] args) {
        HamletParser hamletParser = new HamletParser();
        String hamletText = hamletParser.getHamletData();
        String hamletReplaced = replaceHamlet(hamletText);
        String horatioReplaced = replaceHoratio(hamletReplaced);
        writeFile(horatioReplaced);
    }
}
