import java.io.Serializable;

public class FootballClub extends SportsClub implements Serializable {
    private int points; //Creating a private variable named as points
    private int numOfDraws; //Creating a private variable named as numOfDraws
    private int numOfWins; //Creating a private variable named as numOfWins
    private int numOfDefeats; //Creating a private variable named as numOfDefeats
    private int numOfGoalsAttacked; //Creating a private variable named as numOfGoalsAttacked
    private int numOfGoalsDefended; //Creating a private variable named as numOfGoalsDefended
    private int numOfMatchesPlayed; //Creating a private variable named as numOfMatchesPlayed

    //Creating a default constructor
    public FootballClub() {

    }

    //Creating a constructor with a super class variable clubName as parameter
    public FootballClub(String clubName) {
        super(clubName);
    }

    //Creating a constructor with a super class variables
    public FootballClub(String clubName, String clubLocation, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsAttacked, int numOfGoalsDefended, int points,  int numOfMatchesPlayed) {
        super(clubName, clubLocation);
        this.numOfWins = numOfWins;
        this.numOfDraws = numOfDraws;
        this.numOfDefeats = numOfDefeats;
        this.numOfGoalsAttacked = numOfGoalsAttacked;
        this.numOfGoalsDefended = numOfGoalsDefended;
        this.points = points;
        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }

    //Creating a constructor
    public FootballClub(int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsAttacked, int numOfGoalsDefended, int points,  int numOfMatchesPlayed) {

        this.numOfWins = numOfWins;
        this.numOfDraws = numOfDraws;
        this.numOfDefeats = numOfDefeats;
        this.numOfGoalsAttacked = numOfGoalsAttacked;
        this.numOfGoalsDefended = numOfGoalsDefended;
        this.points = points;
        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }

    // Getters and Setters for points
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // Getters and Setters for numOfDraws
    public int getNumOfDraws() {
        return numOfDraws;
    }

    public void setNumOfDraws(int numOfDraws) {
        this.numOfDraws = numOfDraws;
    }

    // Getters and Setters for numOfWins
    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    // Getters and Setters for numOfDefeats
    public int getNumOfDefeats() {
        return numOfDefeats;
    }

    public void setNumOfDefeats(int numOfDefeats) {
        this.numOfDefeats = numOfDefeats;
    }

    // Getters and Setters for numOfGoalsAttacked
    public int getNumOfGoalsAttacked() {
        return numOfGoalsAttacked;
    }

    public void setNumOfGoalsAttacked(int numOfGoalsAttacked) {
        this.numOfGoalsAttacked = numOfGoalsAttacked;
    }

    // Getters and Setters for numOfGoalsDefended
    public int getNumOfGoalsDefended() {
        return numOfGoalsDefended;
    }

    public void setNumOfGoalsDefended(int numOfGoalsDefended) {
        this.numOfGoalsDefended = numOfGoalsDefended;
    }

    // Getters and Setters for numOfMatchesPlayed
    public int getNumOfMatchesPlayed() {
        return numOfMatchesPlayed;
    }

    public void setNumOfMatchesPlayed(int numOfMatchesPlayed) {
        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }

    //Overriding the toString method
    @Override
    public String toString() {
        return   " matches played: " + numOfMatchesPlayed + "  matches won: " + numOfWins + "  matches drawn: " + numOfDraws + "  matches lost: " + numOfDefeats +
                "  goals attacked: " + numOfGoalsAttacked + "  goals defended: " +  numOfGoalsDefended +
                "  points: " + points;
    }
}
