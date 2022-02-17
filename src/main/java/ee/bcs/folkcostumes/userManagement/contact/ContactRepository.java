package ee.bcs.folkcostumes.userManagement.contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Contact findByUser_Username(String username);

    Contact findByFirstnameAndLastname(String firstname, String lastname);



    Contact findByUser_Id(Integer id);



}