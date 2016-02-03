package com.everimaging.fotorsdk.collage.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.everimaging.fotorsdk.collage.R.attr;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.R.style;
import com.everimaging.fotorsdk.collage.R.styleable;
import com.everimaging.fotorsdk.widget.a;

public class d
        implements PopupWindow.OnDismissListener {
    a a;
    a b;
    a c;
    a d;
    a e;
    private Context f;
    private PopupWindow g;
    private View h;
    private int i;
    private View.OnClickListener j = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if (d.this.e != null) {
                if (paramAnonymousView != d.this.a) {
                    break label42;
                }
                d.this.e.a(d.a(d.this), false);
            }
            label42:
            do {
                return;
                if (paramAnonymousView == d.this.b) {
                    d.this.e.a(d.a(d.this), true);
                    return;
                }
                if (paramAnonymousView == d.this.c) {
                    d.this.e.b(d.a(d.this), false);
                    return;
                }
            } while (paramAnonymousView != d.this.d);
            d.this.e.b(d.a(d.this), true);
        }
    };

    public d(Context paramContext, int paramInt) {
        this.f = paramContext;
        this.i = paramInt;
        a();
    }

    private void a() {
        this.h = LayoutInflater.from(this.f).inflate(R.layout.fotor_collage_rotate_tools_panel, null);
        this.g = new PopupWindow(this.h, -2, -2);
        this.g.setOnDismissListener(this);
        Object localObject = new TypedValue();
        this.f.getTheme().resolveAttribute(R.attr.fotorCollagePopupMenuStyle, (TypedValue) localObject, true);
        localObject = this.f.obtainStyledAttributes(((TypedValue) localObject).data, R.styleable.FotorCollagePopupMenu);
        Drawable localDrawable = ((TypedArray) localObject).getDrawable(0);
        this.h.setBackgroundDrawable(localDrawable);
        this.g.setAnimationStyle(R.style.FotorCollagePopupAnim);
        this.g.setFocusable(true);
        this.g.setOutsideTouchable(true);
        this.g.setBackgroundDrawable(new ColorDrawable(0));
        this.a = ((a) this.h.findViewById(R.id.fotor_collage_rotate_left_btn));
        this.a.setOnClickListener(this.j);
        this.b = ((a) this.h.findViewById(R.id.fotor_collage_rotate_right_btn));
        this.b.setOnClickListener(this.j);
        this.c = ((a) this.h.findViewById(R.id.fotor_collage_rotate_fliph_btn));
        this.c.setOnClickListener(this.j);
        this.d = ((a) this.h.findViewById(R.id.fotor_collage_rotate_flipv_btn));
        this.d.setOnClickListener(this.j);
        ((TypedArray) localObject).recycle();
    }

    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        if (!this.g.isShowing()) {
            this.g.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
        }
    }

    public void a(a parama) {
        this.e = parama;
    }

    public void onDismiss() {
        if (this.e != null) {
            this.e.a(this.i);
        }
    }

    public static abstract interface a {
        public abstract void a(int paramInt);

        public abstract void a(int paramInt, boolean paramBoolean);

        public abstract void b(int paramInt, boolean paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */