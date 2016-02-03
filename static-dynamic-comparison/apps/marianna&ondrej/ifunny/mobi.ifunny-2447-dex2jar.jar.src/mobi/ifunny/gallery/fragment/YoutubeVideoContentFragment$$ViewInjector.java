package mobi.ifunny.gallery.fragment;

import android.view.View;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;

public class YoutubeVideoContentFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, YoutubeVideoContentFragment paramYoutubeVideoContentFragment, Object paramObject) {
        paramYoutubeVideoContentFragment.progressBar = ((ProgressBar) paramFinder.findRequiredView(paramObject, 2131493129, "field 'progressBar'"));
        paramYoutubeVideoContentFragment.video = ((ImageViewEx) paramFinder.findRequiredView(paramObject, 2131493126, "field 'video'"));
        paramYoutubeVideoContentFragment.videoPlayView = paramFinder.findRequiredView(paramObject, 2131493127, "field 'videoPlayView'");
        paramFinder = paramFinder.findRequiredView(paramObject, 2131493128, "field 'videoPlayAnim' and method 'startVideo'");
        paramYoutubeVideoContentFragment.videoPlayAnim = ((ImageView) paramFinder);
        paramFinder.setOnClickListener(new af(paramYoutubeVideoContentFragment));
    }

    public static void reset(YoutubeVideoContentFragment paramYoutubeVideoContentFragment) {
        paramYoutubeVideoContentFragment.progressBar = null;
        paramYoutubeVideoContentFragment.video = null;
        paramYoutubeVideoContentFragment.videoPlayView = null;
        paramYoutubeVideoContentFragment.videoPlayAnim = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/YoutubeVideoContentFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */