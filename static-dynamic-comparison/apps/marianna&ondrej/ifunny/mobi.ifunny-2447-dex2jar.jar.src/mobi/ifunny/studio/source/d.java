package mobi.ifunny.studio.source;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import mobi.ifunny.gallery.a.a;
import mobi.ifunny.gallery.g;
import mobi.ifunny.gallery.h;
import mobi.ifunny.rest.content.WebImage;
import mobi.ifunny.rest.content.WebImageFeed;

public abstract class d<D extends Drawable>
        extends a<WebImage, WebImageFeed> {
    protected String a;
    private e b;

    protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
        if (this.b != null) {
            paramAdapterView = (WebImage) i().c(paramInt).a;
            this.b.a(paramAdapterView);
        }
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        try {
            this.b = ((e) paramActivity);
            return;
        } catch (ClassCastException paramActivity) {
            throw new IllegalStateException(paramActivity);
        }
    }

    public void onCreate(Bundle paramBundle) {
        this.a = getArguments().getString("arg.query");
        super.onCreate(paramBundle);
        if (this.a == null) {
            throw new IllegalStateException();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (i() != null) {
            i().e();
        }
    }

    public void onDetach() {
        super.onDetach();
        this.b = null;
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        f(2131690112);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/source/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */