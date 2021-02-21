package com.bebesi.andras.teszt.feladat.dual.system.ejb.invoiceitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface InvoiceItemRepository extends JpaRepository<InvoiceItemEntity,Long> {
    List<InvoiceItemEntity> findAllByInvoiceId(Long id);
}
