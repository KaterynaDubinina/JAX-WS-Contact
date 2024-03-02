package org.example.server.service;

import jakarta.xml.ws.Endpoint;
import org.example.server.utils.Constants;

public class DataServicePublisher {

    public void publish() {
        Endpoint.publish(Constants.BASE_URL, new DataServiceImpl());
    }
}
