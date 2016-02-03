package com.inmobi.androidsdk;

import android.view.View;
import android.view.View.OnClickListener;
import com.inmobi.re.container.IMWebView;

class IMBrowserActivity$b
        implements View.OnClickListener {
    IMBrowserActivity$b(IMBrowserActivity paramIMBrowserActivity) {
    }

    public void onClick(View paramView) {
        if (IMBrowserActivity.a() != null) {
            IMBrowserActivity.a().close();
        }
        this.a.finish();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/androidsdk/IMBrowserActivity$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */