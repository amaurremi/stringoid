package com.quoord.tools.net;

import android.content.Context;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.directoryurl.DirectoryUrlGenerater;

public class TapatalkLogUrlUtil {
    public static String getAuLogSignLogUrl(Context paramContext, ForumStatus paramForumStatus, boolean paramBoolean, int paramInt, String paramString1, String paramString2) {
        String str = TapatalkJsonEngine.SIGNIN_LOG + "?fid=" + paramForumStatus.getForumId();
        if (paramBoolean) {
        }
        for (paramForumStatus = str + "&uid=" + paramForumStatus.tapatalkForum.getUserId() + "&username=" + paramForumStatus.tapatalkForum.getUserName(); ; paramForumStatus = str + "&uid=0") {
            str = paramForumStatus + "&register=" + paramInt;
            paramForumStatus = str;
            if (paramString1 != null) {
                paramForumStatus = str;
                if (!paramString1.equals("0")) {
                    paramForumStatus = str + "&status=" + paramString1;
                }
            }
            paramString1 = paramForumStatus;
            if (paramString2 != null) {
                paramString1 = paramForumStatus;
                if (!paramString2.equals("")) {
                    paramString1 = paramForumStatus + "&error=" + paramString2;
                }
            }
            return DirectoryUrlGenerater.appendTokenAndAppKey(paramContext, paramString1);
        }
    }

    public static String getFeedLogUrl(Context paramContext, int paramInt1, String paramString, int paramInt2) {
        String str2 = TapatalkJsonEngine.FEED_LOG + "?fid=" + paramInt1 + "&type=" + paramInt2;
        String str1;
        if (paramInt2 == 1) {
            str1 = str2 + "&cid=" + paramString;
        }
        for (; ; ) {
            return DirectoryUrlGenerater.appendTokenAndAppKey(paramContext, str1);
            if (paramInt2 != 2) {
                str1 = str2;
                if (paramInt2 != 3) {
                }
            } else {
                str1 = str2 + "&tid=" + paramString;
            }
        }
    }

    public static String getLogTopicUrl(Context paramContext, String paramString1, String paramString2) {
        String str = DirectoryUrlGenerater.appendAuidWithOutTokenAndAppKey(paramContext, TapatalkJsonEngine.LOG_TOPIC);
        paramContext = str;
        if (paramString1 != null) {
            paramContext = str;
            if (!paramString1.equals("")) {
                paramContext = str + "&fid=" + paramString1;
            }
        }
        paramString1 = paramContext;
        if (paramString2 != null) {
            paramString1 = paramContext;
            if (!paramString2.equals("")) {
                paramString1 = paramContext + "&tid=" + paramString2;
            }
        }
        return paramString1;
    }

    public static String getTopTopicLogUrl(Context paramContext, int paramInt, String paramString) {
        paramString = TapatalkJsonEngine.LOG_TOP_TOPIC + "?fid=" + paramInt + "&tid=" + paramString;
        TapatalkId localTapatalkId = TapatalkIdFactory.getTapatalkId(paramContext);
        if ((localTapatalkId.isTapatalkIdLogin()) && (localTapatalkId.getAuid() != -1)) {
            return DirectoryUrlGenerater.appendTokenAndAppKey(paramContext, paramString);
        }
        return DirectoryUrlGenerater.appendAppKey(paramContext, paramString) + "&device_id=" + Util.getMD5(Util.getMacAddress(paramContext));
    }

    public static String getTrendingTopicThumbupUrl(Context paramContext, int paramInt1, String paramString, int paramInt2) {
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(DirectoryUrlGenerater.appendAuidWithOutTokenAndAppKey(paramContext, TapatalkJsonEngine.FEED_TRENDING_TOPIC_THUMBUP))).append("&fid=").append(paramInt1).toString())).append("&tid=").append(paramString).toString() + "&thumb_up=" + paramInt2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/net/TapatalkLogUrlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */