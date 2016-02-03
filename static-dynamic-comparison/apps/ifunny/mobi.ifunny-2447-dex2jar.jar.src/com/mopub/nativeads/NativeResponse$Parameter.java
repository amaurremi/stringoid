package com.mopub.nativeads;

import com.mopub.common.VisibleForTesting;

import java.util.HashSet;
import java.util.Set;

enum NativeResponse$Parameter {
    @VisibleForTesting
    static final Set<String>requiredKeys;
    final String name;
    final boolean required;

    static {
        int i = 0;
        IMPRESSION_TRACKER = new Parameter("IMPRESSION_TRACKER", 0, "imptracker", true);
        CLICK_TRACKER = new Parameter("CLICK_TRACKER", 1, "clktracker", true);
        TITLE = new Parameter("TITLE", 2, "title", false);
        TEXT = new Parameter("TEXT", 3, "text", false);
        MAIN_IMAGE = new Parameter("MAIN_IMAGE", 4, "mainimage", false);
        ICON_IMAGE = new Parameter("ICON_IMAGE", 5, "iconimage", false);
        CLICK_DESTINATION = new Parameter("CLICK_DESTINATION", 6, "clk", false);
        FALLBACK = new Parameter("FALLBACK", 7, "fallback", false);
        CALL_TO_ACTION = new Parameter("CALL_TO_ACTION", 8, "ctatext", false);
        STAR_RATING = new Parameter("STAR_RATING", 9, "starrating", false);
        $VALUES = new Parameter[]{IMPRESSION_TRACKER, CLICK_TRACKER, TITLE, TEXT, MAIN_IMAGE, ICON_IMAGE, CLICK_DESTINATION, FALLBACK, CALL_TO_ACTION, STAR_RATING};
        requiredKeys = new HashSet();
        Parameter[] arrayOfParameter = values();
        int j = arrayOfParameter.length;
        while (i < j) {
            Parameter localParameter = arrayOfParameter[i];
            if (localParameter.required) {
                requiredKeys.add(localParameter.name);
            }
            i += 1;
        }
    }

    private NativeResponse$Parameter(String paramString, boolean paramBoolean) {
        this.name = paramString;
        this.required = paramBoolean;
    }

    static Parameter from(String paramString) {
        Parameter[] arrayOfParameter = values();
        int j = arrayOfParameter.length;
        int i = 0;
        while (i < j) {
            Parameter localParameter = arrayOfParameter[i];
            if (localParameter.name.equals(paramString)) {
                return localParameter;
            }
            i += 1;
        }
        return null;
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/NativeResponse$Parameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */