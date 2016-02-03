package mobi.ifunny.i;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;

public class b {
    public static void a(Context paramContext, String paramString1, String paramString2) {
        paramContext = new AlertDialog.Builder(paramContext);
        paramContext.setTitle(paramString1);
        paramContext.setMessage(paramString2);
        paramContext.create().show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */