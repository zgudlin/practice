/**********************************************************
 * Program Name   : Player
 * Author         : Zak Gudlin
 * Date           : 5/5/16
 * Course/Section : CSC 111 - 001
 * Program Description:  This class will keep track of a single baseball
 *    player�s statistics. The driver class will enter the player�s name
 *	  and the team class will add them to the team (an array). All of the
 *	  player's stats will be formatted for the user to call upon to display
 *	  from the driver class at their desired time.
 *
 * Methods:
 * -------
 * Constructor - initializes the class variables
 * Update Stats - updates a player's number of hits and at bats
 * Display Player - formats a player's name with an index number for user selection
 * Calculate Batting Average - calculate's a player's batting average
 * To String - formats a player's name, hits, at bats, and batting average on one line
 **********************************************************/
package teamdriver;
import java.text.DecimalFormat;

public class Player
{
	//Class constants

	//Class variables
	private  String firstName;  //Class variable for player's first name
	private  String lastName;   //Class variable for player's last name
	private int hitsTotal;      //Class variable for # of hits
	private int atBatsTotal;    //Class variable for # of at bats
        private float batAvg;       //Class variable for player's batting average

    /**********************************************************
    * Method Name    : Constructor
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Method Description: This constructor method will initialize
    *    the class data.
    *
    * BEGIN Constructor (String inFirst, String inLast)
    *    Initialize inFirst to = firstName (class variable)
    *	 Initialize inLast to = lastName (class variable)
    *    Initialize hitsTotal class variable to = 0
    *    Initialize atBatsTotal class variable to = 0
    *    Initialize batAvg class variable to = 0
    * END Constructor
    **********************************************************/

    public Player (String inFirst, String inLast)
    {
		//Local constants

		//Local variables

        /********************Start Constructor Method*********************/

	    //Initialize inFirst to = firstName (class variable)
        firstName = inFirst;

		//Initialize inLast to = lastName (class variable)
        lastName = inLast;

        //Initialize hitsTotal class variable to = 0
        hitsTotal = 0;

		//Initialize atBatsTotal class variable to = 0
		atBatsTotal = 0;

		//Initialize batAvg class variable to = 0
	    batAvg = 0.0f;

	} //END Constructor Method

    /**********************************************************
    * Method Name    : Update Stats
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Method Description:  This method will receive a baseball player's
    *    number of hits and at bats and will add each of them
    *    to a respective total.
    *
    * BEGIN Update Stats (int hits, int bats)
    *    Add # of hits to total hits
    *    Add # of at bats to total at bats
    * END Update Stats
    **********************************************************/

    public void updateStats (int hits, int bats)
    {
       //Local constants

       //Local variables

       /***********************Start Update Stats*******************/

       //Add # of hits to total hits
       hitsTotal += hits;

       //Add # of at bats to total at bats
       atBatsTotal += bats;

    } //END Update Stats

    /**********************************************************
    * Method Name    : Display Player
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Method Description:  This method will format a player's name and
    *    their index number for user selection. It will return the result
    *    to the method.
    *
    * BEGIN Display Player
    *	 Format the player's name for displaying purposes
    *    IF (player's name is more than 15 characters)
    *       Cut the name down to 15 characters
    *    END IF
    *    IF (player's name is less than 15 characters)
    *       Calculate the number of spaces to add
    *       FOR (as many spaces need to be added)
    *          Add the spaces to the name
    *       END FOR
    *    END IF
    *	 Return formatted name to the method
    * END Display Player
    **********************************************************/

    public String displayPlayer ()
    {
	    //Local constants
	    final String COMMA   = ", ";
	    final int MAX_LENGTH = 15;
	    final char SPACE     = ' ';

	    //Local variables
	    String newName;		//String variable for player's formatted name
	    int addSpace;		//Variable for number of spaces to add to name

	    /***********************Start Display Player******************/

	    //Format player's name
		newName = lastName + COMMA + firstName;

		//If the length of the name is longer than 15 characters
		if (newName.length() > MAX_LENGTH)

			//Cut the length down to 15 characters
			newName = newName.substring (0, MAX_LENGTH);

		//If the length of the name is less than 15 characters
		if (newName.length() < MAX_LENGTH)
		{
			//Calculate number of spaces to add
			addSpace = MAX_LENGTH - newName.length();

			//Add the necessary amount of spaces
			for (int count = 0; count < addSpace; count ++)
				newName += SPACE;

		} //END IF

        //Return formatted name to the method
	    return newName;

    } //END Display Player

    /**********************************************************
    * Method Name    : Calculate Batting Average
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Method Description:  This method will calculate a baseball player's
    *    batting average based on their total number of hits and at bats.
    *
    * BEGIN Calculate Batting Average
    *    IF (at bats is greater than zero)
    *       Calculate the player's batting average
    *    END IF
    * END Calculate Batting Average
    **********************************************************/

    public void calcBatAvg ()
    {
	    //Local constants

	    //Local variables

	    /***********************Start Calculate Batting Average******************/

	    //Calculate the player's batting average
	    if (atBatsTotal > 0)
	        batAvg = (float) hitsTotal / atBatsTotal;

    } //END Calculate Batting Average

    /**********************************************************
    * Method Name    : To String
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Program Description:  This method will format a baseball player's
    *    name, number of hits, at bats, and batting average on one line
    *    to display on the screen.
    *
    * BEGIN To String
    *    Format the player's name
    *    IF (player's name is more than 15 characters)
    *       Cut the name down to 15 characters
    *    END IF
    *    IF (player's name is less than 15 characters)
    *       Calculate the number of spaces to add
    *       FOR (as many spaces need to be added)
    *          Add the spaces to the name
    *       END FOR
    *    END IF
    *    Format the player's name and stats to be on one line
    *    Return the final String output to the method
    * END To String
    **********************************************************/

	public String toString ()
	{
		//Local constants
		final String COMMA    = ", ";
		final char SPACE      = ' ';
		final int MAX_LENGTH  = 15;

		//Local variables
		int addSpace;      //Variable for number of spaces to add to name
		String out;        //String variable for the formatted output
		String newName;    //String variable for player's formatted name

		DecimalFormat avgFormat = new DecimalFormat ("#.000"); //Formats a # to 3 decimal places

		/***************************Start To String Method**************************/

		//Format player's name
		newName = lastName + COMMA + firstName;

		//If the length of the name is longer than 15 characters
		if (newName.length() > MAX_LENGTH)

		    //Cut the length down to 15 characters
			newName = newName.substring (0, MAX_LENGTH);

		//If the length of the name is less than 15 characters
		if (newName.length() < MAX_LENGTH)
		{
			//Calculate number of spaces to add
			addSpace = MAX_LENGTH - newName.length();

			//Add the necessary amount of spaces
			for (int count = 0; count < addSpace; count ++)
				newName += SPACE;

		} //END IF

		//Format the player's name and stats to be on one line
		out = Util.setLeft (15, newName) + Util.setRight (8, "" + atBatsTotal) +
		      Util.setRight (14, "" + hitsTotal) + Util.setRight
              (13, "" + avgFormat.format (batAvg)) + "\n";

		//Return the final String output to the method
		return out;

	} //END To String Method

} //END Player Class