package mobi.ifunny.search;

import android.support.v4.view.ViewPager;
import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.FragmentTabWidget;

public class SearchFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, SearchFragment paramSearchFragment, Object paramObject) {
        paramSearchFragment.fragmentTabWidget = ((FragmentTabWidget) paramFinder.findRequiredView(paramObject, 2131493292, "field 'fragmentTabWidget'"));
        paramSearchFragment.viewPager = ((ViewPager) paramFinder.findRequiredView(paramObject, 2131493293, "field 'viewPager'"));
    }

    public static void reset(SearchFragment paramSearchFragment) {
        paramSearchFragment.fragmentTabWidget = null;
        paramSearchFragment.viewPager = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/SearchFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */