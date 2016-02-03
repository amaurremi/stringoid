package android.support.v4.a;

import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class u
        extends FutureTask<Result> {
    u(r paramr, Callable paramCallable) {
        super(paramCallable);
    }

    protected void done() {
        try {
            Object localObject = get();
            r.b(this.a, localObject);
            return;
        } catch (InterruptedException localInterruptedException) {
            Log.w("AsyncTask", localInterruptedException);
            return;
        } catch (ExecutionException localExecutionException) {
            throw new RuntimeException("An error occured while executing doInBackground()", localExecutionException.getCause());
        } catch (CancellationException localCancellationException) {
            r.b(this.a, null);
            return;
        } catch (Throwable localThrowable) {
            throw new RuntimeException("An error occured while executing doInBackground()", localThrowable);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */