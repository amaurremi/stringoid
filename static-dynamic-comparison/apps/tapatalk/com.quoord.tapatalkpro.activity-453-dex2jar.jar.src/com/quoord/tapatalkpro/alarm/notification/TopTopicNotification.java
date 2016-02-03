package com.quoord.tapatalkpro.alarm.notification;

import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;
import com.quoord.tools.TapatalkLog;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;

public class TopTopicNotification {
    public static String VIEW_TOP_TOPIC_ACTION = "view_toptopic";
    public static int notificationId = 10001;
    private String bigImageUrl;
    private String fid;
    private TapatalkForum forum;
    private Bitmap iconBmp;
    private PendingIntent pendingIntent;
    private String tid;
    private String title;

    public Bitmap getHttpBitmap(String paramString) {
        localObject3 = null;
        localObject4 = null;
        try {
            localObject1 = new URL(paramString);
            localObject3 = localObject1;
        } catch (Exception localException) {
            try {
                if (!paramString.startsWith("https")) {
                    break label121;
                }
                Object localObject1 = localObject4;
                Util.trustAllHosts();
                localObject1 = localObject4;
                paramString = (HttpsURLConnection) ((URL) localObject3).openConnection();
                localObject1 = localObject4;
                paramString.setHostnameVerifier(Util.DO_NOT_VERIFY);
                Object localObject2;
                for (; ; ) {
                    localObject1 = localObject4;
                    paramString.setConnectTimeout(7000);
                    localObject1 = localObject4;
                    paramString.setReadTimeout(90000);
                    localObject1 = localObject4;
                    paramString.setDoInput(true);
                    localObject1 = localObject4;
                    paramString.connect();
                    localObject1 = localObject4;
                    localObject3 = paramString.getInputStream();
                    localObject1 = localObject4;
                    paramString = BitmapFactory.decodeStream((InputStream) localObject3);
                    localObject1 = paramString;
                    ((InputStream) localObject3).close();
                    return paramString;
                    localException = localException;
                    localException.printStackTrace();
                    break;
                    localObject2 = localObject4;
                    paramString = (HttpURLConnection) ((URL) localObject3).openConnection();
                }
                return (Bitmap) localObject2;
            } catch (Exception paramString) {
                paramString.printStackTrace();
            }
        }
        localObject1 = localObject4;
    }

    public Bitmap getIconBitmap(Context paramContext, TapatalkForum paramTapatalkForum) {
        Resources localResources = paramContext.getResources();
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramTapatalkForum != null) {
            localObject1 = localObject2;
            if (paramTapatalkForum.getIconUrl() != null) {
                localObject1 = localObject2;
                if (!paramTapatalkForum.getIconUrl().equals("")) {
                    paramContext = Util.getFoursquareForumIcon(AvatarTool.getLocalUrl(paramContext, 5, paramTapatalkForum.getIconUrl()), (int) localResources.getDimension(17104901));
                    localObject1 = paramContext;
                    if (paramContext == null) {
                        localObject1 = getHttpBitmap(paramTapatalkForum.getIconUrl());
                    }
                }
            }
        }
        paramContext = (Context) localObject1;
        if (localObject1 != null) {
            paramContext = Util.getFoursquareForumIcon((Bitmap) localObject1, (int) localResources.getDimension(17104901));
        }
        paramTapatalkForum = paramContext;
        if (paramContext == null) {
            paramTapatalkForum = BitmapFactory.decodeResource(localResources, 2130839351);
        }
        return paramTapatalkForum;
    }

    public void getIconThenGenerateNotification(final Context paramContext) {
        if (this.forum != null) {
            new Thread() {
                public void handleMessage(Message paramAnonymousMessage) {
                    super.handleMessage(paramAnonymousMessage);
                    if (paramAnonymousMessage.obj != null) {
                    }
                    for (TopTopicNotification.this.iconBmp = ((Bitmap) paramAnonymousMessage.obj); ; TopTopicNotification.this.iconBmp = BitmapFactory.decodeResource(paramAnonymousMessage, 2130837524)) {
                        TopTopicNotification.this.getNotification(paramContext);
                        return;
                        paramAnonymousMessage = paramContext.getResources();
                    }
                }
            }
            {
                public void run ()
                {
                    super.run();
                    Bitmap localBitmap = TopTopicNotification.this.getIconBitmap(paramContext, TopTopicNotification.this.forum);
                    Message localMessage = this.val$outhandler.obtainMessage();
                    localMessage.what = 1;
                    localMessage.obj = localBitmap;
                    this.val$outhandler.dispatchMessage(localMessage);
                }
            }.start();
        }
    }

    public PendingIntent getManagerPendingIntent(Context paramContext) {
        Intent localIntent = new Intent(paramContext, SettingsActivity.class);
        localIntent.putExtra(VIEW_TOP_TOPIC_ACTION, true);
        localIntent.setAction(VIEW_TOP_TOPIC_ACTION + new StringBuilder(String.valueOf(System.currentTimeMillis())).toString().hashCode());
        localIntent.setFlags(32768);
        return PendingIntent.getActivity(paramContext, (VIEW_TOP_TOPIC_ACTION + System.currentTimeMillis()).hashCode(), localIntent, 0);
    }

    public void getNotification(final Context paramContext) {
        try {
            this.pendingIntent = getPendingIntent(paramContext, this.forum, this.tid);
            if (Build.VERSION.SDK_INT > 15) {
                if ((this.bigImageUrl != null) && (!this.bigImageUrl.equals(""))) {
                    new Thread() {
                        public void handleMessage(Message paramAnonymousMessage) {
                            super.handleMessage(paramAnonymousMessage);
                            if (paramAnonymousMessage.obj != null) {
                                paramAnonymousMessage = ImageTools.adjustOpacity((Bitmap) paramAnonymousMessage.obj, 153);
                                TopTopicNotification.this.getTopicWithImageNotification(paramContext, TopTopicNotification.this.forum, paramAnonymousMessage);
                                return;
                            }
                            TopTopicNotification.this.getTopicTextNotification(paramContext, TopTopicNotification.this.forum, false);
                        }
                    }
                    {
                        public void run ()
                        {
                            super.run();
                            Bitmap localBitmap = TopTopicNotification.this.getHttpBitmap(TopTopicNotification.this.bigImageUrl);
                            Message localMessage = this.val$handler.obtainMessage();
                            localMessage.what = 1;
                            localMessage.obj = localBitmap;
                            this.val$handler.dispatchMessage(localMessage);
                        }
                    }.start();
                    return;
                }
                getTopicTextNotification(paramContext, this.forum, false);
                return;
            }
            getTopicTextNotification(paramContext, this.forum, true);
            return;
        } catch (Exception paramContext) {
        }
    }

    public PendingIntent getPendingIntent(Context paramContext, TapatalkForum paramTapatalkForum, String paramString) {
        Intent localIntent = new Intent(paramContext, ThreadActivity.class);
        localIntent.putExtra("topic_id", paramString);
        localIntent.putExtra("forum", paramTapatalkForum);
        localIntent.putExtra("fromFeed", true);
        localIntent.putExtra("goto_first_post", true);
        localIntent.putExtra(VIEW_TOP_TOPIC_ACTION, true);
        localIntent.setAction(VIEW_TOP_TOPIC_ACTION + new StringBuilder(String.valueOf(paramString)).append(System.currentTimeMillis()).toString().hashCode());
        localIntent.setFlags(32768);
        return PendingIntent.getActivity(paramContext, (VIEW_TOP_TOPIC_ACTION + paramString + System.currentTimeMillis()).hashCode(), localIntent, 0);
    }

    public void getTopicTextNotification(Context paramContext, TapatalkForum paramTapatalkForum, boolean paramBoolean) {
        try {
            paramTapatalkForum = new Notification.Builder(paramContext).setContentTitle(paramTapatalkForum.getName()).setTicker(paramTapatalkForum.getName()).setContentText(this.title).setAutoCancel(true).setSmallIcon(2130839351).setLargeIcon(this.iconBmp);
            if (!paramBoolean) {
                paramTapatalkForum.setStyle(new Notification.BigTextStyle().bigText(this.title));
            }
            if (this.pendingIntent != null) {
                paramTapatalkForum.setContentIntent(this.pendingIntent);
            }
            if (Build.VERSION.SDK_INT > 15) {
            }
            for (paramTapatalkForum = paramTapatalkForum.build(); ; paramTapatalkForum = paramTapatalkForum.getNotification()) {
                NotificationManager localNotificationManager = (NotificationManager) paramContext.getSystemService("notification");
                paramContext = Prefs.get(paramContext);
                if ((!paramContext.getBoolean("notification_recommend_topic", true)) || (!paramContext.getBoolean("notification_flag", true))) {
                    break;
                }
                localNotificationManager.notify(notificationId, paramTapatalkForum);
                return;
            }
            return;
        } catch (Exception paramContext) {
        }
    }

    public void getTopicWithImageNotification(Context paramContext, TapatalkForum paramTapatalkForum, Bitmap paramBitmap) {
        try {
            paramTapatalkForum = new Notification.BigPictureStyle();
            paramTapatalkForum.setBigContentTitle(this.title);
            ImageTools.adjustOpacity(BitmapFactory.decodeResource(paramContext.getResources(), 2130839351), 153);
            paramTapatalkForum.bigPicture(paramBitmap);
            paramTapatalkForum = new Notification.Builder(paramContext).setSmallIcon(2130839351).setContentTitle(this.title).setContentText(paramContext.getResources().getString(2131100810)).setLargeIcon(this.iconBmp).setAutoCancel(true).setStyle(paramTapatalkForum).addAction(2130839247, paramContext.getResources().getString(2131100900), getManagerPendingIntent(paramContext));
            if (this.pendingIntent != null) {
                paramTapatalkForum.setContentIntent(this.pendingIntent);
            }
            paramBitmap = (NotificationManager) paramContext.getSystemService("notification");
            paramContext = Prefs.get(paramContext);
            if ((paramContext.getBoolean("notification_recommend_topic", true)) && (paramContext.getBoolean("notification_flag", true))) {
                paramBitmap.notify(notificationId, paramTapatalkForum.build());
            }
            return;
        } catch (Exception paramContext) {
        }
    }

    public void notifyTopTopicNotificationUseRemoteView(final Context paramContext, Intent paramIntent) {
        this.fid = paramIntent.getStringExtra("fid");
        TapatalkLog.d("push", "fid " + this.fid);
        this.tid = paramIntent.getStringExtra("tid");
        TapatalkLog.d("push", "tid " + this.tid);
        this.bigImageUrl = paramIntent.getStringExtra("topic_image");
        this.title = paramIntent.getStringExtra("title");
        paramIntent = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        this.forum = paramIntent.getFavrivateById(this.fid);
        ArrayList localArrayList;
        int i;
        if (this.forum == null) {
            localArrayList = TapatalkAccountAction.getCurrnentAllAccount(paramContext);
            i = 0;
        }
        for (; ; ) {
            if (i >= localArrayList.size()) {
                if (this.forum != null) {
                    break;
                }
                paramIntent = DirectoryUrlUtil.createGetForumById(paramContext, this.fid);
                new TapatalkAjaxAction(paramContext).getJsonArrayAction(paramIntent, new TapatalkAjaxAction.ActionCallBack() {
                    public void actionCallBack(Object paramAnonymousObject) {
                        JSONArray localJSONArray = (JSONArray) paramAnonymousObject;
                        ArrayList localArrayList = new ArrayList();
                        if (localJSONArray != null) {
                            TapatalkLog.v("tapatalkLog", "search forum by id back " + paramAnonymousObject.toString());
                        }
                        try {
                            int j = localJSONArray.length();
                            int i;
                            if (j > 0) {
                                i = 0;
                            }
                            for (; ; ) {
                                if (i >= j) {
                                    if (localArrayList.size() > 0) {
                                        TopTopicNotification.this.forum = ((TapatalkForum) localArrayList.get(0));
                                        TopTopicNotification.this.getIconThenGenerateNotification(paramContext);
                                    }
                                    return;
                                }
                                localArrayList.add(TapatalkForum.getForum(localJSONArray.getJSONObject(i), null, null, null));
                                i += 1;
                            }
                            return;
                        } catch (Exception paramAnonymousObject) {
                        }
                    }
                });
                return;
            }
            if (((TapatalkForum) localArrayList.get(i)).getId().toString().equals(this.fid)) {
                this.forum = ((TapatalkForum) localArrayList.get(i));
                paramIntent.saveFavoriate(this.forum);
            }
            i += 1;
        }
        getIconThenGenerateNotification(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/TopTopicNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */