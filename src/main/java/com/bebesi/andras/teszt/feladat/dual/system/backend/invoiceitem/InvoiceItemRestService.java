package com.bebesi.andras.teszt.feladat.dual.system.backend.invoiceitem;

import com.bebesi.andras.teszt.feladat.dual.system.common.request.SingleRequest;
import com.bebesi.andras.teszt.feladat.dual.system.ejb.Mappers.InvoiceItemMapper;
import com.bebesi.andras.teszt.feladat.dual.system.common.invoiceitem.InvoiceItemEntry;
import com.bebesi.andras.teszt.feladat.dual.system.common.response.ListResponse;
import com.bebesi.andras.teszt.feladat.dual.system.common.response.SingleResponse;
import com.bebesi.andras.teszt.feladat.dual.system.ejb.invoiceitem.InvoiceItemEntity;
import com.bebesi.andras.teszt.feladat.dual.system.ejb.invoiceitem.InvoiceItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
        response.setItem(invoiceItemEntities.stream().map(invoiceItemEntity -> (invoiceItemEntity.getQuantity()*invoiceItemEntity.getUnitPrice())).collect(Collectors.toList()).stream().reduce(0L,(a, b)->(Long.sum(a,b))));
        return response;
    }


    @GetMapping(endpoint+"/list/{id}")
    public ListResponse<InvoiceItemEntry> list(@PathVariable Long id) {
        List<InvoiceItemEntity> invoiceItemEntities = invoiceItemRepository.findAllByInvoiceId(id);
        ListResponse<InvoiceItemEntry> response = new ListResponse<>();
        response.setList(invoiceItemMapper.toDto(invoiceItemEntities));
        return response;
    }

    @PostMapping(endpoint+"/new")
    public SingleResponse<InvoiceItemEntry> save(@RequestBody SingleRequest<InvoiceItemEntry> request) {
        InvoiceItemEntity invoiceItemEntity = invoiceItemRepository.save(invoiceItemMapper.toEntity(request.getItem()));
        SingleResponse<InvoiceItemEntry> response = new SingleResponse<>();
        response.setItem(invoiceItemMapper.toDto(invoiceItemEntity));
        return response;
    }
}
