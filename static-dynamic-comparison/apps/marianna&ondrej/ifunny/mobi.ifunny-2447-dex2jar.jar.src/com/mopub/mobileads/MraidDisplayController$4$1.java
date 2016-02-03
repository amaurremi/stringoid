package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

class MraidDisplayController$4$1
        implements Runnable {
    MraidDisplayController$4$1(MraidDisplayController.4param4) {
    }

    public void run() {
        MraidDisplayController.access$200(this.this$1.this$0, "Image failed to download.");
        this.this$1.this$0.getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.STORE_PICTURE, "Error downloading and saving image file.");
        MoPubLog.d("Error downloading and saving image file.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidDisplayController$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */