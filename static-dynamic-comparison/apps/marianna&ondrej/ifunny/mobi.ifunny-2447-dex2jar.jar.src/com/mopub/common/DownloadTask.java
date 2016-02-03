package com.mopub.common;

import android.os.AsyncTask;
import org.apache.http.client.methods.HttpUriRequest;

public class DownloadTask
        extends AsyncTask<HttpUriRequest, Void, DownloadResponse> {
    private final DownloadTask.DownloadTaskListener a;
    private String b;

    public DownloadTask(DownloadTask.DownloadTaskListener paramDownloadTaskListener) {
        if (paramDownloadTaskListener == null) {
            throw new IllegalArgumentException("DownloadTaskListener must not be null.");
        }
        this.a = paramDownloadTaskListener;
    }

    /* Error */
    protected DownloadResponse a(HttpUriRequest... paramVarArgs) {
        // Byte code:
        //   0: aload_1
        //   1: ifnull +14 -> 15
        //   4: aload_1
        //   5: arraylength
        //   6: ifeq +9 -> 15
        //   9: aload_1
        //   10: iconst_0
        //   11: aaload
        //   12: ifnonnull +12 -> 24
        //   15: ldc 29
        //   17: invokestatic 34	com/mopub/common/logging/MoPubLog:d	(Ljava/lang/String;)V
        //   20: aconst_null
        //   21: astore_1
        //   22: aload_1
        //   23: areturn
        //   24: aload_1
        //   25: iconst_0
        //   26: aaload
        //   27: astore_3
        //   28: aload_0
        //   29: aload_3
        //   30: invokeinterface 40 1 0
        //   35: invokevirtual 46	java/net/URI:toString	()Ljava/lang/String;
        //   38: putfield 48	com/mopub/common/DownloadTask:b	Ljava/lang/String;
        //   41: invokestatic 54	com/mopub/common/HttpClient:getHttpClient	()Landroid/net/http/AndroidHttpClient;
        //   44: astore_2
        //   45: aload_2
        //   46: astore_1
        //   47: new 56	com/mopub/common/DownloadResponse
        //   50: dup
        //   51: aload_2
        //   52: aload_3
        //   53: invokevirtual 62	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   56: invokespecial 65	com/mopub/common/DownloadResponse:<init>	(Lorg/apache/http/HttpResponse;)V
        //   59: astore_3
        //   60: aload_3
        //   61: astore_1
        //   62: aload_2
        //   63: ifnull -41 -> 22
        //   66: aload_2
        //   67: invokevirtual 68	android/net/http/AndroidHttpClient:close	()V
        //   70: aload_3
        //   71: areturn
        //   72: astore_3
        //   73: aconst_null
        //   74: astore_2
        //   75: aload_2
        //   76: astore_1
        //   77: ldc 70
        //   79: aload_3
        //   80: invokestatic 73	com/mopub/common/logging/MoPubLog:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   83: aload_2
        //   84: astore_1
        //   85: aload_0
        //   86: iconst_1
        //   87: invokevirtual 77	com/mopub/common/DownloadTask:cancel	(Z)Z
        //   90: pop
        //   91: aload_2
        //   92: ifnull +7 -> 99
        //   95: aload_2
        //   96: invokevirtual 68	android/net/http/AndroidHttpClient:close	()V
        //   99: aconst_null
        //   100: areturn
        //   101: astore_2
        //   102: aconst_null
        //   103: astore_1
        //   104: aload_1
        //   105: ifnull +7 -> 112
        //   108: aload_1
        //   109: invokevirtual 68	android/net/http/AndroidHttpClient:close	()V
        //   112: aload_2
        //   113: athrow
        //   114: astore_2
        //   115: goto -11 -> 104
        //   118: astore_3
        //   119: goto -44 -> 75
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	122	0	this	DownloadTask
        //   0	122	1	paramVarArgs	HttpUriRequest[]
        //   44	52	2	localAndroidHttpClient	android.net.http.AndroidHttpClient
        //   101	12	2	localObject1	Object
        //   114	1	2	localObject2	Object
        //   27	44	3	localObject3	Object
        //   72	8	3	localException1	Exception
        //   118	1	3	localException2	Exception
        // Exception table:
        //   from	to	target	type
        //   41	45	72	java/lang/Exception
        //   41	45	101	finally
        //   47	60	114	finally
        //   77	83	114	finally
        //   85	91	114	finally
        //   47	60	118	java/lang/Exception
    }

    protected void a(DownloadResponse paramDownloadResponse) {
        if (isCancelled()) {
            onCancelled();
            return;
        }
        this.a.onComplete(this.b, paramDownloadResponse);
    }

    protected void onCancelled() {
        this.a.onComplete(this.b, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/DownloadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */