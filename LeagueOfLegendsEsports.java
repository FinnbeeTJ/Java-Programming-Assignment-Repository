// Name: Teddy Jones
// Course: COP3330.26824
// Date: January 30, 2025
// Program Objective: This program demonstrates inheritance and polymorphism in Java using League of Legends esports teams.
// Inputs: The user will provide input for team win rates, player counts, and desired roster changes.
// Outputs: The program will print team information, calculated win percentages, and updated roster sizes.

import java.util.Scanner;

// Interface for esports teams
interface EsportsTeam {
    // Methods that all implementing classes must override
    double calculateWinPercentage(int wins, int losses);
    void updateRosterSize(int newPlayers);
}

// Parent class for esports teams
class Team implements EsportsTeam {
    // Attributes that all teams have
    private String teamName;
    private String region;
    private int playerCount;

    // Constructor
    public Team(String teamName, String region, int playerCount) {
        this.teamName = teamName;
        this.region = region;
        this.playerCount = playerCount;
    }

    // Getters and setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    // Method to calculate win percentage
    @Override
    public double calculateWinPercentage(int wins, int losses) {
        // Calculate and return win percentage
        if (wins + losses == 0) {
            return 0.0; // Avoid division by zero
        }
        return (double) wins / (wins + losses) * 100;
    }

    // Method to update roster size
    @Override
    public void updateRosterSize(int newPlayers) {
        // Update the player count
        this.playerCount += newPlayers;
    }

    // toString method
    @Override
    public String toString() {
        return "Team Name: " + teamName + ", Region: " + region + ", Player Count: " + playerCount;
    }
}

// Child class for LCS teams
class LCSTeam extends Team {
    private String franchiseCity;

    public LCSTeam(String teamName, String region, int playerCount, String franchiseCity) {
        super(teamName, region, playerCount);
        this.franchiseCity = franchiseCity;
    }

    public String getFranchiseCity() {
        return franchiseCity;
    }

    public void setFranchiseCity(String franchiseCity) {
        this.franchiseCity = franchiseCity;
    }

    @Override
    public double calculateWinPercentage(int wins, int losses) {
        double winPercentage = super.calculateWinPercentage(wins, losses);
        return winPercentage * 1.1; // LCS teams get a 10% bonus.
    }

    @Override
    public void updateRosterSize(int newPlayers) {
        super.updateRosterSize(newPlayers);
        if (getPlayerCount() > 10) {
            System.out.println("Warning: LCS teams typically have rosters of 10 or fewer players.");
        }
    }


    @Override
    public String toString() {
        return super.toString() + ", Franchise City: " + franchiseCity;
    }
}

// Child class for Academy teams
class AcademyTeam extends Team {
    private String parentTeam;

    public AcademyTeam(String teamName, String region, int playerCount, String parentTeam) {
        super(teamName, region, playerCount);
        this.parentTeam = parentTeam;
    }

    public String getParentTeam() {
        return parentTeam;
    }

    public void setParentTeam(String parentTeam) {
        this.parentTeam = parentTeam;
    }

    @Override
    public double calculateWinPercentage(int wins, int losses) {
        double winPercentage = super.calculateWinPercentage(wins, losses);
        return winPercentage * 0.9; // Academy teams have a slightly lower winrate.
    }

    @Override
    public void updateRosterSize(int newPlayers) {
        super.updateRosterSize(newPlayers);
        if (getPlayerCount() > 7) {
            System.out.println("Warning: Academy teams typically have rosters of 7 or fewer players.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Parent Team: " + parentTeam;
    }
}

public class LeagueOfLegendsEsports {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate objects of child classes
        LCSTeam lcsTeam1 = new LCSTeam("Cloud9", "NA", 7, "Los Angeles");
        LCSTeam lcsTeam2 = new LCSTeam("Team Liquid", "NA", 8, "Los Angeles");
        AcademyTeam academyTeam1 = new AcademyTeam("C9 Academy", "NA", 6, "Cloud9");
        AcademyTeam academyTeam2 = new AcademyTeam("TL Academy", "NA", 5, "Team Liquid");
        LCSTeam lcsTeam3 = new LCSTeam("100 Thieves", "NA", 9, "Los Angeles");


        // Add objects to an array of the parent class type
        Team[] teams = new Team[5];
        teams[0] = lcsTeam1;
        teams[1] = lcsTeam2;
        teams[2] = academyTeam1;
        teams[3] = academyTeam2;
        teams[4] = lcsTeam3;

        // Print information for each object
        for (Team team : teams) {
            System.out.println(team);
        }
        System.out.println();

        // Demonstrate polymorphism
        for (Team team : teams) {
            System.out.println("--- " + team.getTeamName() + " ---");

            System.out.print("Enter wins for " + team.getTeamName() + ": ");
            int wins = scanner.nextInt();
            System.out.print("Enter losses for " + team.getTeamName() + ": ");
            int losses = scanner.nextInt();
            double winPercentage = team.calculateWinPercentage(wins, losses);
            System.out.println("Win Percentage: " + winPercentage + "%");


            System.out.print("Enter number of new players for " + team.getTeamName() + ": ");
            int newPlayers = scanner.nextInt();
            team.updateRosterSize(newPlayers);
            System.out.println("Updated " + team.getTeamName() + " Roster: " + team.getPlayerCount());
            System.out.println();
        }

        scanner.close();
    }
}