/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku_solver;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The way A Star Search works:
 * When the search expands a node, it has children
 * The children are each given a heuristic evaluation value
 * A priority queue organizes the children
 * 
 * 
 * @author dennisgahm
 */
public class AStarSearch {
    Board board;
    Board initialBoard;
    PriorityQueue<Board> queue = new PriorityQueue<>(new BoardComparator());
    
    public AStarSearch(Board board) {
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
        int count = 0;
        while (!solved) {
            expanded = expandNode();
            count++;
            if (count % 10000 == 0) 
                System.out.println(count + "");
            if (expanded != null)
                System.out.println(expanded.boardToString());
            
            if (expanded == null)
                continue;
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
                //hack method
                int row = -1;
                int col = -1;
                int numPossibilities = 100;
                for (int i3 = 0; i3 < 9; i3++) {
                    for (int i4 = 0; i4 < 9; i4++) {
                        Cell c1 = current.cells[i3][i4];
                        if (c1.value != 0)
                            continue;
                        int count = 0;
                        for (int i5 = 0; i5 < 9; i5++) {
                            if (c1.possibilities[i5])
                                count++;
                        }
                        
                        if (count < numPossibilities) {
                            row = i3;
                            col = i4;
                        }
                    }
                }
                
                if (row != -1) {
                    
                    for (int i6 = 0; i6 < 9; i6++) {
                        Board clone = current.cloneBoard();
                        if (clone.cells[row][col].possibilities[i6] && 
                                !clone.cells[row][col].cant_be[i6]) {
                            
                            clone.cells[row][col].value = i6 + 1;
                            clone.cells[row][col].cant_be[i6] = true;
                            clone.cells[row][col].possibilities[i6] = false;
                            

                            System.out.println("value: " + clone.cells[row][col].value);
                            System.out.println("row: " + row);
                            System.out.println("col: " + col);
                            
                            //clone.removePossibilities();
                            queue.add(clone);
                            cellExpanded = true;
                        }
                    }
                    
                }
                if (cellExpanded)
                    break;
            }
        }
        
        return expanded;
    }
    
}
