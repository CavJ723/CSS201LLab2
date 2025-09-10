import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        //define variables

        System.out.println("Choose an option (a, b, or c): ");
        char choice = displayMenu(new Scanner(System.in));
        choice = Character.toLowerCase(choice);
        
       if (choice == 'a') {
    System.out.println("You selected option a.");

} else if (choice == 'b') {
    System.out.println("You selected option b.");

} else if (choice == 'c') {
    System.out.println("You selected option c.");

} else {
    System.out.println("Please choose a valid option.");
}

 
        //scanner is defined for you
        Scanner scanner = new Scanner(System.in);
 
        //get the value of choice from displayMenu(scanner)
        choice = displayMenu(scanner);
        choice = Character.toLowerCase(choice);
 
        
        //as long as user wants to continue
        while (choice != 'c') {
            switch (choice) {
                //case a: convert from binary to decimal
                case 'a':
                    if (binToDec(scanner) == -1)
                        System.out.println("Invalid binary number.");
                    break;

                //case b: convert from decimal to binary 
                case 'b':
                    if (decToBin(scanner) == -1)
                        System.out.println("Invalid decimal number.");
                    break;

                //case c: exit program
                case 'c':
                    System.out.println("Exiting program.");
                    break;
            }
            // add another call to displayMenu
            choice = displayMenu(scanner);
            choice = Character.toLowerCase(choice);
        }  

        scanner.close();
    }

    //PRE: accepts scanner object
    //POST: returns a valid value of a,b or c to main
    public static char displayMenu(Scanner scanner) {
        char choice = 'n';

        //while loop that repeats if the choice made is not a, b, or c
        while (choice != 'a' && choice != 'b' && choice != 'c'){
            //display menu choices
            System.out.println("Menu:");
            System.out.println("a) Convert binary to decimal");
            System.out.println("b) Convert decimal to binary");
            System.out.println("c) Exit");

            //prompt user to enter choice


            //this code has been provided since scanner input is new...
            String input = scanner.nextLine().trim().toLowerCase();
            choice = input.charAt(0);
        } 

        return choice;
    }

    //PRE: accepts scanner object
    //POST: prompts user to enter a binary number
    //      will calculate & print binary value entered & decimal equivalent
    public static int binToDec(Scanner scanner) {

        //define variables used
        int decimal = 0;
        int pow = 1;

        //prompt user to enter a binary number
        System.out.println("Enter a binary number: ");

        //use the following to get scanner input
        String binary = scanner.nextLine().trim();


        //for each 'i' character position in binary
        //  starting at binary.length -1 (going to 0)
        //      if charAt is '1': decimal += pow
        //      else if charAt is not '0': return -1
        for (int i = binary.length() - 1; i >= 0; i--) {
            char c = binary.charAt(i);
            if (c == '1') {
                decimal += pow;
            } else if (c != '0') {
                return -1;
            }
            pow *= 2;
        }

        //display Binary input and Decimal output
        System.out.println("Binary: " + binary);
        System.out.println("Decimal: " + decimal);

        return 1;
        //      pow *= 2


    }

    //PRE: accepts an input string
    //POST: returns true if the string has only 0-9, else false 
    public static boolean isDigits(String str) {
        //loop str
        //  use Character.isDigit function to check each character for valid numeric value
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int decToBin(Scanner scanner) {

        //prompt user to enter a decimal number
        System.out.println("Enter a decimal number: ");


        //get scanner input (similar to above)
        String input = scanner.nextLine().trim();

        if (!isDigits(input)) {
            System.out.println("Invalid decimal number.");
            return -1;
        }
        //this line converts the input string to an integer
        int decimal = Integer.parseInt(input);
 
        //define other variables needed for conversion including output string for Binary value
        String binary = new String();

        while (decimal !=0){
            binary = (decimal % 2) + binary;
            decimal = decimal / 2;
        
            //get remainder of modulus 2 & add to binary string
            //update decimal to cut off last digit
        }

        
        System.out.println("Decimal: " + input);
        System.out.println("Binary: " + binary.toString());
        return 1;
    }
}
