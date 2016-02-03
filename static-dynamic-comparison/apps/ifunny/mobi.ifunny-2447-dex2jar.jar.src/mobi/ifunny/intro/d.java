package mobi.ifunny.intro;

import android.support.v4.view.ax;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class d
        extends ax {
    List<View> a = null;

    public d(List<View> paramList) {
        List localList;
        this.a = localList;
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        paramViewGroup.removeView((View) paramObject);
    }

    public int getCount() {
        return this.a.size();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        View localView = (View) this.a.get(paramInt);
        paramViewGroup.addView(localView, 0);
        return localView;
    }

    public boolean isViewFromObject(View paramView, Object paramObject) {
        return paramView.equals(paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/intro/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */