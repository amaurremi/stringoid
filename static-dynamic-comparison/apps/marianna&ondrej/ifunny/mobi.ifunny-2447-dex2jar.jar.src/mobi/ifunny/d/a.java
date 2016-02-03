package mobi.ifunny.d;

import android.support.v4.app.k;
import android.text.TextUtils;

import java.io.IOException;
import java.io.Reader;

import mobi.ifunny.l.h;
import mobi.ifunny.l.i;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;
import retrofit.RetrofitError.Kind;

public abstract class a<T extends h, Result>
        extends i<T, Void, Integer, Result> {
    private final AbstractHttpClient a;
    private final HttpContext b;
    private final String c;
    private final String d;
    private final c e;
    private final RestHttpHandler<Result, T> f;
    private RestError g;

    public a(k paramk, T paramT, String paramString1, AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, String paramString2, String paramString3, c paramc, RestHttpHandler<Result, T> paramRestHttpHandler) {
        super(paramT, paramString1);
        this.a = paramAbstractHttpClient;
        this.b = paramHttpContext;
        this.c = paramString2;
        this.d = paramString3;
        this.e = paramc;
        this.f = paramRestHttpHandler;
    }

    private static String a(String paramString, c paramc) {
        String str = paramString;
        if (paramc != null) {
            paramc = paramc.c();
            str = paramString + "?" + paramc;
        }
        return str;
    }

    protected abstract Result a(Reader paramReader);

    /* Error */
    protected Result a(HttpResponse paramHttpResponse) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aload_1
        //   4: invokeinterface 71 1 0
        //   9: astore_3
        //   10: aload_3
        //   11: invokeinterface 77 1 0
        //   16: istore_2
        //   17: iload_2
        //   18: sipush 300
        //   21: if_icmplt +22 -> 43
        //   24: aload_0
        //   25: iload_2
        //   26: aload_3
        //   27: invokeinterface 80 1 0
        //   32: invokestatic 86	mobi/ifunny/rest/content/RestError:httpError	(ILjava/lang/String;)Lmobi/ifunny/rest/content/RestError;
        //   35: putfield 88	mobi/ifunny/d/a:g	Lmobi/ifunny/rest/content/RestError;
        //   38: aload 5
        //   40: astore_3
        //   41: aload_3
        //   42: areturn
        //   43: aload_1
        //   44: invokeinterface 92 1 0
        //   49: astore_1
        //   50: aload_1
        //   51: ifnull +146 -> 197
        //   54: new 94	java/io/BufferedReader
        //   57: dup
        //   58: new 96	java/io/InputStreamReader
        //   61: dup
        //   62: aload_1
        //   63: invokeinterface 102 1 0
        //   68: ldc 104
        //   70: invokespecial 107	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   73: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   76: astore_1
        //   77: aload_1
        //   78: astore_3
        //   79: aload_0
        //   80: aload_1
        //   81: invokevirtual 112	mobi/ifunny/d/a:a	(Ljava/io/Reader;)Ljava/lang/Object;
        //   84: astore 4
        //   86: aload 4
        //   88: astore_3
        //   89: aload_1
        //   90: ifnull -49 -> 41
        //   93: aload_1
        //   94: invokevirtual 117	java/io/Reader:close	()V
        //   97: aload 4
        //   99: areturn
        //   100: astore_1
        //   101: aload 4
        //   103: areturn
        //   104: astore 4
        //   106: aconst_null
        //   107: astore_1
        //   108: aload_1
        //   109: astore_3
        //   110: aload_0
        //   111: aload 4
        //   113: invokestatic 121	mobi/ifunny/rest/content/RestError:unexpectedError	(Ljava/lang/Throwable;)Lmobi/ifunny/rest/content/RestError;
        //   116: putfield 88	mobi/ifunny/d/a:g	Lmobi/ifunny/rest/content/RestError;
        //   119: aload 5
        //   121: astore_3
        //   122: aload_1
        //   123: ifnull -82 -> 41
        //   126: aload_1
        //   127: invokevirtual 117	java/io/Reader:close	()V
        //   130: aconst_null
        //   131: areturn
        //   132: astore_1
        //   133: aconst_null
        //   134: areturn
        //   135: astore 4
        //   137: aconst_null
        //   138: astore_1
        //   139: aload_1
        //   140: astore_3
        //   141: aload_0
        //   142: aload 4
        //   144: invokestatic 121	mobi/ifunny/rest/content/RestError:unexpectedError	(Ljava/lang/Throwable;)Lmobi/ifunny/rest/content/RestError;
        //   147: putfield 88	mobi/ifunny/d/a:g	Lmobi/ifunny/rest/content/RestError;
        //   150: aload 5
        //   152: astore_3
        //   153: aload_1
        //   154: ifnull -113 -> 41
        //   157: aload_1
        //   158: invokevirtual 117	java/io/Reader:close	()V
        //   161: aconst_null
        //   162: areturn
        //   163: astore_1
        //   164: aconst_null
        //   165: areturn
        //   166: astore_1
        //   167: aconst_null
        //   168: astore_3
        //   169: aload_3
        //   170: ifnull +7 -> 177
        //   173: aload_3
        //   174: invokevirtual 117	java/io/Reader:close	()V
        //   177: aload_1
        //   178: athrow
        //   179: astore_3
        //   180: goto -3 -> 177
        //   183: astore_1
        //   184: goto -15 -> 169
        //   187: astore 4
        //   189: goto -50 -> 139
        //   192: astore 4
        //   194: goto -86 -> 108
        //   197: aconst_null
        //   198: astore_1
        //   199: goto -122 -> 77
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	202	0	this	a
        //   0	202	1	paramHttpResponse	HttpResponse
        //   16	10	2	i	int
        //   9	165	3	localObject1	Object
        //   179	1	3	localIOException1	IOException
        //   84	18	4	localObject2	Object
        //   104	8	4	localIOException2	IOException
        //   135	8	4	localException1	Exception
        //   187	1	4	localException2	Exception
        //   192	1	4	localIOException3	IOException
        //   1	150	5	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   93	97	100	java/io/IOException
        //   43	50	104	java/io/IOException
        //   54	77	104	java/io/IOException
        //   126	130	132	java/io/IOException
        //   43	50	135	java/lang/Exception
        //   54	77	135	java/lang/Exception
        //   157	161	163	java/io/IOException
        //   43	50	166	finally
        //   54	77	166	finally
        //   173	177	179	java/io/IOException
        //   79	86	183	finally
        //   110	119	183	finally
        //   141	150	183	finally
        //   79	86	187	java/lang/Exception
        //   79	86	192	java/io/IOException
    }

    protected Result a(Void... paramVarArgs) {
        for (; ; ) {
            try {
                if (TextUtils.equals("GET", this.c)) {
                    paramVarArgs = new HttpGet(a(this.d, this.e));
                    if (isCanceled()) {
                        return null;
                    }
                } else {
                    if (!TextUtils.equals("POST", this.c)) {
                        break label322;
                    }
                    localHttpPost = new HttpPost(this.d);
                    paramVarArgs = localHttpPost;
                    if (this.e == null) {
                        continue;
                    }
                    localHttpPost.setEntity(this.e.a());
                    paramVarArgs = localHttpPost;
                    continue;
                }
                localHttpRequestRetryHandler = this.a.getHttpRequestRetryHandler();
            } catch (Exception paramVarArgs) {
                this.g = RestError.unexpectedError(paramVarArgs);
                return null;
            }
            HttpRequestRetryHandler localHttpRequestRetryHandler;
            int i = 0;
            boolean bool = true;
            HttpPost localHttpPost = null;
            IOException localIOException2;
            while (bool) {
                if (isCanceled()) {
                    return null;
                }
                publishProgress(new Integer[]{Integer.valueOf(0)});
                Object localObject;
                try {
                    if (TextUtils.equals("POST", paramVarArgs.getMethod())) {
                        localObject = ((HttpPost) paramVarArgs).getEntity();
                        if ((localObject instanceof f)) {
                            ((f) localObject).a(new b(this));
                        }
                    }
                    localObject = this.a.execute(paramVarArgs, this.b);
                    if (!isCanceled()) {
                        break label298;
                    }
                    return null;
                } catch (IOException localIOException1) {
                    i += 1;
                    bool = localHttpRequestRetryHandler.retryRequest(localIOException1, i, this.b);
                } catch (NullPointerException localNullPointerException) {
                    localIOException2 = new IOException("NPE in HttpClient\n" + localNullPointerException.getMessage());
                    i += 1;
                    bool = localHttpRequestRetryHandler.retryRequest(localIOException2, i, this.b);
                }
                continue;
                label298:
                if (localObject != null) {
                    return (Result) a((HttpResponse) localObject);
                }
            }
            this.g = RestError.unexpectedError(localIOException2);
            continue;
            label322:
            paramVarArgs = null;
        }
    }

    protected void a(T paramT, Integer... paramVarArgs) {
        super.onProgressUpdate(paramT, paramVarArgs);
        this.f.onProgressCallback(paramT, paramVarArgs[0].intValue());
    }

    protected void onCancelled(T paramT, Result paramResult) {
        super.onCancelled(paramT, paramResult);
        if (this.f != null) {
            this.f.onCancelCallback(paramT);
        }
    }

    protected void onFinished(T paramT) {
        super.onFinished(paramT);
        if (this.f != null) {
            this.f.onFinishCallback(paramT);
        }
    }

    protected void onPostExecute(T paramT, Result paramResult) {
        if (this.f != null) {
            if (this.g == null) {
                break label60;
            }
            if (this.g.getErrorKind() != RetrofitError.Kind.HTTP) {
                this.f.onExceptionCallback(paramT, this.g.getCause());
            }
        } else {
            return;
        }
        this.f.onFailureCallback(paramT, this.g);
        return;
        label60:
        this.f.onSuccessCallback(paramT, paramResult);
    }

    protected void onStarted(T paramT) {
        super.onStarted(paramT);
        if (this.f != null) {
            this.f.onStartCallback(paramT);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */