package com.mopub.mobileads.util.vast;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.common.util.Strings;

import java.lang.ref.WeakReference;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public class VastXmlManagerAggregator
        extends AsyncTask<String, Void, List<b>> {
    private final WeakReference<e> a;
    private int b;

    VastXmlManagerAggregator(e parame) {
        this.a = new WeakReference(parame);
    }

    String a(AndroidHttpClient paramAndroidHttpClient, String paramString) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramString != null) {
            localObject1 = localObject2;
            if (this.b < 20) {
                this.b += 1;
                paramAndroidHttpClient = paramAndroidHttpClient.execute(new HttpGet(paramString)).getEntity();
                localObject1 = localObject2;
                if (paramAndroidHttpClient != null) {
                    localObject1 = Strings.fromStream(paramAndroidHttpClient.getContent());
                }
            }
        }
        return (String) localObject1;
    }

    /* Error */
    protected List<b> a(String... paramVarArgs) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: invokestatic 64	com/mopub/common/HttpClient:getHttpClient	()Landroid/net/http/AndroidHttpClient;
        //   5: astore_3
        //   6: aload_3
        //   7: astore_2
        //   8: aload_1
        //   9: ifnull +142 -> 151
        //   12: aload_1
        //   13: arraylength
        //   14: ifle +137 -> 151
        //   17: aload_1
        //   18: iconst_0
        //   19: aaload
        //   20: astore_3
        //   21: new 66	java/util/ArrayList
        //   24: dup
        //   25: invokespecial 67	java/util/ArrayList:<init>	()V
        //   28: astore_1
        //   29: aload_3
        //   30: ifnull +55 -> 85
        //   33: aload_3
        //   34: invokevirtual 73	java/lang/String:length	()I
        //   37: ifle +48 -> 85
        //   40: aload_0
        //   41: invokevirtual 77	com/mopub/mobileads/util/vast/VastXmlManagerAggregator:isCancelled	()Z
        //   44: ifne +41 -> 85
        //   47: new 79	com/mopub/mobileads/util/vast/b
        //   50: dup
        //   51: invokespecial 80	com/mopub/mobileads/util/vast/b:<init>	()V
        //   54: astore 4
        //   56: aload 4
        //   58: aload_3
        //   59: invokevirtual 82	com/mopub/mobileads/util/vast/b:a	(Ljava/lang/String;)V
        //   62: aload_1
        //   63: aload 4
        //   65: invokeinterface 88 2 0
        //   70: pop
        //   71: aload_0
        //   72: aload_2
        //   73: aload 4
        //   75: invokevirtual 91	com/mopub/mobileads/util/vast/b:a	()Ljava/lang/String;
        //   78: invokevirtual 93	com/mopub/mobileads/util/vast/VastXmlManagerAggregator:a	(Landroid/net/http/AndroidHttpClient;Ljava/lang/String;)Ljava/lang/String;
        //   81: astore_3
        //   82: goto -53 -> 29
        //   85: aload_1
        //   86: astore_3
        //   87: aload_2
        //   88: ifnull +9 -> 97
        //   91: aload_2
        //   92: invokevirtual 96	android/net/http/AndroidHttpClient:close	()V
        //   95: aload_1
        //   96: astore_3
        //   97: aload_3
        //   98: areturn
        //   99: astore_3
        //   100: aconst_null
        //   101: astore_1
        //   102: ldc 98
        //   104: aload_3
        //   105: invokestatic 104	com/mopub/common/logging/MoPubLog:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   108: aload_1
        //   109: astore_3
        //   110: aload_2
        //   111: ifnull -14 -> 97
        //   114: aload_2
        //   115: invokevirtual 96	android/net/http/AndroidHttpClient:close	()V
        //   118: aload_1
        //   119: areturn
        //   120: astore_1
        //   121: aconst_null
        //   122: astore_2
        //   123: aload_2
        //   124: ifnull +7 -> 131
        //   127: aload_2
        //   128: invokevirtual 96	android/net/http/AndroidHttpClient:close	()V
        //   131: aload_1
        //   132: athrow
        //   133: astore_1
        //   134: goto -11 -> 123
        //   137: astore_1
        //   138: goto -15 -> 123
        //   141: astore_3
        //   142: aconst_null
        //   143: astore_1
        //   144: goto -42 -> 102
        //   147: astore_3
        //   148: goto -46 -> 102
        //   151: aconst_null
        //   152: astore_1
        //   153: goto -68 -> 85
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	156	0	this	VastXmlManagerAggregator
        //   0	156	1	paramVarArgs	String[]
        //   1	127	2	localObject1	Object
        //   5	93	3	localObject2	Object
        //   99	6	3	localException1	Exception
        //   109	1	3	arrayOfString	String[]
        //   141	1	3	localException2	Exception
        //   147	1	3	localException3	Exception
        //   54	20	4	localb	b
        // Exception table:
        //   from	to	target	type
        //   2	6	99	java/lang/Exception
        //   2	6	120	finally
        //   12	17	133	finally
        //   21	29	133	finally
        //   33	82	133	finally
        //   102	108	137	finally
        //   12	17	141	java/lang/Exception
        //   21	29	141	java/lang/Exception
        //   33	82	147	java/lang/Exception
    }

    protected void a(List<b> paramList) {
        e locale = (e) this.a.get();
        if (locale != null) {
            locale.onAggregationComplete(paramList);
        }
    }

    protected void onCancelled() {
        e locale = (e) this.a.get();
        if (locale != null) {
            locale.onAggregationComplete(null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/vast/VastXmlManagerAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */