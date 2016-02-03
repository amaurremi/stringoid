package com.mopub.mobileads;

import java.util.Map;

class MraidCommandGetCurrentPosition
        extends MraidCommand {
    MraidCommandGetCurrentPosition(Map<String, String> paramMap, MraidView paramMraidView) {
        super(paramMap, paramMraidView);
    }

    void execute() {
        this.mView.getDisplayController().getCurrentPosition();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidCommandGetCurrentPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */