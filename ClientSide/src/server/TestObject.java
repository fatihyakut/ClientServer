package server;

import java.io.Serializable;

public class TestObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 171252148885095455L;

	private String name;
	private int age;

	public TestObject() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ýsim : " + this.name + ", Yas : " + this.getAge();
	}

}
