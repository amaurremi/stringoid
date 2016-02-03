package com.facebook;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

@TargetApi(3)
public class RequestAsyncTask
        extends AsyncTask<Void, Void, List<Response>> {
    private static final String TAG = RequestAsyncTask.class.getCanonicalName();
    private static Method executeOnExecutorMethod;
    private final HttpURLConnection connection;
    private Exception exception;
    private final RequestBatch requests;

    static {
        Method[] arrayOfMethod = AsyncTask.class.getMethods();
        int j = arrayOfMethod.length;
        int i = 0;
        for (; ; ) {
            if (i < j) {
                Method localMethod = arrayOfMethod[i];
                if ("executeOnExecutor".equals(localMethod.getName())) {
                    Class[] arrayOfClass = localMethod.getParameterTypes();
                    if ((arrayOfClass.length == 2) && (arrayOfClass[0] == Executor.class) && (arrayOfClass[1].isArray())) {
                        executeOnExecutorMethod = localMethod;
                    }
                }
            } else {
                return;
            }
            i += 1;
        }
    }

    public RequestAsyncTask(RequestBatch paramRequestBatch) {
        this(null, paramRequestBatch);
    }

    public RequestAsyncTask(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch) {
        this.requests = paramRequestBatch;
        this.connection = paramHttpURLConnection;
    }

    public RequestAsyncTask(HttpURLConnection paramHttpURLConnection, Collection<Request> paramCollection) {
        this(paramHttpURLConnection, new RequestBatch(paramCollection));
    }

    public RequestAsyncTask(HttpURLConnection paramHttpURLConnection, Request... paramVarArgs) {
        this(paramHttpURLConnection, new RequestBatch(paramVarArgs));
    }

    public RequestAsyncTask(Collection<Request> paramCollection) {
        this(null, new RequestBatch(paramCollection));
    }

    public RequestAsyncTask(Request... paramVarArgs) {
        this(null, new RequestBatch(paramVarArgs));
    }

    protected List<Response> doInBackground(Void... paramVarArgs) {
        try {
            if (this.connection == null) {
                return this.requests.executeAndWait();
            }
            paramVarArgs = Request.executeConnectionAndWait(this.connection, this.requests);
            return paramVarArgs;
        } catch (Exception paramVarArgs) {
            this.exception = paramVarArgs;
        }
        return null;
    }

    RequestAsyncTask executeOnSettingsExecutor() {
        try {
            if (executeOnExecutorMethod != null) {
                executeOnExecutorMethod.invoke(this, new Object[]{Settings.getExecutor(), null});
                return this;
            }
        } catch (IllegalAccessException localIllegalAccessException) {
            execute(new Void[0]);
            return this;
        } catch (InvocationTargetException localInvocationTargetException) {
            for (; ; ) {
            }
        }
    }

    protected final Exception getException() {
        return this.exception;
    }

    protected final RequestBatch getRequests() {
        return this.requests;
    }

    protected void onPostExecute(List<Response> paramList) {
        super.onPostExecute(paramList);
        if (this.exception != null) {
            Log.d(TAG, String.format("onPostExecute: exception encountered during request: %s", new Object[]{this.exception.getMessage()}));
        }
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (this.requests.getCallbackHandler() == null) {
            this.requests.setCallbackHandler(new Handler());
        }
    }

    public String toString() {
        return "{RequestAsyncTask: " + " connection: " + this.connection + ", requests: " + this.requests + "}";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/RequestAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */