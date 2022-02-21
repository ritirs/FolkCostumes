package ee.bcs.folkcostumes.inventory.elementType;

import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ElementTypeService {

    @Resource
    private ElementTypeMapper elementTypeMapper;
    @Resource
    private ElementTypeRepository elementTypeRepository;
    @Resource
    private ValidationService validationService;


    public void addNewElementType(String elementTypeName) {
        ElementType newElementType = new ElementType();
        newElementType.setElementType(elementTypeName);
        elementTypeRepository.save(newElementType);
    }

    public void addElementTypeList(List<String> types) {
        for (String type : types) {
            addNewElementType(type);
        }
    }

    public String updateElementTypeName(String oldName, String newName) {
        validationService.elementTypeNameAlreadyExists(elementTypeRepository.existsByElementType(newName), newName);
        ElementType newElementType = elementTypeRepository.findByElementType(oldName);
        newElementType.setElementType(newName);
        elementTypeRepository.save(newElementType);
        return "Endine nimetus \"" + oldName + " asendatud uue nimetusega \"" + newName;
    }

//    public List<ElementTypeDto> getAllElementTypes() {
//        List<ElementType> allElementTypes = elementTypeRepository.findAll();
//        return elementTypeMapper.elementTypesToElementTypeDtos(allElementTypes);
//    }

    public List<String> getAllElementTypeNames() {
        List<String> elementTypeNames = new ArrayList<>();
        List<ElementType> allTypes = elementTypeRepository.findAll();
        for (ElementType type : allTypes) {
            elementTypeNames.add(type.getElementType());
        }
        return elementTypeNames;
    }

    public ElementType getElementTypeByTypeName(String elementType) {
        return elementTypeRepository.findByElementType(elementType);
    }


    //TODO: võimaldab kasutajal otsida elementType nimetuse järgi ja loob nimekirja
    // elementType'idest, mis vastavad kriteeriumile.
//    public List<ElementTypeDto> findElementTypesByName(String elementType) {
//        List<ElementType> elementTypes = elementTypeRepository.findByElementTypeName(elementType);
//        List <ElementTypeRequest> elementTypeRequests = elementTypeMapper.elementTypesToElementTypeDtos(elementTypes);
//        return elementTypeRequests;
//        return null;
//    }


}
