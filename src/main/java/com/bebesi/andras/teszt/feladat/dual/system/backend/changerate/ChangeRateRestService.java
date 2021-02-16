package com.bebesi.andras.teszt.feladat.dual.system.backend.changerate;

import com.bebesi.andras.teszt.feladat.dual.system.backend.mnb.MNBArfolyamServiceSoap;
import com.bebesi.andras.teszt.feladat.dual.system.backend.mnb.MNBArfolyamServiceSoapImpl;
import com.bebesi.andras.teszt.feladat.dual.system.common.response.SingleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

@Slf4j
@RestController
public class ChangeRateRestService {

    private final String endpoint = "/change";

    public ChangeRateRestService() {}

    @GetMapping(endpoint + "/save")
    public SingleResponse<String> downloadAll() {
        SingleResponse<String> response = new SingleResponse();
        MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl();
        MNBArfolyamServiceSoap service = impl.getCustomBindingMNBArfolyamServiceSoap();
        try {
            String resp = service.getCurrentExchangeRates();

            // Creates a FileWriter
            FileWriter file = new FileWriter("rate.xml");
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            bufferedWriter.write(resp);
            bufferedWriter.close();
            response.setItem(resp);
        } catch (Exception e) {
            System.err.print(e);
        }

        return response;
    }


    @GetMapping(endpoint + "/find/{curr}")
    public SingleResponse<Double> find(@PathVariable String curr) {
        SingleResponse<Double> response = new SingleResponse();
        try {
            File inputFile = new File("rate.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputFile);
            List<Node> dayNodes= document.selectNodes("/MNBCurrentExchangeRates/Day");
            List<Node> rateNodes = dayNodes.get(0).selectNodes("Rate");
            for (Node rate:rateNodes) {
                if(rate.valueOf("@curr").equals(curr)){
                    response.setItem(Double.parseDouble(rate.getText().replace(",",".")));
                }
            }
        }catch (Exception e){
            log.error("Missing rate, rate download need");
            log.error(e.getMessage());
        }

        return response;
    }


}
