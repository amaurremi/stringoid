package android.support.v4.app;

import android.view.View;

class h
        implements p {
    h(Fragment paramFragment) {
    }

    public View a(int paramInt) {
        if (this.a.mView == null) {
            throw new IllegalStateException("Fragment does not have a view");
        }
        return this.a.mView.findViewById(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */