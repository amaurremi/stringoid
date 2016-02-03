package mobi.ifunny.profile.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import mobi.ifunny.profile.i;
import mobi.ifunny.rest.content.Feed;

public abstract class a<D, T extends Feed<D>>
        extends mobi.ifunny.gallery.a.a<D, T>
        implements mobi.ifunny.profile.a, i {
    private FrameLayout.LayoutParams a;

    public void a(FrameLayout.LayoutParams paramLayoutParams) {
        this.a = paramLayoutParams;
        if (this.additionalLayout == null) {
        }
        while (paramLayoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams localLayoutParams = this.additionalLayout.getLayoutParams();
        localLayoutParams.width = paramLayoutParams.width;
        localLayoutParams.height = paramLayoutParams.height;
        if ((localLayoutParams instanceof FrameLayout.LayoutParams)) {
            ((FrameLayout.LayoutParams) localLayoutParams).gravity = paramLayoutParams.gravity;
        }
        for (; ; ) {
            this.additionalLayout.requestLayout();
            return;
            if ((localLayoutParams instanceof LinearLayout.LayoutParams)) {
                ((LinearLayout.LayoutParams) localLayoutParams).gravity = paramLayoutParams.gravity;
            }
        }
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        a(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/fragments/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */