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
    public Cell[][] cells; 
    
    public Board(Cell[][] cells) {
        this.cells = cells;
    }
    
    public Board() {
        this.cells = new Cell[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int i2 = 0; i2 < 9; i2++) {
                int reg = (i % 3) + ((int) (i / 3)) * 3;
                cells[i][i2] = new Cell(i, i2, reg);
            }
        }
    }
    
    public Board(String str) {
        this.cells = new Cell[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int i2 = 0; i2 < 9; i2++) {
                int value = Character.getNumericValue(str.charAt(i * 9 + i2));
                int reg = 0;
                reg = ((i2 / 3) % 3) + ((int) (i / 3)) * 3;
                cells[i][i2] = new Cell(value, i, i2, reg);
            }
        }
    }
    
//row] [col]
        public boolean IsComplete() {
        for (int i = 0; i < 9; i++) {
            for (int i2 = 0; i2 < 9; i2++) {
                if (cells[i][i2].value == 0)
                    return false;
            }
        }
        return IsConsistent();
    }
    
    public boolean IsSectionConsistent(Cell[] c) {
        boolean[] arr = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (c[i].value == 0)
                return false;
            arr[c[i].value - 1] = true;
        }
        
        for (int i = 0; i < 9; i++) {
            if (arr[i] == false) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean IsConsistent() {
        
        //check regions
        for (int i = 0; i < 9; i++) {
            Cell[] c = this.getRegion(i);
            if (!IsSectionConsistent(c))
                return false;
        }
        
        //check rows
        for (int i = 0; i < 9; i++) {
            Cell[] c = this.getRow(i);
            if (!IsSectionConsistent(c))
                return false;
        }
        
        //check cols
        for (int i = 0; i < 9; i++) {
            Cell[] c = this.getCol(i);
            if (!IsSectionConsistent(c))
                return false;
        }
        
        return true;
    }
    
    public Cell[] getRow(int i) {
        
        return cells[i];
    }
    
    public Cell[] getCol(int i) {
        
        Cell[] col = new Cell[9];
        
        for (int i2 = 0; i2 < 9; i2++) {
            col[i2] = cells[i2][i];
        }
        
        return col;
    }
    
    
    public Cell[] getRegion(int i) {
        int col = i % 3;
        int row = i / 3;
        
        int startCol = col * 3;
        int startRow = row * 3;
        
        int indexCol = startCol;
        int indexRow = startRow;
        
        Cell[] region = new Cell[9];
        
        for (int i2 = 0; i2 < 9; i2++) {
                indexCol = startCol + (i2 % 3);
            if ((i2 % 3) == 0 && i2 != 0) {
                indexRow++;
            }
            region[i2] = cells[indexRow][indexCol];
        }
        
        return region;
    }
    
    public Cell[] getRegion2(int i) {
        
        int size = 0;
        Cell[] region = new Cell[9];
        
        for (int i1 = 0; i1 < 9; i1++) {
            for (int i2 = 0; i2 < 9; i2++) {
                if (cells[i1][i2].reg == i) {
                    region[size] = cells[i1][i2];
                    size++;
                }
            }
        }
        
        return region;
    }
    
    public Board cloneBoard() {
        Cell[][] cellsClone = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int i2 = 0; i2 < 9; i2++) {
                cellsClone[i][i2] = cells[i][i2];
            }
        }
        
        return new Board(cellsClone);
        
    }
    
    public String boardToString()
    {
        String str = "";
        for (int i = 0; i < 9; i++) {
            for (int i2 = 0; i2 < 9; i2++) {
                str += Integer.toString(cells[i][i2].value);
            }
        }
        return str;
    }
}
