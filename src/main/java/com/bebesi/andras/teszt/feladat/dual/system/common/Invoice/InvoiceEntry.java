package com.bebesi.andras.teszt.feladat.dual.system.common.Invoice;

import com.bebesi.andras.teszt.feladat.dual.system.common.invoiceitem.InvoiceItemEntry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class InvoiceEntry implements Serializable {
    private Long id;
    private String customerName;
    private Date issueDate;
    private Date dueDate;
    private String comment;
    private Instant createdOn;
    private Instant updatedOn;
    private List<InvoiceItemEntry> invoiceItems;
}
