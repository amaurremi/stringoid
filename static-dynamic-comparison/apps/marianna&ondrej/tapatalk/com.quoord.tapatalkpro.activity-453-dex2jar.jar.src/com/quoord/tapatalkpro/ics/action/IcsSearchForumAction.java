package com.quoord.tapatalkpro.ics.action;

import android.app.Activity;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.util.FakeX509TrustManager;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class IcsSearchForumAction {
    private Activity mActivity;
    private IcsSearchForumActionBack mCallBack;
    private RequestQueue mQueue = null;

    public IcsSearchForumAction(Activity paramActivity) {
        this.mActivity = paramActivity;
        this.mQueue = Volley.newRequestQueue(this.mActivity);
    }

    private void doDirectorySearch(String paramString) {
        FakeX509TrustManager.allowAllSSL();
        paramString = new JsonArrayRequest(paramString, new Response.Listener() new Response.ErrorListener
        {
            public void onResponse (JSONArray paramAnonymousJSONArray)
            {
                if (paramAnonymousJSONArray == null) {
                    IcsSearchForumAction.this.mCallBack.searchForumActionBack(null);
                    return;
                }
                new ArrayList();
                paramAnonymousJSONArray = IcsSearchForumAction.this.getSearchForumResult(paramAnonymousJSONArray);
                IcsSearchForumAction.this.mCallBack.searchForumActionBack(paramAnonymousJSONArray);
            }
        },new Response.ErrorListener() {
            public void onErrorResponse(VolleyError paramAnonymousVolleyError) {
                IcsSearchForumAction.this.mCallBack.searchForumActionBack(null);
            }
        });
        paramString.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0F));
        this.mQueue.add(paramString);
    }

    private ArrayList<TapatalkForumForSearch> getSearchForumResult(JSONArray paramJSONArray) {
        Object localObject = null;
        if (paramJSONArray == null) {
        }
        ArrayList localArrayList;
        for (; ; ) {
            return (ArrayList<TapatalkForumForSearch>) localObject;
            localArrayList = new ArrayList();
            int i = 0;
            localObject = localArrayList;
            try {
                if (i < paramJSONArray.length()) {
                    localArrayList.add(TapatalkForumForSearch.getForum(paramJSONArray.optJSONObject(i), null, null, null));
                    i += 1;
                }
            } catch (Exception paramJSONArray) {
            }
        }
        return localArrayList;
    }

    private ArrayList<TapatalkForumForSearch> getSearchForumResult(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
        }
        JSONArray localJSONArray1;
        do {
            do {
                return null;
            } while ((!paramJSONObject.has("forums")) && (!paramJSONObject.has("tapatalk_forums")));
            JSONArray localJSONArray2 = paramJSONObject.optJSONArray("tapatalk_forums");
            localJSONArray1 = localJSONArray2;
            if (localJSONArray2 != null) {
                break;
            }
            localJSONArray1 = paramJSONObject.optJSONArray("forums");
        } while (localJSONArray1 == null);
        return getSearchForumResult(localJSONArray1);
    }

    public void directorySearchForum(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, IcsSearchForumActionBack paramIcsSearchForumActionBack) {
        if ((paramString == null) || (paramString.length() == 0) || (paramIcsSearchForumActionBack == null)) {
            return;
        }
        this.mCallBack = paramIcsSearchForumActionBack;
        doDirectorySearch(DirectoryUrlUtil.createSearchForumsURL(this.mActivity, paramString, paramInt1));
    }

    public void directoryUrlMatchSearchForum(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, IcsSearchForumActionBack paramIcsSearchForumActionBack) {
        if ((paramString == null) || (paramString.length() == 0) || (paramIcsSearchForumActionBack == null)) {
            return;
        }
        this.mCallBack = paramIcsSearchForumActionBack;
        paramIcsSearchForumActionBack = DirectoryUrlUtil.createSearchForumsURL(this.mActivity, paramString, paramInt1);
        paramString = paramIcsSearchForumActionBack;
        if (paramBoolean2) {
            paramString = paramIcsSearchForumActionBack + "&tapstream=1";
        }
        doDirectorySearch(paramString + "&type=url_match");
    }

    public void icsSearchForum(final String paramString, final int paramInt1, final int paramInt2, final boolean paramBoolean, final IcsSearchForumActionBack paramIcsSearchForumActionBack) {
        if ((paramString == null) || (paramString.length() == 0) || (paramIcsSearchForumActionBack == null)) {
            return;
        }
        this.mCallBack = paramIcsSearchForumActionBack;
        String str = DirectoryUrlUtil.getIcsSearchForumUrl(this.mActivity, paramString, paramInt1, paramInt2, paramBoolean);
        FakeX509TrustManager.allowAllSSL();
        paramString = new JsonObjectRequest(str, null, new Response.Listener() new Response.ErrorListener
        {
            public void onResponse (JSONObject paramAnonymousJSONObject)
            {
                if (paramAnonymousJSONObject == null) {
                    IcsSearchForumAction.this.directorySearchForum(paramString, paramInt1, paramInt2, paramBoolean, paramIcsSearchForumActionBack);
                    return;
                }
                new ArrayList();
                paramAnonymousJSONObject = IcsSearchForumAction.this.getSearchForumResult(paramAnonymousJSONObject);
                IcsSearchForumAction.this.mCallBack.searchForumActionBack(paramAnonymousJSONObject);
            }
        },new Response.ErrorListener() {
            public void onErrorResponse(VolleyError paramAnonymousVolleyError) {
                IcsSearchForumAction.this.directorySearchForum(paramString, paramInt1, paramInt2, paramBoolean, paramIcsSearchForumActionBack);
            }
        });
        paramString.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0F));
        this.mQueue.add(paramString);
    }

    public static abstract interface IcsSearchForumActionBack {
        public abstract void searchForumActionBack(ArrayList<TapatalkForumForSearch> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/action/IcsSearchForumAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */