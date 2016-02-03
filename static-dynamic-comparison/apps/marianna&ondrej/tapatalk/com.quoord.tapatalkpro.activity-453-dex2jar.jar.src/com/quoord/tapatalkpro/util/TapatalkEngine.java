package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionCallBack;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tools.tracking.GoogleAnalyticsTools;
import com.quoord.xmlrpc.XMLRPCClient;
import com.quoord.xmlrpc.XmlRpcException;

import java.net.URI;
import java.util.ArrayList;

import org.xml.sax.ContentHandler;

public class TapatalkEngine {
    private static final int RECALL_FUNCTION = 2;
    private static final int SUCCESS_RETURN = 1;
    public static boolean isSFR = false;
    private ForumStatus forumStatus;
    public String isLogin;
    public ContentHandler lastHandler;
    public String lastMethod;
    public ArrayList lastParam;
    TryTwiceCallBackInterface mCallBack;
    private Context mContext;
    String url;

    public TapatalkEngine(TryTwiceCallBackInterface paramTryTwiceCallBackInterface, ForumStatus paramForumStatus, Context paramContext) {
        this.mCallBack = paramTryTwiceCallBackInterface;
        this.forumStatus = paramForumStatus;
        this.mContext = paramContext;
        if (!this.mContext.getResources().getBoolean(2131558402)) {
            if (this.forumStatus.getUrl() != null) {
                if (this.forumStatus.tapatalkForum.getExt().equals("none")) {
                    this.url = (this.forumStatus.getUrl() + "/" + this.forumStatus.tapatalkForum.getFolder() + "/mobiquo");
                }
            } else {
                return;
            }
            if (this.forumStatus.getUrl().endsWith("/")) {
                this.url = (this.forumStatus.getUrl() + this.forumStatus.tapatalkForum.getFolder() + "/mobiquo." + this.forumStatus.tapatalkForum.getExt());
                return;
            }
            this.url = (this.forumStatus.getUrl() + "/" + this.forumStatus.tapatalkForum.getFolder() + "/mobiquo." + this.forumStatus.tapatalkForum.getExt());
            return;
        }
        this.url = (this.forumStatus.getUrl() + "/" + this.forumStatus.tapatalkForum.getFolder() + "/mobiquo");
    }

    public void call(final String paramString, final ArrayList paramArrayList) {
        String str = this.url;
        if (this.mContext != null) {
        }
        try {
            GoogleAnalyticsTools.trackEvent((Activity) this.mContext, "rpc", paramString);
            if ((this.forumStatus != null) && (!paramString.equals(this.forumStatus.getAuthroizeUserFunction())) && (!paramString.equals("get_config")) && (!paramString.endsWith("sign_in"))) {
                this.lastMethod = paramString;
                if (this.lastParam != null) {
                    this.lastParam.clear();
                }
                this.lastParam = ((ArrayList) paramArrayList.clone());
            }
            if (paramString.equalsIgnoreCase("upload_attachment_x")) {
                try {
                    uploadToForum(paramArrayList, (ForumActivityStatus) this.mContext);
                    return;
                } catch (Exception paramString) {
                    paramString.printStackTrace();
                    return;
                }
            }
            if (paramString.equalsIgnoreCase("upload_avatar_x")) {
                try {
                    uploadAvatar(paramArrayList, (ForumActivityStatus) this.mContext);
                    return;
                } catch (Exception paramString) {
                    paramString.printStackTrace();
                    return;
                }
            }
            if (this.mCallBack != null) {
                this.mCallBack.setOpCancel(false);
            }
            new Thread() {
                public void handleMessage(Message paramAnonymousMessage) {
                    switch (paramAnonymousMessage.what) {
                    }
                    do {
                        return;
                        paramAnonymousMessage = (EngineResponse) paramAnonymousMessage.obj;
                    }
                    while ((TapatalkEngine.this.mCallBack == null) || ((TapatalkEngine.this.mCallBack.isOpCancel()) && (!paramString.equalsIgnoreCase("get_config"))));
                    try {
                        TapatalkEngine.this.mCallBack.callBack(paramAnonymousMessage);
                        return;
                    } catch (Exception paramAnonymousMessage) {
                        paramAnonymousMessage.printStackTrace();
                    }
                }
            }
            {
                public void run ()
                {
                    EngineResponse localEngineResponse2;
                    try {
                        Object localObject;
                        if (TapatalkEngine.this.forumStatus == null) {
                            localObject = new XMLRPCClient(URI.create(TapatalkEngine.this.url));
                        }
                        for (; ; ) {
                            if (paramString.equalsIgnoreCase("logout_user")) {
                                ((XMLRPCClient) localObject).setCookie(TapatalkEngine.this.forumStatus.getCookie());
                            }
                            if ((!paramString.equalsIgnoreCase("login")) && (!paramString.equalsIgnoreCase("sign_in")) && (TapatalkEngine.this.mCallBack != null) && ((TapatalkEngine.this.mCallBack instanceof ForumRootAdapter))) {
                                TapatalkEngine.this.mCallBack.setSaxCall(false);
                            }
                            ((XMLRPCClient) localObject).send(paramString, paramArrayList.toArray(), TapatalkEngine.this.mContext);
                            try {
                                EngineResponse localEngineResponse1 = new EngineResponse();
                                try {
                                    ((XMLRPCClient) localObject).retrive();
                                    localEngineResponse1.setMethod(paramString);
                                    localEngineResponse1.setResponse(((XMLRPCClient) localObject).parse());
                                    localEngineResponse1.setSuccess(true);
                                    TapatalkEngine.this.isLogin = ((XMLRPCClient) localObject).getLoginStatus();
                                    localObject = this.val$handler.obtainMessage(1, localEngineResponse1);
                                    this.val$handler.sendMessage((Message) localObject);
                                    return;
                                } catch (Exception localException3) {
                                    TapatalkEngine.this.isLogin = ((XMLRPCClient) localObject).getLoginStatus();
                                    throw localException3;
                                }
                                localObject = new XMLRPCClient(URI.create(TapatalkEngine.this.url), TapatalkEngine.this.forumStatus);
                            } catch (Exception localException1) {
                                localException1.printStackTrace();
                                localEngineResponse2 = new EngineResponse();
                                localEngineResponse2.setMethod(paramString);
                                localEngineResponse2.setErrorMessage(localException1.getMessage());
                                if (!(localException1 instanceof XmlRpcException)) {
                                    break label356;
                                }
                            }
                        }
                        localEngineResponse2.setSuccess(true);
                        Message localMessage1 = this.val$handler.obtainMessage(1, localEngineResponse2);
                        this.val$handler.sendMessage(localMessage1);
                        return;
                    } catch (Exception localException2) {
                        localException2.printStackTrace();
                        localEngineResponse2 = new EngineResponse();
                        localEngineResponse2.setMethod(paramString);
                        if (!(localException2 instanceof XmlRpcException)) {
                            break label364;
                        }
                    }
                    localEngineResponse2.setSuccess(true);
                    for (; ; ) {
                        Message localMessage2 = this.val$handler.obtainMessage(1, localEngineResponse2);
                        this.val$handler.sendMessage(localMessage2);
                        return;
                        label356:
                        localEngineResponse2.setSuccess(false);
                        break;
                        label364:
                        localEngineResponse2.setSuccess(false);
                    }
                }
            }.start();
            return;
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
            if (this.lastMethod.equalsIgnoreCase("login_mod")) {
                return;
            }
            boolean bool = this.lastMethod.equalsIgnoreCase("upload_attachment_x");
            if (bool) {
                try {
                    uploadToForum(this.lastParam, (ForumActivityStatus) this.mContext);
                    return;
                } catch (Exception localException1) {
                    localException1.printStackTrace();
                    return;
                }
            }
            new AsyncTask() {
                protected EngineResponse doInBackground(String... paramAnonymousVarArgs) {
                    try {
                        if (TapatalkEngine.this.forumStatus == null) {
                        }
                        EngineResponse localEngineResponse;
                        for (paramAnonymousVarArgs = new XMLRPCClient(URI.create(TapatalkEngine.this.url)); ; paramAnonymousVarArgs = new XMLRPCClient(URI.create(TapatalkEngine.this.url), TapatalkEngine.this.forumStatus)) {
                            publishProgress(new Integer[]{Integer.valueOf(1)});
                            paramAnonymousVarArgs.send(TapatalkEngine.this.lastMethod, TapatalkEngine.this.lastParam.toArray(), TapatalkEngine.this.mContext);
                            publishProgress(new Integer[]{Integer.valueOf(2)});
                            paramAnonymousVarArgs.retrive();
                            publishProgress(new Integer[]{Integer.valueOf(3)});
                            localEngineResponse = new EngineResponse();
                            localEngineResponse.setMethod(TapatalkEngine.this.lastMethod);
                            localEngineResponse.setResponse(paramAnonymousVarArgs.parse());
                            localEngineResponse.setSuccess(true);
                            TapatalkEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                            return localEngineResponse;
                        }
                        return localEngineResponse;
                    } catch (Exception paramAnonymousVarArgs) {
                        localEngineResponse = new EngineResponse();
                        localEngineResponse.setMethod(TapatalkEngine.this.lastMethod);
                        localEngineResponse.setErrorMessage(paramAnonymousVarArgs.getMessage());
                        localEngineResponse.setSuccess(false);
                    }
                }

                protected void onPostExecute(EngineResponse paramAnonymousEngineResponse) {
                    if (TapatalkEngine.this.mCallBack != null) {
                        TapatalkEngine.this.mCallBack.callBack(paramAnonymousEngineResponse);
                    }
                }
            }.execute(new String[0]);
        } catch (Exception localException2) {
            localException2.printStackTrace();
            return;
        }
    }

    public void resaxcall() {
        if (this.mCallBack != null) {
            this.mCallBack.setOpCancel(false);
        }
        AsyncTask local6 = new AsyncTask() {
            protected EngineResponse doInBackground(String... paramAnonymousVarArgs) {
                try {
                    paramAnonymousVarArgs = new XMLRPCClient(URI.create(TapatalkEngine.this.url), TapatalkEngine.this.forumStatus);
                    paramAnonymousVarArgs.send(TapatalkEngine.this.lastMethod, TapatalkEngine.this.lastParam.toArray(), TapatalkEngine.this.mContext);
                    paramAnonymousVarArgs.retrive();
                    try {
                        EngineResponse localEngineResponse1 = new EngineResponse();
                        try {
                            paramAnonymousVarArgs.parse(TapatalkEngine.this.lastHandler, true);
                            TapatalkEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                            return localEngineResponse1;
                        } catch (Exception localException) {
                            TapatalkEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                            localException.printStackTrace();
                            throw localException;
                        }
                        throw paramAnonymousVarArgs;
                    } catch (Exception paramAnonymousVarArgs) {
                        if (!(paramAnonymousVarArgs instanceof XmlRpcException)) {
                        }
                    }
                    TapatalkEngine.this.isLogin = "false";
                } catch (Exception paramAnonymousVarArgs) {
                    paramAnonymousVarArgs.printStackTrace();
                    localEngineResponse2 = new EngineResponse();
                    localEngineResponse2.setMethod(TapatalkEngine.this.lastMethod);
                    localEngineResponse2.setErrorMessage(paramAnonymousVarArgs.getMessage());
                    localEngineResponse2.setSuccess(false);
                    return localEngineResponse2;
                }
                EngineResponse localEngineResponse2 = new EngineResponse();
                localEngineResponse2.setMethod(TapatalkEngine.this.lastMethod);
                localEngineResponse2.setErrorMessage(paramAnonymousVarArgs.getMessage());
                if (TapatalkEngine.this.forumStatus.isLogin()) {
                    localEngineResponse2.setSuccess(true);
                    return localEngineResponse2;
                }
                localEngineResponse2.setSuccess(false);
                return localEngineResponse2;
            }

            protected void onPostExecute(EngineResponse paramAnonymousEngineResponse) {
            }

            protected void onProgressUpdate(Integer... paramAnonymousVarArgs) {
            }
        };
        try {
            local6.execute(new String[0]);
            return;
        } finally {
        }
    }

    public void saxcall(final ContentHandler paramContentHandler, final String paramString, final ArrayList paramArrayList) {
        if (this.mContext != null) {
            GoogleAnalyticsTools.trackEvent(this.mContext, "rpc", paramString);
        }
        if ((this.forumStatus != null) && (!paramString.equals(this.forumStatus.getAuthroizeUserFunction())) && (!paramString.equals("get_config"))) {
            this.lastMethod = paramString;
            if (this.lastParam != null) {
                this.lastParam.clear();
            }
            this.lastParam = ((ArrayList) paramArrayList.clone());
            this.lastHandler = paramContentHandler;
        }
        if (this.mCallBack != null) {
            this.mCallBack.setOpCancel(false);
        }
        Looper.getMainLooper();
        new Thread() {
            public void run() {
                try {
                    XMLRPCClient localXMLRPCClient;
                    if (TapatalkEngine.this.forumStatus == null) {
                        localXMLRPCClient = new XMLRPCClient(URI.create(TapatalkEngine.this.url));
                    }
                    for (; ; ) {
                        localXMLRPCClient.send(paramString, paramArrayList.toArray(), TapatalkEngine.this.mContext);
                        localXMLRPCClient.retrive();
                        try {
                            new EngineResponse();
                            try {
                                final ForumLoginOrSignAction localForumLoginOrSignAction;
                                if (TapatalkEngine.this.mCallBack != null) {
                                    localXMLRPCClient.parse(paramContentHandler, TapatalkEngine.this.mCallBack.getTryTwice());
                                    TapatalkEngine.this.isLogin = localXMLRPCClient.getLoginStatus();
                                    boolean bool = TapatalkEngine.this.forumStatus.isSignInForumUser(TapatalkEngine.this.mContext);
                                    if ((Boolean.parseBoolean(TapatalkEngine.this.isLogin) != TapatalkEngine.this.forumStatus.isLogin()) && (TapatalkEngine.this.forumStatus.isLogin()) && (!TapatalkEngine.this.mCallBack.getTryTwice())) {
                                        TapatalkEngine.this.mCallBack.setTryTwice(true);
                                        TapatalkEngine.this.mCallBack.setSaxCall(true);
                                        localForumLoginOrSignAction = new ForumLoginOrSignAction(TapatalkEngine.this.mContext, TapatalkEngine.this.forumStatus);
                                        if ((!TapatalkEngine.this.forumStatus.isTapatalkSignIn(TapatalkEngine.this.mContext)) || (!bool) || (TapatalkEngine.this.forumStatus.tapatalkForum.hasPassword())) {
                                            break label320;
                                        }
                                        localForumLoginOrSignAction.signForum(TapatalkEngine.this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), null, false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                                            public void actionErrorBack(String paramAnonymous2String1, String paramAnonymous2String2) {
                                                if ((TapatalkEngine.this.forumStatus.tapatalkForum.getPassword() != null) && (!TapatalkEngine.this.forumStatus.tapatalkForum.getPassword().equals(""))) {
                                                    localForumLoginOrSignAction.loginForum(TapatalkEngine.this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), TapatalkEngine.this.forumStatus.tapatalkForum.getPassword(), false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                                                        public void actionErrorBack(String paramAnonymous3String1, String paramAnonymous3String2) {
                                                        }

                                                        public void actionSuccessBack(ForumStatus paramAnonymous3ForumStatus) {
                                                            TapatalkEngine.this.resaxcall();
                                                        }
                                                    });
                                                }
                                            }

                                            public void actionSuccessBack(ForumStatus paramAnonymous2ForumStatus) {
                                                paramAnonymous2ForumStatus.setSignInForumUser(TapatalkEngine.this.mContext);
                                                TapatalkEngine.this.resaxcall();
                                            }
                                        });
                                    }
                                }
                                label320:
                                while ((TapatalkEngine.this.forumStatus.tapatalkForum.getPassword() == null) || (TapatalkEngine.this.forumStatus.tapatalkForum.getPassword().equals(""))) {
                                    return;
                                    localXMLRPCClient = new XMLRPCClient(URI.create(TapatalkEngine.this.url), TapatalkEngine.this.forumStatus);
                                    break;
                                }
                                localForumLoginOrSignAction.loginForum(TapatalkEngine.this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), TapatalkEngine.this.forumStatus.tapatalkForum.getPassword(), false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                                    public void actionErrorBack(String paramAnonymous2String1, String paramAnonymous2String2) {
                                    }

                                    public void actionSuccessBack(ForumStatus paramAnonymous2ForumStatus) {
                                        TapatalkEngine.this.resaxcall();
                                    }
                                });
                                return;
                            } catch (Exception localException3) {
                                TapatalkEngine.this.isLogin = localXMLRPCClient.getLoginStatus();
                                localException3.printStackTrace();
                                throw localException3;
                            }
                            throw localException1;
                        } catch (Exception localException1) {
                            if (!(localException1 instanceof XmlRpcException)) {
                            }
                        }
                    }
                    TapatalkEngine.this.isLogin = "false";
                } catch (Exception localException2) {
                    localException2.printStackTrace();
                    localEngineResponse = new EngineResponse();
                    localEngineResponse.setMethod(paramString);
                    localEngineResponse.setErrorMessage(localException2.getMessage());
                    localEngineResponse.setSuccess(false);
                    return;
                }
                EngineResponse localEngineResponse = new EngineResponse();
                localEngineResponse.setMethod(paramString);
                localEngineResponse.setErrorMessage(localException2.getMessage());
                if (TapatalkEngine.this.forumStatus.isLogin()) {
                    localEngineResponse.setSuccess(true);
                    return;
                }
                localEngineResponse.setSuccess(false);
            }
        }.start();
    }

    public void setmCallBack(TryTwiceCallBackInterface paramTryTwiceCallBackInterface) {
        this.mCallBack = paramTryTwiceCallBackInterface;
    }

    public void uploadAvatar(final ArrayList paramArrayList, final ForumActivityStatus paramForumActivityStatus)
            throws Exception {
        new AsyncTask() {
            protected EngineResponse doInBackground(String... paramAnonymousVarArgs) {
                paramAnonymousVarArgs = new GeoPictureUploader(TapatalkEngine.this.forumStatus, paramForumActivityStatus);
                EngineResponse localEngineResponse = new EngineResponse();
                try {
                    Object localObject = paramAnonymousVarArgs.uploadAvatar(paramArrayList);
                    localEngineResponse.setMethod("upload_avatar_x");
                    localEngineResponse.setResponse(localObject);
                    localEngineResponse.setSuccess(true);
                    TapatalkEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                    return localEngineResponse;
                } catch (Exception localException) {
                    localException.printStackTrace();
                    TapatalkEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                    localException.printStackTrace();
                    localEngineResponse.setMethod("upload_avatar_x");
                    localEngineResponse.setErrorMessage(localException.getMessage());
                    localEngineResponse.setSuccess(false);
                }
                return localEngineResponse;
            }

            protected void onPostExecute(EngineResponse paramAnonymousEngineResponse) {
                if ((TapatalkEngine.this.mCallBack != null) && (!TapatalkEngine.this.mCallBack.isOpCancel())) {
                }
                try {
                    TapatalkEngine.this.mCallBack.callBack(paramAnonymousEngineResponse);
                    return;
                } catch (Exception paramAnonymousEngineResponse) {
                    paramAnonymousEngineResponse.printStackTrace();
                }
            }
        }.execute(new String[0]);
    }

    public void uploadToForum(final ArrayList paramArrayList, final ForumActivityStatus paramForumActivityStatus)
            throws Exception {
        new AsyncTask() {
            protected EngineResponse doInBackground(String... paramAnonymousVarArgs) {
                paramAnonymousVarArgs = new GeoPictureUploader(TapatalkEngine.this.forumStatus, paramForumActivityStatus);
                EngineResponse localEngineResponse = new EngineResponse();
                try {
                    Object localObject = paramAnonymousVarArgs.uploadPictureToForum(paramArrayList, (String) paramArrayList.get(0), TapatalkEngine.this.mContext);
                    localEngineResponse.setMethod("upload_attachment_x");
                    localEngineResponse.setResponse(localObject);
                    localEngineResponse.setSuccess(true);
                    TapatalkEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                    return localEngineResponse;
                } catch (Exception localException) {
                    TapatalkEngine.this.isLogin = paramAnonymousVarArgs.getLoginStatus();
                    localException.printStackTrace();
                    localEngineResponse.setMethod("upload_attachment_x");
                    localEngineResponse.setErrorMessage(localException.getMessage());
                    localEngineResponse.setSuccess(false);
                }
                return localEngineResponse;
            }

            protected void onPostExecute(EngineResponse paramAnonymousEngineResponse) {
                if ((TapatalkEngine.this.mCallBack != null) && (!TapatalkEngine.this.mCallBack.isOpCancel())) {
                }
                try {
                    TapatalkEngine.this.mCallBack.callBack(paramAnonymousEngineResponse);
                    return;
                } catch (Exception paramAnonymousEngineResponse) {
                    paramAnonymousEngineResponse.printStackTrace();
                }
            }
        }.execute(new String[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/TapatalkEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */