package ldbach.vn.werewolfhelper;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;

class CharacterManager {

    private Collection<WereWolfCharacter> existingCharacter = new ArrayList<>();

    WereWolfCharacter createCharacterType(CreateCharacterTypeRequest request) {
        WereWolfCharacter toCreate = new
                WereWolfCharacter(request.characterName, request.activeSkills, request.passiveSkills);

        if (!isCharacterTypeExists(toCreate)) {
            String toCreateName = toCreate.getCharacterName();
            ArrayList<String> existingNames = new ArrayList<String>() {{
                for (WereWolfCharacter c : existingCharacter) {
                    String characterName = c.getCharacterName();
                    if (characterName.startsWith(toCreateName)) {
                        add(characterName);
                    }
                }
            }};

            String resolvedName = StringHelper.createUniqueName(toCreateName, existingNames);
            WereWolfCharacter createdCharacter = toCreate.withName(resolvedName);
            existingCharacter.add(createdCharacter);
            return createdCharacter;
        }

        throw new CharacterTypeExistException();
    }

    private boolean isCharacterTypeExists(WereWolfCharacter character) {
        return existingCharacter.contains(character);
    }

    void removeAllCharacterTypes() {
        this.existingCharacter.clear();
    }

    Collection<WereWolfCharacter> getAllCharacterTypes() {
        return this.existingCharacter;
    }

    void removeCharacterType(WereWolfCharacter character) {
        this.existingCharacter.remove(character);
    }
}
