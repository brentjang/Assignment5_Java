
/* CS 1A Lab 4
 * Instructor Solution
 */

import java.util.Scanner;

public class testAssign4
{
   public static void main (String[] args) throws Exception
   {
      Scanner input = new Scanner(System.in);
      String userStr;
      char mainChoiceLetter = 'x',  // logic requires init.
            yesNoChoiceLetter;
      int length, userInt;
      final int QUALIFY = 10,
            MIN_YOG = 1,
            MAX_YOG = 10000;
      int numStamps;

      // initial values
      numStamps = 0;

      // Get menu choices from the user until s/he says quit.
      // (use do/while to force user to enter at least one response)
      do
      {
         System.out.print("\nMenu: " +
               "\n  P (process Purchase)" +
               "\n  S (Shut down) \n\n  Your Choice: ");
         userStr = input.nextLine();

         length = userStr.length();
         if (length < 1)
         {
            System.out.println("\n *** Please enter a valid choice. ***");
            continue;   // covers any reason the string is emptY.
         }
         mainChoiceLetter = Character.toUpperCase(userStr.charAt(0));   // store in letter

         if (mainChoiceLetter == 'S')
         {
            // shutting down -------------------------------------------
            System.out.println("\nSystem shutting down.");
            continue;  // let loop control detect the exit
         }
         else if (mainChoiceLetter != 'P')
         {
            // mainChoiceLetter is not one of the three legal types
            System.out.println("\n *** Use P or S, please. ***");
            continue;  // the main loop 
         }
         
         // falling through means they requested purchase
         if (numStamps >= QUALIFY)
         {
            // award transaction ------------------------
            System.out.println("\nYou qualify for a free yogurt."
                  +" Would you like to use your credits? (Y or N) ");
            userStr = input.nextLine();
            length = userStr.length();

            if (length < 1)
            {
               System.out.println("\n *** Invalid choice. ***");
               continue;
            }
            yesNoChoiceLetter = Character.toUpperCase(userStr.charAt(0));

            if (yesNoChoiceLetter == 'Y')
            {
               // they want a free yog transaction -----
               numStamps -= QUALIFY;
               System.out.println("\nYou have just used " + QUALIFY
                     + " credits and have " + numStamps + " left."
                     +"\nEnjoy your free yogurt.");
               continue;
            }
            else if (yesNoChoiceLetter != 'N')
            {
               // yesNoChoiceLetter is not one of the legal options
               System.out.println("\n *** Invalid response ***");
               continue;
            }
         }
         
         // normal transaction  for any reason --------------------------
         System.out.println("\nHow many yogurts would you like" +
               " to buy ? ");
         userStr = input.nextLine();
         userInt = Integer.parseInt(userStr);
         if (userInt < MIN_YOG || userInt > MAX_YOG)
         {
            System.out.println("\n *** Invalid # yogurts. ***");
            continue;
         }
         numStamps += userInt;
         System.out.println("\n You just earned " + userInt + " stamps"
               + " and have a total of " + numStamps + " to use.");
      }
      while (mainChoiceLetter != 'S');

      input.close();
      System.out.println("\nGood bye.\n");
   }
}
