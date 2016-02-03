package android.webkit;

import android.content.Context;
import android.view.View;

public abstract interface PluginStub {
    public abstract View getEmbeddedView(int paramInt, Context paramContext);

    public abstract View getFullScreenView(int paramInt, Context paramContext);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/PluginStub.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */