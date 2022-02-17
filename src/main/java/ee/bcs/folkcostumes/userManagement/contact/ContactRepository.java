package ee.bcs.folkcostumes.userManagement.contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Integer findByName(String firstName, String lastName);

}