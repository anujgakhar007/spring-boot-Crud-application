package com.example.repository;



import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Test;

public interface Demo2Repository extends CrudRepository<Test, UUID>{ 

}
