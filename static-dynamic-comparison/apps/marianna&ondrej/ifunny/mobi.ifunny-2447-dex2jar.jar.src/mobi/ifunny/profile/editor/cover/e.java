package mobi.ifunny.profile.editor.cover;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import mobi.ifunny.k.u;
import mobi.ifunny.view.drawable.f;

class e
        extends u<ImageView, f> {
    e(d paramd) {
    }

    public void a(ImageView paramImageView, f paramf) {
        if (paramf == null) {
            return;
        }
        paramImageView.getBackground().setLevel(0);
        paramImageView.setImageDrawable(paramf);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/cover/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */