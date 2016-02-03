package com.everimaging.fotorsdk.filter.rs;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import com.everimaging.bitmap.EIBitmapTool;
import com.everimaging.fotorsdk.algorithms.IAssetLoader;
import com.everimaging.fotorsdk.algorithms.g;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.filter.FxEffectFilter.a;
import com.everimaging.fotorsdk.filter.a.a;
import com.everimaging.fotorsdk.filter.params.EffectsParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class b
        extends a
        implements FxEffectFilter.a {
    private static final Object g = new Object();
    private static final String h = b.class.getSimpleName();
    private static final FotorLoggerFactory.c m = FotorLoggerFactory.a(h, FotorLoggerFactory.LoggerType.CONSOLE);
    private int i;
    private Bitmap j;
    private boolean k;
    private Paint l;

    public b(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, EffectsParams paramEffectsParams, IAssetLoader paramIAssetLoader) {
        super(parama, paramBitmap1, paramBitmap2, paramEffectsParams);
        this.c.a(paramIAssetLoader);
        this.i = -1;
        this.j = BitmapUtils.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), paramBitmap1.getConfig());
        this.k = false;
        this.l = new Paint(4);
        this.l.setFilterBitmap(true);
    }

    private void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, EffectsParams paramEffectsParams) {
        if ((paramBitmap2 == null) || (paramBitmap2.isRecycled()) || (!paramBitmap2.isMutable())) {
            Log.e(h, "compute blend with invalid bitmap");
        }
        do {
            return;
            if ((paramEffectsParams.getBlend() < 1.0F) && (paramBitmap3 != null)) {
                m.c(new Object[]{"doBlend with canvas:" + paramEffectsParams.getBlend()});
                long l1 = System.currentTimeMillis();
                paramBitmap2 = new Canvas(paramBitmap2);
                int n = (int) (paramEffectsParams.getBlend() * 255.0F);
                this.l.setAlpha(255 - n);
                paramBitmap2.drawBitmap(paramBitmap1, 0.0F, 0.0F, this.l);
                this.l.setAlpha(n);
                paramBitmap2.drawBitmap(paramBitmap3, 0.0F, 0.0F, this.l);
                long l2 = System.currentTimeMillis();
                m.c(new Object[]{h, "compute blend speed time:" + (l2 - l1) + "ms"});
                return;
            }
        } while ((paramEffectsParams.getBlend() < 1.0F) || (paramBitmap3 == null));
        EIBitmapTool.a(paramBitmap3, paramBitmap2);
    }

    public Bitmap a() {
        EffectsParams localEffectsParams;
        EffectEntity localEffectEntity;
        synchronized (g) {
            localEffectsParams = (EffectsParams) this.f;
            localEffectEntity = localEffectsParams.getEffectEntity();
            localEffectEntity.setOptimizationDisable(true);
            if ((localEffectsParams.getBlend() == 0.0F) || (localEffectEntity == null) || (localEffectEntity.getID() == -1)) {
                this.i = localEffectEntity.getID();
                m.c(new Object[]{"blend is zero will return original"});
                Bitmap localBitmap = this.e;
                if (localBitmap == null) {
                    localBitmap = BitmapUtils.copy(this.d, Bitmap.Config.ARGB_8888);
                    if ((this.j != null) && (!this.j.isRecycled())) {
                        this.j.recycle();
                        this.j = null;
                    }
                    return localBitmap;
                }
                EIBitmapTool.a(this.d, localBitmap);
            }
        }
        Object localObject3 = this.e;
        Object localObject2 = localObject3;
        if (localObject3 == null) {
            localObject2 = BitmapUtils.createBitmap(this.d.getWidth(), this.d.getHeight(), Bitmap.Config.ARGB_8888);
        }
        if (localEffectEntity.getID() != this.i) {
            m.c(new Object[]{"doFilter:name:" + localEffectsParams.getEffectEntity().getName() + ",Id:" + localEffectsParams.getEffectEntity().getID()});
            long l1 = System.currentTimeMillis();
            localObject3 = this.c.a(localEffectEntity, this.d);
            if ((this.j == null) || (this.j.isRecycled())) {
                this.j = BitmapUtils.createBitmap(this.d.getWidth(), this.d.getHeight(), this.d.getConfig());
            }
            ((Allocation) localObject3).copyTo(this.j);
            long l2 = System.currentTimeMillis();
            m.c(new Object[]{h, "computeEffect speed time:" + (l2 - l1) + "ms"});
            this.i = localEffectEntity.getID();
            localEffectEntity.finish();
        }
        a(this.d, (Bitmap) localObject2, this.j, localEffectsParams);
        return (Bitmap) localObject2;
    }

    public void b() {
        super.b();
        this.j = null;
        this.d = null;
        this.e = null;
        this.k = true;
    }

    protected void finalize()
            throws Throwable {
        m.c(new Object[]{"----finalize----:" + this.k});
        if (!this.k) {
            b();
        }
        super.finalize();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/filter/rs/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */