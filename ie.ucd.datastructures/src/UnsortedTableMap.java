import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of a map using an unsorted table.
 */

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
	/** Underlying storage for the map of entries. */
	private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

	/** Constructs an initially empty map. */
	public UnsortedTableMap() {
	}

	// private utility
	/** Returns the index of an entry with equal key, or -1 if none found. */
	private int findIndex(K key) {
		int length = table.size(); 
		//iterate over the table until you find a match 
		for (int i = 0; i < length; i++) {
			if (table.get(i).getKey().equals(key)) { return i; }
		}
		
		//if there is no match, return -1
		return -1;
	}

	// public methods
	/**
	 * Returns the number of entries in the map.
	 * 
	 * @return number of entries in the map
	 */
	@Override
	public int size() {
		return table.size();
	}

	/**
	 * Returns the value associated with the specified key, or null if no such entry
	 * exists.
	 * 
	 * @param key the key whose associated value is to be returned
	 * @return the associated value, or null if no such entry exists
	 */
	@Override
	public V get(K key) {
		int index = findIndex(key); 
		
		//if no element was found corresponding to the key, return null
		if (index == -1) {
			return null; 
		}
		
		return table.get(index).getValue(); 
	}

	/**
	 * Associates the given value with the given key. If an entry with the key was
	 * already in the map, this replaced the previous value with the new one and
	 * returns the old value. Otherwise, a new entry is added and null is returned.
	 * 
	 * @param key   key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with the key (or null, if no such
	 *         entry)
	 */
	@Override
	public V put(K key, V value) {
		int index = findIndex(key); 
		 
	    if (index != -1) {
	    	return table.get(index).setValue(value); 
	    }
	    else {
	    	table.add(new MapEntry<>(key, value));
	    }
	    return null; 
	}

	/**
	 * Removes the entry with the specified key, if present, and returns its value.
	 * Otherwise does nothing and returns null.
	 * 
	 * @param key the key whose entry is to be removed from the map
	 * @return the previous value associated with the removed key, or null if no
	 *         such entry exists
	 */
	@Override
	public V remove(K key) {
		int index = findIndex(key); 
		int length = table.size(); 
		
		//if there is no element at the specified location, return null\
		if (index == -1) { 
			return null; 
		}
		
		V toReturn = table.get(index).getValue(); 
		
		if (index != length-1) {
			table.set(index, table.get(length-1)); 
		}
		table.remove(length-1); 
	    
		return toReturn; 
	}

	// ---------------- nested EntryIterator class ----------------
	private class EntryIterator implements Iterator<Entry<K, V>> {
		private int key = 0;

		public boolean hasNext() {
			return key < table.size(); 
		}

		public Entry<K, V> next() {
			if (key == table.size()) {
				return null; //there is no 'next' entry
			}
			return table.get(key++); 
		}

		public void remove() {
			throw new UnsupportedOperationException("remove not supported");
		}
	} // ----------- end of nested EntryIterator class -----------

	// ---------------- nested EntryIterable class ----------------
	private class EntryIterable implements Iterable<Entry<K, V>> {
		public Iterator<Entry<K, V>> iterator() {
			return new EntryIterator();
		}
	} // ----------- end of nested EntryIterable class -----------

	/**
	 * Returns an iterable collection of all key-value entries of the map.
	 *
	 * @return iterable collection of the map's entries
	 */
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return new EntryIterable();
	}
	
	public String toString() {
		return table.toString();
	}
}