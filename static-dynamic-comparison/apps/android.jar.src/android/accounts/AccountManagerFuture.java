package android.accounts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract interface AccountManagerFuture<V> {
    public abstract boolean cancel(boolean paramBoolean);

    public abstract boolean isCancelled();

    public abstract boolean isDone();

    public abstract V getResult()
            throws OperationCanceledException, IOException, AuthenticatorException;

    public abstract V getResult(long paramLong, TimeUnit paramTimeUnit)
            throws OperationCanceledException, IOException, AuthenticatorException;
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/accounts/AccountManagerFuture.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */