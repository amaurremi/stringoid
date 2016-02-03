package com.mopub.mobileads;

import java.util.Map;

class MraidCommandFactory {
    protected static MraidCommandFactory instance = new MraidCommandFactory();

    public static MraidCommand create(String paramString, Map<String, String> paramMap, MraidView paramMraidView) {
        return instance.internalCreate(paramString, paramMap, paramMraidView);
    }

    @Deprecated
    public static void setInstance(MraidCommandFactory paramMraidCommandFactory) {
        instance = paramMraidCommandFactory;
    }

    protected MraidCommand internalCreate(String paramString, Map<String, String> paramMap, MraidView paramMraidView) {
        paramString = MraidCommandFactory.MraidJavascriptCommand.access$000(paramString);
        switch (MraidCommandFactory
        .1.$SwitchMap$com$mopub$mobileads$MraidCommandFactory$MraidJavascriptCommand[paramString.ordinal()])
        {
            case 15:
            default:
                return null;
            case 1:
                return new MraidCommandClose(paramMap, paramMraidView);
            case 2:
                return new MraidCommandExpand(paramMap, paramMraidView);
            case 3:
                return new MraidCommandUseCustomClose(paramMap, paramMraidView);
            case 4:
                return new MraidCommandOpen(paramMap, paramMraidView);
            case 5:
                return new MraidCommandResize(paramMap, paramMraidView);
            case 6:
                return new MraidCommandGetResizeProperties(paramMap, paramMraidView);
            case 7:
                return new MraidCommandSetResizeProperties(paramMap, paramMraidView);
            case 8:
                return new MraidCommandPlayVideo(paramMap, paramMraidView);
            case 9:
                return new MraidCommandStorePicture(paramMap, paramMraidView);
            case 10:
                return new MraidCommandGetCurrentPosition(paramMap, paramMraidView);
            case 11:
                return new MraidCommandGetDefaultPosition(paramMap, paramMraidView);
            case 12:
                return new MraidCommandGetMaxSize(paramMap, paramMraidView);
            case 13:
                return new MraidCommandGetScreenSize(paramMap, paramMraidView);
        }
        return new MraidCommandCreateCalendarEvent(paramMap, paramMraidView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidCommandFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */