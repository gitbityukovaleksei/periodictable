package ua.com.lineup.periodictable.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ua.com.lineup.periodictable.domain.Element;

import java.util.List;

@Repository
public interface ElementRepository extends JpaRepository<Element, Integer>, JpaSpecificationExecutor<Element> {
    List<Element> findAll(Specification<Element> spec);

    Page<Element> findAll(Specification<Element> spec, Pageable pageable);

    List<Element> findAll(Specification<Element> spec, Sort sort);
}
