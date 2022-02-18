package ee.bcs.folkcostumes.userManagement.contact;

import ee.bcs.folkcostumes.userManagement.user.UserDataRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact contactDtoToContact(ContactDto contactDto);

    ContactDto contactToContactDto(Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromContactDto(ContactDto contactDto, @MappingTarget Contact contact);

    Contact userDataRequestToContact(UserDataRequest userDataRequest);

    Contact contactResponseToContact(ContactResponse contactResponse);

    @Mapping(target = "userId", source = "user.id")
    ContactResponse contactToContactResponse(Contact contact);

    List<ContactResponse> contactsToContactResponses(List<Contact> contacts);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromContactResponse(ContactResponse contactResponse, @MappingTarget Contact contact);
}
