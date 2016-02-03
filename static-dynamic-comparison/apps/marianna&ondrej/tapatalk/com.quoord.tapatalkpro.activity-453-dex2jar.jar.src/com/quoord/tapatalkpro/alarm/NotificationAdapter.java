package com.quoord.tapatalkpro.alarm;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.alarm.notification.ConvNotification;
import com.quoord.tapatalkpro.alarm.notification.PmNotification;
import com.quoord.tapatalkpro.alarm.notification.SubscribeNotification;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngineService;
import com.quoord.tapatalkpro.util.TimePickerPreference;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class NotificationAdapter
        implements CallBackInterface {
    public static final String ACTION = "viewprivatemessage";
    public static final String ACTION_NOTIFICATION_VIEW_SUBSCRIBETOPIC = "viewsubscribedtopic";
    public static int TYPE_POST = 1;
    public static int TYPE_PRIVATE_MESSAGE = 0;
    boolean anonymous = false;
    private TapatalkEngineService engine = null;
    private String inBoxId = null;
    private boolean isConv;
    boolean isVibrage = false;
    NotificationAlarmService mContext = null;
    TapatalkForum mForum = null;
    boolean mPMOn = false;
    private String mPassWord = null;
    private String mRingtoneUri;
    boolean mSubOn = false;
    private int mUnreadPosts = 0;
    private int mUnreadPrivateMsg = 0;
    private String mUrl = null;
    private String mUserName = null;
    SharedPreferences preferences;
    Uri ringTone;

    public NotificationAdapter(NotificationAlarmService paramNotificationAlarmService, TapatalkForum paramTapatalkForum, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
        this.mContext = paramNotificationAlarmService;
        this.mForum = paramTapatalkForum;
        this.inBoxId = paramString3;
        this.mPMOn = paramBoolean2;
        this.isConv = paramBoolean5;
        this.mSubOn = paramBoolean3;
        this.anonymous = paramBoolean4;
        if (this.mForum.getUrl().endsWith("/")) {
            this.mUrl = (this.mForum.getUrl() + "mobiquo/mobiquo.php");
            this.mUserName = paramString1;
            this.preferences = Prefs.get(this.mContext);
            this.mRingtoneUri = this.preferences.getString("tapatalk_ringtone", "content://settings/system/notification_sound");
            if (this.mRingtoneUri != null) {
                break label333;
            }
            paramTapatalkForum = null;
            label195:
            this.ringTone = paramTapatalkForum;
            this.mPassWord = paramString2;
            if (((AudioManager) this.mContext.getSystemService("audio")).getRingerMode() != 1) {
                break label344;
            }
        }
        label333:
        label344:
        for (int i = 1; ; i = 0) {
            int j = NotificationSetting.getVibrateFlag(paramNotificationAlarmService);
            if ((j == 0) || ((j == 1) && (i != 0))) {
                this.isVibrage = true;
            }
            paramNotificationAlarmService = new ForumStatus(this.mContext);
            this.engine = new TapatalkEngineService(getActivityID(), this.mUrl, this, paramNotificationAlarmService, this.mContext);
            authorize_user(paramInt, paramBoolean4);
            return;
            this.mUrl = (this.mForum.getUrl() + "/mobiquo/mobiquo.php");
            break;
            paramTapatalkForum = Uri.parse(this.mRingtoneUri);
            break label195;
        }
    }

    public static void checkNotification(NotificationAlarmService paramNotificationAlarmService, boolean paramBoolean) {
        SharedPreferences localSharedPreferences = Prefs.get(paramNotificationAlarmService);
        if (isSlientPreroid(paramNotificationAlarmService)) {
        }
        ArrayList localArrayList;
        do {
            do {
                return;
            }
            while (!paramNotificationAlarmService.getSharedPreferences("notificationsetting", 0).getBoolean(paramNotificationAlarmService.getResources().getString(2131100361), true));
            localArrayList = new FavoriateSqlHelper(paramNotificationAlarmService, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivate();
        } while (localArrayList == null);
        int i = 0;
        label69:
        boolean bool1;
        label202:
        boolean bool2;
        label286:
        long l1;
        long l2;
        if (i < localArrayList.size()) {
            if ((!localSharedPreferences.contains(((TapatalkForum) localArrayList.get(i)).getId() + "pm")) && (!localSharedPreferences.contains(((TapatalkForum) localArrayList.get(i)).getId() + "conversation"))) {
                break label817;
            }
            if (localSharedPreferences.getBoolean(((TapatalkForum) localArrayList.get(i)).getId() + "pm", false)) {
                break label811;
            }
            bool1 = false;
            if (!localSharedPreferences.contains(((TapatalkForum) localArrayList.get(i)).getId() + "sub")) {
                break label829;
            }
            if (localSharedPreferences.getBoolean(((TapatalkForum) localArrayList.get(i)).getId() + "sub", false)) {
                break label823;
            }
            bool2 = false;
            l1 = Prefs.get(paramNotificationAlarmService).getLong(((TapatalkForum) localArrayList.get(i)).getId() + "|" + "tapatalk_service_last_notification_time", 0L);
            l2 = System.currentTimeMillis();
            if ((((TapatalkForum) localArrayList.get(i)).isPush()) || (((TapatalkForum) localArrayList.get(i)).isPushSub()) || (((TapatalkForum) localArrayList.get(i)).isPushPM()) || (((TapatalkForum) localArrayList.get(i)).isPushConv())) {
                break label835;
            }
        }
        label811:
        label817:
        label823:
        label829:
        label835:
        for (int j = 0; ; j = 1) {
            boolean bool4 = bool1;
            boolean bool3 = bool2;
            if (j != 0) {
                bool4 = bool1;
                bool3 = bool2;
                if ((l2 - l1) / 7200000L < 2L) {
                    bool4 = false;
                    bool3 = false;
                }
            }
            if ((bool4) || (bool3)) {
                String str2 = localSharedPreferences.getString(((TapatalkForum) localArrayList.get(i)).getId() + "|inbox", null);
                String str1;
                if (str2 != null) {
                    str1 = str2;
                    if (str2.length() != 0) {
                    }
                } else {
                    str1 = localSharedPreferences.getString(((TapatalkForum) localArrayList.get(i)).getUrl() + "|inbox", null);
                }
                j = localSharedPreferences.getInt(((TapatalkForum) localArrayList.get(i)).getId() + "|api_level", 0);
                localSharedPreferences.getString(((TapatalkForum) localArrayList.get(i)).getId() + "|version", "");
                bool1 = localSharedPreferences.getBoolean(((TapatalkForum) localArrayList.get(i)).getId() + "|anonymous", false);
                if ((((TapatalkForum) localArrayList.get(i)).getUserName() != null) && (((TapatalkForum) localArrayList.get(i)).getUserName().length() > 0) && (((TapatalkForum) localArrayList.get(i)).getRawPassword() != null) && (((TapatalkForum) localArrayList.get(i)).getRawPassword().length() > 0)) {
                    new NotificationAdapter(paramNotificationAlarmService, (TapatalkForum) localArrayList.get(i), ((TapatalkForum) localArrayList.get(i)).getUserName(), ((TapatalkForum) localArrayList.get(i)).getPassword(), str1, paramBoolean, j, bool4, bool3, bool1, ((TapatalkForum) localArrayList.get(i)).isSupportConve());
                }
            }
            i += 1;
            break label69;
            break;
            bool1 = true;
            break label202;
            bool1 = true;
            break label202;
            bool2 = true;
            break label286;
            bool2 = true;
            break label286;
        }
    }

    private String getActivityID() {
        return getHost(this.mUrl) + "." + this.mUserName;
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

    private void get_inbox_stat() {
        ArrayList localArrayList = new ArrayList();
        this.engine.call("get_inbox_stat", localArrayList);
    }

    public static boolean isSlientPreroid(Context paramContext) {
        paramContext = Prefs.get(paramContext);
        Object localObject;
        String str;
        Date localDate;
        if (Boolean.valueOf(paramContext.getBoolean("tapatalk_silentmode_2", false)).booleanValue()) {
            localObject = paramContext.getString("silent_begin", "0:0");
            str = paramContext.getString("silent_end", "8:0");
            paramContext = new Date();
            localDate = new Date();
            if (((String) localObject).length() <= 0) {
            }
        }
        do {
            try {
                paramContext.setYear(0);
                paramContext.setMonth(0);
                paramContext.setDate(1);
                paramContext.setHours(TimePickerPreference.getHour((String) localObject));
                paramContext.setMinutes(TimePickerPreference.getMinute((String) localObject));
                if (str.length() <= 0) {
                }
            } catch (Exception localException1) {
                try {
                    localDate.setYear(0);
                    localDate.setMonth(0);
                    localDate.setDate(1);
                    localDate.setHours(TimePickerPreference.getHour(str));
                    localDate.setMinutes(TimePickerPreference.getMinute(str));
                    localObject = Calendar.getInstance().getTime();
                    ((Date) localObject).setYear(0);
                    ((Date) localObject).setMonth(0);
                    ((Date) localObject).setDate(1);
                    if (!paramContext.after(localDate)) {
                        continue;
                    }
                    if ((((Date) localObject).after(localDate)) && (((Date) localObject).before(paramContext))) {
                        return false;
                        localException1 = localException1;
                        localException1.printStackTrace();
                    }
                } catch (Exception localException2) {
                    for (; ; ) {
                        localException2.printStackTrace();
                    }
                }
            }
            return true;
        } while ((!localException2.after(paramContext)) || (!localException2.before(localDate)));
        return true;
    }

    public void authorize_user(int paramInt, boolean paramBoolean) {
        ArrayList localArrayList = new ArrayList();
        byte[] arrayOfByte2;
        try {
            byte[] arrayOfByte1 = this.mUserName.getBytes("UTF-8");
            localArrayList.add(arrayOfByte1);
            if (paramInt < 3) {
                localArrayList.add(this.mPassWord);
                this.engine.call("authorize_user", localArrayList);
                return;
            }
        } catch (UnsupportedEncodingException localUnsupportedEncodingException1) {
            for (; ; ) {
                arrayOfByte2 = this.mUserName.getBytes();
            }
        }
        try {
            arrayOfByte2 = this.mPassWord.getBytes("UTF-8");
            localArrayList.add(arrayOfByte2);
            if (paramBoolean) {
                localArrayList.add(Boolean.valueOf(true));
            }
            this.engine.call("login", localArrayList);
            return;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
            for (; ; ) {
                byte[] arrayOfByte3 = this.mPassWord.getBytes();
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject1 = paramEngineResponse.getMethod();
        label80:
        int j;
        int i;
        if (Boolean.valueOf(paramEngineResponse.isSuccess()).booleanValue()) {
            if ((((String) localObject1).equals("authorize_user")) || (((String) localObject1).equals("login"))) {
                paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                if (((String) localObject1).equals("login")) {
                    if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                        get_inbox_stat();
                    }
                }
            }
            for (; ; ) {
                return;
                if ((paramEngineResponse != null) && (((Boolean) paramEngineResponse.get("authorize_result")).booleanValue())) {
                    get_inbox_stat();
                    return;
                    if (((String) localObject1).equals("get_inbox_stat")) {
                        for (; ; ) {
                            try {
                                paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                                j = ((Integer) paramEngineResponse.get("inbox_unread_count")).intValue();
                                if (paramEngineResponse.containsKey("subscribed_topic_unread_count")) {
                                    i = ((Integer) paramEngineResponse.get("subscribed_topic_unread_count")).intValue();
                                    if ((j > 0) && (this.mPMOn)) {
                                        this.mUnreadPrivateMsg = j;
                                        if (!this.isConv) {
                                            break label217;
                                        }
                                        getConversations();
                                    }
                                    if ((i <= 0) || (!this.mSubOn)) {
                                        break;
                                    }
                                    get_subscribe_topic();
                                    return;
                                }
                            } catch (Exception paramEngineResponse) {
                                paramEngineResponse.printStackTrace();
                                return;
                            }
                            i = 1;
                            continue;
                            label217:
                            if (this.inBoxId != null) {
                                get_box(this.inBoxId);
                            } else {
                                get_box_info();
                            }
                        }
                    }
                    if (((String) localObject1).equals("get_box_info")) {
                        try {
                            paramEngineResponse = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("list");
                            i = 0;
                            while (i < paramEngineResponse.length) {
                                localObject1 = (HashMap) paramEngineResponse[i];
                                if (((String) ((HashMap) localObject1).get("box_type")).equals("INBOX")) {
                                    j = ((Integer) ((HashMap) localObject1).get("unread_count")).intValue();
                                    Prefs.get(this.mContext).edit().putString(this.mForum.getId() + "|inbox", (String) ((HashMap) localObject1).get("box_id")).commit();
                                    if (j > 0) {
                                        get_box((String) ((HashMap) localObject1).get("box_id"));
                                    }
                                }
                                i += 1;
                            }
                            if (!((String) localObject1).equals("get_box")) {
                            }
                        } catch (Exception paramEngineResponse) {
                            paramEngineResponse.printStackTrace();
                            return;
                        }
                    }
                }
            }
        }
        for (; ; ) {
            Object localObject5;
            Object localObject6;
            long l3;
            Object localObject7;
            int k;
            try {
                paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                ((Integer) paramEngineResponse.get("total_unread_count")).intValue();
                localObject5 = (Object[]) paramEngineResponse.get("list");
                localObject6 = Prefs.get(this.mContext);
                l3 = ((SharedPreferences) localObject6).getLong(this.mForum.getId() + "|" + "tapatalk_service_last_run_time", 0L);
                l1 = ((SharedPreferences) localObject6).getLong(this.mForum.getId() + "|" + "tapatalk_service_last_read_pm_time", 0L);
                int i1 = ((SharedPreferences) localObject6).getInt(this.mForum.getId() + "|" + "tapatalk_service_last_pm_id", 0);
                i = i1;
                j = 0;
                localObject7 = new Date(l3);
                localObject1 = "";
                paramEngineResponse = "";
                k = 0;
                if (k >= localObject5.length) {
                    if (l1 > ((SharedPreferences) localObject6).getLong(this.mForum.getId() + "|" + "tapatalk_service_last_read_pm_time", 0L)) {
                        ((SharedPreferences) localObject6).edit().putLong(this.mForum.getId() + "|" + "tapatalk_service_last_read_pm_time", l1).commit();
                    }
                    if ((j <= 0) || (i <= i1)) {
                        break label80;
                    }
                    ((SharedPreferences) localObject6).edit().putInt(this.mForum.getId() + "|" + "tapatalk_service_last_pm_id", i).commit();
                    PmNotification.notifyPmNotification(this.mContext, this.mForum, (String) localObject1, j, i, this.mUserName, paramEngineResponse);
                    return;
                }
            } catch (Exception paramEngineResponse) {
                paramEngineResponse.printStackTrace();
                return;
            }
            Object localObject9 = (HashMap) localObject5[k];
            Object localObject2 = localObject1;
            int m = j;
            Object localObject4 = paramEngineResponse;
            long l2 = l1;
            int n = i;
            Object localObject3;
            if (((Integer) ((HashMap) localObject9).get("msg_state")).intValue() == 1) {
                Object localObject8 = (Date) ((HashMap) localObject9).get("sent_date");
                int i2 = Integer.parseInt((String) ((HashMap) localObject9).get("msg_id"));
                if (((HashMap) localObject9).containsKey("msg_subject")) {
                    paramEngineResponse = new String((byte[]) ((HashMap) localObject9).get("msg_subject"), "UTF-8");
                }
                if (!((Date) localObject8).after((Date) localObject7)) {
                    localObject2 = localObject1;
                    m = j;
                    localObject4 = paramEngineResponse;
                    l2 = l1;
                    n = i;
                    if (l3 != 0L) {
                    }
                } else {
                    localObject2 = (byte[]) ((HashMap) localObject9).get("msg_from");
                    localObject1 = null;
                    try {
                        localObject2 = new String((byte[]) localObject2, "UTF-8");
                        localObject1 = localObject2;
                    } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                        for (; ; ) {
                            int i3;
                            localUnsupportedEncodingException.printStackTrace();
                        }
                    }
                    i3 = j + 1;
                    j = i;
                    if (i2 > i) {
                        j = i2;
                    }
                    localObject2 = localObject1;
                    m = i3;
                    localObject4 = paramEngineResponse;
                    l2 = l1;
                    n = j;
                    if (((Date) localObject8).getTime() > l1) {
                        l2 = ((Date) localObject8).getTime();
                        localObject2 = localObject1;
                        m = i3;
                        localObject4 = paramEngineResponse;
                        n = j;
                        break label2195;
                        Date localDate;
                        Object localObject11;
                        Object localObject10;
                        if (((String) localObject1).equals("get_subscribed_topic")) {
                            for (; ; ) {
                                try {
                                    paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                                    k = 0;
                                    localObject8 = (Object[]) paramEngineResponse.get("topics");
                                    localObject9 = Prefs.get(this.mContext);
                                    l1 = ((SharedPreferences) localObject9).getLong(this.mForum.getId() + "|" + "tapatalk_service_last_sub_topic_time", 0L);
                                    localDate = new Date(l1);
                                    localObject6 = "";
                                    localObject5 = "";
                                    localObject4 = "";
                                    i = 0;
                                    if (i >= localObject8.length) {
                                        if (l1 > ((SharedPreferences) localObject9).getLong(this.mForum.getId() + "|" + "tapatalk_service_last_sub_topic_time", 0L)) {
                                            ((SharedPreferences) localObject9).edit().putLong(this.mForum.getId() + "|" + "tapatalk_service_last_sub_topic_time", l1).commit();
                                        }
                                        if (k <= 0) {
                                            break;
                                        }
                                        SubscribeNotification.notifySubscribeTopicNotification(this.mContext, this.mForum, (String) localObject6, k, this.ringTone, this.isVibrage, (String) localObject5, this.mUserName, (String) localObject4);
                                        return;
                                    }
                                } catch (Exception paramEngineResponse) {
                                    paramEngineResponse.printStackTrace();
                                    return;
                                }
                                localObject11 = (HashMap) localObject8[i];
                                boolean bool = false;
                                if (((HashMap) localObject11).containsKey("new_post")) {
                                    bool = ((Boolean) ((HashMap) localObject11).get("new_post")).booleanValue();
                                }
                                paramEngineResponse = (EngineResponse) localObject6;
                                j = k;
                                localObject1 = localObject5;
                                localObject3 = localObject4;
                                l2 = l1;
                                if (bool) {
                                    localObject7 = new String((byte[]) ((HashMap) localObject11).get("post_author_name"));
                                    paramEngineResponse = (EngineResponse) localObject6;
                                    j = k;
                                    localObject1 = localObject5;
                                    localObject3 = localObject4;
                                    l2 = l1;
                                    if (!((String) localObject7).equalsIgnoreCase(this.mUserName)) {
                                        localObject10 = (Date) ((HashMap) localObject11).get("post_time");
                                        if (!((Date) localObject10).after(localDate)) {
                                            paramEngineResponse = (EngineResponse) localObject6;
                                            j = k;
                                            localObject1 = localObject5;
                                            localObject3 = localObject4;
                                            l2 = l1;
                                            if (l1 != 0L) {
                                            }
                                        } else {
                                            localObject4 = localObject7;
                                            k += 1;
                                            localObject5 = (String) ((HashMap) localObject11).get("topic_id");
                                            localObject6 = new String((byte[]) ((HashMap) localObject11).get("topic_title"), "UTF-8");
                                            paramEngineResponse = (EngineResponse) localObject4;
                                            j = k;
                                            localObject1 = localObject5;
                                            localObject3 = localObject6;
                                            l2 = l1;
                                            if (((Date) localObject10).getTime() > l1) {
                                                l2 = ((Date) localObject10).getTime();
                                                localObject3 = localObject6;
                                                localObject1 = localObject5;
                                                j = k;
                                                paramEngineResponse = (EngineResponse) localObject4;
                                            }
                                        }
                                    }
                                }
                                i += 1;
                                localObject6 = paramEngineResponse;
                                k = j;
                                localObject5 = localObject1;
                                localObject4 = localObject3;
                                l1 = l2;
                            }
                        }
                        if (!((String) localObject1).equals("get_conversations")) {
                            break;
                        }
                        for (; ; ) {
                            try {
                                localObject7 = (Object[]) ((HashMap) paramEngineResponse.getResponse()).get("list");
                                localObject8 = Prefs.get(this.mContext);
                                l1 = ((SharedPreferences) localObject8).getLong(this.mForum.getId() + "|" + "tapatalk_service_last_read_pm_time", 0L);
                                localObject9 = new Date(l1);
                                k = 0;
                                m = 0;
                                localObject6 = "";
                                localObject5 = "";
                                paramEngineResponse = "";
                                i = 0;
                                if (i >= localObject7.length) {
                                    if (l1 > ((SharedPreferences) localObject8).getLong(this.mForum.getId() + "|" + "tapatalk_service_last_read_pm_time", 0L)) {
                                        ((SharedPreferences) localObject8).edit().putLong(this.mForum.getId() + "|" + "tapatalk_service_last_read_pm_time", l1).commit();
                                    }
                                    if (k <= 0) {
                                        break;
                                    }
                                    localObject1 = (NotificationManager) this.mContext.getSystemService("notification");
                                    ConvNotification.getConvNotification(this.mContext, this.mForum, (String) localObject6, k, this.ringTone, this.isVibrage, paramEngineResponse, this.mUserName, (String) localObject5, m);
                                    return;
                                }
                            } catch (Exception paramEngineResponse) {
                                paramEngineResponse.printStackTrace();
                                return;
                            }
                            localObject10 = (HashMap) localObject7[i];
                            localObject1 = localObject6;
                            j = k;
                            localObject3 = localObject5;
                            localObject4 = paramEngineResponse;
                            l2 = l1;
                            if (((Boolean) ((HashMap) localObject10).get("new_post")).booleanValue()) {
                                localDate = (Date) ((HashMap) localObject10).get("last_conv_time");
                                n = Integer.parseInt((String) ((HashMap) localObject10).get("reply_count"));
                                localObject11 = (String) ((HashMap) localObject10).get("last_user_id");
                                if (!localDate.after((Date) localObject9)) {
                                    localObject1 = localObject6;
                                    j = k;
                                    localObject3 = localObject5;
                                    localObject4 = paramEngineResponse;
                                    m = n;
                                    l2 = l1;
                                    if (l1 != 0L) {
                                    }
                                } else {
                                    localObject1 = (HashMap) ((HashMap) ((HashMap) localObject10).get("participants")).get(localObject11);
                                    paramEngineResponse = (String) ((HashMap) localObject10).get("conv_id");
                                    localObject5 = new String((byte[]) ((HashMap) localObject1).get("username"));
                                    localObject6 = new String((byte[]) ((HashMap) localObject10).get("conv_subject"));
                                    k += 1;
                                    localObject1 = localObject5;
                                    j = k;
                                    localObject3 = localObject6;
                                    localObject4 = paramEngineResponse;
                                    m = n;
                                    l2 = l1;
                                    if (localDate.getTime() > l1) {
                                        l2 = localDate.getTime();
                                        m = n;
                                        localObject4 = paramEngineResponse;
                                        localObject3 = localObject6;
                                        j = k;
                                        localObject1 = localObject5;
                                    }
                                }
                            }
                            i += 1;
                            localObject6 = localObject1;
                            k = j;
                            localObject5 = localObject3;
                            paramEngineResponse = (EngineResponse) localObject4;
                            l1 = l2;
                        }
                        new HashMap().put("errorstring", paramEngineResponse.getErrorMessage());
                        return;
                    }
                }
            }
            label2195:
            k += 1;
            localObject1 = localObject3;
            j = m;
            paramEngineResponse = (EngineResponse) localObject4;
            long l1 = l2;
            i = n;
        }
    }

    public String getCallBackTag() {
        return System.currentTimeMillis();
    }

    public void getConversations() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(0));
        localArrayList.add(Integer.valueOf(19));
        this.engine.call("get_conversations", localArrayList);
    }

    public int getUnreadPostsCount() {
        return this.mUnreadPosts;
    }

    public int getUnreadPrivateMsgCount() {
        return this.mUnreadPrivateMsg;
    }

    public void get_subscribe_topic() {
        ArrayList localArrayList = new ArrayList();
        this.engine.call("get_subscribed_topic", localArrayList);
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/NotificationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */