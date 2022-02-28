package ee.bcs.folkcostumes.inventory.element;

import ee.bcs.folkcostumes.inventory.elementInCostume.ElementInCostume;
import ee.bcs.folkcostumes.inventory.elementInCostume.ElementInCostumeRequest;
import ee.bcs.folkcostumes.inventory.elementInCostume.ElementInCostumeWideRequest;
import ee.bcs.folkcostumes.inventory.elementType.ElementType;
import ee.bcs.folkcostumes.inventory.elementType.ElementTypeDto;
import ee.bcs.folkcostumes.inventory.elementType.ElementTypeService;
import ee.bcs.folkcostumes.validation.ValidationService;
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
    @Resource
    private ValidationService validationService;



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

    public Element addNewElement(ElementInCostumeWideRequest elementRequest) {
        Boolean answer = elementRepository.existsByElementName(elementRequest.getElementName()) ;
        validationService.elementExistsInElements(answer, elementRequest.getElementName());
        Element newElement = new Element();
        ElementType elementType = elementTypeService.getElementTypeByTypeName(elementRequest.getElementTypeName());
        newElement.setElementName(elementRequest.getElementName());
        newElement.setElementType(elementType);
        newElement.setDescription(elementRequest.getElementDescription());
        elementRepository.save(newElement);
        return newElement;
    }

    public void updateElementName(String oldName, String newName) {
        Element element = elementRepository.findByElementName(oldName);
        element.setElementName(newName);
        elementRepository.save(element);
    }

    public void updateElementDescription(String elementName, String newDescription) {
        Element element = elementRepository.findByElementName(elementName);
        element.setDescription(newDescription);
        elementRepository.save(element);
    }

    public Element getElementByName(String elementName) {
        return elementRepository.findByElementName(elementName);
    }

    public List<Element> findElementsByTypeName(String elementTypeName) {
        return elementRepository.findElementsByElementType_ElementType(elementTypeName);
    }

}
