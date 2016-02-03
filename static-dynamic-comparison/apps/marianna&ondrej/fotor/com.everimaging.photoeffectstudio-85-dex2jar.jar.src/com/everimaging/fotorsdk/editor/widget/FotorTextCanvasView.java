package com.everimaging.fotorsdk.editor.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.feature.TextFeatureOptionController.ShadowType;
import com.everimaging.fotorsdk.editor.feature.TextFeatureTypefaceController.TypefaceInfo;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.TypefaceUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FotorTextCanvasView
        extends FrameLayout
        implements a.b {
    private LinkedList<d> a;
    private d b = null;
    private a.a c;
    private boolean d = false;
    private boolean e = false;
    private PaintFlagsDrawFilter f;
    private Context g;
    private RectF h;
    private float i;
    private float j;
    private InputMethodManager k;
    private a l;
    private boolean m = false;
    private float n = 0.0F;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private FrameLayout r;
    private EditText s;
    private TextWatcher t = new TextWatcher() {
        public void afterTextChanged(Editable paramAnonymousEditable) {
        }

        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
        }

        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
            if (FotorTextCanvasView.a(FotorTextCanvasView.this) != null) {
                FotorTextCanvasView.a(FotorTextCanvasView.this).a(paramAnonymousCharSequence.toString());
                FotorTextCanvasView.this.invalidate();
            }
        }
    };

    public FotorTextCanvasView(Context paramContext) {
        this(paramContext, null);
    }

    public FotorTextCanvasView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public FotorTextCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext);
    }

    @SuppressLint({"NewApi"})
    private void a(Context paramContext) {
        this.g = paramContext;
        this.f = new PaintFlagsDrawFilter(0, 3);
        this.a = new LinkedList();
        setWillNotDraw(false);
        this.k = ((InputMethodManager) paramContext.getSystemService("input_method"));
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private void d() {
        if (this.e) {
            if ((this.b == null) || (this.c == null)) {
                break label60;
            }
            float f1 = this.c.a(AnimationUtils.currentAnimationTimeMillis());
            this.b.a(f1);
            if (this.c.b()) {
                c();
            }
        } else {
            return;
        }
        invalidate();
        return;
        label60:
        c();
    }

    private void e() {
        if (this.q) {
            if (this.l != null) {
                this.l.n();
            }
            this.q = false;
        }
    }

    private void setIsEditMode(boolean paramBoolean) {
        this.m = paramBoolean;
        int i1 = this.a.size() - 1;
        while (i1 >= 0) {
            ((d) this.a.get(i1)).b(paramBoolean);
            i1 -= 1;
        }
        invalidate();
    }

    public void a() {
        this.k.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public void a(Bitmap paramBitmap) {
        Object localObject = paramBitmap;
        if (!paramBitmap.isMutable()) {
            localObject = BitmapUtils.createBitmap(paramBitmap);
        }
        paramBitmap = new Canvas((Bitmap) localObject);
        paramBitmap.setDrawFilter(this.f);
        localObject = this.a.iterator();
        while (((Iterator) localObject).hasNext()) {
            ((d) ((Iterator) localObject).next()).a(paramBitmap, this.i, this.j);
        }
    }

    public void a(RectF paramRectF, float paramFloat1, float paramFloat2) {
        this.h = new RectF(paramRectF);
        this.i = paramFloat1;
        this.j = paramFloat2;
    }

    public void a(a.a parama) {
        this.c = parama;
        this.c.a();
        b();
        invalidate();
    }

    public void a(a parama) {
        this.a.remove(parama);
        this.b = null;
        this.q = true;
        if (this.l != null) {
            this.l.n();
        }
    }

    public void a(d paramd) {
        if (paramd != null) {
            paramd.a(this);
            paramd.a(this.h);
            this.a.add(paramd);
            if (this.b != null) {
                this.b.a(false);
            }
            this.b = paramd;
            invalidate();
        }
    }

    public void a(boolean paramBoolean) {
        this.s.requestFocus();
        this.s.setInputType(131073);
        if (this.b.j().equals(this.b.g())) {
            this.s.setText("");
        }
        for (; ; ) {
            this.s.setSelection(this.s.getText().length());
            this.k.toggleSoftInput(0, 2);
            if ((this.l != null) && (paramBoolean)) {
                this.l.h();
            }
            return;
            this.s.setText(this.b.j());
        }
    }

    public void b() {
        this.d = true;
        this.e = true;
    }

    public void b(RectF paramRectF, float paramFloat1, float paramFloat2) {
        a(paramRectF, paramFloat1, paramFloat2);
        int i1 = this.a.size() - 1;
        while (i1 >= 0) {
            ((d) this.a.get(i1)).b(paramRectF);
            i1 -= 1;
        }
        invalidate();
    }

    public void b(a parama) {
        this.b = ((d) parama);
    }

    public void b(boolean paramBoolean) {
        if (this.b != null) {
            if (!paramBoolean) {
                break label23;
            }
            this.b.k();
        }
        for (; ; ) {
            invalidate();
            return;
            label23:
            this.b.l();
        }
    }

    public void c() {
        this.d = false;
        this.e = false;
    }

    public void c(a parama) {
        this.b = null;
        this.q = true;
    }

    public void c(boolean paramBoolean) {
        if (this.b != null) {
            this.b.c(paramBoolean);
            invalidate();
        }
    }

    public void d(a parama) {
        if (!this.p) {
            setIsEditMode(true);
            a(true);
        }
    }

    public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent) {
        if ((this.o) && (paramKeyEvent.getKeyCode() == 4) && (this.l != null)) {
            if (paramKeyEvent.getAction() == 1) {
                this.l.d();
            }
            return true;
        }
        return super.dispatchKeyEventPreIme(paramKeyEvent);
    }

    public d getCurrentItem() {
        return this.b;
    }

    public RectF getCurrentItemBounds() {
        RectF localRectF = new RectF();
        if (this.b != null) {
            localRectF = this.b.o();
        }
        return localRectF;
    }

    public List<d> getTextItemsList() {
        return this.a;
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        paramCanvas.setDrawFilter(this.f);
        d();
        paramCanvas.save();
        paramCanvas.translate(0.0F, this.n);
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            ((d) localIterator.next()).a(paramCanvas);
        }
        paramCanvas.restore();
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.d) {
            return true;
        }
        int i2 = this.a.size();
        int i1 = i2 - 1;
        while (i1 >= 0) {
            if (((d) this.a.get(i1)).a(paramMotionEvent)) {
                if ((paramMotionEvent.getAction() == 0) && (i1 != i2 - 1)) {
                    paramMotionEvent = (d) this.a.remove(i1);
                    this.a.addLast(paramMotionEvent);
                }
                invalidate();
                e();
                return true;
            }
            i1 -= 1;
        }
        e();
        if ((this.l != null) && (this.m)) {
            if (paramMotionEvent.getAction() != 0) {
                break label134;
            }
            this.l.i();
        }
        for (; ; ) {
            invalidate();
            return true;
            label134:
            if (paramMotionEvent.getAction() == 1) {
                this.l.j();
            }
        }
    }

    public void setCurrentTextAlignment(Layout.Alignment paramAlignment) {
        if (this.b != null) {
            this.b.a(paramAlignment);
            invalidate();
        }
    }

    public void setCurrentTextBold(boolean paramBoolean) {
        if (this.b != null) {
            this.b.d(paramBoolean);
            invalidate();
        }
    }

    public void setCurrentTextColor(int paramInt) {
        if (this.b != null) {
            this.b.a(paramInt);
            invalidate();
        }
    }

    public void setCurrentTextItalic(boolean paramBoolean) {
        if (this.b != null) {
            this.b.e(paramBoolean);
            invalidate();
        }
    }

    public void setCurrentTextOpacity(int paramInt) {
        if (this.b != null) {
            this.b.b(paramInt);
            invalidate();
        }
    }

    public void setCurrentTextShadow(TextFeatureOptionController.ShadowType paramShadowType) {
        if (this.b != null) {
            this.b.a(paramShadowType);
            invalidate();
        }
    }

    public void setCurrentTextureId(String paramString) {
        if (this.b != null) {
            this.b.b(paramString);
            invalidate();
        }
    }

    public void setCurrentTypeface(TextFeatureTypefaceController.TypefaceInfo paramTypefaceInfo) {
        if (this.b != null) {
            this.b.a(paramTypefaceInfo);
            invalidate();
        }
    }

    public void setDrawOffsetY(float paramFloat) {
        this.n = paramFloat;
        int i1 = this.a.size() - 1;
        while (i1 >= 0) {
            ((d) this.a.get(i1)).e(paramFloat);
            i1 -= 1;
        }
        invalidate();
    }

    public void setInputMaskLayout(FrameLayout paramFrameLayout) {
        this.r = paramFrameLayout;
        this.r.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                return true;
            }
        });
        this.s = ((EditText) this.r.findViewById(R.id.fotor_feature_text_editor));
        this.s.setHorizontallyScrolling(true);
        this.s.setTypeface(TypefaceUtils.createFromAssetPath(this.g, this.g.getString(R.string.fotor_font_roboto_light)));
    }

    public void setIsKeyboardDisplay(boolean paramBoolean) {
        this.o = paramBoolean;
        int i1;
        if (paramBoolean) {
            i1 = 0;
            this.r.setVisibility(i1);
            if (this.o) {
                break label48;
            }
            this.s.removeTextChangedListener(this.t);
        }
        for (; ; ) {
            setIsEditMode(paramBoolean);
            return;
            i1 = 4;
            break;
            label48:
            this.s.addTextChangedListener(this.t);
        }
    }

    public void setIsToolsPanelDisplay(boolean paramBoolean) {
        this.p = paramBoolean;
    }

    public void setTextCanvasListener(a parama) {
        this.l = parama;
    }

    public static abstract interface a {
        public abstract void d();

        public abstract void h();

        public abstract void i();

        public abstract void j();

        public abstract void n();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/FotorTextCanvasView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */