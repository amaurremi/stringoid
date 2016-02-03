package com.everimaging.fotorsdk.editor.filter.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.everimaging.fotorsdk.algorithms.jni.FotorSDKAlgorithmsNative;
import com.everimaging.fotorsdk.brush.painter.beauty.a;
import com.everimaging.fotorsdk.editor.filter.f.a;
import com.everimaging.fotorsdk.editor.filter.params.MosaicParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class e
        extends c
        implements f.a {
    private static final Object e = new Object();
    private static final String f = e.class.getSimpleName();
    private static final FotorLoggerFactory.c g = FotorLoggerFactory.a(f, FotorLoggerFactory.LoggerType.CONSOLE);

    public e(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, MosaicParams paramMosaicParams) {
        super(paramContext, paramBitmap1, paramBitmap2, paramMosaicParams);
    }

    public Bitmap a() {
        synchronized (e) {
            g.c(new Object[]{"compute global mosaic"});
            MosaicParams localMosaicParams = (MosaicParams) this.c;
            Bitmap localBitmap2 = this.b;
            Bitmap localBitmap1 = localBitmap2;
            if (localBitmap2 == null) {
                localBitmap1 = BitmapUtils.createBitmap(this.a.getWidth(), this.a.getHeight(), this.a.getConfig());
            }
            FotorSDKAlgorithmsNative.mosaic(this.a, this.b, localMosaicParams.getBlurPixels());
            return localBitmap1;
        }
    }

    public Bitmap b() {
        synchronized (e) {
            g.a();
            MosaicParams localMosaicParams = (MosaicParams) this.c;
            Object localObject3 = localMosaicParams.getMaskCachePath();
            if ((localObject3 != null) && (!((String) localObject3).isEmpty())) {
                localObject3 = new File((String) localObject3);
                try {
                    localObject4 = new FileInputStream((File) localObject3);
                    byte[] arrayOfByte = new byte['က'];
                    localObject3 = new ByteArrayOutputStream();
                    while (((FileInputStream) localObject4).read(arrayOfByte) != -1) {
                        ((ByteArrayOutputStream) localObject3).write(arrayOfByte);
                    }
                    localBitmap = this.a;
                } catch (Exception localException) {
                    localException.printStackTrace();
                }
            } else {
                return localBitmap;
            }
            ((FileInputStream) localObject4).close();
            Object localObject4 = ByteBuffer.wrap(((ByteArrayOutputStream) localObject3).toByteArray());
            ((ByteArrayOutputStream) localObject3).close();
            int i = localBitmap.getMaskWidth();
            int j = localBitmap.getMaskHeight();
            int k = this.a.getWidth();
            int m = this.a.getHeight();
            float f1 = Math.min(i / k, j / m);
            localObject3 = BitmapUtils.createBitmap(i, j, Bitmap.Config.ALPHA_8);
            ((Bitmap) localObject3).copyPixelsFromBuffer((Buffer) localObject4);
            localBitmap.setBlurPixels(localBitmap.getBlurPixels() / f1);
            this.b = a();
            Bitmap localBitmap = BitmapUtils.createScaleBitmap((Bitmap) localObject3, 1.0F / f1, 1.0F / f1, true);
            localObject3 = BitmapUtils.createBitmap(k, m, Bitmap.Config.ARGB_8888);
            a.a(this.a, this.b, localBitmap, (Bitmap) localObject3);
            g.c(new Object[]{"do filter speed : " + g.b()});
            return (Bitmap) localObject3;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/jni/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */