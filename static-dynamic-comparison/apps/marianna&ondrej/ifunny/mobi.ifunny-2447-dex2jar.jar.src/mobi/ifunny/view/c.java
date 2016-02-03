package mobi.ifunny.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class c {
    private View b;
    private View c;
    private TextView d;
    private String e;
    private int f;

    public c(DynamicListView paramDynamicListView, int paramInt) {
        this.f = paramInt;
    }

    public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup) {
        a(paramLayoutInflater.inflate(this.f, paramViewGroup, false));
        return this.b;
    }

    public void a() {
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.d.setText(this.e);
    }

    public void a(View paramView) {
        this.b = paramView;
        this.c = paramView.findViewById(2131493258);
        this.d = ((TextView) paramView.findViewById(2131493290));
    }

    public final void a(String paramString) {
        this.e = paramString;
    }

    public void b() {
        this.c.setVisibility(0);
        this.d.setVisibility(4);
    }

    public final View c() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */