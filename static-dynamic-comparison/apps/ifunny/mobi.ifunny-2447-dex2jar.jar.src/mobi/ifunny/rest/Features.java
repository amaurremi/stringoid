package mobi.ifunny.rest;

import java.util.HashSet;
import java.util.Set;

import mobi.ifunny.b.c;

public class Features {
    private static final String FEATURE_HIDE_NEW_COMMS_SMILES = "hide_new_comms_smiles";
    private static final String FEATURE_IFUNNY_STATS = "ifunny_stats";
    private static final String FEATURE_MEANWHILE_IN_COLLECTIVE = "meanwhile_in_collective";
    private static final String FEATURE_PROFILE_AD = "profile_ad";
    private static final String FEATURE_RATE_APP = "rate_app";
    private static final long UPDATE_TIMEOUT = 1200000L;
    private static Features instance = new Features();
    private static long loadedTimestamp;
    private Set<String> features = new HashSet();
    private Features.FeaturesParams params;

    public static Integer getHideNewCommentsSmilesInterval() {
        if ((instance.params != null) && (instance.params.hide_new_comms_smiles != null)) {
            return Integer.valueOf(instance.params.hide_new_comms_smiles.for_secs);
        }
        return null;
    }

    public static Integer getInnerStatDispatchInterval() {
        if ((instance.params != null) && (instance.params.ifunny_stats != null)) {
            return Integer.valueOf(instance.params.ifunny_stats.dispatch_interval);
        }
        return null;
    }

    public static Features.RateThisAppParams getRateThisAppParams() {
        if ((instance.params != null) && (instance.params.rate_app != null)) {
            return instance.params.rate_app;
        }
        return null;
    }

    public static boolean isHideNewCommentsSmilesTurnedOn() {
        return instance.features.contains("hide_new_comms_smiles");
    }

    public static boolean isInnerStatTurnedOn() {
        return instance.features.contains("ifunny_stats");
    }

    public static boolean isMeanwhileTurnedOn() {
        return instance.features.contains("meanwhile_in_collective");
    }

    public static boolean isProfileAdsEnabled() {
        return instance.features.contains("profile_ad");
    }

    public static boolean isRateThisAppTurnedOn() {
        return instance.features.contains("rate_app");
    }

    public static boolean isUpdateNeeded() {
        return System.currentTimeMillis() - loadedTimestamp >= 1200000L;
    }

    public static void set(Features paramFeatures) {
        instance = paramFeatures;
        loadedTimestamp = System.currentTimeMillis();
        paramFeatures = getInnerStatDispatchInterval();
        if (paramFeatures != null) {
            c.a(paramFeatures.intValue());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/Features.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */