package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.j;
import android.view.View;

class e
        extends b {
    public j a(Object paramObject, View paramView) {
        paramObject = k.a(paramObject, paramView);
        if (paramObject != null) {
            return new j(paramObject);
        }
        return null;
    }

    public Object a(a parama) {
        return k.a(new f(this, parama));
    }

    public boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle) {
        return k.a(paramObject, paramView, paramInt, paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */