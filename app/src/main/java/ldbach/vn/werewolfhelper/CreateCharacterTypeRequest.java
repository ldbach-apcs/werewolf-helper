package ldbach.vn.werewolfhelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

class CreateCharacterTypeRequest {

    String characterName;
    Party party;
    ArrayList<ActiveSkill> activeSkills;
    ArrayList<PassiveSkill> passiveSkills;

    public CreateCharacterTypeRequest
            (String characterName, Party party,
             ArrayList<ActiveSkill> activeSkills, ArrayList<PassiveSkill> passiveSkills) {
        this.characterName = characterName;
        this.party = party;
        this.activeSkills = activeSkills;
        this.passiveSkills = passiveSkills;
    }
}
