/*   */
package android.app;

/*   */
/*   */ public class UiModeManager {
    /* 4 */   UiModeManager() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public void enableCarMode(int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public void disableCarMode(int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public int getCurrentModeType() {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public void setNightMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public int getNightMode() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static String ACTION_ENTER_CAR_MODE;
    /*   */   public static String ACTION_EXIT_CAR_MODE;
    /*   */   public static String ACTION_ENTER_DESK_MODE;
    /*   */   public static String ACTION_EXIT_DESK_MODE;
    /*   */   public static final int MODE_NIGHT_AUTO = 0;
    /*   */   public static final int MODE_NIGHT_NO = 1;
    /*   */   public static final int MODE_NIGHT_YES = 2;
    /*   */   public static final int ENABLE_CAR_MODE_GO_CAR_HOME = 1;
    /*   */   public static final int DISABLE_CAR_MODE_GO_HOME = 1;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/UiModeManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */