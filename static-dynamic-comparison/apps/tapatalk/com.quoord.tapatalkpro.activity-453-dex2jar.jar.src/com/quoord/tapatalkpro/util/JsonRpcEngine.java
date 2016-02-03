package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.os.AsyncTask;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tools.tracking.GoogleAnalyticsTools;
import com.quoord.xmlrpc.JSONRPCClient;
import com.quoord.xmlrpc.XMLRPCClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

import org.xml.sax.ContentHandler;

public class JsonRpcEngine {
    public static final String GETBLOG = "/index.php?tapatalk=blog&";
    public static final String GETBLOGS = "/index.php?tapatalk=blogs&";
    public static final String GETCATEGORY = "/index.php?tapatalk=category";
    public static final String GETCOMMENT = "/index.php?tapatalk=comments&";
    public static final String GETCONFIG_RETRY = "?tapatalk=config";
    private ForumStatus forumStatus;
    String infos = null;
    public String isLogin;
    public ContentHandler lastHandler;
    public String lastMethod;
    public ArrayList lastParam;
    CallBackInterface mAdapter;
    private Activity mContext;
    String url;

    public JsonRpcEngine(CallBackInterface paramCallBackInterface, ForumStatus paramForumStatus, Activity paramActivity) {
        this.mAdapter = paramCallBackInterface;
        this.forumStatus = paramForumStatus;
        this.mContext = paramActivity;
        this.url = (this.forumStatus.getUrl() + "/mobiquo/wordpress/jsonrpc.php");
    }

    public void call(final String paramString) {
        this.mAdapter.setOpCancel(false);
        new AsyncTask() {
            /* Error */
            protected EngineResponse doInBackground(String... paramAnonymousVarArgs) {
                // Byte code:
                //   0: new 30	com/quoord/tapatalkpro/bean/EngineResponse
                //   3: dup
                //   4: invokespecial 31	com/quoord/tapatalkpro/bean/EngineResponse:<init>	()V
                //   7: astore 4
                //   9: new 33	org/apache/http/conn/scheme/SchemeRegistry
                //   12: dup
                //   13: invokespecial 34	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
                //   16: astore_1
                //   17: aload_0
                //   18: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   21: getfield 37	com/quoord/tapatalkpro/util/JsonRpcEngine:url	Ljava/lang/String;
                //   24: ldc 39
                //   26: invokevirtual 45	java/lang/String:startsWith	(Ljava/lang/String;)Z
                //   29: ifeq +56 -> 85
                //   32: invokestatic 51	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
                //   35: invokestatic 55	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
                //   38: astore 5
                //   40: aload 5
                //   42: aconst_null
                //   43: aconst_null
                //   44: invokevirtual 59	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
                //   47: new 61	com/quoord/tapatalkpro/util/MySSLSocketFactory
                //   50: dup
                //   51: aload 5
                //   53: invokespecial 64	com/quoord/tapatalkpro/util/MySSLSocketFactory:<init>	(Ljava/security/KeyStore;)V
                //   56: astore 5
                //   58: aload 5
                //   60: getstatic 70	org/apache/http/conn/ssl/SSLSocketFactory:ALLOW_ALL_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
                //   63: invokevirtual 74	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
                //   66: aload_1
                //   67: new 76	org/apache/http/conn/scheme/Scheme
                //   70: dup
                //   71: ldc 39
                //   73: aload 5
                //   75: sipush 443
                //   78: invokespecial 79	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
                //   81: invokevirtual 83	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
                //   84: pop
                //   85: new 85	org/apache/http/params/BasicHttpParams
                //   88: dup
                //   89: invokespecial 86	org/apache/http/params/BasicHttpParams:<init>	()V
                //   92: astore 5
                //   94: aload 5
                //   96: getstatic 92	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
                //   99: invokestatic 98	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
                //   102: aload 5
                //   104: ldc 100
                //   106: invokestatic 104	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
                //   109: aload_1
                //   110: new 76	org/apache/http/conn/scheme/Scheme
                //   113: dup
                //   114: ldc 106
                //   116: invokestatic 112	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
                //   119: bipush 80
                //   121: invokespecial 79	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
                //   124: invokevirtual 83	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
                //   127: pop
                //   128: aload_0
                //   129: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   132: getfield 37	com/quoord/tapatalkpro/util/JsonRpcEngine:url	Ljava/lang/String;
                //   135: ldc 114
                //   137: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
                //   140: ifeq +19 -> 159
                //   143: aload 5
                //   145: sipush 7000
                //   148: invokestatic 124	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
                //   151: aload 5
                //   153: sipush 7000
                //   156: invokestatic 127	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
                //   159: new 129	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
                //   162: dup
                //   163: aload 5
                //   165: aload_1
                //   166: invokespecial 132	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
                //   169: astore_1
                //   170: new 134	org/apache/http/impl/client/DefaultHttpClient
                //   173: dup
                //   174: aload_1
                //   175: aload 5
                //   177: invokespecial 137	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
                //   180: new 139	org/apache/http/client/methods/HttpGet
                //   183: dup
                //   184: aload_0
                //   185: getfield 20	com/quoord/tapatalkpro/util/JsonRpcEngine$3:val$tempUrl	Ljava/lang/String;
                //   188: invokespecial 141	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
                //   191: invokeinterface 147 2 0
                //   196: invokeinterface 153 1 0
                //   201: invokeinterface 159 1 0
                //   206: astore 5
                //   208: aconst_null
                //   209: astore_1
                //   210: aload 5
                //   212: ifnull +31 -> 243
                //   215: new 161	java/io/ByteArrayOutputStream
                //   218: dup
                //   219: invokespecial 162	java/io/ByteArrayOutputStream:<init>	()V
                //   222: astore_1
                //   223: sipush 128
                //   226: newarray <illegal type>
                //   228: astore 6
                //   230: aload 5
                //   232: aload 6
                //   234: invokevirtual 168	java/io/InputStream:read	([B)I
                //   237: istore_2
                //   238: iload_2
                //   239: iconst_m1
                //   240: if_icmpne +188 -> 428
                //   243: aload_1
                //   244: invokevirtual 171	java/io/ByteArrayOutputStream:flush	()V
                //   247: aload_0
                //   248: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   251: aload_1
                //   252: invokevirtual 174	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
                //   255: invokevirtual 177	java/lang/String:trim	()Ljava/lang/String;
                //   258: putfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   261: aload_0
                //   262: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   265: getfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   268: ldc -74
                //   270: invokevirtual 186	java/lang/String:indexOf	(Ljava/lang/String;)I
                //   273: istore_2
                //   274: aload_0
                //   275: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   278: getfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   281: ldc -68
                //   283: invokevirtual 186	java/lang/String:indexOf	(Ljava/lang/String;)I
                //   286: istore_3
                //   287: iload_2
                //   288: ifeq +30 -> 318
                //   291: iload_3
                //   292: ifeq +26 -> 318
                //   295: iload_2
                //   296: iload_3
                //   297: if_icmpge +150 -> 447
                //   300: aload_0
                //   301: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   304: aload_0
                //   305: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   308: getfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   311: iload_2
                //   312: invokevirtual 192	java/lang/String:substring	(I)Ljava/lang/String;
                //   315: putfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   318: aload_0
                //   319: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   322: getfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   325: ifnull +166 -> 491
                //   328: aload_0
                //   329: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   332: getfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   335: invokevirtual 196	java/lang/String:length	()I
                //   338: ifle +153 -> 491
                //   341: aload_0
                //   342: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   345: getfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   348: ldc -74
                //   350: invokevirtual 45	java/lang/String:startsWith	(Ljava/lang/String;)Z
                //   353: ifeq +99 -> 452
                //   356: new 198	org/json/JSONObject
                //   359: dup
                //   360: aload_0
                //   361: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   364: getfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   367: invokespecial 199	org/json/JSONObject:<init>	(Ljava/lang/String;)V
                //   370: astore_1
                //   371: aload 4
                //   373: aload_0
                //   374: getfield 20	com/quoord/tapatalkpro/util/JsonRpcEngine$3:val$tempUrl	Ljava/lang/String;
                //   377: invokevirtual 202	com/quoord/tapatalkpro/bean/EngineResponse:setMethod	(Ljava/lang/String;)V
                //   380: aload 4
                //   382: aload_1
                //   383: invokevirtual 206	com/quoord/tapatalkpro/bean/EngineResponse:setResponse	(Ljava/lang/Object;)V
                //   386: aload 4
                //   388: iconst_1
                //   389: invokevirtual 210	com/quoord/tapatalkpro/bean/EngineResponse:setSuccess	(Z)V
                //   392: aload 4
                //   394: areturn
                //   395: astore 5
                //   397: aload 5
                //   399: invokevirtual 213	java/lang/Exception:printStackTrace	()V
                //   402: goto -317 -> 85
                //   405: astore_1
                //   406: aload_1
                //   407: invokevirtual 213	java/lang/Exception:printStackTrace	()V
                //   410: aload 4
                //   412: aload_0
                //   413: getfield 20	com/quoord/tapatalkpro/util/JsonRpcEngine$3:val$tempUrl	Ljava/lang/String;
                //   416: invokevirtual 202	com/quoord/tapatalkpro/bean/EngineResponse:setMethod	(Ljava/lang/String;)V
                //   419: aload 4
                //   421: iconst_0
                //   422: invokevirtual 210	com/quoord/tapatalkpro/bean/EngineResponse:setSuccess	(Z)V
                //   425: aload 4
                //   427: areturn
                //   428: aload_1
                //   429: aload 6
                //   431: iconst_0
                //   432: iload_2
                //   433: invokevirtual 217	java/io/ByteArrayOutputStream:write	([BII)V
                //   436: goto -206 -> 230
                //   439: astore_1
                //   440: aload_1
                //   441: invokevirtual 213	java/lang/Exception:printStackTrace	()V
                //   444: aload 4
                //   446: areturn
                //   447: iload_3
                //   448: istore_2
                //   449: goto -149 -> 300
                //   452: new 219	org/json/JSONArray
                //   455: dup
                //   456: aload_0
                //   457: getfield 18	com/quoord/tapatalkpro/util/JsonRpcEngine$3:this$0	Lcom/quoord/tapatalkpro/util/JsonRpcEngine;
                //   460: getfield 180	com/quoord/tapatalkpro/util/JsonRpcEngine:infos	Ljava/lang/String;
                //   463: invokespecial 220	org/json/JSONArray:<init>	(Ljava/lang/String;)V
                //   466: astore_1
                //   467: aload 4
                //   469: aload_0
                //   470: getfield 20	com/quoord/tapatalkpro/util/JsonRpcEngine$3:val$tempUrl	Ljava/lang/String;
                //   473: invokevirtual 202	com/quoord/tapatalkpro/bean/EngineResponse:setMethod	(Ljava/lang/String;)V
                //   476: aload 4
                //   478: aload_1
                //   479: invokevirtual 206	com/quoord/tapatalkpro/bean/EngineResponse:setResponse	(Ljava/lang/Object;)V
                //   482: aload 4
                //   484: iconst_1
                //   485: invokevirtual 210	com/quoord/tapatalkpro/bean/EngineResponse:setSuccess	(Z)V
                //   488: aload 4
                //   490: areturn
                //   491: aload 4
                //   493: aload_0
                //   494: getfield 20	com/quoord/tapatalkpro/util/JsonRpcEngine$3:val$tempUrl	Ljava/lang/String;
                //   497: invokevirtual 202	com/quoord/tapatalkpro/bean/EngineResponse:setMethod	(Ljava/lang/String;)V
                //   500: aload 4
                //   502: iconst_0
                //   503: invokevirtual 210	com/quoord/tapatalkpro/bean/EngineResponse:setSuccess	(Z)V
                //   506: aload 4
                //   508: areturn
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	509	0	this	3
                //   0	509	1	paramAnonymousVarArgs	String[]
                //   237	212	2	i	int
                //   286	162	3	j	int
                //   7	500	4	localEngineResponse	EngineResponse
                //   38	193	5	localObject	Object
                //   395	3	5	localException	Exception
                //   228	202	6	arrayOfByte	byte[]
                // Exception table:
                //   from	to	target	type
                //   17	85	395	java/lang/Exception
                //   9	17	405	java/lang/Exception
                //   85	159	405	java/lang/Exception
                //   159	170	405	java/lang/Exception
                //   397	402	405	java/lang/Exception
                //   440	444	405	java/lang/Exception
                //   170	208	439	java/lang/Exception
                //   215	230	439	java/lang/Exception
                //   230	238	439	java/lang/Exception
                //   243	287	439	java/lang/Exception
                //   300	318	439	java/lang/Exception
                //   318	392	439	java/lang/Exception
                //   428	436	439	java/lang/Exception
                //   452	488	439	java/lang/Exception
                //   491	506	439	java/lang/Exception
            }

            protected void onPostExecute(EngineResponse paramAnonymousEngineResponse) {
                try {
                    JsonRpcEngine.this.mAdapter.callBack(paramAnonymousEngineResponse);
                    return;
                } catch (Exception paramAnonymousEngineResponse) {
                    paramAnonymousEngineResponse.printStackTrace();
                }
            }

            protected void onProgressUpdate(Integer... paramAnonymousVarArgs) {
                super.onProgressUpdate(paramAnonymousVarArgs);
            }
        }.execute(new String[0]);
    }

    public void call(HashMap arg1) {
        if (this.mContext != null) {
        }
        try {
            GoogleAnalyticsTools.trackPageView(this.mContext, "rpc/" + ? ??.get("method"));
            this.mAdapter.setOpCancel(false);
            AsyncTask local2 = new AsyncTask() {
                protected EngineResponse doInBackground(String... paramAnonymousVarArgs) {
                    try {
                        if (JsonRpcEngine.this.forumStatus == null) {
                            paramAnonymousVarArgs = new JSONRPCClient(URI.create(JsonRpcEngine.this.url));
                        }
                        EngineResponse localEngineResponse2;
                        for (; ; ) {
                            publishProgress(new Integer[]{Integer.valueOf(1)});
                            paramAnonymousVarArgs.send(paramHashMap, JsonRpcEngine.this.mContext);
                            publishProgress(new Integer[]{Integer.valueOf(2)});
                            try {
                                EngineResponse localEngineResponse1 = new EngineResponse();
                                try {
                                    paramAnonymousVarArgs.retrive();
                                    publishProgress(new Integer[]{Integer.valueOf(3)});
                                    localEngineResponse1.setMethod((String) paramHashMap.get("method"));
                                    localEngineResponse1.setResponse(paramAnonymousVarArgs.parse());
                                    localEngineResponse1.setSuccess(true);
                                    JsonRpcEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                                    return localEngineResponse1;
                                } catch (Exception localException) {
                                    JsonRpcEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                                    throw localException;
                                }
                                paramAnonymousVarArgs = new JSONRPCClient(URI.create(JsonRpcEngine.this.url), JsonRpcEngine.this.forumStatus);
                            } catch (Exception paramAnonymousVarArgs) {
                                paramAnonymousVarArgs.printStackTrace();
                                localEngineResponse2 = new EngineResponse();
                                localEngineResponse2.setMethod((String) paramHashMap.get("method"));
                                localEngineResponse2.setErrorMessage(paramAnonymousVarArgs.getMessage());
                                localEngineResponse2.setSuccess(false);
                                return localEngineResponse2;
                            }
                        }
                        return localEngineResponse2;
                    } catch (Exception paramAnonymousVarArgs) {
                        paramAnonymousVarArgs.printStackTrace();
                        localEngineResponse2 = new EngineResponse();
                        localEngineResponse2.setMethod((String) paramHashMap.get("method"));
                        localEngineResponse2.setErrorMessage(paramAnonymousVarArgs.getMessage());
                        localEngineResponse2.setSuccess(false);
                    }
                }

                protected void onPostExecute(EngineResponse paramAnonymousEngineResponse) {
                    try {
                        JsonRpcEngine.this.mAdapter.callBack(paramAnonymousEngineResponse);
                        return;
                    } catch (Exception paramAnonymousEngineResponse) {
                        paramAnonymousEngineResponse.printStackTrace();
                    }
                }

                protected void onProgressUpdate(Integer... paramAnonymousVarArgs) {
                    super.onProgressUpdate(paramAnonymousVarArgs);
                    JsonRpcEngine.this.mAdapter.updateSubclassDialog(paramAnonymousVarArgs[0].intValue());
                }
            };
            synchronized (this.mAdapter) {
                local2.execute(new String[0]);
                return;
            }
        } catch (Exception localException) {
            for (; ; ) {
            }
        }
    }

    public boolean getLoginStatus() {
        try {
            boolean bool = Boolean.parseBoolean(this.isLogin);
            return bool;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return false;
    }

    public void reCall() {
        try {
            new AsyncTask() {
                protected EngineResponse doInBackground(String... paramAnonymousVarArgs) {
                    try {
                        if (JsonRpcEngine.this.forumStatus == null) {
                        }
                        EngineResponse localEngineResponse;
                        for (paramAnonymousVarArgs = new XMLRPCClient(URI.create(JsonRpcEngine.this.url)); ; paramAnonymousVarArgs = new XMLRPCClient(URI.create(JsonRpcEngine.this.url), JsonRpcEngine.this.forumStatus)) {
                            publishProgress(new Integer[]{Integer.valueOf(1)});
                            paramAnonymousVarArgs.send(JsonRpcEngine.this.lastMethod, JsonRpcEngine.this.lastParam.toArray(), JsonRpcEngine.this.mContext);
                            publishProgress(new Integer[]{Integer.valueOf(2)});
                            paramAnonymousVarArgs.retrive();
                            publishProgress(new Integer[]{Integer.valueOf(3)});
                            localEngineResponse = new EngineResponse();
                            localEngineResponse.setMethod(JsonRpcEngine.this.lastMethod);
                            localEngineResponse.setResponse(paramAnonymousVarArgs.parse());
                            localEngineResponse.setSuccess(true);
                            JsonRpcEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                            return localEngineResponse;
                        }
                        return localEngineResponse;
                    } catch (Exception paramAnonymousVarArgs) {
                        localEngineResponse = new EngineResponse();
                        localEngineResponse.setMethod(JsonRpcEngine.this.lastMethod);
                        localEngineResponse.setErrorMessage(paramAnonymousVarArgs.getMessage());
                        localEngineResponse.setSuccess(false);
                    }
                }

                protected void onPostExecute(EngineResponse paramAnonymousEngineResponse) {
                    JsonRpcEngine.this.mAdapter.callBack(paramAnonymousEngineResponse);
                }
            }.execute(new String[0]);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/JsonRpcEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */