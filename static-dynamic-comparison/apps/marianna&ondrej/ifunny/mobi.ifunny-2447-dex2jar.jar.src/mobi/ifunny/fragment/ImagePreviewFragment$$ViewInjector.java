package mobi.ifunny.fragment;

import android.view.View;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.ProgressBar;

public class ImagePreviewFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, ImagePreviewFragment paramImagePreviewFragment, Object paramObject) {
        paramImagePreviewFragment.progress = ((ProgressBar) paramFinder.findRequiredView(paramObject, 2131493149, "field 'progress'"));
        paramImagePreviewFragment.image = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493150, "field 'image'"));
        paramFinder.findRequiredView(paramObject, 2131493148, "method 'onDialogClicked'").setOnClickListener(new e(paramImagePreviewFragment));
    }

    public static void reset(ImagePreviewFragment paramImagePreviewFragment) {
        paramImagePreviewFragment.progress = null;
        paramImagePreviewFragment.image = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/ImagePreviewFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */