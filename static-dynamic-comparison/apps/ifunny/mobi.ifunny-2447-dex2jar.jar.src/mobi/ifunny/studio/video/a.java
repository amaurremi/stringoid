package mobi.ifunny.studio.video;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class a
        extends Thread {
    a(UploadVideoActivity paramUploadVideoActivity) {
    }

    public void run() {
        UploadVideoActivity.a(this.a).requestFocus();
        ((InputMethodManager) this.a.getSystemService("input_method")).showSoftInput(UploadVideoActivity.a(this.a), 1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/video/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */