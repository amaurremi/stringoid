package com.millennialmedia.android;

import java.util.Map;

class BridgeMMInlineVideo
        extends MMJSObject {
    MMJSResponse a(String paramString, Map<String, String> paramMap) {
        MMJSResponse localMMJSResponse = null;
        if ("adjustVideo".equals(paramString)) {
            localMMJSResponse = adjustVideo(paramMap);
        }
        do {
            return localMMJSResponse;
            if ("insertVideo".equals(paramString)) {
                return insertVideo(paramMap);
            }
            if ("pauseVideo".equals(paramString)) {
                return pauseVideo(paramMap);
            }
            if ("playVideo".equals(paramString)) {
                return playVideo(paramMap);
            }
            if ("removeVideo".equals(paramString)) {
                return removeVideo(paramMap);
            }
            if ("resumeVideo".equals(paramString)) {
                return resumeVideo(paramMap);
            }
            if ("setStreamVideoSource".equals(paramString)) {
                return setStreamVideoSource(paramMap);
            }
        } while (!"stopVideo".equals(paramString));
        return stopVideo(paramMap);
    }

    public MMJSResponse adjustVideo(Map<String, String> paramMap) {
        return a(new BridgeMMInlineVideo .4 (this, paramMap));
    }

    public MMJSResponse insertVideo(Map<String, String> paramMap) {
        return a(new BridgeMMInlineVideo .1 (this, paramMap));
    }

    public MMJSResponse pauseVideo(Map<String, String> paramMap) {
        return a(new BridgeMMInlineVideo .6 (this));
    }

    public MMJSResponse playVideo(Map<String, String> paramMap) {
        return a(new BridgeMMInlineVideo .3 (this));
    }

    public MMJSResponse removeVideo(Map<String, String> paramMap) {
        return a(new BridgeMMInlineVideo .2 (this));
    }

    public MMJSResponse resumeVideo(Map<String, String> paramMap) {
        return a(new BridgeMMInlineVideo .7 (this));
    }

    public MMJSResponse setStreamVideoSource(Map<String, String> paramMap) {
        return a(new BridgeMMInlineVideo .8 (this, paramMap));
    }

    public MMJSResponse stopVideo(Map<String, String> paramMap) {
        return a(new BridgeMMInlineVideo .5 (this));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMInlineVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */