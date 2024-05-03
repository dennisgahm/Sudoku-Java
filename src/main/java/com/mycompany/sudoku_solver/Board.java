/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku_solver;

/**
 *
 * @author dennisgahm
 */
public class Board {
    Cell[][] cells;
    
    public boolean IsComplete() {
        for (int i = 0; i < 8; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (cells[i][i2].value == 0)
                    return false;
            }
        }
        return IsConsistent();
    }
    
    public boolean IsConsistent() {
        for (int i = 0; i < 8; i++) {
            Cells[] c = this.getRegion(i);
        }
    }
}
