package mobi.ifunny.studio.meme;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class a
        implements TextWatcher {
    a(MemeEditorActivity paramMemeEditorActivity) {
    }

    public void afterTextChanged(Editable paramEditable) {
        paramEditable = paramEditable.toString();
        if (paramEditable.length() > 0) {
            MemeEditorActivity.b(this.a).getBackground().setLevel(0);
            if (!paramEditable.equals(paramEditable.toUpperCase())) {
                paramEditable = paramEditable.toUpperCase();
                MemeEditorActivity.b(this.a).setText(paramEditable);
                MemeEditorActivity.b(this.a).setSelection(paramEditable.length());
            }
            return;
        }
        MemeEditorActivity.b(this.a).getBackground().setLevel(1);
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        MemeEditorActivity.a(this.a).postInvalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */