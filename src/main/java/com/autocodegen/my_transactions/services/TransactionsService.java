
package com.autocodegen.my_transactions.services;

import com.autocodegen.my_transactions.domain.Transactions;
import com.autocodegen.my_transactions.exceptions.BadRequestException;
import com.autocodegen.my_transactions.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Date;

public interface TransactionsService{

    List<Transactions> fetchAllTransactions() throws ResourceNotFoundException;

    Transactions fetchTransactionsBytransaction_id(int transaction_id) throws ResourceNotFoundException;

    void addTransactions(          String creditor_debitor,                  double amount,                  String date_time_string,                  String notes         ) throws BadRequestException;

    void updateTransactionsBytransaction_id(int transaction_id, Transactions transactions) throws BadRequestException;

    void removeTransactionsBytransaction_id(int transaction_id);
}