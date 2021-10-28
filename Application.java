/** This application class will call the
 * classes in the Dictionary_ArrayList class and
 * will run them to print out an unsorted and
 * sorted Dictionary ArrayList.
 * 
 * 
 * @author morganhardin
 *
 */
public class Application 
{
	/** This main method creates a new instance of the
	 * Dictionary_ArrayList class and uses this to
	 * call the various methods in that class to return 
	 * the sorted and unsorted ArrayList.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Dictionary_ArrayList dictionary = new Dictionary_ArrayList();
		System.out.println("Unsorted List with Half of the Words: ");
		dictionary.scanFirstHalf_KeyValue();
		dictionary.Return();
		System.out.println("\nSorted List with all of the Words: ");
		dictionary.sort();
	}
}
