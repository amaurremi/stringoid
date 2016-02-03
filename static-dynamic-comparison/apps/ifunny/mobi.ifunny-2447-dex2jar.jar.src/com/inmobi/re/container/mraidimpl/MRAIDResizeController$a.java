package com.inmobi.re.container.mraidimpl;

import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;

class MRAIDResizeController$a
        implements Runnable {
    MRAIDResizeController$a(MRAIDResizeController paramMRAIDResizeController) {
    }

    public void run() {
        if (MRAIDResizeController.a(this.a).mListener != null) {
            MRAIDResizeController.a(this.a).mListener.onResize(MRAIDResizeController.b(this.a));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDResizeController$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */