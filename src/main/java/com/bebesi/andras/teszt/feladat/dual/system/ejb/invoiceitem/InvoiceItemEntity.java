package com.bebesi.andras.teszt.feladat.dual.system.ejb.invoiceitem;

import com.bebesi.andras.teszt.feladat.dual.system.ejb.Invoice.InvoiceEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "invoice_item")
public class InvoiceItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "unit_price",nullable = false)
    private Long unitPrice;

    @Column(name = "quantity",nullable = false)
    private Long quantity;

    @Transient
    @Column(name = "total_item_price")
    private Long totalItemPrice;

    @Column(name = "created_on")
    private Instant createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private Instant updatedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    @JsonIgnoreProperties("invoiceItems")
    private InvoiceEntity invoice;
}
