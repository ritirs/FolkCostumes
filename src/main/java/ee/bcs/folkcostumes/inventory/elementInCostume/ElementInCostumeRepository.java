package ee.bcs.folkcostumes.inventory.elementInCostume;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElementInCostumeRepository extends JpaRepository<ElementInCostume, Integer> {
    List<ElementInCostume> findByElement_ElementType_ElementType(String elementType);










}