package com.everimaging.fotorsdk.collage.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.everimaging.fotorsdk.collage.BaseTool.ToolType;
import com.everimaging.fotorsdk.collage.R.dimen;
import com.everimaging.fotorsdk.collage.entity.Axis;
import com.everimaging.fotorsdk.collage.entity.BackgroundInfo;
import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.collage.f;
import com.everimaging.fotorsdk.collage.params.BackgroundParam;
import com.everimaging.fotorsdk.collage.params.CollageParam;
import com.everimaging.fotorsdk.collage.params.TemplateParam;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorIOUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollageCanvasContainer
        extends FrameLayout
        implements CollageAxisItemView.a, CollageCanvasView.b, b {
    private static final String a = CollageCanvasContainer.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private CollageCanvasView c;
    private View d;
    private float e;
    private RectF f;
    private List<CollageAxisItemView> g;
    private View h = null;
    private TemplateParam i;
    private BackgroundParam j;
    private f k;
    private boolean l = false;
    private int m = 0;

    public CollageCanvasContainer(Context paramContext) {
        this(paramContext, null);
    }

    public CollageCanvasContainer(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public CollageCanvasContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        f();
    }

    private void a(int paramInt1, int paramInt2) {
        int n;
        int i1;
        if ((paramInt1 > 0) && (paramInt2 > 0)) {
            n = paramInt1 - this.m;
            i1 = paramInt2 - this.m;
            if (this.e < 1.0F) {
                break label246;
            }
            paramInt1 = (int) (n / this.e);
            if (paramInt1 <= i1) {
                break label284;
            }
            paramInt2 = (int) (i1 * this.e);
            paramInt1 = i1;
        }
        for (; ; ) {
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt2, paramInt1, 17);
            this.c.setLayoutParams(localLayoutParams);
            this.c.a(paramInt2, paramInt1);
            this.d.setLayoutParams(localLayoutParams);
            n = (n - paramInt2) / 2;
            i1 = (i1 - paramInt1) / 2;
            int i2 = Math.min(paramInt2, paramInt1);
            float f1 = i2 * this.c.getTemplateSpacing();
            float f2 = i2 * this.c.getTemplateMargin();
            float f3 = 2.0F * f2;
            float f4 = f1 / 2.0F;
            float f5 = paramInt2;
            float f6 = paramInt1;
            this.f.left = (n + f4 + f2);
            this.f.top = (i1 + f4 + f2);
            this.f.right = (f5 - (f3 + f1) + this.f.left);
            this.f.bottom = (f6 - (f1 + f3) + this.f.top);
            return;
            label246:
            paramInt2 = (int) (i1 * this.e);
            if (paramInt2 > n) {
                paramInt1 = (int) (n / this.e);
                paramInt2 = n;
            } else {
                paramInt1 = i1;
                continue;
                label284:
                paramInt2 = n;
            }
        }
    }

    private void a(Template paramTemplate) {
        ArrayList localArrayList = paramTemplate.getAxes();
        if (localArrayList != null) {
            int i2 = localArrayList.size();
            int n = 0;
            if (n < i2) {
                CollageAxisItemView localCollageAxisItemView = new CollageAxisItemView(getContext());
                localCollageAxisItemView.setActionDelegate(this);
                localCollageAxisItemView.a((Axis) localArrayList.get(n), paramTemplate.getVertices());
                if (this.l) {
                }
                for (int i1 = 0; ; i1 = 4) {
                    localCollageAxisItemView.setVisibility(i1);
                    this.g.add(localCollageAxisItemView);
                    n += 1;
                    break;
                }
            }
        }
    }

    private void b(RectF paramRectF) {
        Iterator localIterator = this.g.iterator();
        while (localIterator.hasNext()) {
            CollageAxisItemView localCollageAxisItemView = (CollageAxisItemView) localIterator.next();
            localCollageAxisItemView.a(paramRectF);
            if (localCollageAxisItemView.getParent() == null) {
                localCollageAxisItemView.setAxisItemListener(this);
                addView(localCollageAxisItemView);
            }
        }
    }

    private void f() {
        this.e = 1.0F;
        this.d = new View(getContext());
        addView(this.d);
        this.c = new CollageCanvasView(getContext());
        this.c.setActionDelegate(this);
        this.c.setCanvasChangedListener(this);
        addView(this.c);
        this.g = new ArrayList();
        this.f = new RectF();
        this.m = getContext().getResources().getDimensionPixelOffset(R.dimen.fotor_collage_template_container_padding);
    }

    private void g() {
        Iterator localIterator = this.g.iterator();
        while (localIterator.hasNext()) {
            removeView((CollageAxisItemView) localIterator.next());
        }
        this.g.clear();
    }

    private void h() {
        Iterator localIterator = this.g.iterator();
        if (localIterator.hasNext()) {
            CollageAxisItemView localCollageAxisItemView = (CollageAxisItemView) localIterator.next();
            if (this.l) {
            }
            for (int n = 0; ; n = 4) {
                localCollageAxisItemView.setVisibility(n);
                break;
            }
        }
    }

    public Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean) {
        float f2 = 1.0F;
        int n = this.c.getWidth();
        int i1 = this.c.getHeight();
        float f3 = paramInt1 / n;
        float f1 = paramInt2 / i1;
        if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
            f1 = 1.0F;
        }
        for (; ; ) {
            f1 = Math.min(f2, f1);
            paramInt1 = (int) (n * f1);
            paramInt2 = (int) (f1 * i1);
            Bitmap localBitmap = BitmapUtils.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
            Object localObject = new Canvas(localBitmap);
            if (paramBoolean) {
                this.d.draw((Canvas) localObject);
            }
            if (paramBoolean) {
                this.c.setIsDrawNullSlot(false);
                this.c.setIsShowNullSlotShadow(false);
            }
            this.c.draw((Canvas) localObject);
            if (paramBoolean) {
                this.c.setIsDrawNullSlot(true);
                this.c.setIsShowNullSlotShadow(true);
            }
            localObject = BitmapUtils.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
            new Canvas((Bitmap) localObject).drawBitmap(localBitmap, null, new Rect(0, 0, paramInt1, paramInt2), null);
            return (Bitmap) localObject;
            f2 = f3;
        }
    }

    public CollageSlotItemView a(int paramInt) {
        return this.c.a(paramInt);
    }

    public void a() {
        if (this.k.n()) {
        }
        for (; ; ) {
            return;
            this.c.a();
            Iterator localIterator = this.g.iterator();
            while (localIterator.hasNext()) {
                ((CollageAxisItemView) localIterator.next()).a();
            }
        }
    }

    public void a(Rect paramRect) {
        int[] arrayOfInt = new int[2];
        this.c.getLocationOnScreen(arrayOfInt);
        paramRect.left = arrayOfInt[0];
        paramRect.top = arrayOfInt[1];
        paramRect.right = (paramRect.left + this.c.getWidth());
        paramRect.bottom = (paramRect.top + this.c.getHeight());
    }

    public void a(RectF paramRectF) {
        b(paramRectF);
    }

    public void a(View paramView) {
        this.h = paramView;
    }

    public void b() {
        this.c.d();
    }

    public void b(int paramInt) {
        this.c.b(paramInt);
    }

    public void b(View paramView) {
        if (this.h == paramView) {
            this.h = null;
        }
    }

    public void c() {
        this.c.b();
    }

    public void c(int paramInt) {
        this.c.c(paramInt);
    }

    public boolean c(View paramView) {
        return (paramView != this.h) && (this.h != null);
    }

    public CollageParam d() {
        CollageParam localCollageParam = new CollageParam();
        this.i.setPreviewCanvasW(this.c.getWidth());
        this.i.setPreviewCanvasH(this.c.getHeight());
        Template localTemplate = this.i.getTemplate();
        localTemplate.setBorderMargin(this.c.getTemplateMargin());
        localTemplate.setBorderSpacing(this.c.getTemplateSpacing());
        localTemplate.setRoundness(this.c.getTemplateRoundness());
        localTemplate.setShadowStrength(this.c.getTemplateShadowStrenth());
        localCollageParam.setBackgroundParam(this.j);
        localCollageParam.setTemplateParam(this.i);
        localCollageParam.setSlotItemParams(this.c.c());
        return localCollageParam;
    }

    public boolean e() {
        return this.i != null;
    }

    public int getCanvasHeight() {
        return this.c.getHeight();
    }

    public float getCanvasRatio() {
        return this.e;
    }

    public int getCanvasWidth() {
        return this.c.getWidth();
    }

    public SparseArray<Region> getSlotItemRegions() {
        return this.c.getSlotItemRegions();
    }

    public float getTemplateMargin() {
        return this.c.getTemplateMargin();
    }

    public float getTemplateRoundness() {
        return this.c.getTemplateRoundness();
    }

    public float getTemplateShadowStrenth() {
        return this.c.getTemplateShadowStrenth();
    }

    public float getTemplateSpacing() {
        return this.c.getTemplateSpacing();
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        a(paramInt1, paramInt2);
    }

    public void setAxisVisible(boolean paramBoolean) {
        BaseTool.ToolType localToolType = this.k.m();
        if (((localToolType == null) || (localToolType != BaseTool.ToolType.OTHER)) && (paramBoolean)) {
            return;
        }
        this.l = paramBoolean;
        h();
    }

    public void setBackgroundParam(BackgroundParam paramBackgroundParam) {
        b.c(new Object[]{"setBackgroundParam:" + paramBackgroundParam});
        if ((paramBackgroundParam == null) || (this.j == paramBackgroundParam)) {
            return;
        }
        this.j = paramBackgroundParam;
        Object localObject = paramBackgroundParam.getBackgroundInfo();
        if (((BackgroundInfo) localObject).isTexture()) {
            paramBackgroundParam = ((h.a) h.a(getContext(), paramBackgroundParam.getFeaturePack())).b("s_" + ((BackgroundInfo) localObject).getResName());
            localObject = BitmapDecodeUtils.decodeStream(paramBackgroundParam);
            FotorIOUtils.closeSilently(paramBackgroundParam);
            float f1 = DeviceUtils.getDensity() / 320.0F;
            paramBackgroundParam = BitmapUtils.createScaleBitmap((Bitmap) localObject, f1, f1, true);
            paramBackgroundParam = new BitmapDrawable(getContext().getResources(), paramBackgroundParam);
            paramBackgroundParam.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        }
        for (; ; ) {
            this.d.setBackgroundDrawable(paramBackgroundParam);
            return;
            paramBackgroundParam = new ColorDrawable(Color.parseColor(((BackgroundInfo) localObject).getColor().replace("0x", "#")));
        }
    }

    public void setBorderMargin(float paramFloat) {
        this.c.setTemplateMargin(paramFloat);
    }

    public void setBorderSpacing(float paramFloat) {
        this.c.setTemplateSpacing(paramFloat);
    }

    public void setCanvasRatio(float paramFloat) {
        if (paramFloat > 0.0F) {
            this.e = paramFloat;
            a(getWidth(), getHeight());
        }
    }

    public void setCurrentSession(f paramf) {
        this.k = paramf;
        this.c.setCurrentSession(this.k);
    }

    public void setOnLoadSlotImageListener(CollageCanvasView.c paramc) {
        this.c.setOnLoadSlotImageListener(paramc);
    }

    public void setOnSlotViewClickListener(CollageCanvasView.d paramd) {
        this.c.setOnSlotViewClickListener(paramd);
    }

    public void setRoundness(float paramFloat) {
        this.c.setTemplateRoundness(paramFloat);
    }

    public void setShadowStrength(float paramFloat) {
        this.c.setTemplateShadowStrength(paramFloat);
    }

    public void setTemplateParam(TemplateParam paramTemplateParam) {
        this.i = paramTemplateParam;
        g();
        this.c.removeAllViews();
        float f2 = 1.0F;
        Template localTemplate = paramTemplateParam.getTemplate();
        float f1 = f2;
        if (localTemplate.getOriginalWidth() > 0) {
            f1 = f2;
            if (localTemplate.getOriginalHeight() > 0) {
                f1 = localTemplate.getOriginalWidth() / localTemplate.getOriginalHeight();
            }
        }
        setCanvasRatio(f1);
        this.c.setTemplateParam(paramTemplateParam);
        a(localTemplate);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/CollageCanvasContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */