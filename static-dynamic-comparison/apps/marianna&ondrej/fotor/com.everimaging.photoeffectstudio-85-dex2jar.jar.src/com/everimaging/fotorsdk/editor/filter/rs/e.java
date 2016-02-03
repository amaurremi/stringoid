package com.everimaging.fotorsdk.editor.filter.rs;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.RSFilterFactory;
import com.everimaging.fotorsdk.algorithms.RSFilterFactory.Filters;
import com.everimaging.fotorsdk.algorithms.f;
import com.everimaging.fotorsdk.algorithms.g;
import com.everimaging.fotorsdk.brush.painter.beauty.a;
import com.everimaging.fotorsdk.editor.filter.a.a;
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
    private static final Object g = new Object();
    private static final String h = e.class.getSimpleName();
    private static final FotorLoggerFactory.c i = FotorLoggerFactory.a(h, FotorLoggerFactory.LoggerType.CONSOLE);

    public e(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, MosaicParams paramMosaicParams) {
        super(parama, paramBitmap1, paramBitmap2, paramMosaicParams);
        parama = RSFilterFactory.a(RSFilterFactory.Filters.MOSAIC, paramMosaicParams.getRsMosaicBaseFilterParams());
        parama.a("src", this.d);
        parama.a("dst", this.e);
        this.c.a(parama);
    }

    public Bitmap a() {
        synchronized (g) {
            Object localObject2 = this.c.d();
            if (this.e == null) {
                this.e = BitmapUtils.createBitmap(((Allocation) localObject2).getType().getX(), ((Allocation) localObject2).getType().getY(), Bitmap.Config.ARGB_8888);
            }
            ((Allocation) localObject2).copyTo(this.e);
            localObject2 = this.e;
            return (Bitmap) localObject2;
        }
    }

    public Bitmap b() {
        synchronized (g) {
            MosaicParams localMosaicParams = (MosaicParams) this.f;
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
                    localBitmap = this.d;
                } catch (Exception localException) {
                    localException.printStackTrace();
                }
            } else {
                return localBitmap;
            }
            ((FileInputStream) localObject4).close();
            Object localObject4 = ByteBuffer.wrap(((ByteArrayOutputStream) localObject3).toByteArray());
            ((ByteArrayOutputStream) localObject3).close();
            int j = localBitmap.getMaskWidth();
            int k = localBitmap.getMaskHeight();
            int m = this.d.getWidth();
            int n = this.d.getHeight();
            float f = Math.min(j / m, k / n);
            localObject3 = BitmapUtils.createBitmap(j, k, Bitmap.Config.ALPHA_8);
            ((Bitmap) localObject3).copyPixelsFromBuffer((Buffer) localObject4);
            localBitmap.setBlurPixels(localBitmap.getBlurPixels() / f);
            this.e = a();
            Bitmap localBitmap = BitmapUtils.createScaleBitmap((Bitmap) localObject3, 1.0F / f, 1.0F / f, true);
            localObject3 = BitmapUtils.createBitmap(m, n, Bitmap.Config.ARGB_8888);
            a.a(this.d, this.e, localBitmap, (Bitmap) localObject3);
            return (Bitmap) localObject3;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/rs/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */