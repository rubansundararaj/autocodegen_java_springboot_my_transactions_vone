
package com.autocodegen.my_transactions.repository;

import com.autocodegen.my_transactions.domain.Transactions;
import com.autocodegen.my_transactions.exceptions.BadRequestException;
import com.autocodegen.my_transactions.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Date;

public interface TransactionsRepository{

    List<Transactions> findAll() throws ResourceNotFoundException;

    Transactions findOne(int transaction_id) throws ResourceNotFoundException;

    Integer create(          String creditor_debitor,                  double amount,                  String date_time_string,                  String notes         ) throws BadRequestException;

    void updateOne(int transaction_id, Transactions transactions) throws BadRequestException;

    void removeOne(int transaction_id);
}