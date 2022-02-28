package ee.bcs.folkcostumes.userManagement.contact;

import ee.bcs.folkcostumes.userManagement.user.UserContactDataRequest;
import ee.bcs.folkcostumes.userManagement.userReport.FirstLastNames;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact contactDtoToContact(ContactDto contactDto);

    ContactDto contactToContactDto(Contact contact);
    List<ContactDto> contactsToContactDtos(List<Contact> contacts);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromContactDto(ContactDto contactDto, @MappingTarget Contact contact);

    Contact userDataRequestToContact(UserContactDataRequest userDataRequest);

    Contact contactResponseToContact(ContactResponse contactResponse);

    ContactResponse contactToContactResponse(Contact contact);
    List<ContactResponse> contactsToContactResponses(List<Contact> contacts);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromContactResponse(ContactResponse contactResponse, @MappingTarget Contact contact);

    FirstLastNames contactToFirstLastName(Contact contact);
    List <FirstLastNames> contactsToFirstLastName(List <Contact> contacts);

}
