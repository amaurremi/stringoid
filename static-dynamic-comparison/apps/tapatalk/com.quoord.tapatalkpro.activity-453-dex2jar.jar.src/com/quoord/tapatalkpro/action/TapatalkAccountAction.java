package com.quoord.tapatalkpro.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.ForumAccountBean;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.net.JSONUtil;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
public class TapatalkAccountAction {
    private static ArrayList<TapatalkForum> currentFroums;
    private Activity activity;
    private AQuery aq = null;
    private FavoriateSqlHelper helper;
    private GetLocalAccountBack localBack;
    private GetRemoteAccountBack remoteBack;
    private TapatalkId tapatalkId;

    public TapatalkAccountAction(Activity paramActivity) {
        this.activity = paramActivity;
        this.aq = new AQuery(this.activity);
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(this.activity);
        this.helper = new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
    }

    private boolean LocalFourmInformation2Forum(TapatalkForum paramTapatalkForum) {
        try {
            TapatalkForum localTapatalkForum = this.helper.getFavrivateByIdSequence(paramTapatalkForum.getId().toString());
            if (paramTapatalkForum.equals(localTapatalkForum)) {
                if (localTapatalkForum != null) {
                    if ((localTapatalkForum.getUserNameOrDisplayName() != null) && (!localTapatalkForum.getUserNameOrDisplayName().equals(""))) {
                        paramTapatalkForum.setUserName(localTapatalkForum.getUserNameOrDisplayName());
                    }
                    if ((localTapatalkForum.getDisplayNameOrUsername() != null) && (!localTapatalkForum.getDisplayNameOrUsername().equals(""))) {
                        paramTapatalkForum.setDisplayName(localTapatalkForum.getDisplayNameOrUsername());
                    }
                    paramTapatalkForum.setUserId(localTapatalkForum.getUserId());
                    paramTapatalkForum.setRawPassword(localTapatalkForum.getRawPassword());
                    paramTapatalkForum.setPassword(localTapatalkForum.getPassword());
                    paramTapatalkForum.setPush(localTapatalkForum.isPush());
                    paramTapatalkForum.setPushConv(localTapatalkForum.isPushConv());
                    paramTapatalkForum.setPushLike(localTapatalkForum.isPushLike());
                    paramTapatalkForum.setPushNewTopic(localTapatalkForum.isPushNewTopic());
                    paramTapatalkForum.setPushPM(localTapatalkForum.isPushPM());
                    paramTapatalkForum.setPushQuote(localTapatalkForum.isPushQuote());
                    paramTapatalkForum.setPushSub(localTapatalkForum.isPushSub());
                    paramTapatalkForum.setPushTag(localTapatalkForum.isPushTag());
                    paramTapatalkForum.setSupportConve(localTapatalkForum.isSupportConve());
                    paramTapatalkForum.setApiLevel(localTapatalkForum.getApiLevel());
                    paramTapatalkForum.setPMEnable(localTapatalkForum.isPMEnable());
                    if (!Util.isEmpty(localTapatalkForum.getUserIconUrl())) {
                        paramTapatalkForum.setUserIconUrl(localTapatalkForum.getUserIconUrl());
                    }
                    paramTapatalkForum.setCurrentUserSso(localTapatalkForum.getCurrentUserSso());
                    if ((localTapatalkForum.getVersion() != null) && (!localTapatalkForum.getVersion().equals(""))) {
                        paramTapatalkForum.setmVersion(localTapatalkForum.getVersion(), this.activity);
                    }
                }
                return true;
            }
            return false;
        } catch (Exception paramTapatalkForum) {
        }
        return true;
    }

    public static void addToCurrenForums(TapatalkForum paramTapatalkForum, Activity paramActivity) {
        if (currentFroums != null) {
            FavoriateSqlHelper localFavoriateSqlHelper = new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
            if (localFavoriateSqlHelper.getFavrivateById(paramTapatalkForum.getId()) == null) {
                localFavoriateSqlHelper.saveFavoriate(paramTapatalkForum);
            }
            currentFroums.add(0, paramTapatalkForum);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    new SynchaAccountAction(TapatalkAccountAction.this).synchAccount(TapatalkAccountAction.currentFroums);
                }
            }, 300L);
        }
    }

    public static void cacheAccountDataUtil(Activity paramActivity, final ArrayList<TapatalkForum> paramArrayList) {
        new Handler().post(new Runnable() {
            public void run() {
                AppCacheManager.cacheData(AppCacheManager.getCloudAccountUrl(TapatalkAccountAction.this), paramArrayList);
            }
        });
    }

    public static void cleanCurrenForums() {
        if (currentFroums != null) {
            currentFroums.clear();
        }
    }

    public static void deleteCurrenForums(TapatalkForum paramTapatalkForum) {
        if (currentFroums != null) {
            currentFroums.remove(paramTapatalkForum);
        }
    }

    public static int getCurrentForumOrder(Context paramContext, TapatalkForum paramTapatalkForum) {
        if (paramTapatalkForum == null) {
            return 0;
        }
        int j = 0;
        ArrayList localArrayList = getCurrnentAllAccount((Activity) paramContext);
        Object localObject = null;
        int i = 0;
        int k;
        for (; ; ) {
            if (i >= localArrayList.size()) {
                k = j;
            }
            TapatalkForum localTapatalkForum;
            do {
                do {
                    do {
                        if (localObject == null) {
                            break label250;
                        }
                        j = 0;
                        if (((TapatalkForum) localObject).getUserName() == null) {
                            j = 1;
                        }
                        i = j;
                        if (j == 0) {
                            i = j;
                            if (((TapatalkForum) localObject).getUserName().equals("")) {
                                i = 1;
                            }
                        }
                        j = i;
                        if (i == 0) {
                            j = i;
                            if (Util.isSignOutUser(paramContext, (TapatalkForum) localObject)) {
                                j = 1;
                            }
                        }
                        if (j != 0) {
                            break label217;
                        }
                        if (!localArrayList.contains(paramTapatalkForum)) {
                            break label212;
                        }
                        return localArrayList.indexOf(paramTapatalkForum) + 1;
                        if (!((TapatalkForum) localArrayList.get(i)).getId().equals(paramTapatalkForum.getId())) {
                            break;
                        }
                        localTapatalkForum = (TapatalkForum) localArrayList.get(i);
                        j = i;
                        localObject = localTapatalkForum;
                        k = j;
                    } while (localTapatalkForum.getUserName() == null);
                    localObject = localTapatalkForum;
                    k = j;
                } while (localTapatalkForum.getUserName().equals(""));
                localObject = localTapatalkForum;
                k = j;
            } while (Util.isSignOutUser(paramContext, localTapatalkForum));
            localObject = localTapatalkForum;
            i += 1;
        }
        label212:
        return k + 1;
        label217:
        localArrayList.remove(localObject);
        localArrayList.add(k, paramTapatalkForum);
        currentFroums = localArrayList;
        AppCacheManager.cacheData(AppCacheManager.getCloudAccountUrl(paramContext), localArrayList);
        return k;
        label250:
        return 0;
    }

    public static ArrayList<TapatalkForum> getCurrnentAllAccount(Context paramContext) {
        if ((currentFroums == null) || (currentFroums.size() == 0)) {
            Object localObject1 = new ArrayList();
            Object localObject2 = AppCacheManager.getCloudAccountUrl(paramContext);
            paramContext = (Context) localObject1;
            if (AppCacheManager.checkFile((String) localObject2)) {
                localObject2 = AppCacheManager.getCacheData((String) localObject2);
                paramContext = (Context) localObject1;
                if ((localObject2 instanceof ArrayList)) {
                    paramContext = (Context) localObject1;
                    if (localObject2 != null) {
                        paramContext = (ArrayList) localObject2;
                    }
                }
            }
            localObject1 = paramContext;
            if (paramContext == null) {
                localObject1 = new ArrayList();
            }
            currentFroums = (ArrayList) localObject1;
        }
        return currentFroums;
    }

    public static ArrayList<TapatalkForum> getFeedTempTapatalkForums(Context paramContext) {
        Object localObject1 = new ArrayList();
        Object localObject2 = AppCacheManager.getFeedTempAccountUrl(paramContext);
        paramContext = (Context) localObject1;
        if (AppCacheManager.checkFile((String) localObject2)) {
            localObject2 = AppCacheManager.getCacheData((String) localObject2);
            paramContext = (Context) localObject1;
            if ((localObject2 instanceof ArrayList)) {
                paramContext = (Context) localObject1;
                if (localObject2 != null) {
                    paramContext = (ArrayList) localObject2;
                }
            }
        }
        localObject1 = paramContext;
        if (paramContext == null) {
            localObject1 = new ArrayList();
        }
        return (ArrayList<TapatalkForum>) localObject1;
    }

    public static void saveFeedTempTapatalkForum(Context paramContext, TapatalkForum paramTapatalkForum) {
        ArrayList localArrayList = getFeedTempTapatalkForums(paramContext);
        localArrayList.add(paramTapatalkForum);
        AppCacheManager.cacheData(AppCacheManager.getFeedTempAccountUrl(paramContext), localArrayList);
    }

    private void saveTapatalkProfile(JSONObject paramJSONObject) {
        SharedPreferences.Editor localEditor = Prefs.get(this.activity).edit();
        if (paramJSONObject.has("au_id")) {
            localEditor.putInt("tapatalk_au_id", paramJSONObject.optInt("au_id"));
        }
        if (paramJSONObject.has("avatar")) {
            localEditor.putString("tapatalk_avatar", paramJSONObject.optString("avatar"));
        }
        if (paramJSONObject.has("avatar_url")) {
            localEditor.putString("tapatalk_avatar_url", paramJSONObject.optString("avatar_url"));
        }
        if (paramJSONObject.has("birthday")) {
            localEditor.putString("tapatalk_birthday", paramJSONObject.optString("birthday"));
        }
        if (paramJSONObject.has("cover")) {
            localEditor.putString("tapatalk_cover", paramJSONObject.optString("cover"));
        }
        if (paramJSONObject.has("description")) {
            localEditor.putString("tapatalk_description", paramJSONObject.optString("description"));
        }
        if (paramJSONObject.has("first_name")) {
            localEditor.putString("tapatalk_first_name", paramJSONObject.optString("first_name"));
        }
        if (paramJSONObject.has("gender")) {
            localEditor.putString("tapatalk_gender", paramJSONObject.optString("gender"));
        }
        if (paramJSONObject.has("language")) {
            localEditor.putString("tapatalk_language", paramJSONObject.optString("language"));
        }
        if (paramJSONObject.has("last_activity")) {
            localEditor.putLong("tapatalk_last_activity", paramJSONObject.optLong("last_activity"));
        }
        if (paramJSONObject.has("last_name")) {
            localEditor.putString("tapatalk_last_name", paramJSONObject.optString("last_name"));
        }
        if (paramJSONObject.has("link")) {
            localEditor.putString("tapatalk_link", paramJSONObject.optString("link"));
        }
        if (paramJSONObject.has("locale")) {
            localEditor.putString("tapatalk_locale", paramJSONObject.optString("locale"));
        }
        if (paramJSONObject.has("location")) {
            localEditor.putString("tapatalk_location", paramJSONObject.optString("location"));
        }
        if (paramJSONObject.has("name")) {
            localEditor.putString("tapatalk_name", paramJSONObject.optString("name"));
        }
        if (paramJSONObject.has("register")) {
            localEditor.putLong("tapatalk_register", paramJSONObject.optLong("register"));
        }
        if (paramJSONObject.has("signature")) {
            localEditor.putString("tapatalk_signature", paramJSONObject.optString("signature"));
        }
        if (paramJSONObject.has("status_message")) {
            localEditor.putString("tapatalk_status_message", paramJSONObject.optString("status_message"));
        }
        localEditor.commit();
    }

    private ArrayList<TapatalkForum> sortForum(ArrayList<TapatalkForum> paramArrayList, HashMap<Integer, String> paramHashMap) {
        ArrayList localArrayList1 = (ArrayList) paramArrayList.clone();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject = sortOrderMap(paramHashMap);
        ArrayList localArrayList3 = new ArrayList();
        int n = ((ArrayList) localObject).size();
        StringBuilder localStringBuilder = new StringBuilder();
        int j = 0;
        int i;
        if (j >= n) {
            j = localArrayList1.size();
            i = 0;
        }
        for (; ; ) {
            if (i >= j) {
                return localArrayList2;
                int m = localArrayList1.size();
                int k = 0;
                if (k >= m) {
                    j += 1;
                    break;
                }
                TapatalkForum localTapatalkForum = (TapatalkForum) localArrayList1.get(k);
                paramHashMap = localTapatalkForum.getUserName();
                paramArrayList = paramHashMap;
                if (paramHashMap == null) {
                    paramArrayList = "";
                }
                paramArrayList = paramArrayList.toLowerCase();
                localStringBuilder.delete(0, localStringBuilder.length());
                if (localTapatalkForum.getUserName() != null) {
                    localStringBuilder.append(localTapatalkForum.getId()).append('|').append(paramArrayList);
                    paramArrayList = localStringBuilder.toString();
                    i = m;
                    if (localTapatalkForum.getName() != null) {
                        i = m;
                        if (paramArrayList.equalsIgnoreCase((String) ((ArrayList) localObject).get(j))) {
                            i = m;
                            if (!localArrayList3.contains(paramArrayList)) {
                                localArrayList2.add(localTapatalkForum);
                                localArrayList3.add(paramArrayList);
                                localArrayList1.remove(localTapatalkForum);
                                i = m - 1;
                            }
                        }
                    }
                }
                for (; ; ) {
                    k += 1;
                    m = i;
                    break;
                    i = m;
                    if (localTapatalkForum.getName() != null) {
                        i = m;
                        if (localTapatalkForum.getId().toString().equalsIgnoreCase((String) ((ArrayList) localObject).get(j))) {
                            localStringBuilder.append(localTapatalkForum.getId()).append('|').append(paramArrayList);
                            paramArrayList = localStringBuilder.toString();
                            i = m;
                            if (!localArrayList3.contains(paramArrayList)) {
                                localArrayList2.add(localTapatalkForum);
                                localArrayList3.add(paramArrayList);
                                localArrayList1.remove(localTapatalkForum);
                                i = m - 1;
                            }
                        }
                    }
                }
            }
            localObject = (TapatalkForum) localArrayList1.get(i);
            paramHashMap = ((TapatalkForum) localObject).getUserName();
            paramArrayList = paramHashMap;
            if (paramHashMap == null) {
                paramArrayList = "";
            }
            paramArrayList = paramArrayList.toLowerCase();
            localStringBuilder.delete(0, localStringBuilder.length());
            localStringBuilder.append(((TapatalkForum) localObject).getId()).append('|').append(paramArrayList);
            paramArrayList = localStringBuilder.toString();
            if ((((TapatalkForum) localObject).getName() != null) && (!localArrayList3.contains(paramArrayList))) {
                localArrayList2.add(localObject);
                localArrayList3.add(paramArrayList);
            }
            i += 1;
        }
    }

    private ArrayList<String> sortOrderMap(HashMap<Integer, String> paramHashMap) {
        ArrayList localArrayList = new ArrayList();
        Object[] arrayOfObject = paramHashMap.keySet().toArray();
        Arrays.sort(arrayOfObject);
        int i = 0;
        for (; ; ) {
            if (i >= arrayOfObject.length) {
                return localArrayList;
            }
            Object localObject = arrayOfObject[i];
            if (!localArrayList.contains(paramHashMap.get(localObject))) {
            }
            try {
                localArrayList.add(((String) paramHashMap.get(localObject)).toString());
                i += 1;
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                }
            }
        }
    }

    private void synLocalAccountsToServer(ArrayList<TapatalkForum> paramArrayList, int paramInt) {
        paramInt = 0;
        if (paramInt >= paramArrayList.size()) {
            return;
        }
        Object localObject2 = (TapatalkForum) paramArrayList.get(paramInt);
        String str1 = ((TapatalkForum) localObject2).getUserNameOrDisplayName();
        Object localObject1 = ((TapatalkForum) localObject2).getUserId();
        String str2 = ((TapatalkForum) localObject2).getFromByoAccountChannel();
        if (((String) localObject1).equals("0")) {
            str1 = "Guest";
        }
        localObject1 = this.activity;
        String str3 = ((TapatalkForum) localObject2).getId();
        localObject2 = ((TapatalkForum) localObject2).getUserId();
        if (str2 == null) {
            str2 = "account";
        }
        for (; ; ) {
            TapatalkJsonEngine.auAddAccount((Context) localObject1, str3, str1, "", (String) localObject2, "", str2, paramInt + 1);
            paramInt += 1;
            break;
        }
    }

    public void cacheAccountData(final ArrayList<TapatalkForum> paramArrayList) {
        new Handler().post(new Runnable() {
            public void run() {
                AppCacheManager.cacheData(AppCacheManager.getCloudAccountUrl(TapatalkAccountAction.this.activity), paramArrayList);
            }
        });
    }

    public ArrayList<TapatalkForum> getCacheAccount() {
        ArrayList localArrayList3 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject = AppCacheManager.getCloudAccountUrl(this.activity);
        ArrayList localArrayList1 = localArrayList3;
        if (AppCacheManager.checkFile((String) localObject)) {
            localObject = AppCacheManager.getCacheData((String) localObject);
            localArrayList1 = localArrayList3;
            if ((localObject instanceof ArrayList)) {
                localArrayList1 = localArrayList3;
                if (localObject != null) {
                    localArrayList1 = (ArrayList) localObject;
                }
            }
        }
        int i;
        if (localArrayList1 != null) {
            i = 0;
        }
        for (; ; ) {
            if (i >= localArrayList1.size()) {
                if (localArrayList1 == null) {
                    localArrayList2 = new ArrayList();
                }
                return localArrayList2;
            }
            if (!localArrayList2.contains(localArrayList1.get(i))) {
                localArrayList2.add((TapatalkForum) localArrayList1.get(i));
            }
            i += 1;
        }
    }

    public ArrayList<TapatalkForum> getDbAccount() {
        new ArrayList();
        ArrayList localArrayList2 = this.helper.getFavrivate();
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null) {
            localArrayList1 = new ArrayList();
        }
        return localArrayList1;
    }

    public void getLocalAccount(GetLocalAccountBack paramGetLocalAccountBack) {
        this.localBack = paramGetLocalAccountBack;
        new Thread() {
            public void handleMessage(Message paramAnonymousMessage) {
                if (TapatalkAccountAction.this.localBack != null) {
                    paramAnonymousMessage = (ArrayList) paramAnonymousMessage.obj;
                    TapatalkAccountAction.this.localBack.getLocalAccountBack(paramAnonymousMessage);
                    TapatalkAccountAction.this.cacheAccountData(paramAnonymousMessage);
                }
            }
        }
        {
            public void run ()
            {
                Object localObject1 = new ArrayList();
                Object localObject2 = TapatalkAccountAction.this.getCacheAccount();
                ArrayList localArrayList = TapatalkAccountAction.this.getDbAccount();
                if ((((ArrayList) localObject2).size() > 0) && (localArrayList.size() > 0)) {
                    localObject1 = TapatalkAccountAction.this.manageLocalAccount((ArrayList) localObject2, localArrayList);
                }
                for (; ; ) {
                    localObject2 = this.val$handler.obtainMessage();
                    ((Message) localObject2).obj = localObject1;
                    this.val$handler.sendMessage((Message) localObject2);
                    return;
                    if (((ArrayList) localObject2).size() == 0) {
                        localObject1 = localArrayList;
                    }
                    if (localArrayList.size() == 0) {
                        localObject1 = localObject2;
                    }
                }
            }
        }.start();
    }

    public void getRemoteAccount(GetRemoteAccountBack paramGetRemoteAccountBack) {
        this.remoteBack = paramGetRemoteAccountBack;
        int i = this.tapatalkId.getAuid();
        paramGetRemoteAccountBack = this.tapatalkId.getToken();
        Object localObject2;
        Object localObject1;
        if ((i != -1) && (paramGetRemoteAccountBack != null)) {
            localObject2 = Prefs.get(this.activity).getString("pro_lincense_check", "");
            localObject1 = TapatalkJsonEngine.AU_GET_INFO + "?au_id=" + i + "&token=" + paramGetRemoteAccountBack + "&accounts=1&profile=1&authinfo=1" + "&" + TapatalkApp.APP_KEY;
            paramGetRemoteAccountBack = (GetRemoteAccountBack) localObject1;
            if (!((String) localObject2).equals("")) {
                paramGetRemoteAccountBack = localObject1 + "&pro=" + (String) localObject2;
            }
        }
        try {
            localObject1 = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            ((SSLSocketFactory) localObject1).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            localObject2 = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                    if ((paramAnonymousJSONObject != null) && (((Boolean) paramAnonymousJSONObject.opt("result")).booleanValue())) {
                        paramAnonymousString = new JSONArray();
                        paramAnonymousAjaxStatus = new JSONArray();
                        if (paramAnonymousJSONObject.has("result_text")) {
                            localObject = (String) paramAnonymousJSONObject.opt("result_text");
                        }
                        if (paramAnonymousJSONObject.has("forums")) {
                            paramAnonymousString = (JSONArray) paramAnonymousJSONObject.opt("forums");
                        }
                        if (paramAnonymousJSONObject.has("accounts")) {
                            paramAnonymousAjaxStatus = (JSONArray) paramAnonymousJSONObject.opt("accounts");
                        }
                        if (paramAnonymousJSONObject.has("authinfo")) {
                            localObject = (JSONObject) paramAnonymousJSONObject.opt("authinfo");
                            new SignInWithOtherUtil(TapatalkAccountAction.this.activity).writeToPres((JSONObject) localObject);
                        }
                        if (paramAnonymousJSONObject.has("profile")) {
                            localObject = paramAnonymousJSONObject.optJSONObject("profile");
                            TapatalkAccountAction.this.saveTapatalkProfile((JSONObject) localObject);
                        }
                        Object localObject = Prefs.get(TapatalkAccountAction.this.activity);
                        if (paramAnonymousJSONObject.has("twitter_user")) {
                            int i = new JSONUtil(paramAnonymousJSONObject).optInteger("twitter_user").intValue();
                            ((SharedPreferences) localObject).edit().putInt("tapatalk_status_twitter_user", i).commit();
                        }
                        if (!paramAnonymousJSONObject.has("twitter_user")) {
                            ((SharedPreferences) localObject).edit().putInt("tapatalk_status_twitter_user", 0).commit();
                        }
                        paramAnonymousString = TapatalkAccountAction.this.manageLocalAndRemoteAccount(paramAnonymousString, paramAnonymousAjaxStatus);
                        TapatalkAccountAction.this.cacheAccountData(paramAnonymousString);
                        TapatalkAccountAction.this.remoteBack.getAccountBack(paramAnonymousString);
                    }
                }
            };
            AjaxCallback.setSSF((SocketFactory) localObject1);
            AjaxCallback.setTimeout(20000);
            this.aq.ajax(paramGetRemoteAccountBack, JSONObject.class, (AjaxCallback) localObject2);
            return;
        } catch (Exception paramGetRemoteAccountBack) {
        }
    }

    public boolean isContainUserId(TapatalkForum paramTapatalkForum) {
        return currentFroums.contains(paramTapatalkForum);
    }

    public ArrayList<TapatalkForum> manageLocalAccount(ArrayList<TapatalkForum> paramArrayList1, ArrayList<TapatalkForum> paramArrayList2) {
        Object localObject1 = paramArrayList1.iterator();
        Iterator localIterator1;
        if (!((Iterator) localObject1).hasNext()) {
            localIterator1 = paramArrayList2.iterator();
        }
        for (; ; ) {
            Object localObject2;
            if (!localIterator1.hasNext()) {
                AppCacheManager.cacheData(AppCacheManager.getCloudAccountUrl(this.activity), paramArrayList1);
                return paramArrayList1;
                localObject2 = (TapatalkForum) ((Iterator) localObject1).next();
                i = 0;
                while (i < paramArrayList2.size()) {
                    LocalFourmInformation2Forum((TapatalkForum) localObject2);
                    i += 1;
                }
                break;
            }
            TapatalkForum localTapatalkForum = (TapatalkForum) localIterator1.next();
            int i = 1;
            Iterator localIterator2 = paramArrayList1.iterator();
            label101:
            int m;
            int j;
            if (!localIterator2.hasNext()) {
                if (i != 0) {
                    paramArrayList1.add(0, localTapatalkForum);
                }
                if (!Util.isSignOutUser(this.activity, localTapatalkForum)) {
                    continue;
                }
                m = 1;
                j = -1;
                i = 0;
                if (i < paramArrayList1.size()) {
                    break label424;
                }
            }
            label346:
            label424:
            label557:
            label585:
            for (i = m; ; i = 0) {
                if (j == -1) {
                    break label588;
                }
                if (i == 0) {
                    break label590;
                }
                ((TapatalkForum) paramArrayList1.get(j)).setUserId("");
                ((TapatalkForum) paramArrayList1.get(j)).setUserName("");
                ((TapatalkForum) paramArrayList1.get(j)).setDisplayName("");
                ((TapatalkForum) paramArrayList1.get(j)).setPassword("");
                this.helper.saveFavoriate((TapatalkForum) paramArrayList1.get(j));
                break;
                paramArrayList2 = (TapatalkForum) localIterator2.next();
                if (!paramArrayList2.getId().equals(localTapatalkForum.getId())) {
                    break label101;
                }
                if ((!Util.isEmpty(paramArrayList2.getUserId())) && (!Util.isEmpty(localTapatalkForum.getUserId())) && ((!paramArrayList2.getUserId().equals("0")) || (!localTapatalkForum.getUserId().equals("0")))) {
                }
                for (j = 0; ; j = 1) {
                    if (j != 0) {
                        break label346;
                    }
                    if (!paramArrayList2.getUserId().equals(localTapatalkForum.getUserId())) {
                        break;
                    }
                    i = 0;
                    break;
                }
                if ((paramArrayList2.getUserNameOrDisplayName() == null) || (localTapatalkForum.getUserNameOrDisplayName() == null)) {
                    break label101;
                }
                localObject1 = paramArrayList2.getUserNameOrDisplayName();
                localObject2 = localTapatalkForum.getUserNameOrDisplayName();
                paramArrayList2 = (ArrayList<TapatalkForum>) localObject1;
                if (((String) localObject1).equals("")) {
                    paramArrayList2 = "Guest";
                }
                localObject1 = localObject2;
                if (((String) localObject2).equals("")) {
                    localObject1 = "Guest";
                }
                if (!paramArrayList2.equals(localObject1)) {
                    break label101;
                }
                i = 0;
                break label101;
                if (!((TapatalkForum) paramArrayList1.get(i)).getId().equals(localTapatalkForum.getId())) {
                }
                for (; ; ) {
                    i += 1;
                    break;
                    if ((!Util.isEmpty(((TapatalkForum) paramArrayList1.get(i)).getUserId())) && (!Util.isEmpty(localTapatalkForum.getUserId())) && ((!((TapatalkForum) paramArrayList1.get(i)).getUserId().equals("0")) || (!localTapatalkForum.getUserId().equals("0")))) {
                    }
                    for (int k = 0; ; k = 1) {
                        if (k != 0) {
                            break label557;
                        }
                        if (!((TapatalkForum) paramArrayList1.get(i)).getUserId().equals(localTapatalkForum.getUserId())) {
                            break label585;
                        }
                        j = i;
                        break;
                    }
                    if (!((TapatalkForum) paramArrayList1.get(i)).getUserNameOrDisplayName().equals(localTapatalkForum.getUserNameOrDisplayName())) {
                        break label585;
                    }
                    j = i;
                }
            }
            label588:
            continue;
            label590:
            paramArrayList2 = (TapatalkForum) paramArrayList1.get(j);
            this.helper.deleteFavoriate(paramArrayList2);
            deleteCurrenForums(paramArrayList2);
            paramArrayList1.remove(j);
        }
    }

    public ArrayList<TapatalkForum> manageLocalAndRemoteAccount(JSONArray paramJSONArray1, JSONArray paramJSONArray2) {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        int i = 0;
        label30:
        label70:
        ForumAccountBean localForumAccountBean;
        if (i >= paramJSONArray2.length()) {
            i = 0;
            if (i >= localArrayList2.size()) {
                paramJSONArray1 = new ArrayList();
                paramJSONArray2 = getDbAccount();
                i = 0;
                if (i < paramJSONArray2.size()) {
                    break label491;
                }
                paramJSONArray2 = getCacheAccount().iterator();
                if (paramJSONArray2.hasNext()) {
                    break label525;
                }
                if (paramJSONArray1.size() > 0) {
                    synLocalAccountsToServer(paramJSONArray1, localArrayList1.size());
                    localArrayList1.addAll(0, paramJSONArray1);
                    new SynchaAccountAction(this.activity).synchAccount(currentFroums);
                }
                return localArrayList1;
            }
        } else {
            try {
                localForumAccountBean = ForumAccountBean.getDataByJson((JSONObject) paramJSONArray2.get(i));
                if (Util.isEmpty(localForumAccountBean.username)) {
                }
                for (String str = localForumAccountBean.displayName; !Util.isSignOutUser(this.activity, localForumAccountBean.fid, localForumAccountBean.uid, str); str = localForumAccountBean.username) {
                    localArrayList2.add(localForumAccountBean);
                    break;
                }
                localForumAccountBean = (ForumAccountBean) localArrayList2.get(i);
            } catch (JSONException localJSONException) {
                localJSONException.printStackTrace();
            }
        }
        int j = 0;
        label231:
        label433:
        label491:
        label525:
        label573:
        for (; ; ) {
            if (j >= paramJSONArray1.length()) {
                i += 1;
                break label30;
            }
            try {
                JSONObject localJSONObject = paramJSONArray1.getJSONObject(j);
                int k = 0;
                if (localJSONObject.has("id")) {
                    k = Integer.parseInt((String) localJSONObject.get("id"));
                }
                if (k != ((ForumAccountBean) localArrayList2.get(i)).fid) {
                    break label573;
                }
                localObject = localForumAccountBean.username;
                paramJSONArray2 = (JSONArray) localObject;
                if (((String) localObject).equals("Guest")) {
                    paramJSONArray2 = "";
                }
                if (paramJSONArray2 != null) {
                    localObject = paramJSONArray2;
                    if (!paramJSONArray2.equals("")) {
                    }
                } else {
                    localObject = localForumAccountBean.displayName;
                }
                paramJSONArray2 = TapatalkForum.getForum(localJSONObject, (String) localObject, localForumAccountBean.use_au_email, localForumAccountBean.uid, localForumAccountBean.displayName);
                paramJSONArray2.setHide(Integer.valueOf(localForumAccountBean.hide));
                LocalFourmInformation2Forum(paramJSONArray2);
                if (localArrayList1.contains(paramJSONArray2)) {
                    break label231;
                }
                if ((!Util.isEmpty(paramJSONArray2.getUserNameOrDisplayName())) && (!paramJSONArray2.getUserNameOrDisplayName().equals("Guest"))) {
                    localArrayList1.add(paramJSONArray2);
                    break label231;
                }
                k = 1;
                localObject = localArrayList1.iterator();
                if (!((Iterator) localObject).hasNext()) {
                }
                while (k != 0) {
                    localArrayList1.add(paramJSONArray2);
                    break;
                    boolean bool = ((TapatalkForum) ((Iterator) localObject).next()).getId().equals(paramJSONArray2.getId());
                    if (!bool) {
                        break label433;
                    }
                    k = 0;
                }
                localObject = (TapatalkForum) paramJSONArray2.get(i);
                if (!localArrayList1.contains(localObject)) {
                    paramJSONArray1.add(localObject);
                }
                i += 1;
            } catch (Exception paramJSONArray2) {
                Object localObject;
                j += 1;
            }
            localObject = (TapatalkForum) paramJSONArray2.next();
            if ((localArrayList1.contains(localObject)) || (paramJSONArray1.contains(localObject))) {
                break label70;
            }
            paramJSONArray1.add(localObject);
            break label70;
            i += 1;
            break;
        }
    }

    public static abstract interface GetLocalAccountBack {
        public abstract void getLocalAccountBack(ArrayList<TapatalkForum> paramArrayList);
    }

    public static abstract interface GetRemoteAccountBack {
        public abstract void getAccountBack(ArrayList<TapatalkForum> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/TapatalkAccountAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */