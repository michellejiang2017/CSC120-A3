import java.util.Scanner; // imports scanner class

class Conversation implements ConversationRequirements {

  // Attributes 
  int rounds; // counts number of rounds, taken as input
  //String transcript; // records transcript of conversation 
  String[] responses; 
  /** 
   * Constructor 
   */
  public Conversation() {
    this.rounds = rounds;
    this.responses = new String[] {"Hmm...", "Uh huh...", "Tell me more...", "Mmm-hm.", "Really?", "How interesting!", "That's cool!", "Wow!", "Nice."};
    //this.transcript = transcript; 
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input = new Scanner(System.in); 
    System.out.println("How many rounds?");
    rounds = input.nextInt();
    System.out.println("Hi there!  What's on your mind?");
    String yap; // initializes user input
    while (rounds > 0) {
      // take in input
      yap = input.nextLine(); // issue: prints out response before taking in input...
      System.out.println(respond(yap)); // read input & print output
      rounds--; // repeat until rounds = 0
    }
    System.out.println("See ya!");
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

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
    myConversation.respond(""); 

  }
}
