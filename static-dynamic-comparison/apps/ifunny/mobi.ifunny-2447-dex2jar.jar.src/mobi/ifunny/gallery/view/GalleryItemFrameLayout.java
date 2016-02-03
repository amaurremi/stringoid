package mobi.ifunny.gallery.view;

import android.content.Context;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class GalleryItemFrameLayout
        extends FrameLayout {
    private static final String a = GalleryItemFrameLayout.class.getSimpleName();
    private boolean b;
    private int c;
    private e d;
    private f e;
    private q f;
    private g g;

    public GalleryItemFrameLayout(Context paramContext) {
        super(paramContext);
        a(paramContext);
    }

    public GalleryItemFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext);
    }

    public GalleryItemFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext);
    }

    private void a(Context paramContext) {
        this.f = new q(paramContext, new b(this, null));
        this.g = new g(paramContext, new c(this, null));
        this.b = false;
    }

    private boolean a(View paramView, boolean paramBoolean, float paramFloat) {
        if (paramView.getVisibility() != 0) {
            return false;
        }
        if ((paramBoolean) && ((paramView instanceof d)) && (((d) paramView).a(paramFloat))) {
            return true;
        }
        if ((paramView instanceof ViewGroup)) {
            paramView = (ViewGroup) paramView;
            int i = paramView.getChildCount() - 1;
            while (i >= 0) {
                if (a(paramView.getChildAt(i), true, paramFloat)) {
                    return true;
                }
                i -= 1;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        if (paramMotionEvent.getActionMasked() == 0) {
            if (a(this, false, 0.0F)) {
                break label50;
            }
        }
        label50:
        for (boolean bool = true; ; bool = false) {
            this.b = bool;
            this.c = 0;
            if (!this.f.a(paramMotionEvent)) {
                break;
            }
            mobi.ifunny.d.b(a, "swipeDetector intercepts");
            return true;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (paramMotionEvent.getActionMasked() == 0) {
            this.b = true;
        }
        if (this.f.a(paramMotionEvent)) {
        }
        while (this.g.a(paramMotionEvent)) {
            return true;
        }
        super.onTouchEvent(paramMotionEvent);
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    }

    public void setSwipeListener(e parame) {
        this.d = parame;
    }

    public void setTapListener(f paramf) {
        this.e = paramf;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/view/GalleryItemFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */