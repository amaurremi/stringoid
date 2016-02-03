package mobi.ifunny.studio.comics.view;

import android.view.View;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

class i {
    private LinkedHashMap<Integer, View> b = new LinkedHashMap();

    private i(HorizontalAdapterView paramHorizontalAdapterView) {
    }

    private View a(int paramInt) {
        Object localObject3 = null;
        if (this.b.size() > 0) {
            Object localObject2 = Integer.valueOf(paramInt);
            localObject3 = (View) this.b.get(Integer.valueOf(paramInt));
            Object localObject1 = localObject3;
            if (localObject3 == null) {
                localObject2 = (Map.Entry) this.b.entrySet().iterator().next();
                localObject1 = (View) ((Map.Entry) localObject2).getValue();
                localObject2 = (Integer) ((Map.Entry) localObject2).getKey();
            }
            localObject3 = localObject1;
            if (localObject1 != null) {
                this.b.remove(localObject2);
                localObject3 = localObject1;
            }
        }
        return HorizontalAdapterView.a(this.a, (View) localObject3, paramInt);
    }

    private void a(View paramView, int paramInt) {
        this.b.put(Integer.valueOf(paramInt), paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/view/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */