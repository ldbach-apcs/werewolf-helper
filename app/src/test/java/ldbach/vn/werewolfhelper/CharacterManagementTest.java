package ldbach.vn.werewolfhelper;

import net.bytebuddy.dynamic.TypeResolutionStrategy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CharacterManagementTest {

    private CharacterManager characterManager;
    private CreateCharacterTypeRequest createRequest;

    @Before
    public void setup() {
        characterManager = new CharacterManager();

        String characterName = "Villager";
        Party party = new VillagerParty();
        ArrayList<ActiveSkill> activeSkills = new ArrayList<ActiveSkill>() {{
            add(new SleepThroughTheNight());
        }};
        ArrayList<PassiveSkill> passiveSkills = new ArrayList<PassiveSkill>() {{
            add(new  Uselessness());
        }};

        createRequest = new CreateCharacterTypeRequest
                (characterName, party, activeSkills, passiveSkills);
    }

    @Test
    public void testCreateCharacterTypeSuccess() {
        WereWolfCharacter c = characterManager.createCharacterType(createRequest);
        assertEquals("Villager", c.getCharacterName());
    }

    @Test(expected = CharacterTypeExistException.class)
    public void testCreateCharacterTypeFail_TypeAlreadyExist() {
        characterManager.createCharacterType(createRequest);
        characterManager.createCharacterType(createRequest);
    }

    @Test
    public void testCreateCharacterSameNameDifferentActiveSkills() {
        WereWolfCharacter c1 = characterManager.createCharacterType(createRequest);
        createRequest.activeSkills = new ArrayList<ActiveSkill>() {{
            add(new NightlyInstantKill());
        }};
        WereWolfCharacter c2 = characterManager.createCharacterType(createRequest);
        assertNotEquals(c1, c2);
    }

    @Test
    public void testCreateCharacterSameNameDifferentPassiveSkills() {
        WereWolfCharacter c1 = characterManager.createCharacterType(createRequest);
        createRequest.passiveSkills = new ArrayList<PassiveSkill>() {{
            add(new ImmuneToNightlyInstantKill());
        }};

        WereWolfCharacter c2 = characterManager.createCharacterType(createRequest);
        assertNotEquals(c1, c2);
    }

    @Test
    public void testCreateCharacterResolveNameConflict() {
        WereWolfCharacter c1 = characterManager.createCharacterType(createRequest);
        createRequest.passiveSkills = new ArrayList<PassiveSkill>() {{
            add(new ImmuneToNightlyInstantKill());
        }};

        WereWolfCharacter c2 = characterManager.createCharacterType(createRequest);
        assertNotEquals(c1.getCharacterName(), c2.getCharacterName());
    }

    @Test
    public void testDeleteAllCharacterTypes() {
        characterManager.removeAllCharacterTypes();
        assertEquals(0, characterManager.getAllCharacterTypes().size());
    }

    @Test
    public void testDeleteSpecificCharacterType() {
        WereWolfCharacter c = characterManager.createCharacterType(createRequest);
        characterManager.removeCharacterType(c);
        assertFalse(characterManager
                .getAllCharacterTypes().contains(c));
    }

}