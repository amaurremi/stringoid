package mobi.ifunny.studio.comics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

class k
        extends ArrayAdapter<Integer> {
    public k(FrameEditorActivity paramFrameEditorActivity, Context paramContext, Integer[] paramArrayOfInteger) {
        super(paramContext, 0, paramArrayOfInteger);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Integer localInteger = (Integer) getItem(paramInt);
        if (paramView == null) {
            paramView = this.a.getLayoutInflater().inflate(2130903076, paramViewGroup, false);
            paramViewGroup = paramView.findViewById(2131493040);
            paramView.setTag(new j(localInteger, paramViewGroup, paramView.findViewById(2131493039), null));
        }
        for (; ; ) {
            paramViewGroup.setBackgroundColor(localInteger.intValue());
            return paramView;
            j localj = (j) paramView.getTag();
            paramViewGroup = localj.b;
            localj.a = localInteger;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */