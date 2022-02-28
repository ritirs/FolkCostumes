package ee.bcs.folkcostumes.inventory;

import ee.bcs.folkcostumes.inventory.costume.CostumeService;
import ee.bcs.folkcostumes.inventory.element.ElementService;
import ee.bcs.folkcostumes.inventory.elementInCostume.*;
import ee.bcs.folkcostumes.inventory.elementType.ElementTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//    T ODO:
//    1. Admin saab lisada süsteemi nimekirja Element-type ja Costume repositooriumitesse
//    2. saab lisada Elementi, määrata sellele Element-type
//    3. saab lisada Costume-element - määrata sellele Costume ja Element-type seosed
//    4. Saab teha väljavõtet ja parandusi kõikidest gruppides: Element-type, Costume, Element, Element-in-costume


@RestController
@RequestMapping("/costume")
public class CostumeController {

    @Resource
    private CostumeService costumeService;
    @Resource
    private ElementTypeService elementTypeService;
    @Resource
    private ElementInCostumeService elementInCostumeService;
    @Resource
    private ElementService elementService;

    @PostMapping("/costume/add/list")
    private String addCostumesList(@RequestParam List<String> costumes) {
        costumeService.addCostumesList(costumes);
        return "Komplekti(d) lisatud.";
    }

    @PostMapping("/costume/update/name")
    public String updateCostumeName(@RequestParam String oldName, @RequestParam String newName) {
        return costumeService.updateCostumeName(oldName, newName);
    }

    @GetMapping("/get/costume/names")
    public List<String> getAllCostumeNames() {
        return costumeService.getAllCostumeNames();
    }

//    @PostMapping("/add/element/type")
//    public String addNewElementType(@RequestParam String elementName) {
//        elementTypeService.addNewElementType(elementName);
//        return "Uus elemendi tüüp lisatud.";
//    }
//    pole ükshaaval vaja lisada

    @PostMapping("/add/element/types")
    private String addElementTypesList(@RequestParam List<String> types) {
        elementTypeService.addElementTypeList(types);
        return "Elemendi tüüp/tüübid lisatud.";
    }

    @PostMapping("/add/elements/new")
    public String addNewElement(@RequestBody List<ElementInCostumeWideRequest> request) {
        elementInCostumeService.addNewElement(request);
        return "Uus rahvariiete element lisatud";
    }

    @PostMapping("/update/element/name")
    public String updateElementName(@RequestParam String oldName, @RequestParam String newName) {
        elementService.updateElementName(oldName, newName);
        return "Rahvariiete elemendi nimi \"" + oldName + " asendatud uue nimega " + newName + " \" ";
    }

    @PostMapping("/update/element/description")
    public String updateElementDescription(@RequestParam String elementName, @RequestParam String newDescription) {
        elementService.updateElementDescription(elementName, newDescription);
        return "Kirjeldus uuendatud.";
    }

    @GetMapping("/get/all/element/type/names")
    public List<String> getAllElementTypes() {
        return elementTypeService.getAllElementTypeNames();
    }

    @GetMapping("/get/elements/by/type/name")
    public List<ElementInCostumeRequest> getElementsByTypeName(@RequestParam String elementTypeName) {
        return elementInCostumeService.getElementsByTypeName(elementTypeName);
    }

    @GetMapping("/get/elements/by/costume")
    public List<String> getElementsByCostume(@RequestParam String costumeName) {
        return elementInCostumeService.getElementsByCostume(costumeName);
    }

    @GetMapping("/get/elements/all")
    public List<ElementInCostumeDtoLarge> getAllElements() {
        return elementInCostumeService.getAllElementDetails();
    }

//    @GetMapping("/elements/by/type/name")
//    public List<ElementInCostumeRequest> elementsByTypeName(@RequestParam String elementType) {
//        return elementInCostumeService.elementsByTypeName(elementType);
//    }

}
