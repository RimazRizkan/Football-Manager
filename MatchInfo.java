import java.util.*;

public class MatchInfo {

    private FootballClub homeTeam; //Creating a private variable named as homeTeam
    private FootballClub awayTeam; //Creating a private variable named as awayTeam
    private int homeTeamScore; //Creating a private variable named as homeTeamScore
    private int awayTeamScore; //Creating a private variable named as awayTeamScore
    private Date date; //Creating a private variable named as date

    //Creating a default constructor
    public MatchInfo() {

    }

    //Creating a constructor
    public MatchInfo(FootballClub homeTeam, FootballClub awayTeam, int homeTeamScore, int awayTeamScore, Date date) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.date = date;

    }

    //Getters and Setters for homeTeam
    public FootballClub getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(FootballClub homeTeam) {
        this.homeTeam = homeTeam;
    }

    //Getters and Setters for awayTeam
    public FootballClub getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(FootballClub awayTeam) {
        this.awayTeam = awayTeam;
    }

    //Getters and Setters for homeTeamScore
    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    //Getters and Setters for awayTeamScore
    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }


    //Getters and Setters for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
