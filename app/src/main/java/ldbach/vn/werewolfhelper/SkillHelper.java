package ldbach.vn.werewolfhelper;

import java.util.ArrayList;

class SkillHelper {
    static boolean isActiveTheSame(ArrayList<ActiveSkill> skills1,
                                     ArrayList<ActiveSkill> skills2) {
        if (skills1.size() != skills2.size()) {
            return false;
        }

        for (ActiveSkill active : skills1) {
            if (!skills2.contains(active)) {
                return false;
            }
        }

        return true;
    }

    static boolean isPassiveTheSame(ArrayList<PassiveSkill> skills1,
                                     ArrayList<PassiveSkill> skills2) {
        if (skills1.size() != skills2.size()) {
            return false;
        }

        for (PassiveSkill active : skills1) {
            if (!skills2.contains(active)) {
                return false;
            }
        }

        return true;
    }
}
