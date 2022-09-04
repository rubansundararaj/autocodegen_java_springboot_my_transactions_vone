
package com.autocodegen.my_transactions.services;

import com.autocodegen.my_transactions.domain.Transactions;
import com.autocodegen.my_transactions.exceptions.BadRequestException;
import com.autocodegen.my_transactions.exceptions.ResourceNotFoundException;
import com.autocodegen.my_transactions.repository.TransactionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Date;

@Service
@Transactional
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    TransactionsRepository transactionsRepository;

    @Override
    public List<Transactions> fetchAllTransactions(){
        
        return transactionsRepository.findAll();
    }

    @Override
    public Transactions fetchTransactionsBytransaction_id(int transaction_id) throws ResourceNotFoundException{
        return transactionsRepository.findOne(transaction_id);
    }

    @Override
    public void addTransactions(          String creditor_debitor,                  double amount,                  String date_time_string,                  String notes         ) throws BadRequestException{
         
          transactionsRepository.create(           creditor_debitor,                    amount,                    date_time_string,                    notes          );
    }
    
    @Override
    public void updateTransactionsBytransaction_id(int transaction_id, Transactions transactions) throws BadRequestException {
        transactionsRepository.updateOne(transaction_id,transactions);   
    }
    
    @Override
    public void removeTransactionsBytransaction_id(int transaction_id){
        this.fetchTransactionsBytransaction_id(transaction_id);
        transactionsRepository.removeOne(transaction_id);
    
    }
}