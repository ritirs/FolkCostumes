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

    @Resource
    private ElementMapper elementMapper;


    public ElementType getElementTypeByName(String elementType) {
        return elementTypeService.getElementTypeByTypeName(elementType);
    }

    public List<ElementDto> getAllElements() {
        List<Element> elements = elementRepository.findAll();
        return elementMapper.elementToElementDto(elements);
    }

    public List<ElementDto> getElementsByTypeName(String typeName) {
        List<Element> elements = elementRepository.findElementsByElementType_ElementType(typeName);
        return elementMapper.elementToElementDto(elements);
    }

}
