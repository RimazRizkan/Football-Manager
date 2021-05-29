import java.io.*;
import java.util.*;

public class SportsClub implements Serializable, Comparator<FootballClub> {

    private String clubName; //Creating a private variable named as clubName
    private String clubLocation; //Creating a private variable named as clubLocation

    //Creating a default constructor
    public SportsClub() {

    }

    //Creating a constructor and passing the parameter clubName
    public SportsClub(String clubName) {
        this.clubName = clubName;
    }

    //Creating a constructor and passing the parameters clubName and clubLocation
    public SportsClub(String clubName, String clubLocation) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    // Getters and Setters for clubName
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    // Getters and Setters for clubLocation
    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }


    @Override
    public String toString() {
        return "Sports Club Details : " + " club name: " + clubName + " , club location: " + clubLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this.clubName.equals(clubName)) {
            return true;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName);
    }

    @Override
    public int compare(FootballClub o1, FootballClub o2) {

        if (o1.getPoints() > o2.getPoints()) {
            return -1; //Do not swap if o1.getPoints is greater than o2.getPoints
        } else if (o1.getPoints() < o2.getPoints()) {
            return 1; //Swap if o1.getPoints is lower than o2.getPoints
        } else if (o1.getPoints() == o2.getPoints()) { //Checking whether both the points are equal
            if (o1.getNumOfGoalsAttacked() > o1.getNumOfGoalsDefended()) {
                return -1; //Not swapping if goals attacked is greater than goals defended
            } else {
                return 1; //Swapping if goals attacked is lower than goals defended
            }

        }
        return 1;
    }
}