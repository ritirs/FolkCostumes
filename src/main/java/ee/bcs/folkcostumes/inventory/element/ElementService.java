package ee.bcs.folkcostumes.inventory.element;

import ee.bcs.folkcostumes.inventory.elementType.ElementType;
import ee.bcs.folkcostumes.inventory.elementType.ElementTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ElementService {

    @Resource
    private ElementRepository elementRepository;

    @Resource
    private ElementTypeService elementTypeService;


    public ElementType getElementTypeByName(String elementType) {
        return  elementTypeService.getElementTypeByTypeName(elementType);
    }

    public List<Element> getElementsByTypeName(String typeName) {
        return elementRepository.findElementsByElementType_ElementType(typeName);
    }

}
