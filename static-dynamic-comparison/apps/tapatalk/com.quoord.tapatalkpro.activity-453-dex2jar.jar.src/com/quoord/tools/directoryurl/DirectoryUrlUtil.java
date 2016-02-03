package com.quoord.tools.directoryurl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gcm.GCMRegistrar;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public class DirectoryUrlUtil {
    public static String createGetForumById(Context paramContext, String paramString) {
        return DirectoryUrlGenerater.appendAppKey(paramContext, TapatalkJsonEngine.GET_FORUMS + "?id=" + paramString);
    }

    public static String createGetRecommendForumsByIabCategory(Activity paramActivity, ArrayList<String> paramArrayList, int paramInt) {
        String str = TapatalkJsonEngine.GET_IAB_RECOMMOND_FORUMS + "?cat_ids=";
        int i = 0;
        if (i >= paramArrayList.size()) {
            return DirectoryUrlGenerater.appendAppKey(paramActivity, str + "&page=" + paramInt + "&per_page=" + 20);
        }
        if (i == paramArrayList.size() - 1) {
        }
        for (str = str + (String) paramArrayList.get(i); ; str = str + (String) paramArrayList.get(i) + ",") {
            i += 1;
            break;
        }
    }

    public static String createSearchForumsURL(Activity paramActivity, String paramString, int paramInt) {
        return DirectoryUrlGenerater.appendAppKey(paramActivity, TapatalkJsonEngine.SEARCH + "?" + "search=" + URLEncoder.encode(paramString) + "&page=" + paramInt + "&per_page=" + 20);
    }

    public static String createSubCategoryFeed(Activity paramActivity, String paramString) {
        return DirectoryUrlGenerater.appendAppKey(paramActivity, TapatalkJsonEngine.GET_CA_PUPULAR + "?cid=" + paramString);
    }

    public static String createSuggestSearchForumsURL(Activity paramActivity, String paramString, int paramInt, boolean paramBoolean) {
        if (paramString == null) {
            return null;
        }
        String str = TapatalkJsonEngine.V2_SEARCH + "?" + "key=" + URLEncoder.encode(paramString) + "&page=" + paramInt + "&per_page=" + 20;
        paramString = str;
        if (paramBoolean) {
            paramString = str + "&hot_term=1";
        }
        return DirectoryUrlGenerater.appendAppKey(paramActivity, paramString);
    }

    public static String getAuIdentifyTapatalkUserUrl(Activity paramActivity, String paramString1, String paramString2) {
        return DirectoryUrlGenerater.appendTokenAndAppKey(paramActivity, TapatalkJsonEngine.AU_IDENTIFY + "?fid=" + paramString1 + "&uid=" + paramString2);
    }

    public static String getAuInviteUserUrl(Activity paramActivity, ArrayList<String> paramArrayList, String paramString) {
        if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
            return "";
        }
        StringBuilder localStringBuilder = new StringBuilder("");
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                localStringBuilder.append(paramString);
                return DirectoryUrlGenerater.appendTokenAndAppKey(paramActivity, TapatalkJsonEngine.AU_INVITE_USER + "?" + localStringBuilder.toString());
            }
            localStringBuilder.append((String) paramArrayList.get(i));
            localStringBuilder.append("&");
            i += 1;
        }
    }

    public static String getBindVimeoUrl(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
        if ((paramContext == null) || (paramString1 == null)) {
            return "";
        }
        return DirectoryUrlGenerater.appendTokenAndAppKey(paramContext, TapatalkJsonEngine.GET_BIND_VIMEO) + "&vimeo_id=" + paramString1 + "&topic_id=" + paramString2 + "&filename=" + paramString4 + "&post_id=" + paramString3;
    }

    public static String getCategoriesUrl(Context paramContext) {
        if (paramContext == null) {
            return "";
        }
        return DirectoryUrlGenerater.appendAppKey(paramContext, TapatalkJsonEngine.GET_NESTED);
    }

    public static String getCategoryForumListUrl(Context paramContext, String paramString, int paramInt) {
        if ((paramContext == null) || (paramString == null)) {
            return "";
        }
        return DirectoryUrlGenerater.appendAppKey(paramContext, TapatalkJsonEngine.FORUMS_CATEGORY + "?cat_id=" + paramString + "&page=" + paramInt + "&per_page=" + 20);
    }

    public static String getDirectorySearchForumsUrl(Activity paramActivity, String paramString1, String paramString2, String paramString3) {
        return DirectoryUrlGenerater.appendAppKey(paramActivity, TapatalkJsonEngine.SEARCH + "?" + "search=" + URLEncoder.encode(paramString1) + "&page=" + paramString2 + "&per_page=" + paramString3);
    }

    public static String getForumFeed(Activity paramActivity, ArrayList<String> paramArrayList) {
        if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        int j;
        if (i >= paramArrayList.size()) {
            paramArrayList = new StringBuilder("");
            j = localArrayList.size();
            i = 0;
        }
        for (; ; ) {
            if (i >= j) {
                return DirectoryUrlGenerater.appendAppKey(paramActivity, TapatalkJsonEngine.GET_POPULAR + "?fid=" + paramArrayList.toString());
                if (!localArrayList.contains(paramArrayList.get(i))) {
                    localArrayList.add((String) paramArrayList.get(i));
                }
                i += 1;
                break;
            }
            paramArrayList.append((String) localArrayList.get(i));
            if (i < j - 1) {
                paramArrayList.append(",");
            }
            i += 1;
        }
    }

    public static String getForumFeedTest(Activity paramActivity, String paramString) {
        return DirectoryUrlGenerater.appendAppKey(paramActivity, TapatalkJsonEngine.GET_POPULAR + "?fid=" + paramString);
    }

    public static String getFunctionConfigUrl(Context paramContext) {
        return TapatalkJsonEngine.GET_FUNCTION_CONFIG;
    }

    public static String getHotTermsUrl(Context paramContext) {
        return DirectoryUrlGenerater.appendAppKey(paramContext, TapatalkJsonEngine.GET_SEARCH_TERMS + "?" + "locale=" + Util.getDeviceLocal(paramContext));
    }

    public static String getIcsSearchForumUrl(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
        if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
            return null;
        }
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(TapatalkJsonEngine.ICS_SEARCH_FORUM)).append("?key=").append(URLEncoder.encode(paramString)).append("&page=").append(paramInt1).append("&per_page=").append(paramInt2);
        if (paramBoolean) {
        }
        for (paramString = "&hot_trem=1"; ; paramString = "") {
            return DirectoryUrlGenerater.appendAppKey(paramContext, paramString);
        }
    }

    public static String getIcsSearchTopicUrl(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
        if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
            return null;
        }
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(TapatalkJsonEngine.ICS_SEARCH_TOPIC)).append("?key=").append(URLEncoder.encode(paramString)).append("&page=").append(paramInt1).append("&per_page=").append(paramInt2);
        if (paramBoolean) {
        }
        for (paramString = "&hot_trem=1"; ; paramString = "") {
            return DirectoryUrlGenerater.appendAppKey(paramContext, paramString);
        }
    }

    public static String getManageAccountUrl(Activity paramActivity) {
        Object localObject = Prefs.get(paramActivity);
        TapatalkId localTapatalkId = TapatalkIdFactory.getTapatalkId(paramActivity);
        String str = TapatalkJsonEngine.MANAGE_ACCOUNT_URL + "?from=" + ((SharedPreferences) localObject).getString("handle", "") + "&code=" + Util.getMD5(new StringBuilder(String.valueOf(localTapatalkId.getAuid())).append("|").append(localTapatalkId.getToken()).toString());
        localObject = str;
        if (localTapatalkId.getAuid() != -1) {
            localObject = str;
            if (localTapatalkId.getToken() != null) {
                if (!str.contains("?")) {
                    break label174;
                }
            }
        }
        label174:
        for (localObject = str + "&&token=" + localTapatalkId.getToken(); ; localObject = str + "?&token=" + localTapatalkId.getToken()) {
            return DirectoryUrlGenerater.appendAppKey(paramActivity, localObject + "&in_app=1");
        }
    }

    public static String getNotificationUrl(Context paramContext) {
        return DirectoryUrlGenerater.appendTokenAndAppKey(paramContext, TapatalkJsonEngine.AU_GET_FEED);
    }

    public static String getOBRecommendForumsByFidsUrl(Activity paramActivity, ArrayList<String> paramArrayList) {
        String str = TapatalkJsonEngine.OB_GET_IAB_CATEGORY + "?fids=";
        int i = 0;
        if (i >= paramArrayList.size()) {
            return DirectoryUrlGenerater.appendAppKey(paramActivity, str);
        }
        if (i < paramArrayList.size() - 1) {
        }
        for (str = str + (String) paramArrayList.get(i) + ","; ; str = str + (String) paramArrayList.get(i)) {
            i += 1;
            break;
        }
    }

    // todo might be interproc call, but String is not returned (?); use of method expects array list
    public static String getObRecommendForumsByIabCategory(Activity paramActivity, ArrayList<String> paramArrayList, int paramInt) {
        String str = TapatalkJsonEngine.OB_GET_IAB_CATEGORY + "?cat_ids=";
        int i = 0;
        if (i >= paramArrayList.size()) {
            return DirectoryUrlGenerater.appendAppKey(paramActivity, str + "&page=" + paramInt + "&per_page=" + 20);
        }
        if (i == paramArrayList.size() - 1) {
        }
        for (str = str + (String) paramArrayList.get(i); ; str = str + (String) paramArrayList.get(i) + ",") {
            i += 1;
            break;
        }
    }

    public static String getRecommendForumsByFidsUrl(Activity paramActivity, ArrayList<String> paramArrayList) {
        String str = TapatalkJsonEngine.GET_RECOMMEND_FORUMS_BY_FIDS + "?fids=";
        int i = 0;
        if (i >= paramArrayList.size()) {
            return DirectoryUrlGenerater.appendAppKey(paramActivity, str);
        }
        if (i < paramArrayList.size() - 1) {
        }
        for (str = str + (String) paramArrayList.get(i) + ","; ; str = str + (String) paramArrayList.get(i)) {
            i += 1;
            break;
        }
    }

    public static String getRegistTokenUrl(Context paramContext) {
        String str = GCMRegistrar.getRegistrationId(paramContext);
        return DirectoryUrlGenerater.appendAppKey(paramContext, TapatalkJsonEngine.REGIEST + "?device_id=" + Util.getMD5(Util.getMacAddress(paramContext)) + "&token=" + str + "&language=" + Util.getDeviceLanguage(paramContext) + "&version=" + Util.getVersionCode(paramContext) + "&timezone=" + TimeZone.getDefault().getRawOffset() / 1000);
    }

    public static String getRemoveVimeoUrl(Context paramContext, String paramString1, String paramString2) {
        if ((paramContext == null) || (paramString1 != null)) {
            return "";
        }
        return DirectoryUrlGenerater.appendTokenAndAppKey(paramContext, TapatalkJsonEngine.GET_REMOVE_VIMEO) + "&vimeo_id=" + paramString1 + "&id=" + paramString2;
    }

    public static String getSignUrl(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        if (paramString1.equals(SignInWithOtherUtil.googleString)) {
            paramString1 = "" + TapatalkJsonEngine.SIGNINWITHGOOGLE + "?";
        }
        for (; ; ) {
            paramString2 = paramString1 + "oauth_token=" + URLEncoder.encode(paramString2) + "&" + "handle=" + URLEncoder.encode(paramString5) + "&language=" + Util.getDeviceLanguage(paramContext) + "&timezone=" + TimeZone.getDefault().getRawOffset() / 1000;
            paramString1 = paramString2;
            if (Util.checkString(paramString3)) {
                paramString1 = paramString2 + "&email=" + URLEncoder.encode(paramString3);
            }
            paramString2 = paramString1;
            if (Util.checkString(paramString4)) {
                paramString2 = paramString1 + "&password=" + URLEncoder.encode(paramString4);
            }
            paramString2 = paramString2 + "&is_plus=1";
            paramString3 = GCMRegistrar.getRegistrationId(paramContext);
            paramString1 = paramString2;
            if (!paramString3.equals("")) {
                paramString1 = new StringBuilder(String.valueOf(paramString2)).append("&push_token=").append(paramString3).toString() + "&device_id=" + Util.getMD5(Util.getMacAddress(paramContext)) + "&device_type=" + Util.getDeviceName();
            }
            return DirectoryUrlGenerater.appendAppKey(paramContext, paramString1);
            if (paramString1.equals(SignInWithOtherUtil.facebookString)) {
                paramString1 = "" + TapatalkJsonEngine.SIGNINWITHFACEBOOK + "?";
            } else {
                paramString1 = "" + TapatalkJsonEngine.SIGNIN + "?";
            }
        }
    }

    public static String getTapatalkForumsFeed(ArrayList<String> paramArrayList, Activity paramActivity, boolean paramBoolean) {
        if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
            return null;
        }
        Object localObject = new ArrayList();
        int i = 0;
        int j;
        if (i >= paramArrayList.size()) {
            paramArrayList = new StringBuilder("");
            j = ((ArrayList) localObject).size();
            if (!paramBoolean) {
                break label311;
            }
            i = 0;
            label55:
            if (i < j) {
                break label219;
            }
            label61:
            if (paramArrayList.toString().equals("")) {
                break label479;
            }
            if (!Prefs.get(paramActivity).getBoolean("feedsettings_photosonly", false)) {
                break label393;
            }
            if (!paramArrayList.toString().endsWith(",")) {
                break label355;
            }
            paramArrayList = TapatalkJsonEngine.GET_MULTI_POPULAR + "?fid=" + paramArrayList.toString().substring(0, paramArrayList.length() - 1) + "&filter=image";
        }
        for (; ; ) {
            localObject = paramArrayList;
            if (Util.isHDDevice(paramActivity)) {
                localObject = paramArrayList + "&device_type=tablet";
            }
            return DirectoryUrlGenerater.appendTokenAndAppKey(paramActivity, (String) localObject);
            if (!((ArrayList) localObject).contains(paramArrayList.get(i))) {
                ((ArrayList) localObject).add((String) paramArrayList.get(i));
            }
            i += 1;
            break;
            label219:
            if (Prefs.get(paramActivity).getBoolean(Prefs.get(paramActivity).getInt("tapatalk_auid", -1) + "|" + (String) ((ArrayList) localObject).get(i), true)) {
                paramArrayList.append((String) ((ArrayList) localObject).get(i));
                if (i < j - 1) {
                    paramArrayList.append(",");
                }
            }
            i += 1;
            break label55;
            label311:
            i = 0;
            while (i < j) {
                paramArrayList.append((String) ((ArrayList) localObject).get(i));
                if (i < j - 1) {
                    paramArrayList.append(",");
                }
                i += 1;
            }
            break label61;
            label355:
            paramArrayList = TapatalkJsonEngine.GET_MULTI_POPULAR + "?fid=" + paramArrayList.toString() + "&filter=image";
            continue;
            label393:
            if (paramArrayList.toString().endsWith(",")) {
                paramArrayList = TapatalkJsonEngine.GET_MULTI_POPULAR + "?fid=" + paramArrayList.toString().substring(0, paramArrayList.length() - 1);
            } else {
                paramArrayList = TapatalkJsonEngine.GET_MULTI_POPULAR + "?fid=" + paramArrayList.toString();
                continue;
                label479:
                paramArrayList = TapatalkJsonEngine.GET_MULTI_POPULAR + "?fid=-1";
            }
        }
    }

    public static String getUploadAvatarUrl(Context paramContext) {
        if (paramContext == null) {
            return "";
        }
        return DirectoryUrlGenerater.appendAppKey(paramContext, TapatalkJsonEngine.UPLOAD_AVATAR);
    }

    public static String getUploadProfileUrl(Context paramContext, HashMap<String, String> paramHashMap) {
        if ((paramContext == null) || (paramHashMap == null)) {
            return "";
        }
        Object localObject = TapatalkJsonEngine.UPLOAD_PROFILE + "?";
        Iterator localIterator = paramHashMap.entrySet().iterator();
        for (paramHashMap = (HashMap<String, String>) localObject; ; paramHashMap = paramHashMap + (String) ((Map.Entry) localObject).getKey() + "=" + (String) ((Map.Entry) localObject).getValue() + "&") {
            if (!localIterator.hasNext()) {
                return DirectoryUrlGenerater.appendTokenAndAppKey(paramContext, paramHashMap.substring(0, paramHashMap.length() - 1));
            }
            localObject = (Map.Entry) localIterator.next();
        }
    }

    public static String getUploadVimeoCompleteUrl(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        if ((paramContext == null) || (paramString3 == null)) {
            return "";
        }
        return DirectoryUrlGenerater.appendTokenAndAppKey(paramContext, TapatalkJsonEngine.GET_UPLOAD_VIMEO_COMPLETE) + "&fid=" + paramString2 + "&uid=" + paramString1 + "&ticketID=" + paramString3 + "&filename=" + "f123-u123-" + System.currentTimeMillis() + "&username=" + paramString5 + "&device_id=" + Util.getMD5(Util.getMacAddress(paramContext));
    }

    public static String getUploadVimeoTicketUrl(Context paramContext) {
        return DirectoryUrlGenerater.appendTokenAndAppKey(paramContext, TapatalkJsonEngine.GET_UPLOAD_VIMEO_TICKET);
    }

    public static String getV2SearchForumsUrl(Activity paramActivity, String paramString) {
        return DirectoryUrlGenerater.appendAppKey(paramActivity, TapatalkJsonEngine.V2_SEARCH + "?key=" + paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/directoryurl/DirectoryUrlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */