package com.mopub.mobileads;

import java.util.Map;

class MraidCommandUseCustomClose
        extends MraidCommand {
    MraidCommandUseCustomClose(Map<String, String> paramMap, MraidView paramMraidView) {
        super(paramMap, paramMraidView);
    }

    void execute() {
        boolean bool = getBooleanFromParamsForKey("shouldUseCustomClose");
        this.mView.getDisplayController().useCustomClose(bool);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidCommandUseCustomClose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */