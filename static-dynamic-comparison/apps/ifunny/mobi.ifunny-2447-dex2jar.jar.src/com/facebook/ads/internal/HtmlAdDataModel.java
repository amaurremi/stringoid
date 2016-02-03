package com.facebook.ads.internal;

import android.content.Intent;
import android.os.Bundle;

import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HtmlAdDataModel
        implements AdDataModel {
    private static final String ACTIVATION_COMMAND_KEY = "activation_command";
    private static final String DETECTION_STRINGS_KEY = "detection_strings";
    private static final String INVALIDATION_BEHAVIOR_KEY = "invalidation_behavior";
    private static final String MARKUP_KEY = "markup";
    private final String activationCommand;
    private final Collection<String> detectionStrings;
    private final AdInvalidationBehavior invalidationBehavior;
    private final String markup;

    private HtmlAdDataModel(String paramString1, String paramString2, AdInvalidationBehavior paramAdInvalidationBehavior, Collection<String> paramCollection) {
        this.markup = paramString1;
        this.activationCommand = paramString2;
        this.invalidationBehavior = paramAdInvalidationBehavior;
        this.detectionStrings = paramCollection;
    }

    public static HtmlAdDataModel fromBundle(Bundle paramBundle) {
        return new HtmlAdDataModel(paramBundle.getString("markup"), paramBundle.getString("activation_command"), AdInvalidationBehavior.NONE, null);
    }

    public static HtmlAdDataModel fromIntentExtra(Intent paramIntent) {
        return new HtmlAdDataModel(paramIntent.getStringExtra("markup"), paramIntent.getStringExtra("activation_command"), AdInvalidationBehavior.NONE, null);
    }

    public static HtmlAdDataModel fromJSONObject(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            return null;
        }
        String str1 = paramJSONObject.optString("markup");
        String str2 = paramJSONObject.optString("activation_command");
        AdInvalidationBehavior localAdInvalidationBehavior = AdInvalidationBehavior.fromString(paramJSONObject.optString("invalidation_behavior"));
        try {
            paramJSONObject = new JSONArray(paramJSONObject.optString("detection_strings"));
            return new HtmlAdDataModel(str1, str2, localAdInvalidationBehavior, AdInvalidationUtils.parseDetectionStrings(paramJSONObject));
        } catch (JSONException paramJSONObject) {
            for (; ; ) {
                paramJSONObject.printStackTrace();
                paramJSONObject = null;
            }
        }
    }

    public void addToIntentExtra(Intent paramIntent) {
        paramIntent.putExtra("markup", this.markup);
        paramIntent.putExtra("activation_command", this.activationCommand);
    }

    public String getActivationCommand() {
        return this.activationCommand;
    }

    public Collection<String> getDetectionStrings() {
        return this.detectionStrings;
    }

    public AdInvalidationBehavior getInvalidationBehavior() {
        return this.invalidationBehavior;
    }

    public String getMarkup() {
        return this.markup;
    }

    public String getSendImpressionCommand() {
        return "facebookAd.sendImpression();";
    }

    public Bundle saveToBundle() {
        Bundle localBundle = new Bundle();
        localBundle.putString("markup", this.markup);
        return localBundle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/HtmlAdDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */