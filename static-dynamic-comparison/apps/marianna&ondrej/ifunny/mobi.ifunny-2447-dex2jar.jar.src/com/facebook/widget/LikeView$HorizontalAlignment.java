package com.facebook.widget;

public enum LikeView$HorizontalAlignment {
    CENTER("center", 0), LEFT("left", 1), RIGHT("right", 2);

    static HorizontalAlignment DEFAULT = CENTER;
    private int intValue;
    private String stringValue;

    private LikeView$HorizontalAlignment(String paramString, int paramInt) {
        this.stringValue = paramString;
        this.intValue = paramInt;
    }

    static HorizontalAlignment fromInt(int paramInt) {
        HorizontalAlignment[] arrayOfHorizontalAlignment = values();
        int j = arrayOfHorizontalAlignment.length;
        int i = 0;
        while (i < j) {
            HorizontalAlignment localHorizontalAlignment = arrayOfHorizontalAlignment[i];
            if (localHorizontalAlignment.getValue() == paramInt) {
                return localHorizontalAlignment;
            }
            i += 1;
        }
        return null;
    }

    private int getValue() {
        return this.intValue;
    }

    public String toString() {
        return this.stringValue;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/LikeView$HorizontalAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */