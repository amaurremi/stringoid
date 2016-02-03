package mobi.ifunny.j;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.k;
import android.view.View;
import android.view.View.OnClickListener;
import mobi.ifunny.main.IFunnyMenuActivity;

public class a
        extends android.support.v4.app.g
        implements View.OnClickListener {
    public static a a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        a locala = new a();
        Bundle localBundle = new Bundle();
        localBundle.putString("TITLE_ARG", paramString1);
        localBundle.putString("TEXT_ARG", paramString2);
        localBundle.putString("MARKET_BTN_ARG_ARG", paramString3);
        localBundle.putString("NEVER_BTN_ARG", paramString4);
        localBundle.putString("LATER_BTN_ARG", paramString5);
        locala.setArguments(localBundle);
        return locala;
    }

    private void a(Activity paramActivity, String paramString1, String paramString2) {
        mobi.ifunny.b.g.a(paramActivity, paramString1, paramString2);
        if ((paramActivity instanceof IFunnyMenuActivity)) {
            mobi.ifunny.b.c.a((IFunnyMenuActivity) paramActivity, paramString1, paramString2);
        }
    }

    public Dialog a(Bundle paramBundle) {
        Object localObject = getArguments();
        paramBundle = ((Bundle) localObject).getString("TITLE_ARG");
        String str1 = ((Bundle) localObject).getString("TEXT_ARG");
        String str2 = ((Bundle) localObject).getString("MARKET_BTN_ARG_ARG");
        String str3 = ((Bundle) localObject).getString("NEVER_BTN_ARG");
        localObject = ((Bundle) localObject).getString("LATER_BTN_ARG");
        k localk = getActivity();
        return new AlertDialog.Builder(localk).setTitle(paramBundle).setMessage(str1).setPositiveButton(str2, new d(this, localk)).setNegativeButton(str3, new c(this, localk)).setNeutralButton((CharSequence) localObject, new b(this, localk)).create();
    }

    public void onClick(View paramView) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */