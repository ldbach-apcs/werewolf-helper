package ldbach.vn.werewolfhelper;

class PassiveSkill {
    @Override
    public boolean equals(Object obj) {
        // Same class means same skill
        return obj.getClass().equals(this.getClass());
    }
}
