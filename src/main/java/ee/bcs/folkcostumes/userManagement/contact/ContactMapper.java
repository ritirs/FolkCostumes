package ee.bcs.folkcostumes.userManagement.contact;

import ee.bcs.folkcostumes.userManagement.UserDataRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact contactDtoToContact(ContactDto contactDto);

    ContactDto contactToContactDto(Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromContactDto(ContactDto contactDto, @MappingTarget Contact contact);

    @Mapping(target = "user.username", source = "username")
    Contact userDataRequestToContact(UserDataRequest userDataRequest);

    UserDataRequest contactToUserDataRequest(Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromUserDataRequest(UserDataRequest userDataRequest, @MappingTarget Contact contact);

    Contact contactResponseToContact(ContactResponse contactResponse);

    ContactResponse contactToContactResponse(Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromContactResponse(ContactResponse contactResponse, @MappingTarget Contact contact);
}
