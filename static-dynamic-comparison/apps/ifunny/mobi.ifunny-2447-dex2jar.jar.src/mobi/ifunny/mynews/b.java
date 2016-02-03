package mobi.ifunny.mynews;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.ifunny.rest.content.IFunny;

class b
        implements View.OnClickListener {
    b(MyNewsAdapter paramMyNewsAdapter, IFunny paramIFunny) {
    }

    public void onClick(View paramView) {
        if (MyNewsAdapter.a(this.b) != null) {
            MyNewsAdapter.a(this.b).a(this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/mynews/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */