package android.support.v4.view;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.KeyEvent.DispatcherState;
import android.view.View;

class KeyEventCompatEclair {
    public static boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2) {
        return paramKeyEvent.dispatch(paramCallback, (KeyEvent.DispatcherState) paramObject1, paramObject2);
    }

    public static Object getKeyDispatcherState(View paramView) {
        return paramView.getKeyDispatcherState();
    }

    public static boolean isTracking(KeyEvent paramKeyEvent) {
        return paramKeyEvent.isTracking();
    }

    public static void startTracking(KeyEvent paramKeyEvent) {
        paramKeyEvent.startTracking();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/view/KeyEventCompatEclair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */