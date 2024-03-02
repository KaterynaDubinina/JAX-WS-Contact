package org.example.client.api;

import jakarta.xml.ws.Service;
import org.example.client.utils.Constants;
import org.example.server.service.DataService;

import javax.xml.namespace.QName;
import java.net.URL;

public class DataClient {

    public String runClient(String data) throws Exception {
        URL url = new URL(Constants.URL);

        QName qname = new QName(
                "http://service.server.example.org/",
                "DataServiceImplService"
        );

        Service service = Service.create(url, qname);
        DataService dataService = service.getPort(DataService.class);
        return dataService.getData(data);
    }
}
