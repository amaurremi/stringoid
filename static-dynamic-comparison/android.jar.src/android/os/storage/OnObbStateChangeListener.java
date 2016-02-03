/*   */
package android.os.storage;

/*   */
/*   */ public abstract class OnObbStateChangeListener {
    /* 4 */
    public OnObbStateChangeListener() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public void onObbStateChange(String path, int state) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int MOUNTED = 1;
    /*   */   public static final int UNMOUNTED = 2;
    /*   */   public static final int ERROR_INTERNAL = 20;
    /*   */   public static final int ERROR_COULD_NOT_MOUNT = 21;
    /*   */   public static final int ERROR_COULD_NOT_UNMOUNT = 22;
    /*   */   public static final int ERROR_NOT_MOUNTED = 23;
    /*   */   public static final int ERROR_ALREADY_MOUNTED = 24;
    /*   */   public static final int ERROR_PERMISSION_DENIED = 25;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/storage/OnObbStateChangeListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */