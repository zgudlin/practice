/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamdriver;
import java.util.Scanner;

/**
 *
 * @author Zak
 */
/**********************************************************
 * Program Name   : Team Driver
 * Author         : Zak Gudlin
 * Date           : 5/5/16
 * Course/Section : CSC 111 - 001
 * Program Description: This program will keep track of and update the
 *    statistics of a baseball team. It will allow the user to add players
 *	  to the team, update and display their individual statistics, as well
 *	  as display the statistics of the entire team, including an overall
 *	  team average. The user will be able to select from these options
 *	  until they choose to quit.
 *
 * Methods:
 * -------
 * Main - calculates  and updates a baseball team's statistics
 * Menu Display - displays a menu of selections for the user to choose from
 * Enter Player - adds players to the team
 * Player Info - allows the user to update an individual player's stats
 * Display Player - allows the user to display the stats of an individual player
 **********************************************************/

public class TeamDriver
{
    /**********************************************************
    * Method Name    : Main
    * Author         : Zak Gudlin
    * Date           : 5/5/16
    * Course/Section : CSC 111 - 001
    * Method Description: This program will keep track of and update the
	*    statistics of a baseball team. It will allow the user to add players
 	*	 to the team, update and display their individual statistics, as well
    *	 as display the statistics of the entire team, including an overall
    *	 team average. The user will be able to select from these options
    *	 until they choose to quit.
    *
    * BEGIN Main Method
    *    Display heading
    *    Input team name
    *    Input roster size (or default)
    *	 Clear the screen
    *	 IF (roster size is default)
    *	    Instantiate a team with a default roster size
    *	 ELSE
    *       Instantiate a team with a user selected roster size
    *	 END IF
    *    Call method to display menu of options and input choice
    *    WHILE (chosen option is not quit value)
    *		Clear the screen
    *       IF (User wants to add players)
    *		   Call method to add players
    *		ELSE IF (User wants to update a player's stats)
    *		   Call method to update player's stats
    *		   Pause the screen
    *		ELSE IF (User wants to display a player's stats)
    *		   Call method to display a player's stats
    *		   Pause the screen
    *		ELSE IF (User wants to display team's stats)
    *		   Clear the screen
    *		   Call method to display team's stats
    *		   Call method to display all the players' stats
    *		   Pause the screen
    *		ELSE
    *		   Display an invalid selection message
    *		   Pause the screen
    *		END IF
    *		Clear the screen
    *	    Call method to display menu of options and input choice
    *    END WHILE
    *	 Clear the screen
    *    Display closing message
    * END Main Method
    **********************************************************/
 static Scanner scan = new Scanner (System.in);

    public static void main (String [] args)
    {
		//Local constants
		final char QUIT           = '1';
		final char ADD_PLAYER     = '2';
		final char UPDATE_INFO    = '3';
		final char DISPLAY_PLAYER = '4';
		final char DISPLAY_TEAM   = '5';

		//Local variables
		int hits;              //Variable for # of hits
		int bats;              //Variable for # of at bats
		char option;           //Variable for menu choice
		int roster;			   //Variable for roster size
		String teamName;       //Variable for team name
               
		Team team;             //Variable for team object

        /**********************Start Main Method*******************/

        //Display heading
        System.out.println ("\n\n" + Util.setLeft (28, "------------------------"));
        System.out.println (Util.setLeft (28, "Baseball Team Statistics"));
        System.out.println (Util.setLeft (28, "------------------------"));

        //Get team name from user
        System.out.print ("\n\n\n" + Util.setLeft (21, "Enter Team Name                     : "));
        teamName = scan.nextLine ();

        //Get roster size from user (or default)
        System.out.print ("\n\n" + Util.setLeft (21, "Roster Size (0 or # < 0 for default): "));
        roster = scan.nextInt ();


        //If user selects default roster size
        if (roster <= 0)

			//Create team using default roster size
            team = new Team (teamName);

		//If user picks a roster size
		else

			//Create team using user's roster size
			team = new Team (teamName, roster);

        //Call method to display menu and input choice
        option = menuDisplay();

        //While choice is not quit
        while (option != QUIT)
        {

			//If user wants to add a player
			if (option == ADD_PLAYER)

				//Call method to enter players
				enterPlayer (team);

			//If user wants to update a player's stats
			else if (option == UPDATE_INFO)
			{
				//Call method to update player's stats
				playerInfo (team);

			
		    }
		    //If user wants to display a player's stats
		    else if (option == DISPLAY_PLAYER)
		    {
			    //Call method to display player's stats
			    displayPlayer (team);

		    }
		    //If user wants to display the team's stats
		    else if (option == DISPLAY_TEAM)
		    {
			  

			    //Call method to display team's info
			    System.out.println (team);

			    //Call method to display all the players' stats
			    System.out.println (team.playerStats());

			  
		    }
            //If user made an invalid choice
		    else
		    {
			    //Display invalid choice message
			    System.out.println ("\n\n\n\n" + Util.setLeft (29, "ERROR: INVALID CHOICE\n\n\n"));

			    

		    } //END IF

		 

            //Call method to display menu and input choice
            option = menuDisplay();

        } //END WHILE


        //Display closing message
        System.out.println ("\n\n\n" + Util.setLeft (22, "Thank You For Running This Program!\n\n\n"));

	} //END Main Method

    /**********************************************************
	* Method Name    : Menu Display
	* Author         : Zak Gudlin
	* Date           : 5/5/16
	* Course/Section : CSC 111 - 001
	* Method Description: This method will display a menu of options
	*    for a user to select from. It will also receive a choice from the user.
	*
	* BEGIN Menu Display
	*    Display menu of choices for user to select from
	*	 Input the choice
	*	 Return the choice to the method
	* END Menu Display
	**********************************************************/

	public static char menuDisplay ()
	{
		//Local constants

		//Local variables
		char choice;		//Variable for user's menu selection

        /**********************Start Menu Display*******************/

        //Display menu of options and prompt for choice
        System.out.print ("\n\n\n\n" + Util.setLeft (38, "MENU\n\n\n"));
        System.out.println (Util.setLeft (27, "Quit                : (1)"));
        System.out.println (Util.setLeft (27, "Add Players         : (2)"));
        System.out.println (Util.setLeft (27, "Update Player Stats : (3)"));
        System.out.println (Util.setLeft (27, "Display Player Stats: (4)"));
        System.out.println (Util.setLeft (27, "Display Team Stats  : (5)\n\n"));
        System.out.print (Util.setLeft (27, "Enter Choice        : "));

        //Get choice from user
        choice = scan.next().charAt(0);

        //Return choice to calling method
        return choice;

	} //END Menu Display

    /**********************************************************
	* Method Name    : Enter Player
	* Author         : Zak Gudlin
	* Date           : 5/5/16
	* Course/Section : CSC 111 - 001
	* Method Description: This method will allow the user to add
	*    players to the team. They will be able to do this until
	*    they choose to quit, or until the team is full.
	*
	* BEGIN Enter Player (Team team)
	*    Get player's first name (or quit)
	*	 WHILE (Player's first name is not quit value)
	*       Input player's last name
	*	    Clear the screen
	*       Instantiate a copy of a player
	*       Call method to add player to the array (the team)
	*		IF (Player was added to team)
	*          Display message indicating successful add
	*		   Pause the screen
	*		   Clear the screen
	*		   Get next first name (or quit)
	*       ELSE
	*          Display message that team is full
	*		   Pause the screen
	*		   Set first name to = quit value
	*       END IF
	*    END WHILE
	* END Enter Player
	**********************************************************/

