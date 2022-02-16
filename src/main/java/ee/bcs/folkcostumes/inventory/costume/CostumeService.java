package ee.bcs.folkcostumes.inventory.costume;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CostumeService {

    @Resource private CostumeRepository costumeRepository;
    @Resource private CostumeMapper costumeMapper;

    public CostumeDto addNewCostume(CostumeDto request) {
        Costume newCostume = costumeMapper.costumeDtoToCostume(request);
        costumeRepository.save(newCostume);
        CostumeDto costumeDto = costumeMapper.costumeToCostumeDto(newCostume);
        return costumeDto;
    }

    public List<CostumeDto> findAllCostumes() {
        List<Costume> costumes = costumeRepository.findAll();
        List<CostumeDto> costumeDtos = costumeMapper.costumesToCostumeDtos(costumes);
        return costumeDtos;
    }


}
