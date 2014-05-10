package server.data_structures;

import java.util.Collection;

public interface BasicArrayAdapter<T> extends Comparable<T> {

	/***
	 * Adds the specified object at the end of the array
	 * 
	 * @param t
	 */
	public void add(T t);

	/***
	 * Adds the specified Collection at the end of the array.
	 * 
	 * @param collection
	 */
	public void addAll(Collection<? extends T> collection);

	/**
	 * Adds the specified items at the end of the array.
	 * 
	 * @param items
	 */
	public void addAll(@SuppressWarnings("unchecked") T... items);

	/**
	 * Remove all elements from the list.
	 */
	public void clear();

	/**
	 * 
	 * @return
	 */
	public int getCount();

	public T getItem(int position);

	/***
	 * Inserts the specified object at the specified index in the array.
	 * 
	 * @param object
	 * @param index
	 */
	public void insert(T object, int index);

}
