package uk.co.chrisjenx.paralloid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class ParallaxScrollView
        extends ScrollView {
    uk.co.chrisjenx.paralloid.c a;

    public ParallaxScrollView(Context paramContext) {
        super(paramContext);
        a();
    }

    public ParallaxScrollView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a();
    }

    public ParallaxScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
    }

    private void a() {
        this.a = uk.co.chrisjenx.paralloid.c.a(this);
    }

    public void a(View paramView, uk.co.chrisjenx.paralloid.c.c paramc, float paramFloat) {
        this.a.a(paramView, paramc, paramFloat);
    }

    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        this.a.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/chrisjenx/paralloid/views/ParallaxScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */