package com.bebesi.andras.teszt.feladat.dual.system.ejb.Mappers;

import com.bebesi.andras.teszt.feladat.dual.system.ejb.invoiceitem.InvoiceItemEntity;
import com.bebesi.andras.teszt.feladat.dual.system.common.invoiceitem.InvoiceItemEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceItemMapper extends EntityMapper<InvoiceItemEntry, InvoiceItemEntity> {
}
