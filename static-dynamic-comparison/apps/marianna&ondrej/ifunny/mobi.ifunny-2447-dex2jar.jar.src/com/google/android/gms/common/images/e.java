package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.ox;
import com.google.android.gms.internal.oy;
import com.google.android.gms.internal.oz;

public abstract class e {
    final f a;
    protected int b;
    protected a c;
    protected int d;

    private Drawable a(Context paramContext, oy paramoy, int paramInt) {
        Resources localResources = paramContext.getResources();
        if (this.d > 0) {
            oz localoz = new oz(paramInt, this.d);
            Drawable localDrawable = (Drawable) paramoy.a(localoz);
            paramContext = localDrawable;
            if (localDrawable == null) {
                localDrawable = localResources.getDrawable(paramInt);
                paramContext = localDrawable;
                if ((this.d & 0x1) != 0) {
                    paramContext = a(localResources, localDrawable);
                }
                paramoy.b(localoz, paramContext);
            }
            return paramContext;
        }
        return localResources.getDrawable(paramInt);
    }

    protected Drawable a(Resources paramResources, Drawable paramDrawable) {
        return ox.a(paramResources, paramDrawable);
    }

    void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean) {
        b.a(paramBitmap);
        Bitmap localBitmap = paramBitmap;
        if ((this.d & 0x1) != 0) {
            localBitmap = ox.a(paramBitmap);
        }
        paramContext = new BitmapDrawable(paramContext.getResources(), localBitmap);
        if (this.c != null) {
            this.c.a(this.a.a, paramContext, true);
        }
        a(paramContext, paramBoolean, false, true);
    }

    void a(Context paramContext, oy paramoy, boolean paramBoolean) {
        Drawable localDrawable = null;
        if (this.b != 0) {
            localDrawable = a(paramContext, paramoy, this.b);
        }
        if (this.c != null) {
            this.c.a(this.a.a, localDrawable, false);
        }
        a(localDrawable, paramBoolean, false, false);
    }

    protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/images/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */