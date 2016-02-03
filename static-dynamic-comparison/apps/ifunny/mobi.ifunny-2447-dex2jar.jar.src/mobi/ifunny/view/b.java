package mobi.ifunny.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class b
        implements AdapterView.OnItemClickListener {
    b(DynamicListView paramDynamicListView, AdapterView.OnItemClickListener paramOnItemClickListener) {
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (!e.b(DynamicListView.a(this.b), paramInt - this.b.getHeaderViewsCount())) {
            this.a.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */