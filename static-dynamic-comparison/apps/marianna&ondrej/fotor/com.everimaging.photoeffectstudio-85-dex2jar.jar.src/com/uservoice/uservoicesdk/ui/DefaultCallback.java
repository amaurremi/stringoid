package com.uservoice.uservoicesdk.ui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.util.Log;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestResult;

public abstract class DefaultCallback<T>
        extends Callback<T> {
    private static final String TAG = "com.uservoice.uservoicesdk";
    private final Context context;

    public DefaultCallback(Context paramContext) {
        this.context = paramContext;
    }

    public void onError(RestResult paramRestResult) {
        Log.e("com.uservoice.uservoicesdk", paramRestResult.getMessage());
        try {
            new AlertDialog.Builder(this.context).setTitle(R.string.uv_network_error).show();
            return;
        } catch (Exception paramRestResult) {
            Log.e("com.uservoice.uservoicesdk", "Failed trying to show alert: " + paramRestResult.getMessage());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/DefaultCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */