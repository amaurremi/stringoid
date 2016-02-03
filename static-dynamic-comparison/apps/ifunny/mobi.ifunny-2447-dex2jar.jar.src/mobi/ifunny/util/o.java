package mobi.ifunny.util;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.plus.i;

public class o {
    public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramActivity) != 0) {
            ai.b(paramActivity, paramString1, paramString2);
            return;
        }
        paramActivity.startActivityForResult(new i(paramActivity).a("text/plain").a(paramString3).a(Uri.parse(paramString4)).a(), 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */