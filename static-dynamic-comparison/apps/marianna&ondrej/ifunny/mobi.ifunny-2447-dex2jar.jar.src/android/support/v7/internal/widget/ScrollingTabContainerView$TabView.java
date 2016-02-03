package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.a.e;
import android.support.v7.b.c;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ScrollingTabContainerView$TabView
        extends LinearLayout {
    private e a;
    private TextView b;
    private ImageView c;
    private View d;
    private ScrollingTabContainerView e;

    public ScrollingTabContainerView$TabView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public void a() {
        Object localObject1 = this.a;
        Object localObject2 = ((e) localObject1).d();
        if (localObject2 != null) {
            localObject1 = ((View) localObject2).getParent();
            if (localObject1 != this) {
                if (localObject1 != null) {
                    ((ViewGroup) localObject1).removeView((View) localObject2);
                }
                addView((View) localObject2);
            }
            this.d = ((View) localObject2);
            if (this.b != null) {
                this.b.setVisibility(8);
            }
            if (this.c != null) {
                this.c.setVisibility(8);
                this.c.setImageDrawable(null);
            }
        }
        label329:
        label354:
        for (; ; ) {
            return;
            if (this.d != null) {
                removeView(this.d);
                this.d = null;
            }
            Object localObject3 = ((e) localObject1).b();
            localObject2 = ((e) localObject1).c();
            if (localObject3 != null) {
                Object localObject4;
                if (this.c == null) {
                    localObject4 = new ImageView(getContext());
                    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
                    localLayoutParams.gravity = 16;
                    ((ImageView) localObject4).setLayoutParams(localLayoutParams);
                    addView((View) localObject4, 0);
                    this.c = ((ImageView) localObject4);
                }
                this.c.setImageDrawable((Drawable) localObject3);
                this.c.setVisibility(0);
                if (localObject2 == null) {
                    break label329;
                }
                if (this.b == null) {
                    localObject3 = new s(getContext(), null, c.actionBarTabTextStyle);
                    ((TextView) localObject3).setEllipsize(TextUtils.TruncateAt.END);
                    localObject4 = new LinearLayout.LayoutParams(-2, -2);
                    ((LinearLayout.LayoutParams) localObject4).gravity = 16;
                    ((TextView) localObject3).setLayoutParams((ViewGroup.LayoutParams) localObject4);
                    addView((View) localObject3);
                    this.b = ((TextView) localObject3);
                }
                this.b.setText((CharSequence) localObject2);
                this.b.setVisibility(0);
            }
            for (; ; ) {
                if (this.c == null) {
                    break label354;
                }
                this.c.setContentDescription(((e) localObject1).f());
                return;
                if (this.c == null) {
                    break;
                }
                this.c.setVisibility(8);
                this.c.setImageDrawable(null);
                break;
                if (this.b != null) {
                    this.b.setVisibility(8);
                    this.b.setText(null);
                }
            }
        }
    }

    public void a(e parame) {
        this.a = parame;
        a();
    }

    void a(ScrollingTabContainerView paramScrollingTabContainerView, e parame, boolean paramBoolean) {
        this.e = paramScrollingTabContainerView;
        this.a = parame;
        if (paramBoolean) {
            setGravity(19);
        }
        a();
    }

    public e getTab() {
        return this.a;
    }

    public void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        if (this.e != null) {
        }
        for (paramInt1 = this.e.b; ; paramInt1 = 0) {
            if ((paramInt1 > 0) && (getMeasuredWidth() > paramInt1)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/ScrollingTabContainerView$TabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */