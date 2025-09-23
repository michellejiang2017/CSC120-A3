/**
 * File name: Conversation.java
 * Author: Michelle Jiang 
 * Description: 
 */
import java.util.Scanner; // imports scanner class
import java.lang.Math; // inport Random class

class Conversation implements ConversationRequirements {

  // Attributes 
  int rounds; // counts number of rounds, taken as input
  String[] transcript; // records transcript of conversation in a list then add everything into the list
  String[] responses; 
  /** 
   * Constructor 
   */
  public Conversation() {
    this.responses = new String[] {"Hmm...", "Uh huh...", "Tell me more...", "Mmm-hm.", "Really?", "How interesting!", "That makes sense.", "I hear you.", "I see.", "How intriguing."};
    this.transcript = new String[] {}; 
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input = new Scanner(System.in); 
    System.out.println("How many rounds?");
    String inputRounds = input.nextLine();
    rounds = Integer.parseInt(inputRounds); 
    System.out.println("Hi there!  What's on your mind?");
    String yap; // initializes user input
    while (rounds > 0) {
      // take in input
      yap = input.nextLine(); // issue: prints out response before taking in input
      System.out.println(respond(yap)); // read input & print output
      rounds--; // repeat until rounds = 0
    }
    input.close();
    System.out.println("See ya!");
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
// create an array as an attribute and add every input and output into the array then print out the entire array here with new lines  
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    /**
     * takes input string convert to array using spaces as the separators then search through each index for the correct word using regex? and replace then output
     * iterate throguh string word by word use mirror dictionary to replace the words  
     * prof recommends looking at the string java doc and using the list of methods (replaceAll using regex) on the inputstring
     * perhaps trim white space? need iterations 
     * take inputstring mark mirror words in a unique way then replace the mirrored words
     */
    int random = (int)(Math.random() * responses.length);
    String returnString = responses[random]; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
    myConversation.respond(""); 

  }
}
