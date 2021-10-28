/** These import the java io and util files so that
 * they can be used in this class.
 * 
 */
import java.io.*;
import java.util.*;

/** This class creates a dictionary ArrayList and reads
 * two files and takes the key and value from each line
 * and puts half of the words into the ArrayList. It then 
 * sorts the ArrayList and adds the rest and the words 
 * into the list and returns the ArrayList.
 * 
 * @author morganhardin
 *
 */
public class Dictionary_ArrayList
{
	/** These private variables create an ArrayList called
	 * myList with the object KeyValue. It also initializes
	 * length, length2, and index as integers.
	 * 
	 */
	private ArrayList<KeyValue> myList = new ArrayList<>();
	@SuppressWarnings("unused")
	private int length, length2, index;
	
	/** This empty constructor sets this myList equal to
	 * a new ArrayList of type KeyValue. It also sets length
	 * and ength2 equal to 0 and index equal to 1. 
	 * 
	 */
	Dictionary_ArrayList()
	{
		this.myList = new ArrayList<KeyValue>();
		length = 0;
		length2 = 0;
		index = 1;
	}
	/** This addDictionary class takes the KeyValue 
	 * object parameter keyValue and uses the built
	 * in add method from the ArrayList to add the
	 * keyValue inputed parameter into the myList
	 * ArrayList.
	 * 
	 * @param keyValue
	 */
	void addDictionary(KeyValue keyValue)
	{
		myList.add(keyValue);
	}
	/** This void method scans two files, a key word file
	 * and a value file. It then keeps track of the length 
	 * of the ArrayList and adds the scanned in strings into
	 * myList by calling the addDictionary class. This method
	 * also has a try catch block to throw an exception
	 * if a file is not found.
	 * 
	 */
	@SuppressWarnings("resource")
	void scanFirstHalf_KeyValue()
	{
		try
		{
			FileReader keyFile = new FileReader("Key_Words.txt");
			FileReader valueFile = new FileReader("Values.txt");
			Scanner scan = new Scanner(keyFile);
			Scanner scan2 = new Scanner(valueFile);
				
			while (scan.hasNextLine() && scan2.hasNextLine())
			{
				addDictionary(new KeyValue(scan.nextLine(), scan2.nextLine()));
				length++;
			}
			length2 = length/2;
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("File Not Found.");
		}
	}
	/** This void method creates two new ArrayLists with
	 * object String that are used to copy the keys and
	 * values from myList in order to sort them. A for
	 * loop is then used to loop through the array to
	 * print the sorted ArrayLists.
	 * 
	 */
	public void sort()
	{
		ArrayList<String> key = new ArrayList<>();
		ArrayList<String> value = new ArrayList<>();
		for (KeyValue kv : myList)
		{
			key.add(kv.getKey());
			value.add(kv.getValue());
		}
		key.sort(String::compareToIgnoreCase);
		for (int i = 0; i < key.size(); i++)
		{
			System.out.println(i+1 + ") " + key.get(i) + ": " + value.get(i));
		}
	}
	/** This void method loops through the ArrayList myList with a for
	 * each loop. Inside the loop, there is an if statement that determines
	 * if the index is less than half the full length of the array and
	 * will then print the list. If it is greater than half the length, 
	 * it will print the whole list. This separates the loop into two
	 * sections, one for the first half of myList and one for the rest
	 * of it.
	 * 
	 */
	public void Return()
	{
		for (KeyValue kv : myList)
		{
			if (index < length/2)
			{
				System.out.println(index + ") " + kv.getKey() + ": " + kv.getValue());
				index++;
			}
			else if (index > length)
			{
				System.out.println(index + ") " + kv.getKey() + ": " + kv.getValue());
				index++;
			}
		}
	}
	
	/** This is a private class that creates the
	 * object KeyValue.
	 * 
	 * @author morganhardin
	 *
	 */
	private static class KeyValue
	{
		/** These private variables instantiate
		 * key and value as strings.
		 * 
		 */
		private String key, value;
		
		/** This empty constructor sets key and 
		 * value equal.
		 * 
		 */
		private KeyValue()
		{
			key = "";
			value = "";
		}
		/** This preferred constructor takes
		 * two string parameters key and
		 * value and set them equal to
		 * this key and this value.
		 * 
		 * @param key
		 * @param value
		 */
		private KeyValue(String key, String value)
		{
			this.key = key;
			this.value = value;
		}
		/** This getter method returns the string, value.
		 * 
		 * @return
		 */
		public String getValue() 
		{
			return value;
		}
		/** This getter method returns the string, key.
		 * 
		 * @return
		 */
		public String getKey() 
		{
			return key;
		}
	}
}
