package mobi.ifunny.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class f {
    public static float a(float paramFloat) {
        return (float) (paramFloat * 3.141592653589793D / 180.0D);
    }

    public static int a(String paramString) {
        try {
            int i = Integer.decode(paramString).intValue();
            return 0xFF000000 | i;
        } catch (NumberFormatException paramString) {
        }
        return -1;
    }

    public static Bitmap a(Drawable paramDrawable) {
        if ((paramDrawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) paramDrawable).getBitmap();
        }
        Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
    }

    public static String a(int paramInt) {
        return String.format("0x%06X", new Object[]{Integer.valueOf(0xFFFFFF & paramInt)});
    }

    public static float b(float paramFloat) {
        return (float) (180.0F * paramFloat / 3.141592653589793D);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */