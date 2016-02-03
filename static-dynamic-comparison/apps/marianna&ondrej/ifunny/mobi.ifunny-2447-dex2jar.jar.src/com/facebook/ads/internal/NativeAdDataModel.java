package com.facebook.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.NativeAd.Rating;
import com.facebook.ads.internal.action.AdAction;
import com.facebook.ads.internal.action.AdActionFactory;

import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeAdDataModel
        implements AdDataModel {
    private static final String TAG = NativeAdDataModel.class.getSimpleName();
    private final Uri adCommand;
    private final String body;
    private final String callToAction;
    private boolean clickLogged;
    private final String clickReportUrl;
    private final Collection<String> detectionStrings;
    private final NativeAd.Image icon;
    private final NativeAd.Image image;
    private boolean impressionLogged;
    private final String impressionReportUrl;
    private final AdInvalidationBehavior invalidationBehavior;
    private final String socialContext;
    private final NativeAd.Rating starRating;
    private final String title;

    private NativeAdDataModel(Uri paramUri, String paramString1, String paramString2, String paramString3, String paramString4, NativeAd.Image paramImage1, NativeAd.Image paramImage2, NativeAd.Rating paramRating, String paramString5, String paramString6, AdInvalidationBehavior paramAdInvalidationBehavior, Collection<String> paramCollection) {
        this.adCommand = paramUri;
        this.title = paramString1;
        this.body = paramString2;
        this.callToAction = paramString3;
        this.socialContext = paramString4;
        this.icon = paramImage1;
        this.image = paramImage2;
        this.starRating = paramRating;
        this.impressionReportUrl = paramString5;
        this.clickReportUrl = paramString6;
        this.invalidationBehavior = paramAdInvalidationBehavior;
        this.detectionStrings = paramCollection;
    }

    public static NativeAdDataModel fromJSONObject(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            return null;
        }
        Uri localUri = Uri.parse(paramJSONObject.optString("fbad_command"));
        String str1 = paramJSONObject.optString("title");
        String str2 = paramJSONObject.optString("body");
        String str3 = paramJSONObject.optString("call_to_action");
        String str4 = paramJSONObject.optString("social_context");
        NativeAd.Image localImage1 = NativeAd.Image.fromJSONObject(paramJSONObject.optJSONObject("icon"));
        NativeAd.Image localImage2 = NativeAd.Image.fromJSONObject(paramJSONObject.optJSONObject("image"));
        NativeAd.Rating localRating = NativeAd.Rating.fromJSONObject(paramJSONObject.optJSONObject("star_rating"));
        String str5 = paramJSONObject.optString("impression_report_url");
        String str6 = paramJSONObject.optString("click_report_url");
        AdInvalidationBehavior localAdInvalidationBehavior = AdInvalidationBehavior.fromString(paramJSONObject.optString("invalidation_behavior"));
        try {
            paramJSONObject = new JSONArray(paramJSONObject.optString("detection_strings"));
            return new NativeAdDataModel(localUri, str1, str2, str3, str4, localImage1, localImage2, localRating, str5, str6, localAdInvalidationBehavior, AdInvalidationUtils.parseDetectionStrings(paramJSONObject));
        } catch (JSONException paramJSONObject) {
            for (; ; ) {
                paramJSONObject.printStackTrace();
                paramJSONObject = null;
            }
        }
    }

    public String getBody() {
        return this.body;
    }

    public String getCallToAction() {
        return this.callToAction;
    }

    public Collection<String> getDetectionStrings() {
        return this.detectionStrings;
    }

    public NativeAd.Image getIcon() {
        return this.icon;
    }

    public NativeAd.Image getImage() {
        return this.image;
    }

    public AdInvalidationBehavior getInvalidationBehavior() {
        return this.invalidationBehavior;
    }

    public String getSocialContext() {
        return this.socialContext;
    }

    public NativeAd.Rating getStarRating() {
        return this.starRating;
    }

    public String getTitle() {
        return this.title;
    }

    public void handleClick(Context paramContext) {
        if (!this.clickLogged) {
            new OpenUrlTask().execute(new String[]{this.clickReportUrl});
            this.clickLogged = true;
        }
        paramContext = AdActionFactory.getAdAction(paramContext, this.adCommand);
        if (paramContext != null) {
        }
        try {
            paramContext.execute();
            return;
        } catch (Exception paramContext) {
            Log.e(TAG, "Error executing action", paramContext);
        }
    }

    public boolean isValid() {
        return (this.title != null) && (this.title.length() > 0) && (this.callToAction != null) && (this.callToAction.length() > 0) && (this.icon != null) && (this.image != null);
    }

    public void logImpression() {
        if (!this.impressionLogged) {
            new OpenUrlTask().execute(new String[]{this.impressionReportUrl});
            this.impressionLogged = true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/NativeAdDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */