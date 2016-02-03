package mobi.ifunny.profile.editor;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

class h
        implements TextWatcher {
    h(b paramb) {
    }

    public void afterTextChanged(Editable paramEditable) {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        paramCharSequence = b.h(this.a).getText();
        if (paramCharSequence != null) {
            paramCharSequence = paramCharSequence.toString().trim();
            if (TextUtils.isEmpty(paramCharSequence)) {
            }
        }
        for (; ; ) {
            this.a.b.about = paramCharSequence;
            return;
            paramCharSequence = null;
            continue;
            paramCharSequence = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */