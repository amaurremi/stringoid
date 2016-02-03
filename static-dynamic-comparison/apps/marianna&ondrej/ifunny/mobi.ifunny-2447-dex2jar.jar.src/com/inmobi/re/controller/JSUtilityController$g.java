package com.inmobi.re.controller;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;

import java.util.TimerTask;

class JSUtilityController$g
        extends TimerTask {
    JSUtilityController$g(JSUtilityController paramJSUtilityController) {
    }

    public void run() {
        try {
            this.a.imWebView.raiseVibrateCompleteEvent();
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Vibrate callback execption", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSUtilityController$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */