package com.everimaging.fotorsdk.algorithms.filter;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.params.AdjustParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;

public class a
        extends com.everimaging.fotorsdk.algorithms.a<d> {
    private static final String b = a.class.getSimpleName();
    private com.everimaging.fotorsdk.algorithms.cpu.c c = new com.everimaging.fotorsdk.algorithms.cpu.c();
    private float[] d = new float['Ā'];
    private float[] e = {0.0F, 0.0F, 0.5F, 0.0F, 1.0F, 1.0F};
    private Allocation f;
    private Allocation g;
    private Allocation h;
    private Allocation i;
    private Allocation j;
    private Allocation k;
    private Allocation l;
    private Allocation m;
    private Allocation n;

    public a(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    private Allocation a(RenderScript paramRenderScript, d paramd, Allocation paramAllocation, float[] paramArrayOfFloat, float paramFloat) {
        paramArrayOfFloat[3] = paramFloat;
        Allocation localAllocation2 = Allocation.createSized(paramRenderScript, Element.F32_2(paramRenderScript), paramArrayOfFloat.length / 2);
        localAllocation2.copyFrom(paramArrayOfFloat);
        Allocation localAllocation1 = paramAllocation;
        if (paramAllocation == null) {
            localAllocation1 = Allocation.createSized(paramRenderScript, Element.F32(paramRenderScript), 256);
        }
        paramd.p(localAllocation2);
        paramd.k(localAllocation1);
        paramd.h(paramArrayOfFloat.length / 2);
        paramd.a();
        return localAllocation1;
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        AdjustParams localAdjustParams = (AdjustParams) b();
        Object localObject = a(paramContext, paramRenderScript, "src");
        if (this.f == null) {
            this.f = Allocation.createTyped(paramRenderScript, ((Allocation) localObject).getType());
        }
        this.f.copyFrom((Allocation) localObject);
        paramContext = a(paramContext, paramRenderScript, "dst");
        localObject = Sampler.CLAMP_LINEAR(paramRenderScript);
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, this.f.getType());
        }
        for (; ; ) {
            paramContext.copyFrom(this.f);
            d locald = (d) a();
            if (this.g == null) {
                this.g = Allocation.createSized(paramRenderScript, Element.F32(paramRenderScript), 256);
            }
            if (this.h == null) {
                this.h = Allocation.createSized(paramRenderScript, Element.F32(paramRenderScript), 256);
            }
            locald.k(this.g);
            locald.q(this.g);
            if (localAdjustParams.getBrightness() != 0.0F) {
                com.everimaging.fotorsdk.algorithms.c.a(b, "doBrightness mapping table");
                locald.c(localAdjustParams.getBrightness());
                locald.d(this.g, this.h);
                this.h.copyTo(this.d);
                this.g.copyFrom(this.d);
            }
            if (localAdjustParams.getContrast() != 1.0F) {
                com.everimaging.fotorsdk.algorithms.c.a(b, "doContrast mapping table");
                locald.d(localAdjustParams.getContrast());
                locald.h(this.g, this.h);
                this.h.copyTo(this.d);
                this.g.copyFrom(this.d);
            }
            if ((localAdjustParams.getBrightness() != 0.0F) || (localAdjustParams.getContrast() != 1.0F)) {
                com.everimaging.fotorsdk.algorithms.c.a(b, "mapping table");
                locald.l(this.g);
                locald.m(this.g);
                locald.n(this.g);
                if (this.i == null) {
                    this.i = Allocation.createSized(paramRenderScript, Element.U8_4(paramRenderScript), 256);
                }
                locald.d(this.i);
                locald.r(this.i);
                locald.aY(this.f, paramContext);
                this.f.copyFrom(paramContext);
            }
            if (localAdjustParams.getSaturation() != 1.0F) {
                com.everimaging.fotorsdk.algorithms.c.a(b, "doSaturation");
                locald.j(localAdjustParams.getSaturation());
                locald.aR(this.f, paramContext);
                this.f.copyFrom(paramContext);
            }
            int i1;
            float f2;
            if (localAdjustParams.getSharpening() != 1.0F) {
                com.everimaging.fotorsdk.algorithms.c.a(b, "doSharpening");
                if (this.j == null) {
                    this.j = Allocation.createTyped(paramRenderScript, this.f.getType(), 2);
                }
                this.j.copyFrom(this.f);
                Float2 localFloat2 = new Float2(1.0F / this.f.getType().getX(), 1.0F / this.f.getType().getY());
                i1 = this.f.getType().getX();
                int i2 = this.f.getType().getY();
                locald.a(i1);
                locald.b(i2);
                locald.a(this.j);
                locald.a((Sampler) localObject);
                if (!localAdjustParams.isProcessOrigin()) {
                    locald.f(localFloat2);
                    locald.Q(localAdjustParams.getSamplerScale());
                    locald.R(localAdjustParams.getSharpening());
                    locald.aV(this.f, paramContext);
                    this.f.copyFrom(paramContext);
                }
            } else if (localAdjustParams.getVignette() != 0.0D) {
                com.everimaging.fotorsdk.algorithms.c.a(b, "doVignette");
                f2 = 2.0F + -1.4F * localAdjustParams.getVignette() / 100.0F;
                if (f2 <= 0.4F) {
                    break label1645;
                }
            }
            label1645:
            for (float f1 = 0.1F * f2; ; f1 = 1.0F) {
                locald.a(this.f.getType().getX());
                locald.b(this.f.getType().getY());
                locald.E(f1);
                locald.F(f2);
                locald.bd(this.f, paramContext);
                this.f.copyFrom(paramContext);
                locald.k(this.g);
                locald.q(this.g);
                if (localAdjustParams.getShadows() != 0.0F) {
                    f2 = localAdjustParams.getShadows();
                    f1 = f2;
                    if (f2 > 0.0F) {
                        f1 = f2 * 0.68F;
                    }
                    f1 = (float) Math.tan((f1 + 100.0F) * 0.007853981633974483D);
                    com.everimaging.fotorsdk.algorithms.c.a(b, "doShadows mapping table");
                    locald.z(f1);
                    locald.aT(this.g, this.h);
                    this.h.copyTo(this.d);
                    this.g.copyFrom(this.d);
                }
                if (localAdjustParams.getHighlights() != 0.0F) {
                    f2 = -localAdjustParams.getHighlights();
                    f1 = f2;
                    if (f2 > 0.0F) {
                        f1 = f2 * 0.68F;
                    }
                    f1 = (float) Math.tan((f1 + 100.0F) * 0.007853981633974483D);
                    com.everimaging.fotorsdk.algorithms.c.a(b, "doHighlight mapping table");
                    locald.h(f1);
                    locald.x(this.g, this.h);
                    this.h.copyTo(this.d);
                    this.g.copyFrom(this.d);
                }
                if ((localAdjustParams.getShadows() != 0.0F) || (localAdjustParams.getHighlights() != 0.0F)) {
                    com.everimaging.fotorsdk.algorithms.c.a(b, "mapping table");
                    locald.l(this.g);
                    locald.m(this.g);
                    locald.n(this.g);
                    if (this.i == null) {
                        this.i = Allocation.createSized(paramRenderScript, Element.U8_4(paramRenderScript), 256);
                    }
                    locald.d(this.i);
                    locald.r(this.i);
                    locald.aY(this.f, paramContext);
                    this.f.copyFrom(paramContext);
                }
                if (localAdjustParams.getTemperature() != 0.0F) {
                    com.everimaging.fotorsdk.algorithms.c.a(b, "doTemperature");
                    locald.C(localAdjustParams.getTemperature());
                    locald.D(1.0F);
                    locald.a(this.c.a(localAdjustParams.getTemperature(), 1.0F));
                    locald.bk(this.f, paramContext);
                    this.f.copyFrom(paramContext);
                }
                if (localAdjustParams.getTint() != 1.0F) {
                    com.everimaging.fotorsdk.algorithms.c.a(b, "doTint");
                    locald.C(0.0F);
                    locald.D(localAdjustParams.getTint());
                    locald.a(this.c.a(0.0F, localAdjustParams.getTint()));
                    locald.bk(this.f, paramContext);
                    this.f.copyFrom(paramContext);
                }
                if ((localAdjustParams.getRgb_R() != 0.5D) || (localAdjustParams.getRgb_G() != 0.5D) || (localAdjustParams.getRgb_B() != 0.5D)) {
                    com.everimaging.fotorsdk.algorithms.c.a(b, "doRGB");
                    this.k = a(paramRenderScript, locald, this.k, this.e, localAdjustParams.getRgb_R());
                    this.l = a(paramRenderScript, locald, this.l, this.e, localAdjustParams.getRgb_G());
                    this.m = a(paramRenderScript, locald, this.m, this.e, localAdjustParams.getRgb_B());
                    locald.l(this.k);
                    locald.m(this.l);
                    locald.n(this.m);
                    if (this.i == null) {
                        this.i = Allocation.createSized(paramRenderScript, Element.U8_4(paramRenderScript), 256);
                    }
                    locald.d(this.i);
                    locald.r(this.i);
                    locald.aY(this.f, paramContext);
                    this.f.copyFrom(paramContext);
                }
                if (localAdjustParams.getCurvePoints() != null) {
                    com.everimaging.fotorsdk.algorithms.c.a(b, "doCurve");
                    if (this.n == null) {
                        this.n = Allocation.createSized(paramRenderScript, Element.F32(paramRenderScript), 256);
                    }
                    this.n.copyFrom(localAdjustParams.getCurvePoints());
                    locald.l(this.n);
                    locald.m(this.n);
                    locald.n(this.n);
                    if (this.i == null) {
                        this.i = Allocation.createSized(paramRenderScript, Element.U8_4(paramRenderScript), 256);
                    }
                    locald.d(this.i);
                    locald.r(this.i);
                    locald.aY(this.f, paramContext);
                    this.f.copyFrom(paramContext);
                }
                if (this.a != null) {
                    this.a.b();
                }
                return paramContext;
                localObject = Allocation.createSized(paramRenderScript, Element.U32(paramRenderScript), i1);
                locald.b(paramContext);
                locald.j((Allocation) localObject);
                locald.f((int) localAdjustParams.getRatio());
                locald.R(localAdjustParams.getSharpening());
                locald.f();
                break;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */