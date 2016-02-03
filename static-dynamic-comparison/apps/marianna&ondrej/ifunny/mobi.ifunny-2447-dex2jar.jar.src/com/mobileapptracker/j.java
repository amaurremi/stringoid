package com.mobileapptracker;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

final class j {
    private HttpClient a;

    public j() {
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 60000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
        this.a = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
    }

    /* Error */
    public final org.json.JSONObject a(String paramString, org.json.JSONObject paramJSONObject) {
        // Byte code:
        //   0: aload_2
        //   1: ifnull +10 -> 11
        //   4: aload_2
        //   5: invokevirtual 93	org/json/JSONObject:length	()I
        //   8: ifne +179 -> 187
        //   11: aload_0
        //   12: getfield 83	com/mobileapptracker/j:a	Lorg/apache/http/client/HttpClient;
        //   15: new 95	org/apache/http/client/methods/HttpGet
        //   18: dup
        //   19: aload_1
        //   20: invokespecial 98	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
        //   23: invokeinterface 104 2 0
        //   28: astore_1
        //   29: aload_1
        //   30: ifnull +232 -> 262
        //   33: aload_1
        //   34: invokeinterface 110 1 0
        //   39: astore_2
        //   40: aload_1
        //   41: ldc 112
        //   43: invokeinterface 116 2 0
        //   48: astore_3
        //   49: ldc 118
        //   51: new 120	java/lang/StringBuilder
        //   54: dup
        //   55: ldc 122
        //   57: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   60: aload_2
        //   61: invokeinterface 128 1 0
        //   66: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   69: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   72: invokestatic 142	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   75: pop
        //   76: aload_2
        //   77: invokeinterface 128 1 0
        //   82: sipush 200
        //   85: if_icmplt +185 -> 270
        //   88: aload_2
        //   89: invokeinterface 128 1 0
        //   94: sipush 299
        //   97: if_icmpgt +173 -> 270
        //   100: new 144	java/io/BufferedReader
        //   103: dup
        //   104: new 146	java/io/InputStreamReader
        //   107: dup
        //   108: aload_1
        //   109: invokeinterface 150 1 0
        //   114: invokeinterface 156 1 0
        //   119: ldc 54
        //   121: invokespecial 159	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   124: invokespecial 162	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   127: astore_1
        //   128: new 120	java/lang/StringBuilder
        //   131: dup
        //   132: invokespecial 163	java/lang/StringBuilder:<init>	()V
        //   135: astore_2
        //   136: aload_1
        //   137: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   140: astore_3
        //   141: aload_3
        //   142: ifnonnull +101 -> 243
        //   145: aload_1
        //   146: invokevirtual 169	java/io/BufferedReader:close	()V
        //   149: aload_2
        //   150: invokevirtual 170	java/lang/StringBuilder:length	()I
        //   153: ifle +109 -> 262
        //   156: new 89	org/json/JSONObject
        //   159: dup
        //   160: new 172	org/json/JSONTokener
        //   163: dup
        //   164: aload_2
        //   165: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   168: invokespecial 173	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
        //   171: invokespecial 176	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
        //   174: astore_1
        //   175: aload_1
        //   176: areturn
        //   177: astore_1
        //   178: aload_1
        //   179: invokevirtual 179	java/lang/Exception:printStackTrace	()V
        //   182: aconst_null
        //   183: astore_1
        //   184: goto -155 -> 29
        //   187: new 181	org/apache/http/entity/StringEntity
        //   190: dup
        //   191: aload_2
        //   192: invokevirtual 182	org/json/JSONObject:toString	()Ljava/lang/String;
        //   195: invokespecial 183	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
        //   198: astore_2
        //   199: aload_2
        //   200: ldc -71
        //   202: invokevirtual 188	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
        //   205: new 190	org/apache/http/client/methods/HttpPost
        //   208: dup
        //   209: aload_1
        //   210: invokespecial 191	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
        //   213: astore_1
        //   214: aload_1
        //   215: aload_2
        //   216: invokevirtual 195	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
        //   219: aload_0
        //   220: getfield 83	com/mobileapptracker/j:a	Lorg/apache/http/client/HttpClient;
        //   223: aload_1
        //   224: invokeinterface 104 2 0
        //   229: astore_1
        //   230: goto -201 -> 29
        //   233: astore_1
        //   234: aload_1
        //   235: invokevirtual 179	java/lang/Exception:printStackTrace	()V
        //   238: aconst_null
        //   239: astore_1
        //   240: goto -211 -> 29
        //   243: aload_2
        //   244: aload_3
        //   245: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   248: ldc -56
        //   250: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   253: pop
        //   254: goto -118 -> 136
        //   257: astore_1
        //   258: aload_1
        //   259: invokevirtual 179	java/lang/Exception:printStackTrace	()V
        //   262: new 89	org/json/JSONObject
        //   265: dup
        //   266: invokespecial 201	org/json/JSONObject:<init>	()V
        //   269: areturn
        //   270: aload_2
        //   271: invokeinterface 128 1 0
        //   276: sipush 400
        //   279: if_icmpne -17 -> 262
        //   282: aload_3
        //   283: ifnull -21 -> 262
        //   286: ldc 118
        //   288: ldc -53
        //   290: invokestatic 142	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   293: pop
        //   294: aconst_null
        //   295: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	296	0	this	j
        //   0	296	1	paramString	String
        //   0	296	2	paramJSONObject	org.json.JSONObject
        //   48	235	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	29	177	java/lang/Exception
        //   187	230	233	java/lang/Exception
        //   33	136	257	java/lang/Exception
        //   136	141	257	java/lang/Exception
        //   145	175	257	java/lang/Exception
        //   243	254	257	java/lang/Exception
        //   270	282	257	java/lang/Exception
        //   286	294	257	java/lang/Exception
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mobileapptracker/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */