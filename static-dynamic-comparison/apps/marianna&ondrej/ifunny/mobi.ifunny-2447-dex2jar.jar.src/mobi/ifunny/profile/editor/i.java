package mobi.ifunny.profile.editor;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import mobi.ifunny.view.SettingsItemLayout;

class i
        implements View.OnFocusChangeListener {
    i(b paramb) {
    }

    public void onFocusChange(View paramView, boolean paramBoolean) {
        if (paramView.hasFocus()) {
            b.h(this.a).setTextColor(b.f());
            b.i(this.a).getBottomLine().setBackgroundColor(b.f());
            return;
        }
        b.h(this.a).setTextColor(b.h());
        b.i(this.a).getBottomLine().setBackgroundColor(b.g());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */