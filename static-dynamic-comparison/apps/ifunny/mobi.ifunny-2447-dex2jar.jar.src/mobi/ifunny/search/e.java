package mobi.ifunny.search;

import android.support.v7.widget.SearchView;

class e
        implements Runnable {
    e(SearchFragment paramSearchFragment) {
    }

    public void run() {
        if ((this.a.getActivity() == null) || (this.a.isDetached())) {
            return;
        }
        SearchFragment.c(this.a).setQuery(SearchFragment.b(this.a), false);
        SearchFragment.c(this.a).requestFocus();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */