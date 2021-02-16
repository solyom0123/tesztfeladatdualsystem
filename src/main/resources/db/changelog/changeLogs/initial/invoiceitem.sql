CREATE TABLE invoice_item (
         id  NUMBER(7) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) PRIMARY KEY,
         product_name   VARCHAR2(100) NOT NULL,
         unit_price  NUMBER(7) NOT NULL,
         quantity  NUMBER(7) NOT NULL,
         created_on TIMESTAMP DEFAULT (sysdate),
         updated_on TIMESTAMP DEFAULT (sysdate),
         total_item_price  NUMBER(7,2) GENERATED ALWAYS AS (quantity*unit_price),
         invoice_id  NUMBER(7) NOT NULL
                     CONSTRAINT invoice_invoice_item_fkey REFERENCES invoice
                     (id))
   STORAGE ( INITIAL 50K);

COMMENT ON TABLE invoice_item IS 'Invoices table';
