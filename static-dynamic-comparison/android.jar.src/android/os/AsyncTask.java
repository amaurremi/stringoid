/*    */
package android.os;
/*    */ 
/*    */

import java.util.concurrent.Executor;

/*    */
/*    */ public abstract class AsyncTask<Params, Progress, Result> {
    /*  6 */   public static enum Status {
        FINISHED,
        /*  7 */     PENDING,
        /*  8 */     RUNNING;

        /*    */
        private Status() {
        }
    }

    /* 10 */
    public AsyncTask() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public final Status getStatus() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    protected abstract Result doInBackground(Params... paramVarArgs);

    /* 13 */
    protected void onPreExecute() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 15 */
    protected void onPostExecute(Result result) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 17 */
    protected void onProgressUpdate(Progress... values) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 19 */
    protected void onCancelled(Result result) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected void onCancelled() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public final boolean isCancelled() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public final boolean cancel(boolean mayInterruptIfRunning) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final Result get() throws InterruptedException, java.util.concurrent.ExecutionException {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public final Result get(long timeout, java.util.concurrent.TimeUnit unit) throws InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public final AsyncTask<Params, Progress, Result> execute(Params... params) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor exec, Params... params) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public static void execute(Runnable runnable) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    protected final void publishProgress(Progress... values) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/* 31 */   public static final Executor SERIAL_EXECUTOR = null;
    public static final Executor THREAD_POOL_EXECUTOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/AsyncTask.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */