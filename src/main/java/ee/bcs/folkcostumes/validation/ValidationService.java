package ee.bcs.folkcostumes.validation;

import ee.bcs.folkcostumes.infrastructure.exception.DataNotFoundException;
import ee.bcs.folkcostumes.userManagement.group.Group;
import ee.bcs.folkcostumes.userManagement.user.User;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ValidationService {

    public static final String EI_EKSISTEERI = "ei eksisteeri.";

    public static final Integer USER_NOT_EXISTS_ERROR_CODE = 1;
    public static final Integer GROUP_NOT_EXISTS_ERROR_CODE = 2;
    public static final Integer WRONG_PASSWORD = 3;
    public static final Integer ALREADY_EXISTING_USERNAME = 4;
    private static final Integer ALREADY_EXISTING_COSTUMENAME = 5;
    private static final Integer ALREADY_EXISTING_ELEMENT_TYPE_NAME = 6;

    public void userExists(Optional<User> user, String username) {
        if (user.isEmpty()) {
            String message = "Kasutajat " + username + EI_EKSISTEERI;
            throw new DataNotFoundException(message, USER_NOT_EXISTS_ERROR_CODE);
        }
    }

    public void passwordIsCorrect(User user, String password) {
        if (!user.getPassword().equals(password)) {
            String message = "Sisestasid: " + password + "\n See ei ole õige salasõna!";
            throw new DataNotFoundException(message, WRONG_PASSWORD);
        }
    }

    public void groupAlreadyExists(Optional<Group> group, String groupName) {
        if (group.isEmpty()) {
            String message = "Gruppi " + groupName + EI_EKSISTEERI;
            throw new DataNotFoundException(message, GROUP_NOT_EXISTS_ERROR_CODE);
        }
    }

    public void UserNameAlreadyExists(boolean userNameExists) {
        if (userNameExists) {
            String message = "Selline kasutajanimi on juba olemas!";
            throw new DataNotFoundException(message, ALREADY_EXISTING_USERNAME);
        }
    }

    public void costumeNameAlreadyExists(boolean existsByName, String newName) {
        if (existsByName) {
            String message = "Nimega /" + newName + "/ komplekt on juba olemas";
            throw new DataNotFoundException(message, ALREADY_EXISTING_COSTUMENAME);
        }
    }

    public void elementTypeNameAlreadyExists(boolean existsByElementType, String newName) {
        if (existsByElementType) {
            String message = "Nimega /" + newName + "/ elemendi tüüp on juba olemas";
            throw new DataNotFoundException(message, ALREADY_EXISTING_ELEMENT_TYPE_NAME);
        }
    }
}
