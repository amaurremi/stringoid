/*    */
package android.content;
/*    */ 
/*    */

import java.io.PrintWriter;

/*    */
/*    */ public class Loader<D> {
    public static abstract interface OnLoadCanceledListener<D> {
        public abstract void onLoadCanceled(Loader<D> paramLoader);
    }

    /*    */   public static abstract interface OnLoadCompleteListener<D> {
        public abstract void onLoadComplete(Loader<D> paramLoader, D paramD);
    }

    /*  7 */   public final class ForceLoadContentObserver extends android.database.ContentObserver {
        public ForceLoadContentObserver() {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public boolean deliverSelfNotifications() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public void onChange(boolean selfChange) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 19 */
    public Loader(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void deliverResult(D data) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void deliverCancellation() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public Context getContext() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getId() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void registerListener(int id, OnLoadCompleteListener<D> listener) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void unregisterListener(OnLoadCompleteListener<D> listener) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> listener) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> listener) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean isStarted() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean isAbandoned() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean isReset() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public final void startLoading() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    protected void onStartLoading() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean cancelLoad() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    protected boolean onCancelLoad() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void forceLoad() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    protected void onForceLoad() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void stopLoading() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    protected void onStopLoading() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void abandon() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    protected void onAbandon() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void reset() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    protected void onReset() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean takeContentChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void onContentChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public String dataToString(D data) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void dump(String prefix, java.io.FileDescriptor fd, PrintWriter writer, String[] args) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/Loader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */