/*    */
package android.os;

/*    */
/*    */ public class Process {
    /*  4 */
    public Process() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public static final native long getElapsedCpuTime();

    /*    */
    public static final native int myPid();

    /*    */
    public static final native int myTid();

    /*    */
    public static final native int myUid();

    /*    */
    public static final native int getUidForName(String paramString);

    /*    */
    public static final native int getGidForName(String paramString);

    /*    */
    public static final native void setThreadPriority(int paramInt1, int paramInt2) throws IllegalArgumentException, SecurityException;

    /*    */
    public static final native void setThreadPriority(int paramInt) throws IllegalArgumentException, SecurityException;

    /*    */
    public static final native int getThreadPriority(int paramInt) throws IllegalArgumentException;

    /*    */
    @Deprecated
/* 15 */ public static final boolean supportsProcesses() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static final void killProcess(int pid) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int SYSTEM_UID = 1000;
    /*    */   public static final int PHONE_UID = 1001;
    /*    */   public static final int FIRST_APPLICATION_UID = 10000;
    /*    */   public static final int LAST_APPLICATION_UID = 19999;
    /*    */   public static final int BLUETOOTH_GID = 2000;
    /*    */   public static final int THREAD_PRIORITY_DEFAULT = 0;
    /*    */   public static final int THREAD_PRIORITY_LOWEST = 19;
    /*    */   public static final int THREAD_PRIORITY_BACKGROUND = 10;
    /*    */   public static final int THREAD_PRIORITY_FOREGROUND = -2;
    /*    */   public static final int THREAD_PRIORITY_DISPLAY = -4;
    /*    */   public static final int THREAD_PRIORITY_URGENT_DISPLAY = -8;
    /*    */   public static final int THREAD_PRIORITY_AUDIO = -16;
    /*    */   public static final int THREAD_PRIORITY_URGENT_AUDIO = -19;
    /*    */   public static final int THREAD_PRIORITY_MORE_FAVORABLE = -1;
    /*    */   public static final int THREAD_PRIORITY_LESS_FAVORABLE = 1;
    /*    */   public static final int SIGNAL_QUIT = 3;
    /*    */   public static final int SIGNAL_KILL = 9;
    /*    */   public static final int SIGNAL_USR1 = 10;

    /*    */
    public static final native void sendSignal(int paramInt1, int paramInt2);
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/Process.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */