package mobi.ifunny.view;

import android.view.View;
import android.view.View.OnClickListener;

class f
        implements View.OnClickListener {
    f(e parame) {
    }

    public void onClick(View paramView) {
        int i;
        if (DynamicListView.b(this.a.a) != null) {
            i = ((Integer) paramView.getTag()).intValue();
            if (i != 0) {
                break label61;
            }
            DynamicListView.b(this.a.a).O();
            DynamicListView.c(this.a.a).a(0).b();
        }
        label61:
        while (i != 1) {
            return;
        }
        DynamicListView.b(this.a.a).P();
        DynamicListView.c(this.a.a).a(1).b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */