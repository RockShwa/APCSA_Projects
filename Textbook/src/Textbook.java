// This is practice for the AP Exam that was done in class
// Do not use this.super.method for stuff, it dosen't like it, also don't do <objectName>.super.method()
// It might be because you can use this() as a constructor

public class Textbook extends Book {
	private int editionNum;

	public Textbook (String bookTitle, double bookPrice, int edNum) {
		super(bookTitle, bookPrice);
		editionNum = edNum;

	}
	
	@Override
	// Only have to use super in overriden methods, but does not hurt to use otherwise
	public String getBookInfo() {
		return super.getBookInfo() + "-" + this.editionNum;
	}

	public int getEdition() {
		return editionNum;
	}

	public boolean canSubsituteFor(Textbook otherTextbook) {
		if ((this.getTitle().equals(otherTextbook.getTitle())) && (editionNum >= otherTextbook.editionNum)) { //can use getEdition() in TextBook to access too
			return true;
		}
		return false;
	}
}