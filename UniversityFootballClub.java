public class UniversityFootballClub extends FootballClub{

    private String nameOfUniversityFootballClub; //Creating a private variable named as nameOfUniversityFootballClub

    //Creating a constructor with the super class named FootballCub
    public UniversityFootballClub(String clubName, String clubLocation, String nameOfUniversity, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsAttacked, int numOfGoalsDefended, int points,  int numOfMatchesPlayed) {
        super(clubName, clubLocation, numOfWins, numOfDraws, numOfDefeats, numOfGoalsAttacked, numOfGoalsDefended, points, numOfMatchesPlayed);
        this.nameOfUniversityFootballClub = nameOfUniversity;

    }

    //Getters and Setters for nameOfUniversityFootballClub
    public String getNameOfUniversityFootballClub() {
        return nameOfUniversityFootballClub;
    }

    public void setNameOfUniversityFootballClub(String nameOfUniversityFootballClub) {
        this.nameOfUniversityFootballClub = nameOfUniversityFootballClub;
    }

    //Overriding the toString method
    @Override
    public String toString() {
        return "University football club: " + "University football club name: " + nameOfUniversityFootballClub;
    }
}
