package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.Intent;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.newonboarding.ObEntryActivity;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.directory.ics.FavForumsFragment;
import com.quoord.tapatalkpro.adapter.directory.FavoriteForumAdapter;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Base64;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.net.URLDecoder;
import java.security.KeyStore;
import java.util.ArrayList;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONObject;

public class GetAccountBybyoAction {
    private ArrayList<String> DisplayNameList = new ArrayList();
    private AQuery aq = null;
    private String byoChannel;
    private FavForumsFragment favforumFragment;
    private String fid = "";
    private ArrayList<String> fidList = new ArrayList();
    private String getAccountUrl = null;
    private Activity mActivity;
    private ArrayList<String> passwordList = new ArrayList();
    private String rid = "";
    private ArrayList<String> ridList = new ArrayList();
    private ArrayList<String> uidList = new ArrayList();
    private ArrayList<String> userNameList = new ArrayList();

    public GetAccountBybyoAction(Activity paramActivity, FavForumsFragment paramFavForumsFragment, String paramString) {
        this.mActivity = paramActivity;
        this.byoChannel = paramString;
        this.aq = new AQuery(this.mActivity);
        this.favforumFragment = paramFavForumsFragment;
    }

    public void callGetAccount() {
        try {
            MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            localMySSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            AjaxCallback local1 = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                    int i;
                    if (paramAnonymousJSONObject != null) {
                        i = 0;
                    }
                    for (; ; ) {
                        try {
                            if (i >= GetAccountBybyoAction.this.fidList.size()) {
                                return;
                            }
                            paramAnonymousString = TapatalkForum.getForum((JSONObject) paramAnonymousJSONObject.get((String) GetAccountBybyoAction.this.fidList.get(i)), null, null, null);
                            paramAnonymousString.setFromByoAccountChannel(GetAccountBybyoAction.this.byoChannel);
                            if ((GetAccountBybyoAction.this.userNameList != null) && (GetAccountBybyoAction.this.userNameList.size() > 0) && (GetAccountBybyoAction.this.userNameList.get(i) != null) && (!((String) GetAccountBybyoAction.this.userNameList.get(i)).equals(""))) {
                                paramAnonymousString.setUserName(URLDecoder.decode((String) GetAccountBybyoAction.this.userNameList.get(i), "utf-8"));
                            }
                            if ((GetAccountBybyoAction.this.DisplayNameList != null) && (GetAccountBybyoAction.this.DisplayNameList.size() > 0) && (GetAccountBybyoAction.this.DisplayNameList.get(i) != null) && (!((String) GetAccountBybyoAction.this.DisplayNameList.get(i)).equals(""))) {
                                paramAnonymousString.setDisplayName(URLDecoder.decode((String) GetAccountBybyoAction.this.DisplayNameList.get(i), "utf-8"));
                            }
                            if ((GetAccountBybyoAction.this.passwordList != null) && (GetAccountBybyoAction.this.passwordList.size() > 0) && (GetAccountBybyoAction.this.passwordList.get(i) != null) && (!((String) GetAccountBybyoAction.this.passwordList.get(i)).equals(""))) {
                                paramAnonymousString.setPassword(new String(Base64.decode((String) GetAccountBybyoAction.this.passwordList.get(i))).toString());
                            }
                            if ((GetAccountBybyoAction.this.uidList != null) && (GetAccountBybyoAction.this.uidList.size() > 0) && (GetAccountBybyoAction.this.uidList.get(i) != null) && (!((String) GetAccountBybyoAction.this.uidList.get(i)).equals(""))) {
                                paramAnonymousString.setUserId((String) GetAccountBybyoAction.this.uidList.get(i));
                            }
                            Util.updateByoAccount(GetAccountBybyoAction.this.mActivity, paramAnonymousString);
                            if ((GetAccountBybyoAction.this.favforumFragment == null) || (GetAccountBybyoAction.this.favforumFragment.mNetworkAdapter == null)) {
                                break label755;
                            }
                            paramAnonymousAjaxStatus = new FavoriateSqlHelper(GetAccountBybyoAction.this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivate();
                            if ((GetAccountBybyoAction.this.favforumFragment.mNetworkAdapter.localDatas.size() <= 0) && (paramAnonymousAjaxStatus.size() <= 0)) {
                                paramAnonymousString = new Intent(GetAccountBybyoAction.this.mActivity, ObEntryActivity.class);
                                GetAccountBybyoAction.this.mActivity.startActivity(paramAnonymousString);
                                GetAccountBybyoAction.this.mActivity.finish();
                            } else {
                                if (!GetAccountBybyoAction.this.favforumFragment.mNetworkAdapter.localDatas.contains(paramAnonymousString)) {
                                    GetAccountBybyoAction.this.favforumFragment.mNetworkAdapter.localDatas.add(0, paramAnonymousString);
                                }
                                GetAccountBybyoAction.this.favforumFragment.mNetworkAdapter.notifyDataSetChanged();
                            }
                        } catch (Exception paramAnonymousString) {
                            paramAnonymousString.printStackTrace();
                            return;
                        }
                        if ((GetAccountBybyoAction.this.favforumFragment != null) && (GetAccountBybyoAction.this.favforumFragment.mNetworkAdapter != null)) {
                            if (GetAccountBybyoAction.this.favforumFragment.mNetworkAdapter.localDatas.size() <= 0) {
                                paramAnonymousString = new Intent(GetAccountBybyoAction.this.mActivity, ObEntryActivity.class);
                                GetAccountBybyoAction.this.mActivity.startActivity(paramAnonymousString);
                                GetAccountBybyoAction.this.mActivity.finish();
                            }
                        } else if (new FavoriateSqlHelper(GetAccountBybyoAction.this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivate().size() <= 0) {
                            paramAnonymousString = new Intent(GetAccountBybyoAction.this.mActivity, ObEntryActivity.class);
                            GetAccountBybyoAction.this.mActivity.startActivity(paramAnonymousString);
                            GetAccountBybyoAction.this.mActivity.finish();
                        }
                        return;
                        label755:
                        i += 1;
                    }
                }
            };
            AjaxCallback.setSSF(localMySSLSocketFactory);
            AjaxCallback.setTimeout(10000);
            this.aq.ajax(this.getAccountUrl, JSONObject.class, local1);
            return;
        } catch (Exception localException) {
        }
    }

    public String parseByoAccountInfo(String paramString) {
        String[] arrayOfString1;
        int i;
        if (paramString.contains("?")) {
            paramString = paramString.split("\\?");
            this.rid = paramString[0].split("\\=")[1];
            if (paramString.length <= 1) {
                return null;
            }
            paramString = paramString[1];
            if (!paramString.contains("&")) {
                break label511;
            }
            arrayOfString1 = paramString.split("\\&");
            i = 0;
            if (i < arrayOfString1.length) {
                break label141;
            }
        }
        for (; ; ) {
            i = 0;
            if (i < this.fidList.size()) {
                break label853;
            }
            this.getAccountUrl = (TapatalkJsonEngine.GET_FORUM_BY_BYO_ACCOUNT + "?rid=" + this.rid + "&fid=" + this.fid + "&" + TapatalkApp.APP_KEY);
            return this.getAccountUrl;
            label141:
            Object localObject = arrayOfString1[i];
            int j;
            if (paramString.contains(",")) {
                localObject = ((String) localObject).split("\\,");
                j = 0;
                label167:
                if (j < localObject.length) {
                }
            }
            for (; ; ) {
                i += 1;
                break;
                String[] arrayOfString2;
                if (localObject[j].contains("fid=")) {
                    arrayOfString2 = localObject[j].split("fid=");
                    this.fidList.add(arrayOfString2[1]);
                }
                if (localObject[j].contains("uid=")) {
                    arrayOfString2 = localObject[j].split("uid=");
                    this.uidList.add(arrayOfString2[1]);
                }
                if (localObject[j].contains("un=")) {
                    arrayOfString2 = localObject[j].split("un=");
                    this.userNameList.add(arrayOfString2[1]);
                }
                if (localObject[j].contains("pw=")) {
                    arrayOfString2 = localObject[j].split("pw=");
                    this.passwordList.add(arrayOfString2[1]);
                }
                if (localObject[j].contains("udn=")) {
                    arrayOfString2 = localObject[j].split("udn=");
                    this.DisplayNameList.add(arrayOfString2[1]);
                }
                j += 1;
                break label167;
                if (paramString.contains("fid=")) {
                    localObject = paramString.split("fid=");
                    this.fidList.add(localObject[1]);
                }
                if (paramString.contains("uid=")) {
                    localObject = paramString.split("uid=");
                    this.uidList.add(localObject[1]);
                }
                if (paramString.contains("un=")) {
                    localObject = paramString.split("un=");
                    this.userNameList.add(localObject[1]);
                }
                if (paramString.contains("pw=")) {
                    localObject = paramString.split("pw=");
                    this.passwordList.add(localObject[1]);
                }
                if (paramString.contains("udn=")) {
                    localObject = paramString.split("udn=");
                    this.DisplayNameList.add(localObject[1]);
                }
            }
            label511:
            if (paramString.contains(",")) {
                paramString = paramString.split("\\,");
                i = 0;
                while (i < paramString.length) {
                    if (paramString[i].contains("fid=")) {
                        arrayOfString1 = paramString[i].split("fid=");
                        this.fidList.add(arrayOfString1[1]);
                    }
                    if (paramString[i].contains("uid=")) {
                        arrayOfString1 = paramString[i].split("uid=");
                        this.uidList.add(arrayOfString1[1]);
                    }
                    if (paramString[i].contains("un=")) {
                        arrayOfString1 = paramString[i].split("un=");
                        this.userNameList.add(arrayOfString1[1]);
                    }
                    if (paramString[i].contains("pw=")) {
                        arrayOfString1 = paramString[i].split("pw=");
                        this.passwordList.add(arrayOfString1[1]);
                    }
                    if (paramString[i].contains("udn=")) {
                        arrayOfString1 = paramString[i].split("udn=");
                        this.DisplayNameList.add(arrayOfString1[1]);
                    }
                    i += 1;
                }
            } else {
                if (paramString.contains("fid=")) {
                    arrayOfString1 = paramString.split("fid=");
                    this.fidList.add(arrayOfString1[1]);
                }
                if (paramString.contains("uid=")) {
                    arrayOfString1 = paramString.split("uid=");
                    this.uidList.add(arrayOfString1[1]);
                }
                if (paramString.contains("un=")) {
                    arrayOfString1 = paramString.split("un=");
                    this.userNameList.add(arrayOfString1[1]);
                }
                if (paramString.contains("pw=")) {
                    arrayOfString1 = paramString.split("pw=");
                    this.passwordList.add(arrayOfString1[1]);
                }
                if (paramString.contains("udn=")) {
                    paramString = paramString.split("udn=");
                    this.DisplayNameList.add(paramString[1]);
                }
            }
        }
        label853:
        if (i < this.fidList.size() - 1) {
        }
        for (this.fid = (this.fid + (String) this.fidList.get(i) + ","); ; this.fid += (String) this.fidList.get(i)) {
            i += 1;
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/GetAccountBybyoAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */