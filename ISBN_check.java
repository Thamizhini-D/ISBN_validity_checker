import java.util.Scanner;


public class ISBN_s28281 {
    public static void main(String[] args) {
        char[][] isbns = {
                {'9', '6', '0', '-', '4', '2', '5', '-', '0', '5', '9', '-', '0'},
                {'8', '0', '-', '9', '0', '2', '7', '4', '4', '-', '1', '-', '6'},
                {'0', '-', '8', '0', '4', '4', '-', '2', '9', '5', '8', '-', 'X'},
                {'0', '-', '9', '4', '3', '3', '9', '6', '-', '0', '4', '-', '2'},
                {'0', '-', '9', '7', '5', '2', '2', '9', '8', '-', '0', '-', '5'},
                {'9', '9', '7', '1', '-', '5', '-', '0', '2', 'l', '0', '-', '0'},
                {'9', '3', '-', '8', '6', '5', '4', '-', '-', '2', '1', '-', '4'},
                {'9', '9', '9', '2', '1', '-', '5', '8', '8', '-', '1', '0', '7'}
        };

        /*
        Scanner scan = new Scanner(System.in);
        char[] user_array = new char[13];
        for(int m = 0; m < 13; m++){
            char user_input = scan.next().charAt(0);
            user_array[m] = user_input;
        }
        checkISBN(user_array);
        */


        for (int i = 0; i < isbns.length; ++i)
            checkISBN(isbns[i]);


    }

    static void checkISBN(char[] isbn) {
        int int_equiv = 0;
        int summing = 0;
        int count = 0;
        int rest;

        //i loop runs until the end of the given 1D char array evaluating each element
        //j variable is for weight assigned to each 10 values; j decreases from 10 to 1, left to right
        for (int i = 0, j = 10; i < isbn.length; i++) {

            //10 needs to be evaluated separately because X is mentioned in its place
            if (isbn[i] == 'X') {
                int_equiv = 10;

                //dash needs to simply ignored; hence, when dash is encountered, "continue" to simply skip to the next iteration
            } else if (isbn[i] == '-') {
                continue;
            } else {

                //converting char number to int number involves subtracting them by CHAR 0 (ASCII rules)
                int_equiv = isbn[i] - '0';

                //converted int number has to be checked if its between given range, since value out of it is considered invalid character
                if (!(int_equiv >= 0 && int_equiv <= 9)) {
                    printArr(isbn);
                    System.out.print(" : ERROR. Invalid character " + isbn[i]);
                    System.out.println();
                    //once AN invalid character is encountered, entire ISBN is valid and need not be assessed at all, hence the break
                    break;
                }
            }
            /*

            1. summing up according to "ISBN rule of weights" is done only when int_equiv has gone through all evaluations

            2. also, note j-- is in this block and not mentioned in initial conditions in i-main loop. It's because
            j stands for the weights assigned for each "number" value. If j-- is mentioned in initial "for loop", then it will be reduced
            even if the value it encountered would be a "-". Remember that j should decrease only after encountering a number, a VALID number!
            not a dash or invalid character

            3.note how summing up and j-- is done in a separate BLOCK.
            this separate BLOCK is built so that the count statement is executed, which basically counts the
            number of valid numbers (which has to be 10) for a correct ISBN.

            It is assumed that int_equiv, having gone through validity checks
            and multiplied with its weight j means it's a valid number.

            Because, this block will be executed ONLY if a valid number is outputted from the previous code, so it makes sense
            to count the number of times this BLOCK is executed to know how many VALID characters are in the array.

            Knowing this count will help assess whether too few/many valid characters are given in an ISBN

             */
            {
                summing += j * int_equiv;
                j--;
                count++;

            }

        }

        /*
        once the loop has finished i.e. all elements of an array has gone through validity check (broken when necessary),
        summed up, and valid numbers are counted. We check if the correct number of ISBN have been given
         */
        if (count > 10) {
            printArr(isbn);
            System.out.println(" : ERROR. Too many digits");
            System.out.println();

        /*
        note that second condition of "(int_equiv >= 0 && int_equiv <=9)" is mentioned here because loops "BREAK"ing out
        when faced with an invalid character ends up printing "too few digits" along with it. Mentioning this condition means
        arrays that broke due to invalid characters will not enter this condition,
        ONLY those with VALID characters but has few digits will enter this condition
             */
        } else if (count < 10 && (int_equiv >= 0 && int_equiv <= 9)) {
            printArr(isbn);
            System.out.print(" : ERROR. Too few digits");
            System.out.println();

            //if 10 valid numbers have been given, we move on to the next step of checking its divisibility by 11.
        } else if (count == 10) {
            if (summing % 11 == 0) {
                printArr(isbn);
                System.out.print(" : OK");

                System.out.println();

                //if divisibility check by 11 fails, subtract the last value (since it is the check digit) from the total sum and store it in rest
                //as usual, remember about the exceptional value 10
            } else {
                if ((isbn[isbn.length - 1] == 'X')) {
                    rest = summing - 10;
                } else {
                    rest = summing - (isbn[isbn.length - 1] - '0');
                }

                //check digit's range is 0-10. So, a new loop is created which adds each value to the rest variable and checks divisibility by 11
                //if divisibility check passes, then the appropriate last digit is printed. In case of the exception 10, X is printed.
                for (int m = 0; m <= 10; m++) {
                    if ((rest + m) % 11 == 0) {
                        if (m == 10) {
                            printArr(isbn);
                            System.out.print(" : ERROR. Last digit should be X");
                            System.out.println();

                        } else {
                            printArr(isbn);
                            System.out.print(" : ERROR. Last digit should be " + m);
                            System.out.println();

                        }
                    }
                }

            }
        }


    }

    static void printArr(char[] arr) {
        for (char c : arr) {
            System.out.print(c);
        }
    }

}

