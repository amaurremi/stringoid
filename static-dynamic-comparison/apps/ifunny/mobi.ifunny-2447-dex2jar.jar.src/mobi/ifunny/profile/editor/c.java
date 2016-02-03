package mobi.ifunny.profile.editor;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class c
        implements ViewTreeObserver.OnGlobalLayoutListener {
    c(b paramb) {
    }

    public void onGlobalLayout() {
        View localView = this.a.getView();
        int i = localView.getWidth() / 2;
        ViewGroup.LayoutParams localLayoutParams = b.a(this.a).getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = i;
        b.a(this.a).setLayoutParams(localLayoutParams);
        localView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */