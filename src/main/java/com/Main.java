import java.io.*;
import java.net.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("All converted values are in USD. Press any key to start");
        String amount = "";
        int converted = 0;
        String currency= "";
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a value");
            amount = scanner.nextLine();
            
            if (amount.equals("exit")){
                scanner.close();  
                break;
            }
            else{
                try {
                    converted = Integer.parseInt(amount);
                }
                catch (NumberFormatException e){
                    System.out.println("Not a number");
                }
            }
            System.out.println("Please enter currency");
            Scanner scanner1 = new Scanner(System.in);
            try{
                currency = scanner1.nextLine();
            }
            catch (Exception e){
                System.out.println("Could not interpret currency:" + e.getMessage());
            }
            URL url = new URL("http://finance.yahoo.com/d/quotes.csv?f=l1&s="+ currency + "USD=X");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = reader.readLine();
            try {
                System.out.println(Double.parseDouble(line) * converted);
            }
            catch (Exception e){
                System.out.println("Some issue with conversion, please try again");
            }
            reader.close();
        }
        
    }
   
}