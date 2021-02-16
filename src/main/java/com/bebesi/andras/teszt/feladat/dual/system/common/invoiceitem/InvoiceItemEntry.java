package com.bebesi.andras.teszt.feladat.dual.system.common.invoiceitem;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
public class InvoiceItemEntry implements Serializable {
    private Long id;
    private String productName;
    private Long unitPrice;
    private Long quantity;
    private Long totalItemPrice;
    private Long invoiceId;
    private Instant createdOn;
    private Instant updatedOn;
}
