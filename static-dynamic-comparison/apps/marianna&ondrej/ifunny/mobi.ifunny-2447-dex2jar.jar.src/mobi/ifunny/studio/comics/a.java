package mobi.ifunny.studio.comics;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;

class a
        implements TextWatcher {
    a(FrameEditorActivity paramFrameEditorActivity) {
    }

    public void afterTextChanged(Editable paramEditable) {
        paramEditable = paramEditable.toString().trim();
        if (TextUtils.isEmpty(paramEditable)) {
            FrameEditorActivity.a(this.a).setVisibility(0);
            if (FrameEditorActivity.b(this.a) != null) {
                FrameEditorActivity.b(this.a).setEnabled(false);
            }
        }
        for (; ; ) {
            FrameEditorActivity.a(this.a, paramEditable);
            return;
            FrameEditorActivity.a(this.a).setVisibility(4);
            if (FrameEditorActivity.b(this.a) != null) {
                FrameEditorActivity.b(this.a).setEnabled(true);
            }
        }
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */