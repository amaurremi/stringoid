package mobi.ifunny.studio.comics;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.k.d;
import mobi.ifunny.k.m;
import mobi.ifunny.k.r;
import mobi.ifunny.rest.content.RageFace;
import mobi.ifunny.studio.comics.view.ConstantRatioImageView;
import mobi.ifunny.util.a.a;
import mobi.ifunny.view.ProgressBar;

class u
        extends BaseAdapter {
    private final m<View, Bitmap> b = new m(2, 6000);
    private final d c = new d();
    private int d;
    private List<RageFace> e;
    private SparseArray<Point> f;

    public u(List<RageFace> paramList, int paramInt) {
        this.b.a(new v(this, paramList));
        int i;
        this.d = i;
        this.e = new ArrayList();
        this.f = new SparseArray();
        if (paramInt != null) {
            this.e.addAll(paramInt);
        }
    }

    public void a() {
        b();
        this.e.clear();
        this.f.clear();
        notifyDataSetInvalidated();
    }

    public void a(RageFace paramRageFace, Point paramPoint) {
        this.e.add(paramRageFace);
        this.f.append(this.f.size(), paramPoint);
        notifyDataSetChanged();
    }

    public void b() {
        this.b.a();
    }

    public int getCount() {
        return this.e.size();
    }

    public Object getItem(int paramInt) {
        return this.e.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        int j = 1;
        RageFace localRageFace = (RageFace) getItem(paramInt);
        ProgressBar localProgressBar;
        Object localObject2;
        if (paramView == null) {
            paramView = this.a.getLayoutInflater().inflate(2130903108, paramViewGroup, false);
            paramViewGroup = (ConstantRatioImageView) paramView.findViewById(2131493036);
            localProgressBar = (ProgressBar) paramView.findViewById(2131493095);
            paramView.setTag(new x(paramInt, paramViewGroup, localRageFace, localProgressBar, null));
            localObject1 = null;
            localObject2 = (Point) this.f.get(paramInt);
            if (localObject2 != null) {
                paramViewGroup.a(((Point) localObject2).x, ((Point) localObject2).y);
            }
            if ((localObject1 == null) || (!TextUtils.equals(((RageFace) localObject1).url, localRageFace.url))) {
                break label208;
            }
            paramInt = 1;
            label129:
            if (paramViewGroup.getDrawable() == null) {
                break label213;
            }
        }
        label208:
        label213:
        for (int i = 1; ; i = 0) {
            if ((paramInt == 0) || (i == 0)) {
                break label219;
            }
            paramViewGroup.setVisibility(0);
            localProgressBar.setVisibility(4);
            return paramView;
            localObject2 = (x) paramView.getTag();
            x.a((x) localObject2, paramInt);
            localProgressBar = x.c((x) localObject2);
            paramViewGroup = x.b((x) localObject2);
            localObject1 = x.a((x) localObject2);
            x.a((x) localObject2, localRageFace);
            break;
            paramInt = 0;
            break label129;
        }
        label219:
        Object localObject1 = this.b.b(paramView);
        paramInt = j;
        if (localObject1 != null) {
            if (TextUtils.equals(localRageFace.url, ((r) localObject1).b.c())) {
                break label333;
            }
            this.b.a(paramView);
        }
        label333:
        for (paramInt = j; ; paramInt = 0) {
            if (paramInt != 0) {
                this.b.a(paramView, new r(this.c, new a(localRageFace.url, new Point(0, this.d), false)));
            }
            paramViewGroup.setImageDrawable(null);
            paramViewGroup.setVisibility(4);
            localProgressBar.setVisibility(0);
            return paramView;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */