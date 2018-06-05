package day08;

import java.io.Serializable;
import java.util.Date;

public class Content implements Serializable{
	int id;
	Date time;
	String name ;
	String mobile;
	transient String address;
	
	public Content(int id, Date time, String name, String mobile, String address) {
		this.id = id;
		this.time = time;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}

	@Override
	public String toString() {
		return id+","+time+","+name+","+mobile+","+address;
		
	}
	
}
