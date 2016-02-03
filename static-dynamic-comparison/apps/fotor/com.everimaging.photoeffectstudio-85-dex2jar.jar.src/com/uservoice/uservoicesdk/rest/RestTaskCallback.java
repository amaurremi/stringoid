package com.uservoice.uservoicesdk.rest;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class RestTaskCallback {
    private final Callback<?> callback;

    public RestTaskCallback(Callback<?> paramCallback) {
        this.callback = paramCallback;
    }

    public abstract void onComplete(JSONObject paramJSONObject)
            throws JSONException;

    public void onError(RestResult paramRestResult) {
        this.callback.onError(paramRestResult);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/rest/RestTaskCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */