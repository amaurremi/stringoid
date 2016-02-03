package mobi.ifunny.gallery.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.as;
import android.support.v4.view.ay;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class g {
    private static final int e = ;
    private static final int f = ViewConfiguration.getTapTimeout();
    private static final int g = ViewConfiguration.getDoubleTapTimeout();
    private int a;
    private int b;
    private int c;
    private int d;
    private final Handler h = new h(this);
    private final GestureDetector.OnGestureListener i;
    private i j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private MotionEvent q;
    private MotionEvent r;
    private MotionEvent s;
    private int t;
    private float u;
    private float v;
    private float w;
    private float x;
    private boolean y;
    private VelocityTracker z;

    public g(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener) {
        this.i = paramOnGestureListener;
        if ((paramOnGestureListener instanceof i)) {
            a((i) paramOnGestureListener);
        }
        a(paramContext);
    }

    private void a() {
        this.z.recycle();
        this.z = null;
        this.k = false;
        d();
    }

    private void a(Context paramContext) {
        if (paramContext == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (this.i == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        }
        this.y = true;
        paramContext = ViewConfiguration.get(paramContext);
        int i1 = paramContext.getScaledTouchSlop();
        int i2 = paramContext.getScaledDoubleTapSlop();
        this.c = paramContext.getScaledMinimumFlingVelocity();
        this.d = paramContext.getScaledMaximumFlingVelocity();
        this.a = (i1 * i1);
        this.b = (i2 * i2);
    }

    private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3) {
        if (!this.o) {
        }
        int i1;
        int i2;
        do {
            do {
                return false;
            } while (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > g);
            i1 = (int) paramMotionEvent1.getX() - (int) paramMotionEvent3.getX();
            i2 = (int) paramMotionEvent1.getY() - (int) paramMotionEvent3.getY();
        } while (i1 * i1 + i2 * i2 >= this.b);
        return true;
    }

    private void b() {
        d();
        this.t = 1;
    }

    private void b(MotionEvent paramMotionEvent) {
        if (!this.k) {
            d();
            this.j.a(paramMotionEvent);
            return;
        }
        this.l = true;
    }

    private void c() {
        this.h.removeMessages(1);
        this.h.removeMessages(2);
    }

    private void c(MotionEvent paramMotionEvent) {
        d();
        this.j.b(paramMotionEvent);
    }

    private void d() {
        c();
        this.h.removeMessages(3);
        this.t = 0;
        this.p = false;
        this.n = false;
        this.o = false;
        this.l = false;
        if (this.m) {
            this.m = false;
        }
    }

    private void d(MotionEvent paramMotionEvent) {
        d();
        this.j.c(paramMotionEvent);
    }

    private void e() {
        this.h.removeMessages(3);
        this.l = false;
        this.m = true;
        this.i.onLongPress(this.q);
    }

    public void a(i parami) {
        this.j = parami;
    }

    public void a(boolean paramBoolean) {
        this.y = paramBoolean;
    }

    public boolean a(MotionEvent paramMotionEvent) {
        boolean bool3 = false;
        boolean bool1 = false;
        int i5 = paramMotionEvent.getAction();
        if (this.z == null) {
            this.z = VelocityTracker.obtain();
        }
        this.z.addMovement(paramMotionEvent);
        int i1;
        int i2;
        label59:
        int i4;
        int i3;
        float f1;
        float f2;
        if ((i5 & 0xFF) == 6) {
            i1 = 1;
            if (i1 == 0) {
                break label101;
            }
            i2 = as.b(paramMotionEvent);
            i4 = as.c(paramMotionEvent);
            i3 = 0;
            f1 = 0.0F;
            f2 = 0.0F;
            label72:
            if (i3 >= i4) {
                break label128;
            }
            if (i2 != i3) {
                break label107;
            }
        }
        for (; ; ) {
            i3 += 1;
            break label72;
            i1 = 0;
            break;
            label101:
            i2 = -1;
            break label59;
            label107:
            f2 += as.c(paramMotionEvent, i3);
            f1 += as.d(paramMotionEvent, i3);
        }
        label128:
        boolean bool2;
        if (i1 != 0) {
            i1 = i4 - 1;
            f2 /= i1;
            f1 /= i1;
            bool2 = bool1;
        }
        float f3;
        label626:
        float f4;
        switch (i5 & 0xFF) {
            default:
                bool2 = bool1;
            case 4:
            case 5:
            case 6:
            case 0:
            case 2:
                do {
                    do {
                        return bool2;
                        i1 = i4;
                        break;
                        this.u = f2;
                        this.w = f2;
                        this.v = f1;
                        this.x = f1;
                        d();
                        return false;
                        this.u = f2;
                        this.w = f2;
                        this.v = f1;
                        this.x = f1;
                        this.z.computeCurrentVelocity(1000, this.d);
                        i2 = as.b(paramMotionEvent);
                        i1 = as.b(paramMotionEvent, i2);
                        f1 = ay.a(this.z, i1);
                        f2 = ay.b(this.z, i1);
                        i1 = 0;
                        bool2 = bool1;
                    } while (i1 >= i4);
                    if (i1 == i2) {
                    }
                    do {
                        i1 += 1;
                        break;
                        i3 = as.b(paramMotionEvent, i1);
                        f3 = ay.a(this.z, i3);
                    } while (ay.b(this.z, i3) * f2 + f3 * f1 >= 0.0F);
                    this.z.clear();
                    return false;
                    this.k = true;
                    this.l = false;
                    if (this.j != null) {
                        this.t += 1;
                        bool1 = this.h.hasMessages(3);
                        if (bool1) {
                            this.h.removeMessages(3);
                        }
                        if ((this.t <= 1) || ((bool1) && (this.q != null) && (this.r != null))) {
                            break label626;
                        }
                        b();
                        this.h.sendEmptyMessageDelayed(3, g);
                    }
                    for (; ; ) {
                        this.u = f2;
                        this.w = f2;
                        this.v = f1;
                        this.x = f1;
                        if (this.s != null) {
                            this.s.recycle();
                        }
                        this.s = this.q;
                        this.q = MotionEvent.obtain(paramMotionEvent);
                        this.n = true;
                        this.o = true;
                        this.m = false;
                        if (this.y) {
                            this.h.removeMessages(2);
                            this.h.sendEmptyMessageAtTime(2, this.q.getDownTime() + f + e);
                        }
                        this.h.sendEmptyMessageAtTime(1, this.q.getDownTime() + f);
                        return false | this.i.onDown(paramMotionEvent);
                        if ((this.t > 1) && (!a(this.q, this.r, paramMotionEvent))) {
                            if (bool1) {
                                if (this.t == 3) {
                                    c(paramMotionEvent);
                                } else if (this.t == 4) {
                                    d(paramMotionEvent);
                                } else {
                                    b(paramMotionEvent);
                                }
                            }
                        } else {
                            this.h.sendEmptyMessageDelayed(3, g);
                        }
                    }
                    bool2 = bool1;
                } while (this.m);
                f3 = this.u - f2;
                f4 = this.v - f1;
                if (this.p) {
                    return true;
                }
                if (this.n) {
                    i1 = (int) (f2 - this.w);
                    i2 = (int) (f1 - this.x);
                    i1 = i1 * i1 + i2 * i2;
                    if (i1 <= this.a) {
                        break label1229;
                    }
                    bool1 = this.i.onScroll(this.q, paramMotionEvent, f3, f4);
                    this.u = f2;
                    this.v = f1;
                    d();
                }
                break;
        }
        for (; ; ) {
            if (i1 > this.a) {
                this.o = false;
            }
            return bool1;
            if (Math.abs(f3) < 1.0F) {
                bool2 = bool1;
                if (Math.abs(f4) < 1.0F) {
                    break;
                }
            }
            bool1 = this.i.onScroll(this.q, paramMotionEvent, f3, f4);
            this.u = f2;
            this.v = f1;
            d();
            return bool1;
            this.k = false;
            c();
            MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
            if (this.p) {
                this.p = false;
                bool1 = true;
            }
            for (; ; ) {
                if (this.r != null) {
                    this.r.recycle();
                }
                this.r = localMotionEvent;
                bool2 = bool1;
                if (this.z == null) {
                    break;
                }
                this.z.recycle();
                this.z = null;
                return bool1;
                if (this.m) {
                    this.h.removeMessages(3);
                    this.m = false;
                    bool1 = bool3;
                } else if (this.n) {
                    bool2 = this.i.onSingleTapUp(paramMotionEvent);
                    bool1 = bool2;
                    if (this.l) {
                        bool1 = bool2;
                        if (this.j != null) {
                            b(paramMotionEvent);
                            bool1 = bool2;
                        }
                    }
                } else {
                    VelocityTracker localVelocityTracker = this.z;
                    i1 = as.b(paramMotionEvent, 0);
                    localVelocityTracker.computeCurrentVelocity(1000, this.d);
                    f1 = ay.b(localVelocityTracker, i1);
                    f2 = ay.a(localVelocityTracker, i1);
                    if (Math.abs(f1) <= this.c) {
                        bool1 = bool3;
                        if (Math.abs(f2) <= this.c) {
                        }
                    } else {
                        bool1 = this.i.onFling(this.q, paramMotionEvent, f2, f1);
                    }
                }
            }
            this.k = false;
            if ((this.j != null) && (this.h.hasMessages(3))) {
                if (this.t != 3) {
                    break label1197;
                }
                c(paramMotionEvent);
            }
            for (; ; ) {
                a();
                return false;
                label1197:
                if (this.t == 4) {
                    d(paramMotionEvent);
                } else if (this.t == 2) {
                    b(paramMotionEvent);
                }
            }
            label1229:
            bool1 = false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */