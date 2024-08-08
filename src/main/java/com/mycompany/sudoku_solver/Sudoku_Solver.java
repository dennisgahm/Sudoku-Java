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
        
        Board board = new Board("061304800000060514429085300000753082000008003000400001904531070250009000010807045");
        
        BFS bfs = new BFS(board);
        Board solved = bfs.solve();
        
        System.out.println(solved.boardToString());
        
    }
}
