package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.quoord.tapatalkpro.util.FakeX509TrustManager;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONObject;

public class AuInviteUserAction {
    private Activity mActivity;
    private AuInviteUserActionBack mCallback;
    private RequestQueue mQueue = null;

    public AuInviteUserAction(Activity paramActivity) {
        this.mActivity = paramActivity;
        this.mQueue = Volley.newRequestQueue(this.mActivity);
    }

    public void doAuInviteUser(String paramString, ArrayList<HashMap<String, String>> paramArrayList, HashMap<String, String> paramHashMap, AuInviteUserActionBack paramAuInviteUserActionBack) {
        if ((paramString == null) || (paramString.length() < 1) || (paramArrayList == null) || (paramArrayList.size() < 1) || (paramAuInviteUserActionBack == null) || (paramHashMap == null)) {
            this.mCallback.auInviteUserActionBack(false, "");
        }
        do {
            return;
            this.mCallback = paramAuInviteUserActionBack;
            if ((!paramHashMap.containsKey("forumid")) || (!paramHashMap.containsKey("userid")) || (!paramHashMap.containsKey("username")) || (!paramHashMap.containsKey("avatarUrl"))) {
                this.mCallback.auInviteUserActionBack(false, "");
                return;
            }
            paramAuInviteUserActionBack = null;
            try {
                localObject = URLEncoder.encode((String) paramHashMap.get("avatarUrl"), "utf-8");
                paramAuInviteUserActionBack = (AuInviteUserActionBack) localObject;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                for (; ; ) {
                    Object localObject;
                    localUnsupportedEncodingException.printStackTrace();
                    continue;
                    HashMap localHashMap = (HashMap) paramArrayList.next();
                    if ((localHashMap.containsKey("userid")) && (localHashMap.containsKey("username")) && (localHashMap.containsKey("enc_email"))) {
                        StringBuilder localStringBuilder = new StringBuilder("");
                        localStringBuilder.append("user[]=");
                        localStringBuilder.append(paramString);
                        localStringBuilder.append("|");
                        localStringBuilder.append((String) localHashMap.get("userid"));
                        localStringBuilder.append("|");
                        localStringBuilder.append((String) localHashMap.get("username"));
                        localStringBuilder.append("|");
                        localStringBuilder.append((String) localHashMap.get("enc_email"));
                        paramAuInviteUserActionBack.add(localStringBuilder.toString());
                    }
                }
                paramString = DirectoryUrlUtil.getAuInviteUserUrl(this.mActivity, paramAuInviteUserActionBack, paramHashMap);
                FakeX509TrustManager.allowAllSSL();
                paramString = new JsonObjectRequest(paramString, null, new Response.Listener()
                new Response.ErrorListener
                {
                    public void onResponse (JSONObject paramAnonymousJSONObject)
                    {
                        if (paramAnonymousJSONObject == null) {
                            AuInviteUserAction.this.mCallback.auInviteUserActionBack(false, "");
                            return;
                        }
                        try {
                            if (!paramAnonymousJSONObject.getBoolean("result")) {
                                AuInviteUserAction.this.mCallback.auInviteUserActionBack(false, "");
                                return;
                            }
                            AuInviteUserAction.this.mCallback.auInviteUserActionBack(true, "");
                            return;
                        } catch (Exception paramAnonymousJSONObject) {
                        }
                    }
                },new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError paramAnonymousVolleyError) {
                        Log.e("AuInviteuser", paramAnonymousVolleyError.getMessage(), paramAnonymousVolleyError);
                        AuInviteUserAction.this.mCallback.auInviteUserActionBack(false, paramAnonymousVolleyError.getMessage());
                    }
                });
                paramString.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0F));
                this.mQueue.add(paramString);
            }
        } while (paramAuInviteUserActionBack == null);
        localObject = new StringBuilder("");
        ((StringBuilder) localObject).append("inviter=");
        ((StringBuilder) localObject).append((String) paramHashMap.get("forumid"));
        ((StringBuilder) localObject).append("|");
        ((StringBuilder) localObject).append((String) paramHashMap.get("userid"));
        ((StringBuilder) localObject).append("|");
        ((StringBuilder) localObject).append((String) paramHashMap.get("username"));
        ((StringBuilder) localObject).append("|");
        ((StringBuilder) localObject).append(paramAuInviteUserActionBack);
        paramHashMap = ((StringBuilder) localObject).toString();
        paramAuInviteUserActionBack = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
            if (paramAuInviteUserActionBack.size() != 0) {
                break label438;
            }
            this.mCallback.auInviteUserActionBack(false, "");
        }
        label438:
    }

    public static abstract interface AuInviteUserActionBack {
        public abstract void auInviteUserActionBack(boolean paramBoolean, String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/AuInviteUserAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */