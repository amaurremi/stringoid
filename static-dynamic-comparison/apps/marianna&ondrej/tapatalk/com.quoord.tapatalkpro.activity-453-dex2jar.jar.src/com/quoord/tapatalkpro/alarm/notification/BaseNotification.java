package com.quoord.tapatalkpro.alarm.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.InboxStyle;
import com.quoord.tapatalkpro.alarm.NotificationSetting;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BaseNotification {
    public static final int countLimit = 8;

    public static void clearSavedList(String paramString, Context paramContext) {
        paramContext = paramContext.getSharedPreferences("notification", 0).edit();
        int i = 0;
        for (; ; ) {
            if (i >= 8) {
                paramContext.commit();
                return;
            }
            paramContext.remove(paramString + i);
            i += 1;
        }
    }

    public static Notification getNotification(Context paramContext, int paramInt, String paramString1, TapatalkForum paramTapatalkForum, ArrayList<String> paramArrayList, Intent paramIntent, String paramString2, String paramString3, String paramString4, String paramString5) {
        Object localObject = paramContext.getSharedPreferences("notification", 0);
        SharedPreferences.Editor localEditor = ((SharedPreferences) localObject).edit();
        paramArrayList.clear();
        int i = 0;
        label33:
        ArrayList localArrayList;
        Uri localUri;
        label77:
        String str;
        if (i >= 8) {
            localArrayList = removeDuplicateWithOrder(paramArrayList);
            localEditor.commit();
            Resources localResources = paramContext.getResources();
            paramArrayList = Prefs.get(paramContext).getString("tapatalk_ringtone", "content://settings/system/notification_sound");
            if (paramArrayList != null) {
                break label1031;
            }
            localUri = null;
            if (paramInt <= 1) {
                break label1041;
            }
            str = paramInt + " " + localResources.getString(2131100492);
            label113:
            i = NotificationSetting.getAlertType(paramContext);
            localObject = ((SharedPreferences) localObject).getString(paramString2 + "pushIds", "");
            if ((i != 2) || (paramInt <= 1)) {
                break label1048;
            }
            paramArrayList = null;
            label164:
            if (!((String) localObject).contains(paramString3)) {
                paramString3 = localObject + ";" + paramString3;
                localEditor.putString(paramString2 + "pushIds", paramString3).commit();
            }
            paramString2 = paramString1 + " @ " + paramTapatalkForum.getName();
            paramIntent = PendingIntent.getActivity(paramContext, (paramTapatalkForum.getName() + paramTapatalkForum.getUserNameOrDisplayName() + paramInt).hashCode(), paramIntent, 0);
            paramString3 = new NotificationCompat.Builder(paramContext.getApplicationContext());
            if (paramInt <= 1) {
                break label1078;
            }
            paramString3.setContentTitle(paramTapatalkForum.getName());
            paramString3.setContentText(paramString1);
            label339:
            paramString3.setAutoCancel(true).setContentIntent(paramIntent).setSmallIcon(2130839351).setSound(paramArrayList).setTicker(paramString2);
            if (NotificationSetting.getLEDColor(paramContext) != 0) {
                break label1129;
            }
            paramString3.setLights(0, 1000, 1000);
            label386:
            if (paramTapatalkForum.getIconUrl() != null) {
                paramString2 = Util.getFoursquareForumIcon(AvatarTool.getLocalUrl(paramContext, 5, paramTapatalkForum.getIconUrl()), (int) localResources.getDimension(17104901));
                paramIntent = paramString2;
                if (paramString2 == null) {
                    paramIntent = Util.getFoursquareForumIcon(AppCacheManager.getFavForumLogoCacheDir(paramContext) + paramTapatalkForum.getIconUrl().hashCode() + ".0", (int) localResources.getDimension(17104901));
                }
                paramString3.setLargeIcon(paramIntent);
            }
            if (Build.VERSION.SDK_INT <= 15) {
                break label1226;
            }
            paramIntent = new NotificationCompat.InboxStyle();
            if (paramInt <= 1) {
                break label1200;
            }
            paramIntent.setBigContentTitle(str);
            i = localArrayList.size() - 1;
            label516:
            if (i >= 0) {
                break label1175;
            }
            if (paramInt > 8) {
                paramIntent.addLine("...");
            }
            paramString3.setContentText(paramInt + " " + localResources.getString(2131100492));
            label570:
            paramIntent.setSummaryText(paramTapatalkForum.getName());
            paramString3.setStyle(paramIntent);
            if (paramArrayList != null) {
                paramString3.setSound(paramArrayList);
            }
            label601:
            paramString1 = paramString3.build();
            if (NotificationSetting.getLEDColor(paramContext) != 0) {
                break label1247;
            }
            paramString1.ledARGB = 0;
        }
        for (; ; ) {
            paramString1.defaults = 0;
            Prefs.get(paramContext).edit().putLong(paramTapatalkForum.getId() + "|" + "tapatalk_service_last_notification_time", System.currentTimeMillis()).commit();
            return paramString1;
            if (((SharedPreferences) localObject).getString(paramString2 + i, null) == null) {
                if (paramInt == 1) {
                    localEditor.putString(paramString2 + i, paramString4 + " " + paramString1 + " " + paramString5);
                    paramArrayList.add(paramString4 + " " + paramString1 + " " + paramString5);
                    break label33;
                }
                localEditor.putString(paramString2 + i, paramString1);
                paramArrayList.add(paramString1);
                break label33;
            }
            paramArrayList.add(((SharedPreferences) localObject).getString(paramString2 + i, ""));
            label955:
            int j;
            if (paramArrayList.size() == 8) {
                paramArrayList.remove(0);
                if (paramInt != 1) {
                    break label974;
                }
                paramArrayList.add(paramString4 + " " + paramString1 + " " + paramString5);
                j = 0;
            }
            for (; ; ) {
                if (j >= 8) {
                    i += 1;
                    break;
                    label974:
                    paramArrayList.add(paramString1);
                    break label955;
                }
                localEditor.putString(paramString2 + j, (String) paramArrayList.get(j));
                j += 1;
            }
            label1031:
            localUri = Uri.parse(paramArrayList);
            break label77;
            label1041:
            str = paramString4;
            break label113;
            label1048:
            paramArrayList = localUri;
            if (i != 1) {
                break label164;
            }
            paramArrayList = localUri;
            if (!((String) localObject).contains(paramString3)) {
                break label164;
            }
            paramArrayList = null;
            break label164;
            label1078:
            paramString3.setContentTitle(paramString4);
            paramString3.setContentText(paramString4 + " " + paramString1 + " " + paramString5);
            break label339;
            label1129:
            if (NotificationSettingActivity.getLEDColor(paramContext) == -1) {
                paramString3.setLights(NotificationSetting.getLEDColor(paramContext), 1000, 1000);
                break label386;
            }
            paramString3.setLights(NotificationSettingActivity.getLEDColor(paramContext), 1000, 1000);
            break label386;
            label1175:
            paramIntent.addLine((CharSequence) localArrayList.get(i));
            i -= 1;
            break label516;
            label1200:
            paramIntent.setBigContentTitle(str);
            paramIntent.addLine(paramString1);
            paramIntent.addLine(paramString5);
            break label570;
            label1226:
            paramString3.setContentTitle(str);
            paramString3.setContentText(paramTapatalkForum.getName());
            break label601;
            label1247:
            if (NotificationSettingActivity.getLEDColor(paramContext) == -1) {
                paramString1.ledARGB = NotificationSetting.getLEDColor(paramContext);
            } else {
                paramString1.ledARGB = NotificationSettingActivity.getLEDColor(paramContext);
            }
        }
    }

    public static ArrayList<String> removeDuplicateWithOrder(ArrayList paramArrayList) {
        HashSet localHashSet = new HashSet();
        ArrayList localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        for (; ; ) {
            if (!paramArrayList.hasNext()) {
                return localArrayList;
            }
            Object localObject = paramArrayList.next();
            if (localHashSet.add(localObject)) {
                localArrayList.add(localObject);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/BaseNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */