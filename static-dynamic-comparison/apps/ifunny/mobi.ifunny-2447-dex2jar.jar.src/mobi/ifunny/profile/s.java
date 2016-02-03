package mobi.ifunny.profile;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.emilsjolander.components.StickyScrollViewItems.StickyScrollView;

class s
        implements ViewTreeObserver.OnGlobalLayoutListener {
    private s(l paraml) {
    }

    public void onGlobalLayout() {
        l.b(this.a).b();
        l.b(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */