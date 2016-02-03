package com.quoord.tapatalkpro.util;

import android.content.Context;
import android.os.AsyncTask;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tools.ForumHttpStatus;
import com.quoord.xmlrpc.XMLRPCClient;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class TapatalkEngineService {
    public static boolean isSFR = false;
    private ForumHttpStatus forumStatus;
    public String isLogin;
    private String lastMethod;
    private ArrayList lastParam;
    CallBackInterface mAdapter;
    private Context mContext;
    String url;

    public TapatalkEngineService(String paramString, CallBackInterface paramCallBackInterface, boolean paramBoolean) {
        this.mAdapter = paramCallBackInterface;
        this.url = paramString;
    }

    public TapatalkEngineService(String paramString1, String paramString2, CallBackInterface paramCallBackInterface, ForumHttpStatus paramForumHttpStatus, Context paramContext) {
        this.mAdapter = paramCallBackInterface;
        this.forumStatus = paramForumHttpStatus;
        this.url = paramString2;
        this.mContext = paramContext;
    }

    private static String getHost(String paramString) {
        try {
            String str = new URL(paramString).getHost();
            return str;
        } catch (MalformedURLException localMalformedURLException) {
            localMalformedURLException.printStackTrace();
        }
        return paramString;
    }

    /* Error */
    public void call(String paramString, ArrayList paramArrayList) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   4: ifnull +51 -> 55
        //   7: aload_1
        //   8: ldc 71
        //   10: invokevirtual 77	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   13: ifne +42 -> 55
        //   16: aload_1
        //   17: ldc 79
        //   19: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   22: ifne +33 -> 55
        //   25: aload_0
        //   26: aload_1
        //   27: putfield 44	com/quoord/tapatalkpro/util/TapatalkEngineService:lastMethod	Ljava/lang/String;
        //   30: aload_0
        //   31: getfield 48	com/quoord/tapatalkpro/util/TapatalkEngineService:lastParam	Ljava/util/ArrayList;
        //   34: ifnull +10 -> 44
        //   37: aload_0
        //   38: getfield 48	com/quoord/tapatalkpro/util/TapatalkEngineService:lastParam	Ljava/util/ArrayList;
        //   41: invokevirtual 88	java/util/ArrayList:clear	()V
        //   44: aload_0
        //   45: aload_2
        //   46: invokevirtual 92	java/util/ArrayList:clone	()Ljava/lang/Object;
        //   49: checkcast 85	java/util/ArrayList
        //   52: putfield 48	com/quoord/tapatalkpro/util/TapatalkEngineService:lastParam	Ljava/util/ArrayList;
        //   55: aload_0
        //   56: getfield 31	com/quoord/tapatalkpro/util/TapatalkEngineService:mAdapter	Lcom/quoord/tapatalkpro/adapter/CallBackInterface;
        //   59: iconst_0
        //   60: invokeinterface 98 2 0
        //   65: new 100	com/quoord/tapatalkpro/bean/EngineResponse
        //   68: dup
        //   69: invokespecial 101	com/quoord/tapatalkpro/bean/EngineResponse:<init>	()V
        //   72: astore 4
        //   74: aload_0
        //   75: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   78: ifnonnull +76 -> 154
        //   81: new 103	com/quoord/xmlrpc/XMLRPCClient
        //   84: dup
        //   85: aload_0
        //   86: getfield 33	com/quoord/tapatalkpro/util/TapatalkEngineService:url	Ljava/lang/String;
        //   89: invokestatic 109	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
        //   92: invokespecial 112	com/quoord/xmlrpc/XMLRPCClient:<init>	(Ljava/net/URI;)V
        //   95: astore_3
        //   96: aload_3
        //   97: aload_1
        //   98: aload_2
        //   99: invokevirtual 116	java/util/ArrayList:toArray	()[Ljava/lang/Object;
        //   102: aload_0
        //   103: getfield 38	com/quoord/tapatalkpro/util/TapatalkEngineService:mContext	Landroid/content/Context;
        //   106: invokevirtual 120	com/quoord/xmlrpc/XMLRPCClient:send	(Ljava/lang/String;[Ljava/lang/Object;Landroid/content/Context;)V
        //   109: aload_3
        //   110: invokevirtual 123	com/quoord/xmlrpc/XMLRPCClient:retrive	()V
        //   113: aload 4
        //   115: aload_1
        //   116: invokevirtual 126	com/quoord/tapatalkpro/bean/EngineResponse:setMethod	(Ljava/lang/String;)V
        //   119: aload 4
        //   121: aload_3
        //   122: invokevirtual 129	com/quoord/xmlrpc/XMLRPCClient:parse	()Ljava/lang/Object;
        //   125: invokevirtual 133	com/quoord/tapatalkpro/bean/EngineResponse:setResponse	(Ljava/lang/Object;)V
        //   128: aload 4
        //   130: iconst_1
        //   131: invokevirtual 136	com/quoord/tapatalkpro/bean/EngineResponse:setSuccess	(Z)V
        //   134: aload_0
        //   135: aload_3
        //   136: invokevirtual 139	com/quoord/xmlrpc/XMLRPCClient:getLoginStatus	()Ljava/lang/String;
        //   139: putfield 141	com/quoord/tapatalkpro/util/TapatalkEngineService:isLogin	Ljava/lang/String;
        //   142: aload_0
        //   143: getfield 31	com/quoord/tapatalkpro/util/TapatalkEngineService:mAdapter	Lcom/quoord/tapatalkpro/adapter/CallBackInterface;
        //   146: aload 4
        //   148: invokeinterface 145 2 0
        //   153: return
        //   154: new 103	com/quoord/xmlrpc/XMLRPCClient
        //   157: dup
        //   158: aload_0
        //   159: getfield 33	com/quoord/tapatalkpro/util/TapatalkEngineService:url	Ljava/lang/String;
        //   162: invokestatic 109	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
        //   165: aload_0
        //   166: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   169: invokespecial 148	com/quoord/xmlrpc/XMLRPCClient:<init>	(Ljava/net/URI;Lcom/quoord/tools/ForumHttpStatus;)V
        //   172: astore_3
        //   173: goto -77 -> 96
        //   176: astore 5
        //   178: aload_0
        //   179: aload_3
        //   180: invokevirtual 139	com/quoord/xmlrpc/XMLRPCClient:getLoginStatus	()Ljava/lang/String;
        //   183: putfield 141	com/quoord/tapatalkpro/util/TapatalkEngineService:isLogin	Ljava/lang/String;
        //   186: aload 5
        //   188: athrow
        //   189: astore_3
        //   190: aload_3
        //   191: instanceof 150
        //   194: ifeq +34 -> 228
        //   197: aload_3
        //   198: athrow
        //   199: astore_2
        //   200: aload_2
        //   201: invokevirtual 151	java/lang/Exception:printStackTrace	()V
        //   204: aload 4
        //   206: aload_1
        //   207: invokevirtual 126	com/quoord/tapatalkpro/bean/EngineResponse:setMethod	(Ljava/lang/String;)V
        //   210: aload 4
        //   212: aload_2
        //   213: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   216: invokevirtual 157	com/quoord/tapatalkpro/bean/EngineResponse:setErrorMessage	(Ljava/lang/String;)V
        //   219: aload 4
        //   221: iconst_0
        //   222: invokevirtual 136	com/quoord/tapatalkpro/bean/EngineResponse:setSuccess	(Z)V
        //   225: goto -83 -> 142
        //   228: aload_0
        //   229: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   232: ifnull +66 -> 298
        //   235: aload_0
        //   236: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   239: invokeinterface 163 1 0
        //   244: ifne +54 -> 298
        //   247: aload_0
        //   248: ldc -91
        //   250: putfield 141	com/quoord/tapatalkpro/util/TapatalkEngineService:isLogin	Ljava/lang/String;
        //   253: aload 4
        //   255: aload_1
        //   256: invokevirtual 126	com/quoord/tapatalkpro/bean/EngineResponse:setMethod	(Ljava/lang/String;)V
        //   259: aload 4
        //   261: aload_3
        //   262: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   265: invokevirtual 157	com/quoord/tapatalkpro/bean/EngineResponse:setErrorMessage	(Ljava/lang/String;)V
        //   268: aload_0
        //   269: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   272: invokeinterface 167 1 0
        //   277: ifeq +12 -> 289
        //   280: aload 4
        //   282: iconst_1
        //   283: invokevirtual 136	com/quoord/tapatalkpro/bean/EngineResponse:setSuccess	(Z)V
        //   286: goto -144 -> 142
        //   289: aload 4
        //   291: iconst_0
        //   292: invokevirtual 136	com/quoord/tapatalkpro/bean/EngineResponse:setSuccess	(Z)V
        //   295: goto -153 -> 142
        //   298: aload_0
        //   299: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   302: ifnull +13 -> 315
        //   305: aload_0
        //   306: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   309: iconst_0
        //   310: invokeinterface 170 2 0
        //   315: aload_0
        //   316: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   319: ifnonnull +67 -> 386
        //   322: new 103	com/quoord/xmlrpc/XMLRPCClient
        //   325: dup
        //   326: aload_0
        //   327: getfield 33	com/quoord/tapatalkpro/util/TapatalkEngineService:url	Ljava/lang/String;
        //   330: invokestatic 109	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
        //   333: invokespecial 112	com/quoord/xmlrpc/XMLRPCClient:<init>	(Ljava/net/URI;)V
        //   336: astore_3
        //   337: aload_3
        //   338: aload_1
        //   339: aload_2
        //   340: invokevirtual 116	java/util/ArrayList:toArray	()[Ljava/lang/Object;
        //   343: aload_0
        //   344: getfield 38	com/quoord/tapatalkpro/util/TapatalkEngineService:mContext	Landroid/content/Context;
        //   347: invokevirtual 120	com/quoord/xmlrpc/XMLRPCClient:send	(Ljava/lang/String;[Ljava/lang/Object;Landroid/content/Context;)V
        //   350: aload_3
        //   351: invokevirtual 123	com/quoord/xmlrpc/XMLRPCClient:retrive	()V
        //   354: aload 4
        //   356: aload_1
        //   357: invokevirtual 126	com/quoord/tapatalkpro/bean/EngineResponse:setMethod	(Ljava/lang/String;)V
        //   360: aload 4
        //   362: aload_3
        //   363: invokevirtual 129	com/quoord/xmlrpc/XMLRPCClient:parse	()Ljava/lang/Object;
        //   366: invokevirtual 133	com/quoord/tapatalkpro/bean/EngineResponse:setResponse	(Ljava/lang/Object;)V
        //   369: aload 4
        //   371: iconst_1
        //   372: invokevirtual 136	com/quoord/tapatalkpro/bean/EngineResponse:setSuccess	(Z)V
        //   375: aload_0
        //   376: aload_3
        //   377: invokevirtual 139	com/quoord/xmlrpc/XMLRPCClient:getLoginStatus	()Ljava/lang/String;
        //   380: putfield 141	com/quoord/tapatalkpro/util/TapatalkEngineService:isLogin	Ljava/lang/String;
        //   383: goto -241 -> 142
        //   386: new 103	com/quoord/xmlrpc/XMLRPCClient
        //   389: dup
        //   390: aload_0
        //   391: getfield 33	com/quoord/tapatalkpro/util/TapatalkEngineService:url	Ljava/lang/String;
        //   394: invokestatic 109	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
        //   397: aload_0
        //   398: getfield 36	com/quoord/tapatalkpro/util/TapatalkEngineService:forumStatus	Lcom/quoord/tools/ForumHttpStatus;
        //   401: invokespecial 148	com/quoord/xmlrpc/XMLRPCClient:<init>	(Ljava/net/URI;Lcom/quoord/tools/ForumHttpStatus;)V
        //   404: astore_3
        //   405: goto -68 -> 337
        //   408: astore_2
        //   409: aload_0
        //   410: aload_3
        //   411: invokevirtual 139	com/quoord/xmlrpc/XMLRPCClient:getLoginStatus	()Ljava/lang/String;
        //   414: putfield 141	com/quoord/tapatalkpro/util/TapatalkEngineService:isLogin	Ljava/lang/String;
        //   417: aload_2
        //   418: athrow
        //   419: astore_1
        //   420: aload_1
        //   421: invokevirtual 151	java/lang/Exception:printStackTrace	()V
        //   424: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	425	0	this	TapatalkEngineService
        //   0	425	1	paramString	String
        //   0	425	2	paramArrayList	ArrayList
        //   95	85	3	localXMLRPCClient1	XMLRPCClient
        //   189	73	3	localException1	Exception
        //   336	75	3	localXMLRPCClient2	XMLRPCClient
        //   72	298	4	localEngineResponse	EngineResponse
        //   176	11	5	localException2	Exception
        // Exception table:
        //   from	to	target	type
        //   113	142	176	java/lang/Exception
        //   178	189	189	java/lang/Exception
        //   74	96	199	java/lang/Exception
        //   96	113	199	java/lang/Exception
        //   154	173	199	java/lang/Exception
        //   190	199	199	java/lang/Exception
        //   228	286	199	java/lang/Exception
        //   289	295	199	java/lang/Exception
        //   298	315	199	java/lang/Exception
        //   315	337	199	java/lang/Exception
        //   337	354	199	java/lang/Exception
        //   375	383	199	java/lang/Exception
        //   386	405	199	java/lang/Exception
        //   409	419	199	java/lang/Exception
        //   354	375	408	java/lang/Exception
        //   142	153	419	java/lang/Exception
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
                        if (TapatalkEngineService.this.forumStatus == null) {
                        }
                        EngineResponse localEngineResponse;
                        for (paramAnonymousVarArgs = new XMLRPCClient(URI.create(TapatalkEngineService.this.url)); ; paramAnonymousVarArgs = new XMLRPCClient(URI.create(TapatalkEngineService.this.url), TapatalkEngineService.this.forumStatus)) {
                            publishProgress(new Integer[]{Integer.valueOf(1)});
                            paramAnonymousVarArgs.send(TapatalkEngineService.this.lastMethod, TapatalkEngineService.this.lastParam.toArray(), TapatalkEngineService.this.mContext);
                            publishProgress(new Integer[]{Integer.valueOf(2)});
                            paramAnonymousVarArgs.retrive();
                            publishProgress(new Integer[]{Integer.valueOf(3)});
                            localEngineResponse = new EngineResponse();
                            localEngineResponse.setMethod(TapatalkEngineService.this.lastMethod);
                            localEngineResponse.setResponse(paramAnonymousVarArgs.parse());
                            localEngineResponse.setSuccess(true);
                            TapatalkEngineService.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                            return localEngineResponse;
                        }
                        return localEngineResponse;
                    } catch (Exception paramAnonymousVarArgs) {
                        localEngineResponse = new EngineResponse();
                        localEngineResponse.setMethod(TapatalkEngineService.this.lastMethod);
                        localEngineResponse.setErrorMessage(paramAnonymousVarArgs.getMessage());
                        localEngineResponse.setSuccess(false);
                    }
                }

                protected void onPostExecute(EngineResponse paramAnonymousEngineResponse) {
                    TapatalkEngineService.this.mAdapter.callBack(paramAnonymousEngineResponse);
                }
            }.execute(new String[0]);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/TapatalkEngineService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */