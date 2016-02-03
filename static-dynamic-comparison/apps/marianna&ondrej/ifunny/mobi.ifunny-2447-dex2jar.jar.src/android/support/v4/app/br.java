package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class br {
    private static final Object a = new Object();
    private static Field b;
    private static boolean c;
    private static final Object d = new Object();

    public static Bundle a(Notification.Builder paramBuilder, bm parambm) {
        paramBuilder.addAction(parambm.a(), parambm.b(), parambm.c());
        paramBuilder = new Bundle(parambm.d());
        if (parambm.f() != null) {
            paramBuilder.putParcelableArray("android.support.remoteInputs", cr.a(parambm.f()));
        }
        return paramBuilder;
    }

    public static Bundle a(Notification paramNotification) {
        Object localObject1;
        Bundle localBundle;
        synchronized (a) {
            if (c) {
                return null;
            }
        }
    }

    private static Bundle a(bm parambm) {
        Bundle localBundle = new Bundle();
        localBundle.putInt("icon", parambm.a());
        localBundle.putCharSequence("title", parambm.b());
        localBundle.putParcelable("actionIntent", parambm.c());
        localBundle.putBundle("extras", parambm.d());
        localBundle.putParcelableArray("remoteInputs", cr.a(parambm.f()));
        return localBundle;
    }

    public static SparseArray<Bundle> a(List<Bundle> paramList) {
        Object localObject1 = null;
        int j = paramList.size();
        int i = 0;
        while (i < j) {
            Bundle localBundle = (Bundle) paramList.get(i);
            Object localObject2 = localObject1;
            if (localBundle != null) {
                localObject2 = localObject1;
                if (localObject1 == null) {
                    localObject2 = new SparseArray();
                }
                ((SparseArray) localObject2).put(i, localBundle);
            }
            i += 1;
            localObject1 = localObject2;
        }
        return (SparseArray<Bundle>) localObject1;
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

    public static void a(aq paramaq, CharSequence paramCharSequence1, boolean paramBoolean1, CharSequence paramCharSequence2, Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean2) {
        paramaq = new Notification.BigPictureStyle(paramaq.a()).setBigContentTitle(paramCharSequence1).bigPicture(paramBitmap1);
        if (paramBoolean2) {
            paramaq.bigLargeIcon(paramBitmap2);
        }
        if (paramBoolean1) {
            paramaq.setSummaryText(paramCharSequence2);
        }
    }

    public static void a(aq paramaq, CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, CharSequence paramCharSequence3) {
        paramaq = new Notification.BigTextStyle(paramaq.a()).setBigContentTitle(paramCharSequence1).bigText(paramCharSequence3);
        if (paramBoolean) {
            paramaq.setSummaryText(paramCharSequence2);
        }
    }

    public static void a(aq paramaq, CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, ArrayList<CharSequence> paramArrayList) {
        paramaq = new Notification.InboxStyle(paramaq.a()).setBigContentTitle(paramCharSequence1);
        if (paramBoolean) {
            paramaq.setSummaryText(paramCharSequence2);
        }
        paramCharSequence1 = paramArrayList.iterator();
        while (paramCharSequence1.hasNext()) {
            paramaq.addLine((CharSequence) paramCharSequence1.next());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */