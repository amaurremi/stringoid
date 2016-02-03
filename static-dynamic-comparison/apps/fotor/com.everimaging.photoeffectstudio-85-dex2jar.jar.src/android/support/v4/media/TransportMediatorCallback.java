package android.support.v4.media;

import android.view.KeyEvent;

abstract interface TransportMediatorCallback {
    public abstract long getPlaybackPosition();

    public abstract void handleAudioFocusChange(int paramInt);

    public abstract void handleKey(KeyEvent paramKeyEvent);

    public abstract void playbackPositionUpdate(long paramLong);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/media/TransportMediatorCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */