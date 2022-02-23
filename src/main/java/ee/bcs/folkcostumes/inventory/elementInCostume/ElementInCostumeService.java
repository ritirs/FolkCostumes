package ee.bcs.folkcostumes.inventory.elementInCostume;

import ee.bcs.folkcostumes.inventory.costume.Costume;
import ee.bcs.folkcostumes.inventory.costume.CostumeService;
import ee.bcs.folkcostumes.inventory.element.Element;
import ee.bcs.folkcostumes.inventory.element.ElementDto;
import ee.bcs.folkcostumes.inventory.element.ElementService;
import ee.bcs.folkcostumes.inventory.elementType.ElementType;
import ee.bcs.folkcostumes.userManagement.group.Group;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroup;
import ee.bcs.folkcostumes.userManagement.roleType.RoleType;
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

    public List<ElementInCostumeRequest> getElementsByTypeName(String elementTypeName) {
        List<ElementInCostumeRequest> elements = new ArrayList<>();
        ElementType type = elementService.getElementTypeByName(elementTypeName);
        Boolean answer = elementInCostumeRepository.existsByElement_ElementType(type);
        validationService.elementTypeExistsInElementsInCostumes(answer, elementTypeName);
        List<ElementInCostume> allElementsInCostume = elementInCostumeRepository.findAll();
        for (ElementInCostume elementInCostume : allElementsInCostume) {
            if (elementInCostume.getElement().getElementType() == type) {
                elements.add(elementInCostumeMapper.elementsInCostumeToElementCostumeRequests(elementInCostume));
            }
        }
        return elements;
    }

//   Todo: siia tuleb sisse kirjutada kontroll, kas elementTYPE on juba olemas ja kas Costume on juba olemas
    public void addNewElement(List<ElementInCostumeWideRequest> elementsRequest) {
        for (ElementInCostumeWideRequest elementRequest : elementsRequest) {
            Element element = elementService.addNewElement(elementRequest);
            Costume costume = costumeService.getCostumeByName(elementRequest.getCostumeName());
            ElementInCostume elementInCostume = new ElementInCostume();
            elementInCostume.setElement(element);
            elementInCostume.setCostume(costume);
            elementInCostumeRepository.save(elementInCostume);
        }

//        public void addNewRoleInGroup(User user, RoleType roleType, Group group, String firstname, String lastname) {
//            RoleInGroup roleInGroup = new RoleInGroup();
//            roleInGroup.setUser(user);
//            roleInGroup.setGroup(group);
//            roleInGroup.setRoleType(roleType);
//            validationService.roleExists(roleInGroupRepository.existsByRoleTypeAndGroupAndUser(roleType,group,user), firstname, lastname);
//            roleInGroupRepository.save(roleInGroup);


    }

    public List<String> getElementsByCostume(String costumeName) {
        Costume costume = costumeService.getCostumeByName(costumeName);
        Boolean answer = elementInCostumeRepository.existsByCostume_Name(costumeName);
        validationService.elementTypeExistsInElementsInCostumes(answer, costumeName);
        List<String> elementNames = new ArrayList<>();
        List<ElementInCostume> allElementsInCostume = elementInCostumeRepository.findAll();
        for (ElementInCostume elementInCostume : allElementsInCostume) {
            if (elementInCostume.getCostume() == costume) {
                elementNames.add(elementInCostume.getElement().getElementName());
            }
        }
        return elementNames;

    }
}
