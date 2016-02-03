package mobi.ifunny.userlists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.k.a;
import mobi.ifunny.k.z;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.util.ah;

public class e
        extends BaseAdapter
        implements AbsListView.RecyclerListener {
    private int a;
    private List<IFunny> b;
    private LayoutInflater c;
    private String d;
    private a e;
    private View.OnClickListener f;

    public e(LayoutInflater paramLayoutInflater, View.OnClickListener paramOnClickListener, int paramInt, List<IFunny> paramList, String paramString, a parama) {
        this.a = paramInt;
        this.f = paramOnClickListener;
        this.b = new ArrayList(this.a);
        this.e = parama;
        a(paramList, paramString, false);
        this.c = paramLayoutInflater;
    }

    public IFunny a(int paramInt) {
        return (IFunny) this.b.get(paramInt);
    }

    public void a(List<IFunny> paramList, String paramString, boolean paramBoolean) {
        this.b.clear();
        this.d = paramString;
        if ((paramList != null) && (paramList.size() > 0)) {
            this.b.addAll(paramList.subList(0, Math.min(paramList.size(), this.a)));
        }
        if (paramBoolean) {
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.b.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        IFunny localIFunny = a(paramInt);
        String str = localIFunny.getThumbUrl(ah.c(paramViewGroup.getContext()));
        if (paramView == null) {
            paramView = this.c.inflate(2130903099, paramViewGroup, false);
            paramViewGroup = new f();
            paramViewGroup.a(paramView);
            paramView.setTag(paramViewGroup);
            paramView.setOnClickListener(this.f);
        }
        for (; ; ) {
            paramViewGroup.e = localIFunny;
            paramViewGroup.h = this.d;
            paramViewGroup = new z(paramViewGroup.g, paramViewGroup.f, str, this.d, paramViewGroup);
            this.e.a(paramViewGroup, paramView);
            return paramView;
            paramViewGroup = (f) paramView.getTag();
        }
    }

    public void notifyDataSetChanged() {
        this.e.a(this.d);
        super.notifyDataSetChanged();
    }

    public void onMovedToScrapHeap(View paramView) {
        this.e.a(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */