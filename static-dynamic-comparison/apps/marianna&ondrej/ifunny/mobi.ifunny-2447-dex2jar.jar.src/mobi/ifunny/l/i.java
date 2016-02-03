package mobi.ifunny.l;

import android.os.AsyncTask;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class i<T extends h, Params, Progress, Result> {
    private final AtomicBoolean innerCancelled;
    private final g manager = g.a();
    private final AtomicBoolean silence;
    final String subscribeId;
    final String subscriberName;
    final String tag;
    private final i<T, Params, Progress, Result>.k task;
    private final AtomicBoolean taskFinished;

    public i(T paramT, String paramString) {
        this.tag = g.a(paramT, paramString);
        this.subscribeId = paramT.L_();
        this.subscriberName = paramT.getClass().getSimpleName();
        this.task = new k(this, null);
        this.innerCancelled = new AtomicBoolean(false);
        this.silence = new AtomicBoolean(false);
        this.taskFinished = new AtomicBoolean(false);
    }

    public void cancel(boolean paramBoolean) {
        this.innerCancelled.set(true);
        this.silence.set(paramBoolean);
        this.task.cancel(true);
    }

    protected abstract Result doInBackground(Params... paramVarArgs);

    public i<T, Params, Progress, Result> execute(Params... paramVarArgs) {
        this.manager.a(this);
        this.task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
        return this;
    }

    public boolean isCanceled() {
        return (this.task.isCancelled()) || (this.innerCancelled.get());
    }

    public boolean isSilence() {
        return this.silence.get();
    }

    protected void onCancelled(T paramT, Result paramResult) {
    }

    protected void onFinished(T paramT) {
    }

    protected void onPostExecute(T paramT, Result paramResult) {
    }

    protected void onProgressUpdate(T paramT, Progress... paramVarArgs) {
    }

    protected void onStarted(T paramT) {
    }

    public void publishProgress(Progress... paramVarArgs) {
        this.task.a(paramVarArgs);
    }

    public String toString() {
        return "Task{tag='" + this.tag + '\'' + ", subscriberName='" + this.subscriberName + '\'' + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/l/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */