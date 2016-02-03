package mobi.ifunny.studio.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import mobi.ifunny.k.u;

class e
        extends u<View, mobi.ifunny.view.drawable.f> {
    e(d paramd) {
    }

    public void a(View paramView, mobi.ifunny.view.drawable.f paramf) {
        paramView = (f) paramView.getTag();
        if (paramf == null) {
            return;
        }
        f.a(paramView).setImageDrawable(paramf);
        f.a(paramView).getBackground().setLevel(0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/video/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */