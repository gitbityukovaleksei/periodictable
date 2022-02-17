package ua.com.lineup.periodictable.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.com.lineup.periodictable.domain.Element;
import ua.com.lineup.periodictable.domain.dto.ElementDTO;
import ua.com.lineup.periodictable.repository.ElementRepository;

import javax.persistence.criteria.Predicate;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ElementService {
    private final Logger log = LoggerFactory.getLogger(ElementService.class);
    private final ElementRepository elementRepository;

    public ElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public void uploadStartDataSet(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<ElementDTO> elements = Arrays.asList(objectMapper.readValue(file, ElementDTO[].class));
            ModelMapper modelMapper = new ModelMapper();
            for (ElementDTO elementDTO : elements) {
                elementRepository.save(modelMapper.map(elementDTO, Element.class));
            }
        } catch (IOException e) {
            log.error("IOException with upload file");
        }
    }

    public List<Element> getAllWithCriteria(ElementCriteria elementCriteria, Pageable pageable) {
        Specification<Element> elementSpecification = makeElementSpecification(elementCriteria);
        if (checkDefaultParams(elementCriteria)) {
            return elementRepository.findAll(pageable).getContent();
        }
        return elementRepository.findAll(elementSpecification, pageable).getContent();
    }

    private boolean checkDefaultParams(ElementCriteria elementCriteria) {
        return elementCriteria.getName() == null;
    }

    private Specification<Element> makeElementSpecification(ElementCriteria elementCriteria) {
        //todo Implement all predicates
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (elementCriteria.getName() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                        "%" + elementCriteria.getName().toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.get(0));
        };
    }

}
