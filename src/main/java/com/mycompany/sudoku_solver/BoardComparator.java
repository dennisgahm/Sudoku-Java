/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku_solver;

import java.util.Comparator;

/**
 *
 * @author dennis
 */
public class BoardComparator implements Comparator<Board> {
    @Override
    public int compare(Board b1, Board b2) {
        return Double.compare(b1.evaluateHeuristic(), b2.evaluateHeuristic());
    }
}
