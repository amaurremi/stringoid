/*    */
package android.util;

/*    */
/*    */ public class StateSet {
    /*  4 */   StateSet() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static boolean isWildCard(int[] stateSetOrSpec) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static boolean stateSetMatches(int[] stateSpec, int[] stateSet) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static boolean stateSetMatches(int[] stateSpec, int state) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static int[] trimStateSet(int[] states, int newSize) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static String dump(int[] states) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */   public static final int[] WILD_CARD = null;
    /* 11 */   public static final int[] NOTHING = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/util/StateSet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */