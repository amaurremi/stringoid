package mobi.ifunny.studio.caption;

import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.FitImageView;

public class CaptionEditorActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, CaptionEditorActivity paramCaptionEditorActivity, Object paramObject) {
        paramCaptionEditorActivity.container = ((ScrollView) paramFinder.findRequiredView(paramObject, 2131493031, "field 'container'"));
        View localView = paramFinder.findRequiredView(paramObject, 2131493032, "field 'imageView' and method 'onClick'");
        paramCaptionEditorActivity.imageView = ((FitImageView) localView);
        localView.setOnClickListener(new a(paramCaptionEditorActivity));
        paramCaptionEditorActivity.imageProgress = paramFinder.findRequiredView(paramObject, 2131493034, "field 'imageProgress'");
        paramCaptionEditorActivity.imagePlaceholder = paramFinder.findRequiredView(paramObject, 2131493035, "field 'imagePlaceholder'");
        paramCaptionEditorActivity.titleEditor = ((EditText) paramFinder.findRequiredView(paramObject, 2131493033, "field 'titleEditor'"));
        paramFinder.findRequiredView(paramObject, 2131493030, "method 'onClick'").setOnClickListener(new b(paramCaptionEditorActivity));
    }

    public static void reset(CaptionEditorActivity paramCaptionEditorActivity) {
        paramCaptionEditorActivity.container = null;
        paramCaptionEditorActivity.imageView = null;
        paramCaptionEditorActivity.imageProgress = null;
        paramCaptionEditorActivity.imagePlaceholder = null;
        paramCaptionEditorActivity.titleEditor = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/caption/CaptionEditorActivity$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */