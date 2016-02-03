package twitter4j;

import java.io.Serializable;

public abstract interface MediaEntity$Size
        extends Serializable {
    public static final int CROP = 101;
    public static final int FIT = 100;
    public static final Integer LARGE = Integer.valueOf(3);
    public static final Integer MEDIUM;
    public static final Integer SMALL;
    public static final Integer THUMB = Integer.valueOf(0);

    static {
        SMALL = Integer.valueOf(1);
        MEDIUM = Integer.valueOf(2);
    }

    public abstract int getHeight();

    public abstract int getResize();

    public abstract int getWidth();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/MediaEntity$Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */