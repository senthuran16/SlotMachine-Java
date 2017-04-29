package CourseWork2;

// represents each symbol
public class Symbol implements ISymbol {

	// path of the symbol's image
	private String image;
	// value for this symbol
	private int value;

	/**
	 * creates a symbol object with image path and value
	 * 
	 * @param image
	 *            : path of image
	 * @param value
	 *            : score of symbol
	 */
	public Symbol(String image, int value) {
		this.image = image;
		this.value = value;
	}

	@Override
	public void setImage(String url) {
		this.image = url;

	}

	@Override
	public String getImage() {
		return this.image;

	}

	@Override
	public void setValue(int v) {
		this.value = v;

	}

	@Override
	public int getValue() {
		return this.value;
	}

	/**
	 * returns whether the values of this Symbol and Symbol s are equal or not
	 * 
	 * @param s
	 *            : Symbol object that is compared to this Symbol
	 * @return : true if both are of equal values
	 */
	public boolean equals(Symbol s) {
		return (this.value == s.value);
	}

}
