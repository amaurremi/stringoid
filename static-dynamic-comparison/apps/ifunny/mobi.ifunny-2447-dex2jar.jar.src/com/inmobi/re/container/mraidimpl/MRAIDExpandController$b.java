package com.inmobi.re.container.mraidimpl;

import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;

class MRAIDExpandController$b
        implements Runnable {
    MRAIDExpandController$b(MRAIDExpandController paramMRAIDExpandController) {
    }

    public void run() {
        if (MRAIDExpandController.a(this.a).mListener != null) {
            MRAIDExpandController.a(this.a).mListener.onExpand();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDExpandController$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */