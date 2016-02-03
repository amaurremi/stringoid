package mobi.ifunny.gallery.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mobi.ifunny.popup.PopupViewHolder;
import mobi.ifunny.rest.content.IFunny;

public class a
        extends BaseAdapter {
    private final ArrayList<b> a = new ArrayList();

    public b a(int paramInt) {
        return (b) this.a.get(paramInt);
    }

    public void a(IFunny paramIFunny, int paramInt) {
        this.a.clear();
        if (paramIFunny.isAbused()) {
            if ((!paramIFunny.hasSource()) && (paramInt == 2)) {
                paramInt = 1;
                if (paramInt != 0) {
                    this.a.add(b.g);
                }
            }
        }
        for (; ; ) {
            notifyDataSetChanged();
            return;
            paramInt = 0;
            break;
            this.a.add(b.a);
            this.a.add(b.b);
            if (paramIFunny.canBeSaved()) {
                this.a.add(b.c);
            }
            if (!paramIFunny.isCreatedByMe()) {
                if (!paramIFunny.isRepublished()) {
                    break label185;
                }
                this.a.add(b.e);
            }
            for (; ; ) {
                this.a.add(b.f);
                if ((paramIFunny.isInMyGallery()) && (paramIFunny.hasSource())) {
                    break;
                }
                switch (paramInt) {
                    default:
                        break;
                    case 1:
                        this.a.add(b.h);
                        break;
                    label185:
                    this.a.add(b.d);
                }
            }
            this.a.add(b.g);
        }
    }

    public int getCount() {
        return this.a.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        b localb = a(paramInt);
        Context localContext = paramViewGroup.getContext();
        Resources localResources = localContext.getResources();
        if (paramView == null) {
            paramView = LayoutInflater.from(localContext).inflate(2130903138, paramViewGroup, false);
            paramViewGroup = new PopupViewHolder(paramView);
            paramView.setTag(paramViewGroup);
        }
        for (; ; ) {
            paramViewGroup.image.setImageDrawable(localResources.getDrawable(localb.k));
            paramViewGroup.text.setText(localb.i);
            paramViewGroup.text.setTextAppearance(localContext, localb.j);
            return paramView;
            paramViewGroup = (PopupViewHolder) paramView.getTag();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */