package ee.bcs.folkcostumes.inventory.costume;


import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CostumeService {

    @Resource
    private CostumeRepository costumeRepository;
    @Resource
    private CostumeMapper costumeMapper;
    @Resource
    private ValidationService validationService;

    public void addNewCostume(String name) {
        Costume newCostume = costumeMapper.nameToCostume(name);
        costumeRepository.save(newCostume);
    }

    public void addCostumesList(List<String> costumes) {
        for (String costume : costumes) {
            addNewCostume(costume);
        }
    }

    public List<CostumeDto> getAllCostumes() {
        List<Costume> costumes = costumeRepository.findAll();
        return costumeMapper.costumesToCostumeDtos(costumes);
    }

    public List<String> getAllCostumeNames() {
        List<String> costumeNames = new ArrayList<>();
        List<CostumeDto> allCostumes = getAllCostumes();
        for (CostumeDto costume : allCostumes) {
            costumeNames.add(costume.getName());
        }
        return costumeNames;
    }

    public String updateCostumeName(String oldName, String newName) {
        validationService.costumeNameAlreadyExists(costumeRepository.existsByName(newName), newName);
        Costume costume = costumeRepository.findByName(oldName);
        costume.setName(newName);
        return "Endine nimetus \"" + oldName + " asendatud uue nimetusega \"" + newName;
    }
}
