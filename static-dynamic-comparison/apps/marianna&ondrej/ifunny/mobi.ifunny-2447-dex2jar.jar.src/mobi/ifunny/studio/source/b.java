package mobi.ifunny.studio.source;

import android.support.v7.widget.SearchView;
import android.view.inputmethod.InputMethodManager;

class b
        implements Runnable {
    b(WebSearchActivity paramWebSearchActivity) {
    }

    public void run() {
        WebSearchActivity.a(this.a).requestFocus();
        ((InputMethodManager) this.a.getSystemService("input_method")).showSoftInput(WebSearchActivity.a(this.a), 1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/source/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */