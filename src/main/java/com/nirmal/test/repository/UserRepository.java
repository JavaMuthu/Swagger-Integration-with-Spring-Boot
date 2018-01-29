/**
 * 
 */
package com.nirmal.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.nirmal.test.model.User;

/**
 * @author muthu_m
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
