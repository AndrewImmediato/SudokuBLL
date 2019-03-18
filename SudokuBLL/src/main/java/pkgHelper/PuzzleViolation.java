package pkgHelper;
//Comments to make the git submission work
import pkgEnum.ePuzzleViolation;
public class PuzzleViolation {
	private int iValue;
	private ePuzzleViolation ePuzzleViolation;
	public PuzzleViolation(pkgEnum.ePuzzleViolation ePuzzleViolation, int iValue) {
		this.ePuzzleViolation = ePuzzleViolation;
		this.iValue = iValue;
		
	}
	public ePuzzleViolation getePuzzleViolation() {
		return ePuzzleViolation;
	}
	public int getiValue() {
		return iValue;
	}
}

