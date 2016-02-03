package com.everimaging.fotorsdk.editor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;
import android.view.MotionEvent;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.R.integer;
import com.everimaging.fotorsdk.editor.utils.StickersDecodeUtils;
import com.everimaging.fotorsdk.editor.utils.StickersDecodeUtils.StickersResLoadMode;
import com.everimaging.fotorsdk.widget.entity.StickersEntity;

public class c
        extends a {
    private boolean A;
    private int B;
    private int C;
    private BitmapDrawable D;
    private int E;
    private int F;
    private Paint G;
    private Path H;
    private float I;
    private float J;
    private float K;
    private float L;
    private float M;
    private float N;
    private int O;
    private StickersDecodeUtils.StickersResLoadMode P;
    private PointF Q = new PointF();
    private PointF R = new PointF();
    private float S;
    private float T;
    private Drawable n;
    private int o;
    private float p;
    private float q;
    private Drawable r;
    private int s;
    private float t;
    private float u;
    private Drawable v;
    private int w;
    private float x;
    private float y;
    private StickersEntity z;

    public c(Context paramContext, StickersEntity paramStickersEntity, StickersDecodeUtils.StickersResLoadMode paramStickersResLoadMode) {
        super(paramContext);
        this.z = paramStickersEntity;
        a(paramStickersResLoadMode);
    }

    private void a(StickersDecodeUtils.StickersResLoadMode paramStickersResLoadMode) {
        this.P = paramStickersResLoadMode;
        this.D = StickersDecodeUtils.a(this.k, this.z, paramStickersResLoadMode);
        this.D.setFilterBitmap(true);
        this.D.setAntiAlias(true);
        this.E = this.D.getIntrinsicWidth();
        this.F = this.D.getIntrinsicHeight();
        int i = this.D.getIntrinsicWidth();
        int j = this.D.getIntrinsicHeight();
        this.D.setBounds(new Rect(0, 0, i, j));
        this.d[0] = 0.0F;
        this.d[1] = 0.0F;
        this.d[2] = i;
        this.d[3] = 0.0F;
        this.d[4] = i;
        this.d[5] = j;
        this.d[6] = 0.0F;
        this.d[7] = j;
        paramStickersResLoadMode = this.k.getResources();
        this.r = paramStickersResLoadMode.getDrawable(R.drawable.fotor_sticker_text_zoom_button);
        this.s = this.r.getIntrinsicWidth();
        this.n = paramStickersResLoadMode.getDrawable(R.drawable.fotor_sticker_text_delete_button);
        this.o = this.n.getIntrinsicWidth();
        this.v = paramStickersResLoadMode.getDrawable(R.drawable.fotor_sticker_text_reset_button);
        this.w = this.v.getIntrinsicWidth();
        this.T = (this.s * 2);
        this.G = new Paint();
        this.G.setAntiAlias(true);
        this.G.setColor(-1);
        this.G.setStyle(Paint.Style.STROKE);
        this.G.setStrokeWidth(3.0F);
        this.H = new Path();
        this.O = this.k.getResources().getInteger(R.integer.fotor_anim_short_duration);
        this.B = Integer.MAX_VALUE;
        this.A = false;
        this.C = 255;
    }

    private float b(MotionEvent paramMotionEvent) {
        float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
        return FloatMath.sqrt(f1 * f1 + f2 * f2);
    }

    private void m() {
        Matrix localMatrix = new Matrix();
        float f2 = this.D.getIntrinsicWidth() / 2.0F;
        float f3 = this.D.getIntrinsicHeight() / 2.0F;
        float f4 = this.D.getIntrinsicWidth();
        float f5 = this.f;
        float f1 = this.f;
        if (f5 * f4 < this.T) {
            f1 = this.T / this.D.getIntrinsicWidth();
        }
        f4 = this.c.x;
        f5 = this.c.y;
        localMatrix.postRotate(this.i, f2, f3);
        localMatrix.postScale(f1, f1, f2, f3);
        localMatrix.postTranslate(f4 - f2, f5 - f3);
        localMatrix.postTranslate(this.j.left, this.j.top);
        localMatrix.mapPoints(this.e, this.d);
        this.H.reset();
        this.H.moveTo(this.e[0], this.e[1]);
        this.H.lineTo(this.e[2], this.e[3]);
        this.H.lineTo(this.e[4], this.e[5]);
        this.H.lineTo(this.e[6], this.e[7]);
        this.H.close();
    }

    private void n() {
        if (this.a != null) {
            float f = 0.0F;
            if (this.i > 180.0F) {
                f = 360.0F;
            }
            a.c localc = new a.c(this, this.O, this.i, f);
            this.a.a(localc);
        }
    }

    public void a(int paramInt) {
        this.A = true;
        this.B = paramInt;
    }

    public void a(int paramInt1, int paramInt2) {
        int i = this.D.getIntrinsicWidth();
        int j = this.D.getIntrinsicHeight();
        float f1;
        if (this.j.width() > this.T) {
            f1 = this.j.width();
            if (this.j.height() <= this.T) {
                break label240;
            }
        }
        label240:
        for (float f2 = this.j.height(); ; f2 = this.T) {
            this.f = Math.min(f1 / 3.0F / i, f2 / 3.0F / j);
            f1 = (this.j.width() - i * this.f - this.o) / (paramInt2 - 1);
            f2 = (this.j.height() - j * this.f - this.o) / (paramInt2 / 2 - 1);
            float f3 = this.o / 2.0F;
            this.g = (f1 * paramInt1 + f3);
            this.h = (this.o / 2.0F + f2 * (paramInt1 % (paramInt2 / 2)));
            this.c.set(this.g + i * this.f / 2.0F, this.h + j * this.f / 2.0F);
            this.i = 0.0F;
            return;
            f1 = this.T;
            break;
        }
    }

    public void a(Canvas paramCanvas) {
        float f1 = this.j.left;
        float f2 = this.j.top;
        paramCanvas.save();
        paramCanvas.translate(f1, f2);
        this.l.reset();
        this.l.postRotate(this.i, this.D.getIntrinsicWidth() / 2.0F, this.D.getIntrinsicHeight() / 2.0F);
        this.l.postScale(this.f, this.f);
        this.l.postTranslate(this.g, this.h);
        paramCanvas.concat(this.l);
        this.D.setAlpha(this.C);
        if ((this.z.isEnableColor) && (this.A)) {
            this.D.setColorFilter(this.B, PorterDuff.Mode.SRC_IN);
        }
        for (; ; ) {
            this.D.draw(paramCanvas);
            m();
            paramCanvas.restore();
            if (this.b) {
                paramCanvas.drawPath(this.H, this.G);
                this.p = (this.e[0] - this.o / 2.0F);
                this.q = (this.e[1] - this.o / 2.0F);
                Rect localRect = new Rect();
                localRect.left = ((int) this.p);
                localRect.top = ((int) this.q);
                localRect.right = (localRect.left + this.o);
                localRect.bottom = (localRect.top + this.o);
                this.n.setBounds(localRect);
                this.n.draw(paramCanvas);
                this.t = (this.e[4] - this.s / 2.0F);
                this.u = (this.e[5] - this.s / 2.0F);
                localRect = new Rect();
                localRect.left = ((int) this.t);
                localRect.top = ((int) this.u);
                localRect.right = (localRect.left + this.s);
                localRect.bottom = (localRect.top + this.s);
                this.r.setBounds(localRect);
                this.r.draw(paramCanvas);
                this.x = (this.e[2] - this.w / 2.0F);
                this.y = (this.e[3] - this.w / 2.0F);
                localRect = new Rect();
                localRect.left = ((int) this.x);
                localRect.top = ((int) this.y);
                localRect.right = (localRect.left + this.w);
                localRect.bottom = (localRect.top + this.w);
                this.v.setBounds(localRect);
                this.v.draw(paramCanvas);
            }
            return;
            this.D.clearColorFilter();
        }
    }

    public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2) {
        paramFloat1 = this.j.width() / paramFloat1;
        paramFloat2 = this.j.height() / paramFloat2;
        if (paramFloat1 < paramFloat2) {
            Matrix localMatrix = new Matrix();
            float f1 = this.f / paramFloat1;
            float f2 = this.g / paramFloat1;
            float f3 = this.h / paramFloat1;
            paramFloat1 = 1.0F;
            if (this.P == StickersDecodeUtils.StickersResLoadMode.MODE_ORIGINAL) {
                paramFloat1 = this.E / this.D.getIntrinsicWidth();
                paramFloat2 = this.F / this.D.getIntrinsicHeight();
                if (paramFloat1 >= paramFloat2) {
                    break label240;
                }
                label107:
                localMatrix.postScale(paramFloat1, paramFloat1);
            }
            localMatrix.postRotate(this.i, this.D.getIntrinsicWidth() * paramFloat1 / 2.0F, paramFloat1 * this.D.getIntrinsicHeight() / 2.0F);
            localMatrix.postScale(f1, f1);
            localMatrix.postTranslate(f2, f3);
            paramCanvas.save();
            paramCanvas.concat(localMatrix);
            this.D.setAlpha(this.C);
            if ((!this.z.isEnableColor) || (!this.A)) {
                break label245;
            }
            this.D.setColorFilter(this.B, PorterDuff.Mode.SRC_IN);
        }
        for (; ; ) {
            this.D.draw(paramCanvas);
            paramCanvas.restore();
            return;
            paramFloat1 = paramFloat2;
            break;
            label240:
            paramFloat1 = paramFloat2;
            break label107;
            label245:
            this.D.clearColorFilter();
        }
    }

    public void a(RectF paramRectF) {
        super.a(paramRectF);
    }

    public boolean a(MotionEvent paramMotionEvent) {
        int k = 1;
        int m = 1;
        boolean bool2 = true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        boolean bool1;
        switch (paramMotionEvent.getAction() & 0xFF) {
            case 3:
            case 4:
            default:
                bool1 = false;
        }
        label118:
        label138:
        label230:
        label236:
        label242:
        label248:
        label285:
        label305:
        label361:
        label367:
        label373:
        label379:
        label416:
        label436:
        label492:
        label498:
        label504:
        label510:
        label750:
        label768:
        label788:
        label833:
        label839:
        label845:
        label851:
        label884:
        label902:
        label922:
        label980:
        label986:
        label992:
        label998:
        do {
            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    return bool1;
                                    if (this.m != 0) {
                                        break;
                                    }
                                    if (this.b) {
                                        if (f1 >= this.t) {
                                            i = 1;
                                            if (f1 > this.t + this.s) {
                                                break label230;
                                            }
                                            j = 1;
                                            if ((i & j) == 0) {
                                                break label248;
                                            }
                                            if (f2 < this.u) {
                                                break label236;
                                            }
                                            i = 1;
                                            if (f2 > this.u + this.s) {
                                                break label242;
                                            }
                                        }
                                        for (j = 1; ; j = 0) {
                                            if ((i & j) == 0) {
                                                break label248;
                                            }
                                            this.m = 3;
                                            this.K = f1;
                                            this.L = f2;
                                            this.I = f1;
                                            this.J = f2;
                                            this.M = this.f;
                                            this.N = this.f;
                                            this.r.setState(new int[]{16842919});
                                            return true;
                                            i = 0;
                                            break;
                                            j = 0;
                                            break label118;
                                            i = 0;
                                            break label138;
                                        }
                                    }
                                    if (this.b) {
                                        if (f1 >= this.p) {
                                            i = 1;
                                            if (f1 > this.p + this.o) {
                                                break label361;
                                            }
                                            j = 1;
                                            if ((i & j) == 0) {
                                                break label379;
                                            }
                                            if (f2 < this.q) {
                                                break label367;
                                            }
                                            i = 1;
                                            if (f2 > this.q + this.o) {
                                                break label373;
                                            }
                                        }
                                        for (j = 1; ; j = 0) {
                                            if ((i & j) == 0) {
                                                break label379;
                                            }
                                            this.m = 5;
                                            this.n.setState(new int[]{16842919});
                                            return true;
                                            i = 0;
                                            break;
                                            j = 0;
                                            break label285;
                                            i = 0;
                                            break label305;
                                        }
                                    }
                                    if (this.b) {
                                        if (f1 >= this.x) {
                                            i = 1;
                                            if (f1 > this.x + this.w) {
                                                break label492;
                                            }
                                            j = 1;
                                            if ((i & j) == 0) {
                                                break label510;
                                            }
                                            if (f2 < this.y) {
                                                break label498;
                                            }
                                            i = 1;
                                            if (f2 > this.y + this.w) {
                                                break label504;
                                            }
                                        }
                                        for (j = 1; ; j = 0) {
                                            if ((i & j) == 0) {
                                                break label510;
                                            }
                                            this.m = 4;
                                            this.v.setState(new int[]{16842919});
                                            return true;
                                            i = 0;
                                            break;
                                            j = 0;
                                            break label416;
                                            i = 0;
                                            break label436;
                                        }
                                    }
                                    if (a(new PointF(f1, f2), null)) {
                                        this.m = 2;
                                        this.b = true;
                                        if (this.a != null) {
                                            this.a.b(this);
                                        }
                                        this.K = f1;
                                        this.L = f2;
                                        return true;
                                    }
                                    if (this.a != null) {
                                        this.a.c(this);
                                    }
                                    this.b = false;
                                    break;
                                    bool1 = bool2;
                                } while (paramMotionEvent.getPointerCount() != 2);
                                this.Q.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
                                this.R.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
                                this.S = b(paramMotionEvent);
                                bool1 = bool2;
                            } while (this.S <= 10.0F);
                            bool1 = bool2;
                        } while (this.m != 2);
                        this.N = this.f;
                        this.M = this.f;
                        this.m = 6;
                        return true;
                        if (this.m == 3) {
                            this.r.setState(new int[0]);
                        }
                        do {
                            this.m = 0;
                            return false;
                            if (this.m == 4) {
                                if (this.b) {
                                    if (f1 < this.x) {
                                        break label833;
                                    }
                                    i = 1;
                                    if (f1 > this.x + this.w) {
                                        break label839;
                                    }
                                    j = 1;
                                    if ((i & j) != 0) {
                                        if (f2 < this.y) {
                                            break label845;
                                        }
                                        i = 1;
                                        if (f2 > this.y + this.w) {
                                            break label851;
                                        }
                                    }
                                }
                                for (j = k; ; j = 0) {
                                    if ((i & j) != 0) {
                                        n();
                                    }
                                    this.v.setState(new int[0]);
                                    break;
                                    i = 0;
                                    break label750;
                                    j = 0;
                                    break label768;
                                    i = 0;
                                    break label788;
                                }
                            }
                        } while (this.m != 5);
                        if (this.b) {
                            if (f1 < this.p) {
                                break label980;
                            }
                            i = 1;
                            if (f1 > this.p + this.o) {
                                break label986;
                            }
                            j = 1;
                            if ((i & j) != 0) {
                                if (f2 < this.q) {
                                    break label992;
                                }
                                i = 1;
                                if (f2 > this.q + this.o) {
                                    break label998;
                                }
                            }
                        }
                        for (j = m; ; j = 0) {
                            if (((i & j) != 0) && (this.a != null)) {
                                this.a.a(this);
                            }
                            this.n.setState(new int[0]);
                            break;
                            i = 0;
                            break label884;
                            j = 0;
                            break label902;
                            i = 0;
                            break label922;
                        }
                        bool1 = bool2;
                    } while (paramMotionEvent.getPointerCount() > 2);
                    bool1 = bool2;
                } while (this.m != 6);
                this.m = 0;
                return true;
                if (this.m == 2) {
                    this.g += f1 - this.K;
                    this.h += f2 - this.L;
                    paramMotionEvent = this.c;
                    paramMotionEvent.x += f1 - this.K;
                    paramMotionEvent = this.c;
                    paramMotionEvent.y += f2 - this.L;
                    this.K = f1;
                    this.L = f2;
                    return true;
                }
                if (this.m == 3) {
                    a(this.i + a(this.K, this.L, f1, f2));
                    f5 = this.I - (this.c.x + this.j.left);
                    f6 = this.J - (this.c.y + this.j.top);
                    f3 = f1 - (this.c.x + this.j.left);
                    f4 = f2 - (this.c.y + this.j.top);
                    f5 = (float) Math.sqrt(f5 * f5 + f6 * f6);
                    f3 = (float) Math.sqrt(f3 * f3 + f4 * f4) / f5 * this.N;
                    b(f3);
                    i = this.D.getIntrinsicWidth();
                    j = this.D.getIntrinsicHeight();
                    f4 = i;
                    f5 = this.M;
                    f6 = j;
                    f7 = this.M;
                    float f8 = i;
                    float f9 = j;
                    this.g -= (f8 * f3 - f4 * f5) / 2.0F;
                    this.h -= (f9 * f3 - f6 * f7) / 2.0F;
                    this.K = f1;
                    this.L = f2;
                    this.M = f3;
                    return true;
                }
                bool1 = bool2;
            } while (this.m != 6);
            f1 = b(paramMotionEvent);
            bool1 = bool2;
        } while (f1 <= 10.0F);
        f1 = f1 / this.S * this.N;
        b(f1);
        int i = this.D.getIntrinsicWidth();
        int j = this.D.getIntrinsicHeight();
        f2 = i;
        float f3 = this.M;
        float f4 = j;
        float f5 = this.M;
        float f6 = i;
        float f7 = j;
        this.g -= (f6 * f1 - f2 * f3) / 2.0F;
        this.h -= (f7 * f1 - f4 * f5) / 2.0F;
        this.M = f1;
        return true;
    }

    public void b(int paramInt) {
        this.C = paramInt;
    }

    public void b(int paramInt1, int paramInt2) {
        this.E = paramInt1;
        this.F = paramInt2;
    }

    public void b(RectF paramRectF) {
        float f1 = this.j.width();
        float f2 = this.j.height();
        float f4 = paramRectF.width();
        float f3 = paramRectF.height();
        f1 = f4 / f1;
        f2 = f3 / f2;
        if (f1 < f2) {
        }
        for (; ; ) {
            super.a(paramRectF);
            this.g *= f1;
            this.h *= f1;
            paramRectF = this.c;
            paramRectF.x *= f1;
            paramRectF = this.c;
            paramRectF.y *= f1;
            this.f = (f1 * this.f);
            return;
            f1 = f2;
        }
    }

    public StickersEntity g() {
        return this.z;
    }

    public int h() {
        return this.D.getIntrinsicWidth();
    }

    public int i() {
        return this.D.getIntrinsicHeight();
    }

    public int j() {
        return this.B;
    }

    public boolean k() {
        return this.A;
    }

    public int l() {
        return this.C;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */