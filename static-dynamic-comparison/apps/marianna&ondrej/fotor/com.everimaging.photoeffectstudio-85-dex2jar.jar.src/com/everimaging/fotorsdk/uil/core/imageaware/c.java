package com.everimaging.fotorsdk.uil.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.everimaging.fotorsdk.uil.core.assist.ViewScaleType;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class c
        implements a {
    protected Reference<ImageView> a;
    protected boolean b;

    public c(ImageView paramImageView) {
        this(paramImageView, true);
    }

    public c(ImageView paramImageView, boolean paramBoolean) {
        this.a = new WeakReference(paramImageView);
        this.b = paramBoolean;
    }

    private static int a(Object paramObject, String paramString) {
        try {
            paramString = ImageView.class.getDeclaredField(paramString);
            paramString.setAccessible(true);
            int i = ((Integer) paramString.get(paramObject)).intValue();
            if ((i > 0) && (i < Integer.MAX_VALUE)) {
                return i;
            }
        } catch (Exception paramObject) {
            com.everimaging.fotorsdk.uil.utils.c.a((Throwable) paramObject);
        }
        return 0;
    }

    public int a() {
        int j = 0;
        ImageView localImageView = (ImageView) this.a.get();
        if (localImageView != null) {
            ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
            int i = j;
            if (this.b) {
                i = j;
                if (localLayoutParams != null) {
                    i = j;
                    if (localLayoutParams.width != -2) {
                        i = localImageView.getWidth();
                    }
                }
            }
            j = i;
            if (i <= 0) {
                j = i;
                if (localLayoutParams != null) {
                    j = localLayoutParams.width;
                }
            }
            if (j <= 0) {
                return a(localImageView, "mMaxWidth");
            }
        } else {
            return 0;
        }
        return j;
    }

    public boolean a(int paramInt) {
        ImageView localImageView = (ImageView) this.a.get();
        if (localImageView != null) {
            localImageView.setImageResource(paramInt);
            return true;
        }
        return false;
    }

    public boolean a(Bitmap paramBitmap) {
        ImageView localImageView = (ImageView) this.a.get();
        if (localImageView != null) {
            localImageView.setImageBitmap(paramBitmap);
            return true;
        }
        return false;
    }

    public boolean a(Drawable paramDrawable) {
        ImageView localImageView = (ImageView) this.a.get();
        if (localImageView != null) {
            localImageView.setImageDrawable(paramDrawable);
            return true;
        }
        return false;
    }

    public int b() {
        int j = 0;
        ImageView localImageView = (ImageView) this.a.get();
        if (localImageView != null) {
            ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
            int i = j;
            if (this.b) {
                i = j;
                if (localLayoutParams != null) {
                    i = j;
                    if (localLayoutParams.height != -2) {
                        i = localImageView.getHeight();
                    }
                }
            }
            j = i;
            if (i <= 0) {
                j = i;
                if (localLayoutParams != null) {
                    j = localLayoutParams.height;
                }
            }
            if (j <= 0) {
                return a(localImageView, "mMaxHeight");
            }
        } else {
            return 0;
        }
        return j;
    }

    public ViewScaleType c() {
        ImageView localImageView = (ImageView) this.a.get();
        if (localImageView != null) {
            return ViewScaleType.fromImageView(localImageView);
        }
        return null;
    }

    public boolean e() {
        return this.a.get() == null;
    }

    public int f() {
        ImageView localImageView = (ImageView) this.a.get();
        if (localImageView == null) {
            return super.hashCode();
        }
        return localImageView.hashCode();
    }

    public ImageView g() {
        return (ImageView) this.a.get();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/imageaware/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */