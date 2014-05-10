package server.data_structures;

import java.io.Serializable;
import java.util.Collection;

public interface BasicHashAdapter<K, V> extends Serializable {

	/***
	 * Inserts the specified object at the specified key in the array.
	 * 
	 * @param key
	 * @param object
	 */
	public void insert(K key, V value);

	/***
	 * Adds the specified Collection at the end of the array.
	 * 
	 * @param collection
	 */
	public void addAll(Collection<? extends K> keys,
			Collection<? extends V> values);

	/**
	 * Remove all elements from the list.
	 */
	public void clear();

	/**
	 * 
	 * @return
	 */
	public int getCount();

	/**
	 * 
	 * @param key
	 * @return
	 */
	public V getItem(K key);

	/**
	 * 
	 * @param key
	 * @return
	 */
	public V remove(K key);

}
