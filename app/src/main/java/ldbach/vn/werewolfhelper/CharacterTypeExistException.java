package ldbach.vn.werewolfhelper;

class CharacterTypeExistException extends IllegalArgumentException {
    CharacterTypeExistException() {
        super("There exist a type that is exactly the same");
    }
}
