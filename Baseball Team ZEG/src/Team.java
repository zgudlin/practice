/**********************************************************
 * Program Name   : Baseball Team
 * Author         : Zak Gudlin
 * Date           : 5/5/16
 * Course/Section : CSC 111 - 001
 * Program Description:  This class will keep track of the players on
 *    a baseball team. It will keep track of and update their statistics,
 *    allowing the user to make changes to individual player's stats from
 *	  the driver class if they wish. The driver class will also allow the
 *	  user to add players to the team (until the roster is full).
 *    It will also allow the user to display the team's overall statistics
 *    and those of all of the individual players.
 *
 * Methods:
 * -------
 * Constructor # 1 - initializes the class variables using a default roster size
 * Constructor # 2 - initializes the class variables using a user-given roster size
 * Player Menu - displays an indexed menu of players on the team
 * Player Stats - formats every players' stats onto individual lines
 * Add Player - adds players to the team
 * Get Player Count - gets the number of players on the team
 * Update Team Stats - updates the team's hits, at bats, and batting average
 * Get Player Info - gets the formatted stats of one individual player
 * To String - formats the team's name, hits, at bats and batting average on one line
 **********************************************************/

import java.text.DecimalFormat;

public class Team
{
	//Class constants

	//Class variables
	private String teamName;	//Variable for team's name
	private float teamAvg;		//Variable for team's batting average
	private int teamHits;		//Variable for team's total hits
	private int teamBats;		//Variable for team's total at bats
	private int playerCount;	//Variable to keep track of the # of players on the team
	private int rosterSize;		//Variable for the team's maximum roster size
	private Player players [];  //Player object variable for an array of players

    /**********************************************************
    * Method Name    : Constructor # 1
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Program Description: This constructor method will initialize
    *    the class data. It will only receive the team's name. It
    *    will set the team's roster to a default size.
    *
    * BEGIN Constructor # 1 (String inName)
   	*    Initialize inName to = teamName (class variable)
  	*    Initialize teamAvg class variable to = 0
  	*    Initialize teamHits class variable to = 0
	*    Initialize teamBats class variable to = 0
	*    Initialize player count to = 0
	*    Set roster size to equal default
	*	 Instantiate an array of players of the default size
    * END Constructor # 1
    **********************************************************/

    public Team (String inName)
    {
		//Local constants
		final int DEFAULT = 5;

		//Local variables

        /********************Start Constructor # 1*********************/

	    //Initialize inName to = teamName (class variable)
        teamName = inName;

		//Initialize teamAvg class variable to = 0
        teamAvg = 0.0f;

        //Initialize teamHits class variable to = 0
        teamHits = 0;

		//Initialize teamBats class variable to = 0
		teamBats = 0;

		//Initialize playerCount to = 0
		playerCount = 0;

		//Initialize Roster size to default
	    rosterSize = DEFAULT;

	    //Instantiate an array of players of the default size
	    players = new Player [rosterSize];

	} //END Constructor # 1

    /**********************************************************
	* Method Name    : Constructor # 2
	* Author         : Zak Gudlin
	* Date           : 5/5/16
	* Course/Section : CSC 111 - 001
	* Program Description: This overloaded constructor method will initialize
	*    the class data. It will receive the team's name and its roster size.
	*
	* BEGIN Constructor # 2 (String inName, int maxPlayers)
	*    Initialize inName to = teamName (class variable)
	*    Initialize teamAvg class variable to = 0
	*    Initialize teamHits class variable to = 0
	*    Initialize teamBats class variable to = 0
	*	 Initialize player count to = 0
	*	 Initialize roster size to = maxPlayers
	*	 Instantiate an array of players the size of the roster
	* END Constructor # 2
	**********************************************************/

    public Team (String inName, int maxPlayers)
	{
	    //Local constants

		//Local variables

	    /********************Start Constructor # 2*********************/

		//Initialize inName to = teamName (class variable)
		teamName = inName;

		//Initialize teamAvg class variable to = 0
		teamAvg = 0.0f;

		//Initialize teamHits class variable to = 0
		teamHits = 0;

		//Initialize teamBats class variable to = 0
		teamBats = 0;

		//Initialize playerCount to = 0
		playerCount = 0;

		//Initialize roster size to = maxPlayers
		rosterSize = maxPlayers;

		//Instantiate an array of players of the roster size
	    players = new Player [rosterSize];

    } //END Constructor # 2

