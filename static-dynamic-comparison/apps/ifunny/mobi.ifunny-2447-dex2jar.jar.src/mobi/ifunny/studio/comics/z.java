package mobi.ifunny.studio.comics;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.ifunny.k.m;
import mobi.ifunny.k.r;
import mobi.ifunny.k.x;
import mobi.ifunny.rest.content.RageCategory;
import mobi.ifunny.util.a.a;
import mobi.ifunny.view.drawable.f;

class z
        extends ArrayAdapter<RageCategory> {
    private final x b = new x();
    private final m<View, f> c = new m(4, 6000);

    public z(FrameEditorActivity paramFrameEditorActivity, Context paramContext, RageCategory[] paramArrayOfRageCategory) {
        super(paramContext, 0, paramArrayOfRageCategory);
        this.c.a(new aa(this, paramFrameEditorActivity));
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        RageCategory localRageCategory = (RageCategory) getItem(paramInt);
        boolean bool;
        if (paramView == null) {
            paramView = this.a.getLayoutInflater().inflate(2130903072, paramViewGroup, false);
            paramViewGroup = new ab((ImageView) paramView.findViewById(2131493036), (TextView) paramView.findViewById(2131493037), localRageCategory, null);
            paramView.setTag(paramViewGroup);
            bool = false;
        }
        while ((bool) && (ab.a(paramViewGroup).getDrawable() != null)) {
            ab.a(paramViewGroup).setDrawingCacheEnabled(true);
            if (!bool) {
                ab.c(paramViewGroup).setText(localRageCategory.name);
            }
            return paramView;
            paramViewGroup = (ab) paramView.getTag();
            bool = localRageCategory.equals(ab.b(paramViewGroup));
            ab.a(paramViewGroup, localRageCategory);
        }
        r localr = this.c.b(paramView);
        if (localr != null) {
            if (TextUtils.equals(localRageCategory.icon_url, localr.b.c())) {
                break label244;
            }
            this.c.a(paramView);
            paramInt = 1;
        }
        for (; ; ) {
            if (paramInt != 0) {
                this.c.a(paramView, new r(this.b, new a(localRageCategory.icon_url)));
            }
            ab.a(paramViewGroup).setImageDrawable(null);
            ab.a(paramViewGroup).getBackground().setLevel(0);
            break;
            paramInt = 1;
            continue;
            label244:
            paramInt = 0;
        }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (paramView == null) {
            paramView = this.a.getLayoutInflater().inflate(2130903073, paramViewGroup, false);
        }
        for (; ; ) {
            ((TextView) paramView).setText(((RageCategory) getItem(paramInt)).name);
            return paramView;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */