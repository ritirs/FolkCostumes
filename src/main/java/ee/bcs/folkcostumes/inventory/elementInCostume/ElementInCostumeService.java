package ee.bcs.folkcostumes.inventory.elementInCostume;

import ee.bcs.folkcostumes.inventory.costume.CostumeService;
import ee.bcs.folkcostumes.inventory.element.Element;
import ee.bcs.folkcostumes.inventory.element.ElementDto;
import ee.bcs.folkcostumes.inventory.element.ElementService;
import ee.bcs.folkcostumes.inventory.elementType.ElementType;
import ee.bcs.folkcostumes.userManagement.user.User;
import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ElementInCostumeService {

    @Resource
    private ElementService elementService;
    @Resource
    private CostumeService costumeService;
    @Resource
    private ElementInCostumeRepository elementInCostumeRepository;
    @Resource
    private ElementInCostumeMapper elementInCostumeMapper;
    @Resource
    private ValidationService validationService;


//    public List<ElementInCostume> getAllElementsInCostumes() {
//        List<ElementInCostume> elementsInCostumes = elementInCostumeRepository.findAll();
////        return elementInCostumeMapper.elementsInCostumeToElementCostumeRequests(elementsInCostumes);
//        return elementsInCostumes;
//    }

    public List<ElementInCostumeDtoLarge> getAllElementDetails() {
        List<ElementInCostumeDtoLarge> elementDetails = new ArrayList<>();
        List<ElementInCostume> elementsInCostumes = elementInCostumeRepository.findAll();
        for (ElementInCostume element : elementsInCostumes) {
            elementDetails.add(elementInCostumeMapper.elementInCostumeToElementInCostumeDtoLarge(element));
        }
        return elementDetails;
    }

    //    EI TÖÖTA! List<ElementInCostumeRequest> Kõik seelikud
    public List<ElementInCostumeRequest> getElementsByTypeName(String elementTypeName) {
        List<ElementInCostumeRequest> elements = new ArrayList<>();
        ElementType type = elementService.getElementTypeByName(elementTypeName);
        Boolean answer = elementInCostumeRepository.existsByElement_ElementType(type);
        validationService.elementTypeExistsInElementsInCostumes(answer, elementTypeName);
        List<ElementInCostume> allElementsInCostume = elementInCostumeRepository.findAll();
        for (ElementInCostume elementInCostume : allElementsInCostume) {
            if (elementInCostume.getElement().getElementType()==type) {
                elements.add(elementInCostumeMapper.elementsInCostumeToElementCostumeRequests(elementInCostume));
            }

        }

//        List<ElementInCostume> elementsInCostumes = elementInCostumeRepository.findByElement_ElementType(type);
//
//        for () {
//        }
//        List<ElementInCostume> elementsInCostumes = elementInCostumeRepository.findByElement_ElementType(type);

//        return elementInCostumeMapper.elementsInCostumeToElementCostumeRequests(elementsInCostumes);
//        return elementsInCostumes;
        return elements;
    }
}

//        List<Element> elements = elementService.getElementsByTypeName(elementTypeName);