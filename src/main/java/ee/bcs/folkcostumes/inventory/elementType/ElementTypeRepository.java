package ee.bcs.folkcostumes.inventory.elementType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface ElementTypeRepository extends JpaRepository<ElementType, Integer> {

    boolean existsByElementType(String elementType);

    ElementType findByElementType(String elementType);

}