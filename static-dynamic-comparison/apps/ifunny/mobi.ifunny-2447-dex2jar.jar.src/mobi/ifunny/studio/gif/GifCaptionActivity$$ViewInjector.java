package mobi.ifunny.studio.gif;

import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;

public class GifCaptionActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, GifCaptionActivity paramGifCaptionActivity, Object paramObject) {
        View localView = paramFinder.findRequiredView(paramObject, 2131493032, "field 'imageView' and method 'onClick'");
        paramGifCaptionActivity.imageView = ((ImageViewEx) localView);
        localView.setOnClickListener(new a(paramGifCaptionActivity));
        paramGifCaptionActivity.imageProgress = ((ProgressBar) paramFinder.findRequiredView(paramObject, 2131493137, "field 'imageProgress'"));
        localView = paramFinder.findRequiredView(paramObject, 2131493138, "field 'textFrame' and method 'onClick'");
        paramGifCaptionActivity.textFrame = localView;
        localView.setOnClickListener(new b(paramGifCaptionActivity));
        paramGifCaptionActivity.captionEditor = paramFinder.findRequiredView(paramObject, 2131493133, "field 'captionEditor'");
        paramGifCaptionActivity.titleEditor = ((EditText) paramFinder.findRequiredView(paramObject, 2131493033, "field 'titleEditor'"));
        paramGifCaptionActivity.gifSpeedSeek = ((SeekBar) paramFinder.findRequiredView(paramObject, 2131493136, "field 'gifSpeedSeek'"));
    }

    public static void reset(GifCaptionActivity paramGifCaptionActivity) {
        paramGifCaptionActivity.imageView = null;
        paramGifCaptionActivity.imageProgress = null;
        paramGifCaptionActivity.textFrame = null;
        paramGifCaptionActivity.captionEditor = null;
        paramGifCaptionActivity.titleEditor = null;
        paramGifCaptionActivity.gifSpeedSeek = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/GifCaptionActivity$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */