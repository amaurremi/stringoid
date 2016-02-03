package mobi.ifunny.studio.meme;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.ScrollView;

class c
        implements ViewTreeObserver.OnGlobalLayoutListener {
    c(MemeEditorActivity paramMemeEditorActivity) {
    }

    public void onGlobalLayout() {
        if (MemeEditorActivity.d(this.a) == null) {
        }
        do {
            return;
            if (MemeEditorActivity.d(this.a).getRootView().getHeight() - MemeEditorActivity.d(this.a).getHeight() <= 200) {
                break;
            }
            MemeEditorActivity.e(this.a);
        } while (!MemeEditorActivity.c(this.a).isFocused());
        MemeEditorActivity.f(this.a).postDelayed(new d(this), 200L);
        return;
        MemeEditorActivity.g(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */