package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a simple electronic voting machine that allows
 * voters to cast votes for candidates and display election results.
 */
public class VotingMachine {
    private Map<String, Integer> candidateVotes;
    
    /**
     * Constructor for creating a new VotingMachine
     */
    public VotingMachine() {
        candidateVotes = new HashMap<>();
    }
    
    /**
     * Adds a new candidate to the voting machine
     */
    public void addCandidate(String name) {
        candidateVotes.put(name, 0);
    }
    
    /**
     * Casts a vote for the specified candidate
     * 
     * @param name The name of the candidate to vote for
     * @return true if the vote was successful, false if the candidate doesn't exist
     */
    public boolean castVote(String name) {
        if (!candidateVotes.containsKey(name)) {
            return false;  // Candidate doesn't exist
        }
        
        int currentVotes = candidateVotes.get(name);
        candidateVotes.put(name, currentVotes + 1);
        return true;
    }
    
    /**
     * Gets the name of the candidate with the most votes
     * In case of a tie, returns one of the winners
     * 
     * @return The name of the winning candidate and their vote count
     */
    public String getWinner() {
        if (candidateVotes.isEmpty()) {
            return "No candidates available";
        }
        
        String winner = null;
        int maxVotes = -1;
        
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}