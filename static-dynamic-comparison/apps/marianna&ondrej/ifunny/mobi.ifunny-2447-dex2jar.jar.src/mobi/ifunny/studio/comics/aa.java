package mobi.ifunny.studio.comics;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import mobi.ifunny.k.u;
import mobi.ifunny.view.drawable.f;

class aa
        extends u<View, f> {
    aa(z paramz, FrameEditorActivity paramFrameEditorActivity) {
    }

    public void a(View paramView, f paramf) {
        paramView = (ab) paramView.getTag();
        if (paramf != null) {
            ab.a(paramView).setImageDrawable(paramf);
            ab.a(paramView).getBackground().setLevel(1);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */