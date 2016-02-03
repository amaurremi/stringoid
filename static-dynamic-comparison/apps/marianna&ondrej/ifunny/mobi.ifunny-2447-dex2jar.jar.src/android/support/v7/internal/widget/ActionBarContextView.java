package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.b.c;
import android.support.v7.b.h;
import android.support.v7.b.k;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.q;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView
        extends a {
    private CharSequence g;
    private CharSequence h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private Drawable p;
    private boolean q;

    public ActionBarContextView(Context paramContext) {
        this(paramContext, null);
    }

    public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, c.actionModeStyle);
    }

    public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.ActionMode, paramInt, 0);
        setBackgroundDrawable(paramContext.getDrawable(3));
        this.n = paramContext.getResourceId(1, 0);
        this.o = paramContext.getResourceId(2, 0);
        this.f = paramContext.getLayoutDimension(0, 0);
        this.p = paramContext.getDrawable(4);
        paramContext.recycle();
    }

    private void i() {
        int i4 = 8;
        int i2 = 1;
        if (this.k == null) {
            LayoutInflater.from(getContext()).inflate(h.abc_action_bar_title_item, this);
            this.k = ((LinearLayout) getChildAt(getChildCount() - 1));
            this.l = ((TextView) this.k.findViewById(android.support.v7.b.f.action_bar_title));
            this.m = ((TextView) this.k.findViewById(android.support.v7.b.f.action_bar_subtitle));
            if (this.n != 0) {
                this.l.setTextAppearance(getContext(), this.n);
            }
            if (this.o != 0) {
                this.m.setTextAppearance(getContext(), this.o);
            }
        }
        this.l.setText(this.g);
        this.m.setText(this.h);
        int i1;
        label167:
        Object localObject;
        if (!TextUtils.isEmpty(this.g)) {
            i1 = 1;
            if (TextUtils.isEmpty(this.h)) {
                break label234;
            }
            localObject = this.m;
            if (i2 == 0) {
                break label239;
            }
        }
        label234:
        label239:
        for (int i3 = 0; ; i3 = 8) {
            ((TextView) localObject).setVisibility(i3);
            localObject = this.k;
            if (i1 == 0) {
                i1 = i4;
                if (i2 == 0) {
                }
            } else {
                i1 = 0;
            }
            ((LinearLayout) localObject).setVisibility(i1);
            if (this.k.getParent() == null) {
                addView(this.k);
            }
            return;
            i1 = 0;
            break;
            i2 = 0;
            break label167;
        }
    }

    public void a(android.support.v7.c.a parama) {
        if (this.i == null) {
            this.i = LayoutInflater.from(getContext()).inflate(h.abc_action_mode_close_item, this, false);
            addView(this.i);
        }
        ViewGroup.LayoutParams localLayoutParams;
        for (; ; ) {
            this.i.findViewById(android.support.v7.b.f.action_mode_close_button).setOnClickListener(new f(this, parama));
            parama = (q) parama.a();
            if (this.b != null) {
                this.b.c();
            }
            this.b = new ActionMenuPresenter(getContext());
            this.b.a(true);
            localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
            if (this.d) {
                break;
            }
            parama.a(this.b);
            this.a = ((ActionMenuView) this.b.a(this));
            this.a.setBackgroundDrawable(null);
            addView(this.a, localLayoutParams);
            return;
            if (this.i.getParent() == null) {
                addView(this.i);
            }
        }
        this.b.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
        this.b.a(Integer.MAX_VALUE);
        localLayoutParams.width = -1;
        localLayoutParams.height = this.f;
        parama.a(this.b);
        this.a = ((ActionMenuView) this.b.a(this));
        this.a.setBackgroundDrawable(this.p);
        this.c.addView(this.a, localLayoutParams);
    }

    public boolean a() {
        if (this.b != null) {
            return this.b.a();
        }
        return false;
    }

    public boolean c() {
        if (this.b != null) {
            return this.b.b();
        }
        return false;
    }

    public boolean d() {
        if (this.b != null) {
            return this.b.e();
        }
        return false;
    }

    public void g() {
        if (this.i == null) {
            h();
        }
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
    }

    public CharSequence getSubtitle() {
        return this.h;
    }

    public CharSequence getTitle() {
        return this.g;
    }

    public void h() {
        removeAllViews();
        if (this.c != null) {
            this.c.removeView(this.a);
        }
        this.j = null;
        this.a = null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.b();
            this.b.d();
        }
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i1 = getPaddingLeft();
        int i2 = getPaddingTop();
        int i3 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
        ViewGroup.MarginLayoutParams localMarginLayoutParams;
        if ((this.i != null) && (this.i.getVisibility() != 8)) {
            localMarginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            paramInt2 = i1 + localMarginLayoutParams.leftMargin;
            paramInt4 = b(this.i, paramInt2, i2, i3);
        }
        for (paramInt2 = localMarginLayoutParams.rightMargin + (paramInt2 + paramInt4); ; paramInt2 = i1) {
            paramInt4 = paramInt2;
            if (this.k != null) {
                paramInt4 = paramInt2;
                if (this.j == null) {
                    paramInt4 = paramInt2;
                    if (this.k.getVisibility() != 8) {
                        paramInt4 = paramInt2 + b(this.k, paramInt2, i2, i3);
                    }
                }
            }
            if (this.j != null) {
                b(this.j, paramInt4, i2, i3);
            }
            paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
            if (this.a != null) {
                c(this.a, paramInt1, i2, i3);
            }
            return;
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"FILL_PARENT\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(paramInt2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        }
        int i6 = View.MeasureSpec.getSize(paramInt1);
        int i1;
        int i5;
        int i2;
        if (this.f > 0) {
            i1 = this.f;
            int i7 = getPaddingTop() + getPaddingBottom();
            paramInt1 = i6 - getPaddingLeft() - getPaddingRight();
            i5 = i1 - i7;
            i2 = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            paramInt2 = paramInt1;
            Object localObject;
            if (this.i != null) {
                paramInt1 = a(this.i, paramInt1, i2, 0);
                localObject = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
                paramInt2 = ((ViewGroup.MarginLayoutParams) localObject).leftMargin;
                paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams) localObject).rightMargin + paramInt2);
            }
            paramInt1 = paramInt2;
            if (this.a != null) {
                paramInt1 = paramInt2;
                if (this.a.getParent() == this) {
                    paramInt1 = a(this.a, paramInt2, i2, 0);
                }
            }
            paramInt2 = paramInt1;
            if (this.k != null) {
                paramInt2 = paramInt1;
                if (this.j == null) {
                    if (!this.q) {
                        break label512;
                    }
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    this.k.measure(paramInt2, i2);
                    int i8 = this.k.getMeasuredWidth();
                    if (i8 > paramInt1) {
                        break label500;
                    }
                    i2 = 1;
                    label307:
                    paramInt2 = paramInt1;
                    if (i2 != 0) {
                        paramInt2 = paramInt1 - i8;
                    }
                    localObject = this.k;
                    if (i2 == 0) {
                        break label506;
                    }
                    paramInt1 = 0;
                    label332:
                    ((LinearLayout) localObject).setVisibility(paramInt1);
                }
            }
            label338:
            if (this.j != null) {
                localObject = this.j.getLayoutParams();
                if (((ViewGroup.LayoutParams) localObject).width == -2) {
                    break label528;
                }
                paramInt1 = 1073741824;
                label368:
                i2 = paramInt2;
                if (((ViewGroup.LayoutParams) localObject).width >= 0) {
                    i2 = Math.min(((ViewGroup.LayoutParams) localObject).width, paramInt2);
                }
                if (((ViewGroup.LayoutParams) localObject).height == -2) {
                    break label535;
                }
                paramInt2 = i3;
                label403:
                if (((ViewGroup.LayoutParams) localObject).height < 0) {
                    break label542;
                }
                i3 = Math.min(((ViewGroup.LayoutParams) localObject).height, i5);
                label423:
                this.j.measure(View.MeasureSpec.makeMeasureSpec(i2, paramInt1), View.MeasureSpec.makeMeasureSpec(i3, paramInt2));
            }
            if (this.f > 0) {
                break label557;
            }
            i2 = getChildCount();
            paramInt1 = 0;
            paramInt2 = i4;
            label460:
            if (paramInt2 >= i2) {
                break label549;
            }
            i1 = getChildAt(paramInt2).getMeasuredHeight() + i7;
            if (i1 <= paramInt1) {
                break label565;
            }
            paramInt1 = i1;
        }
        label500:
        label506:
        label512:
        label528:
        label535:
        label542:
        label549:
        label557:
        label565:
        for (; ; ) {
            paramInt2 += 1;
            break label460;
            i1 = View.MeasureSpec.getSize(paramInt2);
            break;
            i2 = 0;
            break label307;
            paramInt1 = 8;
            break label332;
            paramInt2 = a(this.k, paramInt1, i2, 0);
            break label338;
            paramInt1 = Integer.MIN_VALUE;
            break label368;
            paramInt2 = Integer.MIN_VALUE;
            break label403;
            i3 = i5;
            break label423;
            setMeasuredDimension(i6, paramInt1);
            return;
            setMeasuredDimension(i6, i1);
            return;
        }
    }

    public void setContentHeight(int paramInt) {
        this.f = paramInt;
    }

    public void setCustomView(View paramView) {
        if (this.j != null) {
            removeView(this.j);
        }
        this.j = paramView;
        if (this.k != null) {
            removeView(this.k);
            this.k = null;
        }
        if (paramView != null) {
            addView(paramView);
        }
        requestLayout();
    }

    public void setSplitActionBar(boolean paramBoolean) {
        ViewGroup.LayoutParams localLayoutParams;
        ViewGroup localViewGroup;
        if (this.d != paramBoolean) {
            if (this.b != null) {
                localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (paramBoolean) {
                    break label91;
                }
                this.a = ((ActionMenuView) this.b.a(this));
                this.a.setBackgroundDrawable(null);
                localViewGroup = (ViewGroup) this.a.getParent();
                if (localViewGroup != null) {
                    localViewGroup.removeView(this.a);
                }
                addView(this.a, localLayoutParams);
            }
        }
        for (; ; ) {
            super.setSplitActionBar(paramBoolean);
            return;
            label91:
            this.b.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.b.a(Integer.MAX_VALUE);
            localLayoutParams.width = -1;
            localLayoutParams.height = this.f;
            this.a = ((ActionMenuView) this.b.a(this));
            this.a.setBackgroundDrawable(this.p);
            localViewGroup = (ViewGroup) this.a.getParent();
            if (localViewGroup != null) {
                localViewGroup.removeView(this.a);
            }
            this.c.addView(this.a, localLayoutParams);
        }
    }

    public void setSubtitle(CharSequence paramCharSequence) {
        this.h = paramCharSequence;
        i();
    }

    public void setTitle(CharSequence paramCharSequence) {
        this.g = paramCharSequence;
        i();
    }

    public void setTitleOptional(boolean paramBoolean) {
        if (paramBoolean != this.q) {
            requestLayout();
        }
        this.q = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/ActionBarContextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */