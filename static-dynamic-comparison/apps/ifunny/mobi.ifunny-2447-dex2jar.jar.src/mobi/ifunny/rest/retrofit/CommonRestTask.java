package mobi.ifunny.rest.retrofit;

import java.util.concurrent.Callable;

import mobi.ifunny.l.h;
import mobi.ifunny.l.i;
import retrofit.RetrofitError;

public abstract class CommonRestTask<Target extends h, Result>
        extends i<Target, Void, Integer, CommonRestTask.RestResult<Result>> {
    public static final int RETRIES_COUNT_DEFAULT = 3;
    private final Callable<Result> callable;
    private int retriesCount;

    public CommonRestTask(Target paramTarget, String paramString, Callable<Result> paramCallable, int paramInt) {
        super(paramTarget, paramString);
        this.callable = paramCallable;
        this.retriesCount = paramInt;
    }

    public static <T> CommonRestTask.RestResult<T> callWithRetries(Callable<T> paramCallable, int paramInt) {
        return callWithRetries(paramCallable, null, paramInt);
    }

    public static <T> CommonRestTask.RestResult<T> callWithRetries(Callable<T> paramCallable, CommonRestTask.CancelHandler paramCancelHandler, int paramInt) {
        if ((paramCallable == null) || (paramInt <= 0)) {
            throw new IllegalArgumentException();
        }
        CommonRestTask.RestResult localRestResult = new CommonRestTask.RestResult();
        for (; ; ) {
            if ((paramInt > 0) && ((paramCancelHandler == null) || (!paramCancelHandler.isCallCanceled()))) {
            }
            try {
                localRestResult.result = paramCallable.call();
                localRestResult.error = null;
                return localRestResult;
            } catch (RetrofitError localRetrofitError) {
                if (!localRetrofitError.isNetworkError()) {
                    localRestResult.error = localRetrofitError;
                    return localRestResult;
                }
                paramInt -= 1;
            } catch (Exception paramCallable) {
                localRestResult.error = paramCallable;
            }
        }
        return localRestResult;
    }

    protected CommonRestTask.RestResult<Result> doInBackground(Void... paramVarArgs) {
        return callWithRetries(this.callable, new CommonRestTask .1 (this), this.retriesCount);
    }

    protected void onCancel(Target paramTarget) {
    }

    protected final void onCancelled(Target paramTarget, CommonRestTask.RestResult<Result> paramRestResult) {
        super.onCancelled(paramTarget, paramRestResult);
        onCancel(paramTarget);
    }

    protected abstract void onFail(Target paramTarget, Throwable paramThrowable);

    protected void onPostExecute(Target paramTarget, CommonRestTask.RestResult<Result> paramRestResult) {
        super.onPostExecute(paramTarget, paramRestResult);
        if (paramRestResult == null) {
            onFail(paramTarget, new IllegalArgumentException("Result is null"));
            return;
        }
        if (paramRestResult.error == null) {
            onSuccess(paramTarget, paramRestResult.result);
            return;
        }
        onFail(paramTarget, paramRestResult.error);
    }

    protected abstract void onSuccess(Target paramTarget, Result paramResult);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/CommonRestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */