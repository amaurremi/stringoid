package com.quoord.tapatalkpro.action;

import android.content.Context;
import com.google.android.gcm.GCMRegistrar;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.TapatalkAjaxLogAction;

public class InitGcmTool {
    private Context context;

    public InitGcmTool(Context paramContext) {
        this.context = paramContext;
    }

    public void initGcm() {
        try {
            GCMRegistrar.checkDevice(this.context);
            GCMRegistrar.checkManifest(this.context);
            if (GCMRegistrar.getRegistrationId(this.context).equals("")) {
                GCMRegistrar.register(this.context, new String[]{"608452217441"});
                return;
            }
            if (!GCMRegistrar.isRegisteredOnServer(this.context)) {
                String str = DirectoryUrlUtil.getRegistTokenUrl(this.context);
                new TapatalkAjaxLogAction(this.context).logTapatalkLog(str);
                return;
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/InitGcmTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */