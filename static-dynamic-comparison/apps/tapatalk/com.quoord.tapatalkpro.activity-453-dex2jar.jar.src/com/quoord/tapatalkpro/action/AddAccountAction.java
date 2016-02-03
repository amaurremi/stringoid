package com.quoord.tapatalkpro.action;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;

import java.net.URLEncoder;

public class AddAccountAction {
    public static void auAddAccount(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        auAddAccount(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, "");
    }

    public static void auAddAccount(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        if (!paramContext.getResources().getBoolean(2131558401)) {
            boolean bool = Prefs.get(paramContext).getBoolean("login", false);
            int i = Prefs.get(paramContext).getInt("tapatalk_auid", -1);
            if ((bool) && (i >= 0)) {
                String str2 = Prefs.get(paramContext).getString("token", "");
                String str1 = paramString5;
                if (paramString5 == null) {
                    str1 = "0";
                }
                paramString5 = TapatalkJsonEngine.AU_ADD_ACCOUNT + "?au_id=" + i + "&token=" + str2 + "&fid=" + paramString1 + "&use_au_email=" + str1;
                paramString1 = paramString5;
                if (paramString2 != null) {
                    paramString1 = paramString5 + "&username=" + URLEncoder.encode(paramString2);
                }
                paramString2 = paramString1;
                if (paramString3 != null) {
                    paramString2 = paramString1 + "&display_name=" + paramString3;
                }
                paramString1 = paramString2;
                if (paramString4 != null) {
                    paramString1 = paramString2 + "&uid=" + paramString4;
                }
                paramString2 = paramString1;
                if (paramString6 != null) {
                    paramString2 = paramString1 + "&channel=" + paramString6;
                }
                paramString1 = paramString2;
                if (paramString7 != null) {
                    paramString1 = paramString2;
                    if (!paramString7.equals("")) {
                        paramString1 = paramString2 + "&email=" + paramString7;
                    }
                }
                TapatalkJsonEngine.callLogin(paramContext, paramString1);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/AddAccountAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */