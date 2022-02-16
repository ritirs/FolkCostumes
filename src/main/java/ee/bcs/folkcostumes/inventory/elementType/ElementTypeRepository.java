package ee.bcs.folkcostumes.inventory.elementType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementTypeRepository extends JpaRepository<ElementType, Integer> {
    ElementType findByElementTypeIsLikeIgnoreCase(String elementType);

}