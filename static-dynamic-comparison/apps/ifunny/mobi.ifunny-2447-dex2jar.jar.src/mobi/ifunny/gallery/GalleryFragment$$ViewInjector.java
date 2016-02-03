package mobi.ifunny.gallery;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class GalleryFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, GalleryFragment paramGalleryFragment, Object paramObject) {
        paramGalleryFragment.pager = ((GalleryViewPager) paramFinder.findRequiredView(paramObject, 2131493106, "field 'pager'"));
        paramGalleryFragment.progressBar = paramFinder.findRequiredView(paramObject, 2131493107, "field 'progressBar'");
        paramGalleryFragment.bottomPanel = paramFinder.findRequiredView(paramObject, 2131493108, "field 'bottomPanel'");
        paramGalleryFragment.smileBtn = paramFinder.findRequiredView(paramObject, 2131493109, "field 'smileBtn'");
        paramGalleryFragment.smileImage = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493110, "field 'smileImage'"));
        paramGalleryFragment.smileCounter = ((TextView) paramFinder.findRequiredView(paramObject, 2131493111, "field 'smileCounter'"));
        paramGalleryFragment.unsmileBtn = paramFinder.findRequiredView(paramObject, 2131493112, "field 'unsmileBtn'");
        paramGalleryFragment.unsmileImage = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493113, "field 'unsmileImage'"));
        paramGalleryFragment.commentsBtn = paramFinder.findRequiredView(paramObject, 2131493115, "field 'commentsBtn'");
        paramGalleryFragment.commentsCounter = ((TextView) paramFinder.findRequiredView(paramObject, 2131493117, "field 'commentsCounter'"));
        paramGalleryFragment.activityBtn = paramFinder.findRequiredView(paramObject, 2131493114, "field 'activityBtn'");
        paramGalleryFragment.activityAnchor = paramFinder.findRequiredView(paramObject, 2131493122, "field 'activityAnchor'");
        paramGalleryFragment.emptyLayout = paramFinder.findRequiredView(paramObject, 2131493093, "field 'emptyLayout'");
        paramGalleryFragment.overlayAnimationView = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493118, "field 'overlayAnimationView'"));
        paramGalleryFragment.blackBackground = paramFinder.findRequiredView(paramObject, 2131493105, "field 'blackBackground'");
    }

    public static void reset(GalleryFragment paramGalleryFragment) {
        paramGalleryFragment.pager = null;
        paramGalleryFragment.progressBar = null;
        paramGalleryFragment.bottomPanel = null;
        paramGalleryFragment.smileBtn = null;
        paramGalleryFragment.smileImage = null;
        paramGalleryFragment.smileCounter = null;
        paramGalleryFragment.unsmileBtn = null;
        paramGalleryFragment.unsmileImage = null;
        paramGalleryFragment.commentsBtn = null;
        paramGalleryFragment.commentsCounter = null;
        paramGalleryFragment.activityBtn = null;
        paramGalleryFragment.activityAnchor = null;
        paramGalleryFragment.emptyLayout = null;
        paramGalleryFragment.overlayAnimationView = null;
        paramGalleryFragment.blackBackground = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/GalleryFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */