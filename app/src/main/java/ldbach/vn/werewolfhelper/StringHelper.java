package ldbach.vn.werewolfhelper;

import java.util.ArrayList;

class StringHelper {
    static String createUniqueName(
            String toCreateName, ArrayList<String> existingNames) {
        if (existingNames.size() == 0)
            return toCreateName;

        return "NonsenseName";
    }
}
