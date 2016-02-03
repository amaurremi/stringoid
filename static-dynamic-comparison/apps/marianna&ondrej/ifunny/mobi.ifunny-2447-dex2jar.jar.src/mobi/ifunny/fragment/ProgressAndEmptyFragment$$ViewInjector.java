package mobi.ifunny.fragment;

import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class ProgressAndEmptyFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, ProgressAndEmptyFragment paramProgressAndEmptyFragment, Object paramObject) {
        paramProgressAndEmptyFragment.emptyLayout = paramFinder.findRequiredView(paramObject, 2131493093, "field 'emptyLayout'");
        paramProgressAndEmptyFragment.emptyTextView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493094, "field 'emptyTextView'"));
        paramProgressAndEmptyFragment.progress = paramFinder.findRequiredView(paramObject, 2131493254, "field 'progress'");
    }

    public static void reset(ProgressAndEmptyFragment paramProgressAndEmptyFragment) {
        paramProgressAndEmptyFragment.emptyLayout = null;
        paramProgressAndEmptyFragment.emptyTextView = null;
        paramProgressAndEmptyFragment.progress = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/ProgressAndEmptyFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */