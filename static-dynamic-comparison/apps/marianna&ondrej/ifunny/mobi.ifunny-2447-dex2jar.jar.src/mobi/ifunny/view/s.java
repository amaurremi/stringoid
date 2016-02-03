package mobi.ifunny.view;

import android.view.View;

import java.util.Comparator;

class s
        implements Comparator<View> {
    s(PriorityLinearLayout paramPriorityLinearLayout) {
    }

    public int a(View paramView1, View paramView2) {
        paramView1 = (t) paramView1.getLayoutParams();
        paramView2 = (t) paramView2.getLayoutParams();
        if (paramView1.a == paramView2.a) {
            return 0;
        }
        if (paramView1.a < paramView2.a) {
            return -1;
        }
        return 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */