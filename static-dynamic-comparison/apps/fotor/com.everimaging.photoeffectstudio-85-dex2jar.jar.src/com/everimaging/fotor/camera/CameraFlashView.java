package com.everimaging.fotor.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.everimaging.fotor.widget.FotorButton;

public class CameraFlashView
        extends ImageButton
        implements View.OnClickListener, PopupWindow.OnDismissListener {
    private View a;
    private FotorButton b;
    private FotorButton c;
    private FotorButton d;
    private FotorButton e;
    private PopupWindow f;
    private a g;

    public CameraFlashView(Context paramContext) {
        super(paramContext);
        a();
    }

    public CameraFlashView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a();
    }

    private void a() {
        LayoutInflater localLayoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        setCurrentFlashMode("off");
        this.a = localLayoutInflater.inflate(2130903081, null, false);
        this.f = new PopupWindow(this.a, -2, -2, true);
        this.f.setTouchable(true);
        this.f.setOutsideTouchable(true);
        this.f.setBackgroundDrawable(new ColorDrawable(0));
        this.f.setOnDismissListener(this);
        setOnClickListener(this);
        this.b = ((FotorButton) this.a.findViewById(2131558507));
        this.b.setOnClickListener(this);
        this.c = ((FotorButton) this.a.findViewById(2131558508));
        this.c.setOnClickListener(this);
        this.d = ((FotorButton) this.a.findViewById(2131558509));
        this.d.setOnClickListener(this);
        this.e = ((FotorButton) this.a.findViewById(2131558510));
        this.e.setOnClickListener(this);
    }

    protected void finalize()
            throws Throwable {
        super.finalize();
    }

    public void onClick(View paramView) {
        if (paramView == this) {
            int i = getResources().getDimensionPixelSize(2131165407);
            this.f.showAsDropDown(this, i, 0);
            setSelected(true);
            return;
        }
        this.f.dismiss();
        switch (paramView.getId()) {
            default:
                paramView = "off";
        }
        for (; ; ) {
            setCurrentFlashMode(paramView);
            if (this.g == null) {
                break;
            }
            this.g.a(paramView);
            return;
            paramView = "auto";
            continue;
            paramView = "on";
            continue;
            paramView = "off";
            continue;
            paramView = "torch";
        }
    }

    public void onDismiss() {
        setSelected(false);
    }

    public void setCurrentFlashMode(String paramString) {
        if ("on".equals(paramString)) {
            setImageResource(2130837687);
            return;
        }
        if ("off".equals(paramString)) {
            setImageResource(2130837682);
            return;
        }
        if ("auto".equals(paramString)) {
            setImageResource(2130837671);
            return;
        }
        if ("torch".equals(paramString)) {
            setImageResource(2130837677);
            return;
        }
        setVisibility(8);
    }

    public void setOnFlashModeChangeListener(a parama) {
        this.g = parama;
    }

    public static abstract interface a {
        public abstract void a(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/CameraFlashView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */