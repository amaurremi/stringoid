package com.uservoice.uservoicesdk;

import android.content.Context;
import android.content.Intent;
import com.uservoice.uservoicesdk.activity.ContactActivity;
import com.uservoice.uservoicesdk.activity.ForumActivity;
import com.uservoice.uservoicesdk.activity.PortalActivity;
import com.uservoice.uservoicesdk.activity.PostIdeaActivity;
import com.uservoice.uservoicesdk.babayaga.Babayaga;

import java.util.Map;

public class UserVoice {
    public static String getVersion() {
        return "1.1.0";
    }

    public static void init(Config paramConfig, Context paramContext) {
        Session.reset();
        Babayaga.init(paramContext);
        Babayaga.setUserTraits(paramConfig.getUserTraits());
        Session.getInstance().setContext(paramContext);
        Session.getInstance().setConfig(paramConfig);
    }

    public static void launchContactUs(Context paramContext) {
        paramContext.startActivity(new Intent(paramContext, ContactActivity.class));
    }

    public static void launchForum(Context paramContext) {
        paramContext.startActivity(new Intent(paramContext, ForumActivity.class));
    }

    public static void launchPostIdea(Context paramContext) {
        paramContext.startActivity(new Intent(paramContext, PostIdeaActivity.class));
    }

    public static void launchUserVoice(Context paramContext) {
        paramContext.startActivity(new Intent(paramContext, PortalActivity.class));
    }

    public static void setExternalId(String paramString1, String paramString2) {
        Session.getInstance().setExternalId(paramString1, paramString2);
    }

    public static void track(String paramString) {
        track(paramString, null);
    }

    public static void track(String paramString, Map<String, Object> paramMap) {
        Babayaga.track(paramString, paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/UserVoice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */