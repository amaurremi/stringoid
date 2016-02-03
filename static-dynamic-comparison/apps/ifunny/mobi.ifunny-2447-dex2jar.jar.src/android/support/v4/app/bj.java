package android.support.v4.app;

import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.os.Parcelable;

import java.util.ArrayList;

class bj {
    private static Notification.Action a(bm parambm) {
        Notification.Action.Builder localBuilder = new Notification.Action.Builder(parambm.a(), parambm.b(), parambm.c()).addExtras(parambm.d());
        parambm = parambm.f();
        if (parambm != null) {
            parambm = cn.a(parambm);
            int j = parambm.length;
            int i = 0;
            while (i < j) {
                localBuilder.addRemoteInput(parambm[i]);
                i += 1;
            }
        }
        return localBuilder.build();
    }

    public static ArrayList<Parcelable> a(bm[] paramArrayOfbm) {
        Object localObject;
        if (paramArrayOfbm == null) {
            localObject = null;
            return (ArrayList<Parcelable>) localObject;
        }
        ArrayList localArrayList = new ArrayList(paramArrayOfbm.length);
        int j = paramArrayOfbm.length;
        int i = 0;
        for (; ; ) {
            localObject = localArrayList;
            if (i >= j) {
                break;
            }
            localArrayList.add(a(paramArrayOfbm[i]));
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */