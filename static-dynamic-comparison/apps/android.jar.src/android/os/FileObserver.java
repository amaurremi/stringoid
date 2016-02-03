/*   */
package android.os;

/*   */
/*   */ public abstract class FileObserver {
    /* 4 */
    public FileObserver(String path) {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public FileObserver(String path, int mask) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void startWatching() {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public void stopWatching() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int ACCESS = 1;
    /*   */   public static final int MODIFY = 2;
    /*   */   public static final int ATTRIB = 4;
    /*   */   public static final int CLOSE_WRITE = 8;
    /*   */   public static final int CLOSE_NOWRITE = 16;
    /*   */   public static final int OPEN = 32;
    /*   */   public static final int MOVED_FROM = 64;
    /*   */   public static final int MOVED_TO = 128;
    /*   */   public static final int CREATE = 256;
    /*   */   public static final int DELETE = 512;
    /*   */   public static final int DELETE_SELF = 1024;
    /*   */   public static final int MOVE_SELF = 2048;
    /*   */   public static final int ALL_EVENTS = 4095;

    /*   */
    public abstract void onEvent(int paramInt, String paramString);
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/FileObserver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */