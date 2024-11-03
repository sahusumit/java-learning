package org.example.LLDSystemDesigns.DesignTicTacToe;

import org.springframework.data.util.Pair;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][]  board;
   public Board(int size){
        this.size = size;
       board = new PlayingPiece[size][size];
    }

    public  boolean addPiece(int row, int col, PlayingPiece piece){
       if(board[row][col]!=null){
           return false;
       }
       board[row][col] = piece;
       return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells(){
       List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for(int i=0;i<size; i++){
            for(int j=0; j<size; j++){
             if(board[i][j]==null){
                 Pair<Integer, Integer> rowColumn = Pair.of(i, j);
                 freeCells.add(rowColumn);
             }
            }
            System.out.println();
        }
        return freeCells;
    }

    public void printBoard(){
       for(int i=0;i<size; i++){
           for(int j=0; j<size; j++){
               if(board[i][j]!=null){
                   System.out.print(" "+board[i][j].pieceType +" | ");
               }else {
                   System.out.print("   | ");
               }
           }
           System.out.println();
       }
    }
}
