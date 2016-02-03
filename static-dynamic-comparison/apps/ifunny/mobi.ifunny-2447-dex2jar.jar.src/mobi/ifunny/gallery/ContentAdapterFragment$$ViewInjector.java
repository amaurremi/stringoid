package mobi.ifunny.gallery;

import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class ContentAdapterFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, ContentAdapterFragment paramContentAdapterFragment, Object paramObject) {
        paramContentAdapterFragment.progressView = paramFinder.findRequiredView(paramObject, 2131493254, "field 'progressView'");
        paramContentAdapterFragment.emptyLayout = paramFinder.findRequiredView(paramObject, 2131493093, "field 'emptyLayout'");
        paramContentAdapterFragment.emptyText = ((TextView) paramFinder.findRequiredView(paramObject, 2131493094, "field 'emptyText'"));
        paramContentAdapterFragment.additionalLayout = paramFinder.findRequiredView(paramObject, 2131493013, "field 'additionalLayout'");
    }

    public static void reset(ContentAdapterFragment paramContentAdapterFragment) {
        paramContentAdapterFragment.progressView = null;
        paramContentAdapterFragment.emptyLayout = null;
        paramContentAdapterFragment.emptyText = null;
        paramContentAdapterFragment.additionalLayout = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/ContentAdapterFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */