package mobi.ifunny.studio.gif;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import mobi.ifunny.view.ImageViewEx;

class f
        implements ViewTreeObserver.OnGlobalLayoutListener {
    f(GifCaptionActivity paramGifCaptionActivity) {
    }

    public void onGlobalLayout() {
        float f = this.a.imageView.getScale();
        Rect localRect = GifCaptionActivity.e(this.a).f();
        this.a.titleEditor.setPadding((int) (localRect.left * f), (int) (localRect.top * f), (int) (localRect.right * f), (int) (localRect.bottom * f));
        this.a.titleEditor.setTextSize(0, f * GifCaptionActivity.e(this.a).g());
        this.a.imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */