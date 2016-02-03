package mobi.ifunny.studio.comics;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class l
        extends BaseAdapter {
    private LayoutInflater a;
    private int b;
    private ac[] c;

    public l(Context paramContext, int paramInt, ac[] paramArrayOfac) {
        int i = paramArrayOfac.length;
        this.c = new ac[i];
        System.arraycopy(paramArrayOfac, 0, this.c, 0, i);
        this.a = ((LayoutInflater) paramContext.getSystemService("layout_inflater"));
        this.b = paramInt;
    }

    public ac a(int paramInt) {
        return this.c[paramInt];
    }

    public int getCount() {
        return this.c.length;
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return getView(paramInt, paramView, paramViewGroup);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        TextView localTextView;
        if (paramView == null) {
            paramView = this.a.inflate(2130903110, paramViewGroup, false);
            localTextView = (TextView) paramView.findViewById(2131493038);
            paramViewGroup = paramView.findViewById(2131493097);
            paramView.setTag(new Pair(localTextView, paramViewGroup));
            ac localac = a(paramInt);
            localTextView.setText(localac.b());
            localTextView.setTypeface(localac.c());
            if (this.b != paramInt) {
                break label120;
            }
        }
        label120:
        for (paramInt = 0; ; paramInt = 4) {
            paramViewGroup.setVisibility(paramInt);
            return paramView;
            paramViewGroup = (Pair) paramView.getTag();
            localTextView = (TextView) paramViewGroup.first;
            paramViewGroup = (View) paramViewGroup.second;
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */