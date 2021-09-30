/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie {
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response = "";
        if (findWord(statement,"no") >= 0) {
            response = "Why so negative?";
        } else if (findWord(statement,"mother") >= 0
                || findWord(statement,"father") >= 0
                || findWord(statement,"sister") >= 0
                || findWord(statement, "brother") >= 0) {
            response = "Tell me more about your family.";
        } else if (findWord(statement,"dog") >= 0 || findWord(statement,"cat")>= 0) {
            response = "Tell me more about your pets.";
        } else if (findWord(statement, "Mr.") >= 0 || findWord(statement,"Mrs.") >= 0) {
            response = "They sound like a great teacher.";
        } else if (statement.trim().length() == 0) {
            response = "Say something please.";
        } else if (findWord(statement,"Giraffe") >= 0) {
            response = "You have a giraffe? That's cool.";
        } else if (findWord(statement,"Fantasy") >= 0) {
            response = "You play fantasy football too? I hope you did not draft David Montgomery";
        } else if (findWord(statement,"Athenian") >= 0) {
            response = "You go to Athenian as well?";
        } else if(statement.indexOf("I want")>= 0) {
            transformIWantStatement(statement);
        }
         else {
            response = getRandomResponse();
        }

        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    public String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        } else if (whichResponse == 4) {
            response = "I play Fortnite";
        } else if (whichResponse == 5) {
            response = "You play Fortnite?";
        }

        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        String x = str.toLowerCase();
        if (x.indexOf(word + " ")>= 0||x.indexOf(" "+word)>= 0|| x.indexOf(" "+word+" ")>= 0){
            return x.indexOf(word);
        }
        else {
            return -1;
        }

    }


    


    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        String final_final = " ";
        if (statement.indexOf("I want")>= 0){
            int x = statement.indexOf("I want") + 6;
            String temp = statement.substring(x);
            String final_string = temp.trim();
            final_final = ("Would you really be happy if you had "+final_string +"?");
        }
        System.out.println(final_final);
        return final_final;



    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        //your code here
        return "";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        // your code here
        return "";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        // your code here
        return "";
    }
}
