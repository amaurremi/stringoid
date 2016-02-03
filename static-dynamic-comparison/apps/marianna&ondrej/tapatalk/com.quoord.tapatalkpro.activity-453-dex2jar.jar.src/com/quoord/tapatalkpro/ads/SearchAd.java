package com.quoord.tapatalkpro.ads;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.ads.search.SearchAdRequest.Builder;
import com.google.android.gms.ads.search.SearchAdView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.directory.ics.IcsSearchForumAdapter;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.net.JSONUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchAd {
    private Activity activity;
    private SearchAdView adView;
    private LinearLayout adViewContainer;
    private IcsSearchForumAdapter adapter;
    public boolean isAdViewBack = false;
    private String keyword;
    private String searchAdsKey;

    public SearchAd(Activity paramActivity, String paramString, IcsSearchForumAdapter paramIcsSearchForumAdapter) {
        this.activity = paramActivity;
        this.keyword = paramString;
        this.adapter = paramIcsSearchForumAdapter;
        if ((this.searchAdsKey == null) || (this.searchAdsKey.equals(""))) {
            getSearchAdAction();
            return;
        }
        getSearchView();
    }

    private int calculateDpToPx(Activity paramActivity, int paramInt) {
        float f = paramActivity.getResources().getDisplayMetrics().density;
        return (int) (paramInt * f + 0.5F);
    }

    public void getSearchAdAction() {
        String str1 = "https://pt.tapatalk.com/pt_get_ad.php?fid=google_search";
        Object localObject = TapatalkIdFactory.getTapatalkId(this.activity);
        if (((TapatalkId) localObject).getAuid() != -1) {
            str1 = "https://pt.tapatalk.com/pt_get_ad.php?fid=google_search" + "&au_id==" + ((TapatalkId) localObject).getAuid();
        }
        if (Util.googleAdsId != null) {
        }
        for (str1 = str1 + "&device_id=" + Util.googleAdsId; ; str1 = str1 + "&device_id=" + Util.getMD5(Util.getMacAddress(this.activity))) {
            localObject = "android";
            String str2 = "phone";
            if (Util.getDeviceSize(this.activity) >= 7.0D) {
                localObject = "pad";
                str2 = "pad";
            }
            str1 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str1)).append("&prx_agent=").append((String) localObject).append(Build.VERSION.SDK_INT).toString())).append("&").append(TapatalkApp.APP_KEY).toString() + "&device_type=" + str2;
            new TapatalkAjaxAction(this.activity).getJsonObjectAction(str1, new TapatalkAjaxAction.ActionCallBack() {
                public void actionCallBack(Object paramAnonymousObject) {
                    if (paramAnonymousObject != null) {
                    }
                    try {
                        paramAnonymousObject = new JSONUtil(((JSONObject) paramAnonymousObject).getJSONObject("Ad"));
                        SearchAd.this.searchAdsKey = ((JSONUtil) paramAnonymousObject).optString("Body");
                        SearchAd.this.getSearchView();
                        return;
                    } catch (JSONException paramAnonymousObject) {
                        ((JSONException) paramAnonymousObject).printStackTrace();
                    }
                }
            });
            return;
        }
    }

    public View getSearchView() {
        if (this.adViewContainer == null) {
            this.adViewContainer = ((LinearLayout) this.activity.getLayoutInflater().inflate(2130903051, null));
            this.adViewContainer.setVisibility(8);
            Util.setBg(this.adViewContainer, ThemeUtil.getBgDrawableByPicNameForList("list_item_bg_normal", this.activity, false));
            this.adView = new SearchAdView(this.activity);
            this.adView.setAdUnitId(this.searchAdsKey);
            this.adView.setAdSize(AdSize.BANNER);
            Object localObject = new ViewGroup.LayoutParams(-2, calculateDpToPx(this.activity, 80));
            this.adView.setLayoutParams((ViewGroup.LayoutParams) localObject);
            this.adView.setVisibility(8);
            this.adView.setAdListener(new AdListener() {
                public void onAdClosed() {
                    super.onAdClosed();
                }

                public void onAdFailedToLoad(int paramAnonymousInt) {
                    super.onAdFailedToLoad(paramAnonymousInt);
                    SearchAd.this.adViewContainer.setVisibility(8);
                    SearchAd.this.adView.setVisibility(8);
                }

                public void onAdLeftApplication() {
                    super.onAdLeftApplication();
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                    SearchAd.this.adViewContainer.setVisibility(0);
                    SearchAd.this.adView.setVisibility(0);
                    SearchAd.this.adapter.searchAdViewBack();
                    SearchAd.this.isAdViewBack = true;
                }

                public void onAdOpened() {
                    super.onAdOpened();
                }
            });
            if (SettingsFragment.isLightTheme(this.activity)) {
                localObject = new SearchAdRequest.Builder().setQuery(this.keyword).setBorderColor(this.activity.getResources().getColor(2131165503)).setBackgroundColor(this.activity.getResources().getColor(2131165503)).setHeaderTextColor(this.activity.getResources().getColor(2131165508)).setDescriptionTextColor(this.activity.getResources().getColor(2131165508)).setBorderThickness(5).build();
                this.adView.loadAd((SearchAdRequest) localObject);
                this.adViewContainer.addView(this.adView);
            }
            for (; ; ) {
                return this.adViewContainer;
                localObject = new SearchAdRequest.Builder().setQuery(this.keyword).setBorderColor(this.activity.getResources().getColor(2131165508)).setBackgroundColor(this.activity.getResources().getColor(2131165508)).setHeaderTextColor(this.activity.getResources().getColor(2131165503)).setDescriptionTextColor(this.activity.getResources().getColor(2131165503)).setBorderThickness(5).build();
                this.adView.loadAd((SearchAdRequest) localObject);
                this.adViewContainer.addView(this.adView);
            }
        }
        this.adViewContainer.invalidate();
        return this.adViewContainer;
    }

    public static abstract interface SearchAdViewBack {
        public abstract void searchAdViewBack();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ads/SearchAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */