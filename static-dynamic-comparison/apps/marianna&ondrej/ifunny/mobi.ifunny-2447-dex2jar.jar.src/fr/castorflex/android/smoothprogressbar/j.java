package fr.castorflex.android.smoothprogressbar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;

public final class j {
    public static Drawable a(int[] paramArrayOfInt, float paramFloat) {
        if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
            return null;
        }
        return new ShapeDrawable(new a(paramFloat, paramArrayOfInt));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/fr/castorflex/android/smoothprogressbar/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */