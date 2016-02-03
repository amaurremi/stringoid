package mobi.ifunny.gallery;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import java.lang.reflect.Field;

import mobi.ifunny.view.PinchImageView;

public class GalleryViewPager
        extends ViewPager {
    public GalleryViewPager(Context paramContext) {
        super(paramContext);
    }

    public GalleryViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        try {
            paramContext = ViewPager.class.getDeclaredField("E");
            paramContext.setAccessible(true);
            paramContext.set(this, Integer.valueOf(paramContext.getInt(this) / 2));
            return;
        } catch (NoSuchFieldException paramContext) {
        } catch (IllegalArgumentException paramContext) {
        } catch (IllegalAccessException paramContext) {
        }
    }

    protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
        if ((paramView instanceof PinchImageView)) {
            PinchImageView localPinchImageView = (PinchImageView) paramView;
            if (localPinchImageView.getVisibility() == 0) {
                return localPinchImageView.a(paramInt1, paramInt2, paramInt3);
            }
        }
        return super.a(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/GalleryViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */