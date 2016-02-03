package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

import java.util.Map;

class MraidCommandStorePicture
        extends MraidCommand {
    public static final String MIME_TYPE_HEADER = "Content-Type";

    public MraidCommandStorePicture(Map<String, String> paramMap, MraidView paramMraidView) {
        super(paramMap, paramMraidView);
    }

    void execute() {
        String str = getStringFromParamsForKey("uri");
        if ((str != null) && (!str.equals(""))) {
            this.mView.getDisplayController().showUserDownloadImageAlert(str);
            return;
        }
        this.mView.fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.STORE_PICTURE, "Image can't be stored with null or empty URL");
        MoPubLog.d("Invalid URI for Mraid Store Picture.");
    }

    protected boolean isCommandDependentOnUserClick(MraidView.PlacementType paramPlacementType) {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidCommandStorePicture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */