package ee.bcs.folkcostumes.inventory;

import ee.bcs.folkcostumes.inventory.costume.CostumeDto;
import ee.bcs.folkcostumes.inventory.costume.CostumeService;
import ee.bcs.folkcostumes.inventory.elementType.ElementTypeDto;
import ee.bcs.folkcostumes.inventory.elementType.ElementTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//    TODO:
//    1. Admin saab lisada süsteemi nimekirja element-type ja costume repositooriumitesse
//    2. saab lisada elementi, määrata sellele element-type
//    3. saab lisada costume-element - määrata sellele costume ja element-type seosed
//    4. Saab teha väljavõtet ja parandusi kõikidest gruppides: element-type, costume, element, element-in-costume


@RestController
@RequestMapping("/costume")
public class CostumeController {

    @Resource private CostumeService costumeService;
    @Resource private ElementTypeService elementTypeService;

    @PostMapping("/add/new/element/type")
    public ElementTypeDto addNewElementType(@RequestBody ElementTypeDto request) {
        ElementTypeDto elementTypeDto = elementTypeService.addNewElementType(request);
        return elementTypeDto;
    }

    @GetMapping("/all/element/types")
    public List<ElementTypeDto> findAllElementTypes() {
        List<ElementTypeDto> elementTypeDtos = elementTypeService.findAllElementTypes();
        return elementTypeDtos;
    }

    @GetMapping("/find/element/type/by/name")
    public ElementTypeDto findElementTypesByName(@RequestParam String elementTypeRequest) {
        ElementTypeDto response = elementTypeService.findElementTypesByName(elementTypeRequest);
        return response;
    }

    @PostMapping("/add/new/costume")
    public CostumeDto addNewCostume(@RequestBody CostumeDto request) {
        CostumeDto costumeDto = costumeService.addNewCostume(request);
        return costumeDto;
    }

    @GetMapping("/all/costumes")
    public List<CostumeDto> findAllCostumes() {
        List<CostumeDto> costumeDtos = costumeService.findAllCostumes();
        return costumeDtos;
    }



}
