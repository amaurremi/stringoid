package mobi.ifunny.popup;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ListPopupWindow;
import android.widget.ListView;

public class a
        extends ListPopupWindow {
    public a(Context paramContext) {
        super(paramContext);
        setModal(true);
        setListSelector(paramContext.getResources().getDrawable(2130837829));
    }

    public void show() {
        super.show();
        ListView localListView = getListView();
        localListView.setDivider(null);
        localListView.setDividerHeight(0);
        localListView.setHorizontalScrollBarEnabled(false);
        localListView.setVerticalScrollBarEnabled(false);
        localListView.setVerticalFadingEdgeEnabled(false);
        localListView.setHorizontalFadingEdgeEnabled(false);
        localListView.setOverScrollMode(2);
        super.show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/popup/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */