package mobi.ifunny.profile;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.emilsjolander.components.StickyScrollViewItems.StickyScrollView;

class r
        implements ViewTreeObserver.OnPreDrawListener {
    private r(l paraml) {
    }

    public boolean onPreDraw() {
        l.b(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */