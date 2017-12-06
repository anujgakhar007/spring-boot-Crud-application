package com.example.service;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Test;
import com.example.repository.Demo2Repository;

@Service
public class Demo2Service {
	@Autowired
Demo2Repository demo2Repository;
	public void add(Test ob) {
	ob.setId();
System.out.println("ob"+ob);
		demo2Repository.save(ob);
	}
	public int update(Test obj){
	UUID  ids= (obj.getId());
	Test ob=demo2Repository.findOne(ids);
	if(ob!=null)
	{
	if (obj.getname()!=null){	
		System.out.println("new name"+obj.getname());
		System.out.println("ob"+ob);
		ob.setname(obj.getname());
	}
	if (obj.getsub()!=null){
	ob.setsub(obj.getsub());
	}
	if(obj.getsection()!=null){
 	ob.setsection(obj.getsection());
	}
	if(obj.getcollege()!=null){
	 	
	ob.setcollege(obj.getcollege());
 	}
	demo2Repository.save(ob);
	return 1;
	}
	else{
		System.out.println("no record found to update");
	return 0;
	}
	}
	public void delete(UUID id) {
		Test ob=demo2Repository.findOne(id);
		if(ob!=null)
		{
		demo2Repository.delete(id);
	}
		else{
			System.out.println("no record found to delete");
		}
	
	}
	}