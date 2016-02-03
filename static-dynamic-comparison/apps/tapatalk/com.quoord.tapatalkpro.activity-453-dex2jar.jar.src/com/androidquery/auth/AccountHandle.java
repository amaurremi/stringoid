package com.androidquery.auth;

import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;

import java.net.HttpURLConnection;
import java.util.LinkedHashSet;

import org.apache.http.HttpRequest;

public abstract class AccountHandle {
    private LinkedHashSet<AbstractAjaxCallback<?, ?>> callbacks;

    public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpURLConnection paramHttpURLConnection) {
    }

    public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpRequest paramHttpRequest) {
    }

    protected abstract void auth();

    /* Error */
    public void auth(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   6: ifnonnull +30 -> 36
        //   9: aload_0
        //   10: new 24	java/util/LinkedHashSet
        //   13: dup
        //   14: invokespecial 25	java/util/LinkedHashSet:<init>	()V
        //   17: putfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   20: aload_0
        //   21: getfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   24: aload_1
        //   25: invokevirtual 29	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
        //   28: pop
        //   29: aload_0
        //   30: invokevirtual 31	com/androidquery/auth/AccountHandle:auth	()V
        //   33: aload_0
        //   34: monitorexit
        //   35: return
        //   36: aload_0
        //   37: getfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   40: aload_1
        //   41: invokevirtual 29	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
        //   44: pop
        //   45: goto -12 -> 33
        //   48: astore_1
        //   49: aload_0
        //   50: monitorexit
        //   51: aload_1
        //   52: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	53	0	this	AccountHandle
        //   0	53	1	paramAbstractAjaxCallback	AbstractAjaxCallback<?, ?>
        // Exception table:
        //   from	to	target	type
        //   2	33	48	finally
        //   36	45	48	finally
    }

    public abstract boolean authenticated();

    public abstract boolean expired(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, AjaxStatus paramAjaxStatus);

    /* Error */
    protected void failure(android.content.Context paramContext, int paramInt, String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   6: ifnull +25 -> 31
        //   9: aload_0
        //   10: getfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   13: invokevirtual 42	java/util/LinkedHashSet:iterator	()Ljava/util/Iterator;
        //   16: astore_1
        //   17: aload_1
        //   18: invokeinterface 47 1 0
        //   23: ifne +11 -> 34
        //   26: aload_0
        //   27: aconst_null
        //   28: putfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   31: aload_0
        //   32: monitorexit
        //   33: return
        //   34: aload_1
        //   35: invokeinterface 51 1 0
        //   40: checkcast 53	com/androidquery/callback/AbstractAjaxCallback
        //   43: iload_2
        //   44: aload_3
        //   45: invokevirtual 56	com/androidquery/callback/AbstractAjaxCallback:failure	(ILjava/lang/String;)V
        //   48: goto -31 -> 17
        //   51: astore_1
        //   52: aload_0
        //   53: monitorexit
        //   54: aload_1
        //   55: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	56	0	this	AccountHandle
        //   0	56	1	paramContext	android.content.Context
        //   0	56	2	paramInt	int
        //   0	56	3	paramString	String
        // Exception table:
        //   from	to	target	type
        //   2	17	51	finally
        //   17	31	51	finally
        //   34	48	51	finally
    }

    public String getCacheUrl(String paramString) {
        return paramString;
    }

    public String getNetworkUrl(String paramString) {
        return paramString;
    }

    public abstract boolean reauth(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback);

    /* Error */
    protected void success(android.content.Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   6: ifnull +25 -> 31
        //   9: aload_0
        //   10: getfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   13: invokevirtual 42	java/util/LinkedHashSet:iterator	()Ljava/util/Iterator;
        //   16: astore_2
        //   17: aload_2
        //   18: invokeinterface 47 1 0
        //   23: ifne +11 -> 34
        //   26: aload_0
        //   27: aconst_null
        //   28: putfield 22	com/androidquery/auth/AccountHandle:callbacks	Ljava/util/LinkedHashSet;
        //   31: aload_0
        //   32: monitorexit
        //   33: return
        //   34: aload_2
        //   35: invokeinterface 51 1 0
        //   40: checkcast 53	com/androidquery/callback/AbstractAjaxCallback
        //   43: aload_1
        //   44: invokevirtual 66	com/androidquery/callback/AbstractAjaxCallback:async	(Landroid/content/Context;)V
        //   47: goto -30 -> 17
        //   50: astore_1
        //   51: aload_0
        //   52: monitorexit
        //   53: aload_1
        //   54: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	55	0	this	AccountHandle
        //   0	55	1	paramContext	android.content.Context
        //   16	19	2	localIterator	java.util.Iterator
        // Exception table:
        //   from	to	target	type
        //   2	17	50	finally
        //   17	31	50	finally
        //   34	47	50	finally
    }

    public void unauth() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/auth/AccountHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */