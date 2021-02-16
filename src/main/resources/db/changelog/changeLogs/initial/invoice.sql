CREATE TABLE invoice (
         id  NUMBER(7) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) PRIMARY KEY,
         customer_name   VARCHAR2(100) NOT NULL,
         issue_date  DATE NOT NULL,
         due_date  DATE NOT NULL,
         invoice_comment  VARCHAR2(100),
         created_on TIMESTAMP DEFAULT (sysdate),
         updated_on TIMESTAMP DEFAULT (sysdate))
   STORAGE ( INITIAL 50K);
COMMENT ON TABLE invoice IS 'Invoices table';
