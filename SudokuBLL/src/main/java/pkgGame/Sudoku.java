package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;


//Comments to make the git submission work
public class Sudoku extends LatinSquare {

	private int iSize;
	private int iSqrtSize; 
	 
	public Sudoku(int iSize) throws Exception{
		
			//works only if there is an integer square root of isize
			if ((Math.sqrt(iSize)%1)!=0){
		
				throw new Exception("This does not have a whole number square root");
				
			}
			else {
			
				this.iSize=iSize;
				this.iSqrtSize= (int) Math.sqrt(iSize);
			}
	}
		
	
	public Sudoku ( int[][] puzzle) throws Exception {
		super(puzzle);
		this.iSize= puzzle.length;
		
			//works only if there is an integer square root of isize
			if ((Math.sqrt(iSize)%1)!=0){
		
				throw new Exception ("The length of the puzzle dos not have a whole number squar root");
			}
			else 
			{
			iSqrtSize= (int) Math.sqrt(iSize);
			}
		
		
		}
		
		
		
	protected int[][] getPuzzle() {
		return super.getLatinSquare();
	   //not sure why this is returning a type error 
		
	    }
	    
	 
	 
	 	int [][] puzzle = this.getPuzzle();
	 	
	    public int[] getRegion (int iRow, int iCol) throws Exception{
	    	
	    	if (iCol>= iSize || iRow>= iSize) {
    		        throw new Exception ("Region Index Out of Bounds");}
	    	else{
	        int iSize = puzzle.length;
	        int iSizeSqrt = (int) Math.sqrt(iSize);
	        int i = (iCol/ iSizeSqrt) + ((iRow / iSizeSqrt) * iSizeSqrt);
	        return getRegion(i);
	    	}
	    }
	    
	    protected int[] getRegion (int r) throws Exception {
	        int[] myRegion = new int[puzzle.length];
	        int index = 0;
	        int iSize = puzzle.length;
	        int iSizeSqrt= (int) Math.sqrt(iSize);
	        if (r>= iSize)
	            throw new Exception ("Region Index Out of Bounds");
	        for (int iRow = (r/ iSizeSqrt)* iSizeSqrt; iRow < (((r/iSize) +1)* iSizeSqrt);iRow++) {
	            for (int iCol = (r % iSizeSqrt) * iSizeSqrt; iCol < (((r % iSizeSqrt) +1 )* iSizeSqrt); iCol++) {
	                myRegion[index++] = puzzle[iRow][iCol];
	            }
	        }
	        return myRegion; 
	    }
	
	    
	    @Override
	    public boolean hasDuplicates(int[] puzzle) {
			boolean hasDuplicates = false;
			int[] sortedArray = Arrays.copyOf(puzzle, puzzle.length);
			Arrays.sort(sortedArray);

			for (int i = 0; i < sortedArray.length - 1; i++) {
				if (sortedArray[i] == sortedArray[i + 1]) {
					hasDuplicates = true;
					break;
				}
			}
			return hasDuplicates;
		}
   

public boolean isPartialSudoku() {

	//ignore zeroes code
	//checks for dupes in region,rows,columns
	super.setbIgnoreZero(true);
	
	int[]iRow;
	int[]iCol;
	int[] iRegion;
	for (int i=0; i<iSize; i++) {
		iRow=super.getRow(i);
		iCol=super.getColumn(i);
		iRegion= this.getRegion(i);
		
		if (super.hasDuplicates(iRegion)==true){
			return false;
		}
		
		if (super.hasDuplicates(iRow)==true){
			return false;
		}
		if (super.hasDuplicates(iCol)==true){
			return false;
		}
		
	
}
	return true;
}


public boolean isSudoku() {

	//ignore zeroes code
	//checks for dupes in region,rows,columns
	super.setbIgnoreZero(false);
	
	if (super.ContainsZero()){
		return false;
	}
	
	int[]iRow;
	int[]iCol;
	int[] iRegion;
	for (int i=0; i<iSize; i++) {
		iRow=super.getRow(i);
		iCol=super.getColumn(i);
		iRegion= this.getRegion(i);
		
		if (super.hasDuplicates(iRegion)==true){
			return false;
		}
		
		if (super.hasDuplicates(iRow)==true){
			return false;
		}
		if (super.hasDuplicates(iCol)==true){
			return false;
		}
		
	
}

	return true;
}


protected boolean isValidValue(int iCol, int iRow, int iValue) throws Exception{
    boolean isValidValue = false;
    if (iValue > 0 || iValue < iSize) {
        isValidValue = true;
    }
    else {
        int[] value = {iValue};
        if (hasAllValues(super.getRow(iRow), value) == true ||
                hasAllValues(super.getColumn(iCol), value) == true||
                hasAllValues(getRegion(iCol, iRow), value) == true) {
            isValidValue = false;
            
    }
    }
    return isValidValue;
}	
	

}