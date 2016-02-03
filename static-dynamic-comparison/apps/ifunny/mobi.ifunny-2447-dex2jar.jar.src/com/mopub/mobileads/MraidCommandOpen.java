package com.mopub.mobileads;

import java.util.Map;

class MraidCommandOpen
        extends MraidCommand {
    MraidCommandOpen(Map<String, String> paramMap, MraidView paramMraidView) {
        super(paramMap, paramMraidView);
    }

    void execute() {
        String str = getStringFromParamsForKey("url");
        if (str == null) {
            this.mView.fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.OPEN, "Url can not be null.");
            return;
        }
        this.mView.getBrowserController().open(str);
    }

    protected boolean isCommandDependentOnUserClick(MraidView.PlacementType paramPlacementType) {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidCommandOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */