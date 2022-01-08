package com.java.springboot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteStudentRepository extends CrudRepository<DeleteStudent,Integer> {
}
