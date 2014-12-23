package org.mule.modules.helloworld;

public class Customer {
	
	private String id;
	private String name;
	private boolean isEnabled;
	
	public Customer(String id, String name, boolean isEnabled) {
		setId(id);
		setName(name);
		setEnabled(isEnabled);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
		
}
