/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku_solver;

/**
 *
 * @author dennisgahm
 */
public class Cell {
    public boolean[] possibilities = new boolean[9];
    public boolean[] cant_be = new boolean[9];
    public int value = -1;
    public int row = -1;
    public int col = -1;
    public int reg = -1;
    
    public Cell(int v, int r, int c, int reg) {
        value = v;
        row = r;
        col = c;
        this.reg = reg;
    }
}
