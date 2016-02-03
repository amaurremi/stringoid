package com.everimaging.fotorsdk.collage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout.a;

public class l
        extends BaseTool
        implements FotorSliderPanelLayout.a {
    private View c;
    private FotorSliderPanelLayout d;
    private FotorSliderPanelLayout e;

    public l(Context paramContext) {
        super(paramContext);
    }

    private void c() {
        this.c = LayoutInflater.from(this.b).inflate(R.layout.fotor_collage_operation_distance_tool, null);
        this.d = ((FotorSliderPanelLayout) this.c.findViewById(R.id.fotor_collage_operation_tool_margin));
        this.d.setOnChangedListener(this);
        this.e = ((FotorSliderPanelLayout) this.c.findViewById(R.id.fotor_collage_operation_tool_spacing));
        this.e.setOnChangedListener(this);
    }

    public BaseTool.ToolType a() {
        return BaseTool.ToolType.WIDTH;
    }

    public void a(int paramInt1, int paramInt2) {
        this.d.setProgress(paramInt1);
        this.e.setProgress(paramInt2);
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout) {
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout, int paramInt, boolean paramBoolean) {
        paramFotorSliderPanelLayout.setDisplayValue(String.valueOf(paramInt));
        if (this.a != null) {
            if (paramFotorSliderPanelLayout == this.d) {
                this.a.b(this, paramInt);
            }
        } else {
            return;
        }
        this.a.a(this, paramInt);
    }

    public void a(boolean paramBoolean) {
        this.e.setEnabled(paramBoolean);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */