package mobi.ifunny.main.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.d.m;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.ifunny.popup.PopupViewHolder;
import mobi.ifunny.rest.retrofit.RestNotification.Counters;
import mobi.ifunny.util.r;

public final class a
        extends BaseAdapter {
    private final SparseArray<b> a = new SparseArray(5);
    private final m<b, String> b;
    private b c;

    public a() {
        d(b.a);
        d(b.c);
        d(b.d);
        d(b.e);
        d(b.f);
        this.b = new m(5);
    }

    private void d(b paramb) {
        this.a.put(paramb.ordinal(), paramb);
    }

    public b a() {
        return this.c;
    }

    public b a(int paramInt) {
        return (b) this.a.valueAt(paramInt);
    }

    public void a(b paramb) {
        if (this.c != paramb) {
            this.c = paramb;
            notifyDataSetChanged();
        }
    }

    public void a(b paramb, String paramString) {
        if (!TextUtils.equals((String) this.b.get(paramb), paramString)) {
            this.b.put(paramb, paramString);
            notifyDataSetChanged();
        }
    }

    public void a(RestNotification.Counters paramCounters) {
        a(b.a, r.a(paramCounters.featured));
        a(b.c, r.b(paramCounters.collective));
        a(b.d, r.a(paramCounters.subscriptions));
        a(b.f, r.a(paramCounters.news));
    }

    public void b(b paramb) {
        a(paramb, null);
    }

    public String c(b paramb) {
        return (String) this.b.get(paramb);
    }

    public int getCount() {
        return this.a.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Object localObject1 = a(paramInt);
        Context localContext;
        Object localObject2;
        label62:
        int i;
        if (localObject1 == this.c) {
            paramInt = 1;
            localContext = paramViewGroup.getContext();
            localObject2 = localContext.getResources();
            if (paramView != null) {
                break label161;
            }
            paramView = LayoutInflater.from(localContext).inflate(2130903138, paramViewGroup, false);
            paramViewGroup = new PopupViewHolder(paramView);
            paramView.setTag(paramViewGroup);
            ImageView localImageView = paramViewGroup.image;
            if (paramInt == 0) {
                break label172;
            }
            i = ((b) localObject1).i;
            label79:
            localImageView.setImageDrawable(((Resources) localObject2).getDrawable(i));
            paramViewGroup.text.setText(((b) localObject1).g);
            localObject2 = paramViewGroup.text;
            if (paramInt == 0) {
                break label182;
            }
        }
        label161:
        label172:
        label182:
        for (paramInt = 2131755133; ; paramInt = 2131755131) {
            ((TextView) localObject2).setTextAppearance(localContext, paramInt);
            localObject1 = (String) this.b.get(localObject1);
            if (!TextUtils.isEmpty((CharSequence) localObject1)) {
                break label188;
            }
            paramViewGroup.counter.setVisibility(4);
            return paramView;
            paramInt = 0;
            break;
            paramViewGroup = (PopupViewHolder) paramView.getTag();
            break label62;
            i = ((b) localObject1).h;
            break label79;
        }
        label188:
        paramViewGroup.counter.setVisibility(0);
        paramViewGroup.counter.setText((CharSequence) localObject1);
        return paramView;
    }

    public boolean hasStableIds() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */