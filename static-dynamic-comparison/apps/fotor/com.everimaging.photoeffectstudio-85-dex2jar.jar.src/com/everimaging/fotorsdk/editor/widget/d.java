package com.everimaging.fotorsdk.editor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.FloatMath;
import android.view.MotionEvent;
import com.everimaging.fotorsdk.editor.R.color;
import com.everimaging.fotorsdk.editor.R.dimen;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.R.integer;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.feature.TextFeatureOptionController.ShadowType;
import com.everimaging.fotorsdk.editor.feature.TextFeatureTypefaceController.TypefaceInfo;
import com.everimaging.fotorsdk.plugins.c;
import com.everimaging.fotorsdk.plugins.g;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.utils.TypefaceUtils;

public class d
        extends a {
    private float A;
    private Drawable B;
    private int C;
    private float D;
    private float E;
    private Path F;
    private float G;
    private String H;
    private String I;
    private TextPaint J;
    private int K;
    private Bitmap L;
    private String M;
    private BitmapShader N;
    private Paint O;
    private TextFeatureTypefaceController.TypefaceInfo P;
    private g Q;
    private Layout.Alignment R;
    private StaticLayout S;
    private boolean T = false;
    private boolean U = false;
    private TextFeatureOptionController.ShadowType V = TextFeatureOptionController.ShadowType.ST_NONE;
    private int W = 100;
    private float X;
    private float Y;
    private float Z;
    private float aa;
    private float ab;
    private float ac;
    private float ad;
    private float ae;
    private float af;
    private float ag;
    private float ah;
    private float ai;
    private int aj;
    private float ak;
    private float al;
    private Drawable am;
    private float an = 0.0F;
    private int ao;
    private boolean n = false;
    private boolean o = true;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private Drawable t;
    private int u;
    private float v;
    private float w;
    private Drawable x;
    private int y;
    private float z;

    public d(Context paramContext) {
        super(paramContext);
        w();
    }

    private void a(boolean paramBoolean, float paramFloat) {
        float f1 = this.S.getWidth();
        float f2 = x();
        if (!paramBoolean) {
            this.g = (this.j.left + this.c.x - f1 / 2.0F);
            this.h = (this.j.top + this.c.y - f2 / 2.0F);
            this.l.reset();
            this.l.postTranslate(this.g, this.h);
            this.l.postRotate(this.i, this.j.left + this.c.x, this.j.top + this.c.y);
            this.l.postScale(this.f, this.f, this.j.left + this.c.x, this.j.top + this.c.y);
            return;
        }
        this.g = (this.c.x - f1 / 2.0F);
        this.h = (this.c.y - f2 / 2.0F);
        this.l.reset();
        this.l.postTranslate(this.g / paramFloat, this.h / paramFloat);
        this.l.postRotate(this.i, this.c.x / paramFloat, this.c.y / paramFloat);
        this.l.postScale(this.f, this.f, this.c.x / paramFloat, this.c.y / paramFloat);
        this.l.preScale(1.0F / paramFloat, 1.0F / paramFloat);
    }

    private void b(Canvas paramCanvas) {
        int i = Color.argb((int) (Color.alpha(this.aj) * this.W / 100.0F), Color.red(this.aj), Color.green(this.aj), Color.blue(this.aj));
        switch (1. a[this.V.ordinal()])
        {
        }
        for (; ; ) {
            if (this.V != TextFeatureOptionController.ShadowType.ST_NONE) {
                paramCanvas.save();
                paramCanvas.concat(this.l);
                this.J.setColor(i);
                this.J.setShader(null);
                this.J.setAlpha((int) (this.W * 255 / 100.0F));
                this.S.draw(paramCanvas);
                paramCanvas.restore();
            }
            i = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
            this.J.setColor(this.K);
            this.J.clearShadowLayer();
            this.J.setAlpha((int) (this.W * 255 / 100.0F));
            paramCanvas.save();
            paramCanvas.concat(this.l);
            this.S.draw(paramCanvas);
            paramCanvas.restore();
            if (this.N != null) {
                this.O.setShader(this.N);
                paramCanvas.drawPath(this.F, this.O);
                this.N.setLocalMatrix(null);
            }
            this.O.setShader(null);
            paramCanvas.restoreToCount(i);
            return;
            this.J.clearShadowLayer();
            continue;
            this.J.setShadowLayer(1.0F, -this.ak, this.al, i);
            continue;
            this.J.setShadowLayer(1.0F, 0.0F, this.al, i);
            continue;
            this.J.setShadowLayer(1.0F, this.ak, this.al, i);
        }
    }

    private boolean b(PointF paramPointF) {
        return a(paramPointF, new PointF[]{new PointF((int) this.e[0], (int) this.e[1]), new PointF((int) this.e[2], (int) this.e[3]), new PointF((int) this.e[4], (int) this.e[5]), new PointF((int) this.e[6], (int) this.e[7])});
    }

    private void w() {
        Resources localResources = this.k.getResources();
        this.ao = localResources.getInteger(R.integer.fotor_anim_short_duration);
        this.t = localResources.getDrawable(R.drawable.fotor_sticker_text_delete_button);
        this.u = this.t.getIntrinsicWidth();
        this.x = localResources.getDrawable(R.drawable.fotor_sticker_text_zoom_button);
        this.y = this.x.getIntrinsicWidth();
        this.B = localResources.getDrawable(R.drawable.fotor_sticker_text_reset_button);
        this.C = this.B.getIntrinsicWidth();
        this.am = localResources.getDrawable(R.drawable.fotor_text_item_background);
        this.X = localResources.getDimension(R.dimen.fotor_text_textsize_default);
        this.Y = localResources.getDimension(R.dimen.fotor_text_textsize_maximum);
        this.Z = localResources.getDimension(R.dimen.fotor_text_textsize_minimum);
        this.aa = localResources.getDimension(R.dimen.fotor_text_textsize_step);
        this.ab = (this.Z / this.X);
        this.ac = (this.Y / this.X);
        this.H = localResources.getString(R.string.fotor_text_default_text);
        this.I = new String(this.H);
        this.R = Layout.Alignment.ALIGN_NORMAL;
        this.G = localResources.getDimension(R.dimen.fotor_text_item_padding);
        this.K = -1;
        this.J = new TextPaint();
        this.J.setAntiAlias(true);
        this.J.setTextSize(this.X);
        this.J.setLinearText(true);
        this.J.setSubpixelText(true);
        this.F = new Path();
        this.aj = localResources.getColor(R.color.fotor_text_shadow_color);
        this.ak = localResources.getDimension(R.dimen.fotor_text_shadow_offset_x);
        this.al = localResources.getDimension(R.dimen.fotor_text_shadow_offset_y);
        this.O = new Paint();
        this.O.setStyle(Paint.Style.FILL);
        this.O.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private float x() {
        Paint.FontMetrics localFontMetrics = this.J.getFontMetrics();
        return localFontMetrics.bottom - localFontMetrics.top - (localFontMetrics.descent - localFontMetrics.ascent) + this.S.getHeight();
    }

    private void y() {
        if (this.a != null) {
            float f = 0.0F;
            if (this.i > 180.0F) {
                f = 360.0F;
            }
            a.c localc = new a.c(this, this.ao, this.i, f);
            this.a.a(localc);
        }
    }

    public void a(int paramInt) {
        this.K = paramInt;
        this.L = null;
        this.N = null;
        this.M = null;
        this.o = true;
    }

    public void a(Canvas paramCanvas) {
        if (this.o) {
            h();
        }
        a(false, 1.0F);
        i();
        paramCanvas.save();
        paramCanvas.concat(this.l);
        if (this.b) {
            if (this.n) {
                this.am.setState(new int[]{16842913});
                this.am.draw(paramCanvas);
            }
        } else {
            paramCanvas.restore();
            b(paramCanvas);
            if (this.b) {
                paramCanvas.save();
                paramCanvas.translate(this.v, this.w);
                if (!this.p) {
                    break label297;
                }
                this.t.setState(new int[]{16842919});
                label130:
                this.t.draw(paramCanvas);
                paramCanvas.restore();
                paramCanvas.save();
                paramCanvas.translate(this.D, this.E);
                if (!this.q) {
                    break label311;
                }
                this.B.setState(new int[]{16842919});
                label183:
                if (!this.n) {
                    break label325;
                }
                this.B.setAlpha(160);
                label200:
                this.B.draw(paramCanvas);
                paramCanvas.restore();
                paramCanvas.save();
                paramCanvas.translate(this.z, this.A);
                if (!this.r) {
                    break label338;
                }
                this.x.setState(new int[]{16842919});
                label253:
                if (!this.n) {
                    break label352;
                }
                this.x.setAlpha(160);
            }
        }
        for (; ; ) {
            this.x.draw(paramCanvas);
            paramCanvas.restore();
            return;
            this.am.setState(new int[0]);
            break;
            label297:
            this.t.setState(new int[0]);
            break label130;
            label311:
            this.B.setState(new int[0]);
            break label183;
            label325:
            this.B.setAlpha(255);
            break label200;
            label338:
            this.x.setState(new int[0]);
            break label253;
            label352:
            this.x.setAlpha(255);
        }
    }

    public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2) {
        if ((this.I.equals(this.H)) || (this.I.isEmpty())) {
            return;
        }
        paramFloat1 = this.j.width() / paramFloat1;
        paramFloat2 = this.j.height() / paramFloat2;
        if (paramFloat1 < paramFloat2) {
        }
        for (; ; ) {
            h();
            a(true, paramFloat1);
            i();
            if (this.N != null) {
                Matrix localMatrix = new Matrix();
                localMatrix.postTranslate(-this.j.left, -this.j.top);
                localMatrix.postScale(1.0F / paramFloat1, 1.0F / paramFloat1);
                this.N.setLocalMatrix(localMatrix);
            }
            b(paramCanvas);
            this.o = true;
            return;
            paramFloat1 = paramFloat2;
        }
    }

    public void a(RectF paramRectF) {
        super.a(paramRectF);
        this.c.set(this.j.width() / 2.0F, this.j.height() / 2.0F);
    }

    public void a(Layout.Alignment paramAlignment) {
        this.R = paramAlignment;
        this.o = true;
    }

    public void a(TextFeatureOptionController.ShadowType paramShadowType) {
        this.V = paramShadowType;
        this.o = true;
    }

    public void a(TextFeatureTypefaceController.TypefaceInfo paramTypefaceInfo) {
        if (paramTypefaceInfo == null) {
            return;
        }
        this.P = paramTypefaceInfo;
        this.Q = ((g) h.a(this.k, this.P.typefacePack));
        this.T = false;
        this.U = false;
        this.o = true;
    }

    public void a(String paramString) {
        this.I = new String(paramString);
        this.o = true;
    }

    public boolean a(MotionEvent paramMotionEvent) {
        boolean bool2 = true;
        float f3 = paramMotionEvent.getX();
        float f4 = paramMotionEvent.getY();
        boolean bool1;
        switch (paramMotionEvent.getAction()) {
            default:
                bool1 = false;
        }
        label144:
        label164:
        label203:
        label209:
        label215:
        label221:
        label241:
        label260:
        label280:
        label335:
        label341:
        label347:
        label353:
        label373:
        label392:
        label412:
        label467:
        label473:
        label479:
        label485:
        label520:
        label573:
        label1103:
        label1123:
        label1189:
        label1195:
        label1201:
        label1207:
        label1253:
        label1273:
        label1326:
        label1332:
        label1338:
        label1344:
        do {
            int i;
            int j;
            do {
                do {
                    return bool1;
                    if (this.m != 0) {
                        break;
                    }
                    this.ad = f3;
                    this.ae = f4;
                    this.af = f3;
                    this.ag = f4;
                    this.ah = this.f;
                    this.ai = this.f;
                    f1 = f4 - this.an;
                    if (this.b) {
                        if (f3 >= this.v) {
                            i = 1;
                            if (f3 > this.v + this.u) {
                                break label203;
                            }
                            j = 1;
                            if ((i & j) == 0) {
                                break label221;
                            }
                            if (f1 < this.w) {
                                break label209;
                            }
                            i = 1;
                            if (f1 > this.w + this.u) {
                                break label215;
                            }
                        }
                        for (j = 1; ; j = 0) {
                            if ((i & j) == 0) {
                                break label221;
                            }
                            this.p = true;
                            return true;
                            i = 0;
                            break;
                            j = 0;
                            break label144;
                            i = 0;
                            break label164;
                        }
                    }
                    if (this.b) {
                        if (f3 >= this.D) {
                            i = 1;
                            if (f3 > this.D + this.C) {
                                break label335;
                            }
                            j = 1;
                            if ((i & j) == 0) {
                                break label353;
                            }
                            if (f1 < this.E) {
                                break label341;
                            }
                            i = 1;
                            if (f1 > this.E + this.C) {
                                break label347;
                            }
                        }
                        for (j = 1; ; j = 0) {
                            if ((i & j) == 0) {
                                break label353;
                            }
                            bool1 = bool2;
                            if (this.n) {
                                break;
                            }
                            this.m = 4;
                            this.q = true;
                            return true;
                            i = 0;
                            break label241;
                            j = 0;
                            break label260;
                            i = 0;
                            break label280;
                        }
                    }
                    if (this.b) {
                        if (f3 >= this.z) {
                            i = 1;
                            if (f3 > this.z + this.y) {
                                break label467;
                            }
                            j = 1;
                            if ((i & j) == 0) {
                                break label485;
                            }
                            if (f1 < this.A) {
                                break label473;
                            }
                            i = 1;
                            if (f1 > this.A + this.y) {
                                break label479;
                            }
                        }
                        for (j = 1; ; j = 0) {
                            if ((i & j) == 0) {
                                break label485;
                            }
                            bool1 = bool2;
                            if (this.n) {
                                break;
                            }
                            this.m = 3;
                            this.r = true;
                            return true;
                            i = 0;
                            break label373;
                            j = 0;
                            break label392;
                            i = 0;
                            break label412;
                        }
                    }
                    if (!b(new PointF(f3, f1))) {
                        break label573;
                    }
                    if (!this.n) {
                        break label520;
                    }
                    bool1 = bool2;
                } while (this.b);
                this.m = 1;
                if (!this.b) {
                }
                for (this.s = true; ; this.s = false) {
                    this.b = true;
                    bool1 = bool2;
                    if (this.a == null) {
                        break;
                    }
                    this.a.b(this);
                    return true;
                }
                if (this.a != null) {
                    this.a.c(this);
                }
                this.b = false;
                break;
                if (!this.b) {
                    break;
                }
                if ((!this.p) && (this.m == 1) && (FloatMath.sqrt((f3 - this.ad) * (f3 - this.ad) + (f4 - this.ae) * (f4 - this.ae)) >= 5.0F)) {
                    this.m = 2;
                }
                if (this.m == 2) {
                    paramMotionEvent = this.c;
                    paramMotionEvent.x += f3 - this.af;
                    paramMotionEvent = this.c;
                    paramMotionEvent.y += f4 - this.ag;
                    this.af = f3;
                    this.ag = f4;
                }
                bool1 = bool2;
            } while (this.m != 3);
            a(this.i + a(this.af, this.ag - this.an, f3, f4 - this.an));
            float f5 = this.ad - (this.c.x + this.j.left);
            float f6 = this.ae - this.an - (this.c.y + this.j.top);
            float f1 = f3 - (this.c.x + this.j.left);
            float f2 = f4 - this.an - (this.c.y + this.j.top);
            f5 = (float) Math.sqrt(f5 * f5 + f6 * f6);
            f2 = (float) Math.sqrt(f1 * f1 + f2 * f2) / f5 * this.ai;
            f1 = f2;
            if (f2 > this.ac) {
                f1 = this.ac;
            }
            f2 = f1;
            if (f1 < this.ab) {
                f2 = this.ab;
            }
            b(f2);
            f1 = this.S.getWidth();
            f5 = x();
            f6 = this.ah;
            float f7 = this.ah;
            this.g -= (f1 * f2 - f6 * f1) / 2.0F;
            this.h -= (f5 * f2 - f7 * f5) / 2.0F;
            this.af = f3;
            this.ag = f4;
            this.ah = f2;
            return true;
            f1 = f4 - this.an;
            if (this.m == 2) {
                this.m = 0;
                return false;
            }
            this.m = 0;
            if ((this.p) && (this.b)) {
                if (f3 >= this.v) {
                    i = 1;
                    if (f3 > this.v + this.u) {
                        break label1189;
                    }
                    j = 1;
                    if ((i & j) == 0) {
                        break label1207;
                    }
                    if (f1 < this.w) {
                        break label1195;
                    }
                    i = 1;
                    if (f1 > this.w + this.u) {
                        break label1201;
                    }
                }
                for (j = 1; ; j = 0) {
                    if ((i & j) == 0) {
                        break label1207;
                    }
                    if (this.a != null) {
                        this.a.a(this);
                    }
                    this.p = false;
                    this.q = false;
                    this.r = false;
                    return true;
                    i = 0;
                    break;
                    j = 0;
                    break label1103;
                    i = 0;
                    break label1123;
                }
            }
            if ((this.q) && (this.b)) {
                if (f3 >= this.D) {
                    i = 1;
                    if (f3 > this.D + this.C) {
                        break label1326;
                    }
                    j = 1;
                    if ((i & j) == 0) {
                        break label1344;
                    }
                    if (f1 < this.E) {
                        break label1332;
                    }
                    i = 1;
                    if (f1 > this.E + this.C) {
                        break label1338;
                    }
                }
                for (j = 1; ; j = 0) {
                    if ((i & j) == 0) {
                        break label1344;
                    }
                    y();
                    this.p = false;
                    this.q = false;
                    this.r = false;
                    return true;
                    i = 0;
                    break;
                    j = 0;
                    break label1253;
                    i = 0;
                    break label1273;
                }
            }
            if ((this.r) && (this.b)) {
                this.p = false;
                this.q = false;
                this.r = false;
                return true;
            }
            this.p = false;
            this.q = false;
            this.r = false;
            if ((!this.b) || (this.s) || (FloatMath.sqrt((f3 - this.ad) * (f3 - this.ad) + (f1 - this.ae) * (f1 - this.ae)) >= 5.0F)) {
                break;
            }
            bool1 = bool2;
        } while (this.a == null);
        this.a.d(this);
        return true;
    }

    public void b(int paramInt) {
        this.W = paramInt;
        this.o = true;
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
            if (this.f < this.ab) {
                this.f = this.ab;
            }
            if (this.f > this.ac) {
                this.f = this.ac;
            }
            this.o = true;
            return;
            f1 = f2;
        }
    }

    public void b(String paramString) {
        if ((paramString == null) || (paramString.isEmpty())) {
            return;
        }
        this.M = paramString;
        try {
            int i = Integer.parseInt(paramString);
            paramString = new BitmapFactory.Options();
            paramString.inScaled = false;
            this.L = BitmapFactory.decodeResource(this.k.getResources(), i, paramString);
            this.N = new BitmapShader(this.L, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            this.o = true;
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    public void b(boolean paramBoolean) {
        this.n = paramBoolean;
        if (this.n == true) {
        }
        while (!this.I.equals("")) {
            return;
        }
        a(this.H);
    }

    public void c(boolean paramBoolean) {
        if (paramBoolean) {
            this.i -= 18.0F;
            if (this.i >= -360.0F) {
                break label55;
            }
            this.i += 360.0F;
        }
        label55:
        while (this.i <= 360.0F) {
            return;
            this.i += 18.0F;
            break;
        }
        this.i -= 360.0F;
    }

    public void d(boolean paramBoolean) {
        this.T = paramBoolean;
        this.o = true;
    }

    public void e(float paramFloat) {
        this.an = paramFloat;
    }

    public void e(boolean paramBoolean) {
        this.U = paramBoolean;
        this.o = true;
    }

    public void f(float paramFloat) {
        this.X = paramFloat;
        this.o = true;
    }

    public String g() {
        return this.H;
    }

    public void h() {
        Object localObject = null;
        String str;
        if (this.Q != null) {
            str = this.Q.a_();
            localObject = this.P.normal;
            if (!(this.Q instanceof c)) {
                break label280;
            }
        }
        label76:
        label118:
        label222:
        label241:
        label277:
        label280:
        for (int i = 1; ; i = 0) {
            float f1;
            if ((this.T) && (this.U)) {
                localObject = this.P.boldItalic;
                if (i == 0) {
                    break label222;
                }
                localObject = TypefaceUtils.createFromLocalPath(str, (String) localObject);
                this.J.setTypeface((Typeface) localObject);
                this.J.setTextSize(this.X);
                String[] arrayOfString = this.I.split("\n|\r\n|\r");
                int j = arrayOfString.length;
                i = 0;
                f1 = 0.0F;
                if (i >= j) {
                    break label241;
                }
                str = arrayOfString[i];
                localObject = str;
                if (str.length() == 0) {
                    localObject = " ";
                }
                float f2 = this.J.measureText((String) localObject);
                if (f2 <= f1) {
                    break label277;
                }
                f1 = f2;
            }
            for (; ; ) {
                i += 1;
                break label118;
                if (this.T) {
                    localObject = this.P.bold;
                    break;
                }
                if (this.U) {
                    localObject = this.P.italic;
                    break;
                }
                localObject = this.P.normal;
                break;
                localObject = TypefaceUtils.createFromAsset(this.Q.i(), str, (String) localObject);
                break label76;
                this.S = new StaticLayout(this.I, this.J, (int) f1 + 1, this.R, 1.0F, 0.0F, false);
                this.o = false;
                return;
            }
        }
    }

    public void i() {
        float f1 = this.S.getWidth();
        float f2 = x();
        this.d[0] = (0.0F - this.G * 2.0F);
        this.d[1] = (0.0F - this.G);
        this.d[2] = (this.G * 2.0F + f1);
        this.d[3] = (0.0F - this.G);
        this.d[4] = (f1 + this.G * 2.0F);
        this.d[5] = (this.G + f2);
        this.d[6] = (0.0F - this.G * 2.0F);
        this.d[7] = (f2 + this.G);
        float f3 = this.d[0];
        float f4 = this.d[1];
        float f5 = this.d[4];
        float f6 = this.d[5];
        float f9 = (f5 - f3) * this.f;
        float f7 = (f6 - f4) * this.f;
        float f8 = this.u;
        f1 = 1.0F;
        f2 = 1.0F;
        if (f9 < f8) {
            f1 = f8 / f9;
        }
        if (f7 < f8) {
            f2 = f8 / f7;
        }
        f1 = Math.max(f1, f2);
        RectF localRectF = new RectF(f3, f4, f5, f6);
        Object localObject = new Matrix();
        ((Matrix) localObject).postScale(f1, f1, localRectF.left + localRectF.width() / 2.0F, localRectF.top + localRectF.height() / 2.0F);
        ((Matrix) localObject).mapRect(localRectF);
        localObject = new Rect();
        ((Rect) localObject).left = ((int) localRectF.left);
        ((Rect) localObject).top = ((int) localRectF.top);
        ((Rect) localObject).right = ((int) localRectF.right);
        ((Rect) localObject).bottom = ((int) localRectF.bottom);
        this.am.setBounds((Rect) localObject);
        this.d[0] = localRectF.left;
        this.d[1] = localRectF.top;
        this.d[2] = localRectF.right;
        this.d[3] = localRectF.top;
        this.d[4] = localRectF.right;
        this.d[5] = localRectF.bottom;
        this.d[6] = localRectF.left;
        this.d[7] = localRectF.bottom;
        this.l.mapPoints(this.e, this.d);
        this.F.reset();
        this.F.moveTo(this.e[0], this.e[1]);
        this.F.lineTo(this.e[2], this.e[3]);
        this.F.lineTo(this.e[4], this.e[5]);
        this.F.lineTo(this.e[6], this.e[7]);
        this.F.close();
        this.v = (this.e[0] - this.u / 2.0F);
        this.w = (this.e[1] - this.u / 2.0F);
        this.t.setBounds(0, 0, this.u, this.u);
        this.D = (this.e[2] - this.C / 2.0F);
        this.E = (this.e[3] - this.C / 2.0F);
        this.B.setBounds(0, 0, this.C, this.C);
        this.z = (this.e[4] - this.y / 2.0F);
        this.A = (this.e[5] - this.y / 2.0F);
        this.x.setBounds(0, 0, this.y, this.y);
    }

    public String j() {
        return this.I;
    }

    public void k() {
        float f = this.X * this.f;
        this.f = ((this.aa + f) / f * this.f);
        if (this.f > this.ac) {
            this.f = this.ac;
        }
        this.o = true;
    }

    public void l() {
        float f = this.X * this.f;
        this.f = ((f - this.aa) / f * this.f);
        if (this.f < this.ab) {
            this.f = this.ab;
        }
        this.o = true;
    }

    public int m() {
        return this.K;
    }

    public String n() {
        return this.M;
    }

    public RectF o() {
        RectF localRectF = new RectF();
        this.F.computeBounds(localRectF, true);
        return localRectF;
    }

    public TextFeatureTypefaceController.TypefaceInfo p() {
        return this.P;
    }

    public boolean q() {
        return this.T;
    }

    public boolean r() {
        return this.U;
    }

    public Layout.Alignment s() {
        return this.R;
    }

    public TextFeatureOptionController.ShadowType t() {
        return this.V;
    }

    public int u() {
        return this.W;
    }

    public float v() {
        return this.X;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */