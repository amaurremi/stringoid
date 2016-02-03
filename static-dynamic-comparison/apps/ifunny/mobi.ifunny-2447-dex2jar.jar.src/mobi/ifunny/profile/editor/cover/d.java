package mobi.ifunny.profile.editor.cover;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import mobi.ifunny.k.m;
import mobi.ifunny.k.x;
import mobi.ifunny.rest.content.Cover;
import mobi.ifunny.rest.content.CoverList;
import mobi.ifunny.util.a.a;
import mobi.ifunny.view.drawable.f;

public class d
        extends BaseAdapter {
    private CoverList a = new CoverList();
    private final m<ImageView, f> b = new m(4, 8000);
    private final x c = new x();

    public d() {
        this.b.a(new e(this));
    }

    public String a(int paramInt) {
        return ((Cover) this.a.items.get(paramInt)).thumb_url;
    }

    public void a() {
        this.b.b();
    }

    public void a(CoverList paramCoverList) {
        if (this.a != paramCoverList) {
            this.a = paramCoverList;
            notifyDataSetChanged();
        }
    }

    public String b(int paramInt) {
        return ((Cover) this.a.items.get(paramInt)).url;
    }

    public int getCount() {
        return this.a.items.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        String str = a(paramInt);
        View localView = paramView;
        if (paramView == null) {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903075, paramViewGroup, false);
        }
        paramView = (ImageView) localView.findViewById(2131492972);
        boolean bool = TextUtils.equals(str, (String) paramView.getTag());
        if (paramView.getDrawable() == null) {
            paramInt = 1;
            if ((!bool) || (paramInt != 0)) {
                paramView.setImageDrawable(null);
                paramView.getBackground().setLevel(mobi.ifunny.util.r.b(1, 6));
                paramViewGroup = this.b.b(paramView);
                if (paramViewGroup != null) {
                    break label170;
                }
                paramInt = 1;
            }
        }
        for (; ; ) {
            if (paramInt != 0) {
                paramViewGroup = paramView.getLayoutParams();
                paramViewGroup = new a(str, new Point(paramViewGroup.width, paramViewGroup.height), false);
                this.b.a(paramView, new mobi.ifunny.k.r(this.c, paramViewGroup));
            }
            return localView;
            paramInt = 0;
            break;
            label170:
            if (!TextUtils.equals(str, paramViewGroup.b.c())) {
                this.b.a(paramView);
                paramInt = 1;
            } else {
                paramInt = 0;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/cover/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */