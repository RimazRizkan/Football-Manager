public class Main {
    public static void main(String[] args) {
        //Creating the premierLeagueManager object
        LeagueManager premierLeagueManager = new PremierLeagueManager(10);

        boolean exit = false; //Assigning exit as false
        while (!exit){ //This mentions that while exit not equal false then run the menu
            exit = premierLeagueManager.runMenu();

        }
    }
}


