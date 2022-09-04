
package com.autocodegen.my_transactions.services;

import com.autocodegen.my_transactions.domain.User;
import com.autocodegen.my_transactions.exceptions.AuthException;

public interface UserService {

    User validateUser(String email, String password) throws AuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws AuthException;

}