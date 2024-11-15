/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sudoku_solver;

/**
 *
 * @author dennisgahm
 */
public class Sudoku_Solver {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //061304800
        //000060514
        //429085300
        //000753082
        //000008003
        //000400001
        //904531070
        //250009000
        //010807045
        Board board = new Board("061304800000060514429085300000753082000008003000400001904531070250009000010807045");
        
        //board.removePossibilities();
        //System.out.println(board.boardToString());
        AStarSearch bfs = new AStarSearch(board);
        Board solved = bfs.solve();
        
        System.out.println(solved.boardToString());
        
    }
}
