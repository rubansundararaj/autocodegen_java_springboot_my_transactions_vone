
package com.autocodegen.my_transactions.resources;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autocodegen.my_transactions.domain.Transactions;
import com.autocodegen.my_transactions.services.TransactionsService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsResource {
    
    @Autowired
    TransactionsService transactionsService;

    @GetMapping("")
   public ResponseEntity<List<Transactions>> getAllTransactions(HttpServletRequest request) {
        
        List<Transactions> transactionss = transactionsService.fetchAllTransactions();
        return new ResponseEntity<>(transactionss, HttpStatus.OK);
   }

    @GetMapping("/{transaction_id}")
    public ResponseEntity<Transactions> getTransactionsBytransaction_id(HttpServletRequest request,
                                                    @PathVariable("transaction_id") int transaction_id) {
      
        Transactions transactions = transactionsService.fetchTransactionsBytransaction_id(transaction_id);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Boolean>> addTransactions(HttpServletRequest request,
                                                @RequestBody Map<String, Object> transactionsMap) {
        
                 String creditor_debitor = (String)transactionsMap.get("creditor_debitor");
                  double amount = (double)transactionsMap.get("amount");
                  String date_time_string = (String)transactionsMap.get("date_time_string");
                  String notes = (String)transactionsMap.get("notes");
         
         transactionsService.addTransactions(            creditor_debitor,                   amount,                   date_time_string,                   notes         );
        
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PutMapping("/{transaction_id}")
    public ResponseEntity<Map<String, Boolean>> updateTransactions(HttpServletRequest request,
                                                               @PathVariable("transaction_id") int transaction_id,
                                                               @RequestBody Transactions transactions) {

        transactionsService.updateTransactionsBytransaction_id(transaction_id,transactions);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
    @DeleteMapping("/{transaction_id}")
    public ResponseEntity<Map<String, Boolean>> deleteTransactions(HttpServletRequest request,
                                                               @PathVariable("transaction_id") int transaction_id) {
    
         transactionsService.removeTransactionsBytransaction_id(transaction_id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}