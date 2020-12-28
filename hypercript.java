import java.util.Scanner;

public class hypercript{
    
    public static void main(String[] args){
        /**I will create 3 scanners that, for now, will be a test to take the user 
         * dictated encryption passes
         * 
         * 
         * This code will be implemented on the next update
        */

        /**The 3 int init below will allow the user to dictate their
         * needs for the encrypt method
         * These static values will be changed to allow input by the user
        */
        int pass1 = 2;
        int pass2 = 3;
        int pass3 = 666;
        encrypt(pass1, pass2, pass3);
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

    private static void encrypt (int pass1, int pass2, int pass3){
                /* count number of iterations in forloop */
                int count_iteration = 0;

                /** Create a scanner to catch user string input */
                Scanner string_to_encrypt = new Scanner(System.in);
        
                /*Catch scanner input and convert to string*/
                System.out.println(">>> Data to ecnrypt : ");
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
        
                    /**Every 3rd iteration, add 3 to the ascii unit*/
                    if(count_iteration%3 == 0){
                        c += pass1;
                    }
        
                    /**Every 4th iteration, subtract 3 from the ascii unit*/
                    if(count_iteration % 4 == 0){
                        c -= pass2;
                    }
                    
                    /**Every 5th iteration, subtract -666 from the ascii unit*/
                    if(count_iteration % 5 == 0){
                        c -= pass3;
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
                        /*This may not yet need to be used... I'll keep it on the back burner because I may not use it*/
                    }
                }
        
                /*Stop any data leak and close the scanner to preserve memory*/
                string_to_encrypt.close();
    }
}