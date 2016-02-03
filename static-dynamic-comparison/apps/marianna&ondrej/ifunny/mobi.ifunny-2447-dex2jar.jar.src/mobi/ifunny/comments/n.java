package mobi.ifunny.comments;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class n
        implements TextView.OnEditorActionListener {
    n(CommentsFragment paramCommentsFragment) {
    }

    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            CommentsFragment.a(this.a);
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */