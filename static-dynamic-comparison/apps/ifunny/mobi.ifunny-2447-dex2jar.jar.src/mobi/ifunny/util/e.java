package mobi.ifunny.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class e {
    public static void a(Context paramContext, String paramString) {
        ((ClipboardManager) paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("IFunny", paramString));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */