package com.everimaging.fotor.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.everimaging.fotor.widget.FotorButton;

public class CameraMenu
        extends LinearLayout
        implements View.OnClickListener {
    private FotorButton a;
    private FotorButton b;
    private FotorButton c;
    private FotorButton d;
    private FotorButton e;
    private FotorButton f;
    private FotorButton g;
    private FotorButton h;
    private View i;
    private a j;
    private boolean k = true;

    public CameraMenu(Context paramContext) {
        super(paramContext);
        b();
    }

    public CameraMenu(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        b();
    }

    private void a(int paramInt) {
        if (this.j != null) {
            this.j.a(paramInt);
        }
    }

    private void b() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130903085, this, true);
        this.a = ((FotorButton) findViewById(2131558531));
        this.a.setOnClickListener(this);
        this.a.setSelected(true);
        this.i = this.a;
        this.b = ((FotorButton) findViewById(2131558532));
        this.b.setOnClickListener(this);
        this.b.setSelected(true);
        this.c = ((FotorButton) findViewById(2131558533));
        this.c.setOnClickListener(this);
        this.d = ((FotorButton) findViewById(2131558534));
        this.d.setOnClickListener(this);
        this.e = ((FotorButton) findViewById(2131558535));
        this.e.setOnClickListener(this);
        this.f = ((FotorButton) findViewById(2131558537));
        this.f.setOnClickListener(this);
        this.g = ((FotorButton) findViewById(2131558536));
        this.g.setOnClickListener(this);
        this.h = ((FotorButton) findViewById(2131558538));
        this.h.setOnClickListener(this);
    }

    public boolean a() {
        return this.b.isSelected();
    }

    public void onClick(View paramView) {
        boolean bool2 = true;
        boolean bool1 = true;
        if (paramView.getId() == 2131558532) {
            if (this.k) {
                paramView = this.b;
                if (this.b.isSelected()) {
                    break label67;
                }
            }
            for (; ; ) {
                paramView.setSelected(bool1);
                if (this.j != null) {
                    this.j.a(this.b.isSelected());
                }
                return;
                label67:
                bool1 = false;
            }
        }
        if (paramView.getId() == 2131558533) {
            paramView = this.c;
            if (!this.c.isSelected()) {
            }
            for (bool1 = bool2; ; bool1 = false) {
                paramView.setSelected(bool1);
                if (this.j == null) {
                    break;
                }
                this.j.b(this.c.isSelected());
                return;
            }
        }
        int m;
        if (this.i == null) {
            m = 0;
        }
        switch (paramView.getId()) {
            case 2131558532:
            case 2131558533:
            default:
            case 2131558531:
                for (; ; ) {
                    if ((this.i != null) && (this.i.getId() != paramView.getId())) {
                        this.i.setSelected(false);
                    }
                    if (m != paramView.getId()) {
                        break label390;
                    }
                    paramView.setSelected(false);
                    this.a.setSelected(true);
                    this.i = this.a;
                    return;
                    m = this.i.getId();
                    break;
                    a(0);
                }
            case 2131558534:
                if (m == paramView.getId()) {
                }
                for (n = 0; ; n = 6) {
                    a(n);
                    break;
                }
            case 2131558535:
                if (m == paramView.getId()) {
                }
                for (n = 0; ; n = 3) {
                    a(n);
                    break;
                }
            case 2131558537:
                if (m == paramView.getId()) {
                }
                for (n = 0; ; n = 5) {
                    a(n);
                    break;
                }
            case 2131558536:
                if (m == paramView.getId()) {
                }
                for (n = 0; ; n = 4) {
                    a(n);
                    break;
                }
        }
        if (m == paramView.getId()) {
        }
        for (int n = 0; ; n = 2) {
            a(n);
            break;
        }
        label390:
        paramView.setSelected(true);
        this.i = paramView;
    }

    public void setCaptureMode(int paramInt) {
        if (this.i != null) {
            this.i.setSelected(false);
        }
        switch (paramInt) {
            case 1:
            default:
                return;
            case 0:
                this.a.setSelected(true);
                this.i = this.a;
                return;
            case 3:
                this.e.setSelected(true);
                this.i = this.e;
                return;
            case 5:
                this.f.setSelected(true);
                this.i = this.f;
                return;
            case 2:
                this.h.setSelected(true);
                this.i = this.h;
                return;
            case 4:
                this.g.setSelected(true);
                this.i = this.g;
                return;
        }
        this.d.setSelected(true);
        this.i = this.d;
    }

    public void setGridEnable(boolean paramBoolean) {
        this.c.setSelected(paramBoolean);
        if (this.j != null) {
            this.j.b(paramBoolean);
        }
    }

    public void setMenuChangeListener(a parama) {
        this.j = parama;
    }

    public void setZoomSelected(boolean paramBoolean) {
        this.b.setSelected(paramBoolean);
    }

    public void setZoomSupported(boolean paramBoolean) {
        FotorButton localFotorButton = this.b;
        if (paramBoolean) {
        }
        for (int m = 0; ; m = 8) {
            localFotorButton.setVisibility(m);
            return;
        }
    }

    public void setZoomToolEnable(boolean paramBoolean) {
        this.k = paramBoolean;
        this.b.setEnabled(paramBoolean);
        if (!paramBoolean) {
            this.b.setSelected(paramBoolean);
            if (this.j != null) {
                this.j.a(paramBoolean);
            }
        }
    }

    public static abstract interface a {
        public abstract void a(int paramInt);

        public abstract void a(boolean paramBoolean);

        public abstract void b(boolean paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/CameraMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */