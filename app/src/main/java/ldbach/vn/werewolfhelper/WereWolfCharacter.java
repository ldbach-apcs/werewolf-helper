package ldbach.vn.werewolfhelper;

import java.util.ArrayList;

class WereWolfCharacter {
    private String characterName;
    private ArrayList<ActiveSkill> activeSkills;
    private ArrayList<PassiveSkill> passiveSkills;

    WereWolfCharacter(String characterName,
                      ArrayList<ActiveSkill> activeSkills,
                      ArrayList<PassiveSkill> passiveSkills) {
        this.characterName = characterName;
        this.activeSkills = activeSkills;
        this.passiveSkills = passiveSkills;
    }

    String getCharacterName() {
        return this.characterName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof WereWolfCharacter))
            return false;

        WereWolfCharacter other = (WereWolfCharacter) obj;
        return other.characterName.equals(this.characterName)
                && SkillHelper.isActiveTheSame(other.activeSkills, this.activeSkills)
                && SkillHelper.isPassiveTheSame(other.passiveSkills, this.passiveSkills);
    }

    WereWolfCharacter withName(String resolvedName) {
        return new WereWolfCharacter(resolvedName, this.activeSkills, this.passiveSkills);
    }


}
