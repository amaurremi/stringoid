package com.inmobi.re.controller;

import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;

class g
        implements AudioTriggerCallback {
    g(JSUtilityController paramJSUtilityController) {
    }

    public void audioLevel(double paramDouble) {
        this.a.imWebView.raiseMicEvent(paramDouble);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */