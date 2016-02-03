/*   */
package android.text;

/*   */
/*   */ public class AndroidCharacter {
    /* 4 */
    public AndroidCharacter() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int EAST_ASIAN_WIDTH_NEUTRAL = 0;
    /*   */   public static final int EAST_ASIAN_WIDTH_AMBIGUOUS = 1;
    /*   */   public static final int EAST_ASIAN_WIDTH_HALF_WIDTH = 2;
    /*   */   public static final int EAST_ASIAN_WIDTH_FULL_WIDTH = 3;
    /*   */   public static final int EAST_ASIAN_WIDTH_NARROW = 4;
    /*   */   public static final int EAST_ASIAN_WIDTH_WIDE = 5;

    /*   */
    public static native void getDirectionalities(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt);

    /*   */
/*   */
    public static native int getEastAsianWidth(char paramChar);

    /*   */
/*   */
    public static native void getEastAsianWidths(char[] paramArrayOfChar, int paramInt1, int paramInt2, byte[] paramArrayOfByte);

    /*   */
/*   */
    public static native boolean mirror(char[] paramArrayOfChar, int paramInt1, int paramInt2);

    /*   */
/*   */
    public static native char getMirror(char paramChar);
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/AndroidCharacter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */