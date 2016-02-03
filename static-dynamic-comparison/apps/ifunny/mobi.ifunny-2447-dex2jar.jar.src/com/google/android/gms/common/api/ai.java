package com.google.android.gms.common.api;

import android.content.IntentSender.SendIntentException;
import android.support.v4.app.k;
import android.support.v4.app.q;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;

import java.util.List;

class ai
        implements Runnable {
    private final int b;
    private final a c;

    public ai(ae paramae, int paramInt, a parama) {
        this.b = paramInt;
        this.c = parama;
    }

    public void run() {
        if (this.c.a()) {
            try {
                int i = this.a.getActivity().f().c().indexOf(this.a);
                this.c.a(this.a.getActivity(), (i + 1 << 16) + 1);
                return;
            } catch (IntentSender.SendIntentException localSendIntentException) {
                ae.a(this.a);
                return;
            }
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(this.c.c())) {
            GooglePlayServicesUtil.showErrorDialogFragment(this.c.c(), this.a.getActivity(), this.a, 2, this.a);
            return;
        }
        ae.a(this.a, this.b, this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */