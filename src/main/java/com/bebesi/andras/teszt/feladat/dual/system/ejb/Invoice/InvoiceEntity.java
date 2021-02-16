package com.bebesi.andras.teszt.feladat.dual.system.ejb.Invoice;

import com.bebesi.andras.teszt.feladat.dual.system.ejb.invoiceitem.InvoiceItemEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "invoice")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "issue_date",nullable = false)
    private Date issueDate;

    @Column(name = "due_date",nullable = false)
    private Date dueDate;

    @Column(name = "invoice_comment")
    private String comment;

    @Column(name = "created_on")
    private Instant createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private Instant updatedOn;

    @OneToMany(mappedBy = "invoice", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    @JsonIgnoreProperties("invoice")
    private List<InvoiceItemEntity> invoiceItems = new ArrayList<>();
}
