package com.quoord.tapatalkpro.favunread;

import android.content.Context;
import android.content.SharedPreferences;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ForumCookiesCache;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngineService;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.LoginStatus;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class ForumUnreadStatusCall
        implements CallBackInterface {
    private String boxId = null;
    private int conversationPage = 0;
    private boolean isLoginSuccess = false;
    private int loginNum = 0;
    private Context mContext;
    private TapatalkEngineService mLoginEngine;
    private LoginStatus mLoginStatus;
    private Thread mThread;
    private UnreadStatus mUnread;
    private String methodInboxStat = "get_inbox_stat";
    private String methodLogin = "login";
    private String methodSignin = "sign_in";
    private OnForumUnreadStatusCallOverListener overListener;
    private int pageLimit = 3;
    private int pmPage = 0;
    private ArrayList<PrivateMessage> realPmList = new ArrayList();
    private ArrayList<Topic> realSubScribeList = new ArrayList();
    private ArrayList<Conversation> realconversationList = new ArrayList();
    private Thread specificThread;
    private int topicPage = 0;

    public ForumUnreadStatusCall(TapatalkForum paramTapatalkForum, Context paramContext, int paramInt) {
        this.mContext = paramContext;
        initData(paramTapatalkForum, paramInt);
        initThread();
    }

    private void addConversation(HashMap paramHashMap, Context paramContext) {
        if (paramHashMap != null) {
            paramHashMap = Conversation.createConverBean(paramHashMap, paramContext, true);
            if (paramHashMap.isNew_post()) {
                paramHashMap.setLoginStatus(this.mUnread.getLoginStatus());
                this.realconversationList.add(paramHashMap);
            }
        }
    }

    private void addPm(HashMap paramHashMap, Context paramContext, String paramString, boolean paramBoolean) {
        if (paramHashMap != null) {
            paramHashMap = PrivateMessage.createPMBean(paramHashMap, paramContext, paramString, paramBoolean, null, true);
            paramHashMap.setLoginStatus(this.mUnread.getLoginStatus());
            if (paramHashMap.getMsgState() == 1) {
                this.realPmList.add(paramHashMap);
            }
        }
    }

    private void addTopic(HashMap paramHashMap, Context paramContext) {
        if (paramHashMap != null) {
            paramHashMap = Topic.createTopicBean(paramHashMap, paramContext);
            paramHashMap.setLoginStatus(this.mUnread.getLoginStatus());
            paramHashMap.setSubscribe(true);
            this.realSubScribeList.add(paramHashMap);
        }
    }

    private void get_box(String paramString) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        localArrayList.add(Integer.valueOf(this.pmPage * 20));
        localArrayList.add(Integer.valueOf(this.pmPage * 20 + 19));
        this.mLoginEngine.call("get_box", localArrayList);
    }

    private void get_box_info() {
        ArrayList localArrayList = new ArrayList();
        this.mLoginEngine.call("get_box_info", localArrayList);
    }

    private void get_inbox_stat() {
        ArrayList localArrayList = new ArrayList();
        this.mLoginEngine.call(this.methodInboxStat, localArrayList);
    }

    private void initData(TapatalkForum paramTapatalkForum, int paramInt) {
        this.mLoginStatus = new LoginStatus();
        this.mLoginStatus.setForumName(paramTapatalkForum.getName());
        this.mLoginStatus.setForumId(paramTapatalkForum.getId());
        this.mLoginStatus.setUrl(paramTapatalkForum.getUrl());
        this.mLoginStatus.setLowerUserName(paramTapatalkForum.getLowerUserName());
        this.mLoginStatus.setUserName(paramTapatalkForum.getUserName());
        this.mLoginStatus.setPassWord(paramTapatalkForum.getPassword());
        this.mLoginStatus.setExt(paramTapatalkForum.getExt());
        this.mLoginStatus.setFolder(paramTapatalkForum.getFolder());
        this.mLoginStatus.setSupportConve(paramTapatalkForum.isSupportConve());
        this.mLoginStatus.setForumIconUrl(paramTapatalkForum.getIconUrl());
        this.mLoginStatus.setApiLevel(paramTapatalkForum.getApiLevel());
        this.mUnread = new UnreadStatus();
        this.mUnread.setLoginStatus(this.mLoginStatus);
        this.mUnread.setForumPri(paramTapatalkForum.getPrimaryKey());
        this.mUnread.setListIndex(paramInt);
        this.mUnread.setCall(this);
        this.mLoginEngine = new TapatalkEngineService(null, this.mLoginStatus.getLoginUrl(), this, this.mLoginStatus, this.mContext);
    }

    private void initSpecificCall() {
        this.realconversationList.clear();
        this.realPmList.clear();
        this.realSubScribeList.clear();
        this.topicPage = 0;
        this.pmPage = 0;
        this.conversationPage = 0;
    }

    private void initThread() {
        this.mThread = new Thread(new Runnable() {
            public void run() {
                if (Util.isLoggedForum(ForumUnreadStatusCall.this.mContext, ForumUnreadStatusCall.this.mLoginStatus.getForumId(), ForumUnreadStatusCall.this.mLoginStatus.getLowerUserName(), ForumUnreadStatusCall.this.mLoginStatus.getPassWord())) {
                    ForumUnreadStatusCall.this.startLogin();
                    return;
                }
                ForumUnreadStatusCall.this.overListener.isGetInfoOver(ForumUnreadStatusCall.this.mUnread);
            }
        });
        this.specificThread = new Thread(new Runnable() {
            public void run() {
                ForumUnreadStatusCall.this.initSpecificCall();
                ForumUnreadStatusCall.this.mUnread.initLocalSubscribeForum(ForumUnreadStatusCall.this.mContext);
                if (ForumUnreadStatusCall.this.mUnread.getUnreadSubscribed() > 0) {
                    ForumUnreadStatusCall.this.get_subscribe_topic();
                }
                while (ForumUnreadStatusCall.this.mUnread.getUnreadPm() <= 0) {
                    return;
                }
                if (ForumUnreadStatusCall.this.mLoginStatus.isSupportConve()) {
                    ForumUnreadStatusCall.this.getConversations();
                    return;
                }
                ForumUnreadStatusCall.this.get_box_info();
            }
        });
    }

    private void isInfoOver() {
        if (isHasListener()) {
            this.overListener.isGetInfoOver(this.mUnread);
        }
    }

    private void isLoginFailed() {
        if (isHasListener()) {
            this.overListener.isUnloginInvoke(this.mUnread);
        }
    }

    private void isSpecificOver() {
        if (isHasListener()) {
            this.overListener.isGetSpecificOver(this.mUnread);
        }
    }

    /* Error */
    private void loginWithTapatalkId(LoginStatus paramLoginStatus, TapatalkEngineService paramTapatalkEngineService, String paramString1, String paramString2, String paramString3, String paramString4) {
        // Byte code:
        //   0: new 79	java/util/ArrayList
        //   3: dup
        //   4: invokespecial 80	java/util/ArrayList:<init>	()V
        //   7: astore 7
        //   9: aload 7
        //   11: aload 5
        //   13: invokevirtual 149	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   16: pop
        //   17: aload 7
        //   19: aload 4
        //   21: invokevirtual 149	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   24: pop
        //   25: aload_3
        //   26: invokestatic 330	com/quoord/tapatalkpro/util/Util:checkString	(Ljava/lang/String;)Z
        //   29: ifeq +99 -> 128
        //   32: aload_3
        //   33: ldc_w 332
        //   36: invokevirtual 338	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   39: astore 4
        //   41: aload 4
        //   43: astore_3
        //   44: aload 7
        //   46: aload_3
        //   47: invokevirtual 149	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   50: pop
        //   51: aload 6
        //   53: invokestatic 330	com/quoord/tapatalkpro/util/Util:checkString	(Ljava/lang/String;)Z
        //   56: ifeq +98 -> 154
        //   59: aload 6
        //   61: invokevirtual 341	java/lang/String:trim	()Ljava/lang/String;
        //   64: ldc_w 343
        //   67: invokevirtual 338	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   70: astore_3
        //   71: aload 7
        //   73: aload_3
        //   74: invokevirtual 149	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   77: pop
        //   78: aload_1
        //   79: invokevirtual 344	com/quoord/tools/LoginStatus:getApiLevel	()I
        //   82: iconst_3
        //   83: if_icmplt +95 -> 178
        //   86: bipush 12
        //   88: invokestatic 350	com/quoord/tapatalkpro/ics/tapatalkid/SignInWithOtherUtil:createDefaultPassWord	(I)Ljava/lang/String;
        //   91: astore_3
        //   92: aload_3
        //   93: ldc_w 343
        //   96: invokevirtual 338	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   99: astore_1
        //   100: aload 7
        //   102: aload_1
        //   103: invokevirtual 149	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   106: pop
        //   107: aload_2
        //   108: aload_0
        //   109: getfield 59	com/quoord/tapatalkpro/favunread/ForumUnreadStatusCall:methodSignin	Ljava/lang/String;
        //   112: aload 7
        //   114: invokevirtual 191	com/quoord/tapatalkpro/util/TapatalkEngineService:call	(Ljava/lang/String;Ljava/util/ArrayList;)V
        //   117: return
        //   118: astore 4
        //   120: aload_3
        //   121: invokevirtual 353	java/lang/String:getBytes	()[B
        //   124: astore_3
        //   125: goto -81 -> 44
        //   128: aload 7
        //   130: ldc_w 355
        //   133: invokevirtual 353	java/lang/String:getBytes	()[B
        //   136: invokevirtual 149	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   139: pop
        //   140: goto -89 -> 51
        //   143: astore_3
        //   144: ldc_w 355
        //   147: invokevirtual 353	java/lang/String:getBytes	()[B
        //   150: astore_3
        //   151: goto -80 -> 71
        //   154: aload 7
        //   156: ldc_w 355
        //   159: invokevirtual 353	java/lang/String:getBytes	()[B
        //   162: invokevirtual 149	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   165: pop
        //   166: goto -88 -> 78
        //   169: astore_1
        //   170: aload_3
        //   171: invokevirtual 353	java/lang/String:getBytes	()[B
        //   174: astore_1
        //   175: goto -75 -> 100
        //   178: aload 7
        //   180: bipush 12
        //   182: invokestatic 350	com/quoord/tapatalkpro/ics/tapatalkid/SignInWithOtherUtil:createDefaultPassWord	(I)Ljava/lang/String;
        //   185: invokevirtual 149	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   188: pop
        //   189: goto -82 -> 107
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	192	0	this	ForumUnreadStatusCall
        //   0	192	1	paramLoginStatus	LoginStatus
        //   0	192	2	paramTapatalkEngineService	TapatalkEngineService
        //   0	192	3	paramString1	String
        //   0	192	4	paramString2	String
        //   0	192	5	paramString3	String
        //   0	192	6	paramString4	String
        //   7	172	7	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   32	41	118	java/lang/Exception
        //   59	71	143	java/lang/Exception
        //   92	100	169	java/io/UnsupportedEncodingException
    }

    private void startLogin() {
        Object localObject2 = new ArrayList();
        try {
            byte[] arrayOfByte1 = this.mLoginStatus.getLowerUserName().getBytes("UTF-8");
            ((ArrayList) localObject2).add(arrayOfByte1);
            if (this.mLoginStatus.getApiLevel() < 3) {
                ((ArrayList) localObject2).add(this.mLoginStatus.getPassWord());
                this.mLoginEngine.call("authorize_user", (ArrayList) localObject2);
                this.loginNum += 1;
                return;
            }
        } catch (UnsupportedEncodingException localUnsupportedEncodingException1) {
            for (; ; ) {
                byte[] arrayOfByte2 = this.mLoginStatus.getLowerUserName().getBytes();
                continue;
                Object localObject1;
                if (this.mLoginStatus.getPassWord() != null) {
                    try {
                        arrayOfByte2 = this.mLoginStatus.getPassWord().getBytes("UTF-8");
                        ((ArrayList) localObject2).add(arrayOfByte2);
                        this.mLoginEngine.call(this.methodLogin, (ArrayList) localObject2);
                    } catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
                        for (; ; ) {
                            localObject1 = this.mLoginStatus.getPassWord().getBytes();
                        }
                    }
                } else if (Util.isSignedUserNew(this.mContext, this.mLoginStatus.getForumId(), this.mLoginStatus.getLowerUserName())) {
                    localObject1 = Prefs.get(this.mContext);
                    localObject2 = this.mLoginStatus.getForumId() + "|" + ((SharedPreferences) localObject1).getInt("tapatalk_auid", 0) + "|" + ((SharedPreferences) localObject1).getString("email", "");
                    loginWithTapatalkId(this.mLoginStatus, this.mLoginEngine, "", Util.getMD5((String) localObject2), ((SharedPreferences) localObject1).getString("token", ""), this.mLoginStatus.getLowerUserName());
                }
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject1 = paramEngineResponse.getMethod();
        Object localObject2;
        int i;
        if (Boolean.valueOf(paramEngineResponse.isSuccess()).booleanValue()) {
            localObject2 = (HashMap) paramEngineResponse.getResponse();
            if ((((String) localObject1).equals("authorize_user")) || (((String) localObject1).equals(this.methodLogin))) {
                if (((String) localObject1).equals(this.methodLogin)) {
                    if (((Boolean) ((HashMap) localObject2).get("result")).booleanValue()) {
                        saveCookiesCache();
                        this.isLoginSuccess = true;
                        get_inbox_stat();
                    }
                }
            }
            label350:
            label458:
            label463:
            label685:
            label822:
            do {
                for (; ; ) {
                    return;
                    isLoginFailed();
                    return;
                    if (localObject2 != null) {
                        if (((Boolean) ((HashMap) localObject2).get("authorize_result")).booleanValue()) {
                            saveCookiesCache();
                            get_inbox_stat();
                            return;
                        }
                        isLoginFailed();
                        return;
                        if (((String) localObject1).equals(this.methodSignin)) {
                            if (((Boolean) ((HashMap) localObject2).get("result")).booleanValue()) {
                                saveCookiesCache();
                                this.isLoginSuccess = true;
                                get_inbox_stat();
                                return;
                            }
                            isLoginFailed();
                            return;
                        }
                        if (((String) localObject1).equals(this.methodInboxStat)) {
                            i = 0;
                            int j = 0;
                            if (((HashMap) localObject2).containsKey("inbox_unread_count")) {
                                i = ((Integer) ((HashMap) localObject2).get("inbox_unread_count")).intValue();
                            }
                            if (((HashMap) localObject2).containsKey("subscribed_topic_unread_count")) {
                                j = ((Integer) ((HashMap) localObject2).get("subscribed_topic_unread_count")).intValue();
                            }
                            this.mUnread.setUnreadSubscribed(j);
                            this.mUnread.setUnreadPm(i);
                            isInfoOver();
                            return;
                        }
                        if (((String) localObject1).equals("get_subscribed_topic")) {
                            try {
                                localObject1 = (HashMap) paramEngineResponse.getResponse();
                                paramEngineResponse = null;
                                if (((HashMap) localObject1).containsKey("result")) {
                                    paramEngineResponse = (Boolean) ((HashMap) localObject1).get("result");
                                }
                                if ((paramEngineResponse != null) && (!paramEngineResponse.booleanValue())) {
                                    continue;
                                }
                                paramEngineResponse = (Object[]) ((HashMap) localObject1).get("topics");
                                Prefs.get(this.mContext);
                                i = 0;
                                if (i >= paramEngineResponse.length) {
                                    if (this.realSubScribeList.size() <= 0) {
                                        break label463;
                                    }
                                    this.mUnread.addTopicList(this.realSubScribeList);
                                    isSpecificOver();
                                    if (!this.mLoginStatus.isSupportConve()) {
                                        break label458;
                                    }
                                    getConversations();
                                    return;
                                }
                            } catch (Exception paramEngineResponse) {
                                paramEngineResponse.printStackTrace();
                                return;
                            }
                            localObject1 = (HashMap) paramEngineResponse[i];
                            boolean bool = false;
                            if (((HashMap) localObject1).containsKey("new_post")) {
                                bool = ((Boolean) ((HashMap) localObject1).get("new_post")).booleanValue();
                            }
                            if (!bool) {
                                break label1075;
                            }
                            addTopic((HashMap) localObject1, this.mContext);
                            break label1075;
                            get_box_info();
                            return;
                            if (this.topicPage < this.pageLimit) {
                                this.topicPage += 1;
                                get_subscribe_topic();
                                return;
                            }
                            if (this.mLoginStatus.isSupportConve()) {
                                getConversations();
                            }
                            for (; ; ) {
                                isSpecificOver();
                                return;
                                get_box_info();
                            }
                        } else if (((String) localObject1).equals("get_box_info")) {
                            try {
                                paramEngineResponse = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("list");
                                i = 0;
                                while (i < paramEngineResponse.length) {
                                    localObject1 = (HashMap) paramEngineResponse[i];
                                    if (((String) ((HashMap) localObject1).get("box_type")).equals("INBOX")) {
                                        this.boxId = ((String) ((HashMap) localObject1).get("box_id"));
                                        get_box(this.boxId);
                                    }
                                    i += 1;
                                }
                                if (!((String) localObject1).equals("get_box")) {
                                    break label822;
                                }
                            } catch (Exception paramEngineResponse) {
                                paramEngineResponse.printStackTrace();
                                return;
                            }
                        }
                    }
                    try {
                        localObject2 = (HashMap) paramEngineResponse.getResponse();
                        localObject1 = (Object[]) ((HashMap) localObject2).get("list");
                        paramEngineResponse = null;
                        if (((HashMap) localObject2).containsKey("result")) {
                            paramEngineResponse = (Boolean) ((HashMap) localObject2).get("result");
                        }
                        if (paramEngineResponse == null) {
                            break label1082;
                        }
                        if (!paramEngineResponse.booleanValue()) {
                        }
                    } catch (Exception paramEngineResponse) {
                        paramEngineResponse.printStackTrace();
                        return;
                    }
                }
                if (i >= localObject1.length) {
                    if (this.realPmList.size() > 0) {
                        this.mUnread.addPmList(this.realPmList);
                        isSpecificOver();
                    }
                } else {
                    localObject2 = (HashMap) localObject1[i];
                    paramEngineResponse = Integer.valueOf(0);
                    if (((HashMap) localObject2).containsKey("msg_state")) {
                        paramEngineResponse = (Integer) ((HashMap) localObject2).get("msg_state");
                    }
                    if (paramEngineResponse.intValue() != 1) {
                        break label1087;
                    }
                    addPm((HashMap) localObject2, this.mContext, this.boxId, true);
                    break label1087;
                }
                if (this.pmPage < this.pageLimit) {
                    this.pmPage += 1;
                    get_box(this.boxId);
                    return;
                }
                isSpecificOver();
                return;
            } while (!((String) localObject1).equals("get_conversations"));
        }
        for (; ; ) {
            try {
                localObject2 = (HashMap) paramEngineResponse.getResponse();
                localObject1 = (Object[]) ((HashMap) localObject2).get("list");
                paramEngineResponse = null;
                if (((HashMap) localObject2).containsKey("result")) {
                    paramEngineResponse = (Boolean) ((HashMap) localObject2).get("result");
                }
                if (paramEngineResponse == null) {
                    break label1094;
                }
                if (!paramEngineResponse.booleanValue()) {
                    break;
                }
            } catch (Exception paramEngineResponse) {
                paramEngineResponse.printStackTrace();
                return;
            }
            if (i >= localObject1.length) {
                if (this.realconversationList.size() > 0) {
                    this.mUnread.addConversationList(this.realconversationList);
                    isSpecificOver();
                }
            } else {
                paramEngineResponse = (HashMap) localObject1[i];
                localObject2 = (Boolean) paramEngineResponse.get("new_post");
                if ((localObject2 == null) || (!((Boolean) localObject2).booleanValue())) {
                    break label1099;
                }
                addConversation(paramEngineResponse, this.mContext);
                break label1099;
            }
            if (this.conversationPage < this.pageLimit) {
                this.conversationPage += 1;
                getConversations();
                return;
            }
            isSpecificOver();
            return;
            if ((((String) localObject1).equals("authorize_user")) || (((String) localObject1).equals(this.methodLogin)) || (((String) localObject1).equals(this.methodSignin))) {
                isInfoOver();
                isLoginFailed();
                return;
            }
            if (((String) localObject1).equals(this.methodInboxStat)) {
                isInfoOver();
                return;
            }
            isSpecificOver();
            return;
            label1075:
            i += 1;
            break label350;
            label1082:
            i = 0;
            break label685;
            label1087:
            i += 1;
            break label685;
            label1094:
            i = 0;
            continue;
            label1099:
            i += 1;
        }
    }

    public void getConversations() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(this.conversationPage * 20));
        localArrayList.add(Integer.valueOf(this.conversationPage * 20 + 19));
        this.mLoginEngine.call("get_conversations", localArrayList);
    }

    public int getLoginNum() {
        return this.loginNum;
    }

    public Thread getSpecificInfoCallThread() {
        return this.specificThread;
    }

    public void get_subscribe_topic() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(this.topicPage * 20));
        localArrayList.add(Integer.valueOf(this.topicPage * 20 + 19));
        this.mLoginEngine.call("get_subscribed_topic", localArrayList);
    }

    public Thread getmThread() {
        return this.mThread;
    }

    public UnreadStatus getmUnread() {
        return this.mUnread;
    }

    public boolean isHasListener() {
        return this.overListener != null;
    }

    public boolean isLoginSuccess() {
        return this.isLoginSuccess;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void saveCookiesCache() {
        String str = AppCacheManager.getCookieCacheUrl(this.mContext, this.mLoginStatus.getUrl(), this.mLoginStatus.getLowerUserName());
        ForumCookiesCache localForumCookiesCache = new ForumCookiesCache();
        localForumCookiesCache.writeTime = System.currentTimeMillis();
        localForumCookiesCache.saveForTime = 1800000L;
        localForumCookiesCache.cookies = this.mLoginStatus.getCookies();
        AppCacheManager.cacheForumCookiesData(str, localForumCookiesCache);
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setOverListener(OnForumUnreadStatusCallOverListener paramOnForumUnreadStatusCallOverListener) {
        this.overListener = paramOnForumUnreadStatusCallOverListener;
    }

    public void setmUnread(UnreadStatus paramUnreadStatus) {
        this.mUnread = paramUnreadStatus;
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public static abstract interface OnForumUnreadStatusCallOverListener {
        public abstract void isGetInfoOver(UnreadStatus paramUnreadStatus);

        public abstract void isGetSpecificOver(UnreadStatus paramUnreadStatus);

        public abstract void isUnloginInvoke(UnreadStatus paramUnreadStatus);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/favunread/ForumUnreadStatusCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */