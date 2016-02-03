package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Map;

class MraidCommandRegistry {
    private static Map<String, MraidCommandFactory> commandMap = new HashMap();

    static {
        commandMap.put("close", new MraidCommandFactory() {
            public MraidCommand create(Map<String, String> paramAnonymousMap, MraidView paramAnonymousMraidView) {
                return new MraidCommandClose(paramAnonymousMap, paramAnonymousMraidView);
            }
        });
        commandMap.put("expand", new MraidCommandFactory() {
            public MraidCommand create(Map<String, String> paramAnonymousMap, MraidView paramAnonymousMraidView) {
                return new MraidCommandExpand(paramAnonymousMap, paramAnonymousMraidView);
            }
        });
        commandMap.put("usecustomclose", new MraidCommandFactory() {
            public MraidCommand create(Map<String, String> paramAnonymousMap, MraidView paramAnonymousMraidView) {
                return new MraidCommandUseCustomClose(paramAnonymousMap, paramAnonymousMraidView);
            }
        });
        commandMap.put("open", new MraidCommandFactory() {
            public MraidCommand create(Map<String, String> paramAnonymousMap, MraidView paramAnonymousMraidView) {
                return new MraidCommandOpen(paramAnonymousMap, paramAnonymousMraidView);
            }
        });
        commandMap.put("playVideo", new MraidCommandFactory() {
            public MraidCommand create(Map<String, String> paramAnonymousMap, MraidView paramAnonymousMraidView) {
                return new MraidCommandPlayVideo(paramAnonymousMap, paramAnonymousMraidView);
            }
        });
        commandMap.put("log", new MraidCommandFactory() {
            public MraidCommand create(Map<String, String> paramAnonymousMap, MraidView paramAnonymousMraidView) {
                return new MraidCommandLogCat(paramAnonymousMap, paramAnonymousMraidView);
            }
        });
    }

    static MraidCommand createCommand(String paramString, Map<String, String> paramMap, MraidView paramMraidView) {
        paramString = (MraidCommandFactory) commandMap.get(paramString);
        if (paramString != null) {
            return paramString.create(paramMap, paramMraidView);
        }
        return null;
    }

    private static abstract interface MraidCommandFactory {
        public abstract MraidCommand create(Map<String, String> paramMap, MraidView paramMraidView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidCommandRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */