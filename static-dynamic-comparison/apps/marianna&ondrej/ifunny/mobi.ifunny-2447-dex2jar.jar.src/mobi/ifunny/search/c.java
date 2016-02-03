package mobi.ifunny.search;

import android.support.v4.view.ah;

class c
        implements Runnable {
    c(SearchFragment paramSearchFragment) {
    }

    public void run() {
        if ((this.a.getActivity() == null) || (this.a.isDetached())) {
            return;
        }
        ah.b(SearchFragment.a(this.a));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */