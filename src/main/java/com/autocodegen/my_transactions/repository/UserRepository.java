
package com.autocodegen.my_transactions.repository;

import com.autocodegen.my_transactions.domain.User;
import com.autocodegen.my_transactions.exceptions.AuthException;


public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws AuthException;

    User findByEmailAndPassword(String email, String password) throws AuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);

}