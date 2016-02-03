package com.everimaging.fotorsdk.collage.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.everimaging.fotorsdk.collage.R.drawable;
import com.everimaging.fotorsdk.collage.entity.Axis;
import com.everimaging.fotorsdk.collage.entity.Axis.Direction;
import com.everimaging.fotorsdk.collage.utils.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollageAxisItemView
        extends ImageView {
    private a a;
    private b b;
    private List<PointF> c;
    private Axis d;
    private RectF e;
    private float f;
    private float g;

    public CollageAxisItemView(Context paramContext) {
        this(paramContext, null);
    }

    public CollageAxisItemView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public CollageAxisItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        b();
    }

    private ArrayList<PointF> a(ArrayList<Integer> paramArrayList) {
        ArrayList localArrayList = new ArrayList();
        if (paramArrayList != null) {
            paramArrayList = paramArrayList.iterator();
            while (paramArrayList.hasNext()) {
                Integer localInteger = (Integer) paramArrayList.next();
                localArrayList.add((PointF) this.c.get(localInteger.intValue()));
            }
        }
        return localArrayList;
    }

    private void a(float paramFloat1, float paramFloat2) {
        paramFloat1 = (paramFloat1 - this.f) / this.e.width();
        paramFloat2 = (paramFloat2 - this.g) / this.e.height();
        Object localObject3 = this.d.getBeginPositions();
        Object localObject2 = this.d.getEndPositions();
        Object localObject1 = this.d.getTargetPositions();
        localObject3 = a((ArrayList) localObject3);
        localObject2 = a((ArrayList) localObject2);
        localObject1 = a((ArrayList) localObject1);
        Axis.Direction localDirection = this.d.getDirection();
        PointF localPointF1;
        PointF localPointF2;
        float f1;
        float f2;
        if ((localDirection == Axis.Direction.H) || (localDirection == Axis.Direction.V)) {
            localPointF1 = (PointF) ((ArrayList) localObject3).get(0);
            localPointF2 = (PointF) ((ArrayList) localObject2).get(0);
            if (localDirection == Axis.Direction.H) {
                f1 = localPointF1.x;
                f2 = localPointF2.x;
                localObject3 = ((ArrayList) localObject3).iterator();
                while (((Iterator) localObject3).hasNext()) {
                    f1 = Math.max(f1, ((PointF) ((Iterator) localObject3).next()).x);
                }
                localObject2 = ((ArrayList) localObject2).iterator();
                while (((Iterator) localObject2).hasNext()) {
                    f2 = Math.min(f2, ((PointF) ((Iterator) localObject2).next()).x);
                }
                localObject2 = ((ArrayList) localObject1).iterator();
                if (((Iterator) localObject2).hasNext()) {
                    localObject3 = (PointF) ((Iterator) localObject2).next();
                    paramFloat2 = paramFloat1;
                    if (((PointF) localObject3).x + paramFloat1 - f1 < 0.16666667F) {
                        paramFloat2 = 0.16666667F + f1 - ((PointF) localObject3).x;
                    }
                    if (f2 - (((PointF) localObject3).x + paramFloat2) >= 0.16666667F) {
                        break label1220;
                    }
                }
            }
        }
        label1192:
        label1200:
        label1203:
        label1208:
        label1213:
        label1220:
        for (paramFloat1 = f2 - 0.16666667F - ((PointF) localObject3).x; ; paramFloat1 = paramFloat2) {
            break;
            paramFloat2 = paramFloat1;
            paramFloat1 = 0.0F;
            for (; ; ) {
                localObject1 = ((ArrayList) localObject1).iterator();
                while (((Iterator) localObject1).hasNext()) {
                    localObject2 = (PointF) ((Iterator) localObject1).next();
                    ((PointF) localObject2).x += paramFloat2;
                    ((PointF) localObject2).y += paramFloat1;
                    continue;
                    if (localDirection != Axis.Direction.V) {
                        break label1213;
                    }
                    f1 = localPointF1.y;
                    f2 = localPointF2.y;
                    localObject3 = ((ArrayList) localObject3).iterator();
                    while (((Iterator) localObject3).hasNext()) {
                        f1 = Math.max(f1, ((PointF) ((Iterator) localObject3).next()).y);
                    }
                    localObject2 = ((ArrayList) localObject2).iterator();
                    while (((Iterator) localObject2).hasNext()) {
                        f2 = Math.min(f2, ((PointF) ((Iterator) localObject2).next()).y);
                    }
                    localObject2 = ((ArrayList) localObject1).iterator();
                    paramFloat1 = paramFloat2;
                    if (!((Iterator) localObject2).hasNext()) {
                        break label1208;
                    }
                    localObject3 = (PointF) ((Iterator) localObject2).next();
                    paramFloat2 = paramFloat1;
                    if (((PointF) localObject3).y + paramFloat1 - f1 < 0.16666667F) {
                        paramFloat2 = 0.16666667F + f1 - ((PointF) localObject3).y;
                    }
                    if (f2 - (((PointF) localObject3).y + paramFloat2) >= 0.16666667F) {
                        break label1203;
                    }
                }
                for (paramFloat1 = f2 - 0.16666667F - ((PointF) localObject3).y; ; paramFloat1 = paramFloat2) {
                    break;
                    int k;
                    int j;
                    int i;
                    if ((localDirection == Axis.Direction.H_DIA) || (localDirection == Axis.Direction.V_DIA)) {
                        k = ((ArrayList) localObject3).size();
                        j = 0;
                        i = 0;
                        if (j < ((ArrayList) localObject1).size()) {
                            if (j >= k) {
                                break label1200;
                            }
                            i = j;
                        }
                    }
                    for (; ; ) {
                        localPointF1 = (PointF) ((ArrayList) localObject3).get(i);
                        localPointF2 = (PointF) ((ArrayList) localObject2).get(i);
                        localPointF1 = new PointF(localPointF1.x, localPointF1.y);
                        localPointF2 = new PointF(localPointF2.x, localPointF2.y);
                        PointF localPointF3 = (PointF) ((ArrayList) localObject1).get(j);
                        float f3;
                        if (localDirection == Axis.Direction.H_DIA) {
                            f3 = Math.min(localPointF1.x, localPointF2.x);
                            f2 = Math.max(localPointF1.x, localPointF2.x);
                            f1 = paramFloat1;
                            if (localPointF3.x + paramFloat1 - f3 < 0.16666667F) {
                                f1 = f3 + 0.16666667F - localPointF3.x;
                            }
                            paramFloat1 = f1;
                            if (f2 - (localPointF3.x + f1) < 0.16666667F) {
                                paramFloat1 = f2 - 0.16666667F - localPointF3.x;
                            }
                        }
                        for (; ; ) {
                            j += 1;
                            break;
                            f1 = paramFloat2;
                            if (localDirection == Axis.Direction.V_DIA) {
                                f1 = Math.min(localPointF1.y, localPointF2.y);
                                f3 = Math.max(localPointF1.y, localPointF2.y);
                                f2 = paramFloat2;
                                if (localPointF3.y + paramFloat2 - f1 < 0.16666667F) {
                                    f2 = f1 + 0.16666667F - localPointF3.y;
                                }
                                f1 = f2;
                                if (f3 - (localPointF3.y + f2) < 0.16666667F) {
                                    paramFloat2 = f3 - 0.16666667F - localPointF3.y;
                                    continue;
                                    j = 0;
                                    if (j < ((ArrayList) localObject1).size()) {
                                        if (j >= k) {
                                            break label1192;
                                        }
                                        i = j;
                                    }
                                    for (; ; ) {
                                        localPointF1 = (PointF) ((ArrayList) localObject1).get(j);
                                        localPointF3 = (PointF) ((ArrayList) localObject3).get(i);
                                        localPointF2 = (PointF) ((ArrayList) localObject2).get(i);
                                        localPointF3 = new PointF(localPointF3.x, localPointF3.y);
                                        localPointF2 = new PointF(localPointF2.x, localPointF2.y);
                                        if (localDirection == Axis.Direction.H_DIA) {
                                            if (i == j) {
                                                f1 = paramFloat1 * (float) Math.tan(a.b(localPointF3, localPointF2));
                                                localPointF1.x += paramFloat1;
                                                localPointF1.y += f1;
                                                paramFloat2 = paramFloat1;
                                                paramFloat1 = f1;
                                            }
                                        }
                                        for (; ; ) {
                                            j += 1;
                                            f1 = paramFloat2;
                                            paramFloat2 = paramFloat1;
                                            paramFloat1 = f1;
                                            break;
                                            localPointF1.x += paramFloat1;
                                            f1 = paramFloat1;
                                            paramFloat1 = paramFloat2;
                                            paramFloat2 = f1;
                                            continue;
                                            if (localDirection == Axis.Direction.V_DIA) {
                                                if (i == j) {
                                                    f1 = paramFloat2 * (float) Math.tan(1.5707963267948966D - a.b(localPointF3, localPointF2));
                                                    localPointF1.x += f1;
                                                    localPointF1.y += paramFloat2;
                                                    paramFloat1 = paramFloat2;
                                                    paramFloat2 = f1;
                                                } else {
                                                    localPointF1.y += paramFloat2;
                                                }
                                            } else {
                                                f1 = paramFloat1;
                                                paramFloat1 = paramFloat2;
                                                paramFloat2 = f1;
                                            }
                                        }
                                        if (this.a != null) {
                                            this.a.a();
                                        }
                                        return;
                                    }
                                }
                            }
                            paramFloat2 = f1;
                        }
                    }
                }
                paramFloat2 = 0.0F;
                continue;
                paramFloat1 = 0.0F;
                paramFloat2 = 0.0F;
            }
        }
    }

    private void a(Axis paramAxis) {
        paramAxis = paramAxis.getDirection();
        switch (1. a[paramAxis.ordinal()])
        {
            default:
                return;
            case 1:
            case 2:
            case 3:
                setImageResource(R.drawable.fotor_collage_pivot_btn_round);
                return;
            case 4:
                setImageResource(R.drawable.fotor_collage_pivot_btn_hor);
                return;
        }
        setImageResource(R.drawable.fotor_collage_pivot_btn_ver);
    }

    private void b() {
        setClickable(true);
    }

    public void a() {
        Object localObject = getDrawable();
        if ((localObject != null) && (this.e != null)) {
            int i = ((Drawable) localObject).getIntrinsicWidth();
            int j = ((Drawable) localObject).getIntrinsicHeight();
            localObject = this.d.getPositions();
            localObject = a.a((PointF) this.c.get(((Integer) ((List) localObject).get(0)).intValue()), (PointF) this.c.get(((Integer) ((List) localObject).get(1)).intValue()), 0.5F);
            float f1 = this.e.left;
            float f2 = this.e.width();
            float f3 = ((PointF) localObject).x;
            float f4 = this.e.top;
            float f5 = this.e.height();
            float f6 = ((PointF) localObject).y;
            localObject = new FrameLayout.LayoutParams(i, j);
            ((FrameLayout.LayoutParams) localObject).leftMargin = ((int) (f1 + f2 * f3 - i / 2.0F + 0.5F));
            ((FrameLayout.LayoutParams) localObject).topMargin = ((int) (f6 * f5 + f4 - j / 2.0F + 0.5F));
            ((FrameLayout.LayoutParams) localObject).gravity = 51;
            setLayoutParams((ViewGroup.LayoutParams) localObject);
        }
    }

    public void a(RectF paramRectF) {
        this.e = paramRectF;
        a();
    }

    public void a(Axis paramAxis, List<PointF> paramList) {
        this.d = paramAxis;
        this.c = paramList;
        if (this.d != null) {
            a(paramAxis);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if ((this.b != null) && (this.b.c(this))) {
        }
        float f1;
        float f2;
        do {
            do {
                return true;
                f1 = paramMotionEvent.getRawX();
                f2 = paramMotionEvent.getRawY();
                switch (paramMotionEvent.getAction()) {
                    default:
                        return true;
                    case 0:
                        this.f = f1;
                        this.g = f2;
                        setPressed(true);
                }
            } while (this.b == null);
            this.b.a(this);
            return true;
            setPressed(false);
        } while (this.b == null);
        this.b.b(this);
        return true;
        a(f1, f2);
        this.f = f1;
        this.g = f2;
        return true;
    }

    public void setActionDelegate(b paramb) {
        this.b = paramb;
    }

    public void setAxisItemListener(a parama) {
        this.a = parama;
    }

    public static abstract interface a {
        public abstract void a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/CollageAxisItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */