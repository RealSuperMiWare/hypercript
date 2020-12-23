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

            if(Character.isUpperCase(c)){
                Character.toLowerCase(c);
                System.out.println("To lower case");
            }

            /**Every 3rd iteration, add 3 to the ascii unit*/
            if(count_iteration%3 == 0){
                c += 2;
            }

            /**Every 4th iteration, subtract 3 from the ascii unit*/
            if(count_iteration % 4 == 0){
                c -= 3;
            }
            
            /**Every 5th iteration, subtract -666 from the ascii unit*/
            if(count_iteration % 5 == 0){
                c -= 666;
            }

            encryptedString += c;

            /*lastly print the encrypted text*/
            System.out.print(c);
        }

        /*Now that the first encryption is done*/
        /*restart loop count*/
        count_iteration = 0;

        System.out.println("\nLength Reported : " + string_to_char.length);
        final int mid1 = encryptedString.length() / 2; //get the middle of the String

        /** call returnbool to check condition if true carry out code. it will always be true because the data
         * will always be split in half and the 2 seperations will be set : the second half will become the first, 
         * and the first half will become the second half. 
         */
        if(returnbool(caughtString)){
            String[] parts = {encryptedString.substring(0, mid1), encryptedString.substring(mid1)};
            System.out.println("First seperation : " + parts[1]); //first part
            System.out.println("Second Seperation : " + parts[0]); //second part
            System.out.println(returnbool("String : " + caughtString));

            /** this loop will encrypt the new seperate sections of the data, possibly adding new bits
             * and seperating them again
             */
            for(char c : string_to_char){
            }
        }

        /*Stop any data leak and close the scanner to preserve memeory*/
        string_to_encrypt.close();
    }

    /** This boolean will report if a seperation was passed or failed
     * FUN FACT - it highly unlikley to fail thus far.
     */
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