package com.facebook.internal;

class LikeActionController$SerializeToDiskWorkItem
        implements Runnable {
    private String cacheKey;
    private String controllerJson;

    LikeActionController$SerializeToDiskWorkItem(String paramString1, String paramString2) {
        this.cacheKey = paramString1;
        this.controllerJson = paramString2;
    }

    public void run() {
        LikeActionController.access$2800(this.cacheKey, this.controllerJson);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$SerializeToDiskWorkItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */