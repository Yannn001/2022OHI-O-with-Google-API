package com.cabsApi.webApp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashMap;

@Data
@Document
public class CCDailyStore {
    @Id
    private String id;
    private HashMap<String, Double>[] timeMap;
    //String: destination name, Double: time that actually spent to the destination
}
