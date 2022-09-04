package com.autocodegen.my_transactions.repository;

import com.autocodegen.my_transactions.domain.Transactions;
import com.autocodegen.my_transactions.exceptions.BadRequestException;
import com.autocodegen.my_transactions.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Date;

@Repository
public class TransactionsRepositoryImpl implements TransactionsRepository {

    private static final String SQL_CREATE = "insert into transactions( transaction_id,creditor_debitor,amount,date_time_string,notes ) values(nextval('transaction_id_seq'),  ?,  ?,  ?,  ?  )";
    private static final String SQL_FIND_BY_ID = "select * from transactions where transaction_id = ?";
    private static final String SQL_FIND_ALL = "select * from transactions";
    private static final String SQL_UPDATE = "update transactions set   creditor_debitor = ? ,   amount = ? ,   date_time_string = ? ,   notes = ?  where transaction_id = ?";
    private static final String SQL_DELETE = "delete from transactions where transaction_id = ?";
 
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Transactions> findAll(){
    return jdbcTemplate.query(SQL_FIND_ALL, transactionsRowMapper);
    }

    @Override
    public Transactions findOne(int transaction_id) throws ResourceNotFoundException {
         try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, transactionsRowMapper,transaction_id);
        }catch (Exception e) {
            throw new ResourceNotFoundException("Data not found");
        }
    }

    @Override
    public Integer create(          String creditor_debitor,                  double amount,                  String date_time_string,                  String notes         ) throws BadRequestException{
         
          try {
              KeyHolder keyHolder = new GeneratedKeyHolder();
              jdbcTemplate.update(connection -> {
                  PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);

                                                    
                   ps.setString(1,creditor_debitor);
                  
                                   
                                                    
                   ps.setDouble(2,amount);
                  
                                   
                                                    
                   ps.setString(3,date_time_string);
                  
                                   
                                                    
                   ps.setString(4,notes);
                  
                                   
                  
                  return ps;
              },keyHolder);

               return (Integer) keyHolder.getKeys().get("transaction_id");
        }catch (Exception e) {
            throw new BadRequestException("Invalid request");
        }
}
    @Override
    public void updateOne(int transaction_id, Transactions transactions) throws BadRequestException{
       try {
            jdbcTemplate.update(SQL_UPDATE, new Object[]{
            
                      transactions.getcreditor_debitor(),
                   transactions.getamount(),
                   transactions.getdate_time_string(),
                   transactions.getnotes(),
                     
            transaction_id});
        }catch (Exception e) {
            throw new BadRequestException("Invalid request");
        }  
     
     }

    @Override
    public void removeOne(int transaction_id) throws ResourceNotFoundException{
    int count = jdbcTemplate.update(SQL_DELETE, new Object[]{transaction_id});
     if(count == 0)
     {
            throw new ResourceNotFoundException( "Data not found");
     }
    }

    private RowMapper<Transactions> transactionsRowMapper = ((rs, rowNum) -> {
        return new Transactions(rs.getInt("transaction_id"),

                         rs.getString("creditor_debitor"),                                  rs.getDouble("amount"),                                  rs.getString("date_time_string"),                                  rs.getString("notes")                  );

               
    });
}
