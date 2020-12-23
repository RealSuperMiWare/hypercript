import java.util.Scanner;

public class hypercript{
    
    public static void main(String[] args){
        /* count number of iterations in forloop */
        int count_iteration = 0;

        /** Create a scanner to catch user string input */
        Scanner string_to_encrypt = new Scanner(System.in);

        /*Catch scanner input and convert to string*/
        System.out.println(">>> : ");
        String caughtString = string_to_encrypt.nextLine();

        /** cast string to char array */
        char[] string_to_char = caughtString.toCharArray();

        /** create string to hold encrypted value */
        String encryptedString = "";

        /** loop through array and encrypt values */
        for(char c : string_to_char){
            /*count each iteration*/
            count_iteration++;

            /*each iteration needs to add a value to the ascii unit
            in this case the value is 5*/
            c += 5;

            /*for every 3rd iteration add 3 to the ascii unit
            this will help midigate the spotting of repeat values*/
            if(Character.isUpperCase(c)){
                Character.toLowerCase(c);
                System.out.println("To lower case");
            }
            if(count_iteration%3 == 0){
                c += 2;
            }
            if(count_iteration % 4 == 0){
                c -= 3;
            }
            if(count_iteration % 5 == 0){
                c -= 666;
            }

            encryptedString += c;

            /*lastly print the encrypted text*/
            System.out.print(c);
        }

        count_iteration = 0;

        System.out.println("\nLength Reported : " + string_to_char.length);
        final int mid1 = encryptedString.length() / 2; //get the middle of the String

        if(returnbool(caughtString)){
            String[] parts = {encryptedString.substring(0, mid1), encryptedString.substring(mid1)};
            System.out.println("First seperation : " + parts[1]); //first part
            System.out.println("Second Seperation : " + parts[0]); //second part
            System.out.println(returnbool("String : " + caughtString));

            for(char c : string_to_char){
            }
        }

        string_to_encrypt.close();
    }

    public static boolean returnbool(String string){
        final int mid1 = (string.length() % 2); //get the middle of the String
        if(mid1 == (mid1 % 2)){
            System.out.println("Seperation 1 : Passed");
            return true;
        }else{
            System.out.println("Speration 2 : Failed ");
            return false;
        }
    }
}