package com.inmobi.re.container.mraidimpl;

import android.view.View;
import android.view.View.OnClickListener;
import com.inmobi.re.container.IMWebView;

class MRAIDResizeController$b
        implements View.OnClickListener {
    MRAIDResizeController$b(MRAIDResizeController paramMRAIDResizeController) {
    }

    public void onClick(View paramView) {
        IMWebView.userInitiatedClose = true;
        MRAIDResizeController.a(this.a).close();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDResizeController$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */