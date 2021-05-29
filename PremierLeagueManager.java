import java.io.*;
import java.text.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    private final ArrayList<FootballClub> footballClubList; //Creating a private Arraylist named as footballClubList
    private final ArrayList<MatchInfo> matchesPlayed; //Creating a private Arraylist named as matchesPlayed
    private final int numOfClubs; //Creating a private variable named as numOfClubs


    //Creating a constructor and passing a parameter named as clubListLength
    public PremierLeagueManager(int clubListLength) {
        this.numOfClubs = clubListLength; //Assigning the numOfClubs to clubListLength
        footballClubList = new ArrayList<>();
        matchesPlayed = new ArrayList<>();
    }


    //Creating a runMenu method
    public boolean runMenu() {

        while (true) {
            //Displaying the following options in the console for the user to choose
            System.out.println(" \n  1 : Add a football club to premier league\n" +
                    "  2 : Delete a football club from premier league\n" +
                    "  3 : Display football club statistics\n" +
                    "  4 : Display premier league table\n" +
                    "  5 : Adding a played match\n" +
                    "  6 : Save to a text file\n" +
                    "  7 : Load from text file\n" +
                    "  8 : Play random Match \n" +
                    "  9 : Quit the program... \n");

            try {
                Scanner sc = new Scanner(System.in); //Creating a new Scanner object as sc
                System.out.print("Enter your preferred option : ");
                int userInput = sc.nextInt(); //Creating a integer variable userInput to the scanner
                System.out.println();

                //Using a switch case for the above userInput
                switch (userInput) {
                    //If user input is 1 then addClub() method will be called
                    case 1:
                        addClub();
                        break;

                    //If user input is 2 then deleteClub() method will be called
                    case 2:
                        deleteClub();
                        break;

                    //If user input is 3 then clubStatistics() method will be called
                    case 3:
                        clubStatistics();
                        break;

                    //If user input is 4 then displayPremierLeagueTable() method will be called
                    case 4:
                        displayPremierLeagueTable();
                        break;

                    //If user input is 5 then addPlayedMatch() method will be called
                    case 5:
                        addPlayedMatch();
                        break;

                    //If user input is 6 then saveToTextFile() method will be called
                    case 6:
                        saveToTextFile();
                        break;

                    //If user input is 7 then loadFromTextFile() method will be called
                    case 7:
                        loadFromTextFile();
                        break;

                    //If user input is 8 then playRandomMatch() method will be called
                    case 8:
                        playRandomMatch();
                        break;

                    //If user input is 9 then the program will get exit successfully
                    case 9:
                        System.out.println("Program got exit successfully...");
                        System.exit(0);
                        break;

                    //If User enters a invalid input then this message will be displayed
                    default:
                        System.out.println("Enter a valid input!");
            }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input " + e);
            }
        }
    }


    //Overriding the addClub() method
    @Override
    public void addClub() {
        if (footballClubList.size() >= numOfClubs) { //Checking if Arraylist footballClubList is greater or equal to numOfClubs
            System.out.println("No more space left...");
            System.exit(0); //If the if condition is true then the program will get exit successfully
        }


        Scanner sc = new Scanner(System.in); //Creating a new Scanner object named as sc
        System.out.print("Enter club name: ");
        String user = sc.next(); //Creating a string variable user to the scanner


        //Creating a enhanced for loop with type FootballClub and variable name as footballClub followed with an arraylist called footballCLubList
        for (FootballClub footballClub : footballClubList) {
            if (footballClub.getClubName().contains(user)) { //Checking whether the footballClub contains user variable
                System.out.println("Club already exists...");
                return; //Returns to the user options if the if condition is true
            }

        }

        //Creating a new footballClub object with the parameter user to the constructor
        FootballClub footballClub = new FootballClub(user);
        System.out.print("Enter club location: ");
        user = sc.next();
        footballClub.setClubLocation(user); //Setting the club location to the footballClub object
        footballClubList.add(footballClub); //Adding the footballClub object to the footballClubList Arraylist

        System.out.println("Successfully added " + footballClub.getClubName() + " to league");
        System.out.println("----------------------------------------------");

    }


    //Overriding the deleteClub() method
    @Override
    public void deleteClub() {
        //Creating a new Scanner object named as sc
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the club name to delete: ");
        String clubName = sc.next(); //Creating a string variable clubName to the scanner

        for (int i = 0; i < footballClubList.size(); i++) { //Creating a for loop to iterate the footballClubList arraylist
            if (clubName.equals(footballClubList.get(i).getClubName())) { //Checking whether the user input is equal to the club name in the footballClubList
                System.out.println("removed club " + footballClubList.get(i).getClubName() + " successfully...");
                footballClubList.remove(i); //If it is equal then club name in the footballClubList gets removed
                return; //Returns to the user options if the if condition is true
            }
        }
        System.out.println("Sorry! there is no such club in the premier league");

    }


    //Generating a random match
    public void playRandomMatch() {

        if (footballClubList.size() < 3) { //Checking if the arraylist size is less than 3
            System.out.println("Minimum 3 Clubs Should be Added");
            return;
        }

        //Getting a random home club
        String randomHomeClub = footballClubList.get(getRandomNumber(1, footballClubList.size())).getClubName();
        String randomAwayClub;
        while (true) {
            //Getting random away club
            randomAwayClub = footballClubList.get(getRandomNumber(1, footballClubList.size())).getClubName();
            if (!randomAwayClub.equals(randomHomeClub)) {
                break;
            }
        }
        System.out.println("HOME TEAM : " +randomHomeClub);
        System.out.println("AWAY  TEAM : " +randomAwayClub);

        Date currentDate = new Date(); //Creating a currentDate object

        //Creating a MatchInfo object named as match
        MatchInfo match = new MatchInfo();
        match.setDate(currentDate);

        FootballClub homeTeam = null; //Declaring FootballClub object homeTeam as null

        for (FootballClub footballClub : footballClubList) {
            if (footballClub.getClubName().equals(randomHomeClub)) { //Checking if the club name is equal to randomHomeClub
                homeTeam = footballClub; //Assigning homeTeam to footballClub
            }
        }

        FootballClub awayTeam = null; //Declaring FootballClub object awayTeam as null

        for (FootballClub footballClub : footballClubList) {
            if (footballClub.getClubName().equals(randomAwayClub)) { //Checking if the club name is equal to randomAwayClub
                awayTeam = footballClub; //Assigning awayTeam to footballClub
            }
        }

        int homeTeamGoalsScored = getRandomNumber(1, 8); //Getting a random number from 1 to 7 for homeTeamGoalsScored
        int awayTeamScoredGoals = getRandomNumber(1, 8); //Getting a random number from 1 to 7 for awayTeamGoalsScored

        System.out.println("HOME TEAM GOALS SCORED : " +homeTeamGoalsScored);
        System.out.println("AWAY TEAM  GOALS SCORED: " +awayTeamScoredGoals);

        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setHomeTeamScore(homeTeamGoalsScored);
        match.setAwayTeamScore(awayTeamScoredGoals);
        matchesPlayed.add(match); //Adding the match object to the matchesPlayed Arraylist

        homeTeam.setNumOfGoalsAttacked(homeTeam.getNumOfGoalsAttacked() + homeTeamGoalsScored);
        awayTeam.setNumOfGoalsAttacked(awayTeam.getNumOfGoalsAttacked() + awayTeamScoredGoals);
        homeTeam.setNumOfGoalsDefended(homeTeam.getNumOfGoalsDefended() + awayTeamScoredGoals);
        awayTeam.setNumOfGoalsDefended(awayTeam.getNumOfGoalsDefended() + homeTeamGoalsScored);
        homeTeam.setNumOfMatchesPlayed(homeTeam.getNumOfMatchesPlayed() + 1);
        awayTeam.setNumOfMatchesPlayed(awayTeam.getNumOfMatchesPlayed() + 1);

        //Checking if homeTeamGoalsScored is greater than awayTeamScoredGoals
        if (homeTeamGoalsScored > awayTeamScoredGoals) {
            System.out.println("----------HOME TEAM WON----------");
            homeTeam.setPoints(homeTeam.getPoints() + 3); //homeTeam points increase by 3
            homeTeam.setNumOfWins(homeTeam.getNumOfWins() + 1); //homeTeam wins increase by 1
            awayTeam.setNumOfDefeats(awayTeam.getNumOfDefeats() + 1); //awayTeam defeats increase by 1

            //Checking if awayTeamScoredGoals is greater than homeTeamGoalsScored
        } else if (awayTeamScoredGoals > homeTeamGoalsScored) {
            System.out.println("----------AWAY TEAM WON----------");
            awayTeam.setPoints(awayTeam.getPoints() + 3); //awayTeam points increase by 3
            awayTeam.setNumOfWins(awayTeam.getNumOfWins() + 1); //awayTeam wins increase by 1
            homeTeam.setNumOfDefeats(homeTeam.getNumOfDefeats() + 1); //homeTeam defeats increase by 1

            //Checking if homeTeamGoalsScored is equal to awayTeamScoredGoals
        } else if (homeTeamGoalsScored == awayTeamScoredGoals) {
            System.out.println("----------MATCH DRAWN----------");
            homeTeam.setPoints(homeTeam.getPoints() + 1); //homeTeam points increase by 1
            awayTeam.setPoints(awayTeam.getPoints() + 1); //awayTeam points increase by 1
            homeTeam.setNumOfDraws(homeTeam.getNumOfDraws() + 1); //homeTeam draws increase by 1
            awayTeam.setNumOfDraws(awayTeam.getNumOfDraws() + 1); //awayTeam draws increase by 1
        }


    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    //Overriding the clubStatistics() method
    @Override
    public void clubStatistics() {

        //Creating a new Scanner object named as sc
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter football club name: ");
        String user = sc.next(); //Creating a string variable user to the scanner

        //Creating a enhanced for loop with type FootballClub and variable name as footballClub followed with an arraylist called footballCLubList
        for (FootballClub footballClub : footballClubList) {
            if (footballClub.getClubName().equals(user)) { //Checking whether the club name is equal to the Scanner variable named user
                System.out.println("Statistics of club: " + footballClub.getClubName());
                System.out.println(footballClub.toString());
                return; //Returns to the user options if the if condition is true
            }
        }
        System.out.println("Sorry this club is not available in the premier league...");
    }


    //Overriding the displayPremierLeagueTable() method
    @Override
    public void displayPremierLeagueTable() {

        footballClubList.sort(new SportsClub());

        if (footballClubList.isEmpty()) { //Checking whether the footballClubList is empty
            System.out.println("Sorry, no clubs found! Try Again...");
            return; //Returns to the user options if the if condition is true
        }
        //Displaying the premier league table
        System.out.println("---------------------------------------------------------------- PREMIER LEAGUE TABLE ----------------------------------------------------------------");
        System.out.println();
        for (FootballClub footballClub : footballClubList) {
            System.out.printf("| %-15s|   %-15s|   %-8s|   %-8s|   %-8s|   %-20s|   %-20s|   %-8s|   %-15s \n", "CLUB NAME", "CLUB LOCATION", "WINS", "DRAWS", "DEFEATS", "GOALS ATTACKED", "GOALS DEFENDED", "POINTS", "MATCHES PLAYED");
            System.out.printf("| %-15s|   %-15s|   %-8s|   %-8s|   %-8s|   %-20s|   %-20s|   %-8s|   %-15s \n", footballClub.getClubName(), footballClub.getClubLocation(), footballClub.getNumOfWins(), footballClub.getNumOfDraws(), footballClub.getNumOfDefeats(), footballClub.getNumOfGoalsAttacked(), footballClub.getNumOfGoalsDefended(), footballClub.getPoints(), footballClub.getNumOfMatchesPlayed());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

    }


    //Overriding the addPlayedMatch() method
    @Override
    public void addPlayedMatch() {

        //Creating a new Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date in (dd-mm-yyyy) format");
        String user = sc.nextLine(); //Creating a string object user to the scanner

        Date date; //date as the object from Date class
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(user);
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("Incorrect date format!! Please try again");
            return; //Returns to the user options if the if condition is true
        }


        System.out.println("Enter home team name: ");
        user = sc.nextLine();
        FootballClub homeTeam = null; //Declaring FootballClub object homeTeam as null

        for (FootballClub footballClub : footballClubList) {
            if (footballClub.getClubName().equals(user)) { //Checking if the club name is equal to Scanner variable named user
                homeTeam = footballClub; //Assigning homeTeam to footballClub
            }
        }

        if (homeTeam == null) { //Checking whether the homeTeam is null
            System.out.println("Home team not found");
            return; //Returns to the user options if the if condition is true
        }

        System.out.println("Enter away team name: ");
        user = sc.nextLine();
        FootballClub awayTeam = null; //Declaring FootballClub object awayTeam as null

        for (FootballClub footballClub : footballClubList) {
            if (footballClub.getClubName().equals(user)) { //Checking if the club name is equal to Scanner variable named user
                awayTeam = footballClub; //Assigning awayTeam to footballClub
            }
        }

        if (awayTeam == null) { //Checking whether the awayTeam is null
            System.out.println("Away team not found");
            return; //Returns to the user options if the if condition is true
        }

        if (awayTeam == homeTeam) { //Checking whether the awayTeam is equal to homeTeam
            System.out.println("Sorry, Away team name is similar to Home team!");
            return; //Returns to the user options if the if condition is true
        }

        System.out.println("Number of goals scored by home team: ");
        user = sc.nextLine();
        int homeTeamGoalsScored; //Creating a integer variable named as homeTeamGoalsScored
        try {
            homeTeamGoalsScored = Integer.parseInt(user);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid input " + e);
            return; //Returns to the user options if the if condition is true
        }

        if (homeTeamGoalsScored < 0) {
            System.out.println("You need to enter number of goals scored by home team");
            return; //Returns to the user options if the if condition is true
        }


        System.out.println("Number of goals scored by away team: ");
        user = sc.nextLine();
        int awayTeamScoredGoals; //Creating a integer variable named as awayTeamGoalsScored
        try {
            awayTeamScoredGoals = Integer.parseInt(user);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid input " + e);
            return; //Returns to the user options if the if condition is true
        }

        if (awayTeamScoredGoals < 0) {
            System.out.println("You need to enter number of goals scored by away team");
            return; //Returns to the user options if the if condition is true
        }

        //Creating a MatchInfo object named as match
        MatchInfo match = new MatchInfo();
        match.setDate(date);
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setHomeTeamScore(homeTeamGoalsScored);
        match.setAwayTeamScore(awayTeamScoredGoals);
        matchesPlayed.add(match); //Adding the match object to the matchesPlayed Arraylist

        //Setting and Getting num of goals attacked, defended and matches played by homeTeam and awayTeam
        homeTeam.setNumOfGoalsAttacked(homeTeam.getNumOfGoalsAttacked() + homeTeamGoalsScored);
        awayTeam.setNumOfGoalsAttacked(awayTeam.getNumOfGoalsAttacked() + awayTeamScoredGoals);
        homeTeam.setNumOfGoalsDefended(homeTeam.getNumOfGoalsDefended() + awayTeamScoredGoals);
        awayTeam.setNumOfGoalsDefended(awayTeam.getNumOfGoalsDefended() + homeTeamGoalsScored);
        homeTeam.setNumOfMatchesPlayed(homeTeam.getNumOfMatchesPlayed() + 1);
        awayTeam.setNumOfMatchesPlayed(awayTeam.getNumOfMatchesPlayed() + 1);

        //Checking if homeTeamGoalsScored is greater than awayTeamScoredGoals
        if (homeTeamGoalsScored > awayTeamScoredGoals) {
            System.out.println("----------HOME TEAM WON----------");
            homeTeam.setPoints(homeTeam.getPoints() + 3); //homeTeam points increase by 3
            homeTeam.setNumOfWins(homeTeam.getNumOfWins() + 1); //homeTeam wins increase by 1
            awayTeam.setNumOfDefeats(awayTeam.getNumOfDefeats() + 1); //awayTeam defeats increase by 1

            //Checking if awayTeamScoredGoals is greater than homeTeamGoalsScored
        } else if (awayTeamScoredGoals > homeTeamGoalsScored) {
            System.out.println("----------AWAY TEAM WON----------");
            awayTeam.setPoints(awayTeam.getPoints() + 3); //awayTeam points increase by 3
            awayTeam.setNumOfWins(awayTeam.getNumOfWins() + 1); //awayTeam wins increase by 1
            homeTeam.setNumOfDefeats(homeTeam.getNumOfDefeats() + 1); //homeTeam defeats increase by 1

            //Checking if homeTeamGoalsScored is equal to awayTeamScoredGoals
        } else if (homeTeamGoalsScored == awayTeamScoredGoals) {
            System.out.println("----------MATCH DRAWN----------");
            homeTeam.setPoints(homeTeam.getPoints() + 1); //homeTeam points increase by 1
            awayTeam.setPoints(awayTeam.getPoints() + 1); //awayTeam points increase by 1
            homeTeam.setNumOfDraws(homeTeam.getNumOfDraws() + 1); //homeTeam draws increase by 1
            awayTeam.setNumOfDraws(awayTeam.getNumOfDraws() + 1); //awayTeam draws increase by 1
        }

    }


    //Overriding the saveToTextFile() method
    @Override
    public void saveToTextFile() {
        if (footballClubList.size() <= 0) { //Checking if footballClubList arraylist size is less than or equal to 0
            System.out.println("No Clubs Available");
            return;
        }

        try {
            //Creating a fos object with a file name called footballClub
            FileOutputStream fos = new FileOutputStream("footballClub");
            //Creating a oos object and passing the parameter fos
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (FootballClub footballClub : footballClubList) {
                oos.writeObject((footballClub)); //writeObject footballClub to oos object
            }
            oos.close(); //Close oos object
            System.out.println("Successfully Saved to Text File");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    //Overriding the loadFromTextFile() method
    @Override
    public void loadFromTextFile() {
        try {
            //Creating a fileInputStream object with a file name called footballClub
            FileInputStream fileInputStream = new FileInputStream("footballClub");
            //Creating a objectInputStream object and passing the parameter fileInputStream
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


            for (; ; ) { //Creating an infinite for loop
                try { //Creating a club object  and readObject
                    FootballClub club = (FootballClub) objectInputStream.readObject();
                    footballClubList.add(club); //adding club object to footballClubList arraylist
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }

            fileInputStream.close(); //Closing fileInputStream object
            objectInputStream.close(); //Closing objectInputStream object
            System.out.println("Successfully Read From Text File");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

