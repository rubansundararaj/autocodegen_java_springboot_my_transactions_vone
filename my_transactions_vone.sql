-- psql -U postgres --file <filename>.sql
drop user my_transactions_vone;
create user my_transactions_vone with password 'password';
create database my_transactions_vonedb with template=template0 owner=my_transactions_vone;
\connect my_transactions_vonedb;
alter default privileges grant all on tables to my_transactions_vone;
alter default privileges grant all on sequences to my_transactions_vone;


create table "users"(
"user_id" integer primary key not null,
"first_name" varchar(20) not null,
"last_name" varchar(20) not null,
"email" varchar(30) not null,
"password" text not null
);

CREATE TABLE IF NOT EXISTS "transactions" (
   PRIMARY KEY(transaction_id),
   "transaction_id" INT NOT NULL UNIQUE,
   "creditor_debitor" VARCHAR(100) ,       "amount" NUMERIC ,       "date_time_string" VARCHAR(100) ,       "notes" TEXT     );

 

create sequence transaction_id_seq increment 1 start 1;
create sequence users_seq increment 1 start 1;
