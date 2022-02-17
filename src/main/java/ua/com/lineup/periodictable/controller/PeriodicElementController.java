package ua.com.lineup.periodictable.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.lineup.periodictable.service.ElementCriteria;
import ua.com.lineup.periodictable.service.ElementService;

@RestController
@RequestMapping("/api/periodic")
public class PeriodicElementController {

    private final ElementService elementService;

    public PeriodicElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getMyJobsForCustomer(ElementCriteria elementCriteria,
                                                  @PageableDefault(size = 20, page = 0, sort = {"atomicNumber"}, direction = Sort.Direction.ASC) Pageable pageable) {

        return ResponseEntity.ok(elementService.getAllWithCriteria(elementCriteria, pageable));
    }
}
