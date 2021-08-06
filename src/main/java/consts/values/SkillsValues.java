package consts.values;

public enum SkillsValues {
    Java    ("Java"),
    Java2   ("Java"),
    Java3   ("Java"),
    Java4   ("Java"),
    ANDROID ("Android"),
    IOS     ("iOS"),
    PHP     ("PHP"),
    ENGLISH ("English"),
    Unity   ("Unity/C#"),
    SAP     ("SAP"),
    RPA     ("RPA");

    private final String skill;

    SkillsValues(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }
}
