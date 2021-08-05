package consts;

public enum SkillsValues {
    VALUE00 ("Java"),
    VALUE01 ("Ruby");

    private final String skill;

    SkillsValues(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }
}