	public static void enterPlayer (Team team)
	{
		//Local constants
		final String QUIT = "0";

		//Local variables
		String first;       	//Variable for player's first name
		String last;        	//Variable for player's last name
		boolean successfulAdd;  //Boolean variable for indicating if player was added to team
		Player player;			//Variable for the player object

		/**********************Start Enter Player*******************/

		//Input first name or quit
		System.out.print ("\n\n\n" + Util.setLeft (25, "Enter First Name (0 to quit): "));
		first = scan.nextLine();

		//While user did not quit
		while (first.compareTo (first) != QUIT.compareTo (first))
		{
			//Input last name
			System.out.print ("\n" + Util.setLeft (25, "Enter Last Name             : "));
			last = scan.nextLine();

			//Instantiate a copy of a player
			player = new Player (first, last);

			//Call method to add player to the array
			successfulAdd = team.addPlayer (player);

			//If player was successfully added
			if (successfulAdd)
			{
				//Display message indicating player was succesfully added
				System.out.println ("\n\n\n" + Util.setLeft (27, "Player Successfully Added\n\n"));

			
				//Ask for next player's first name or quit
				System.out.print ("\n\n\n" + Util.setLeft (25, "Enter First Name (0 to quit): "));
				first = scan.nextLine();
			}
			//If the team (array) is full
			else
			{
				//Display a message indicating team is full
				System.out.println ("\n\n\n" + Util.setLeft (34,"Team Is Full\n\n"));


			    //Set first name to equal quit value
				first = QUIT;

			} //End IF

		} //END WHILE

	} //END Enter Player

    /**********************************************************
	* Method Name    : Player Info
	* Author         : Zak Gudlin
	* Date           : 5/5/16
	* Course/Section : CSC 111 - 001
	* Method Description: This method will allow the user to select
	*    an individual player and edit their stats (hits and at bats).
	*    If the team is empty, the user will be informed. This method will
	*    also make sure that the info entered is valid, and will let the user
	*    know when the stats are successfully updated.
	*
	* BEGIN Player Info (Team team)
	*    IF (array is empty (no players have been entered))
	*       Let user know no players have been entered
	*    ELSE
	*		Clear the screen
	*	    Display menu of indexed players to select from
	*       Get player selection index from user
	*		Subtract one from index to line up with proper array element
	*       WHILE (The index is invalid)
	*    	   Tell user the index is invalid
	*		   Get another index from user
	*		   Subtract one from index to line up with proper array element
	*		END WHILE
	*		Input # of at bats
	*       Input # of hits
	*       WHILE (hits exceed at bats)
	*		   Tell user hits CANNOT exceed at bats
	*		   Re-enter # of hits
	*       END WHILE
	*       Call method to update team and player's stats
	*       IF (Update was successful)
	*		   Display message letting user know updates were made
	*		ELSE
	*		   Display message indicating updates were unsuccessful
	*		END IF
	*    END IF
	* END Player Info
	**********************************************************/

	public static void playerInfo (Team team)
	{
		//Local constants

		//Local variables
		int index;					//Variable for player selection choice
		int hits;					//Variable for # of hits
		int bats;					//Variable for # of at bats
		boolean successfulUpdate;	//Boolean variable for indicating if player was added to team

		/*****************************Start Player Info******************************/

		//If array is empty
		if (team.getPlayerCount() == 0)

			//Let user know no players have been entered
			System.out.println ("\n\n\n" + Util.setLeft (31, "No Players Entered\n\n"));

		//If array is not empty
		else
		{
		

			//Display menu of available players to select from
			System.out.println ("\n\n\n");
			System.out.println (team.playerMenu());

			//Prompt for and input the index of the player user wants to select
			System.out.print ("\n" + Util.setLeft (29, "Enter Choice   : "));
			index = scan.nextInt();

			//Subtract one from index to line up with proper array element
			index = index - 1;

			//While the index is invalid
			while (index >= team.getPlayerCount() || index < 0)
			{
				//Tell user the index is invalid and to choose again
				System.out.print ("\n" + Util.setLeft (20, "Invalid Player Selection: Select Again: "));

				//Input next choice
				index = scan.nextInt();

				//Subtract one from index to line up with proper array element
				index = index - 1;

			} //END WHILE

			//Input # of at bats
			System.out.print ("\n\n" + Util.setLeft (35, "At Bats: "));
			bats = scan.nextInt();

			//Input # of hits
			System.out.print ("\n" + Util.setLeft (35, "Hits   : "));
			hits = scan.nextInt();
			//While hits exceeds at bats
			while (hits > bats)
			{
				//Tell user hits cannot be greater than at bats and to choose again
				System.out.print ("\n" + Util.setLeft (20, "Hits Cannot Exceed At Bats: Try Again: "));

				//Get next # of hits
				hits = scan.nextInt();

			} //END WHILE

			//Call the method to update the stats
			successfulUpdate = team.updateTeamStats (hits, bats, index);

	  	    //If successful update of the stats
	   		if (successfulUpdate)

		        //Let user know stats were updated
		        System.out.println ("\n\n" + Util.setLeft (31, "Stats Were Updated\n\n\n"));

	   		//If stats were not updated
	   		else

				//Display message indicating invalid data was entered
			    System.out.println (Util.setLeft (29, "Stats Were NOT Updated\n\n\n"));

   		} //End IF

   } //END Player Info

   /**********************************************************
   * Method Name    : Display Player
   * Author         : Zak Gudlin
   * Date           : 5/5/16
   * Course/Section : CSC 111 - 001
   * Method Description: This method will allow the user to select an
   *    individual player and display their statistics (hits, at bats and
   *    batting average). It will also inform the user if the team is empty.
   *
   * BEGIN Display Player (Team team)
   *    Clear the screen
   *    IF (There are no players in the array (on the team)
   *	   Display a message indicating no players have been input
   *	ELSE
   *	   Display a menu of players with indexed numbers
   *	   Select an index for a specific player
   *	   Subtract one from the index to line it up with the proper array element
   *       WHILE (index is invalid)
   *	      Let the user know they selected an invalid choice
   *		  Input next choice
   *		  Subtract one from the index to line it up with the proper array element
   *       END WHILE
   *	   Clear the screen
   *	   Display the headings
   *	   Call the method to display the player's stats
   *	END IF
   * END Display Player
   **********************************************************/

   public static void displayPlayer (Team team)
   {
	   //Local constants

	   //Local variables
	   int displayIndex;	//Variable for user's selected index

	   /****************************Start Display Player*********************************/


	   //If # of players in array is zero
	   if (team.getPlayerCount() == 0)
			System.out.println ("\n\n\n\n" + Util.setLeft (31, "No Players Entered\n\n"));

	   //If array is not empty
	   else
	   {
		   //Display menu of players with indexes
		   System.out.println ("\n\n\n\n" + team.playerMenu());

		   //Prompt for and get choice from user
		   System.out.print (Util.setLeft (29, "Enter Choice   : "));
		   displayIndex = scan.nextInt ();

		   //Subtract one from index to line up with proper array element
		   displayIndex = displayIndex - 1;

		   //While the index is invalid
		   while (displayIndex >= team.getPlayerCount() || displayIndex < 0)
		   {
			   //Display message indicating invalid index
			   System.out.print (team.getPlayerInfo (displayIndex));

			   //Enter next choice
			   displayIndex = scan.nextInt ();

			   //Subtract one from index to line up with proper array element
			   displayIndex = displayIndex -1;

		   }//END WHILE

		   //Display headings
		   System.out.println ("\n\n\n" + Util.setLeft (31, "-----------------"));
		   System.out.println (Util.setLeft (31, "Player Statistics"));
		   System.out.println (Util.setLeft (31, "-----------------\n\n\n"));
		   System.out.println (Util.setLeft (15, "Name               Bats          Hits          AVG"));

	       //Call the method to display selected player's stats
	       System.out.println (team.getPlayerInfo (displayIndex));

	   } //END IF/ELSE

   } //END Display Player

} //END Team Driver
