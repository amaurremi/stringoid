package com.quoord.tapatalkpro.activity;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gcm.GCMBaseIntentService;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.alarm.NotificationAdapter;
import com.quoord.tapatalkpro.alarm.notification.AddForumNotification;
import com.quoord.tapatalkpro.alarm.notification.ConvNotification;
import com.quoord.tapatalkpro.alarm.notification.LikeNotification;
import com.quoord.tapatalkpro.alarm.notification.NewTopicNotification;
import com.quoord.tapatalkpro.alarm.notification.PmNotification;
import com.quoord.tapatalkpro.alarm.notification.QuoteNotification;
import com.quoord.tapatalkpro.alarm.notification.RecommendForumNotification;
import com.quoord.tapatalkpro.alarm.notification.RecommendTopicNotification;
import com.quoord.tapatalkpro.alarm.notification.SubscribeNotification;
import com.quoord.tapatalkpro.alarm.notification.TagNotification;
import com.quoord.tapatalkpro.alarm.notification.ThankNotification;
import com.quoord.tapatalkpro.alarm.notification.TopTopicNotification;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

public class GCMIntentService
        extends GCMBaseIntentService {
    public static final String TAG_CONVERSATION = "conversation";
    public static final String TAG_LIKE = "like";
    public static final String TAG_NEW = "newtopic";
    public static final String TAG_NOTIFICATIOM = "notification";
    public static final String TAG_PM = "pm";
    public static final String TAG_QUOTE = "quote";
    public static final String TAG_SUBSCRIBE = "sub";
    public static final String TAG_TAG = "tag";
    public static final String TAG_THANK = "thank";
    public static final String TAG_TOPIC = "topic";

    public GCMIntentService() {
        super("608452217441");
    }

    private static void generateNotification(Context paramContext, Intent paramIntent) {
        SharedPreferences localSharedPreferences;
        if (Prefs.get(paramContext).getBoolean("notification_flag", true)) {
            localSharedPreferences = paramContext.getSharedPreferences("notification", 0);
            if (!NotificationAdapter.isSlientPreroid(paramContext)) {
                break label31;
            }
        }
        label31:
        String str;
        do {
            return;
            str = paramIntent.getExtras().getString("type");
            if ("pm".equals(str)) {
                PmNotification.notifyPmNotification(paramContext, paramIntent, localSharedPreferences);
                return;
            }
            if ("conv".equals(str)) {
                ConvNotification.notifyConversationNotification(paramContext, paramIntent, localSharedPreferences);
                return;
            }
            if ("sub".equals(str)) {
                SubscribeNotification.notifySubscribeTopicNotifycation(paramContext, paramIntent, localSharedPreferences);
                return;
            }
            if ("like".equals(str)) {
                notifyLikenotification(paramContext, paramIntent, localSharedPreferences);
                return;
            }
            if ("thank".equals(str)) {
                notifyThanknotification(paramContext, paramIntent, localSharedPreferences);
                return;
            }
            if ("quote".equals(str)) {
                notifyQuoteNotifycation(paramContext, paramIntent, localSharedPreferences);
                return;
            }
            if ("tag".equals(str)) {
                notifyTagNotification(paramContext, paramIntent, localSharedPreferences);
                return;
            }
            if ("newtopic".equals(str)) {
                notifyNewTopicNotification(paramContext, paramIntent, localSharedPreferences);
                return;
            }
        } while (!"bc".equals(str));
        getBroadcastNotification(paramContext, paramIntent);
    }

    private static void getBroadcastNotification(Context paramContext, Intent paramIntent) {
        paramIntent.getExtras().getInt("pmCount");
        Object localObject5 = paramIntent.getExtras().getString("fid");
        Object localObject3 = paramIntent.getExtras().getString("url");
        Object localObject2 = paramIntent.getExtras().getString("msg");
        Object localObject4 = paramIntent.getExtras().getString("tid");
        Object localObject1 = "";
        if (paramIntent.getExtras().containsKey("title")) {
            localObject1 = paramIntent.getExtras().getString("title");
        }
        TapatalkForum localTapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById((String) localObject5);
        if (((String) localObject5).equalsIgnoreCase("0")) {
            localTapatalkForum = new TapatalkForum();
            localTapatalkForum.setName("Tapatalk Community");
            localTapatalkForum.setUrl("http://support.tapatalk.com");
        }
        if (localTapatalkForum != null) {
            if ((localObject3 == null) || (((String) localObject3).equals(""))) {
                break label324;
            }
            paramIntent = (NotificationManager) paramContext.getSystemService("notification");
            localObject4 = new Intent("android.intent.action.VIEW", Uri.parse((String) localObject3));
            ((Intent) localObject4).setFlags(268435456);
            localObject4 = PendingIntent.getActivity(paramContext, 0, (Intent) localObject4, 0);
            localObject5 = new Notification();
            ((Notification) localObject5).icon = 2130839351;
            ((Notification) localObject5).defaults = 1;
            if ((localObject1 == null) || (((String) localObject1).length() <= 0)) {
                break label291;
            }
            ((Notification) localObject5).setLatestEventInfo(paramContext, (CharSequence) localObject1, (CharSequence) localObject2, (PendingIntent) localObject4);
        }
        for (; ; ) {
            ((Notification) localObject5).flags = 16;
            paramIntent.notify((localTapatalkForum.getUrl() + localTapatalkForum.getUserName() + (String) localObject3 + (String) localObject2).hashCode(), (Notification) localObject5);
            return;
            label291:
            ((Notification) localObject5).setLatestEventInfo(paramContext, "Tapatalk - " + localTapatalkForum.getName(), (CharSequence) localObject2, (PendingIntent) localObject4);
        }
        label324:
        if ((localObject4 != null) && (!((String) localObject4).equals(""))) {
            localTapatalkForum.setUnreadPMNotificaion(localTapatalkForum.getUnreadPMNotificaion() + 1);
            paramIntent = SubscribeNotification.getSubscribeNotification(paramContext, localTapatalkForum, localTapatalkForum.getUserName(), 1, (String) localObject4, (String) localObject2, "c2dm", "", "");
            ((NotificationManager) paramContext.getSystemService("notification")).notify((localTapatalkForum.getUrl() + localTapatalkForum.getUserName() + (String) localObject4 + (String) localObject2).hashCode(), paramIntent);
            return;
        }
        try {
            localObject3 = (NotificationManager) paramContext.getSystemService("notification");
            localObject4 = new Notification.Builder(paramContext);
            ((Notification.Builder) localObject4).setOngoing(true);
            localObject5 = paramContext.getResources();
            if (localTapatalkForum.getIconUrl() != null) {
                localObject2 = Util.getFoursquareForumIcon(AvatarTool.getLocalUrl(paramContext, 5, localTapatalkForum.getIconUrl()), (int) ((Resources) localObject5).getDimension(17104901));
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject1 = Util.getFoursquareForumIcon(AppCacheManager.getFavForumLogoCacheDir(paramContext) + localTapatalkForum.getIconUrl().hashCode() + ".0", (int) ((Resources) localObject5).getDimension(17104901));
                }
                ((Notification.Builder) localObject4).setLargeIcon((Bitmap) localObject1);
            }
            ((Notification.Builder) localObject4).setAutoCancel(true).setSmallIcon(2130839351).setTicker(paramIntent.getStringExtra("msg")).setContentTitle(localTapatalkForum.getName()).setContentText(paramIntent.getStringExtra("msg"));
            paramContext = ((Notification.Builder) localObject4).getNotification();
            paramContext.flags = 16;
            ((NotificationManager) localObject3).notify(paramIntent.getStringExtra("msg").hashCode(), paramContext);
            return;
        } catch (Exception paramContext) {
        }
    }

    private static void notifyLikenotification(Context paramContext, Intent paramIntent, SharedPreferences paramSharedPreferences) {
        String str2 = paramIntent.getExtras().getString("author");
        String str1 = paramIntent.getExtras().getString("fid");
        String str3 = paramIntent.getExtras().getString("title");
        String str4 = paramIntent.getExtras().getString("did");
        paramIntent = paramIntent.getExtras().getString("pid");
        TapatalkForum localTapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(str1);
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("notificationsetting", 0);
        int i;
        if ((localTapatalkForum != null) && (localSharedPreferences.getBoolean(localTapatalkForum.getId() + "like", true)) && (localSharedPreferences.getBoolean(str1 + "notification", true))) {
            str1 = str1 + "notification";
            i = paramSharedPreferences.getInt(str1, 0);
            if (i <= 0) {
                break label270;
            }
        }
        label270:
        for (paramIntent = LikeNotification.getLikeNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1); ; paramIntent = LikeNotification.getLikeNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1)) {
            paramIntent.number = (i + 1);
            paramSharedPreferences = paramSharedPreferences.edit();
            paramSharedPreferences.putInt(str1, i + 1);
            paramSharedPreferences.commit();
            ((NotificationManager) paramContext.getSystemService("notification")).notify(str1.hashCode(), paramIntent);
            return;
        }
    }

    private static void notifyNewTopicNotification(Context paramContext, Intent paramIntent, SharedPreferences paramSharedPreferences) {
        paramIntent.getExtras().getString("uid");
        String str2 = paramIntent.getExtras().getString("author");
        String str1 = paramIntent.getExtras().getString("fid");
        String str3 = paramIntent.getExtras().getString("title");
        String str4 = paramIntent.getExtras().getString("did");
        paramIntent = paramIntent.getExtras().getString("pid");
        TapatalkForum localTapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(str1);
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("notificationsetting", 0);
        int i;
        if ((localTapatalkForum != null) && (localSharedPreferences.getBoolean(localTapatalkForum.getId() + "newtopic", true)) && (localSharedPreferences.getBoolean(str1 + "notification", true))) {
            str1 = str1 + "notification";
            i = paramSharedPreferences.getInt(str1, 0);
            if (i <= 0) {
                break label281;
            }
        }
        label281:
        for (paramIntent = NewTopicNotification.getNewNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1); ; paramIntent = NewTopicNotification.getNewNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1)) {
            paramIntent.number = (i + 1);
            paramSharedPreferences = paramSharedPreferences.edit();
            paramSharedPreferences.putInt(str1, i + 1);
            paramSharedPreferences.commit();
            ((NotificationManager) paramContext.getSystemService("notification")).notify(str1.hashCode(), paramIntent);
            return;
        }
    }

    private static void notifyQuoteNotifycation(Context paramContext, Intent paramIntent, SharedPreferences paramSharedPreferences) {
        String str2 = paramIntent.getExtras().getString("author");
        String str1 = paramIntent.getExtras().getString("fid");
        String str3 = paramIntent.getExtras().getString("title");
        String str4 = paramIntent.getExtras().getString("did");
        paramIntent = paramIntent.getExtras().getString("pid");
        TapatalkForum localTapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(str1);
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("notificationsetting", 0);
        int i;
        if ((localTapatalkForum != null) && (localSharedPreferences.getBoolean(localTapatalkForum.getId() + "quote", true)) && (localSharedPreferences.getBoolean(str1 + "notification", true))) {
            str1 = str1 + "notification";
            i = paramSharedPreferences.getInt(str1, 0);
            if (i <= 0) {
                break label270;
            }
        }
        label270:
        for (paramIntent = QuoteNotification.getQuoteNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1); ; paramIntent = QuoteNotification.getQuoteNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1)) {
            paramIntent.number = (i + 1);
            paramSharedPreferences = paramSharedPreferences.edit();
            paramSharedPreferences.putInt(str1, i + 1);
            paramSharedPreferences.commit();
            ((NotificationManager) paramContext.getSystemService("notification")).notify(str1.hashCode(), paramIntent);
            return;
        }
    }

    private static void notifyTagNotification(Context paramContext, Intent paramIntent, SharedPreferences paramSharedPreferences) {
        paramIntent.getExtras().getString("uid");
        String str2 = paramIntent.getExtras().getString("author");
        String str1 = paramIntent.getExtras().getString("fid");
        String str3 = paramIntent.getExtras().getString("title");
        String str4 = paramIntent.getExtras().getString("did");
        paramIntent = paramIntent.getExtras().getString("pid");
        TapatalkForum localTapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(str1);
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("notificationsetting", 0);
        int i;
        if ((localTapatalkForum != null) && (localSharedPreferences.getBoolean(localTapatalkForum.getId() + "tag", true)) && (localSharedPreferences.getBoolean(str1 + "notification", true))) {
            str1 = str1 + "notification";
            i = paramSharedPreferences.getInt(str1, 0);
            if (i <= 0) {
                break label281;
            }
        }
        label281:
        for (paramIntent = TagNotification.getTagNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1); ; paramIntent = TagNotification.getTagNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1)) {
            paramIntent.number = (i + 1);
            paramSharedPreferences = paramSharedPreferences.edit();
            paramSharedPreferences.putInt(str1, i + 1);
            paramSharedPreferences.commit();
            ((NotificationManager) paramContext.getSystemService("notification")).notify(str1.hashCode(), paramIntent);
            return;
        }
    }

    private static void notifyThanknotification(Context paramContext, Intent paramIntent, SharedPreferences paramSharedPreferences) {
        String str2 = paramIntent.getExtras().getString("author");
        String str1 = paramIntent.getExtras().getString("fid");
        String str3 = paramIntent.getExtras().getString("title");
        String str4 = paramIntent.getExtras().getString("did");
        paramIntent = paramIntent.getExtras().getString("pid");
        TapatalkForum localTapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(str1);
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("notificationsetting", 0);
        int i;
        if ((localTapatalkForum != null) && (localSharedPreferences.getBoolean(localTapatalkForum.getId() + "like", true)) && (localSharedPreferences.getBoolean(str1 + "notification", true))) {
            str1 = str1 + "notification";
            i = paramSharedPreferences.getInt(str1, 0);
            if (i <= 0) {
                break label270;
            }
        }
        label270:
        for (paramIntent = ThankNotification.getThankNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1); ; paramIntent = ThankNotification.getThankNotification(paramContext, localTapatalkForum, str2, i + 1, str4, str3, null, paramIntent, str1)) {
            paramIntent.number = (i + 1);
            paramSharedPreferences = paramSharedPreferences.edit();
            paramSharedPreferences.putInt(str1, i + 1);
            paramSharedPreferences.commit();
            ((NotificationManager) paramContext.getSystemService("notification")).notify(str1.hashCode(), paramIntent);
            return;
        }
    }

    protected void onDeletedMessages(Context paramContext, int paramInt) {
    }

    public void onError(Context paramContext, String paramString) {
    }

    protected void onMessage(Context paramContext, Intent paramIntent) {
        Object localObject2 = "";
        if (paramIntent.hasExtra("author")) {
            localObject2 = "" + paramIntent.getExtras().getString("author");
        }
        Object localObject1 = localObject2;
        if (paramIntent.hasExtra("fid")) {
            localObject1 = localObject2 + paramIntent.getExtras().getString("fid");
        }
        localObject2 = localObject1;
        if (paramIntent.hasExtra("did")) {
            localObject2 = localObject1 + paramIntent.getExtras().getString("did");
        }
        localObject1 = localObject2;
        if (paramIntent.hasExtra("pid")) {
            localObject1 = localObject2 + paramIntent.getExtras().getString("pid");
        }
        localObject2 = localObject1;
        if (paramIntent.hasExtra("uid")) {
            localObject2 = localObject1 + paramIntent.getExtras().getString("uid");
        }
        localObject1 = localObject2;
        if (paramIntent.hasExtra("type")) {
            localObject1 = localObject2 + paramIntent.getExtras().getString("type");
        }
        if (((String) localObject1).equalsIgnoreCase("au_reg")) {
            generateNotification(paramContext, paramIntent);
        }
        do {
            boolean bool;
            do {
                return;
                bool = paramContext.getSharedPreferences("notificationsetting", 0).getBoolean(paramContext.getResources().getString(2131100361), true);
            } while (!bool);
            String str = paramIntent.getExtras().getString("uid");
            localObject2 = paramIntent.getExtras().getString("fid");
            FavoriateSqlHelper localFavoriateSqlHelper = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
            localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = "0";
                paramIntent.putExtra("fid", "0");
            }
            localObject2 = localFavoriateSqlHelper.getFavrivateById((String) localObject1);
            localObject1 = paramIntent.getExtras().getString("type");
            if (localObject2 != null) {
            }
            try {
                if ((getSharedPreferences("notificationsetting", 0).getBoolean(((TapatalkForum) localObject2).getId() + "notification", true)) && (("bc".equals(localObject1)) || ((bool) && (localObject2 != null) && (str.equals(((TapatalkForum) localObject2).getUserId()))))) {
                    generateNotification(paramContext, paramIntent);
                }
            } catch (Exception localException) {
                for (; ; ) {
                }
            }
            if ("rf".equals(localObject1)) {
                RecommendForumNotification.getRecommendForumNotification(paramContext, paramIntent);
            }
            if ("rt".equals(localObject1)) {
                RecommendTopicNotification.getRecommendTopicNotification(paramContext, paramIntent);
            }
            if ("f".equals(localObject1)) {
                new AddForumNotification().getTopicTextNotification(paramContext, paramIntent);
            }
        } while (!"top_topic".equals(localObject1));
        new TopTopicNotification().notifyTopTopicNotificationUseRemoteView(paramContext, paramIntent);
    }

    protected boolean onRecoverableError(Context paramContext, String paramString) {
        return super.onRecoverableError(paramContext, paramString);
    }

    protected void onRegistered(Context paramContext, String paramString) {
        Object localObject = Prefs.get(paramContext);
        int i = TapatalkIdFactory.getTapatalkId(paramContext).getAuid();
        if (paramContext.getResources().getBoolean(2131558401)) {
            localObject = ((SharedPreferences) localObject).getString("byo-uid", "");
            localObject = TapatalkJsonEngine.REGIEST + "?" + "device_id=" + Util.getMD5(Util.getMacAddress(paramContext)) + "&token=" + paramString + "&language=" + Util.getDeviceLanguage(paramContext) + "&uid=" + (String) localObject;
            paramString = (String) localObject;
            if (i != 0) {
                paramString = localObject + "&au_id=" + i;
            }
            TapatalkJsonEngine.callLogin(paramContext, paramString, true);
        }
    }

    protected void onUnregistered(Context paramContext, String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/GCMIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */