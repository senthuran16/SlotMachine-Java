package CourseWork2;

public interface ISymbol {
	/**
	 * sets the image url of the symbol
	 * @param url : path of the symbol image
	 */
	public void setImage(String url);

	/**
	 * returns the image path of the symbol
	 * @return image path of symbol
	 */
	public String getImage();

	/**
	 * sets the score of the symbol
	 * @param v : score of the symbol
	 */
	public void setValue(int v);

	/**
	 * returns the score of the symbol
	 * @return score of the symbol 
	 */
	public int getValue();
}
