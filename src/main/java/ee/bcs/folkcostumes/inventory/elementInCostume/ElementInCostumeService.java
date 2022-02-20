package ee.bcs.folkcostumes.inventory.elementInCostume;

import ee.bcs.folkcostumes.inventory.element.Element;
import ee.bcs.folkcostumes.inventory.element.ElementService;
import ee.bcs.folkcostumes.inventory.elementType.ElementType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ElementInCostumeService {

    @Resource
    private ElementService elementService;
    @Resource
    private ElementInCostumeRepository elementInCostumeRepository;
    @Resource
    private ElementInCostumeMapper elementInCostumeMapper;

//    EI TÖÖTA!
    public List<ElementInCostumeRequest> getElementsByTypeName(String elementTypeName) {
        List<ElementInCostume> elementsInCostumes  = elementInCostumeRepository.findByElement_ElementType_ElementType(elementTypeName);
        return elementInCostumeMapper.elementsInCostumeToElementCostumeRequests(elementsInCostumes);
    }
}

//        List<Element> elements = elementService.getElementsByTypeName(elementTypeName);