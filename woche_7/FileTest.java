package woche_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class FileTest {
    public static void main(String[] args) {
        File lel = new File("test.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(lel))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

}