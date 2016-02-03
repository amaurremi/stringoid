package uk.co.a.a.b;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;

class i
        implements c {
    i(g paramg) {
    }

    public Context a(Activity paramActivity) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 14) {
            ActionBar localActionBar = paramActivity.getActionBar();
            localObject1 = localObject2;
            if (localActionBar != null) {
                localObject1 = localActionBar.getThemedContext();
            }
        }
        if (localObject1 == null) {
            return paramActivity;
        }
        return (Context) localObject1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/a/a/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */