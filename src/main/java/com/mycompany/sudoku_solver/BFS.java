/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku_solver;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author dennisgahm
 */
public class BFS {
    Board board;
    Board initialBoard;
    Queue<Board> queue = new LinkedList<>();
    
    public BFS(Board board) {
        this.board = board;
        initialBoard = board.cloneBoard();
    }
    
    public Board solve() {
        if (initialBoard == null)
            return null;
        
        //expand node
        //add to queue
        queue.add(board);
        
        boolean solved = false;
        Board expanded = null;
        while (!solved) {
            expanded = expandNode();
            if (expanded == null)
                break;
            if (expanded.IsComplete())
                solved = true;
        }
        
        return expanded;
    }
    
    public Board expandNode() {
        if (queue.isEmpty())
            return null;
        
        Board expanded = queue.remove();
        
        
        boolean cellExpanded = false;
        for (int i = 0; i < 9; i++) {
            if (cellExpanded)
                break;
            for (int i2 = 0; i2 < 9; i2++) {
                
                if (cellExpanded)
                    break;
                Board current = expanded.cloneBoard();
                //check if cell has possibilities
                //try all possibilities of the current cell
                Cell cell = current.cells[i][i2];
                
                //***This is where different methods can occur:
                    //1) Choose cell, then DFS
                    //2) choose all cells, then BFS
                //search possibilities
                
////                Method 2:
//                for (int i3 = 0; i3 < 9; i3++) {
//                    if (cell.possibilities[i3]) {
//                        cell.value = i3 + 1;
//                        queue.add(current);
//                    }
//                    break;
//                }
                
                //Method 1:
                for (int i3 = 0; i3 < 9; i3++) {
                    if (cell.possibilities[i3]) {
                        cell.value = i3 + 1;
                        queue.add(current);
                        cellExpanded = true;
                    }
                    break;
                }
            }
        }
        
        return expanded;
    }
    
}
