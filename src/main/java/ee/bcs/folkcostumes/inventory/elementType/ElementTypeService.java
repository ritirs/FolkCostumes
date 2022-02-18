//package ee.bcs.folkcostumes.inventory.elementType;
//
//import org.springframework.stereotype.Service;
//
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Service
//public class ElementTypeService {
//
//    @Resource private ElementTypeMapper elementTypeMapper;
//    @Resource private ElementTypeRepository elementTypeRepository;
//
//    public ElementTypeRequest addNewElementType(ElementTypeRequest request) {
//        ElementType newElementType = elementTypeMapper.elementTypeDtoToElementType(request);
//        elementTypeRepository.save(newElementType);
//        ElementTypeRequest elementTypeRequest = elementTypeMapper.elementTypeToElementTypeDto(newElementType);
//        return elementTypeRequest;
//    }
//
//    public List<ElementTypeRequest> findAllElementTypes() {
//        List<ElementType> elementTypes = elementTypeRepository.findAll();
//        List<ElementTypeRequest> elementTypeRequests = elementTypeMapper.elementTypesToElementTypeDtos(elementTypes);
//        return elementTypeRequests;
//    }
//
//    //TODO: võimaldab kasutajal otsida elementType nimetuse järgi ja loob nimekirja
//    // elementType'idest, mis vastavad kriteeriumile.
//    public List <ElementTypeRequest>findElementTypesByName(String elementType) {
//        List<ElementType> elementTypes = elementTypeRepository.findByElementTypeName(elementType);
//        List <ElementTypeRequest> elementTypeRequests = elementTypeMapper.elementTypesToElementTypeDtos(elementTypes);
//        return elementTypeRequests;
//    }
//
//
//}
