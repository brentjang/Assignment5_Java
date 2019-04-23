// This class takes the user input of a character and a string
// and produces new strings masking, removing, and counting
// the user character in the user string

import java.util.Scanner;

public class Foothill
{ 
   static Scanner input;
   static char keyCharacter;
   static String theString;
   static final int MIN_LEN = 4;
   static final int MAX_LEN = 500;
   static String special = "$";
   
   public static void main(String[] args)
   {
      input = new Scanner(System.in);
      keyCharacter = getKeyCharacter();
      theString = getString();
      
      System.out.println("String with '" + keyCharacter + "' masked:");
      System.out.println(maskCharacter(theString, keyCharacter) + "\n");
      
      System.out.println("String with '" + keyCharacter + "' removed:");
      System.out.println(removeCharacter(theString, keyCharacter) 
            + "\n");
      
      System.out.println("Number of '" + keyCharacter + "'s");
      System.out.println(countKey(theString, keyCharacter));
   }   
   
   // method gets user input for a key character
   public static char getKeyCharacter()
   {
      // loops until a valid value is entered
      boolean check = false;
      while (!check)
      {
         System.out.println("Enter ONE key character: ");
         String key = input.nextLine();

         // checks if input is valid (one character)
         if (key.length() == 1)
         {
            keyCharacter = key.charAt(0);
            check = true;
         }
         else
         {
            System.out.println("Please enter a valid value." + "\n");
         }
      }
      return keyCharacter;     
   }
   
   // method gets user input for a string
   public static String getString()
   {
      // loops until value is valid
      boolean check = false;
      while(!check)
      {
         System.out.println("Enter a word or phrase (between 4 - 500 "
               + "characters): ");
         String word = input.nextLine();
         
         // checks if between char constraints
         if (word.length() > MIN_LEN && word.length() < MAX_LEN)
         {
            theString = word;
            check = true;
         }
         else
         {
            System.out.println("Please enter a valid value." + "\n");
         }
      }
      return theString;      
   }
   
   // method masks user key char in user string with special value
   public static String maskCharacter(String theString, 
         char keyCharacter)
   {
      // empty string to build new string
      String change = "";
      
      // loops thru every char of the user string
      for (int i = 0; i < theString.length(); i++)
      {
         // checks if char is the same as the key and switches it if so
         if (theString.charAt(i) == keyCharacter)
         {
            change += special;
         }
         else
         {
            change += theString.charAt(i);
         }
      }
      return change;
   }
   
   // method removes user char from user string
   public static String removeCharacter(String theString, 
         char keyCharacter)
   {
      // empty string to build new string
      String change = "";
      
      // loops thru every char of the user string
      for (int i = 0; i < theString.length(); i++)
      {
         // checks if char is the same as the key and removes it if so
         if (theString.charAt(i) == keyCharacter)
         {
            change += "";
         }
         else
         {
            change += theString.charAt(i);
         }
      }
      return change;
   }
   
   // method counts number of key char in user string
   public static int countKey(String theString, char keyCharacter)
   {
      // local count of key char
      int count = 0;
      
      // loops thru every char of the user string
      for (int i = 0; i < theString.length(); i++)
      {
         // checks if char is the same as the key and counts it if so
         if (theString.charAt(i) == keyCharacter)
         {
            count += 1;
         }
         else
         {
            count += 0;
         }
      }
      return count;
   }
}
/*
\\\\\\\\\\\\\\\\\\\\\\\\\\ RUN 1 ///////////////////////////////
Enter ONE key character: 
12
Please enter a valid value.

Enter ONE key character: 
AB
Please enter a valid value.

Enter ONE key character: 
B
Enter a word or phrase (between 4 - 500 characters): 
hi
Please enter a valid value.

Enter a word or phrase (between 4 - 500 characters): 
Reading this book was an incredible insight into a very fascinating part 
of making a movie, the development process. As viewers, we oftentimes 
overlook the process that a screenplay goes through to 
become a final product. There are so many changes made in every aspect 
that it is very interesting to see the final product. In the case with 
Groundhog Day it was very interesting to read the draft of the script. 
It was already a phenomenal script off the first draft so it was 
insightful to see how this script was broken down and developed into a 
better version. One thing that I really enjoyed while reading this were 
the footnotes. It was exciting to see how much thought and detail goes 
into a script beyond the actual words, and how some scenes have more 
meaning than a viewer will normally pick up on. It was also nice to see 
that Rubin remained to have a creative voice beyond his initial draft 
and upon selling it to Columbia. I think that this is
Please enter a valid value.

Enter a word or phrase (between 4 - 500 characters): 
BIG boy has a Big house But look at his blue CAR and Blue Shoes
String with 'B' masked:
$IG boy has a $ig house $ut look at his blue CAR and $lue Shoes

String with 'B' removed:
IG boy has a ig house ut look at his blue CAR and lue Shoes

Number of 'B's
4

\\\\\\\\\\\\\\\\\\\\\\\\\\ RUN 2 ///////////////////////////////

Enter ONE key character: 
%
Enter a word or phrase (between 4 - 500 characters): 
how much % alcohol is in the 80 proof, about 40%
String with '%' masked:
how much $ alcohol is in the 80 proof, about 40$

String with '%' removed:
how much  alcohol is in the 80 proof, about 40

Number of '%'s
2

\\\\\\\\\\\\\\\\\\\\\\\\\\ RUN 3 ///////////////////////////////

Enter ONE key character: 
e
Enter a word or phrase (between 4 - 500 characters): 
e
Please enter a valid value.

Enter a word or phrase (between 4 - 500 characters): 
The amount of time spent during computer science homework is excessive 
String with 'e' masked:
Th$ amount of tim$ sp$nt during comput$r sci$nc$ hom$work is $xc$ssiv$ 

String with 'e' removed:
Th amount of tim spnt during computr scinc homwork is xcssiv 

Number of 'e's
10

\\\\\\\\\\\\\\\\\\\\\\\\\\ RUN 4 ///////////////////////////////

Enter ONE key character: 
no
Please enter a valid value.

Enter ONE key character: 
o
Enter a word or phrase (between 4 - 500 characters): 
THERE ARE MANY WORDS THAT I CAN WRITE but one 
String with 'o' masked:
THERE ARE MANY WORDS THAT I CAN WRITE but $ne 

String with 'o' removed:
THERE ARE MANY WORDS THAT I CAN WRITE but ne 

Number of 'o's
1

*/