    /**********************************************************
    * Method Name    : Player Menu
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Program Description:  This method will display a menu of the
    *    players currently on the team, with an index number next to
    *    their name for user selection.
    *
    * BEGIN Player Menu
    *    FOR (as many players are on the team)
    *       Format each player's name and index number on its own line
    *    END FOR
    *    Return the formatted string to the method
    * END Player Menu
    **********************************************************/

    public String playerMenu ()
    {
   	    //Local constants

   	    //Local variables
   	    String display = "";		//String variable for the menu of players

   	    /***********************Start Player Menu******************/

	    //For as many players are on the team
   	    for (int pos = 0; pos < playerCount; pos ++)

		    //Format each player's name and index number on a new line
   	        display = display + Util.setLeft (29, players[pos].displayPlayer())
   	                  + Util.setRight (4, " (" + (pos + 1) + ")\n");

	    //Return the formatted string to the method
   	    return display;

    } //END Player Menu

    /**********************************************************
    * Method Name    : Player Stats
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Program Description:  This method will format all of the baseball players'
    *    names, number of hits, at bats, and batting averages on individual lines
    *    to display on the screen.
    *
    * BEGIN Player Stats
    *    FOR (every player in the array)
    *	   Call method to format each player's stats on one line
    *	END FOR
    *	Return the formatted string of player' stats to the method
    * END Player Stats
    **********************************************************/

    public String playerStats ()
    {
	    //Local constants

	    //Local variables
	    String stats = "";	//String variable for listing all players' stats

	    /*************************Start Player Stats******************************/

	    //For as many players are on the team
	    for (int pos = 0; pos < playerCount; pos ++)

	        //Call method to format each player's stats on a new line
	        stats = stats + players[pos].toString();

	    //Return the formatted string to the method
	    return stats;

    } //END Player Stats

    /**********************************************************
   	* Method Name    : Add Player
   	* Author         : Zak Gudlin
   	* Date           : 5/5/16
   	* Course/Section : CSC 111 - 001
   	* Program Description:  This method will add players to the team
   	*    and increment the player count as each player is added. It
   	*    will return a true/false result to let the user know whether
   	*	 or not the player was successfully added.
   	*
   	* BEGIN Add Player (Player newPlayer)
   	*    IF (Player count is less than roster size)
   	*       Put the new player into the array at the current position
   	*       Increment the player count by one
   	*       Set the result = to true
   	*    END IF
   	*    Return the result to the method
   	* END Add Player
    **********************************************************/

    public boolean addPlayer (Player newPlayer)
    {
        //Local constants

        //Local variables
        boolean result = false;	//Variable for returning true/false result

        /***********************Start Add Player*******************/

        //Add player to the array in current position if array is not full
        if (playerCount < rosterSize)
        {
		    //Put the player into the array
		    players[playerCount] = newPlayer;

		    //Increment the player count by 1
            playerCount ++;

            //Set the result (whether or not player was added) to equal true
            result = true;

        } //END IF

        //Return result
        return result;

    } //END Add Player

    /**********************************************************
    * Method Name    : Get Player Count
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Program Description:  This method will return the number of players
    *    currently on the team.
    *
    * BEGIN Get Player Count
    *    Return the number of players on the team to the method
    * END Get Player Count
    **********************************************************/

    public int getPlayerCount ()
    {
	    //Local constants

	    //Local variables

	    /********************Start Get Player Count*********************/

	    //Return the number of players on the team to the method
	    return playerCount;

    } //END Get Player Count

    /**********************************************************
    * Method Name    : Update Team Stats
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Program Description:  This method will update the team's stats
    *    (hits, at bats and batting average) as well as update the stats of one
    *    selected player. It will return a true/false result to let the user know
    *    whether or not the updates were made successfully.
    *
    * BEGIN Update Team Stats (int newHits, int newBats, int index)
    *    IF (Player count is > 0)
    *       Update the team's total hits with the new hits
    *       Update the team's total at bats with the new at bats
    *       Call the method to update a selected individual player's hits and at bats
    *	    Call the method to update the individual player's batting average
    *       IF (Team's at bats is greater than zero)
    *		     Calculate the team's batting average
    *		END IF
    *       Set result = to true
    *    END IF
    *    Return the result to the method
    * END Update Team Stats
    **********************************************************/

