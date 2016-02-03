/*    */
package android.content;
/*    */ 
/*    */

import java.io.PrintWriter;

/*    */
/*  5 */ public abstract class AsyncTaskLoader<D> extends Loader<D> {
    public AsyncTaskLoader(Context context) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void setUpdateThrottle(long delayMS) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    protected void onForceLoad() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    protected boolean onCancelLoad() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void onCanceled(D data) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract D loadInBackground();

    /* 11 */
    protected D onLoadInBackground() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void cancelLoadInBackground() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean isLoadInBackgroundCanceled() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void dump(String prefix, java.io.FileDescriptor fd, PrintWriter writer, String[] args) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/AsyncTaskLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */