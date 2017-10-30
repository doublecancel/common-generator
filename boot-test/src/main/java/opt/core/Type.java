package opt.core;

public enum Type {
    EQ(1),//==                         0000 01
    LIKE(2),//%abc%                    0000 10
    LEFT_LIKE(4),//%abc                0001 00
    LIKE_RIGHT(8),//abc%               0010 00
    GT(16),//>=                        0100 00
    LT(32);//<=                        1000 00

    private Integer key;

    Type(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }
}
