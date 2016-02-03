package com.amazon.device.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class hw
        implements di {
    private RelativeLayout a;
    private bt b;
    private Activity c;

    private void a(Bundle paramBundle) {
        Controller.PlayerProperties localPlayerProperties = (Controller.PlayerProperties) paramBundle.getParcelable("player_properties");
        Controller.Dimensions localDimensions = (Controller.Dimensions) paramBundle.getParcelable("player_dimensions");
        this.b = new bt(this.c);
        this.b.a(localPlayerProperties, paramBundle.getString("url"));
        if (localDimensions == null) {
            paramBundle = new RelativeLayout.LayoutParams(-1, -1);
            paramBundle.addRule(13);
        }
        for (; ; ) {
            this.b.a(paramBundle);
            this.b.a(this.a);
            a(this.b);
            return;
            paramBundle = new RelativeLayout.LayoutParams(localDimensions.c, localDimensions.d);
            paramBundle.topMargin = localDimensions.b;
            paramBundle.leftMargin = localDimensions.a;
        }
    }

    private void a(bt parambt) {
        parambt.a(new hx(this));
    }

    public void a() {
    }

    public void a(Activity paramActivity) {
        this.c = paramActivity;
    }

    public void b() {
        Bundle localBundle = this.c.getIntent().getExtras();
        this.a = new RelativeLayout(this.c);
        this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.c.setContentView(this.a);
        a(localBundle);
        this.b.a();
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
        this.b.e();
        this.b = null;
        this.c.finish();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */