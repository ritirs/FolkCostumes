package ee.bcs.folkcostumes.validation;

import ee.bcs.folkcostumes.infrastructure.exception.BusinessServiceException;
import ee.bcs.folkcostumes.infrastructure.exception.DataNotFoundException;
import ee.bcs.folkcostumes.userManagement.group.Group;
import ee.bcs.folkcostumes.userManagement.user.User;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ValidationService {

    public static final String EI_EKSISTEERI = "ei eksisteeri.";
    public static final String INSUFFICIENT_BALANCE = "Kasutaja käes/laos pole soovitud kogust.";

    public static final Integer USER_NOT_EXISTS_ERROR_CODE = 1;
    public static final Integer GROUP_NOT_EXISTS_ERROR_CODE = 2;
    public static final Integer WRONG_PASSWORD = 3;
    public static final Integer ALREADY_EXISTING_USERNAME = 4;
    private static final Integer ALREADY_EXISTING_COSTUMENAME = 5;
    private static final Integer ALREADY_EXISTING_ELEMENT_TYPE_NAME = 6;
    private static final Integer NO_SUCH_ELEMENT_TYPE_IN_ELEMENT_IN_COSTUMES = 7;
    private static final Integer ALREADY_EXISTING_ROLE_IN_GROUP = 8;
    private static final Integer ALREADY_EXISTING_ELEMENT_NAME = 9;
    private static final Integer NO_SUCH_COSTUME_IN_ELEMENT_IN_COSTUMES = 10;
    private static final Integer INSUFFICIENT_BALANCE_ERROR_CODE = 11;

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
            String message = "Selline kasutajanimi" + " on juba olemas!";
            throw new DataNotFoundException(message, ALREADY_EXISTING_USERNAME);
        }
    }

    public void costumeNameAlreadyExists(boolean existsByName, String newName) {
        if (existsByName) {
            String message = "Komplekt nimega \"" + newName + "\"" + " on juba olemas!";
            throw new DataNotFoundException(message, ALREADY_EXISTING_COSTUMENAME);
        }
    }

    public void elementTypeNameAlreadyExists(boolean existsByElementType, String newName) {
        if (existsByElementType) {
            String message = "Elemendi tüüp \"" + newName + "\"" + " on juba olemas!";
            throw new DataNotFoundException(message, ALREADY_EXISTING_ELEMENT_TYPE_NAME);
        }
    }

    public void elementTypeExistsInElementsInCostumes(Boolean answer, String elementTypeName) {
        if (!answer) {
            String message = "Elemenditüübiga /" + elementTypeName + "/ elementi ei ole kostüümielementide nimekirjas.";
            throw new DataNotFoundException(message, NO_SUCH_ELEMENT_TYPE_IN_ELEMENT_IN_COSTUMES);
        }
    }

    public void costumeExistsInElementsInCostumes(Boolean answer, String costumeName) {
        if (!answer) {
            String message = "Elemenditüübiga /" + costumeName + "/ elementi ei ole kostüümielementide nimekirjas.";
            throw new DataNotFoundException(message, NO_SUCH_COSTUME_IN_ELEMENT_IN_COSTUMES);
        }
    }

    public void roleExists(Boolean roleAnswer, String firstname, String lastname) {
        if (roleAnswer) {
            String message = "Selline roll kasutajale " + firstname + " " + lastname + " on juba olemas!";
            throw new DataNotFoundException(message, ALREADY_EXISTING_ROLE_IN_GROUP);
        }
    }

    public void elementExistsInElements(Boolean elementAnswer, String elementName) {
        if (elementAnswer) {
            String message = elementName + " on juba olemas!";
            throw new DataNotFoundException(message, ALREADY_EXISTING_ELEMENT_NAME);
        }
    }

    public void locationExists(boolean locationExists, String newLocation) {
        if (locationExists) {
            String message = newLocation + " on juba olemas!";
        }
    }

    public void sufficientBalance(Integer balance, Integer amount) {
        if (amount > balance) {
            throw new BusinessServiceException(INSUFFICIENT_BALANCE, INSUFFICIENT_BALANCE_ERROR_CODE);
        }
    }
}
