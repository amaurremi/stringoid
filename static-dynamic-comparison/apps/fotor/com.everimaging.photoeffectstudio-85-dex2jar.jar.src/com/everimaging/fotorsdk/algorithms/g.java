package com.everimaging.fotorsdk.algorithms;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.text.TextUtils;
import android.util.Log;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.parser.RSBaseFilterFactory.BaseFilter;
import com.everimaging.fotorsdk.algorithms.xml.entity.AllocationEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.AllocationEntity.AllocationType;
import com.everimaging.fotorsdk.algorithms.xml.entity.AllocationEntityBorders;
import com.everimaging.fotorsdk.algorithms.xml.entity.BaseFilterEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
        implements e {
    private static final String a = g.class.getSimpleName();
    private RenderScript b;
    private d c;
    private Context d;
    private List<f> e = new ArrayList();
    private List<a> f = new ArrayList();
    private IAssetLoader g;

    public g(Context paramContext, RenderScript paramRenderScript, d paramd) {
        this.d = paramContext;
        this.b = paramRenderScript;
        this.c = paramd;
    }

    public static Bitmap a(Bitmap paramBitmap, Bitmap.Config paramConfig) {
        paramConfig = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramConfig);
        Canvas localCanvas = new Canvas(paramConfig);
        Paint localPaint = new Paint();
        localPaint.setColor(0);
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
        return paramConfig;
    }

    private Bitmap a(String paramString) {
        if (this.g != null) {
            return this.g.loadAsset(paramString);
        }
        Log.e(a, "AssemblyFactory not implmenetation..");
        return null;
    }

    private Allocation b(String paramString) {
        return b(paramString, 1);
    }

    private Allocation b(String paramString, int paramInt) {
        if (!TextUtils.isEmpty(paramString)) {
            Bitmap localBitmap = a(paramString);
            if (localBitmap != null) {
                paramString = localBitmap;
                if (localBitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                    paramString = a(localBitmap, Bitmap.Config.ARGB_8888);
                }
                return Allocation.createFromBitmap(this.b, paramString, Allocation.MipmapControl.MIPMAP_NONE, paramInt);
            }
        }
        return null;
    }

    public Allocation a(EffectEntity paramEffectEntity, Bitmap paramBitmap) {
        int j = 0;
        if (paramEffectEntity == null) {
            Log.e("RSFilterEngine", "effect entity is not exist!");
            return null;
        }
        c.a(a, "Run BaseFilter mode filter:id:" + paramEffectEntity.getID());
        Object localObject = paramEffectEntity.getAllocations();
        List localList = paramEffectEntity.getmFilters();
        Allocation localAllocation = Allocation.createFromBitmap(this.b, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        int i = 0;
        while (i < ((List) localObject).size()) {
            paramEffectEntity = (AllocationEntity) ((List) localObject).get(i);
            if (paramEffectEntity.getType() == AllocationEntity.AllocationType.SRC) {
                paramEffectEntity.setAllocation(localAllocation);
            }
            i += 1;
        }
        paramEffectEntity = null;
        i = j;
        while (i < localList.size()) {
            localObject = (BaseFilterEntity) localList.get(i);
            if (((BaseFilterEntity) localObject).getFilterType() == RSBaseFilterFactory.BaseFilter.CURVE) {
            }
            AllocationEntity localAllocationEntity = ((BaseFilterEntity) localObject).getSrc();
            if (localAllocationEntity != null) {
                if (localAllocationEntity.getAllocation() == null) {
                    paramBitmap = b(localAllocationEntity.getFile());
                    paramEffectEntity = paramBitmap;
                    if (paramBitmap == null) {
                        paramEffectEntity = Allocation.createTyped(this.b, localAllocation.getType());
                    }
                    localAllocationEntity.setAllocation(paramEffectEntity);
                }
                ((BaseFilterEntity) localObject).getRSFilter().a("src", localAllocationEntity);
                c.a("Engine", "SRC is set");
            }
            localAllocationEntity = ((BaseFilterEntity) localObject).getDst();
            if (localAllocationEntity != null) {
                if (localAllocationEntity.getAllocation() == null) {
                    paramBitmap = b(localAllocationEntity.getFile());
                    paramEffectEntity = paramBitmap;
                    if (paramBitmap == null) {
                        paramEffectEntity = Allocation.createTyped(this.b, ((BaseFilterEntity) localObject).getSrc().getAllocation().getType());
                    }
                    localAllocationEntity.setAllocation(paramEffectEntity);
                }
                ((BaseFilterEntity) localObject).getRSFilter().a("dst", localAllocationEntity);
                c.a("Engine", "DST is set");
            }
            localAllocationEntity = ((BaseFilterEntity) localObject).getTex();
            if (localAllocationEntity != null) {
                if (localAllocationEntity.getAllocation() == null) {
                    paramBitmap = b(localAllocationEntity.getFile());
                    paramEffectEntity = paramBitmap;
                    if (paramBitmap == null) {
                        paramEffectEntity = Allocation.createTyped(this.b, localAllocation.getType());
                    }
                    localAllocationEntity.setAllocation(paramEffectEntity);
                }
                ((BaseFilterEntity) localObject).getRSFilter().a("texture0", localAllocationEntity);
                c.a("Engine", "TEXTURE is set");
            }
            localAllocationEntity = ((BaseFilterEntity) localObject).getTableTex();
            if (localAllocationEntity != null) {
                if (localAllocationEntity.getAllocation() == null) {
                    paramBitmap = b(localAllocationEntity.getFile());
                    paramEffectEntity = paramBitmap;
                    if (paramBitmap == null) {
                        paramEffectEntity = Allocation.createSized(this.b, Element.U8_4(this.b), 256);
                    }
                    localAllocationEntity.setAllocation(paramEffectEntity);
                }
                ((BaseFilterEntity) localObject).getRSFilter().a("table_texture0", localAllocationEntity);
                c.a("Engine", "TABLE_TEXTURE0 is set");
            }
            paramEffectEntity = ((BaseFilterEntity) localObject).getBorder();
            if (paramEffectEntity != null) {
                localAllocationEntity = paramEffectEntity.getUnity();
                if (localAllocationEntity.getAllocation() == null) {
                    paramBitmap = b(localAllocationEntity.getFile(), 2);
                    paramEffectEntity = paramBitmap;
                    if (paramBitmap == null) {
                        paramEffectEntity = Allocation.createTyped(this.b, localAllocation.getType());
                    }
                    localAllocationEntity.setAllocation(paramEffectEntity);
                }
                ((BaseFilterEntity) localObject).getRSFilter().a("texture0", localAllocationEntity);
                c.a("Engine", "UNITY is set");
            }
            paramEffectEntity = ((BaseFilterEntity) localObject).getRSFilter();
            paramEffectEntity.a(this);
            paramEffectEntity.a(this.d, this.c);
            paramEffectEntity.e(this.d, this.b);
            paramEffectEntity.a(this.d, this.b);
            i += 1;
        }
        return paramEffectEntity.c();
    }

    public Allocation a(String paramString, int paramInt) {
        return b(paramString, paramInt);
    }

    public h a(f paramf) {
        this.e.add(paramf);
        paramf.a(this.d, this.c);
        paramf = new a(paramf);
        this.f.add(paramf);
        return paramf;
    }

    public void a() {
    }

    public void a(IAssetLoader paramIAssetLoader) {
        this.g = paramIAssetLoader;
    }

    public void b() {
    }

    public void c() {
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext()) {
            ((f) localIterator.next()).a(this.d, this.b);
        }
        this.e.clear();
        this.f.clear();
    }

    public Allocation d() {
        Object localObject = null;
        int i = 0;
        while (i < this.e.size()) {
            f localf = (f) this.e.get(i);
            if (localObject != null) {
                localf.a("src", (h) this.f.get(this.e.indexOf(localObject)));
            }
            localf.e(this.d, this.b);
            i += 1;
            localObject = localf;
        }
        return ((f) localObject).c();
    }

    public void e() {
        c.a(a, "==Engine dispose==");
        c();
    }

    private static class a
            extends h {
        private f a;

        a(f paramf) {
            this.a = paramf;
        }

        Allocation a() {
            return this.a.c();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */