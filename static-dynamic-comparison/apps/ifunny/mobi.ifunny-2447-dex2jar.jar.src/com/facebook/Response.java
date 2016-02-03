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
    public static final String SUCCESS_KEY = "success";
    private static FileLruCache responseCache;
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final GraphObject graphObject;
    private final GraphObjectList<GraphObject> graphObjectList;
    private final boolean isFromCache;
    private final String rawResponse;
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
        this(paramRequest, paramHttpURLConnection, null, null, null, false, paramFacebookRequestError);
    }

    Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, String paramString, GraphObject paramGraphObject, GraphObjectList<GraphObject> paramGraphObjectList, boolean paramBoolean, FacebookRequestError paramFacebookRequestError) {
        this.request = paramRequest;
        this.connection = paramHttpURLConnection;
        this.rawResponse = paramString;
        this.graphObject = paramGraphObject;
        this.graphObjectList = paramGraphObjectList;
        this.isFromCache = paramBoolean;
        this.error = paramFacebookRequestError;
    }

    Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, String paramString, GraphObject paramGraphObject, boolean paramBoolean) {
        this(paramRequest, paramHttpURLConnection, paramString, paramGraphObject, null, paramBoolean, null);
    }

    Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, String paramString, GraphObjectList<GraphObject> paramGraphObjectList, boolean paramBoolean) {
        this(paramRequest, paramHttpURLConnection, paramString, null, paramGraphObjectList, paramBoolean, null);
    }

    static List<Response> constructErrorResponses(List<Request> paramList, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException) {
        int j = paramList.size();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j) {
            localArrayList.add(new Response((Request) paramList.get(i), paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, paramFacebookException)));
            i += 1;
        }
        return localArrayList;
    }

    private static Response createResponseFromObject(Request paramRequest, HttpURLConnection paramHttpURLConnection, Object paramObject1, boolean paramBoolean, Object paramObject2) {
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
                paramObject2 = GraphObject.Factory.create((JSONObject) paramObject1);
                return new Response(paramRequest, paramHttpURLConnection, paramObject1.toString(), (GraphObject) paramObject2, paramBoolean);
            }
            if ((paramObject1 instanceof JSONArray)) {
                paramObject2 = GraphObject.Factory.createList((JSONArray) paramObject1, GraphObject.class);
                return new Response(paramRequest, paramHttpURLConnection, paramObject1.toString(), (GraphObjectList) paramObject2, paramBoolean);
            }
            localObject = JSONObject.NULL;
        }
        if (localObject == JSONObject.NULL) {
            return new Response(paramRequest, paramHttpURLConnection, localObject.toString(), (GraphObject) null, paramBoolean);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + localObject.getClass().getSimpleName());
    }

    private static List<Response> createResponsesFromObject(HttpURLConnection paramHttpURLConnection, List<Request> paramList, Object paramObject, boolean paramBoolean) {
        int j = 0;
        assert ((paramHttpURLConnection != null) || (paramBoolean));
        int k = paramList.size();
        ArrayList localArrayList = new ArrayList(k);
        Request localRequest;
        if (k == 1) {
            localRequest = (Request) paramList.get(0);
        }
        for (; ; ) {
            try {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("body", paramObject);
                if (paramHttpURLConnection == null) {
                    continue;
                }
                i = paramHttpURLConnection.getResponseCode();
                localJSONObject.put("code", i);
                localJSONArray = new JSONArray();
                localJSONArray.put(localJSONObject);
            } catch (JSONException localJSONException1) {
                JSONArray localJSONArray;
                localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException1)));
                Object localObject1 = paramObject;
                continue;
            } catch (IOException localIOException) {
                localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localIOException)));
            }
            if (((localJSONArray instanceof JSONArray)) && (((JSONArray) localJSONArray).length() == k)) {
                break;
            }
            throw new FacebookException("Unexpected number of results");
            i = 200;
            continue;
            localObject2 = paramObject;
        }
        Object localObject2 = (JSONArray) localObject2;
        int i = j;
        for (; ; ) {
            if (i < ((JSONArray) localObject2).length()) {
                localRequest = (Request) paramList.get(i);
                try {
                    localArrayList.add(createResponseFromObject(localRequest, paramHttpURLConnection, ((JSONArray) localObject2).get(i), paramBoolean, paramObject));
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
        return localArrayList;
    }

    static List<Response> createResponsesFromStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch, boolean paramBoolean) {
        paramInputStream = Utility.readStreamToString(paramInputStream);
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[]{Integer.valueOf(paramInputStream.length()), paramInputStream});
        return createResponsesFromString(paramInputStream, paramHttpURLConnection, paramRequestBatch, paramBoolean);
    }

    static List<Response> createResponsesFromString(String paramString, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch, boolean paramBoolean) {
        paramHttpURLConnection = createResponsesFromObject(paramHttpURLConnection, paramRequestBatch, new JSONTokener(paramString).nextValue(), paramBoolean);
        Logger.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[]{paramRequestBatch.getId(), Integer.valueOf(paramString.length()), paramHttpURLConnection});
        return paramHttpURLConnection;
    }

    /* Error */
    static List<Response> fromHttpConnection(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aconst_null
        //   4: astore 6
        //   6: aconst_null
        //   7: astore 7
        //   9: aconst_null
        //   10: astore_3
        //   11: aload_1
        //   12: instanceof 280
        //   15: ifeq +546 -> 561
        //   18: aload_1
        //   19: checkcast 280	com/facebook/internal/CacheableRequestBatch
        //   22: astore 8
        //   24: invokestatic 284	com/facebook/Response:getResponseCache	()Lcom/facebook/internal/FileLruCache;
        //   27: astore 4
        //   29: aload 8
        //   31: invokevirtual 287	com/facebook/internal/CacheableRequestBatch:getCacheKeyOverride	()Ljava/lang/String;
        //   34: astore_3
        //   35: aload_3
        //   36: astore_2
        //   37: aload_3
        //   38: invokestatic 291	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   41: ifeq +20 -> 61
        //   44: aload_1
        //   45: invokevirtual 292	com/facebook/RequestBatch:size	()I
        //   48: iconst_1
        //   49: if_icmpne +68 -> 117
        //   52: aload_1
        //   53: iconst_0
        //   54: invokevirtual 295	com/facebook/RequestBatch:get	(I)Lcom/facebook/Request;
        //   57: invokevirtual 298	com/facebook/Request:getUrlForSingleRequest	()Ljava/lang/String;
        //   60: astore_2
        //   61: aload 8
        //   63: invokevirtual 301	com/facebook/internal/CacheableRequestBatch:getForceRoundTrip	()Z
        //   66: ifne +485 -> 551
        //   69: aload 4
        //   71: ifnull +480 -> 551
        //   74: aload_2
        //   75: invokestatic 291	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   78: ifne +473 -> 551
        //   81: aload 4
        //   83: aload_2
        //   84: invokevirtual 306	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;)Ljava/io/InputStream;
        //   87: astore_3
        //   88: aload_3
        //   89: ifnull +44 -> 133
        //   92: aload_3
        //   93: astore 5
        //   95: aload_3
        //   96: astore 6
        //   98: aload_3
        //   99: astore 7
        //   101: aload_3
        //   102: aconst_null
        //   103: aload_1
        //   104: iconst_1
        //   105: invokestatic 308	com/facebook/Response:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
        //   108: astore 8
        //   110: aload_3
        //   111: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   114: aload 8
        //   116: areturn
        //   117: getstatic 266	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
        //   120: ldc 22
        //   122: ldc_w 314
        //   125: invokestatic 317	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
        //   128: aload_3
        //   129: astore_2
        //   130: goto -69 -> 61
        //   133: aload_3
        //   134: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   137: aload_2
        //   138: astore 5
        //   140: aload_3
        //   141: astore_2
        //   142: aload_2
        //   143: astore 7
        //   145: aload_2
        //   146: astore 8
        //   148: aload_2
        //   149: astore 9
        //   151: aload_2
        //   152: astore 10
        //   154: aload_2
        //   155: astore_3
        //   156: aload_0
        //   157: invokevirtual 204	java/net/HttpURLConnection:getResponseCode	()I
        //   160: sipush 400
        //   163: if_icmplt +107 -> 270
        //   166: aload_2
        //   167: astore 7
        //   169: aload_2
        //   170: astore 8
        //   172: aload_2
        //   173: astore 9
        //   175: aload_2
        //   176: astore 10
        //   178: aload_2
        //   179: astore_3
        //   180: aload_0
        //   181: invokevirtual 321	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
        //   184: astore_2
        //   185: aload_2
        //   186: astore 7
        //   188: aload_2
        //   189: astore 8
        //   191: aload_2
        //   192: astore 9
        //   194: aload_2
        //   195: astore 10
        //   197: aload_2
        //   198: astore_3
        //   199: aload_2
        //   200: aload_0
        //   201: aload_1
        //   202: iconst_0
        //   203: invokestatic 308	com/facebook/Response:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
        //   206: astore 4
        //   208: aload_2
        //   209: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   212: aload 4
        //   214: areturn
        //   215: astore_3
        //   216: aconst_null
        //   217: astore_3
        //   218: aload_3
        //   219: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   222: aload_2
        //   223: astore 5
        //   225: aload_3
        //   226: astore_2
        //   227: goto -85 -> 142
        //   230: astore_3
        //   231: aload 5
        //   233: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   236: aload_2
        //   237: astore_3
        //   238: aload 5
        //   240: astore_2
        //   241: aload_3
        //   242: astore 5
        //   244: goto -102 -> 142
        //   247: astore_3
        //   248: aload 6
        //   250: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   253: aload_2
        //   254: astore 5
        //   256: aload 6
        //   258: astore_2
        //   259: goto -117 -> 142
        //   262: astore_0
        //   263: aload 7
        //   265: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   268: aload_0
        //   269: athrow
        //   270: aload_2
        //   271: astore 7
        //   273: aload_2
        //   274: astore 8
        //   276: aload_2
        //   277: astore 9
        //   279: aload_2
        //   280: astore 10
        //   282: aload_2
        //   283: astore_3
        //   284: aload_0
        //   285: invokevirtual 324	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   288: astore 6
        //   290: aload 6
        //   292: astore_2
        //   293: aload 4
        //   295: ifnull -110 -> 185
        //   298: aload 6
        //   300: astore_2
        //   301: aload 5
        //   303: ifnull -118 -> 185
        //   306: aload 6
        //   308: astore_2
        //   309: aload 6
        //   311: ifnull -126 -> 185
        //   314: aload 6
        //   316: astore 7
        //   318: aload 6
        //   320: astore 8
        //   322: aload 6
        //   324: astore 9
        //   326: aload 6
        //   328: astore 10
        //   330: aload 6
        //   332: astore_3
        //   333: aload 4
        //   335: aload 5
        //   337: aload 6
        //   339: invokevirtual 328	com/facebook/internal/FileLruCache:interceptAndPut	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
        //   342: astore 4
        //   344: aload 6
        //   346: astore_2
        //   347: aload 4
        //   349: ifnull -164 -> 185
        //   352: aload 4
        //   354: astore_2
        //   355: goto -170 -> 185
        //   358: astore_2
        //   359: aload 7
        //   361: astore_3
        //   362: getstatic 266	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
        //   365: ldc 25
        //   367: ldc_w 330
        //   370: iconst_1
        //   371: anewarray 4	java/lang/Object
        //   374: dup
        //   375: iconst_0
        //   376: aload_2
        //   377: aastore
        //   378: invokestatic 249	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   381: aload 7
        //   383: astore_3
        //   384: aload_1
        //   385: aload_0
        //   386: aload_2
        //   387: invokestatic 332	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   390: astore_0
        //   391: aload 7
        //   393: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   396: aload_0
        //   397: areturn
        //   398: astore_2
        //   399: aload 8
        //   401: astore_3
        //   402: getstatic 266	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
        //   405: ldc 25
        //   407: ldc_w 330
        //   410: iconst_1
        //   411: anewarray 4	java/lang/Object
        //   414: dup
        //   415: iconst_0
        //   416: aload_2
        //   417: aastore
        //   418: invokestatic 249	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   421: aload 8
        //   423: astore_3
        //   424: aload_1
        //   425: aload_0
        //   426: new 165	com/facebook/FacebookException
        //   429: dup
        //   430: aload_2
        //   431: invokespecial 335	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
        //   434: invokestatic 332	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   437: astore_0
        //   438: aload 8
        //   440: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   443: aload_0
        //   444: areturn
        //   445: astore_2
        //   446: aload 9
        //   448: astore_3
        //   449: getstatic 266	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
        //   452: ldc 25
        //   454: ldc_w 330
        //   457: iconst_1
        //   458: anewarray 4	java/lang/Object
        //   461: dup
        //   462: iconst_0
        //   463: aload_2
        //   464: aastore
        //   465: invokestatic 249	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   468: aload 9
        //   470: astore_3
        //   471: aload_1
        //   472: aload_0
        //   473: new 165	com/facebook/FacebookException
        //   476: dup
        //   477: aload_2
        //   478: invokespecial 335	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
        //   481: invokestatic 332	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   484: astore_0
        //   485: aload 9
        //   487: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   490: aload_0
        //   491: areturn
        //   492: astore_2
        //   493: aload 10
        //   495: astore_3
        //   496: getstatic 266	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
        //   499: ldc 25
        //   501: ldc_w 330
        //   504: iconst_1
        //   505: anewarray 4	java/lang/Object
        //   508: dup
        //   509: iconst_0
        //   510: aload_2
        //   511: aastore
        //   512: invokestatic 249	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   515: aload 10
        //   517: astore_3
        //   518: aload_1
        //   519: aload_0
        //   520: new 165	com/facebook/FacebookException
        //   523: dup
        //   524: aload_2
        //   525: invokespecial 335	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
        //   528: invokestatic 332	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   531: astore_0
        //   532: aload 10
        //   534: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   537: aload_0
        //   538: areturn
        //   539: astore_0
        //   540: aload_3
        //   541: invokestatic 312	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   544: aload_0
        //   545: athrow
        //   546: astore 5
        //   548: goto -330 -> 218
        //   551: aconst_null
        //   552: astore_3
        //   553: aload_2
        //   554: astore 5
        //   556: aload_3
        //   557: astore_2
        //   558: goto -416 -> 142
        //   561: aconst_null
        //   562: astore 4
        //   564: aconst_null
        //   565: astore_2
        //   566: aload_3
        //   567: astore 5
        //   569: goto -427 -> 142
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	572	0	paramHttpURLConnection	HttpURLConnection
        //   0	572	1	paramRequestBatch	RequestBatch
        //   36	319	2	localObject1	Object
        //   358	29	2	localFacebookException1	FacebookException
        //   398	33	2	localJSONException1	JSONException
        //   445	33	2	localIOException1	IOException
        //   492	62	2	localSecurityException	SecurityException
        //   557	9	2	localObject2	Object
        //   10	189	3	localObject3	Object
        //   215	1	3	localFacebookException2	FacebookException
        //   217	9	3	localCloseable	java.io.Closeable
        //   230	1	3	localJSONException2	JSONException
        //   237	5	3	localObject4	Object
        //   247	1	3	localIOException2	IOException
        //   283	284	3	localObject5	Object
        //   27	536	4	localObject6	Object
        //   1	335	5	localObject7	Object
        //   546	1	5	localFacebookException3	FacebookException
        //   554	14	5	localObject8	Object
        //   4	341	6	localObject9	Object
        //   7	385	7	localObject10	Object
        //   22	417	8	localObject11	Object
        //   149	337	9	localObject12	Object
        //   152	381	10	localObject13	Object
        // Exception table:
        //   from	to	target	type
        //   81	88	215	com/facebook/FacebookException
        //   81	88	230	org/json/JSONException
        //   101	110	230	org/json/JSONException
        //   81	88	247	java/io/IOException
        //   101	110	247	java/io/IOException
        //   81	88	262	finally
        //   101	110	262	finally
        //   156	166	358	com/facebook/FacebookException
        //   180	185	358	com/facebook/FacebookException
        //   199	208	358	com/facebook/FacebookException
        //   284	290	358	com/facebook/FacebookException
        //   333	344	358	com/facebook/FacebookException
        //   156	166	398	org/json/JSONException
        //   180	185	398	org/json/JSONException
        //   199	208	398	org/json/JSONException
        //   284	290	398	org/json/JSONException
        //   333	344	398	org/json/JSONException
        //   156	166	445	java/io/IOException
        //   180	185	445	java/io/IOException
        //   199	208	445	java/io/IOException
        //   284	290	445	java/io/IOException
        //   333	344	445	java/io/IOException
        //   156	166	492	java/lang/SecurityException
        //   180	185	492	java/lang/SecurityException
        //   199	208	492	java/lang/SecurityException
        //   284	290	492	java/lang/SecurityException
        //   333	344	492	java/lang/SecurityException
        //   156	166	539	finally
        //   180	185	539	finally
        //   199	208	539	finally
        //   284	290	539	finally
        //   333	344	539	finally
        //   362	381	539	finally
        //   384	391	539	finally
        //   402	421	539	finally
        //   424	438	539	finally
        //   449	468	539	finally
        //   471	485	539	finally
        //   496	515	539	finally
        //   518	532	539	finally
        //   101	110	546	com/facebook/FacebookException
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

    public String getRawResponse() {
        return this.rawResponse;
    }

    public Request getRequest() {
        return this.request;
    }

    public Request getRequestForPagedResults(Response.PagingDirection paramPagingDirection) {
        Response.PagingInfo localPagingInfo;
        if (this.graphObject != null) {
            localPagingInfo = ((Response.PagedResults) this.graphObject.cast(Response.PagedResults.class)).getPaging();
            if (localPagingInfo != null) {
                if (paramPagingDirection == Response.PagingDirection.NEXT) {
                    paramPagingDirection = localPagingInfo.getNext();
                }
            }
        }
        for (; ; ) {
            if (Utility.isNullOrEmpty(paramPagingDirection)) {
            }
            while ((paramPagingDirection != null) && (paramPagingDirection.equals(this.request.getUrlForSingleRequest()))) {
                return null;
                paramPagingDirection = localPagingInfo.getPrevious();
                break;
            }
            try {
                paramPagingDirection = new Request(this.request.getSession(), new URL(paramPagingDirection));
                return paramPagingDirection;
            } catch (MalformedURLException paramPagingDirection) {
                return null;
            }
            paramPagingDirection = null;
        }
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */