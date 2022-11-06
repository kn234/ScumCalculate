package stringToListOfPerson;

import java.util.ArrayList;
import java.util.List;
import model.Person;

public class StringToListOfPerson {
    public static List<Person> stringToList(String str) {
        StringBuilder humanName = new StringBuilder("");
        List result = new ArrayList<>();
        StringBuilder strWithEnd = new StringBuilder(str);
        strWithEnd.append(" ");
        for (int i = 0; i < strWithEnd.length(); i++) {
            if (Character.isAlphabetic(strWithEnd.charAt(i))) {
                humanName.append(str.charAt(i));
            } else {
                Person human = new Person(humanName.toString());
                result.add(human);
                humanName.delete(0, humanName.length());
            }
        }
        return result;
    }
}