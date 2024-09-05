/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.sudoku_solver.BFS;
import com.mycompany.sudoku_solver.Board;
import com.mycompany.sudoku_solver.Cell;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dennisgahm
 */
public class UnitTest1 {
    
    public UnitTest1() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void checkBoardClone() {
        Board board = new Board("061304800000060514429085300000753082000008003000400001904531070250009000010807045");
        Board board2 = board.cloneBoard();
        
        assertEquals(board2.boardToString(), board.boardToString());
    }
    
    
    @Test
    public void checkGetCol() {
        
        Board board = new Board("061304800000060514429085300000753082000008003000400001904531070250009000010807045");
        String col0 = "004000920";
        String col4 = "068500300";
        
        Cell[] cells0 = board.getCol(0);
        Cell[] cells4 = board.getCol(4);
        
        String testCol0 = "";
        String testCol4 = "";
        for (int i = 0; i < 9; i++) {
            testCol0 += cells0[i].value;
            testCol4 += cells4[i].value;
        }
        
        
        assertEquals(col0, testCol0);
        assertEquals(col4, testCol4);
    }
    
    @Test
    public void checkGetRow() {
        
        //col is actually row
        Board board = new Board("061304800000060514429085300000753082000008003000400001904531070250009000010807045");
        String col0 = "061304800";
        String col4 = "000008003";
        
        Cell[] cells0 = board.getRow(0);
        Cell[] cells4 = board.getRow(4);
        
        String testCol0 = "";
        String testCol4 = "";
        for (int i = 0; i < 9; i++) {
            testCol0 += cells0[i].value;
            testCol4 += cells4[i].value;
        }
        
        
        assertEquals(col0, testCol0);
        assertEquals(col4, testCol4);
    }
    
    @Test
    public void checkRegion1() {
        Board board = new Board("061304800000060514429085300000753082000008003000400001904531070250009000010807045");
        
        //061 304 800
        //000 060 514
        //429 085 300
        
        //000 753 082
        //000 008 003
        //000 400 001
        
        //904 531 070
        //250 009 000
        //010 807 045
        
        //region 0
        String reg0 = "061000429";
        String reg1 = "304060085";
        String reg2 = "800514300";
        String reg3 = "000000000";
        String reg4 = "753008400";
        String reg5 = "082003001";
        String reg6 = "904250010";
        String reg7 = "531009807";
        String reg8 = "070000045";
        
        Cell[] cells0 = board.getRegion(0);
        Cell[] cells1 = board.getRegion(1);
        Cell[] cells2 = board.getRegion(2);
        Cell[] cells3 = board.getRegion(3);
        Cell[] cells4 = board.getRegion(4);
        Cell[] cells5 = board.getRegion(5);
        Cell[] cells6 = board.getRegion(6);
        Cell[] cells7 = board.getRegion(7);
        Cell[] cells8 = board.getRegion(8);
        
        
        Cell[] cells0a = board.getRegion2(0);
        Cell[] cells1a = board.getRegion2(1);
        Cell[] cells2a = board.getRegion2(2);
        Cell[] cells3a = board.getRegion2(3);
        Cell[] cells4a = board.getRegion2(4);
        Cell[] cells5a = board.getRegion2(5);
        Cell[] cells6a = board.getRegion2(6);
        Cell[] cells7a = board.getRegion2(7);
        Cell[] cells8a = board.getRegion2(8);
        
        String testReg0 = "";
        String testReg1 = "";
        String testReg2 = "";
        String testReg3 = "";
        String testReg4 = "";
        String testReg5 = "";
        String testReg6 = "";
        String testReg7 = "";
        String testReg8 = "";
        for (int i = 0; i < 9; i++) {
            testReg0 += cells0[i].value;
            testReg1 += cells1[i].value;
            testReg2 += cells2[i].value;
            testReg3 += cells3[i].value;
            testReg4 += cells4[i].value;
            testReg5 += cells5[i].value;
            testReg6 += cells6[i].value;
            testReg7 += cells7[i].value;
            testReg8 += cells8[i].value;
        }
        
        
        String testReg0a = "";
        String testReg1a = "";
        String testReg2a = "";
        String testReg3a = "";
        String testReg4a = "";
        String testReg5a = "";
        String testReg6a = "";
        String testReg7a = "";
        String testReg8a = "";
        for (int i = 0; i < 9; i++) {
            testReg0a += cells0a[i].value;
            testReg1a += cells1a[i].value;
            testReg2a += cells2a[i].value;
            testReg3a += cells3a[i].value;
            testReg4a += cells4a[i].value;
            testReg5a += cells5a[i].value;
            testReg6a += cells6a[i].value;
            testReg7a += cells7a[i].value;
            testReg8a += cells8a[i].value;
        }
        
        assertEquals(reg0, testReg0);
        assertEquals(reg1, testReg1);
        assertEquals(reg2, testReg2);
        assertEquals(reg3, testReg3);
        assertEquals(reg4, testReg4);
        assertEquals(reg5, testReg5);
        assertEquals(reg6, testReg6);
        assertEquals(reg7, testReg7);
        assertEquals(reg8, testReg8);
        
        assertEquals(reg0, testReg0a);
        assertEquals(reg1, testReg1a);
        assertEquals(reg2, testReg2a);
        assertEquals(reg3, testReg3a);
        assertEquals(reg4, testReg4a);
        assertEquals(reg5, testReg5a);
        assertEquals(reg6, testReg6a);
        assertEquals(reg7, testReg7a);
        assertEquals(reg8, testReg8a);
    }
        
    @Test
    //check if getRow allows you to get a reference to the Cell and mutate the original board.
    public void testMutation() {
        Board board = new Board("061304800000060514429085300000753082000008003000400001904531070250009000010807045");
        //061 304 800
        //000 060 514
        //429 085 300
        
        //000 753 082
        //000 008 003
        //000 400 001
        
        //904 531 070
        //250 009 000
        //010 807 045
        Cell[] cells = board.getRow(0);
        cells[0].value = 9;
        assertEquals(board.cells[0][0].value, 9);
        
        
        cells = board.getCol(0);
        cells[1].value = 5;
        assertEquals(board.cells[1][0].value, 5);
        
        
        cells = board.getRegion(0);
        cells[1].value = 4;
        assertEquals(board.cells[0][1].value, 4);
        
        
        cells = board.getRegion2(0);
        cells[2].value = 3;
        assertEquals(board.cells[0][2].value, 3);
        
    }
}
