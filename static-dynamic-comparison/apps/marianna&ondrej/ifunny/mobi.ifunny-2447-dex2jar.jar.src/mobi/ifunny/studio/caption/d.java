package mobi.ifunny.studio.caption;

import android.widget.ScrollView;
import mobi.ifunny.view.FitImageView;

class d
        implements Runnable {
    d(CaptionEditorActivity paramCaptionEditorActivity) {
    }

    public void run() {
        this.a.container.scrollTo(0, this.a.imageView.getScaledHeight());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/caption/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */