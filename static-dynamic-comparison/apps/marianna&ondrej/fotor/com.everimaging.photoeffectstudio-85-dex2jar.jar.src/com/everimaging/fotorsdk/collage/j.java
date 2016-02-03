package com.everimaging.fotorsdk.collage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout.a;

public class j
        extends BaseTool
        implements FotorSliderPanelLayout.a {
    private View c;
    private FotorSliderPanelLayout d;
    private FotorSliderPanelLayout e;

    public j(Context paramContext) {
        super(paramContext);
    }

    private void c() {
        this.c = LayoutInflater.from(this.b).inflate(R.layout.fotor_collage_operation_other_tool, null);
        this.d = ((FotorSliderPanelLayout) this.c.findViewById(R.id.fotor_collage_operation_tool_roundness));
        this.d.setOnChangedListener(this);
        this.e = ((FotorSliderPanelLayout) this.c.findViewById(R.id.fotor_collage_operation_tool_shadow));
        this.e.setOnChangedListener(this);
    }

    public BaseTool.ToolType a() {
        return BaseTool.ToolType.OTHER;
    }

    public void a(int paramInt1, int paramInt2) {
        this.d.setProgress(paramInt1);
        this.e.setProgress(paramInt2);
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout) {
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout, int paramInt, boolean paramBoolean) {
        if (this.a != null) {
            if (paramFotorSliderPanelLayout != this.d) {
                break label35;
            }
            this.a.c(this, paramInt);
        }
        for (; ; ) {
            paramFotorSliderPanelLayout.setDisplayValue(String.valueOf(paramInt));
            return;
            label35:
            this.a.d(this, paramInt);
        }
    }

    public void a(boolean paramBoolean) {
        this.d.setEnabled(paramBoolean);
    }

    public View b() {
        if (this.c == null) {
            c();
        }
        return this.c;
    }

    public void b(FotorSliderPanelLayout paramFotorSliderPanelLayout) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */