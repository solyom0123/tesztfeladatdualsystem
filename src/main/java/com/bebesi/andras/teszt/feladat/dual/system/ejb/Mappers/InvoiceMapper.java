package com.bebesi.andras.teszt.feladat.dual.system.ejb.Mappers;

import com.bebesi.andras.teszt.feladat.dual.system.ejb.Invoice.InvoiceEntity;
import com.bebesi.andras.teszt.feladat.dual.system.common.Invoice.InvoiceEntry;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        uses = {InvoiceItemMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface InvoiceMapper extends EntityMapper<InvoiceEntry, InvoiceEntity> {
}
