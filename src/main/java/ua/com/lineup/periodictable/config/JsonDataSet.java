package ua.com.lineup.periodictable.config;

import org.springframework.stereotype.Component;
import ua.com.lineup.periodictable.service.ElementService;

import javax.annotation.PostConstruct;

@Component
public class JsonDataSet {

    private final ElementService elementService;


    public JsonDataSet(ElementService elementService) {
        this.elementService = elementService;
    }

    @PostConstruct
    void uploadDataSet() {
        elementService.uploadStartDataSet("/periodic_table.json");
    }
}
