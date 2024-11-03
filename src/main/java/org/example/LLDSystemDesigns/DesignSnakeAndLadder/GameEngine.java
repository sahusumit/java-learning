package org.example.LLDSystemDesigns.DesignSnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class GameEngine {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;


    public GameEngine() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();

    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void startSnakeAndLadderGame() {
        while (winner == null) {
            Player player = findPlayerTurn();
            System.out.println("player turn is " + player.playerId + " current position is " + player.currentPosition);

            //role the dice
            int diceValue = dice.rollDice();
            int playerNewPosition = player.currentPosition + diceValue;
            playerNewPosition = jumpValid(playerNewPosition);
            player.currentPosition = playerNewPosition;
            System.out.println("player turn is " + player.playerId + " dice number: "+diceValue+ " new position is:  " + player.currentPosition);

            //check for winning condition
            if (playerNewPosition >= board.cells.length * board.cells.length - 1) {
                winner = player;
            }


        }
        System.out.println("Winner is: " + winner.playerId);
    }

    private int jumpValid(int playerNewPosition) {
        if (playerNewPosition > board.cells.length * board.cells.length - 1) {
            return playerNewPosition;
        }
        Cell cell = board.getCell(playerNewPosition);
        if (cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = cell.jump.start < cell.jump.end ? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.startSnakeAndLadderGame();
    }
}
