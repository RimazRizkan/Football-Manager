public interface LeagueManager { //Creating an interface named as LeagueManager and adding the required methods
    public void addClub();
    public void deleteClub();
    public void clubStatistics();
    public void displayPremierLeagueTable();
    public void addPlayedMatch();
    public void saveToTextFile();
    public void loadFromTextFile();
    public abstract boolean runMenu();


}
