package com.bebesi.andras.teszt.feladat.dual.system.ejb.Mappers;

import com.bebesi.andras.teszt.feladat.dual.system.ejb.Invoice.InvoiceEntity;
import com.bebesi.andras.teszt.feladat.dual.system.ejb.invoiceitem.InvoiceItemEntity;
import com.bebesi.andras.teszt.feladat.dual.system.common.invoiceitem.InvoiceItemEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface InvoiceItemMapper extends EntityMapper<InvoiceItemEntry, InvoiceItemEntity> {

    @Mapping(source = "invoice", target = "invoiceId", qualifiedByName = "entityToId")
    InvoiceItemEntry toDto(InvoiceItemEntity entity);

    @Named("entityToId")
    static Long entityToId(InvoiceEntity entity) {
        return entity.getId();
    }
    @Mapping(source = "invoiceId", target = "invoice", qualifiedByName = "idToEntity")
    InvoiceItemEntity toEntity(InvoiceItemEntry entry);

    @Named("idToEntity")
    static InvoiceEntity idToEntity(Long id) {
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setId(id);
        return invoiceEntity;
    }
}
