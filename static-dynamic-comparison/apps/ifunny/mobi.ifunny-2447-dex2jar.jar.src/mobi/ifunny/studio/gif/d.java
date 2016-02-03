package mobi.ifunny.studio.gif;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class d
        implements TextWatcher {
    d(GifCaptionActivity paramGifCaptionActivity) {
    }

    public void afterTextChanged(Editable paramEditable) {
        Drawable localDrawable = this.a.titleEditor.getBackground();
        if (paramEditable.length() > 0) {
        }
        for (int i = 0; ; i = 1) {
            localDrawable.setLevel(i);
            return;
        }
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */