import java.util.ArrayList;
import java.util.Scanner; // imports scanner class

class Conversation implements ConversationRequirements {

  // Attributes 
  int rounds; // counts number of rounds, taken as input
  //String transcript; // records transcript of conversation 
  ArrayList<String> responses = new ArrayList<String>();
  /** 
   * Constructor 
   */
  public Conversation(int rounds, ArrayList<String> responses) {
    this.rounds = rounds;
    this.responses = [""];
    //this.transcript = transcript; 
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    System.out.println("Welcome! What's up?");
    String yap = ""; // initializes user input
    Scanner input = new Scanner(System.in); 
    while (rounds > 0) {
      // take in input
      yap = input.nextLine();
      System.out.println(respond(yap)); // read input & print output
      rounds--; // repeat until rounds = 0
    }
    System.out.println("Bye!");
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = "Hmm..."; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation(3);
    myConversation.chat();
    myConversation.printTranscript();
    myConversation.respond(""); 

  }
}
