package com.everimaging.fotorsdk.widget.entity;

import android.graphics.PointF;

public class FotorLine {
    private float A;
    private float B;
    private float B1;
    private float C;
    private float K;

    public FotorLine() {
        this.A = 0.0F;
        this.B = 0.0F;
        this.C = 0.0F;
        this.K = 0.0F;
        this.B1 = 0.0F;
    }

    public FotorLine(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.A = paramFloat1;
        this.B = paramFloat2;
        this.C = paramFloat3;
        this.K = (-paramFloat1 / paramFloat2);
        this.B1 = (-paramFloat3 / paramFloat2);
    }

    public FotorLine(PointF paramPointF1, PointF paramPointF2) {
        if ((paramPointF1.x == paramPointF2.x) && (paramPointF1.y == paramPointF2.y)) {
            this.A = 0.0F;
            this.B = 0.0F;
            this.C = 0.0F;
            this.K = 0.0F;
            this.B1 = 0.0F;
            return;
        }
        if (paramPointF1.x == paramPointF2.x) {
            this.B = 0.0F;
            this.A = 1.0F;
            this.C = (-paramPointF1.x);
            this.K = 0.0F;
            this.B1 = 0.0F;
            return;
        }
        this.B = (paramPointF1.x - paramPointF2.x);
        this.A = (paramPointF2.y - paramPointF1.y);
        this.C = (paramPointF1.x * (paramPointF1.y - paramPointF2.y) + paramPointF1.y * (paramPointF2.x - paramPointF1.x));
        this.K = ((paramPointF2.y - paramPointF1.y) / (paramPointF2.x - paramPointF1.x));
        this.B1 = (paramPointF1.y - paramPointF1.x * this.K);
    }

    public float a() {
        return this.A;
    }

    public float b() {
        return this.B;
    }

    public float b1() {
        return this.B1;
    }

    public float c() {
        return this.C;
    }

    public PointF getIntersection(FotorLine paramFotorLine) {
        float f = (paramFotorLine.b() * this.C - paramFotorLine.c() * this.B) / (paramFotorLine.a() * this.B - this.A * paramFotorLine.b());
        return new PointF(f, -(this.C + this.A * f) / this.B);
    }

    public int getPointLocation(PointF paramPointF) {
        if (this.B != 0.0F) {
            f = paramPointF.x * this.A + paramPointF.y * this.B + this.C;
            if (f <= 0.0F) {
            }
        }
        while (paramPointF.x > -this.C) {
            float f;
            return 1;
            if (f < 0.0F) {
                return -1;
            }
            return 0;
        }
        if (paramPointF.x < -this.C) {
            return -1;
        }
        if (Math.abs(paramPointF.x - this.C) < 1.0E-7D) {
            return 0;
        }
        return -2;
    }

    public float k() {
        return this.K;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/entity/FotorLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */