package mobi.ifunny.comments;

import android.support.v4.app.k;
import android.view.inputmethod.InputMethodManager;

class o
        implements Runnable {
    o(CommentsFragment paramCommentsFragment) {
    }

    public void run() {
        ((InputMethodManager) this.a.getActivity().getSystemService("input_method")).showSoftInput(this.a.writeCommentView, 2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */