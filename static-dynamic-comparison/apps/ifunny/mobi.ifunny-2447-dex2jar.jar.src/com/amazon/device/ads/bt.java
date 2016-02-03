package com.amazon.device.ads;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;

final class bt
        implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    private static String a = "AdVideoPlayer";
    private Controller.PlayerProperties b;
    private AudioManager c;
    private bu d;
    private String e;
    private int f;
    private boolean g = false;
    private Context h;
    private VideoView i = null;
    private ViewGroup.LayoutParams j = null;
    private ViewGroup k = null;

    public bt(Context paramContext) {
        this.h = paramContext;
        this.b = new Controller.PlayerProperties();
        this.c = ((AudioManager) this.h.getSystemService("audio"));
    }

    private void f() {
        VideoView localVideoView = new VideoView(this.h);
        localVideoView.setOnCompletionListener(this);
        localVideoView.setOnErrorListener(this);
        localVideoView.setLayoutParams(this.j);
        this.i = localVideoView;
        this.k.addView(this.i);
    }

    private void g() {
        Uri localUri = Uri.parse(this.e);
        this.i.setVideoURI(localUri);
    }

    private void h() {
        dv.b(a, "in displayPlayerControls");
        if (this.b.b()) {
            MediaController localMediaController = new MediaController(this.h);
            this.i.setMediaController(localMediaController);
            localMediaController.setAnchorView(this.i);
            localMediaController.requestFocus();
        }
    }

    private void i() {
        dv.b(a, "in removePlayerFromParent");
        this.k.removeView(this.i);
    }

    public void a() {
        dv.b(a, "in playVideo");
        if (this.b.d()) {
            b();
        }
        f();
        g();
        d();
    }

    public void a(ViewGroup.LayoutParams paramLayoutParams) {
        this.j = paramLayoutParams;
    }

    public void a(ViewGroup paramViewGroup) {
        this.k = paramViewGroup;
    }

    public void a(Controller.PlayerProperties paramPlayerProperties, String paramString) {
        this.g = false;
        if (paramPlayerProperties != null) {
            this.b = paramPlayerProperties;
        }
        this.e = paramString;
    }

    public void a(bu parambu) {
        this.d = parambu;
    }

    public void b() {
        dv.b(a, "in mutePlayer");
        this.f = this.c.getStreamVolume(3);
        this.c.setStreamVolume(3, 0, 4);
    }

    public void c() {
        dv.b(a, "in unmutePlayer");
        this.c.setStreamVolume(3, this.f, 4);
    }

    public void d() {
        dv.b(a, "in startPlaying");
        h();
        if (this.b.a()) {
            this.i.start();
        }
    }

    public void e() {
        dv.b(a, "in releasePlayer");
        if (this.g) {
        }
        do {
            return;
            this.g = true;
            this.i.stopPlayback();
            i();
        } while (!this.b.d());
        c();
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        if (this.b.c()) {
            this.i.start();
        }
        do {
            do {
                return;
            } while ((!this.b.e()) && (!this.b.e));
            e();
        } while (this.d == null);
        this.d.a();
    }

    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        i();
        if (this.d != null) {
            this.d.b();
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */