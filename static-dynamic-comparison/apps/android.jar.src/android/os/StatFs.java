/*   */
package android.os;

/*   */
/*   */ public class StatFs {
    /* 4 */
    public StatFs(String path) {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public void restat(String path) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */
    public native int getBlockSize();

    /*   */
/*   */
    public native int getBlockCount();

    /*   */
/*   */
    public native int getFreeBlocks();

    /*   */
/*   */
    public native int getAvailableBlocks();
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/StatFs.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */