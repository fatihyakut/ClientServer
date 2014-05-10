package server.data_structures;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;

public interface ArrayAdapter<T> extends Serializable {

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

	/**
	 * Returns the position of the specified item in the array.
	 * 
	 * @param item
	 * @return
	 */
	public int getPosition(T item);

	/**
	 * Sorts the content of this adapter using the specified comparator.
	 * 
	 * @param comparator
	 */
	public void sort(Comparator<? super T> comparator);

	/**
	 * Removes the specified object from the array.
	 * 
	 * @param object
	 * @return
	 */
	public void remove(T object);

	/**
	 * Removes the specified object from the array.
	 * 
	 * @param index
	 * @return
	 */
	public void remove(int index);

	/***
	 * Inserts the specified object at the specified index in the array.
	 * 
	 * @param object
	 * @param index
	 */
	public void insert(T object, int index);

}
