package com.mopub.mobileads;

import java.util.Map;

class MraidCommandClose
        extends MraidCommand {
    MraidCommandClose(Map<String, String> paramMap, MraidView paramMraidView) {
        super(paramMap, paramMraidView);
    }

    void execute() {
        this.mView.getDisplayController().close();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidCommandClose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */