package ee.bcs.folkcostumes.inventory.elementInCostume;

import ee.bcs.folkcostumes.inventory.elementType.ElementType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElementInCostumeRepository extends JpaRepository<ElementInCostume, Integer> {

    List<ElementInCostume> findByElement_ElementType(ElementType elementType);

    boolean existsByElement_ElementType(ElementType elementType);
















}