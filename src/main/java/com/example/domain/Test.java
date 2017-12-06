package com.example.domain;




import java.io.Serializable;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType;

@Table(value = "Test")
public class Test implements Serializable{
	
	 
		
		
@PrimaryKey
private UUID id;

private String name;
@Digits(integer = 8, fraction = 0)
private int salary;
@Digits(integer = 10, fraction = 0)  
private int mobile;
		private String sub;
	    
	    private String section;
	    private String college;
	  	   
	    
	    public int getsalary() {
	    	
	        return salary;
	    }
	    public void setmobile(int mobile) {
	    	System.out.println("inside mobile");
	        this.mobile = mobile;
	    }
public int getmobile() {
	    	
	        return mobile;
	    }
	    public void setsalary(int salary) {
	    	System.out.println("inside salary");
	        this.salary = salary;
	    }
	    
	    public String getname() {
	    	
	        return name;
	    }
	    public void setname(String name) {
	    	System.out.println("inside name");
	    	this.name = name;
	    	
	    	
	    }
	  
	    public String getsection() {
	        return section;
	    }
	    
	   
	    public void setsection(String section) {
	        this.section = section;
	    }

	    public void setId() {
	        this.id = UUID.randomUUID();
	        System.out.println("inside uuid");
	    }
	    public UUID getId() {
	        return id;
	    }
	   
	    public String getsub() {
	        return sub;
	    }
	    public void setsub(String sub) {
	        this.sub = sub;
	    }
	    public String getcollege() {
	        return college;
	    }
	    public void setcollege(String college) {
	        this.college = college;
	    }   
	  

	    @Override
		public String toString() {
			return "" + this.name + " " + this.id+ " " + this.section + " "+ this.sub+" "+this.college;
		}
}