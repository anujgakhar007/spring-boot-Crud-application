package com.example.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Test;
import com.example.repository.Demo2Repository;
import com.example.service.Demo2Service;



@RestController
public class Demo2Controller {
	@Autowired
		Demo2Service demo2Service;

@RequestMapping(value="/insert",method=RequestMethod.POST)

ResponseEntity<Object> insert(  @RequestBody @Valid Test ob,BindingResult bindingResult){

	Map<String,String> map = new HashMap<String,String>();
	
	
	if (bindingResult.hasErrors()) {
		  map.put("error","input has validation error");
		  return new ResponseEntity(map, HttpStatus.OK);
			
	  }
	
	
	
	demo2Service.add(ob);	
	return new ResponseEntity(map, HttpStatus.OK);
	
}



@ResponseStatus(HttpStatus.OK)
@ExceptionHandler(HttpMessageNotReadableException.class)
@ResponseBody
public ErrorBean handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    String msg="wrong data type entered";
	ErrorBean errorBean = new ErrorBean();
    errorBean.setMessage(msg);
    return errorBean;
}

class ErrorBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

@RequestMapping(value="/update",method=RequestMethod.POST)
ResponseEntity<Object> update( @RequestBody  Test obj)

{
	Map<String,String> map = new HashMap<String,String>();
	int i=demo2Service.update(obj);	
	if(i==1)
			{
		map.put("msg","data updated");
			}
	else
	{
		map.put("msg1","nothing to update");
	}
	return new ResponseEntity(map, HttpStatus.OK);
	
}


@RequestMapping(value="/delete",method=RequestMethod.POST)
ResponseEntity<Object> delete( @RequestBody UUID id)

{
System.out.println("uuid"+id);
	Map<String,String> map = new HashMap<String,String>();
	demo2Service.delete(id);	
	return new ResponseEntity(map, HttpStatus.OK);
	
}

















}
