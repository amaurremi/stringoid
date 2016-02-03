package com.everimaging.fotor.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.everimaging.fotor.App;
import com.everimaging.fotor.c.e;

import java.util.Arrays;

public class CameraTimer
        extends FrameLayout
        implements View.OnClickListener {
    private static final int[] g = {1, 2, 3, 4, 5, 15, 30};
    private TextView a;
    private TextView b;
    private TextView c;
    private ImageButton d;
    private ImageButton e;
    private ViewGroup f;
    private int h = 0;
    private int i = g[this.h];

    public CameraTimer(Context paramContext) {
        super(paramContext);
        e();
    }

    public CameraTimer(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        e();
    }

    public CameraTimer(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        e();
    }

    private void e() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130903086, this, true);
        this.a = ((TextView) findViewById(2131558540));
        this.a.setTypeface(App.c);
        this.b = ((TextView) findViewById(2131558545));
        this.b.setTypeface(App.c);
        this.c = ((TextView) findViewById(2131558542));
        this.c.setTypeface(App.c);
        this.d = ((ImageButton) findViewById(2131558544));
        this.d.setOnClickListener(this);
        this.e = ((ImageButton) findViewById(2131558543));
        this.e.setOnClickListener(this);
        this.f = ((ViewGroup) findViewById(2131558539));
        a(a.f());
        setOnClickListener(e.a());
    }

    public void a() {
        a(a.f());
        d();
    }

    public void a(int paramInt) {
        this.h = 4;
        int j = 0;
        while (j < g.length) {
            if (paramInt == g[j]) {
                this.h = j;
            }
            j += 1;
        }
        this.i = g[this.h];
        this.b.setText(String.valueOf(this.i));
        this.a.setVisibility(0);
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.f.clearAnimation();
        this.f.setVisibility(0);
    }

    public void a(Animation.AnimationListener paramAnimationListener) {
        this.a.setVisibility(4);
        this.c.setVisibility(4);
        this.d.setVisibility(4);
        this.e.setVisibility(4);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.6F, 1.0F, 0.6F, 1, 0.5F, 1, 0.5F);
        localScaleAnimation.setDuration(150L);
        localScaleAnimation.setFillAfter(true);
        localScaleAnimation.setAnimationListener(paramAnimationListener);
        this.f.startAnimation(localScaleAnimation);
    }

    public void b() {
        this.i -= 1;
        if (this.i > 0) {
            this.b.setText(String.valueOf(this.i));
        }
    }

    public void c() {
        setVisibility(4);
    }

    public void d() {
        setVisibility(0);
    }

    public int getTime() {
        return this.i;
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
        }
        do {
            do {
                return;
            } while (this.h >= g.length - 1);
            this.h += 1;
            this.i = g[this.h];
            this.b.setText(String.valueOf(this.i));
            return;
        } while (this.h <= 0);
        this.h -= 1;
        this.i = g[this.h];
        this.b.setText(String.valueOf(this.i));
    }

    public void setTime(int paramInt) {
        this.h = Arrays.binarySearch(g, paramInt);
        if ((this.h < 0) || (this.h >= g.length)) {
            this.h = 4;
        }
        this.i = g[this.h];
        this.b.setText(String.valueOf(this.i));
        this.a.setVisibility(0);
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.f.clearAnimation();
        this.f.setVisibility(0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/CameraTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */