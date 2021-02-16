package com.bebesi.andras.teszt.feladat.dual.system.backend.invoice;

import com.bebesi.andras.teszt.feladat.dual.system.ejb.Invoice.InvoiceEntity;
import com.bebesi.andras.teszt.feladat.dual.system.ejb.Invoice.InvoiceRepository;
import com.bebesi.andras.teszt.feladat.dual.system.ejb.Mappers.InvoiceMapper;
import com.bebesi.andras.teszt.feladat.dual.system.common.Invoice.InvoiceEntry;
import com.bebesi.andras.teszt.feladat.dual.system.common.response.ListResponse;
import com.bebesi.andras.teszt.feladat.dual.system.common.response.SingleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class InvoiceRestService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    private final String endpoint = "/invoice";

    public InvoiceRestService(
            InvoiceRepository invoiceRepository,
            InvoiceMapper invoiceMapper
    ) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @GetMapping(endpoint + "/list")
    public ListResponse<InvoiceEntry> listAll() {
        List<InvoiceEntity> invoiceEntities = invoiceRepository.findAll();
        ListResponse<InvoiceEntry> response = new ListResponse();
        response.setList(invoiceMapper.toDto(invoiceEntities));
        return response;
    }

    @GetMapping(endpoint + "/{id}")
    public SingleResponse<InvoiceEntry> listAll(@PathVariable Long id) {
        Optional<InvoiceEntity> invoiceEntity = invoiceRepository.findById(id);
        SingleResponse<InvoiceEntry> response = new SingleResponse();
        if (invoiceEntity.isPresent())
            response.setItem(invoiceMapper.toDto(invoiceEntity.get()));
        return response;
    }


}
