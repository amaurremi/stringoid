package com.quoord.tapatalkpro.tabwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionCallBack;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.tabwidget.manager.PMWidgetManager;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.xmlrpc.XmlRpcParser;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PMWidget
        implements RemoteViewsService.RemoteViewsFactory {
    private static Context mContext = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat(XmlRpcParser.DATETIME_FORMAT);
    public List<Object> mList = new ArrayList();
    private final int mWidgetId;
    private final AppWidgetManager mWidgetManager;
    private GetPMTask myTimeTask;
    private TapatalkForum tapatalkForum;
    private Timer timer;

    public PMWidget(Context paramContext, int paramInt1, int paramInt2) {
        mContext = paramContext;
        this.mWidgetManager = AppWidgetManager.getInstance(mContext);
        this.mWidgetId = paramInt1;
        this.tapatalkForum = getTapatalkForum(paramInt2);
        if (this.tapatalkForum != null) {
            updateWidgetView(0, paramInt2, this.tapatalkForum.getName());
        }
    }

    private TapatalkForum getTapatalkForum(String paramString) {
        Object localObject1 = null;
        Object localObject2 = new FavoriateSqlHelper(mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        if (!mContext.getResources().getBoolean(2131558401)) {
            localObject1 = ((FavoriateSqlHelper) localObject2).getFavrivateById(paramString);
            return (TapatalkForum) localObject1;
        }
        localObject2 = ((FavoriateSqlHelper) localObject2).getFavrivate();
        int i = 0;
        for (paramString = (String) localObject1; ; paramString = (String) localObject1) {
            localObject1 = paramString;
            if (i >= ((ArrayList) localObject2).size()) {
                break;
            }
            localObject1 = paramString;
            if (((TapatalkForum) ((ArrayList) localObject2).get(i)).getUserName() != null) {
                localObject1 = paramString;
                if (((TapatalkForum) ((ArrayList) localObject2).get(i)).getUserName().length() > 0) {
                    localObject1 = paramString;
                    if (((TapatalkForum) ((ArrayList) localObject2).get(i)).hasPassword()) {
                        localObject1 = (TapatalkForum) ((ArrayList) localObject2).get(i);
                    }
                }
            }
            i += 1;
        }
    }

    public int getCount() {
        return this.mList.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public RemoteViews getLoadingView() {
        return new RemoteViews(mContext.getPackageName(), 2130903080);
    }

    public RemoteViews getNoLoginView() {
        RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130903295);
        localRemoteViews.setTextViewText(2131230763, "No Login");
        Intent localIntent = new Intent(mContext, WidgetClickHandlerService.class).setFlags(67108864);
        localIntent.setAction("android.appwidget.action.CLICK_LOGIN");
        localRemoteViews.setOnClickFillInIntent(2131230762, localIntent);
        return localRemoteViews;
    }

    public RemoteViews getNoneView() {
        RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130903295);
        localRemoteViews.setTextViewText(2131230763, "No Messages");
        return localRemoteViews;
    }

    public RemoteViews getViewAt(int paramInt) {
        try {
            if (((this.mList.get(paramInt) instanceof PrivateMessage)) || ((this.mList.get(paramInt) instanceof HashMap))) {
                localObject1 = new RemoteViews(mContext.getPackageName(), 2130903443);
                Intent localIntent = new Intent(mContext, WidgetClickHandlerService.class).setFlags(67108864);
                Object localObject2;
                Object localObject3;
                if ((this.mList.get(paramInt) instanceof PrivateMessage)) {
                    localObject2 = (PrivateMessage) this.mList.get(paramInt);
                    ((RemoteViews) localObject1).setTextViewText(2131230769, ((PrivateMessage) localObject2).getMsgSubject());
                    if ((((PrivateMessage) localObject2).getMsgSubject() != null) && (((PrivateMessage) localObject2).getMsgSubject().length() > 0) && (((PrivateMessage) localObject2).getMsgState() == 2)) {
                        paramInt = ((PrivateMessage) localObject2).getMsgSubject().length();
                        localObject3 = new SpannableString(((PrivateMessage) localObject2).getMsgSubject());
                        ((SpannableString) localObject3).setSpan(new ForegroundColorSpan(mContext.getResources().getColor(2131165283)), 0, paramInt, 0);
                        ((RemoteViews) localObject1).setTextViewText(2131230769, (CharSequence) localObject3);
                    }
                    ((RemoteViews) localObject1).setTextViewText(2131230778, ((PrivateMessage) localObject2).getShortContent());
                    ((RemoteViews) localObject1).setTextViewText(2131231190, ((PrivateMessage) localObject2).getMsgFrom());
                    ((RemoteViews) localObject1).setTextViewText(2131231748, Util.formatDateInThread(((PrivateMessage) localObject2).getSentDate(), mContext));
                    localIntent.setAction("android.appwidget.action.PM_CLICK");
                    localObject3 = new Bundle();
                    ((Bundle) localObject3).putSerializable("serial", (Serializable) localObject2);
                    localIntent.putExtras((Bundle) localObject3);
                }
                for (; ; ) {
                    localIntent.putExtra("forumId", PMWidgetManager.loadForumIdPref(mContext, this.mWidgetId));
                    localIntent.putExtra("widgetId", this.mWidgetId);
                    ((RemoteViews) localObject1).setOnClickFillInIntent(2131231745, localIntent);
                    return (RemoteViews) localObject1;
                    localObject2 = (HashMap) this.mList.get(paramInt);
                    localObject3 = ((HashMap) localObject2).get("last_user_id").toString();
                    localObject3 = (HashMap) ((HashMap) ((HashMap) localObject2).get("participants")).get(localObject3);
                    ((RemoteViews) localObject1).setTextViewText(2131230769, new String((byte[]) ((HashMap) localObject2).get("conv_subject")));
                    ((RemoteViews) localObject1).setViewVisibility(2131230778, 8);
                    ((RemoteViews) localObject1).setTextViewText(2131231190, new String((byte[]) ((HashMap) localObject3).get("username")));
                    localIntent.setAction("android.appwidget.action.CONVER_CLICK");
                    localIntent.putExtra("convId", ((HashMap) localObject2).get("conv_id").toString());
                }
            }
            Object localObject1 = (String) this.mList.get(paramInt);
            if (((String) localObject1).equals("load")) {
                return getLoadingView();
            }
            if (((String) localObject1).equals("nologin")) {
                return getNoLoginView();
            }
            localObject1 = getNoneView();
            return (RemoteViews) localObject1;
        } catch (Exception localException) {
        }
        return null;
    }

    public int getViewTypeCount() {
        return 4;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void onCreate() {
        this.mList.add("load");
    }

    public void onDataSetChanged() {
    }

    public void onDeleted() {
        stopTimer();
    }

    public void onDestroy() {
        this.mList.clear();
    }

    public void reset() {
        start();
    }

    public void start() {
        this.timer = new Timer();
        if (this.tapatalkForum != null) {
            this.myTimeTask = new GetPMTask(mContext, this.mWidgetId, this.tapatalkForum);
            this.timer.scheduleAtFixedRate(this.myTimeTask, 1000L, 1800000L);
        }
    }

    public void stopTimer() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer.purge();
        }
        if (this.myTimeTask != null) {
            this.myTimeTask.cancel();
        }
    }

    public void updateWidgetView(int paramInt1, int paramInt2, String paramString) {
        Intent localIntent = new Intent(mContext, PMWidgetProvider.PMConverListViewService.class);
        localIntent.putExtra("appWidgetId", this.mWidgetId);
        localIntent.setData(Uri.parse(localIntent.toUri(1)));
        RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130903442);
        localRemoteViews.setTextViewText(2131231750, paramInt1);
        localRemoteViews.setTextViewText(2131231178, paramString);
        localRemoteViews.setRemoteAdapter(this.mWidgetId, 2131230759, localIntent);
        this.mWidgetManager.notifyAppWidgetViewDataChanged(this.mWidgetId, 2131230759);
        paramString = new Intent(mContext, WidgetClickHandlerService.class);
        localRemoteViews.setPendingIntentTemplate(2131230759, PendingIntent.getService(mContext, 0, paramString, 134217728));
        paramString = new Intent(mContext, WidgetClickHandlerService.class);
        paramString.setAction("android.appwidget.action.CLICK_NEWPM");
        paramString.putExtra("forumId", paramInt2);
        localRemoteViews.setOnClickPendingIntent(2131231749, PendingIntent.getService(mContext, paramInt2, paramString, 134217728));
        this.mWidgetManager.updateAppWidget(this.mWidgetId, localRemoteViews);
    }

    public class GetPMTask
            extends TimerTask
            implements TryTwiceCallBackInterface {
        private String box_id;
        Context context;
        TapatalkEngine engine;
        TapatalkForum forum;
        int forumId;
        ForumLoginOrSignAction loginOrSign;
        RemoteViews remoteViews;
        ForumStatus status;
        int widgetId;

        public GetPMTask(Context paramContext, int paramInt, TapatalkForum paramTapatalkForum) {
            this.context = paramContext;
            this.widgetId = paramInt;
            this.forumId = PMWidgetManager.loadForumIdPref(paramContext, paramInt);
            this.forum = paramTapatalkForum;
            this.status = ForumStatus.initialForumStatus(paramContext, this.forum, null, null);
            this.loginOrSign = new ForumLoginOrSignAction(paramContext, this.status);
        }

        private void getConversations() {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(new Integer(0));
            localArrayList.add(new Integer(19));
            this.engine.call("get_conversations", localArrayList);
        }

        private void get_box(String paramString) {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramString);
            localArrayList.add(new Integer(0));
            localArrayList.add(new Integer(19));
            this.engine.call("get_box", localArrayList);
        }

        private void get_box_info() {
            ArrayList localArrayList = new ArrayList();
            this.engine.call("get_box_info", localArrayList);
        }

        public void callBack(EngineResponse paramEngineResponse) {
            Object localObject = paramEngineResponse.getMethod();
            int i;
            if (((String) localObject).equals("get_box_info")) {
                try {
                    paramEngineResponse = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("list");
                    i = 0;
                    for (; ; ) {
                        if (i >= paramEngineResponse.length) {
                            return;
                        }
                        localObject = (HashMap) paramEngineResponse[i];
                        if (((String) ((HashMap) localObject).get("box_type")).equals("INBOX")) {
                            get_box((String) ((HashMap) localObject).get("box_id"));
                        }
                        i += 1;
                    }
                    if (!((String) localObject).equals("get_box")) {
                        break label243;
                    }
                } catch (Exception paramEngineResponse) {
                    paramEngineResponse.printStackTrace();
                    return;
                }
            }
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            int j = ((Integer) paramEngineResponse.get("total_unread_count")).intValue();
            paramEngineResponse = (Object[]) paramEngineResponse.get("list");
            if (paramEngineResponse != null) {
                PMWidget.this.mList.clear();
                localObject = new Object[paramEngineResponse.length];
                i = 0;
                for (; ; ) {
                    if (i >= paramEngineResponse.length) {
                        PMWidget.this.updateWidgetView(j, PMWidget.this.tapatalkForum.getId().intValue(), PMWidget.this.tapatalkForum.getName());
                        return;
                    }
                    localObject[i] = PrivateMessage.createPMBean((HashMap) paramEngineResponse[i], this.context, "0", true, null);
                    PMWidget.this.mList.add(localObject[i]);
                    i += 1;
                }
                label243:
                if (((String) localObject).equals("get_conversations")) {
                    paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                    j = ((Integer) paramEngineResponse.get("unread_count")).intValue();
                    paramEngineResponse = (Object[]) paramEngineResponse.get("list");
                    if (paramEngineResponse != null) {
                        PMWidget.this.mList.clear();
                        i = 0;
                        for (; ; ) {
                            if (i >= paramEngineResponse.length) {
                                PMWidget.this.updateWidgetView(j, PMWidget.this.tapatalkForum.getId().intValue(), PMWidget.this.tapatalkForum.getName());
                                return;
                            }
                            PMWidget.this.mList.add((HashMap) paramEngineResponse[i]);
                            i += 1;
                        }
                    }
                }
            }
        }

        public boolean getSaxCall() {
            return false;
        }

        public boolean getTryTwice() {
            return false;
        }

        public boolean isOpCancel() {
            return false;
        }

        public void run() {
            try {
                if (Util.isLoginedUser(this.context, this.forum)) {
                    if (!Util.isConn(PMWidget.mContext)) {
                        return;
                    }
                    this.engine = new TapatalkEngine(this, this.status, PMWidget.mContext);
                    if (Util.isSignedUser(this.context, this.forum)) {
                        this.loginOrSign.signForum(this.forum.getUserNameOrDisplayName(), null, false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                            public void actionErrorBack(String paramAnonymousString1, String paramAnonymousString2) {
                            }

                            public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                                if (PMWidget.GetPMTask.this.forum.isPMEnable()) {
                                    if (PMWidget.GetPMTask.this.forum.isSupportConve()) {
                                        PMWidget.GetPMTask.this.getConversations();
                                    }
                                } else {
                                    return;
                                }
                                if (PMWidget.GetPMTask.this.box_id != null) {
                                    PMWidget.GetPMTask.this.get_box(PMWidget.GetPMTask.this.box_id);
                                    return;
                                }
                                PMWidget.GetPMTask.this.get_box_info();
                            }
                        });
                        return;
                    }
                    if ((this.forum.isPMEnable()) && (!this.forum.isSupportConve())) {
                        this.box_id = this.status.tapatalkForum.getInboxId();
                    }
                    this.loginOrSign.loginForum(this.forum.getUserNameOrDisplayName(), this.forum.getPassword(), false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                        public void actionErrorBack(String paramAnonymousString1, String paramAnonymousString2) {
                        }

                        public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                            if (PMWidget.GetPMTask.this.forum.isPMEnable()) {
                                if (PMWidget.GetPMTask.this.forum.isSupportConve()) {
                                    PMWidget.GetPMTask.this.getConversations();
                                }
                            } else {
                                return;
                            }
                            if (PMWidget.GetPMTask.this.box_id != null) {
                                PMWidget.GetPMTask.this.get_box(PMWidget.GetPMTask.this.box_id);
                                return;
                            }
                            PMWidget.GetPMTask.this.get_box_info();
                        }
                    });
                    return;
                }
            } catch (Exception localException) {
                localException.printStackTrace();
                return;
            }
            PMWidget.this.mList.clear();
            PMWidget.this.mList.add("nologin");
            PMWidget.this.mWidgetManager.notifyAppWidgetViewDataChanged(this.widgetId, 2131230759);
        }

        public void setOpCancel(boolean paramBoolean) {
        }

        public void setSaxCall(boolean paramBoolean) {
        }

        public void setTryTwice(boolean paramBoolean) {
        }

        public void tryFailed(String paramString) {
        }

        public void updateSubclassDialog(int paramInt) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/PMWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */