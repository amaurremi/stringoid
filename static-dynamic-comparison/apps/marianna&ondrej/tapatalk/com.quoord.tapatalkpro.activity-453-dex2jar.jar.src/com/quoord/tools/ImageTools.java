package com.quoord.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide.Request;
import com.quoord.tapatalkpro.util.ImageItem;
import com.quoord.tapatalkpro.util.Util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ImageTools {
    public static Bitmap adjustOpacity(Bitmap paramBitmap, int paramInt) {
        if (paramBitmap.isMutable()) {
        }
        for (; ; ) {
            new Canvas(paramBitmap).drawColor((paramInt & 0xFF) << 24, PorterDuff.Mode.DST_IN);
            return paramBitmap;
            paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
        }
    }

    public static Rect calculateDstRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ScalingLogic paramScalingLogic) {
        if (paramScalingLogic == ScalingLogic.FIT) {
            float f = paramInt1 / paramInt2;
            if (f > paramInt3 / paramInt4) {
                return new Rect(0, 0, paramInt3, (int) (paramInt3 / f));
            }
            return new Rect(0, 0, (int) (paramInt4 * f), paramInt4);
        }
        return new Rect(0, 0, paramInt3, paramInt4);
    }

    public static int calculateSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ScalingLogic paramScalingLogic) {
        if (paramScalingLogic == ScalingLogic.FIT) {
            if (paramInt1 / paramInt2 > paramInt3 / paramInt4) {
                return paramInt1 / paramInt3;
            }
            return paramInt2 / paramInt4;
        }
        if (paramInt1 / paramInt2 > paramInt3 / paramInt4) {
            return paramInt2 / paramInt4;
        }
        return paramInt1 / paramInt3;
    }

    public static Rect calculateSrcRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ScalingLogic paramScalingLogic) {
        if (paramScalingLogic == ScalingLogic.CROP) {
            float f1 = paramInt1 / paramInt2;
            float f2 = paramInt3 / paramInt4;
            if (f1 > f2) {
                paramInt3 = (int) (paramInt2 * f2);
                paramInt1 = (paramInt1 - paramInt3) / 2;
                return new Rect(paramInt1, 0, paramInt1 + paramInt3, paramInt2);
            }
            paramInt3 = (int) (paramInt1 / f2);
            paramInt2 = (paramInt2 - paramInt3) / 2;
            return new Rect(0, paramInt2, paramInt1, paramInt2 + paramInt3);
        }
        return new Rect(0, 0, paramInt1, paramInt2);
    }

    public static Bitmap createScaledBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, ScalingLogic paramScalingLogic) {
        Rect localRect = calculateSrcRect(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2, paramScalingLogic);
        paramScalingLogic = calculateDstRect(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2, paramScalingLogic);
        Bitmap localBitmap = Bitmap.createBitmap(paramScalingLogic.width(), paramScalingLogic.height(), Bitmap.Config.ARGB_8888);
        new Canvas(localBitmap).drawBitmap(paramBitmap, localRect, paramScalingLogic, new Paint(2));
        return localBitmap;
    }

    public static Bitmap decodeFile(String paramString, int paramInt1, int paramInt2, ScalingLogic paramScalingLogic) {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        localOptions.inJustDecodeBounds = false;
        if ((localOptions.outHeight != 0) && (localOptions.outWidth != 0)) {
        }
        for (localOptions.inSampleSize = calculateSampleSize(localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, paramScalingLogic); ; localOptions.inSampleSize = 1) {
            return BitmapFactory.decodeFile(paramString, localOptions);
        }
    }

    public static Bitmap getBitmapFromCache(String paramString) {
        try {
            paramString = BitmapFactory.decodeFile(paramString);
            return paramString;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    public static Bitmap getBlogBigImage(String paramString, Context paramContext, int paramInt) {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        double d1 = localOptions.outWidth;
        double d2 = localOptions.outHeight;
        paramContext = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay();
        double d3 = paramInt;
        double d4 = paramContext.getHeight();
        if (d2 / d1 > 0.67D) {
            paramString = decodeFile(paramString, (int) d3, (int) (d2 * d3 / d1), ScalingLogic.CROP);
            if (paramString != null) {
                return createScaledBitmap(paramString, (int) d3, (int) (0.67D * d3), ScalingLogic.CROP);
            }
        } else {
            paramString = decodeFile(paramString, (int) d3, (int) (d2 * d3 / d1), ScalingLogic.FIT);
            if (paramString != null) {
                return createScaledBitmap(paramString, (int) d3, (int) (d2 * d3 / d1), ScalingLogic.FIT);
            }
        }
        return null;
    }

    public static String getImageType(InputStream paramInputStream) {
        Object localObject = null;
        try {
            String str = ImageItem.getImageType(paramInputStream);
            localObject = str;
            paramInputStream.close();
            localObject = str;
        } catch (Exception paramInputStream) {
            for (; ; ) {
                paramInputStream.printStackTrace();
            }
        }
        paramInputStream = (InputStream) localObject;
        if (localObject == null) {
            paramInputStream = ImageItem.JPEG;
        }
        paramInputStream.equals(ImageItem.GIF);
        return paramInputStream;
    }

    public static String getImageType(String paramString) {
        Object localObject3 = new File(paramString);
        Object localObject2 = null;
        paramString = null;
        localObject1 = localObject2;
        try {
            if (((File) localObject3).exists()) {
                localObject1 = localObject2;
                localObject3 = new FileInputStream((File) localObject3);
                localObject1 = localObject2;
                paramString = ImageItem.getImageType((InputStream) localObject3);
                localObject1 = paramString;
                ((InputStream) localObject3).close();
            }
        } catch (Exception paramString) {
            for (; ; ) {
                paramString.printStackTrace();
                paramString = (String) localObject1;
            }
        }
        localObject1 = paramString;
        if (paramString == null) {
            localObject1 = ImageItem.JPEG;
        }
        ((String) localObject1).equals(ImageItem.GIF);
        return (String) localObject1;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap) {
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        RectF localRectF = new RectF(localRect);
        localPaint.setAntiAlias(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-12434878);
        localCanvas.drawRoundRect(localRectF, 12.0F, 12.0F, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
        return localBitmap;
    }

    public static void glideLoad(String paramString, ImageView paramImageView) {
        if ((paramString == null) || (paramString.equals("")) || (paramImageView == null)) {
            return;
        }
        try {
            Glide.load(paramString).into(paramImageView);
            return;
        } catch (Exception paramString) {
        }
    }

    public static void glideLoad(String paramString, ImageView paramImageView, int paramInt) {
        if ((Util.isEmpty(paramString)) || (Util.isEmpty(paramImageView))) {
        }
        for (; ; ) {
            try {
                paramImageView.setImageResource(paramInt);
                return;
            } catch (Exception paramString) {
            }
            try {
                Glide.load(paramString).placeholder(paramInt).into(paramImageView);
                return;
            } catch (Exception paramString) {
            }
        }
    }

    /* Error */
    public static void glideLoad(String paramString, ImageView paramImageView, int paramInt, com.bumptech.glide.Glide.RequestListener<String> paramRequestListener) {
        // Byte code:
        //   0: aload_0
        //   1: invokestatic 250	com/quoord/tapatalkpro/util/Util:isEmpty	(Ljava/lang/String;)Z
        //   4: ifne +10 -> 14
        //   7: aload_1
        //   8: invokestatic 253	com/quoord/tapatalkpro/util/Util:isEmpty	(Landroid/view/View;)Z
        //   11: ifeq +9 -> 20
        //   14: aload_1
        //   15: iload_2
        //   16: invokevirtual 258	android/widget/ImageView:setImageResource	(I)V
        //   19: return
        //   20: aload_3
        //   21: ifnonnull +16 -> 37
        //   24: aload_0
        //   25: invokestatic 237	com/bumptech/glide/Glide:load	(Ljava/lang/String;)Lcom/bumptech/glide/Glide$Request;
        //   28: iload_2
        //   29: invokevirtual 262	com/bumptech/glide/Glide$Request:placeholder	(I)Lcom/bumptech/glide/Glide$Request;
        //   32: aload_1
        //   33: invokevirtual 243	com/bumptech/glide/Glide$Request:into	(Landroid/widget/ImageView;)V
        //   36: return
        //   37: aload_0
        //   38: invokestatic 237	com/bumptech/glide/Glide:load	(Ljava/lang/String;)Lcom/bumptech/glide/Glide$Request;
        //   41: iload_2
        //   42: invokevirtual 262	com/bumptech/glide/Glide$Request:placeholder	(I)Lcom/bumptech/glide/Glide$Request;
        //   45: aload_3
        //   46: invokevirtual 267	com/bumptech/glide/Glide$Request:listener	(Lcom/bumptech/glide/Glide$RequestListener;)Lcom/bumptech/glide/Glide$Request;
        //   49: aload_1
        //   50: invokevirtual 243	com/bumptech/glide/Glide$Request:into	(Landroid/widget/ImageView;)V
        //   53: return
        //   54: astore_0
        //   55: return
        //   56: astore_0
        //   57: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	58	0	paramString	String
        //   0	58	1	paramImageView	ImageView
        //   0	58	2	paramInt	int
        //   0	58	3	paramRequestListener	com.bumptech.glide.Glide.RequestListener<String>
        // Exception table:
        //   from	to	target	type
        //   14	19	54	java/lang/Exception
        //   24	36	56	java/lang/Exception
        //   37	53	56	java/lang/Exception
    }

    public static boolean saveBitmpaToCache(Bitmap paramBitmap, String paramString) {
        paramString = new File(paramString);
        if (!paramString.exists()) {
        }
        try {
            paramString.createNewFile();
        } catch (Exception localException) {
            for (; ; ) {
                try {
                    paramString = new BufferedOutputStream(new FileOutputStream(paramString));
                    boolean bool = paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramString);
                    return bool;
                } catch (Exception paramBitmap) {
                    paramBitmap.printStackTrace();
                }
                localException = localException;
                localException.printStackTrace();
            }
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/ImageTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */