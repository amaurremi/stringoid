package mobi.ifunny.studio.gif;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import mobi.ifunny.video.a;

class c
        implements SeekBar.OnSeekBarChangeListener {
    c(GifCaptionActivity paramGifCaptionActivity) {
    }

    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {
        GifCaptionActivity.a(this.a, paramInt);
        paramInt -= GifCaptionActivity.a(this.a);
        if (paramInt == 0) {
            GifCaptionActivity.a(this.a, 1.0F);
        }
        for (; ; ) {
            if (GifCaptionActivity.c(this.a) != null) {
                GifCaptionActivity.c(this.a).a(GifCaptionActivity.d(this.a));
            }
            return;
            if (paramInt > 0) {
                GifCaptionActivity.a(this.a, (paramInt + 1) * GifCaptionActivity.b(this.a));
            } else {
                paramInt = -(paramInt - 1);
                GifCaptionActivity.a(this.a, 1.0F / (paramInt * GifCaptionActivity.b(this.a)));
            }
        }
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar) {
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */