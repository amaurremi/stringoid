package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.Context;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;

public class TapatalkIdSignAction {
    private Activity activity;
    private TapatalkIdSignCallback signCallback;
    private TapatalkAjaxAction tapatalkAjaxAction;

    public TapatalkIdSignAction(Activity paramActivity) {
        this.activity = paramActivity;
        this.tapatalkAjaxAction = new TapatalkAjaxAction(this.activity);
    }

    public void signTapatalkId(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, TapatalkIdSignCallback paramTapatalkIdSignCallback) {
        this.signCallback = paramTapatalkIdSignCallback;
        paramContext = DirectoryUrlUtil.getSignUrl(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5);
        this.tapatalkAjaxAction.getJsonObjectAction(paramContext, new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                TapatalkIdSignAction.this.signCallback.signCallback();
            }
        });
    }

    public static abstract interface TapatalkIdSignCallback {
        public abstract void signCallback();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/TapatalkIdSignAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */