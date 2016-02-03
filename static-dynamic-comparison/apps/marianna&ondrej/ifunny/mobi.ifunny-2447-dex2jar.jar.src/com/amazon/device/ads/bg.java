package com.amazon.device.ads;

import android.content.Context;

import java.util.Map;

abstract class bg
        implements bv {
    protected final dj a;
    protected final Context b;
    protected ah c;
    protected boolean d = false;
    protected boolean e = false;
    protected boolean f = false;
    private double g = 1.0D;

    protected bg(ah paramah, dj paramdj, Context paramContext) {
        this.c = paramah;
        this.a = paramdj;
        this.b = paramContext;
    }

    protected static double a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        double d2 = paramInt3 / paramInt1;
        double d3 = paramInt4 / paramInt2;
        double d1;
        if (d3 >= d2) {
            d1 = d2;
            if (d2 != 0.0D) {
            }
        } else {
            d1 = d2;
            if (d3 != 0.0D) {
                d1 = d3;
            }
        }
        d2 = d1;
        if (d1 == 0.0D) {
            d2 = 1.0D;
        }
        return d2;
    }

    protected static double a(ah paramah, dj paramdj) {
        float f1 = dn.i().b().s();
        int i = (int) (paramah.f() * f1);
        int j = (int) (paramah.e() * f1);
        double d1 = a(i, j, paramdj.h(), paramdj.g());
        dv.a("AdRenderer", "Scaling Params: scalingDensity: %f, windowWidth: %d, windowHeight: %d, adWidth: %d, adHeight: %d, scale: %f", new Object[]{Float.valueOf(f1), Integer.valueOf(paramdj.h()), Integer.valueOf(paramdj.g()), Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d1)});
        return d1;
    }

    public void a() {
        this.g = a(this.c, this.a);
        this.f = true;
    }

    protected void a(ah paramah) {
        this.c = paramah;
    }

    protected void a(bd parambd) {
        this.a.a(parambd);
    }

    protected abstract boolean a(bh parambh);

    protected abstract boolean a(String paramString, Map<String, String> paramMap);

    public boolean b() {
        return this.f;
    }

    protected double c() {
        return this.g;
    }

    public String d() {
        if (c() > 1.0D) {
            return "u";
        }
        if ((c() < 1.0D) && (c() > 0.0D)) {
            return "d";
        }
        return "n";
    }

    protected boolean e() {
        return (!b()) || (this.e);
    }

    protected boolean f() {
        return (!b()) || (this.d);
    }

    public boolean g() {
        return (b()) && (!f()) && (!e());
    }

    public boolean h() {
        return this.a.r();
    }

    protected abstract boolean i();

    protected abstract void j();

    protected abstract boolean k();

    protected abstract void l();

    protected abstract void m();

    public int n() {
        return this.c.e();
    }

    public ca o() {
        return this.a.s();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */