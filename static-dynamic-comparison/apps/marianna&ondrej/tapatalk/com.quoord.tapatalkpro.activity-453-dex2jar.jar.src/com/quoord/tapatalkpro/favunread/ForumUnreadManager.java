package com.quoord.tapatalkpro.favunread;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.LoginStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ForumUnreadManager {
    private CallBack callBack;
    private ArrayList<UnreadStatus> callData;
    Comparator<UnreadStatus> comparator;
    private ExecutorService fixedThreadPool;
    private ExecutorService fixedThreadPool_Specific;
    private boolean hasCall = false;
    private final int infoTag = 1;
    private int loginPoolSizeLimit = 3;
    private Handler mhandler;
    private final int specificTag = 2;
    private int totalLoginCount = 0;

    public ForumUnreadManager() {
        initNeed();
    }

    public ForumUnreadManager(ArrayList<UnreadStatus> paramArrayList) {
        this.callData = paramArrayList;
        initNeed();
    }

    private void LoginCountMinus() {
        this.totalLoginCount -= 1;
    }

    private void LoginCountPlus() {
        this.totalLoginCount += 1;
    }

    private void callForForumSpecificInfo(UnreadStatus paramUnreadStatus, Context paramContext, String paramString) {
        if ((!paramUnreadStatus.isHasSubOrPm()) && (paramUnreadStatus.isShouldhasSubOrPm())) {
            executeThread(2, paramUnreadStatus.getCall().getSpecificInfoCallThread());
        }
    }

    private boolean checkCallBack() {
        return this.callBack != null;
    }

    private void createThreadPool() {
        if ((this.fixedThreadPool == null) || (this.fixedThreadPool.isShutdown())) {
            this.fixedThreadPool = Executors.newFixedThreadPool(this.loginPoolSizeLimit);
        }
        if ((this.fixedThreadPool_Specific == null) || (this.fixedThreadPool_Specific.isShutdown())) {
            this.fixedThreadPool_Specific = Executors.newSingleThreadExecutor();
        }
    }

    private void executeThread(int paramInt, Runnable paramRunnable) {
        createThreadPool();
        if (paramInt == 1) {
            this.fixedThreadPool.execute(paramRunnable);
        }
        while (paramInt != 2) {
            return;
        }
        this.fixedThreadPool_Specific.execute(paramRunnable);
    }

    private UnreadStatus getUnreadStatus(String paramString) {
        int i = 0;
        for (; ; ) {
            if (i >= this.callData.size()) {
                return null;
            }
            if (((UnreadStatus) this.callData.get(i)).getLoginStatus().getPrimaryKey().equals(paramString)) {
                return (UnreadStatus) this.callData.get(i);
            }
            i += 1;
        }
    }

    private void initNeed() {
        createThreadPool();
        this.mhandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message paramAnonymousMessage) {
                int i = paramAnonymousMessage.what;
                paramAnonymousMessage = (UnreadStatus) paramAnonymousMessage.obj;
                switch (i) {
                }
                label113:
                do {
                    return;
                    if (paramAnonymousMessage.isShouldhasSubOrPm()) {
                        if (!ForumUnreadManager.this.callData.isEmpty()) {
                            break label113;
                        }
                        ForumUnreadManager.this.callData.add(paramAnonymousMessage);
                    }
                    for (; ; ) {
                        ForumUnreadManager.this.LoginCountMinus();
                        if (!ForumUnreadManager.this.checkCallBack()) {
                            break;
                        }
                        ForumUnreadManager.this.callBack.handleShouldHasBack(ForumUnreadManager.this.callData, ForumUnreadManager.this.isLoginCallOver());
                        return;
                        if (ForumUnreadManager.this.getUnreadStatus(paramAnonymousMessage.getLoginStatus().getPrimaryKey()) == null) {
                            ForumUnreadManager.this.callData.add(paramAnonymousMessage);
                            ForumUnreadManager.this.sort();
                        }
                    }
                    ForumUnreadManager.this.callBack.handleShouldHasBack(null, true);
                    return;
                } while (!ForumUnreadManager.this.checkCallBack());
                ForumUnreadManager.this.callBack.handleSpecificBack(paramAnonymousMessage);
            }
        };
    }

    private boolean isLoginCallOver() {
        return this.totalLoginCount <= 0;
    }

    private void setUnreadCallLis(ForumUnreadStatusCall paramForumUnreadStatusCall) {
        paramForumUnreadStatusCall.setOverListener(new ForumUnreadStatusCall.OnForumUnreadStatusCallOverListener() {
            public void isGetInfoOver(UnreadStatus paramAnonymousUnreadStatus) {
                if (paramAnonymousUnreadStatus != null) {
                    Message localMessage = ForumUnreadManager.this.mhandler.obtainMessage(1);
                    localMessage.obj = paramAnonymousUnreadStatus;
                    ForumUnreadManager.this.mhandler.sendMessage(localMessage);
                }
            }

            public void isGetSpecificOver(UnreadStatus paramAnonymousUnreadStatus) {
                if (paramAnonymousUnreadStatus != null) {
                    Message localMessage = ForumUnreadManager.this.mhandler.obtainMessage(2);
                    localMessage.obj = paramAnonymousUnreadStatus;
                    ForumUnreadManager.this.mhandler.sendMessage(localMessage);
                }
            }

            public void isUnloginInvoke(UnreadStatus paramAnonymousUnreadStatus) {
                if ((paramAnonymousUnreadStatus != null) && (!paramAnonymousUnreadStatus.isLoginOver())) {
                    paramAnonymousUnreadStatus = paramAnonymousUnreadStatus.getCall();
                    ForumUnreadManager.this.executeThread(1, paramAnonymousUnreadStatus.getmThread());
                }
            }
        });
    }

    private void shutdownLoginThreadPool() {
        if (this.fixedThreadPool != null) {
            this.fixedThreadPool.shutdown();
        }
    }

    private void shutdownSpecificThreadPool() {
        if (this.fixedThreadPool_Specific != null) {
            this.fixedThreadPool_Specific.shutdown();
        }
    }

    private void sort() {
        if (this.callData != null) {
            if (this.comparator == null) {
                this.comparator = new Comparator() {
                    public int compare(UnreadStatus paramAnonymousUnreadStatus1, UnreadStatus paramAnonymousUnreadStatus2) {
                        return paramAnonymousUnreadStatus1.getListIndex() - paramAnonymousUnreadStatus2.getListIndex();
                    }
                };
            }
            Collections.sort(this.callData, this.comparator);
        }
    }

    public void callForForumSpecificInfo(UnreadStatus paramUnreadStatus, Context paramContext) {
        callForForumSpecificInfo(paramUnreadStatus, paramContext, null);
    }

    public void callForForumSpecificInfos(Context paramContext) {
        int j;
        int i;
        if (this.callData != null) {
            j = this.callData.size();
            i = 0;
        }
        for (; ; ) {
            if (i >= j) {
                shutdownSpecificThreadPool();
                return;
            }
            callForForumSpecificInfo((UnreadStatus) this.callData.get(i), paramContext, null);
            i += 1;
        }
    }

    public void callForForumsUnread(ArrayList<TapatalkForum> paramArrayList, Context paramContext) {
        int j = paramArrayList.size();
        if (this.callData == null) {
            this.callData = new ArrayList();
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        if (i >= j) {
            if (localArrayList.size() < this.callData.size()) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= this.callData.size()) {
                if ((!this.hasCall) && (checkCallBack())) {
                    sort();
                    this.callBack.dataNotify();
                }
                this.hasCall = false;
                shutdownLoginThreadPool();
                return;
                Object localObject = (TapatalkForum) paramArrayList.get(i);
                UnreadStatus localUnreadStatus = getUnreadStatus(((TapatalkForum) localObject).getPrimaryKey());
                if (localUnreadStatus != null) {
                    localArrayList.add(localUnreadStatus.getForumPri());
                    if (!Util.isLoggedForum(paramContext, ((TapatalkForum) localObject).getId(), ((TapatalkForum) localObject).getLowerUserName(), ((TapatalkForum) localObject).getPassword())) {
                        this.callData.remove(localUnreadStatus);
                    }
                }
                for (; ; ) {
                    i += 1;
                    break;
                    localUnreadStatus.setListIndex(i);
                    if (!localUnreadStatus.isLoginOver()) {
                        if (!localUnreadStatus.getCall().isHasListener()) {
                            setUnreadCallLis(localUnreadStatus.getCall());
                        }
                        executeThread(1, localUnreadStatus.getCall().getmThread());
                        this.hasCall = true;
                        continue;
                        if (Util.isLoggedForum(paramContext, ((TapatalkForum) localObject).getId(), ((TapatalkForum) localObject).getLowerUserName(), ((TapatalkForum) localObject).getPassword())) {
                            LoginCountPlus();
                            localObject = new ForumUnreadStatusCall((TapatalkForum) paramArrayList.get(i), paramContext, i);
                            localArrayList.add(((ForumUnreadStatusCall) localObject).getmUnread().getForumPri());
                            setUnreadCallLis((ForumUnreadStatusCall) localObject);
                            executeThread(1, ((ForumUnreadStatusCall) localObject).getmThread());
                            this.hasCall = true;
                        }
                    }
                }
            }
            if (!localArrayList.contains(((UnreadStatus) this.callData.get(i)).getForumPri())) {
                this.callData.remove(i);
            }
            i += 1;
        }
    }

    public void clearData() {
        if (this.callData != null) {
            this.callData.clear();
        }
        this.totalLoginCount = 0;
    }

    public ArrayList<UnreadStatus> getCallData() {
        return this.callData;
    }

    public void setCallBack(CallBack paramCallBack) {
        this.callBack = paramCallBack;
    }

    public void shutdownThreadPools() {
        shutdownLoginThreadPool();
        shutdownSpecificThreadPool();
    }

    public static abstract interface CallBack {
        public abstract void dataNotify();

        public abstract void deleteData(UnreadStatus paramUnreadStatus);

        public abstract void handleShouldHasBack(ArrayList<UnreadStatus> paramArrayList, boolean paramBoolean);

        public abstract void handleSpecificBack(UnreadStatus paramUnreadStatus);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/favunread/ForumUnreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */