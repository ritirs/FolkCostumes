package ee.bcs.folkcostumes.inventory.elementType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElementTypeRepository extends JpaRepository<ElementType, Integer> {
    @Query("select e from ElementType e where upper(e.elementType) like upper(:elementType)")
    ElementType findByElementTypeIsLike(@Param("elementType") String elementType);

    @Query("select e from ElementType e where upper(e.elementType) like upper(:elementType) order by e.elementType")
    List<ElementType> findListByElementType(@Param("elementType") String elementType);



}