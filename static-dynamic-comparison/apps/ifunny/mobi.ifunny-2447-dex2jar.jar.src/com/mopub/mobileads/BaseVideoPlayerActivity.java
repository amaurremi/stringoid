package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;

class BaseVideoPlayerActivity
        extends Activity {
    static final String VIDEO_CLASS_EXTRAS_KEY = "video_view_class_name";
    static final String VIDEO_URL = "video_url";

    static Intent createIntentMraid(Context paramContext, String paramString, AdConfiguration paramAdConfiguration) {
        paramContext = new Intent(paramContext, MraidVideoPlayerActivity.class);
        paramContext.setFlags(268435456);
        paramContext.putExtra("video_view_class_name", "mraid");
        paramContext.putExtra("video_url", paramString);
        paramContext.putExtra("Ad-Configuration", paramAdConfiguration);
        return paramContext;
    }

    static Intent createIntentVast(Context paramContext, VastVideoConfiguration paramVastVideoConfiguration, AdConfiguration paramAdConfiguration) {
        paramContext = new Intent(paramContext, MraidVideoPlayerActivity.class);
        paramContext.setFlags(268435456);
        paramContext.putExtra("video_view_class_name", "vast");
        paramContext.putExtra("vast_video_configuration", paramVastVideoConfiguration);
        paramContext.putExtra("Ad-Configuration", paramAdConfiguration);
        return paramContext;
    }

    static void startMraid(Context paramContext, String paramString, AdConfiguration paramAdConfiguration) {
        paramString = createIntentMraid(paramContext, paramString, paramAdConfiguration);
        try {
            paramContext.startActivity(paramString);
            return;
        } catch (ActivityNotFoundException paramContext) {
            MoPubLog.d("Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    static void startVast(Context paramContext, VastVideoConfiguration paramVastVideoConfiguration, AdConfiguration paramAdConfiguration) {
        paramVastVideoConfiguration = createIntentVast(paramContext, paramVastVideoConfiguration, paramAdConfiguration);
        try {
            paramContext.startActivity(paramVastVideoConfiguration);
            return;
        } catch (ActivityNotFoundException paramContext) {
            MoPubLog.d("Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/BaseVideoPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */