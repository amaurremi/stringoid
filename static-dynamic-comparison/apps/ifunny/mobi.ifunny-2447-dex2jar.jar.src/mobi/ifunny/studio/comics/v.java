package mobi.ifunny.studio.comics;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import mobi.ifunny.studio.comics.view.ConstantRatioImageView;
import mobi.ifunny.view.ProgressBar;

class v
        extends mobi.ifunny.k.u<View, Bitmap> {
    v(u paramu, FrameEditorActivity paramFrameEditorActivity) {
    }

    public void a(View paramView, Bitmap paramBitmap) {
        if (paramBitmap != null) {
            paramView = (x) paramView.getTag();
            x.b(paramView).setImageDrawable(new BitmapDrawable(this.b.a.getResources(), paramBitmap));
            x.b(paramView).setVisibility(0);
            x.c(paramView).setVisibility(4);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */