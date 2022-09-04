
package com.autocodegen.my_transactions.domain;

import javax.persistence.*;
import java.util.Date;

public class Transactions {


    private int transaction_id;
     private String creditor_debitor;
       private double amount;
       private String date_time_string;
       private String notes;
   
    public Transactions(
        int transaction_id, 
                  String creditor_debitor,                  double amount,                  String date_time_string,                  String notes         ) {

            this.creditor_debitor = creditor_debitor;
            this.amount = amount;
            this.date_time_string = date_time_string;
            this.notes = notes;
         }
    
    public int getint(){
        return transaction_id;
    }

    public void setint(int transaction_id){
        this.transaction_id = transaction_id;
    }

     
     public String getcreditor_debitor(){        
        return creditor_debitor;
     }
     
     public void setcreditor_debitor (String creditor_debitor){
        this.creditor_debitor = creditor_debitor;
      
      }
      
     public double getamount(){        
        return amount;
     }
     
     public void setamount (double amount){
        this.amount = amount;
      
      }
      
     public String getdate_time_string(){        
        return date_time_string;
     }
     
     public void setdate_time_string (String date_time_string){
        this.date_time_string = date_time_string;
      
      }
      
     public String getnotes(){        
        return notes;
     }
     
     public void setnotes (String notes){
        this.notes = notes;
      
      }
            
   
}
