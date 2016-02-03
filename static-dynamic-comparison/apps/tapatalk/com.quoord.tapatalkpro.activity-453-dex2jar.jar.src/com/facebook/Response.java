package com.facebook;

import android.content.Context;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import com.facebook.model.GraphObjectList;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Response {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final int INVALID_SESSION_FACEBOOK_ERROR_CODE = 190;
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_CACHE_TAG = "ResponseCache";
    private static final String RESPONSE_LOG_TAG = "Response";
    private static FileLruCache responseCache;
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final GraphObject graphObject;
    private final GraphObjectList<GraphObject> graphObjectList;
    private final boolean isFromCache;
    private final Request request;

    static {
        if (!Response.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            return;
        }
    }

    Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, FacebookRequestError paramFacebookRequestError) {
        this.request = paramRequest;
        this.connection = paramHttpURLConnection;
        this.graphObject = null;
        this.graphObjectList = null;
        this.isFromCache = false;
        this.error = paramFacebookRequestError;
    }

    Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, GraphObject paramGraphObject, boolean paramBoolean) {
        this.request = paramRequest;
        this.connection = paramHttpURLConnection;
        this.graphObject = paramGraphObject;
        this.graphObjectList = null;
        this.isFromCache = paramBoolean;
        this.error = null;
    }

    Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, GraphObjectList<GraphObject> paramGraphObjectList, boolean paramBoolean) {
        this.request = paramRequest;
        this.connection = paramHttpURLConnection;
        this.graphObject = null;
        this.graphObjectList = paramGraphObjectList;
        this.isFromCache = paramBoolean;
        this.error = null;
    }

    static List<Response> constructErrorResponses(List<Request> paramList, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException) {
        int j = paramList.size();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return localArrayList;
            }
            localArrayList.add(new Response((Request) paramList.get(i), paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, paramFacebookException)));
            i += 1;
        }
    }

    private static Response createResponseFromObject(Request paramRequest, HttpURLConnection paramHttpURLConnection, Object paramObject1, boolean paramBoolean, Object paramObject2)
            throws JSONException {
        Object localObject = paramObject1;
        if ((paramObject1 instanceof JSONObject)) {
            paramObject1 = (JSONObject) paramObject1;
            paramObject2 = FacebookRequestError.checkResponseAndCreateError((JSONObject) paramObject1, paramObject2, paramHttpURLConnection);
            if (paramObject2 != null) {
                if (((FacebookRequestError) paramObject2).getErrorCode() == 190) {
                    paramObject1 = paramRequest.getSession();
                    if (paramObject1 != null) {
                        ((Session) paramObject1).closeAndClearTokenInformation();
                    }
                }
                return new Response(paramRequest, paramHttpURLConnection, (FacebookRequestError) paramObject2);
            }
            paramObject1 = Utility.getStringPropertyAsJSON((JSONObject) paramObject1, "body", "FACEBOOK_NON_JSON_RESULT");
            if ((paramObject1 instanceof JSONObject)) {
                return new Response(paramRequest, paramHttpURLConnection, GraphObject.Factory.create((JSONObject) paramObject1), paramBoolean);
            }
            if ((paramObject1 instanceof JSONArray)) {
                return new Response(paramRequest, paramHttpURLConnection, GraphObject.Factory.createList((JSONArray) paramObject1, GraphObject.class), paramBoolean);
            }
            localObject = JSONObject.NULL;
        }
        if (localObject == JSONObject.NULL) {
            return new Response(paramRequest, paramHttpURLConnection, null, paramBoolean);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + localObject.getClass().getSimpleName());
    }

    private static List<Response> createResponsesFromObject(HttpURLConnection paramHttpURLConnection, List<Request> paramList, Object paramObject, boolean paramBoolean)
            throws FacebookException, JSONException {
        assert ((paramHttpURLConnection != null) || (paramBoolean));
        int j = paramList.size();
        ArrayList localArrayList = new ArrayList(j);
        Object localObject1 = paramObject;
        Request localRequest;
        if (j == 1) {
            localRequest = (Request) paramList.get(0);
        }
        int i;
        for (; ; ) {
            try {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("body", paramObject);
                if (paramHttpURLConnection == null) {
                    continue;
                }
                i = paramHttpURLConnection.getResponseCode();
                localJSONObject.put("code", i);
                localObject1 = new JSONArray();
                ((JSONArray) localObject1).put(localJSONObject);
            } catch (JSONException localJSONException1) {
                localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException1)));
                localObject2 = paramObject;
                continue;
            } catch (IOException localIOException) {
                localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localIOException)));
                localObject3 = paramObject;
                continue;
                localObject3 = (JSONArray) localObject3;
                i = 0;
            }
            if (((localObject1 instanceof JSONArray)) && (((JSONArray) localObject1).length() == j)) {
                continue;
            }
            throw new FacebookException("Unexpected number of results");
            i = 200;
        }
        for (; ; ) {
            Object localObject2;
            Object localObject3;
            if (i >= ((JSONArray) localObject3).length()) {
                return localArrayList;
            }
            localRequest = (Request) paramList.get(i);
            try {
                localArrayList.add(createResponseFromObject(localRequest, paramHttpURLConnection, ((JSONArray) localObject3).get(i), paramBoolean, paramObject));
                i += 1;
            } catch (JSONException localJSONException2) {
                for (; ; ) {
                    localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException2)));
                }
            } catch (FacebookException localFacebookException) {
                for (; ; ) {
                    localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localFacebookException)));
                }
            }
        }
    }

    static List<Response> createResponsesFromStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch, boolean paramBoolean)
            throws FacebookException, JSONException, IOException {
        paramInputStream = Utility.readStreamToString(paramInputStream);
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[]{Integer.valueOf(paramInputStream.length()), paramInputStream});
        return createResponsesFromString(paramInputStream, paramHttpURLConnection, paramRequestBatch, paramBoolean);
    }

    static List<Response> createResponsesFromString(String paramString, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch, boolean paramBoolean)
            throws FacebookException, JSONException, IOException {
        paramHttpURLConnection = createResponsesFromObject(paramHttpURLConnection, paramRequestBatch, new JSONTokener(paramString).nextValue(), paramBoolean);
        Logger.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[]{paramRequestBatch.getId(), Integer.valueOf(paramString.length()), paramHttpURLConnection});
        return paramHttpURLConnection;
    }

    /* Error */
    static List<Response> fromHttpConnection(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 11
        //   3: aconst_null
        //   4: astore 4
        //   6: aconst_null
        //   7: astore 6
        //   9: aconst_null
        //   10: astore 7
        //   12: aconst_null
        //   13: astore 5
        //   15: aconst_null
        //   16: astore 8
        //   18: aconst_null
        //   19: astore 9
        //   21: aload 11
        //   23: astore_2
        //   24: aload_1
        //   25: instanceof 277
        //   28: ifeq +167 -> 195
        //   31: aload_1
        //   32: checkcast 277	com/facebook/internal/CacheableRequestBatch
        //   35: astore 12
        //   37: invokestatic 281	com/facebook/Response:getResponseCache	()Lcom/facebook/internal/FileLruCache;
        //   40: astore 10
        //   42: aload 12
        //   44: invokevirtual 284	com/facebook/internal/CacheableRequestBatch:getCacheKeyOverride	()Ljava/lang/String;
        //   47: astore_2
        //   48: aload_2
        //   49: astore_3
        //   50: aload_2
        //   51: invokestatic 288	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   54: ifeq +20 -> 74
        //   57: aload_1
        //   58: invokevirtual 289	com/facebook/RequestBatch:size	()I
        //   61: iconst_1
        //   62: if_icmpne +101 -> 163
        //   65: aload_1
        //   66: iconst_0
        //   67: invokevirtual 292	com/facebook/RequestBatch:get	(I)Lcom/facebook/Request;
        //   70: invokevirtual 295	com/facebook/Request:getUrlForSingleRequest	()Ljava/lang/String;
        //   73: astore_3
        //   74: aload 10
        //   76: astore 8
        //   78: aload_3
        //   79: astore 9
        //   81: aload 11
        //   83: astore_2
        //   84: aload 12
        //   86: invokevirtual 298	com/facebook/internal/CacheableRequestBatch:getForceRoundTrip	()Z
        //   89: ifne +106 -> 195
        //   92: aload 10
        //   94: astore 8
        //   96: aload_3
        //   97: astore 9
        //   99: aload 11
        //   101: astore_2
        //   102: aload 10
        //   104: ifnull +91 -> 195
        //   107: aload 10
        //   109: astore 8
        //   111: aload_3
        //   112: astore 9
        //   114: aload 11
        //   116: astore_2
        //   117: aload_3
        //   118: invokestatic 288	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   121: ifne +74 -> 195
        //   124: aload 10
        //   126: aload_3
        //   127: invokevirtual 303	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;)Ljava/io/InputStream;
        //   130: astore_2
        //   131: aload_2
        //   132: ifnull +173 -> 305
        //   135: aload_2
        //   136: astore 5
        //   138: aload_2
        //   139: astore 4
        //   141: aload_2
        //   142: astore 6
        //   144: aload_2
        //   145: astore 7
        //   147: aload_2
        //   148: aconst_null
        //   149: aload_1
        //   150: iconst_1
        //   151: invokestatic 305	com/facebook/Response:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
        //   154: astore 8
        //   156: aload_2
        //   157: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   160: aload 8
        //   162: areturn
        //   163: getstatic 265	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
        //   166: ldc 31
        //   168: ldc_w 311
        //   171: invokestatic 314	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
        //   174: aload_2
        //   175: astore_3
        //   176: goto -102 -> 74
        //   179: astore_2
        //   180: aload 5
        //   182: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   185: aload 5
        //   187: astore_2
        //   188: aload_3
        //   189: astore 9
        //   191: aload 10
        //   193: astore 8
        //   195: aload_2
        //   196: astore 5
        //   198: aload_2
        //   199: astore 6
        //   201: aload_2
        //   202: astore 7
        //   204: aload_2
        //   205: astore_3
        //   206: aload_0
        //   207: invokevirtual 203	java/net/HttpURLConnection:getResponseCode	()I
        //   210: sipush 400
        //   213: if_icmplt +106 -> 319
        //   216: aload_2
        //   217: astore 5
        //   219: aload_2
        //   220: astore 6
        //   222: aload_2
        //   223: astore 7
        //   225: aload_2
        //   226: astore_3
        //   227: aload_0
        //   228: invokevirtual 318	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
        //   231: astore_2
        //   232: aload_2
        //   233: astore 5
        //   235: aload_2
        //   236: astore 6
        //   238: aload_2
        //   239: astore 7
        //   241: aload_2
        //   242: astore_3
        //   243: aload_2
        //   244: aload_0
        //   245: aload_1
        //   246: iconst_0
        //   247: invokestatic 305	com/facebook/Response:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
        //   250: astore 4
        //   252: aload_2
        //   253: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   256: aload 4
        //   258: areturn
        //   259: astore_2
        //   260: aload 4
        //   262: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   265: aload 10
        //   267: astore 8
        //   269: aload_3
        //   270: astore 9
        //   272: aload 4
        //   274: astore_2
        //   275: goto -80 -> 195
        //   278: astore_2
        //   279: aload 6
        //   281: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   284: aload 10
        //   286: astore 8
        //   288: aload_3
        //   289: astore 9
        //   291: aload 6
        //   293: astore_2
        //   294: goto -99 -> 195
        //   297: astore_0
        //   298: aload 7
        //   300: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   303: aload_0
        //   304: athrow
        //   305: aload_2
        //   306: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   309: aload 10
        //   311: astore 8
        //   313: aload_3
        //   314: astore 9
        //   316: goto -121 -> 195
        //   319: aload_2
        //   320: astore 5
        //   322: aload_2
        //   323: astore 6
        //   325: aload_2
        //   326: astore 7
        //   328: aload_2
        //   329: astore_3
        //   330: aload_0
        //   331: invokevirtual 321	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   334: astore 4
        //   336: aload 4
        //   338: astore_2
        //   339: aload 8
        //   341: ifnull -109 -> 232
        //   344: aload 4
        //   346: astore_2
        //   347: aload 9
        //   349: ifnull -117 -> 232
        //   352: aload 4
        //   354: astore_2
        //   355: aload 4
        //   357: ifnull -125 -> 232
        //   360: aload 4
        //   362: astore 5
        //   364: aload 4
        //   366: astore 6
        //   368: aload 4
        //   370: astore 7
        //   372: aload 4
        //   374: astore_3
        //   375: aload 8
        //   377: aload 9
        //   379: aload 4
        //   381: invokevirtual 325	com/facebook/internal/FileLruCache:interceptAndPut	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
        //   384: astore 8
        //   386: aload 4
        //   388: astore_2
        //   389: aload 8
        //   391: ifnull -159 -> 232
        //   394: aload 8
        //   396: astore_2
        //   397: goto -165 -> 232
        //   400: astore_2
        //   401: aload 5
        //   403: astore_3
        //   404: getstatic 265	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
        //   407: ldc 34
        //   409: ldc_w 327
        //   412: iconst_1
        //   413: anewarray 4	java/lang/Object
        //   416: dup
        //   417: iconst_0
        //   418: aload_2
        //   419: aastore
        //   420: invokestatic 248	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   423: aload 5
        //   425: astore_3
        //   426: aload_1
        //   427: aload_0
        //   428: aload_2
        //   429: invokestatic 329	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   432: astore_0
        //   433: aload 5
        //   435: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   438: aload_0
        //   439: areturn
        //   440: astore_2
        //   441: aload 6
        //   443: astore_3
        //   444: getstatic 265	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
        //   447: ldc 34
        //   449: ldc_w 327
        //   452: iconst_1
        //   453: anewarray 4	java/lang/Object
        //   456: dup
        //   457: iconst_0
        //   458: aload_2
        //   459: aastore
        //   460: invokestatic 248	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   463: aload 6
        //   465: astore_3
        //   466: aload_1
        //   467: aload_0
        //   468: new 162	com/facebook/FacebookException
        //   471: dup
        //   472: aload_2
        //   473: invokespecial 332	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
        //   476: invokestatic 329	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   479: astore_0
        //   480: aload 6
        //   482: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   485: aload_0
        //   486: areturn
        //   487: astore_2
        //   488: aload 7
        //   490: astore_3
        //   491: getstatic 265	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
        //   494: ldc 34
        //   496: ldc_w 327
        //   499: iconst_1
        //   500: anewarray 4	java/lang/Object
        //   503: dup
        //   504: iconst_0
        //   505: aload_2
        //   506: aastore
        //   507: invokestatic 248	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   510: aload 7
        //   512: astore_3
        //   513: aload_1
        //   514: aload_0
        //   515: new 162	com/facebook/FacebookException
        //   518: dup
        //   519: aload_2
        //   520: invokespecial 332	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
        //   523: invokestatic 329	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   526: astore_0
        //   527: aload 7
        //   529: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   532: aload_0
        //   533: areturn
        //   534: astore_0
        //   535: aload_3
        //   536: invokestatic 309	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   539: aload_0
        //   540: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	541	0	paramHttpURLConnection	HttpURLConnection
        //   0	541	1	paramRequestBatch	RequestBatch
        //   23	152	2	localObject1	Object
        //   179	1	2	localFacebookException1	FacebookException
        //   187	66	2	localObject2	Object
        //   259	1	2	localJSONException1	JSONException
        //   274	1	2	localObject3	Object
        //   278	1	2	localIOException1	IOException
        //   293	104	2	localObject4	Object
        //   400	29	2	localFacebookException2	FacebookException
        //   440	33	2	localJSONException2	JSONException
        //   487	33	2	localIOException2	IOException
        //   49	487	3	localObject5	Object
        //   4	383	4	localObject6	Object
        //   13	421	5	localObject7	Object
        //   7	474	6	localObject8	Object
        //   10	518	7	localObject9	Object
        //   16	379	8	localObject10	Object
        //   19	359	9	localObject11	Object
        //   40	270	10	localFileLruCache	FileLruCache
        //   1	114	11	localObject12	Object
        //   35	50	12	localCacheableRequestBatch	com.facebook.internal.CacheableRequestBatch
        // Exception table:
        //   from	to	target	type
        //   124	131	179	com/facebook/FacebookException
        //   147	156	179	com/facebook/FacebookException
        //   124	131	259	org/json/JSONException
        //   147	156	259	org/json/JSONException
        //   124	131	278	java/io/IOException
        //   147	156	278	java/io/IOException
        //   124	131	297	finally
        //   147	156	297	finally
        //   206	216	400	com/facebook/FacebookException
        //   227	232	400	com/facebook/FacebookException
        //   243	252	400	com/facebook/FacebookException
        //   330	336	400	com/facebook/FacebookException
        //   375	386	400	com/facebook/FacebookException
        //   206	216	440	org/json/JSONException
        //   227	232	440	org/json/JSONException
        //   243	252	440	org/json/JSONException
        //   330	336	440	org/json/JSONException
        //   375	386	440	org/json/JSONException
        //   206	216	487	java/io/IOException
        //   227	232	487	java/io/IOException
        //   243	252	487	java/io/IOException
        //   330	336	487	java/io/IOException
        //   375	386	487	java/io/IOException
        //   206	216	534	finally
        //   227	232	534	finally
        //   243	252	534	finally
        //   330	336	534	finally
        //   375	386	534	finally
        //   404	423	534	finally
        //   426	433	534	finally
        //   444	463	534	finally
        //   466	480	534	finally
        //   491	510	534	finally
        //   513	527	534	finally
    }

    static FileLruCache getResponseCache() {
        if (responseCache == null) {
            Context localContext = Session.getStaticContext();
            if (localContext != null) {
                responseCache = new FileLruCache(localContext, "ResponseCache", new FileLruCache.Limits());
            }
        }
        return responseCache;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    public final GraphObject getGraphObject() {
        return this.graphObject;
    }

    public final <T extends GraphObject> T getGraphObjectAs(Class<T> paramClass) {
        if (this.graphObject == null) {
            return null;
        }
        if (paramClass == null) {
            throw new NullPointerException("Must pass in a valid interface that extends GraphObject");
        }
        return this.graphObject.cast(paramClass);
    }

    public final GraphObjectList<GraphObject> getGraphObjectList() {
        return this.graphObjectList;
    }

    public final <T extends GraphObject> GraphObjectList<T> getGraphObjectListAs(Class<T> paramClass) {
        if (this.graphObjectList == null) {
            return null;
        }
        return this.graphObjectList.castToListOf(paramClass);
    }

    public final boolean getIsFromCache() {
        return this.isFromCache;
    }

    public Request getRequest() {
        return this.request;
    }

    public Request getRequestForPagedResults(PagingDirection paramPagingDirection) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        PagingInfo localPagingInfo;
        if (this.graphObject != null) {
            localPagingInfo = ((PagedResults) this.graphObject.cast(PagedResults.class)).getPaging();
            localObject1 = localObject2;
            if (localPagingInfo != null) {
                if (paramPagingDirection != PagingDirection.NEXT) {
                    break label63;
                }
            }
        }
        label63:
        for (localObject1 = localPagingInfo.getNext(); Utility.isNullOrEmpty((String) localObject1); localObject1 = localPagingInfo.getPrevious()) {
            return null;
        }
        if ((localObject1 != null) && (((String) localObject1).equals(this.request.getUrlForSingleRequest()))) {
            return null;
        }
        try {
            paramPagingDirection = new Request(this.request.getSession(), new URL((String) localObject1));
            return paramPagingDirection;
        } catch (MalformedURLException paramPagingDirection) {
        }
        return null;
    }

    public String toString() {
        for (; ; ) {
            try {
                if (this.connection == null) {
                    continue;
                }
                i = this.connection.getResponseCode();
                str1 = String.format("%d", new Object[]{Integer.valueOf(i)});
            } catch (IOException localIOException) {
                int i;
                String str1;
                String str2 = "unknown";
                continue;
            }
            return "{Response: " + " responseCode: " + str1 + ", graphObject: " + this.graphObject + ", error: " + this.error + ", isFromCache:" + this.isFromCache + "}";
            i = 200;
        }
    }

    static abstract interface PagedResults
            extends GraphObject {
        public abstract GraphObjectList<GraphObject> getData();

        public abstract Response.PagingInfo getPaging();
    }

    public static enum PagingDirection {
        NEXT, PREVIOUS;
    }

    static abstract interface PagingInfo
            extends GraphObject {
        public abstract String getNext();

        public abstract String getPrevious();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */