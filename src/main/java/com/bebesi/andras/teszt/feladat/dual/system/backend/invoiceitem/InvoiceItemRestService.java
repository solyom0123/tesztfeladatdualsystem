package com.bebesi.andras.teszt.feladat.dual.system.backend.invoiceitem;

import com.bebesi.andras.teszt.feladat.dual.system.ejb.Mappers.InvoiceItemMapper;
import com.bebesi.andras.teszt.feladat.dual.system.common.invoiceitem.InvoiceItemEntry;
import com.bebesi.andras.teszt.feladat.dual.system.common.response.ListResponse;
import com.bebesi.andras.teszt.feladat.dual.system.common.response.SingleResponse;
import com.bebesi.andras.teszt.feladat.dual.system.ejb.invoiceitem.InvoiceItemEntity;
import com.bebesi.andras.teszt.feladat.dual.system.ejb.invoiceitem.InvoiceItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class InvoiceItemRestService {

    private final InvoiceItemRepository invoiceItemRepository;
    private final InvoiceItemMapper invoiceItemMapper;

    private final String endpoint="/invoiceitem";

    public InvoiceItemRestService(
         InvoiceItemRepository invoiceItemRepository,
         InvoiceItemMapper invoiceItemMapper
            ) {
    this.invoiceItemRepository = invoiceItemRepository;
    this.invoiceItemMapper = invoiceItemMapper;
    }

    @GetMapping(endpoint+"/price/{id}")
    public SingleResponse<Long> getCalculatedTotalPriceByInvoiceId(@PathVariable Long id) {
        List<InvoiceItemEntity> invoiceItemEntities = invoiceItemRepository.findAllByInvoiceId(id);
        SingleResponse<Long> response = new SingleResponse<>();
        response.setItem(invoiceItemEntities.stream().map(invoiceItemEntity -> invoiceItemEntity.getTotalItemPrice()).collect(Collectors.toList()).stream().reduce(0L,(a, b)->(Long.sum(a,b))));
        return response;
    }


    @GetMapping(endpoint+"/list/{id}")
    public ListResponse<InvoiceItemEntry> list(@PathVariable Long id) {
        List<InvoiceItemEntity> invoiceItemEntities = invoiceItemRepository.findAllByInvoiceId(id);
        ListResponse<InvoiceItemEntry> response = new ListResponse<>();
        response.setList(invoiceItemMapper.toDto(invoiceItemEntities));
        return response;
    }

}
