package ee.bcs.folkcostumes.inventory.costume;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumeRepository extends JpaRepository<Costume, Integer> {

    boolean existsByName(String name);

    Costume findByName(String name);




}