    public boolean updateTeamStats(int newHits, int newBats, int index)
    {
	    //Local constants

	    //Local variables
	    boolean result = false;	//Variable for returning true/false result

	    /***********************Start Update Team Stats*******************/

	    //If there are players in the array
	    if (playerCount > 0)
        {
		    //Update team hits
		    teamHits += newHits;

		    //Update team at bats
		    teamBats += newBats;

		    //Call the method to update an individual player's hits and at bats
		    players[index].updateStats (newHits, newBats);

		    //Call method to calculate player's batting average
		    players[index].calcBatAvg();

		    //If team's at bats > team's hits
		    if (teamBats > 0)

			    //Calculate team's batting average
			    teamAvg = (float) teamHits / teamBats;

		    //Set the result (whether the stats were updated) equal to true
		    result = true;

        }//END IF

	    //Return result
	    return result;

    } //END Update Team Stats

    /**********************************************************
    * Method Name    : Get Player Info
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Program Description:  This method will retrieve the stats (hits, at bats,
    *    batting average) of one selected player. If the user selects a player
    *    that is not there, the method will let the user know their choice was
    *    invalid and ask for another selection.
    *
    * BEGIN Get Player Info (int index)
    *    IF (player count is > 0 and index is valid)
    *       Get the player's info
    *    ELSE
    *       Display an error message
    *    END IF
    *    Return the string result to the method
    * END Get Player Info
    **********************************************************/

    public String getPlayerInfo (int index)
    {
	    //Local constants

	    //Local variables
	    String result;		//String variable for returning a player's stats

	    /***********************Start Get Player Info***********************/

        //If players are in the array and the index is valid
        if (playerCount > 0 && index >= 0 && index < playerCount)

            //Get player's info
            result = players[index].toString();

        //If index is invalid
        else
       	    //Display an invalid index message
            result = "\n" + Util.setLeft (26, "Invalid Index: Select Again: ");

        //Return the string to the method
        return result;

    } //END Get Player Info

    /**********************************************************
    * Method Name    : To String
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Program Description:  This method will format a baseball team's
    *    name, number of hits, at bats, and batting average on one line
    *    to display on the screen. It will also include a heading.
    *
    * BEGIN To String
    *    IF (team's name is more than 15 characters)
    *       Cut the name down to 15 characters
    *    END IF
    *    IF (team's name is less than 15 characters)
    *       Calculate the number of spaces to add
    *       FOR (as many spaces need to be added)
    *          Add the spaces to the team's name
    *       END FOR
    *    END IF
    *    Format the team's name and stats to be on one line
    *    Return the final String output to the method
    * END To String
    **********************************************************/

	public String toString ()
	{
		//Local constants
		final char SPACE         = ' ';
		final int MAX_LENGTH     = 15;

		//Local variables
		int addSpace;      //Variable for number of spaces to add to name
		String out;        //String variable for formatted output

		DecimalFormat avgFormat = new DecimalFormat ("#.000"); //Formats a # to 3 decimal places

		/**********************Start To String Method****************************/

		//If the length of the team name is longer than 15 characters
		if (teamName.length() > MAX_LENGTH)

		    //Cut the length down to 15 characters
			teamName = teamName.substring (0, MAX_LENGTH);

		//If the length of the name is less than 15 characters
		if (teamName.length() < MAX_LENGTH)
		{
			//Calculate number of spaces to add
			addSpace = MAX_LENGTH - teamName.length();

			//Add the necessary amount of spaces
			for (int count = 0; count < addSpace; count ++)
				teamName += SPACE;

		} //END IF

		//Format the team's name, at bats, hits and average to be on one line
		out = "\n\n\n\n" + Util.setLeft  (32, "---------------\n") +
		      Util.setLeft (32, "Team Statistics\n")
		      + Util.setLeft (32, "---------------\n\n\n") +
		      Util.setLeft (15, "Name               Bats          Hits          AVG\n") +
		      Util.setLeft (15, teamName) + Util.setRight (8, "" + teamBats) +
		      Util.setRight (14, "" + teamHits) + Util.setRight
              (13, "" + avgFormat.format (teamAvg)) + "\n";

		//Return the final string output to the method
		return out;

	} //END To String Method

} //END Baseball Team