package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.b.f;
import android.support.v7.b.h;
import android.support.v7.b.k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
        extends LinearLayout
        implements aj {
    private u a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private Drawable g;
    private int h;
    private Context i;
    private boolean j;
    private int k;
    private Context l;
    private LayoutInflater m;
    private boolean n;

    public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet);
        this.l = paramContext;
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, k.MenuView, paramInt, 0);
        this.g = paramAttributeSet.getDrawable(5);
        this.h = paramAttributeSet.getResourceId(1, -1);
        this.j = paramAttributeSet.getBoolean(7, false);
        this.i = paramContext;
        paramAttributeSet.recycle();
    }

    private void b() {
        this.b = ((ImageView) getInflater().inflate(h.abc_list_menu_item_icon, this, false));
        addView(this.b, 0);
    }

    private void c() {
        this.c = ((RadioButton) getInflater().inflate(h.abc_list_menu_item_radio, this, false));
        addView(this.c);
    }

    private void d() {
        this.e = ((CheckBox) getInflater().inflate(h.abc_list_menu_item_checkbox, this, false));
        addView(this.e);
    }

    private LayoutInflater getInflater() {
        if (this.m == null) {
            this.m = LayoutInflater.from(this.l);
        }
        return this.m;
    }

    public void a(u paramu, int paramInt) {
        this.a = paramu;
        this.k = paramInt;
        if (paramu.isVisible()) {
        }
        for (paramInt = 0; ; paramInt = 8) {
            setVisibility(paramInt);
            setTitle(paramu.a(this));
            setCheckable(paramu.isCheckable());
            a(paramu.e(), paramu.c());
            setIcon(paramu.getIcon());
            setEnabled(paramu.isEnabled());
            return;
        }
    }

    public void a(boolean paramBoolean, char paramChar) {
        if ((paramBoolean) && (this.a.e())) {
        }
        for (paramChar = '\000'; ; paramChar = '\b') {
            if (paramChar == 0) {
                this.f.setText(this.a.d());
            }
            if (this.f.getVisibility() != paramChar) {
                this.f.setVisibility(paramChar);
            }
            return;
        }
    }

    public boolean a() {
        return false;
    }

    public u getItemData() {
        return this.a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.g);
        this.d = ((TextView) findViewById(f.title));
        if (this.h != -1) {
            this.d.setTextAppearance(this.i, this.h);
        }
        this.f = ((TextView) findViewById(f.shortcut));
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        if ((this.b != null) && (this.j)) {
            ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
            LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
                localLayoutParams1.width = localLayoutParams.height;
            }
        }
        super.onMeasure(paramInt1, paramInt2);
    }

    public void setCheckable(boolean paramBoolean) {
        if ((!paramBoolean) && (this.c == null) && (this.e == null)) {
        }
        label51:
        label133:
        label139:
        do {
            return;
            Object localObject1;
            Object localObject2;
            if (this.a.f()) {
                if (this.c == null) {
                    c();
                }
                localObject1 = this.c;
                localObject2 = this.e;
                if (!paramBoolean) {
                    break label139;
                }
                ((CompoundButton) localObject1).setChecked(this.a.isChecked());
                if (!paramBoolean) {
                    break label133;
                }
            }
            for (int i1 = 0; ; i1 = 8) {
                if (((CompoundButton) localObject1).getVisibility() != i1) {
                    ((CompoundButton) localObject1).setVisibility(i1);
                }
                if ((localObject2 == null) || (((CompoundButton) localObject2).getVisibility() == 8)) {
                    break;
                }
                ((CompoundButton) localObject2).setVisibility(8);
                return;
                if (this.e == null) {
                    d();
                }
                localObject1 = this.e;
                localObject2 = this.c;
                break label51;
            }
            if (this.e != null) {
                this.e.setVisibility(8);
            }
        } while (this.c == null);
        this.c.setVisibility(8);
    }

    public void setChecked(boolean paramBoolean) {
        if (this.a.f()) {
            if (this.c == null) {
                c();
            }
        }
        for (Object localObject = this.c; ; localObject = this.e) {
            ((CompoundButton) localObject).setChecked(paramBoolean);
            return;
            if (this.e == null) {
                d();
            }
        }
    }

    public void setForceShowIcon(boolean paramBoolean) {
        this.n = paramBoolean;
        this.j = paramBoolean;
    }

    public void setIcon(Drawable paramDrawable) {
        int i1;
        if ((this.a.h()) || (this.n)) {
            i1 = 1;
            if ((i1 != 0) || (this.j)) {
                break label36;
            }
        }
        label36:
        while ((this.b == null) && (paramDrawable == null) && (!this.j)) {
            return;
            i1 = 0;
            break;
        }
        if (this.b == null) {
            b();
        }
        if ((paramDrawable != null) || (this.j)) {
            ImageView localImageView = this.b;
            if (i1 != 0) {
            }
            for (; ; ) {
                localImageView.setImageDrawable(paramDrawable);
                if (this.b.getVisibility() == 0) {
                    break;
                }
                this.b.setVisibility(0);
                return;
                paramDrawable = null;
            }
        }
        this.b.setVisibility(8);
    }

    public void setTitle(CharSequence paramCharSequence) {
        if (paramCharSequence != null) {
            this.d.setText(paramCharSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
        while (this.d.getVisibility() == 8) {
            return;
        }
        this.d.setVisibility(8);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */