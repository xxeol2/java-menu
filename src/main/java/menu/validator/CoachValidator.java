package menu.validator;

import menu.exception.WrongCoachNameException;

public class CoachValidator {

    public static final int COACH_NAME_MIN_LENGTH = 2;
    public static final int COACH_NAME_MAX_LENGTH = 4;
    
    public static void validateCoachName(String name) {
        if (!verifyNameLength(name)) {
            throw new WrongCoachNameException();
        }
    }

    private static boolean verifyNameLength(String name) {
        return name.length() >= COACH_NAME_MIN_LENGTH && name.length() <= COACH_NAME_MAX_LENGTH;
    }
}
