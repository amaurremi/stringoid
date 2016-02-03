package mobi.ifunny.profile.editor;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import mobi.ifunny.view.SettingsItemLayout;

class f
        implements View.OnFocusChangeListener {
    f(b paramb) {
    }

    public void onFocusChange(View paramView, boolean paramBoolean) {
        b.a(this.a, paramBoolean);
        paramView = b.d(this.a).getBottomLine();
        if (paramBoolean) {
            paramView.setBackgroundColor(b.f());
        }
        for (; ; ) {
            b.a(this.a, b.e(this.a));
            return;
            paramView.setBackgroundColor(b.g());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */