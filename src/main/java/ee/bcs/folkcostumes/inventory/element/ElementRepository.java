package ee.bcs.folkcostumes.inventory.element;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElementRepository extends JpaRepository<Element, Integer> {

    List<Element> findElementsByElementType_ElementType(String elementType);

    boolean existsByElementName(String elementName);

    Element findByElementName(String elementName);








}