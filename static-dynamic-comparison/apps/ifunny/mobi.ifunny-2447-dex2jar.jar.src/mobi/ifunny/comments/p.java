package mobi.ifunny.comments;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

class p
        implements TextWatcher {
    p(CommentsFragment paramCommentsFragment) {
    }

    public void afterTextChanged(Editable paramEditable) {
        if ((paramEditable == null) || (TextUtils.isEmpty(paramEditable.toString()))) {
            this.a.sendCommentView.setEnabled(false);
            return;
        }
        this.a.sendCommentView.setEnabled(true);
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */