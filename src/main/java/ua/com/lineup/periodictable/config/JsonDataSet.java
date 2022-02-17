package ua.com.lineup.periodictable.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ua.com.lineup.periodictable.service.ElementService;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class JsonDataSet {

    private final ElementService elementService;

    @Value("classpath:periodic_table.json")
    Resource resourceFile;

    public JsonDataSet(ElementService elementService) {
        this.elementService = elementService;
    }

    @PostConstruct
    void uploadDataSet() throws IOException {
        if (resourceFile.getFile().exists()) {
            elementService.uploadStartDataSet(resourceFile.getFile());
        }
    }
}
