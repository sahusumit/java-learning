package org.example.LLDSystemDesigns.DesignTicTacToe;

import org.springframework.data.util.Pair;

import java.util.*;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initialize();
    }

    public void  initialize(){
        players = new LinkedList<>();
        PlayingPieceX  crossPiece = new PlayingPieceX();
        Player player1 = new Player("Ram", crossPiece);

        PlayingPieceO roundPiece = new PlayingPieceO();
        Player player2 = new Player("Shyam", roundPiece);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player playerTurn  = players.removeFirst();

            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty()){
                noWinner = false;
                continue;
            }


            System.out.println("Player: "+ playerTurn.name + "  Enter row and column: ");
            Scanner sc = new Scanner(System.in);
            String s  = sc.nextLine();
            String[] value = s.split(",");
            int inputRow = Integer.valueOf(value[0]);
            int inputColumn = Integer.valueOf(value[1]);


            boolean pieceAddSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.piece);
            if(!pieceAddSuccessfully){
                System.out.println("Player can not insert the piece into cell, please choose another cell");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean isWinner = isThereWinner(inputRow, inputColumn, playerTurn.piece.pieceType);
            if(isWinner){
                return playerTurn.name;
            }
        }
        return "draw";
    }

    private boolean isThereWinner(int inputRow, int inputColumn, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonal = true;

        for(int i=0; i<gameBoard.size; i++){
            if(gameBoard.board[inputRow][i] == null || gameBoard.board[inputRow][i].pieceType != pieceType){
                rowMatch = false;
                break;
            }
        }
        for(int i=0; i<gameBoard.size; i++){
            if(gameBoard.board[i][inputColumn]==null|| gameBoard.board[i][inputColumn].pieceType != pieceType){
                colMatch = false;
                break;
            }
        }
        //check diagonal
        for(int i=0, j=0; i<gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        //check  anti diagonal
        for(int i=0, j= gameBoard.size-1; i<gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonal = false;
                break;
            }
        }
        if(rowMatch || colMatch || diagonalMatch || antiDiagonal){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("Game winner is: "+ game.startGame());
    }
}
