package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SudokuTest{
    
    @Test
    public void TestPuzzle() {
        int[][] puzzle = {{1,2,3,4,5,6,7,8,9},
                          {2,3,4,5,6,7,8,9,1},
                          {3,4,5,6,7,8,9,1,2},
                          {4,5,6,7,8,9,1,2,3},
                          {5,6,7,8,9,1,2,3,4},
                          {6,7,8,9,1,2,3,4,5},
                          {7,8,9,1,2,3,4,5,6},
                          {8,9,1,2,3,4,5,6,7},
                          {9,1,2,3,4,5,6,7,8}};
        int[]iRegionValuesExpected = {1,2,3,2,3,4,3,4,5};
        int[]iRegionValuesActual;
        Puzzle p = new Puzzle(puzzle);                        
        try {
            iRegionValuesActual = p.getRegion(0);
            assertTrue(Arrays.equals(iRegionValuesActual,iRegionValuesExpected));
        }
        catch(Exception e1) {
            e1.printStackTrace();
        }
    }
    @Test(expected = Exception.class)
    public void TestSmallPuzzleException() throws Exception{
        int[][] puzzle = {{1,2,3,4,5,6,7,8,9},
                          {2,3,4,5,6,7,8,9,1},
                          {3,4,5,6,7,8,9,1,2},
                          {4,5,6,7,8,9,1,2,3},
                          {5,6,7,8,9,1,2,3,4},
                          {6,7,8,9,1,2,3,4,5},
                          {7,8,9,1,2,3,4,5,6},
                          {8,9,1,2,3,4,5,6,7},
                          {9,1,2,3,4,5,6,7,8}};
        Puzzle p = new Puzzle(puzzle);
        int[] iRegionValues = null;
        iRegionValues = p.getRegion(2);
        System.out.println(Arrays.toString(iRegionValues));
    }
}