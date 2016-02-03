package com.everimaging.fotorsdk.collage.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.everimaging.fotorsdk.collage.R.attr;
import com.everimaging.fotorsdk.collage.entity.Attachment;
import com.everimaging.fotorsdk.collage.painter.a;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.widget.FotorTextView;

public class CollageAttachmentItemView
        extends FotorTextView
        implements ICollageViewItem {
    private int a;
    private Attachment b;
    private float c = 1.0F;
    private h.a d;
    private a e;

    public CollageAttachmentItemView(Context paramContext) {
        this(paramContext, null);
    }

    public CollageAttachmentItemView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultTextViewStyle);
    }

    public CollageAttachmentItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        b();
    }

    @SuppressLint({"NewApi"})
    private void b() {
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    public void a() {
        if (this.b != null) {
            Object localObject = this.e.a();
            Rect localRect = new Rect();
            localRect.left = ((int) ((RectF) localObject).left);
            localRect.top = ((int) ((RectF) localObject).top);
            localRect.right = ((int) ((RectF) localObject).right + 2);
            localRect.bottom = ((int) ((RectF) localObject).bottom + 2);
            localObject = new FrameLayout.LayoutParams(localRect.width(), localRect.height());
            ((FrameLayout.LayoutParams) localObject).leftMargin = localRect.left;
            ((FrameLayout.LayoutParams) localObject).topMargin = localRect.top;
            ((FrameLayout.LayoutParams) localObject).gravity = 51;
            setLayoutParams((ViewGroup.LayoutParams) localObject);
        }
    }

    public void a(Attachment paramAttachment, h.a parama, float paramFloat) {
        this.b = paramAttachment;
        this.c = paramFloat;
        this.d = parama;
        this.e = new a(getContext(), this.b, this.d, this.c);
        a();
    }

    public ICollageViewItem.CollageDrawItemType getDrawItemType() {
        return ICollageViewItem.CollageDrawItemType.ATTACHMENT;
    }

    public int getZIndex() {
        return this.a;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.e != null) {
            this.e.a(paramCanvas, true);
        }
    }

    public void setZIndex(int paramInt) {
        this.a = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/CollageAttachmentItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */