package com.everimaging.fotorsdk.editor.filter.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.everimaging.bitmap.EIBitmapTool;
import com.everimaging.fotorsdk.algorithms.IAssetLoader;
import com.everimaging.fotorsdk.algorithms.jni.FotorSDKAlgorithmsNative;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.editor.filter.FxEffectFilter.a;
import com.everimaging.fotorsdk.editor.filter.params.EffectsParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class d
        extends c
        implements FxEffectFilter.a {
    private static final Object e = new Object();
    private static final String f = d.class.getSimpleName();
    private static final FotorLoggerFactory.c l = FotorLoggerFactory.a(f, FotorLoggerFactory.LoggerType.CONSOLE);
    private int g;
    private boolean h;
    private IAssetLoader i;
    private Bitmap j;
    private Paint k;

    public d(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, EffectsParams paramEffectsParams, IAssetLoader paramIAssetLoader) {
        super(paramContext, paramBitmap1, paramBitmap2, paramEffectsParams);
        this.i = paramIAssetLoader;
        this.g = -1;
        this.h = false;
        this.k = new Paint(4);
        this.k.setFilterBitmap(true);
    }

    private void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, EffectsParams paramEffectsParams) {
        if ((paramBitmap2 == null) || (paramBitmap2.isRecycled()) || (!paramBitmap2.isMutable()) || (paramBitmap3 == null) || (paramBitmap3.isRecycled())) {
            Log.e(f, "compute blend with invalid bitmap");
        }
        do {
            return;
            if (paramEffectsParams.getBlend() < 1.0F) {
                l.c(new Object[]{"doBlend with canvas:" + paramEffectsParams.getBlend()});
                long l1 = System.currentTimeMillis();
                paramBitmap2 = new Canvas(paramBitmap2);
                int m = (int) (paramEffectsParams.getBlend() * 255.0F);
                this.k.setAlpha(255 - m);
                paramBitmap2.drawBitmap(paramBitmap1, 0.0F, 0.0F, this.k);
                this.k.setAlpha(m);
                paramBitmap2.drawBitmap(paramBitmap3, 0.0F, 0.0F, this.k);
                long l2 = System.currentTimeMillis();
                l.c(new Object[]{f, "compute blend speed time:" + (l2 - l1) + "ms"});
                return;
            }
        } while (paramEffectsParams.getBlend() < 1.0F);
        EIBitmapTool.a(paramBitmap3, paramBitmap2);
    }

    public void a() {
        a(this.a, this.b, this.j, (EffectsParams) this.c);
    }

    public void a(boolean paramBoolean) {
        if ((paramBoolean) && (this.a != null) && (this.b != null)) {
            EIBitmapTool.a(this.a, this.b);
        }
        this.g = -1;
    }

    public Bitmap b() {
        EffectsParams localEffectsParams;
        EffectEntity localEffectEntity;
        synchronized (e) {
            localEffectsParams = (EffectsParams) this.c;
            localEffectEntity = localEffectsParams.getEffectEntity();
            localEffectEntity.setOptimizationDisable(true);
            if ((localEffectsParams.getBlend() == 0.0F) || (localEffectEntity == null) || (localEffectEntity.getID() == -1)) {
                this.g = localEffectEntity.getID();
                l.c(new Object[]{"blend is zero will return original dst bm:" + this.b});
                Bitmap localBitmap1 = this.b;
                if (localBitmap1 == null) {
                    localBitmap1 = BitmapUtils.copy(this.a, Bitmap.Config.ARGB_8888);
                    if ((this.j != null) && (!this.j.isRecycled())) {
                        this.j.isRecycled();
                    }
                    this.j = null;
                    return localBitmap1;
                }
                EIBitmapTool.a(this.a, localBitmap1);
            }
        }
        l.a();
        Bitmap localBitmap2 = this.b;
        Object localObject2 = localBitmap2;
        if (localBitmap2 == null) {
            localObject2 = BitmapUtils.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.ARGB_8888);
        }
        if (localEffectEntity.getID() != this.g) {
            l.c(new Object[]{"doFilter:name:" + localEffectsParams.getEffectEntity().getName() + ",Id:" + localEffectsParams.getEffectEntity().getID()});
            if ((this.j == null) || (this.j.isRecycled())) {
                this.j = BitmapUtils.createBitmap(this.a.getWidth(), this.a.getHeight(), this.a.getConfig());
            }
            FotorSDKAlgorithmsNative.effect(this.a, this.j, localEffectEntity, this.i);
            this.g = localEffectEntity.getID();
            localEffectEntity.finish();
        }
        a(this.a, (Bitmap) localObject2, this.j, localEffectsParams);
        l.c(new Object[]{f, "compute fx speed time:" + l.b() + "ms"});
        return (Bitmap) localObject2;
    }

    public void c() {
        super.c();
        this.a = null;
        this.b = null;
        this.h = true;
        if ((this.j != null) && (!this.j.isRecycled())) {
            this.j.recycle();
        }
        this.j = null;
    }

    protected void finalize()
            throws Throwable {
        l.c(new Object[]{"----finalize----:" + this.h});
        if (!this.h) {
            c();
        }
        super.finalize();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/jni/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */