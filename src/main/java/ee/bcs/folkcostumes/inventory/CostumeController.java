//package ee.bcs.folkcostumes.inventory;
//
//import ee.bcs.folkcostumes.inventory.costume.CostumeDto;
//import ee.bcs.folkcostumes.inventory.costume.CostumeService;
//import ee.bcs.folkcostumes.inventory.elementType.ElementTypeRequest;
//import ee.bcs.folkcostumes.inventory.elementType.ElementTypeService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
////    TODO:
////    1. Admin saab lisada süsteemi nimekirja Element-type ja Costume repositooriumitesse
////    2. saab lisada Elementi, määrata sellele Element-type
////    3. saab lisada Costume-element - määrata sellele Costume ja Element-type seosed
////    4. Saab teha väljavõtet ja parandusi kõikidest gruppides: Element-type, Costume, Element, Element-in-costume
//
//
//@RestController
//@RequestMapping("/costume")
//public class CostumeController {
//
//    @Resource private CostumeService costumeService;
//    @Resource private ElementTypeService elementTypeService;
//
//    @PostMapping("/add/new/element/type")
//    public ElementTypeRequest addNewElementType(@RequestBody ElementTypeRequest request) {
//        ElementTypeRequest elementTypeRequest = elementTypeService.addNewElementType(request);
//        return elementTypeRequest;
//    }
//
//    @GetMapping("/all/element/types")
//    public List<ElementTypeRequest> findAllElementTypes() {
//        List<ElementTypeRequest> elementTypeRequests = elementTypeService.findAllElementTypes();
//        return elementTypeRequests;
//    }
//
//    @PostMapping ("/find/element/type/by/name")
//    public List<ElementTypeRequest> findElementTypesByName(@RequestParam String elementType) {
//        List<ElementTypeRequest> elementTypeRequests = elementTypeService.findElementTypesByName(elementType);
//        return elementTypeRequests;
//    }
//
//    @PostMapping("/add/new/costume")
//    public CostumeDto addNewCostume(@RequestBody CostumeDto request) {
//        CostumeDto costumeDto = costumeService.addNewCostume(request);
//        return costumeDto;
//    }
//
//    @GetMapping("/all/costumes")
//    public List<CostumeDto> findAllCostumes() {
//        List<CostumeDto> costumeDtos = costumeService.findAllCostumes();
//        return costumeDtos;
//    }
//
//}
