package ee.bcs.folkcostumes.inventory.elementType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ElementTypeRepository extends JpaRepository<ElementType, Integer> {

    boolean existsByElementType(String elementType);

    @Query("select e from ElementType e where e.elementType = ?1")
    ElementType findByElementTypeName(String elementType);



}