package ee.bcs.folkcostumes.inventory;

import ee.bcs.folkcostumes.inventory.costume.CostumeService;
import ee.bcs.folkcostumes.inventory.element.ElementService;
import ee.bcs.folkcostumes.inventory.elementInCostume.ElementInCostume;
import ee.bcs.folkcostumes.inventory.elementInCostume.ElementInCostumeRequest;
import ee.bcs.folkcostumes.inventory.elementInCostume.ElementInCostumeService;
import ee.bcs.folkcostumes.inventory.elementType.ElementType;
import ee.bcs.folkcostumes.inventory.elementType.ElementTypeDto;
import ee.bcs.folkcostumes.inventory.elementType.ElementTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//    TODO:
//    1. Admin saab lisada süsteemi nimekirja Element-type ja Costume repositooriumitesse
//    2. saab lisada Elementi, määrata sellele Element-type
//    3. saab lisada Costume-element - määrata sellele Costume ja Element-type seosed
//    4. Saab teha väljavõtet ja parandusi kõikidest gruppides: Element-type, Costume, Element, Element-in-costume


@RestController
@RequestMapping("/costume")
public class CostumeController {

    @Resource private CostumeService costumeService;
    @Resource private ElementTypeService elementTypeService;
    @Resource private ElementInCostumeService elementInCostumeService;

    @PostMapping("/add/list")
    private String addCostumesList(@RequestParam List<String> costumes) {
        costumeService.addCostumesList(costumes);
        return "Komplektid lisatud.";
    }
    @PostMapping("/add/new")
    public String addNewCostume(@RequestBody String costume) {
        costumeService.addNewCostume(costume);
        return "Komplekt lisatud nimekirja.";
    }

    @PostMapping("/update/name")
    public String updateCostumeName(@RequestParam String oldName, @RequestParam String newName) {
        return costumeService.updateCostumeName(oldName, newName);
    }

    @GetMapping("/get/all/names")
    public List<String> getAllCostumeNames() {
        return costumeService.getAllCostumeNames();
    }

    @PostMapping("/add/element/type")
    public String addNewElementType(@RequestParam String elementName) {
       elementTypeService.addNewElementType(elementName);
        return "Uus elemendi tüüp lisatud.";
    }

    @PostMapping("/add/element/types")
    private String addElementTypesList(@RequestParam List<String> types) {
        elementTypeService.addElementTypeList(types);
        return "Elemendi tüübid lisatud.";
    }

    @PostMapping("/update/element/type/name")
    public String updateElementTypeName(@RequestParam String oldName, @RequestParam String newName) {
        return elementTypeService.updateElementTypeName(oldName, newName);
    }

    @GetMapping("/get/all/element/type/names")
    public List<String> getAllElementTypes() {
          return elementTypeService.getAllElementTypeNames ();
    }

    @GetMapping("/get/all/elements/in/costume")
    public List<ElementInCostume> getAllElementsInCostume() {
        return elementInCostumeService.getAllElementsInCostumes();
    }

    @GetMapping ("/get/elements/in/costume/by/type/name")
    public List<ElementInCostumeRequest> findElementsByTypeName(@RequestParam String elementTypeName) {
        return elementInCostumeService.getElementsByTypeName(elementTypeName);
    }





}
