package net.citizensnpcs.adventures.util.debug;


public enum Language {
	ERROR("Error"),
	CONFIG_RELOAD("Reloading configuration..."),
	INFORMATION("Info"),
	RELOAD("Reloading plugin configuration and dialog files...");
	
	
	private String msg;
	
	Language( String message ) {
		this.msg = message;
	}
	
	@Override
	public String toString() {
		return msg;
	}
	
	public String toUpperCase() {
		return toString().toUpperCase();
	}
}
