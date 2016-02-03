package com.everimaging.fotorsdk.editor.feature.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.everimaging.fotorsdk.brush.toolkit.c.b;
import com.everimaging.fotorsdk.brush.toolkit.d;
import com.everimaging.fotorsdk.brush.toolkit.d.a;
import com.everimaging.fotorsdk.editor.filter.params.MosaicParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.FotorIOUtils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class a
        extends d<MosaicParams> {
    private static final String d = a.class.getSimpleName();
    private static final FotorLoggerFactory.c e = FotorLoggerFactory.a(d, FotorLoggerFactory.LoggerType.CONSOLE);
    private com.everimaging.fotorsdk.brush.painter.beauty.a f;

    public a(com.everimaging.fotorsdk.brush.painter.beauty.a parama) {
        this.f = parama;
    }

    public c.b a(int paramInt) {
        if ((paramInt >= this.b.size()) || (paramInt < 0)) {
            return null;
        }
        this.c -= 1;
        return (c.b) this.b.remove(paramInt);
    }

    public void a(MosaicParams paramMosaicParams) {
        if (this.c == 0) {
            this.f.b();
        }
        Object localObject1;
        do {
            return;
            localObject1 = paramMosaicParams.getMaskCachePath();
        } while ((localObject1 == null) || (((String) localObject1).isEmpty()));
        try {
            localObject2 = new FileInputStream((String) localObject1);
            byte[] arrayOfByte = new byte['က'];
            localObject1 = new ByteArrayOutputStream();
            while (((FileInputStream) localObject2).read(arrayOfByte) != -1) {
                ((ByteArrayOutputStream) localObject1).write(arrayOfByte);
            }
            FotorIOUtils.closeSilently((Closeable) localObject2);
        } catch (Exception paramMosaicParams) {
            paramMosaicParams.printStackTrace();
            return;
        }
        paramMosaicParams = Bitmap.createBitmap(paramMosaicParams.getMaskWidth(), paramMosaicParams.getMaskHeight(), Bitmap.Config.ALPHA_8);
        Object localObject2 = ByteBuffer.wrap(((ByteArrayOutputStream) localObject1).toByteArray());
        FotorIOUtils.closeSilently((Closeable) localObject1);
        paramMosaicParams.copyPixelsFromBuffer((Buffer) localObject2);
        paramMosaicParams = BitmapUtils.copy(paramMosaicParams, Bitmap.Config.ARGB_8888);
        this.f.setMaskBitmap(paramMosaicParams);
    }

    public c.b g() {
        return new a();
    }

    public void h() {
        a locala = new a();
        locala.b = new MosaicParams();
        super.a(locala);
    }

    public class a
            extends d.a {
        public a() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */