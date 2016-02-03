package mobi.ifunny.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

public class z
        extends j {
    private TextView a;

    public z(String paramString) {
        super(2130903172, paramString);
    }

    protected void a(View paramView) {
        this.a = ((TextView) paramView.findViewById(2131493336));
    }

    protected void a(View paramView, Drawable paramDrawable) {
    }

    protected void a(View paramView, String paramString) {
        this.a.setText(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */