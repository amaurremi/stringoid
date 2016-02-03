package com.uservoice.uservoicesdk.rest;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.Session;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;

public class RestTask
        extends AsyncTask<String, String, RestResult> {
    private RestTaskCallback callback;
    private RestMethod method;
    private List<BasicNameValuePair> params;
    private HttpUriRequest request;
    private String urlPath;

    public RestTask(RestMethod paramRestMethod, String paramString, List<BasicNameValuePair> paramList, RestTaskCallback paramRestTaskCallback) {
        this.method = paramRestMethod;
        this.urlPath = paramString;
        this.callback = paramRestTaskCallback;
        this.params = paramList;
    }

    public RestTask(RestMethod paramRestMethod, String paramString, Map<String, String> paramMap, RestTaskCallback paramRestTaskCallback) {
    }

    private HttpUriRequest createRequest()
            throws URISyntaxException, UnsupportedEncodingException {
        String str2 = Session.getInstance().getConfig().getSite();
        Uri.Builder localBuilder = new Uri.Builder();
        if (str2.contains(".us.com")) {
        }
        for (String str1 = "http"; ; str1 = "https") {
            localBuilder.scheme(str1);
            localBuilder.encodedAuthority(str2);
            localBuilder.path(this.urlPath);
            if (this.method != RestMethod.GET) {
                break;
            }
            return requestWithQueryString(new HttpGet(), localBuilder);
        }
        if (this.method == RestMethod.DELETE) {
            return requestWithQueryString(new HttpDelete(), localBuilder);
        }
        if (this.method == RestMethod.POST) {
            return requestWithEntity(new HttpPost(), localBuilder);
        }
        if (this.method == RestMethod.PUT) {
            return requestWithEntity(new HttpPut(), localBuilder);
        }
        throw new IllegalArgumentException("Method must be one of [GET, POST, PUT, DELETE], but was " + this.method);
    }

    public static List<BasicNameValuePair> paramsToList(Map<String, String> paramMap) {
        ArrayList localArrayList = new ArrayList(paramMap.size());
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext()) {
            String str1 = (String) localIterator.next();
            String str2 = (String) paramMap.get(str1);
            if (str2 != null) {
                localArrayList.add(new BasicNameValuePair(str1, str2));
            }
        }
        return localArrayList;
    }

    private HttpUriRequest requestWithEntity(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, Uri.Builder paramBuilder)
            throws UnsupportedEncodingException, URISyntaxException {
        if (this.params != null) {
            paramHttpEntityEnclosingRequestBase.setEntity(new UrlEncodedFormEntity(this.params, "UTF-8"));
        }
        paramHttpEntityEnclosingRequestBase.setURI(new URI(paramBuilder.build().toString()));
        return paramHttpEntityEnclosingRequestBase;
    }

    private HttpUriRequest requestWithQueryString(HttpRequestBase paramHttpRequestBase, Uri.Builder paramBuilder)
            throws URISyntaxException {
        if (this.params != null) {
            Iterator localIterator = this.params.iterator();
            while (localIterator.hasNext()) {
                BasicNameValuePair localBasicNameValuePair = (BasicNameValuePair) localIterator.next();
                paramBuilder.appendQueryParameter(localBasicNameValuePair.getName(), localBasicNameValuePair.getValue());
            }
        }
        paramHttpRequestBase.setURI(new URI(paramBuilder.build().toString()));
        return paramHttpRequestBase;
    }

    /* Error */
    protected RestResult doInBackground(String... paramVarArgs) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore_3
        //   5: aload_0
        //   6: aload_0
        //   7: invokespecial 236	com/uservoice/uservoicesdk/rest/RestTask:createRequest	()Lorg/apache/http/client/methods/HttpUriRequest;
        //   10: putfield 238	com/uservoice/uservoicesdk/rest/RestTask:request	Lorg/apache/http/client/methods/HttpUriRequest;
        //   13: aload_0
        //   14: invokevirtual 241	com/uservoice/uservoicesdk/rest/RestTask:isCancelled	()Z
        //   17: ifeq +44 -> 61
        //   20: new 243	java/lang/InterruptedException
        //   23: dup
        //   24: invokespecial 244	java/lang/InterruptedException:<init>	()V
        //   27: athrow
        //   28: astore 4
        //   30: aconst_null
        //   31: astore_1
        //   32: aload_1
        //   33: astore_3
        //   34: new 246	com/uservoice/uservoicesdk/rest/RestResult
        //   37: dup
        //   38: aload 4
        //   40: invokespecial 249	com/uservoice/uservoicesdk/rest/RestResult:<init>	(Ljava/lang/Exception;)V
        //   43: astore 4
        //   45: aload 4
        //   47: astore_3
        //   48: aload_1
        //   49: ifnull +10 -> 59
        //   52: aload_1
        //   53: invokevirtual 254	android/net/http/AndroidHttpClient:close	()V
        //   56: aload 4
        //   58: astore_3
        //   59: aload_3
        //   60: areturn
        //   61: invokestatic 52	com/uservoice/uservoicesdk/Session:getInstance	()Lcom/uservoice/uservoicesdk/Session;
        //   64: invokevirtual 258	com/uservoice/uservoicesdk/Session:getOAuthConsumer	()Loauth/signpost/OAuthConsumer;
        //   67: astore_1
        //   68: aload_1
        //   69: ifnull +43 -> 112
        //   72: invokestatic 52	com/uservoice/uservoicesdk/Session:getInstance	()Lcom/uservoice/uservoicesdk/Session;
        //   75: invokevirtual 262	com/uservoice/uservoicesdk/Session:getAccessToken	()Lcom/uservoice/uservoicesdk/model/AccessToken;
        //   78: astore 5
        //   80: aload 5
        //   82: ifnull +19 -> 101
        //   85: aload_1
        //   86: aload 5
        //   88: invokevirtual 267	com/uservoice/uservoicesdk/model/AccessToken:getKey	()Ljava/lang/String;
        //   91: aload 5
        //   93: invokevirtual 270	com/uservoice/uservoicesdk/model/AccessToken:getSecret	()Ljava/lang/String;
        //   96: invokeinterface 275 3 0
        //   101: aload_1
        //   102: aload_0
        //   103: getfield 238	com/uservoice/uservoicesdk/rest/RestTask:request	Lorg/apache/http/client/methods/HttpUriRequest;
        //   106: invokeinterface 279 2 0
        //   111: pop
        //   112: ldc_w 281
        //   115: aload_0
        //   116: getfield 25	com/uservoice/uservoicesdk/rest/RestTask:urlPath	Ljava/lang/String;
        //   119: invokestatic 287	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   122: pop
        //   123: aload_0
        //   124: getfield 238	com/uservoice/uservoicesdk/rest/RestTask:request	Lorg/apache/http/client/methods/HttpUriRequest;
        //   127: ldc_w 289
        //   130: invokestatic 295	java/util/Locale:getDefault	()Ljava/util/Locale;
        //   133: invokevirtual 298	java/util/Locale:getLanguage	()Ljava/lang/String;
        //   136: invokeinterface 303 3 0
        //   141: aload_0
        //   142: getfield 238	com/uservoice/uservoicesdk/rest/RestTask:request	Lorg/apache/http/client/methods/HttpUriRequest;
        //   145: ldc_w 305
        //   148: ldc_w 307
        //   151: iconst_1
        //   152: anewarray 309	java/lang/Object
        //   155: dup
        //   156: iconst_0
        //   157: invokestatic 314	com/uservoice/uservoicesdk/UserVoice:getVersion	()Ljava/lang/String;
        //   160: aastore
        //   161: invokestatic 318	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   164: invokeinterface 303 3 0
        //   169: ldc_w 307
        //   172: iconst_1
        //   173: anewarray 309	java/lang/Object
        //   176: dup
        //   177: iconst_0
        //   178: invokestatic 314	com/uservoice/uservoicesdk/UserVoice:getVersion	()Ljava/lang/String;
        //   181: aastore
        //   182: invokestatic 318	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   185: invokestatic 52	com/uservoice/uservoicesdk/Session:getInstance	()Lcom/uservoice/uservoicesdk/Session;
        //   188: invokevirtual 322	com/uservoice/uservoicesdk/Session:getContext	()Landroid/content/Context;
        //   191: invokestatic 326	android/net/http/AndroidHttpClient:newInstance	(Ljava/lang/String;Landroid/content/Context;)Landroid/net/http/AndroidHttpClient;
        //   194: astore_1
        //   195: aload_1
        //   196: astore_3
        //   197: aload_0
        //   198: invokevirtual 241	com/uservoice/uservoicesdk/rest/RestTask:isCancelled	()Z
        //   201: ifeq +13 -> 214
        //   204: aload_1
        //   205: astore_3
        //   206: new 243	java/lang/InterruptedException
        //   209: dup
        //   210: invokespecial 244	java/lang/InterruptedException:<init>	()V
        //   213: athrow
        //   214: aload_1
        //   215: astore_3
        //   216: aload_1
        //   217: aload_0
        //   218: getfield 238	com/uservoice/uservoicesdk/rest/RestTask:request	Lorg/apache/http/client/methods/HttpUriRequest;
        //   221: invokevirtual 330	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   224: astore 6
        //   226: aload_1
        //   227: astore_3
        //   228: aload_0
        //   229: invokevirtual 241	com/uservoice/uservoicesdk/rest/RestTask:isCancelled	()Z
        //   232: ifeq +24 -> 256
        //   235: aload_1
        //   236: astore_3
        //   237: new 243	java/lang/InterruptedException
        //   240: dup
        //   241: invokespecial 244	java/lang/InterruptedException:<init>	()V
        //   244: athrow
        //   245: astore_1
        //   246: aload_3
        //   247: ifnull +7 -> 254
        //   250: aload_3
        //   251: invokevirtual 254	android/net/http/AndroidHttpClient:close	()V
        //   254: aload_1
        //   255: athrow
        //   256: aload_1
        //   257: astore_3
        //   258: aload 6
        //   260: invokeinterface 336 1 0
        //   265: astore 5
        //   267: aload_1
        //   268: astore_3
        //   269: aload 6
        //   271: invokeinterface 340 1 0
        //   276: astore 6
        //   278: aload 6
        //   280: ifnull +90 -> 370
        //   283: aload_1
        //   284: astore_3
        //   285: aload 6
        //   287: invokeinterface 345 1 0
        //   292: istore_2
        //   293: aload 5
        //   295: ifnull +12 -> 307
        //   298: aload_1
        //   299: astore_3
        //   300: aload 5
        //   302: invokestatic 350	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
        //   305: astore 4
        //   307: aload_1
        //   308: astore_3
        //   309: aload_0
        //   310: invokevirtual 241	com/uservoice/uservoicesdk/rest/RestTask:isCancelled	()Z
        //   313: ifeq +13 -> 326
        //   316: aload_1
        //   317: astore_3
        //   318: new 243	java/lang/InterruptedException
        //   321: dup
        //   322: invokespecial 244	java/lang/InterruptedException:<init>	()V
        //   325: athrow
        //   326: aload_1
        //   327: astore_3
        //   328: new 246	com/uservoice/uservoicesdk/rest/RestResult
        //   331: dup
        //   332: iload_2
        //   333: new 352	org/json/JSONObject
        //   336: dup
        //   337: aload 4
        //   339: invokespecial 353	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   342: invokespecial 356	com/uservoice/uservoicesdk/rest/RestResult:<init>	(ILorg/json/JSONObject;)V
        //   345: astore 4
        //   347: aload 4
        //   349: astore_3
        //   350: aload_1
        //   351: ifnull -292 -> 59
        //   354: aload_1
        //   355: invokevirtual 254	android/net/http/AndroidHttpClient:close	()V
        //   358: aload 4
        //   360: areturn
        //   361: astore_1
        //   362: goto -116 -> 246
        //   365: astore 4
        //   367: goto -335 -> 32
        //   370: iconst_0
        //   371: istore_2
        //   372: goto -79 -> 293
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	375	0	this	RestTask
        //   0	375	1	paramVarArgs	String[]
        //   292	80	2	i	int
        //   4	346	3	localObject1	Object
        //   1	1	4	localObject2	Object
        //   28	11	4	localException1	Exception
        //   43	316	4	localObject3	Object
        //   365	1	4	localException2	Exception
        //   78	223	5	localObject4	Object
        //   224	62	6	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   5	28	28	java/lang/Exception
        //   61	68	28	java/lang/Exception
        //   72	80	28	java/lang/Exception
        //   85	101	28	java/lang/Exception
        //   101	112	28	java/lang/Exception
        //   112	195	28	java/lang/Exception
        //   34	45	245	finally
        //   197	204	245	finally
        //   206	214	245	finally
        //   216	226	245	finally
        //   228	235	245	finally
        //   237	245	245	finally
        //   258	267	245	finally
        //   269	278	245	finally
        //   285	293	245	finally
        //   300	307	245	finally
        //   309	316	245	finally
        //   318	326	245	finally
        //   328	347	245	finally
        //   5	28	361	finally
        //   61	68	361	finally
        //   72	80	361	finally
        //   85	101	361	finally
        //   101	112	361	finally
        //   112	195	361	finally
        //   197	204	365	java/lang/Exception
        //   206	214	365	java/lang/Exception
        //   216	226	365	java/lang/Exception
        //   228	235	365	java/lang/Exception
        //   237	245	365	java/lang/Exception
        //   258	267	365	java/lang/Exception
        //   269	278	365	java/lang/Exception
        //   285	293	365	java/lang/Exception
        //   300	307	365	java/lang/Exception
        //   309	316	365	java/lang/Exception
        //   318	326	365	java/lang/Exception
        //   328	347	365	java/lang/Exception
    }

    protected void onPostExecute(RestResult paramRestResult) {
        if (paramRestResult.isError()) {
            this.callback.onError(paramRestResult);
        }
        for (; ; ) {
            super.onPostExecute(paramRestResult);
            return;
            try {
                this.callback.onComplete(paramRestResult.getObject());
            } catch (JSONException localJSONException) {
                this.callback.onError(new RestResult(localJSONException, paramRestResult.getStatusCode(), paramRestResult.getObject()));
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/rest/RestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */