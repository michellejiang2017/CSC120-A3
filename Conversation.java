/**
 * File name: Conversation.java
 * Author Michelle Jiang 
 * Description: Simple chatbot who will mirror inputted messages or give canned responses. Also prints transcript. 
 * Date: 2025-09-23
 */

// Imports for lists, maps, user input, and random number generator used in chatbot
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 
import java.lang.Math; 

/**
 * Conversation class which implements ConversationRequirements interface. 
 * 
 * Creates a simple chatbot which mirrors responses and gives canned responses. Also prints transcript. 
 */
class Conversation implements ConversationRequirements {

  // Attributes 
  int rounds; // counts number of rounds, taken as input
  ArrayList<String> transcript; 
  String[] responses; 
  Map<String, String> mirrorWords;

  /** 
   * Constructor 
   */
  public Conversation() {
    this.responses = new String[] {"Hmm...", "Uh huh...", "Tell me more...", "Mmm-hm.", "Really?", "How interesting!", "That makes sense.", "I hear you.", "I see.", "How intriguing."};
    this.transcript = new ArrayList<String> (); 
    this.mirrorWords = new HashMap<String, String>();
    // Inserts the required mirrored words
    mirrorWords.put("I", "you");
    mirrorWords.put("me", "you");
    mirrorWords.put("am", "are");
    mirrorWords.put("you", "I");
    mirrorWords.put("my", "your");
    mirrorWords.put("your", "my");
    mirrorWords.put("are", "am");
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input = new Scanner(System.in); 
    System.out.println("How many rounds?");
    transcript.add("How many rounds?");

    String inputRounds = input.nextLine(); 
    transcript.add(inputRounds);
    rounds = Integer.parseInt(inputRounds); // fixed for issue where it takes new line as userInput 
    
    System.out.println("Hi there!  What's on your mind?");
    transcript.add("Hi there!  What's on your mind?");
    String userInput; // initializes user input

    while (rounds > 0) {
      // take in input
      userInput = input.nextLine(); 
      transcript.add(userInput);
      System.out.println(respond(userInput)); // read input & print output
      rounds--; // repeat until rounds = 0
    }

    input.close();
    System.out.println("See ya!");
    transcript.add("See ya!");
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    String output = String.join("\n", transcript);
    System.out.println("\nTRANSCRIPT: ");
    System.out.println(output);
}

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    // initialize variables 
    int random = (int)(Math.random() * responses.length);
    boolean replaced = false;
    String returnString = "";

    // converts inputString to ArrayList by splitting through String[]
    String[] strSplit = inputString.split(" ");
    ArrayList<String> inputArray = new ArrayList<String>(Arrays.asList(strSplit));
    for (int i=0;i < inputArray.size();i++) {
      if (mirrorWords.containsKey(inputArray.get(i))) {
        inputArray.set(i, mirrorWords.get(inputArray.get(i)));
        replaced = true;
      }
    }

    if (replaced) {
      // convert inputArray back to a String by joining through String[]
      String[] strArray = inputArray.toArray(new String[0]);
      returnString = String.join(" ", strArray) + "?";
    } else {
      returnString = responses[random]; 
    }
    transcript.add(returnString);
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}
