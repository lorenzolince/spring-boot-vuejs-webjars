/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.springboot.vuejs.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.llh.springboot.vuejs.backend.domain.User;
/**
 *
 * @author lorenzo
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(@Param("lastname") String lastname);

    List<User> findByFirstName(@Param("firstname") String firstname);

}
