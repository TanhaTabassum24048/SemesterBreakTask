import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ContactReader {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the contacts file: ");
        String fileName = sc.nextLine();

        int count = 0; 

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts.length == 2) {
                    String name = parts[0];
                    String phone = parts[1];
                    System.out.println("Contact: " + name + " | Phone: " + phone);

                    count++;
                }
            }
            br.close();
            System.out.println("\nTotal Contacts: " + count);

        } catch (Exception e) {
            System.out.println("Error reading file! Check file name.");
        }

        sc.close();
    }
}