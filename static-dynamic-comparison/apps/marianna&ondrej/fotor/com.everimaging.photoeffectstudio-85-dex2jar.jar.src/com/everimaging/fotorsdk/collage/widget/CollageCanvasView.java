package com.everimaging.fotorsdk.collage.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v8.renderscript.RenderScript;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.collage.R.anim;
import com.everimaging.fotorsdk.collage.R.integer;
import com.everimaging.fotorsdk.collage.c;
import com.everimaging.fotorsdk.collage.entity.Attachment;
import com.everimaging.fotorsdk.collage.entity.ImageInfo;
import com.everimaging.fotorsdk.collage.entity.SVGHole;
import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.collage.entity.Template.LayoutType;
import com.everimaging.fotorsdk.collage.f;
import com.everimaging.fotorsdk.collage.g;
import com.everimaging.fotorsdk.collage.params.CollageSlotItemParam;
import com.everimaging.fotorsdk.collage.params.TemplateParam;
import com.everimaging.fotorsdk.collage.utils.e;
import com.everimaging.fotorsdk.filter.a.a;
import com.everimaging.fotorsdk.imagepicker.Picture;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.plugins.h.b;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollageCanvasView
        extends FrameLayout
        implements CollageSlotItemView.c, CollageSlotItemView.d, a.a {
    private static final String a = CollageCanvasView.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private boolean A = true;
    private int B;
    private List<ICollageViewItem> c;
    private SparseArray<CollageSlotItemView> d;
    private SparseArray<CollageAttachmentItemView> e;
    private Template f;
    private h.b g;
    private Paint h;
    private int i;
    private int j;
    private float k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private PaintFlagsDrawFilter p;
    private ImageView q = null;
    private d r;
    private b s;
    private c t;
    private a u;
    private CollageSlotItemView v;
    private b w;
    private com.everimaging.fotorsdk.collage.painter.b x;
    private f y;
    private boolean z = true;

    public CollageCanvasView(Context paramContext) {
        this(paramContext, null);
    }

    public CollageCanvasView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public CollageCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        f();
    }

    private void a(float paramFloat1, float paramFloat2) {
        float f1 = 2.0F * paramFloat1;
        paramFloat1 = this.i - (f1 + paramFloat2);
        paramFloat2 = this.j - (f1 + paramFloat2);
        if (this.s != null) {
            RectF localRectF = new RectF();
            localRectF.left = (getLeft() + (this.i - paramFloat1) / 2.0F);
            localRectF.top = (getTop() + (this.j - paramFloat2) / 2.0F);
            localRectF.right = (paramFloat1 + localRectF.left);
            localRectF.bottom = (paramFloat2 + localRectF.top);
            this.s.a(localRectF);
        }
    }

    @SuppressLint({"NewApi"})
    private void f() {
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.o = false;
        this.i = 0;
        this.j = 0;
        this.c = new ArrayList();
        this.d = new SparseArray();
        this.e = new SparseArray();
        this.k = 0.0F;
        this.l = 0.0F;
        this.m = 0.0F;
        this.n = 0.0F;
        this.h = new Paint();
        this.h.setColor(-3355444);
        this.p = new PaintFlagsDrawFilter(0, 3);
        this.x = new com.everimaging.fotorsdk.collage.painter.b(getContext());
    }

    private void g() {
        int i5 = 0;
        if (this.f != null) {
            this.c.clear();
            this.d.clear();
            this.e.clear();
            ArrayList localArrayList;
            Object localObject1;
            int i1;
            int i2;
            int i3;
            label96:
            int i4;
            Object localObject2;
            switch (3. a[this.f.getType().ordinal()])
            {
                default:
                    localArrayList = null;
                    localObject1 = null;
                    i1 = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = i5;
                    if (i3 >= i2) {
                        break label336;
                    }
                    localObject2 = new CollageSlotItemView(getContext());
                    ((CollageSlotItemView) localObject2).setFilterContext(this);
                    ((CollageSlotItemView) localObject2).setSlotIndex(i3);
                    ((CollageSlotItemView) localObject2).setOnSlotClickListener(this);
                    ((CollageSlotItemView) localObject2).setOnSlotLongPressListener(this);
                    if (localObject1 != null) {
                        ((CollageSlotItemView) localObject2).setZIndex(((SVGHole) ((List) localObject1).get(i3)).getzIndex());
                    }
                    break;
            }
            for (; ; ) {
                this.d.put(i3, localObject2);
                this.c.add(localObject2);
                i3 += 1;
                break label96;
                localArrayList = null;
                localObject1 = null;
                i1 = 0;
                i2 = 0;
                break;
                localArrayList = null;
                localObject1 = null;
                i1 = 0;
                i2 = 0;
                break;
                i2 = this.f.getPolygons().size();
                localObject1 = null;
                i1 = 0;
                localArrayList = null;
                break;
                localArrayList = null;
                localObject1 = null;
                i1 = 0;
                i2 = 0;
                break;
                localObject1 = this.f.getSvgHoles();
                localArrayList = this.f.getAttachments();
                i2 = this.f.getSvgHoles().size();
                i1 = this.f.getAttachments().size();
                break;
                localObject1 = this.f.getSvgHoles();
                i2 = this.f.getSvgHoles().size();
                i1 = 0;
                localArrayList = null;
                break;
                ((CollageSlotItemView) localObject2).setZIndex(i3);
            }
            label336:
            while (i4 < i1) {
                localObject1 = new CollageAttachmentItemView(getContext());
                localObject2 = (Attachment) localArrayList.get(i4);
                ((CollageAttachmentItemView) localObject1).setZIndex(((Attachment) localObject2).getzIndex());
                this.e.put(((Attachment) localObject2).getzIndex(), localObject1);
                this.c.add(localObject1);
                i4 += 1;
            }
            this.y.e().post(new Runnable() {
                public void run() {
                    CollageCanvasView.this.removeAllViews();
                    CollageCanvasView.this.a();
                    CollageCanvasView.this.startAnimation(AnimationUtils.loadAnimation(CollageCanvasView.this.getContext(), R.anim.fotor_collage_view_fade_in));
                }
            });
            b();
        }
    }

    private void h() {
        ArrayList localArrayList = new ArrayList();
        if (this.c != null) {
            Iterator localIterator = this.c.iterator();
            while (localIterator.hasNext()) {
                Object localObject = (ICollageViewItem) localIterator.next();
                if (((ICollageViewItem) localObject).getDrawItemType() == ICollageViewItem.CollageDrawItemType.SLOT) {
                    localObject = (CollageSlotItemView) localObject;
                    Path localPath = ((CollageSlotItemView) localObject).getOrgDrawPath();
                    if (localPath != null) {
                        if (this.A) {
                            localArrayList.add(localPath);
                        } else if (((CollageSlotItemView) localObject).e()) {
                            localArrayList.add(localPath);
                        }
                    }
                }
            }
        }
        this.x.a(this.m, localArrayList);
    }

    public CollageSlotItemView a(int paramInt) {
        return (CollageSlotItemView) this.d.get(paramInt);
    }

    public void a() {
        int i1;
        int i2;
        float f1;
        float f2;
        Object localObject1;
        if ((this.i == getWidth()) && (this.j == getHeight()) && (this.f != null)) {
            i1 = this.i;
            i2 = this.j;
            int i3 = Math.min(i1, i2);
            f1 = i3;
            f1 = this.k * f1;
            f2 = i3;
            f2 = this.l * f2;
            switch (3. a[this.f.getType().ordinal()])
            {
                default:
                    localObject1 = null;
            }
        }
        label504:
        for (; ; ) {
            a(f2, f1);
            Object localObject2;
            if (localObject1 != null) {
                i1 = 0;
                for (; ; ) {
                    if (i1 < ((List) localObject1).size()) {
                        localObject2 = (Path) ((List) localObject1).get(i1);
                        ((CollageSlotItemView) this.d.get(i1)).a((Path) localObject2);
                        i1 += 1;
                        continue;
                        localObject1 = null;
                        break;
                        localObject1 = null;
                        break;
                        localObject1 = e.a(this.f, this.i, this.j, f2, f1, this.n);
                        break;
                        localObject1 = null;
                        break;
                        float f3 = Math.min(this.i / this.f.getOriginalWidth(), this.j / this.f.getOriginalHeight());
                        localObject1 = e.a(this.f, (h.a) this.g, f3);
                        localObject2 = this.f.getAttachments();
                        if (localObject2 == null) {
                            break label504;
                        }
                        localObject2 = ((List) localObject2).iterator();
                        while (((Iterator) localObject2).hasNext()) {
                            Attachment localAttachment = (Attachment) ((Iterator) localObject2).next();
                            i1 = localAttachment.getzIndex();
                            CollageAttachmentItemView localCollageAttachmentItemView = (CollageAttachmentItemView) this.e.get(i1);
                            if (localCollageAttachmentItemView != null) {
                                localCollageAttachmentItemView.a(localAttachment, (h.a) this.g, f3);
                            }
                        }
                        break;
                        localObject1 = e.a(this.f, (h.a) this.g, i1, i2, f2);
                        break;
                    }
                }
            }
            if ((!this.o) && (this.c != null)) {
                Collections.sort(this.c, new com.everimaging.fotorsdk.collage.utils.b());
                localObject1 = this.c.iterator();
                while (((Iterator) localObject1).hasNext()) {
                    localObject2 = (View) ((Iterator) localObject1).next();
                    if (((View) localObject2).getParent() == null) {
                        addView((View) localObject2, ((View) localObject2).getLayoutParams());
                    }
                }
                requestLayout();
            }
            invalidate();
            this.o = true;
            return;
        }
    }

    public void a(int paramInt1, int paramInt2) {
        this.i = paramInt1;
        this.j = paramInt2;
    }

    public void a(CollageSlotItemView paramCollageSlotItemView) {
        if (this.r != null) {
            this.r.a(paramCollageSlotItemView);
        }
    }

    public void a(CollageSlotItemView paramCollageSlotItemView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        if (this.y.n()) {
        }
        do {
            do {
                return;
            } while ((this.q == null) || (this.q.getWidth() <= 0) || (this.q.getHeight() <= 0));
            paramCollageSlotItemView = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            paramCollageSlotItemView.leftMargin = ((int) (paramCollageSlotItemView.leftMargin + paramFloat3 + 0.5F));
            paramCollageSlotItemView.topMargin = ((int) (paramCollageSlotItemView.topMargin + paramFloat4 + 0.5F));
            this.q.requestLayout();
            paramCollageSlotItemView = new int[2];
            getLocationOnScreen(paramCollageSlotItemView);
        } while (this.c == null);
        int i1 = this.c.size() - 1;
        while (i1 >= 0) {
            Object localObject = (ICollageViewItem) this.c.get(i1);
            if (((ICollageViewItem) localObject).getDrawItemType() == ICollageViewItem.CollageDrawItemType.SLOT) {
                localObject = (CollageSlotItemView) localObject;
                if (((CollageSlotItemView) localObject).a(paramFloat1 - paramCollageSlotItemView[0], paramFloat2 - paramCollageSlotItemView[1])) {
                    if ((this.v != null) && (this.v != localObject)) {
                        this.v.setShowMask(false);
                    }
                    ((CollageSlotItemView) localObject).setShowMask(true);
                    this.v = ((CollageSlotItemView) localObject);
                    return;
                }
            }
            i1 -= 1;
        }
        if (this.v != null) {
            this.v.setShowMask(false);
        }
        this.v = null;
    }

    public void b() {
        if (this.u != null) {
            this.u.cancel(true);
        }
        this.u = new a(getContext(), getWidth(), getHeight());
        this.u.execute(new Void[0]);
    }

    public void b(int paramInt) {
        this.B = paramInt;
        this.w.setAxisVisible(false);
        int i1 = 0;
        if (i1 < this.d.size()) {
            CollageSlotItemView localCollageSlotItemView = (CollageSlotItemView) this.d.valueAt(i1);
            if (paramInt == localCollageSlotItemView.getSlotIndex()) {
                localCollageSlotItemView.setTouchSwitchType(CollageSlotItemView.SlotTouchSwitchType.Source);
            }
            for (; ; ) {
                i1 += 1;
                break;
                localCollageSlotItemView.setTouchSwitchType(CollageSlotItemView.SlotTouchSwitchType.Target);
            }
        }
    }

    public void b(CollageSlotItemView paramCollageSlotItemView) {
        if (this.y.n()) {
        }
        while (this.q == null) {
            return;
        }
        removeView(this.q);
        this.q = null;
        if ((this.v != null) && (this.v != paramCollageSlotItemView)) {
            ImageInfo localImageInfo1 = this.v.getImageInfo();
            ImageInfo localImageInfo2 = paramCollageSlotItemView.getImageInfo();
            int i1 = paramCollageSlotItemView.getSlotIndex();
            int i2 = this.v.getSlotIndex();
            Object localObject = this.v.getSlotItemParam();
            CollageSlotItemParam localCollageSlotItemParam = paramCollageSlotItemView.getSlotItemParam();
            paramCollageSlotItemView.a((CollageSlotItemParam) localObject, localImageInfo1);
            this.v.a(localCollageSlotItemParam, localImageInfo2);
            localObject = g.a();
            ((g) localObject).a(i1);
            ((g) localObject).a(i2);
            if (localImageInfo1 != null) {
                ((g) localObject).a(localImageInfo1, i1);
            }
            if (localImageInfo2 != null) {
                ((g) localObject).a(localImageInfo2, i2);
            }
        }
        for (this.v = null; ; this.v = null) {
            do {
                paramCollageSlotItemView.setIsLongPressedSwitchMode(false);
                this.w.setAxisVisible(true);
                return;
            } while ((this.v == null) || (this.v != paramCollageSlotItemView));
            paramCollageSlotItemView.setShowMask(false);
        }
    }

    public List<CollageSlotItemParam> c() {
        ArrayList localArrayList = new ArrayList();
        int i1 = 0;
        while (i1 < this.d.size()) {
            CollageSlotItemParam localCollageSlotItemParam = ((CollageSlotItemView) this.d.valueAt(i1)).getSlotItemParam();
            if (localCollageSlotItemParam != null) {
                localArrayList.add(localCollageSlotItemParam);
            }
            i1 += 1;
        }
        return localArrayList;
    }

    public void c(int paramInt) {
        if (paramInt == this.B) {
        }
        Object localObject;
        ImageInfo localImageInfo2;
        int i1;
        do {
            return;
            localObject = a(this.B);
            CollageSlotItemView localCollageSlotItemView = a(paramInt);
            ImageInfo localImageInfo1 = localCollageSlotItemView.getImageInfo();
            localImageInfo2 = ((CollageSlotItemView) localObject).getImageInfo();
            CollageSlotItemParam localCollageSlotItemParam1 = localCollageSlotItemView.getSlotItemParam();
            CollageSlotItemParam localCollageSlotItemParam2 = ((CollageSlotItemView) localObject).getSlotItemParam();
            paramInt = ((CollageSlotItemView) localObject).getSlotIndex();
            i1 = localCollageSlotItemView.getSlotIndex();
            ((CollageSlotItemView) localObject).a(localCollageSlotItemParam1, localImageInfo1);
            localCollageSlotItemView.a(localCollageSlotItemParam2, localImageInfo2);
            localObject = g.a();
            ((g) localObject).a(paramInt);
            ((g) localObject).a(i1);
            if (localImageInfo1 != null) {
                ((g) localObject).a(localImageInfo1, paramInt);
            }
        } while (localImageInfo2 == null);
        ((g) localObject).a(localImageInfo2, i1);
    }

    public void c(CollageSlotItemView paramCollageSlotItemView) {
        if (this.y.n()) {
        }
        while ((this.q != null) || (paramCollageSlotItemView.getImageInfo() == null)) {
            return;
        }
        this.v = null;
        Object localObject = paramCollageSlotItemView.a(0.9F);
        this.q = new ImageView(getContext());
        this.q.setImageBitmap((Bitmap) localObject);
        int i1 = getContext().getResources().getInteger(R.integer.fotor_collage_swither_thumb_view_alpha);
        this.q.setAlpha(i1);
        i1 = paramCollageSlotItemView.getLeft();
        int i2 = paramCollageSlotItemView.getTop();
        int i3 = (paramCollageSlotItemView.getWidth() - ((Bitmap) localObject).getWidth()) / 2;
        int i4 = (paramCollageSlotItemView.getHeight() - ((Bitmap) localObject).getHeight()) / 2;
        localObject = new FrameLayout.LayoutParams(((Bitmap) localObject).getWidth(), ((Bitmap) localObject).getHeight());
        ((FrameLayout.LayoutParams) localObject).gravity = 51;
        ((FrameLayout.LayoutParams) localObject).leftMargin = (i1 + i3);
        ((FrameLayout.LayoutParams) localObject).topMargin = (i2 + i4);
        addView(this.q, (ViewGroup.LayoutParams) localObject);
        paramCollageSlotItemView.setIsLongPressedSwitchMode(true);
        this.w.setAxisVisible(false);
    }

    public void d() {
        this.w.setAxisVisible(true);
        int i1 = 0;
        while (i1 < this.d.size()) {
            ((CollageSlotItemView) this.d.valueAt(i1)).setTouchSwitchType(CollageSlotItemView.SlotTouchSwitchType.None);
            i1 += 1;
        }
    }

    public RenderScript getRenderScript() {
        return this.y.f().i();
    }

    public d getScript_BaseFilter() {
        return this.y.f().j();
    }

    public SparseArray<Region> getSlotItemRegions() {
        SparseArray localSparseArray = new SparseArray();
        int i1 = this.d.size() - 1;
        while (i1 >= 0) {
            CollageSlotItemView localCollageSlotItemView = (CollageSlotItemView) this.d.valueAt(i1);
            localSparseArray.put(localCollageSlotItemView.getSlotIndex(), localCollageSlotItemView.getOrgRegion());
            i1 -= 1;
        }
        return localSparseArray;
    }

    public float getTemplateMargin() {
        return this.l;
    }

    public float getTemplateRoundness() {
        return this.n;
    }

    public float getTemplateShadowStrenth() {
        return this.m;
    }

    public float getTemplateSpacing() {
        return this.k;
    }

    protected void onDraw(Canvas paramCanvas) {
        paramCanvas.setDrawFilter(this.p);
        super.onDraw(paramCanvas);
        if ((this.f != null) && (this.z)) {
            h();
            this.x.a(paramCanvas, this.i, this.j);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        return true;
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if ((paramInt1 == this.i) && (paramInt2 == this.j)) {
            getHandler().post(new Runnable() {
                public void run() {
                    CollageCanvasView.this.a();
                }
            });
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.y.n()) {
        }
        label12:
        label169:
        label174:
        do {
            do {
                return true;
            } while ((this.w != null) && (this.w.c(this)));
            int i1;
            if (this.c != null) {
                i1 = this.c.size() - 1;
            }
            for (; ; ) {
                MotionEvent localMotionEvent;
                if (i1 >= 0) {
                    Object localObject = (ICollageViewItem) this.c.get(i1);
                    if (((ICollageViewItem) localObject).getDrawItemType() != ICollageViewItem.CollageDrawItemType.SLOT) {
                        break label174;
                    }
                    localObject = (CollageSlotItemView) localObject;
                    localMotionEvent = MotionEvent.obtain(paramMotionEvent);
                    localMotionEvent.offsetLocation(-((CollageSlotItemView) localObject).getLeft(), -((CollageSlotItemView) localObject).getTop());
                    if (!((CollageSlotItemView) localObject).onTouchEvent(localMotionEvent)) {
                        break label169;
                    }
                }
                switch (paramMotionEvent.getActionMasked()) {
                    default:
                        return true;
                    case 0:
                        if (this.w == null) {
                            break label12;
                        }
                        this.w.a(this);
                        return true;
                    localMotionEvent.recycle();
                    i1 -= 1;
                }
            }
        } while (this.w == null);
        this.w.b(this);
        return true;
    }

    public void setActionDelegate(b paramb) {
        this.w = paramb;
    }

    public void setCanvasChangedListener(b paramb) {
        this.s = paramb;
    }

    public void setCurrentSession(f paramf) {
        this.y = paramf;
    }

    public void setIsDrawNullSlot(boolean paramBoolean) {
        if (this.d != null) {
            int i1 = 0;
            while (i1 < this.d.size()) {
                ((CollageSlotItemView) this.d.valueAt(i1)).setIsDrawNullSlot(paramBoolean);
                i1 += 1;
            }
        }
    }

    public void setIsShowNullSlotShadow(boolean paramBoolean) {
        this.A = paramBoolean;
    }

    public void setOnLoadSlotImageListener(c paramc) {
        this.t = paramc;
    }

    public void setOnSlotViewClickListener(d paramd) {
        this.r = paramd;
    }

    public void setTemplateMargin(float paramFloat) {
        this.l = paramFloat;
        if (this.o) {
            a();
        }
    }

    public void setTemplateParam(TemplateParam paramTemplateParam) {
        this.o = false;
        this.f = paramTemplateParam.getTemplate();
        this.g = h.a(getContext(), paramTemplateParam.getFeaturePack());
        if (this.f.getType() != Template.LayoutType.Poster) {
            if (this.f.getOriginalWidth() <= 0) {
                this.f.setOriginalWidth(2200);
            }
            if (this.f.getOriginalHeight() <= 0) {
                this.f.setOriginalHeight(2200);
            }
        }
        for (this.z = true; ; this.z = false) {
            g();
            return;
        }
    }

    public void setTemplateRoundness(float paramFloat) {
        float f2 = 1.0F;
        float f1 = 0.0F;
        if (paramFloat > 1.0F) {
            paramFloat = f2;
        }
        for (; ; ) {
            if (paramFloat < 0.0F) {
                paramFloat = f1;
            }
            for (; ; ) {
                this.n = paramFloat;
                if (this.o) {
                    a();
                }
                return;
            }
        }
    }

    public void setTemplateShadowStrength(float paramFloat) {
        this.m = paramFloat;
        if (this.o) {
            invalidate();
        }
    }

    public void setTemplateSpacing(float paramFloat) {
        this.k = paramFloat;
        if (this.o) {
            a();
        }
    }

    class a
            extends FotorAsyncTask<Void, Object, Void> {
        private Context b;
        private int c;
        private int d;
        private int e;
        private int f;

        public a(Context paramContext, int paramInt1, int paramInt2) {
            this.b = paramContext;
            this.c = paramInt1;
            this.d = paramInt2;
        }

        protected Void a(Void... paramVarArgs) {
            g localg = g.a();
            CollageCanvasView.e().c(new Object[]{"load slot bitmap images."});
            int i;
            if (CollageCanvasView.a(CollageCanvasView.this) != null) {
                paramVarArgs = CollageCanvasView.a(CollageCanvasView.this);
                i = 0;
            }
            try {
                while (i < CollageCanvasView.a(CollageCanvasView.this).size()) {
                    ImageInfo localImageInfo = localg.b(i);
                    CollageSlotItemView localCollageSlotItemView = (CollageSlotItemView) CollageCanvasView.a(CollageCanvasView.this).valueAt(i);
                    if ((localImageInfo != null) && (localImageInfo.getPicture() != null) && (localImageInfo.getSourceBitmap() == null)) {
                        CollageCanvasView.e().c(new Object[]{"source bitmap is null,load bitmap from uri"});
                        localImageInfo.setSourceBitmap(BitmapDecodeUtils.decode(this.b, localImageInfo.getPicture().g(), this.c, this.d));
                        this.f += 1;
                    }
                    publishProgress(new Object[]{localImageInfo, localCollageSlotItemView, Integer.valueOf(i)});
                    i += 1;
                }
                CollageCanvasView.e().c(new Object[]{"completion load slot images"});
                return null;
            } finally {
            }
        }

        protected void a(Void paramVoid) {
            CollageCanvasView.a(CollageCanvasView.this, null);
            if (CollageCanvasView.b(CollageCanvasView.this) != null) {
                CollageCanvasView.b(CollageCanvasView.this).a();
            }
        }

        protected void onCancelled() {
            if (CollageCanvasView.b(CollageCanvasView.this) != null) {
                CollageCanvasView.b(CollageCanvasView.this).a();
            }
        }

        protected void onPreExecute() {
            int i = 0;
            this.e = 0;
            this.f = 0;
            g localg = g.a();
            for (; ; ) {
                synchronized (CollageCanvasView.a(CollageCanvasView.this)) {
                    if (i < CollageCanvasView.a(CollageCanvasView.this).size()) {
                        ImageInfo localImageInfo = localg.b(i);
                        if ((localImageInfo != null) && (localImageInfo.getPicture() != null) && (localImageInfo.getSourceBitmap() == null)) {
                            this.e += 1;
                        }
                    } else {
                        if ((CollageCanvasView.b(CollageCanvasView.this) != null) && (this.e > 0)) {
                            CollageCanvasView.b(CollageCanvasView.this).b();
                        }
                        return;
                    }
                }
                i += 1;
            }
        }

        protected void onProgressUpdate(Object... paramVarArgs) {
            ImageInfo localImageInfo = (ImageInfo) paramVarArgs[0];
            CollageSlotItemView localCollageSlotItemView = (CollageSlotItemView) paramVarArgs[1];
            ((Integer) paramVarArgs[2]).intValue();
            CollageCanvasView.e().c(new Object[]{"load slot bitmap progress:image:" + localImageInfo, "index:" + this.f, "totol:" + this.e});
            float f1 = this.f / this.e * 100.0F;
            CollageCanvasView.e().c(new Object[]{"load slot bitmap percent :" + f1 + "%"});
            if (localCollageSlotItemView != null) {
                localCollageSlotItemView.setSlotImage(localImageInfo);
            }
            if (CollageCanvasView.b(CollageCanvasView.this) != null) {
                CollageCanvasView.b(CollageCanvasView.this).a(f1);
            }
        }
    }

    public static abstract interface b {
        public abstract void a(RectF paramRectF);
    }

    public static abstract interface c {
        public abstract void a();

        public abstract void a(float paramFloat);

        public abstract void b();
    }

    public static abstract interface d {
        public abstract void a(CollageSlotItemView paramCollageSlotItemView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/CollageCanvasView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */