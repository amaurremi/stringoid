package mobi.ifunny.studio.comics.engine.a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.studio.comics.RageEditorActivity;
import mobi.ifunny.studio.comics.a.a;
import mobi.ifunny.studio.comics.engine.b.b;
import mobi.ifunny.studio.comics.engine.b.l;
import mobi.ifunny.studio.comics.engine.c;
import mobi.ifunny.studio.comics.engine.f;

public class i
        extends d
        implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    private Context a;
    private GestureDetector b;
    private n c = n.a;
    private PointF d;
    private PointF e;
    private RectF f;
    private float g;
    private float h;
    private float i;
    private float j;
    private boolean k;
    private mobi.ifunny.studio.comics.engine.c.h l;

    public i(Context paramContext, e parame) {
        this(paramContext, null, parame);
    }

    public i(Context paramContext, g paramg, e parame) {
        super(paramg, parame);
        this.a = paramContext;
        this.b = new GestureDetector(paramContext, this);
        this.b.setOnDoubleTapListener(this);
        this.k = false;
    }

    private Dialog a(mobi.ifunny.studio.comics.engine.c.h paramh) {
        String str1 = this.a.getResources().getString(2131689977);
        String str2 = this.a.getResources().getString(2131689975);
        String str3 = this.a.getResources().getString(2131689974);
        String str4 = this.a.getResources().getString(2131689976);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.a);
        paramh = new k(this, paramh);
        localBuilder.setItems(new String[]{str1, str2, str3, str4}, paramh);
        return localBuilder.create();
    }

    private Dialog a(mobi.ifunny.studio.comics.engine.c.h paramh, PointF paramPointF) {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = new ArrayList();
        Object localObject2 = this.a.getResources();
        if (paramh == null) {
            if (RageEditorActivity.p.b()) {
                localArrayList.add(m.b);
                ((ArrayList) localObject1).add(((Resources) localObject2).getString(2131689988));
            }
        }
        int m;
        for (; ; ) {
            m = ((ArrayList) localObject1).size();
            if (m != 0) {
                break;
            }
            return null;
            mobi.ifunny.studio.comics.engine.c.j localj = paramh.n();
            if ((paramh instanceof Cloneable)) {
                localArrayList.add(m.a);
                ((ArrayList) localObject1).add(((Resources) localObject2).getString(2131689982));
            }
            if ((localj == mobi.ifunny.studio.comics.engine.c.j.c) || (localj == mobi.ifunny.studio.comics.engine.c.j.e) || (localj == mobi.ifunny.studio.comics.engine.c.j.d) || (localj == mobi.ifunny.studio.comics.engine.c.j.f)) {
                localArrayList.add(m.d);
                ((ArrayList) localObject1).add(((Resources) localObject2).getString(2131689986));
            }
            if ((localj == mobi.ifunny.studio.comics.engine.c.j.d) || (localj == mobi.ifunny.studio.comics.engine.c.j.f)) {
                localArrayList.add(m.c);
                ((ArrayList) localObject1).add(((Resources) localObject2).getString(2131689985));
            }
            localArrayList.add(m.e);
            ((ArrayList) localObject1).add(((Resources) localObject2).getString(2131689973));
            localArrayList.add(m.f);
            ((ArrayList) localObject1).add(((Resources) localObject2).getString(2131689987));
        }
        localObject2 = new CharSequence[m];
        ((ArrayList) localObject1).toArray((Object[]) localObject2);
        localObject1 = new AlertDialog.Builder(this.a);
        ((AlertDialog.Builder) localObject1).setItems((CharSequence[]) localObject2, new j(this, localArrayList, paramh, paramPointF));
        ((AlertDialog.Builder) localObject1).setCancelable(true);
        paramh = ((AlertDialog.Builder) localObject1).create();
        paramh.setCanceledOnTouchOutside(true);
        return paramh;
    }

    private void a(float paramFloat1, float paramFloat2, mobi.ifunny.studio.comics.engine.c.h paramh) {
        double d2 = (Math.atan2(paramFloat2, paramFloat1) - this.g) * 180.0D / 3.141592653589793D;
        double d1 = d2;
        if (paramh.m()) {
            d1 = -d2;
        }
        paramh.c((float) (d1 + this.h));
        paramh.b((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) / this.i * this.j);
    }

    private void a(PointF paramPointF) {
        if (this.k) {
        }
        do {
            return;
            paramPointF = a(j().s(), paramPointF);
            e locale = i();
            if (locale != null) {
                locale.a(paramPointF);
            }
        } while (paramPointF == null);
        this.k = true;
        paramPointF.show();
        paramPointF.setOnDismissListener(this);
        paramPointF.setOnCancelListener(this);
    }

    private boolean b(MotionEvent paramMotionEvent) {
        float f1 = 0.0F;
        paramMotionEvent = j();
        mobi.ifunny.studio.comics.engine.c.h localh = paramMotionEvent.s();
        switch (l.a[this.c.ordinal()]) {
        }
        for (; ; ) {
            this.c = n.a;
            return true;
            PointF localPointF = localh.q();
            if ((localPointF.x != this.e.x) || (localPointF.y != this.e.y)) {
                paramMotionEvent.a(new mobi.ifunny.studio.comics.engine.b.h(localh, this.e, localPointF), c.b);
                continue;
                if (localh.n() != mobi.ifunny.studio.comics.engine.c.j.f) {
                    break;
                }
                f1 = this.f.width();
                f2 = localh.w().width();
                if (f2 != f1) {
                    paramMotionEvent.a(new mobi.ifunny.studio.comics.engine.b.k(localh, f1, f2), c.b);
                }
                paramMotionEvent.a(false);
            }
        }
        float f2 = localh.B();
        double d1 = Math.toRadians(f2);
        if ((Math.cos(d1) > 0.0D) && (Math.abs(Math.sin(d1)) < 0.08D)) {
            localh.c(0.0F);
        }
        for (; ; ) {
            f2 = localh.A();
            if ((f1 == this.h) && (f2 == this.j)) {
                break;
            }
            paramMotionEvent.a(new l(localh, new mobi.ifunny.studio.comics.engine.b.m(this.h, this.j), new mobi.ifunny.studio.comics.engine.b.m(f1, f2)), c.b);
            break;
            f1 = f2;
        }
    }

    public void a(int paramInt) {
        f localf = j();
        if (localf != null) {
            Object localObject = localf.u();
            localObject = new b((mobi.ifunny.studio.comics.engine.c.h) localObject, new Paint(((mobi.ifunny.studio.comics.engine.c.h) localObject).C()), false);
            ((b) localObject).a(paramInt);
            localf.a((mobi.ifunny.studio.comics.engine.b.i) localObject, c.a);
        }
    }

    public boolean a(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 82) {
            a(null);
            return true;
        }
        return false;
    }

    public boolean a(MotionEvent paramMotionEvent) {
        int n = 1;
        if (super.a(paramMotionEvent)) {
            return true;
        }
        int i1 = paramMotionEvent.getAction();
        int m = n;
        if (i1 != 1) {
            if (i1 != 3) {
                break label73;
            }
        }
        boolean bool;
        label73:
        for (m = n; ; m = 0) {
            bool = this.b.onTouchEvent(paramMotionEvent);
            if ((bool) || (m == 0)) {
                break;
            }
            this.l = null;
            bool = b(paramMotionEvent);
            this.l = null;
            return bool;
        }
        return bool;
    }

    public boolean b(int paramInt, KeyEvent paramKeyEvent) {
        return false;
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        this.k = false;
    }

    public void onDismiss(DialogInterface paramDialogInterface) {
        this.k = false;
    }

    public boolean onDoubleTap(MotionEvent paramMotionEvent) {
        paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
        a(h().a().a(paramMotionEvent));
        this.l = null;
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent paramMotionEvent) {
        this.c = n.a;
        paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
        paramMotionEvent = h().a().a(paramMotionEvent);
        f localf = j();
        this.l = localf.s();
        if ((this.l != null) && (this.l.k().contains(paramMotionEvent.x, paramMotionEvent.y))) {
            this.d = paramMotionEvent;
            this.f = new RectF(this.l.w());
            localObject = this.l.w();
            float f1 = paramMotionEvent.x - ((RectF) localObject).centerX();
            float f2 = paramMotionEvent.y - ((RectF) localObject).centerY();
            this.h = this.l.B();
            this.g = ((float) Math.atan2(f2, f1));
            this.j = this.l.A();
            this.i = (f2 * f2 + f1 * f1);
            localf.a(true);
            this.c = n.c;
            return true;
        }
        Object localObject = localf.a(0).c();
        int m = ((List) localObject).size() - 1;
        while (m >= 0) {
            mobi.ifunny.studio.comics.engine.c.h localh = (mobi.ifunny.studio.comics.engine.c.h) ((List) localObject).get(m);
            if (localh.p().contains(paramMotionEvent.x, paramMotionEvent.y)) {
                this.e = localh.q();
                this.d = paramMotionEvent;
                localf.a(localh);
                this.c = n.b;
                return true;
            }
            m -= 1;
        }
        localf.a(null);
        return true;
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        this.l = null;
        return false;
    }

    public void onLongPress(MotionEvent paramMotionEvent) {
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        paramFloat1 = 50.0F;
        paramMotionEvent1 = new PointF(paramMotionEvent2.getX(), paramMotionEvent2.getY());
        paramMotionEvent1 = h().a().a(paramMotionEvent1);
        paramMotionEvent2 = j().s();
        switch (l.a[this.c.ordinal()]) {
            default:
                return false;
            case 1:
                paramFloat1 = paramMotionEvent1.x;
                paramFloat2 = this.d.x;
                float f1 = paramMotionEvent1.y;
                float f2 = this.d.y;
                paramMotionEvent2.b(new PointF(paramFloat1 - paramFloat2 + this.e.x, f1 - f2 + this.e.y));
                return true;
        }
        RectF localRectF = paramMotionEvent2.w();
        if (paramMotionEvent2.n() == mobi.ifunny.studio.comics.engine.c.j.f) {
            paramFloat2 = paramMotionEvent1.x - this.d.x + this.f.width();
            if (paramFloat2 >= 50.0F) {
                break label303;
            }
        }
        for (; ; ) {
            paramMotionEvent2.a(paramFloat1);
            do {
                return true;
                a(paramMotionEvent1.x - localRectF.centerX(), paramMotionEvent1.y - localRectF.centerY(), paramMotionEvent2);
                paramFloat1 = paramMotionEvent2.u() * paramMotionEvent2.A();
                paramFloat2 = paramMotionEvent2.v() * paramMotionEvent2.A();
            } while ((paramFloat1 >= 50.0F) && (paramFloat2 >= 50.0F));
            if (paramFloat1 < paramFloat2) {
            }
            for (paramFloat1 = 50.0F * paramMotionEvent2.A() / paramFloat1; ; paramFloat1 = 50.0F * paramMotionEvent2.A() / paramFloat2) {
                paramMotionEvent2.b(paramFloat1);
                break;
            }
            label303:
            paramFloat1 = paramFloat2;
        }
    }

    public void onShowPress(MotionEvent paramMotionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
        paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
        paramMotionEvent = h().a().a(paramMotionEvent);
        if ((this.l != null) && (this.l.p().contains(paramMotionEvent.x, paramMotionEvent.y))) {
            a(paramMotionEvent);
            return true;
        }
        this.l = null;
        return false;
    }

    public boolean onSingleTapUp(MotionEvent paramMotionEvent) {
        return b(paramMotionEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */