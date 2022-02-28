package ee.bcs.folkcostumes.userManagement.contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Contact findByFirstnameAndLastname(String firstname, String lastname);

    Contact findByUser_Id(Integer id);

    boolean existsByFirstnameAndLastname(String firstname, String lastname);



}