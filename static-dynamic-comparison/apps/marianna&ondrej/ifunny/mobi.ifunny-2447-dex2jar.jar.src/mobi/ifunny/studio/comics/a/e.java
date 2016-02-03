package mobi.ifunny.studio.comics.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mobi.ifunny.studio.comics.engine.c.c;
import mobi.ifunny.studio.comics.engine.c.k;
import mobi.ifunny.studio.comics.engine.c.l;

public class e {
    private static final String a = e.class.getSimpleName();

    public static Bitmap a(Context paramContext, mobi.ifunny.studio.a.b.a parama, Map<mobi.ifunny.studio.a.b.b, Bitmap> paramMap) {
        boolean bool = parama.a;
        parama = parama.b;
        int j = parama.size() * 480;
        Bitmap localBitmap2 = Bitmap.createBitmap(640, j, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap2);
        g localg;
        int i;
        label67:
        mobi.ifunny.studio.a.b.b localb;
        if (bool) {
            localg = g.a;
            Iterator localIterator = parama.iterator();
            i = 0;
            if (!localIterator.hasNext()) {
                break label182;
            }
            localb = (mobi.ifunny.studio.a.b.b) localIterator.next();
            if (paramMap != null) {
                break label148;
            }
            parama = a(paramContext, localb, g.c);
        }
        for (; ; ) {
            if (parama != null) {
                a(new Canvas(parama), 0, localg);
                localCanvas.drawBitmap(parama, 0.0F, i, null);
            }
            i += 480;
            break label67;
            localg = g.c;
            break;
            label148:
            Bitmap localBitmap1 = (Bitmap) paramMap.get(localb);
            parama = localBitmap1;
            if (localBitmap1 == null) {
                parama = a(paramContext, localb, g.c);
            }
        }
        label182:
        if (bool) {
            paramContext = new Paint();
            paramContext.setStyle(Paint.Style.STROKE);
            paramContext.setStrokeWidth(2.0F);
            paramContext.setColor(-16777216);
            localCanvas.drawRect(0.0F, 0.0F, 639.0F, j - 1, paramContext);
        }
        return localBitmap2;
    }

    public static Bitmap a(Context paramContext, mobi.ifunny.studio.a.b.b paramb, g paramg) {
        return a(paramContext, paramb, paramg, false);
    }

    public static Bitmap a(Context paramContext, mobi.ifunny.studio.a.b.b paramb, g paramg, boolean paramBoolean) {
        Bitmap localBitmap = Bitmap.createBitmap(640, 480, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawColor(paramb.a);
        paramb = paramb.b.iterator();
        while (paramb.hasNext()) {
            mobi.ifunny.studio.comics.engine.c.h localh = a(paramContext, (mobi.ifunny.studio.a.b.d) paramb.next());
            if (localh != null) {
                localh.b(localCanvas);
                localh.b();
            }
        }
        if ((paramg != g.c) && ((paramg != g.b) || (!paramBoolean))) {
            a(localCanvas, 0, paramg);
        }
        return localBitmap;
    }

    private static Bitmap a(Drawable paramDrawable) {
        if ((paramDrawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) paramDrawable).getBitmap();
        }
        if ((paramDrawable instanceof mobi.ifunny.view.drawable.f)) {
            return ((mobi.ifunny.view.drawable.f) paramDrawable).d();
        }
        return null;
    }

    public static mobi.ifunny.studio.a.b.d a(mobi.ifunny.studio.comics.engine.c.h paramh) {
        Object localObject2 = paramh.n();
        PointF localPointF = paramh.r();
        boolean bool = paramh.m();
        float f1 = mobi.ifunny.util.f.a(paramh.B());
        float f2 = paramh.A();
        Object localObject1 = null;
        switch (f.a[localObject2.ordinal()]) {
            default:
                mobi.ifunny.d.e(a, "itemFromPrimitive unknown type " + localObject2);
                paramh = (mobi.ifunny.studio.comics.engine.c.h) localObject1;
        }
        for (; ; ) {
            if (paramh != null) {
                paramh.b = localPointF.x;
                paramh.c = localPointF.y;
                paramh.d = bool;
            }
            return paramh;
            localObject1 = new mobi.ifunny.studio.a.b.f();
            ((mobi.ifunny.studio.a.b.f) localObject1).e = mobi.ifunny.util.a.b.a(a(((mobi.ifunny.studio.comics.engine.c.a) paramh).a()), Bitmap.CompressFormat.PNG, 100);
            ((mobi.ifunny.studio.a.b.f) localObject1).f = f1;
            ((mobi.ifunny.studio.a.b.f) localObject1).g = f2;
            paramh = (mobi.ifunny.studio.comics.engine.c.h) localObject1;
            continue;
            localObject1 = new mobi.ifunny.studio.a.b.h();
            paramh = (l) paramh;
            ((mobi.ifunny.studio.a.b.h) localObject1).e = paramh.a();
            ((mobi.ifunny.studio.a.b.h) localObject1).f = paramh.c();
            localObject2 = paramh.f().c();
            if (localObject2 == null) {
                ((mobi.ifunny.studio.a.b.h) localObject1).g = "normal";
            }
            for (; ; ) {
                ((mobi.ifunny.studio.a.b.h) localObject1).h = paramh.d();
                ((mobi.ifunny.studio.a.b.h) localObject1).i = paramh.e();
                paramh = paramh.w();
                ((mobi.ifunny.studio.a.b.h) localObject1).j = paramh.width();
                ((mobi.ifunny.studio.a.b.h) localObject1).k = paramh.height();
                paramh = (mobi.ifunny.studio.comics.engine.c.h) localObject1;
                break;
                switch (((Typeface) localObject2).getStyle()) {
                    default:
                        ((mobi.ifunny.studio.a.b.h) localObject1).g = "normal";
                        break;
                    case 1:
                        ((mobi.ifunny.studio.a.b.h) localObject1).g = "bold";
                        break;
                    case 2:
                        ((mobi.ifunny.studio.a.b.h) localObject1).g = "italic";
                        break;
                    case 3:
                        ((mobi.ifunny.studio.a.b.h) localObject1).g = "bold_italic";
                }
            }
            localObject1 = new mobi.ifunny.studio.a.b.g();
            paramh = (k) paramh;
            ((mobi.ifunny.studio.a.b.g) localObject1).e = paramh.c();
            ((mobi.ifunny.studio.a.b.g) localObject1).f = paramh.d();
            ((mobi.ifunny.studio.a.b.g) localObject1).g = f1;
            ((mobi.ifunny.studio.a.b.g) localObject1).h = f2;
            paramh = (mobi.ifunny.studio.comics.engine.c.h) localObject1;
            continue;
            localObject1 = new mobi.ifunny.studio.a.b.e();
            ((mobi.ifunny.studio.a.b.e) localObject1).e = mobi.ifunny.util.a.b.a(((c) paramh).f(), Bitmap.CompressFormat.PNG, 100);
            ((mobi.ifunny.studio.a.b.e) localObject1).f = f1;
            ((mobi.ifunny.studio.a.b.e) localObject1).g = f2;
            paramh = (mobi.ifunny.studio.comics.engine.c.h) localObject1;
        }
    }

    public static mobi.ifunny.studio.comics.engine.c.h a(Context paramContext, mobi.ifunny.studio.a.b.d paramd) {
        Object localObject1 = null;
        int i = paramd.a;
        switch (i) {
            default:
                mobi.ifunny.d.e(a, "object2primitive unknown type " + i);
                paramContext = null;
        }
        for (; ; ) {
            if (paramContext != null) {
                break label496;
            }
            mobi.ifunny.d.e(a, "object2primitive failed to create primitive with type " + i);
            return paramContext;
            localObject1 = (mobi.ifunny.studio.a.b.f) paramd;
            paramContext = new mobi.ifunny.util.a.a(null, false);
            paramContext = mobi.ifunny.util.a.b.b(((mobi.ifunny.studio.a.b.f) localObject1).e, paramContext);
            if (paramContext == null) {
                break;
            }
            paramContext = new mobi.ifunny.studio.comics.engine.c.a(new mobi.ifunny.view.drawable.f(paramContext));
            paramContext.c(mobi.ifunny.util.f.b(((mobi.ifunny.studio.a.b.f) localObject1).f));
            paramContext.b(((mobi.ifunny.studio.a.b.f) localObject1).g);
            continue;
            Object localObject2 = (mobi.ifunny.studio.a.b.h) paramd;
            Object localObject3 = ((mobi.ifunny.studio.a.b.h) localObject2).f;
            String str = ((mobi.ifunny.studio.a.b.h) localObject2).g;
            float f = ((mobi.ifunny.studio.a.b.h) localObject2).h;
            int j = ((mobi.ifunny.studio.a.b.h) localObject2).i;
            try {
                paramContext = Typeface.createFromAsset(paramContext.getAssets(), (String) localObject3);
                localObject1 = paramContext;
            } catch (Exception paramContext) {
                for (; ; ) {
                    continue;
                    paramContext = null;
                }
            }
            paramContext = (Context) localObject1;
            if (localObject1 == null) {
                if (!TextUtils.equals(str, "bold_italic")) {
                    break label271;
                }
                paramContext = Typeface.defaultFromStyle(3);
            }
            for (; ; ) {
                paramContext = new l(((mobi.ifunny.studio.a.b.h) localObject2).e, (String) localObject3, paramContext, f, j);
                paramContext.a(((mobi.ifunny.studio.a.b.h) localObject2).j);
                break;
                label271:
                if (TextUtils.equals(str, "bold")) {
                    paramContext = Typeface.defaultFromStyle(1);
                } else if (TextUtils.equals(str, "italic")) {
                    paramContext = Typeface.defaultFromStyle(2);
                } else {
                    paramContext = Typeface.defaultFromStyle(0);
                }
            }
            localObject1 = (mobi.ifunny.studio.a.b.g) paramd;
            localObject2 = ((mobi.ifunny.studio.a.b.g) localObject1).f;
            localObject3 = (Bitmap) mobi.ifunny.util.cache.a.a((String) localObject2, mobi.ifunny.util.cache.f.b(new mobi.ifunny.util.a.a((String) localObject2))).a;
            if (localObject3 == null) {
                break;
            }
            paramContext = new BitmapDrawable(paramContext.getResources(), (Bitmap) localObject3);
            paramContext = new k(((mobi.ifunny.studio.a.b.g) localObject1).e, (String) localObject2, paramContext);
            paramContext.c(mobi.ifunny.util.f.b(((mobi.ifunny.studio.a.b.g) localObject1).g));
            paramContext.b(((mobi.ifunny.studio.a.b.g) localObject1).h);
            continue;
            localObject1 = (mobi.ifunny.studio.a.b.e) paramd;
            paramContext = new mobi.ifunny.util.a.a(null, false);
            paramContext = mobi.ifunny.util.a.b.b(((mobi.ifunny.studio.a.b.e) localObject1).e, paramContext);
            if (paramContext == null) {
                break label529;
            }
            paramContext = ((mobi.ifunny.util.a.e) paramContext.c.get(0)).a;
            if (paramContext == null) {
                break;
            }
            paramContext = new c(paramContext);
            paramContext.c(mobi.ifunny.util.f.b(((mobi.ifunny.studio.a.b.e) localObject1).f));
            paramContext.b(((mobi.ifunny.studio.a.b.e) localObject1).g);
        }
        label496:
        paramContext.c(new PointF(paramd.b, paramd.c));
        paramContext.d(paramd.d);
        return paramContext;
    }

    private static void a(Canvas paramCanvas, int paramInt, g paramg) {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        switch (f.b[paramg.ordinal()]) {
            default:
                return;
            case 1:
                paramg = new Paint();
                paramg.setStyle(Paint.Style.STROKE);
                paramg.setStrokeWidth(paramInt);
                paramg.setColor(-16777216);
                paramCanvas.drawRect(0.0F, 0.0F, i - 1, j - 1, paramg);
                return;
        }
        paramg = new Paint();
        paramg.setStyle(Paint.Style.STROKE);
        paramg.setStrokeWidth(paramInt);
        paramg.setColor(-16777216);
        paramg.setPathEffect(new DashPathEffect(new float[]{15.0F, 15.0F}, 0.0F));
        paramCanvas.drawLine(0.0F, j - 1, i, j - 1, paramg);
    }

    public static void a(RectF paramRectF1, RectF paramRectF2, Matrix paramMatrix) {
        int i = 0;
        float[] arrayOfFloat = new float[8];
        arrayOfFloat[0] = paramRectF1.left;
        arrayOfFloat[1] = paramRectF1.top;
        arrayOfFloat[2] = paramRectF1.right;
        arrayOfFloat[3] = paramRectF1.top;
        arrayOfFloat[4] = paramRectF1.right;
        arrayOfFloat[5] = paramRectF1.bottom;
        arrayOfFloat[6] = paramRectF1.left;
        arrayOfFloat[7] = paramRectF1.bottom;
        paramMatrix.mapPoints(arrayOfFloat);
        paramRectF2.set(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38F, -3.4028235E38F);
        while (i < 4) {
            int j = i * 2;
            float f1 = arrayOfFloat[j];
            float f2 = arrayOfFloat[(j + 1)];
            if (paramRectF2.left > f1) {
                paramRectF2.left = f1;
            }
            if (paramRectF2.right < f1) {
                paramRectF2.right = f1;
            }
            if (paramRectF2.top > f2) {
                paramRectF2.top = f2;
            }
            if (paramRectF2.bottom < f2) {
                paramRectF2.bottom = f2;
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */