/*   */
package android.app.backup;

/*   */
/*   */ public abstract class RestoreObserver {
    /* 4 */
    public RestoreObserver() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public void restoreStarting(int numPackages) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public void onUpdate(int nowBeingRestored, String currentPackage) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void restoreFinished(int error) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/backup/RestoreObserver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */