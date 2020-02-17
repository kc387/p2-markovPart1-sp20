
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author KATHLEEN CHEN
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;
		int i = 0;
		// TODO: initialize myWords
		for(int k = start; k < size; k +=1) {
			myWords[i] = source[k];
			i += 1;
		}
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return int that is the size of the WordGram
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param o is an Object
	 * @return boolean value, true if WordGram object has the same strings in the same order as this object and false if they are not
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		// TODO: Complete this method
		WordGram wg = (WordGram) o;
		if(wg.length() != this.length()) {
			return false;
		}
		else if (!(wg == o)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		myHash = myWords.toString().hashCode();
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return new WordGram object with k entries (k is the order of the WordGram)
	 */
	public WordGram shiftAdd(String last) {

		// TODO: Complete this method
		String[] a = new String[myWords.length];
		for(int k = 0; k < myWords.length; k += 1) {
			if (k == myWords.length - 1){
				a[k] = last;
			}
			else {
				a[k] = this.myWords[k+1];
			}
		}
		WordGram wg = new WordGram(a,0,myWords.length);
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method
		String a = String.join(" ", myWords);
		return a;
	}
}
