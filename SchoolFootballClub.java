public class SchoolFootballClub extends FootballClub{

    private String nameOfSchoolFootballClub; //Creating a private variable named as nameOfSchoolFootballClub

    //Creating a constructor with the super class named FootballCub
    public SchoolFootballClub(String clubName, String clubLocation, String nameOfUniversity, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsAttacked, int numOfGoalsDefended, int points,  int numOfMatchesPlayed) {
        super(clubName, clubLocation, numOfWins, numOfDraws, numOfDefeats, numOfGoalsAttacked, numOfGoalsDefended, points, numOfMatchesPlayed);
        this.nameOfSchoolFootballClub = nameOfUniversity;

    }

    //Getters and Setters for nameOfSchoolFootballClub
    public String getNameOfSchoolFootballClub() {
        return nameOfSchoolFootballClub;
    }

    public void setNameOfSchoolFootballClub(String nameOfSchoolFootballClub) {
        this.nameOfSchoolFootballClub = nameOfSchoolFootballClub;
    }

    //Overriding the toString method
    @Override
    public String toString() {
        return "School football club: " + "school football club name: " + nameOfSchoolFootballClub;
    }
}
