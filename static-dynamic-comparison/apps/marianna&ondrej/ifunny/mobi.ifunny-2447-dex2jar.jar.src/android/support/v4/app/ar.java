package android.support.v4.app;

import android.app.Notification;
import android.os.Build.VERSION;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Iterator;

public class ar {
    private static final az a = new bb();

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            a = new ba();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a = new bg();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            a = new bf();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            a = new be();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            a = new bd();
            return;
        }
        if (Build.VERSION.SDK_INT >= 9) {
            a = new bc();
            return;
        }
    }

    public static Bundle a(Notification paramNotification) {
        return a.a(paramNotification);
    }

    private static void b(ap paramap, ArrayList<as> paramArrayList) {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
            paramap.a((as) paramArrayList.next());
        }
    }

    private static void b(aq paramaq, bh parambh) {
        if (parambh != null) {
            if (!(parambh instanceof av)) {
                break label37;
            }
            parambh = (av) parambh;
            br.a(paramaq, parambh.e, parambh.g, parambh.f, parambh.a);
        }
        label37:
        do {
            return;
            if ((parambh instanceof ay)) {
                parambh = (ay) parambh;
                br.a(paramaq, parambh.e, parambh.g, parambh.f, parambh.a);
                return;
            }
        } while (!(parambh instanceof au));
        parambh = (au) parambh;
        br.a(paramaq, parambh.e, parambh.g, parambh.f, parambh.a, parambh.b, parambh.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */