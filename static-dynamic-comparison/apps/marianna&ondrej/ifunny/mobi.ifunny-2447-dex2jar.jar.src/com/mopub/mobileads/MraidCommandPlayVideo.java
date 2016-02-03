package com.mopub.mobileads;

import java.util.Map;

class MraidCommandPlayVideo
        extends MraidCommand {
    public MraidCommandPlayVideo(Map<String, String> paramMap, MraidView paramMraidView) {
        super(paramMap, paramMraidView);
    }

    void execute() {
        String str = getStringFromParamsForKey("uri");
        if ((str != null) && (!str.equals(""))) {
            this.mView.getDisplayController().showVideo(str);
            return;
        }
        this.mView.fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.PLAY_VIDEO, "Video can't be played with null or empty URL");
    }

    protected boolean isCommandDependentOnUserClick(MraidView.PlacementType paramPlacementType) {
        switch (MraidCommandPlayVideo
        .1.$SwitchMap$com$mopub$mobileads$MraidView$PlacementType[paramPlacementType.ordinal()])
        {
            default:
                return super.isCommandDependentOnUserClick(paramPlacementType);
            case 1:
                return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidCommandPlayVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */