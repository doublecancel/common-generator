package opt.core;

public enum Type {
    EQ(1),//==
    LIKE(2),//%abc%
    LEFT_LIKE(4),//%abc
    LIKE_RIGHT(8),//abc%
    GT(16),//>=
    LT(32);//<=
    private Integer key;

    Type(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }
}
