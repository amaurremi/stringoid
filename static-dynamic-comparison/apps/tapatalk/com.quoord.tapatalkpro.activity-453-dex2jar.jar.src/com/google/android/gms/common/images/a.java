package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.internal.ex;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fa;
import com.google.android.gms.internal.fa.a;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fo;

import java.lang.ref.WeakReference;

public abstract class a {
    final a Cm;
    protected int Cn = 0;
    protected int Co = 0;
    private boolean Cp = true;
    private boolean Cq = false;
    protected int Cr;

    public a(Uri paramUri, int paramInt) {
        this.Cm = new a(paramUri);
        this.Co = paramInt;
    }

    private Drawable a(Context paramContext, fa paramfa, int paramInt) {
        Resources localResources = paramContext.getResources();
        if (this.Cr > 0) {
            fa.a locala = new fa.a(paramInt, this.Cr);
            Drawable localDrawable = (Drawable) paramfa.get(locala);
            paramContext = localDrawable;
            if (localDrawable == null) {
                localDrawable = localResources.getDrawable(paramInt);
                paramContext = localDrawable;
                if ((this.Cr & 0x1) != 0) {
                    paramContext = a(localResources, localDrawable);
                }
                paramfa.put(locala, paramContext);
            }
            return paramContext;
        }
        return localResources.getDrawable(paramInt);
    }

    public void J(int paramInt) {
        this.Co = paramInt;
    }

    protected Drawable a(Resources paramResources, Drawable paramDrawable) {
        return ey.a(paramResources, paramDrawable);
    }

    protected ex a(Drawable paramDrawable1, Drawable paramDrawable2) {
        if (paramDrawable1 != null) {
            localDrawable = paramDrawable1;
            if (!(paramDrawable1 instanceof ex)) {
            }
        }
        for (Drawable localDrawable = ((ex) paramDrawable1).ez(); ; localDrawable = null) {
            return new ex(localDrawable, paramDrawable2);
        }
    }

    void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean) {
        fb.d(paramBitmap);
        Bitmap localBitmap = paramBitmap;
        if ((this.Cr & 0x1) != 0) {
            localBitmap = ey.a(paramBitmap);
        }
        a(new BitmapDrawable(paramContext.getResources(), localBitmap), paramBoolean, false, true);
    }

    void a(Context paramContext, fa paramfa) {
        Drawable localDrawable = null;
        if (this.Cn != 0) {
            localDrawable = a(paramContext, paramfa, this.Cn);
        }
        a(localDrawable, false, true, false);
    }

    void a(Context paramContext, fa paramfa, boolean paramBoolean) {
        Drawable localDrawable = null;
        if (this.Co != 0) {
            localDrawable = a(paramContext, paramfa, this.Co);
        }
        a(localDrawable, paramBoolean, false, false);
    }

    protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

    protected boolean b(boolean paramBoolean1, boolean paramBoolean2) {
        return (this.Cp) && (!paramBoolean2) && ((!paramBoolean1) || (this.Cq));
    }

    static final class a {
        public final Uri uri;

        public a(Uri paramUri) {
            this.uri = paramUri;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof a)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            return fo.equal(((a) paramObject).uri, this.uri);
        }

        public int hashCode() {
            return fo.hashCode(new Object[]{this.uri});
        }
    }

    public static final class b
            extends a {
        private WeakReference<ImageView> Cs;

        public b(ImageView paramImageView, int paramInt) {
            super(paramInt);
            fb.d(paramImageView);
            this.Cs = new WeakReference(paramImageView);
        }

        public b(ImageView paramImageView, Uri paramUri) {
            super(0);
            fb.d(paramImageView);
            this.Cs = new WeakReference(paramImageView);
        }

        private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
            if ((!paramBoolean2) && (!paramBoolean3)) {
            }
            for (int i = 1; (i != 0) && ((paramImageView instanceof ez)); i = 0) {
                int j = ((ez) paramImageView).eB();
                if ((this.Co == 0) || (j != this.Co)) {
                    break;
                }
                return;
            }
            paramBoolean1 = b(paramBoolean1, paramBoolean2);
            if (paramBoolean1) {
                paramDrawable = a(paramImageView.getDrawable(), paramDrawable);
            }
            for (; ; ) {
                paramImageView.setImageDrawable(paramDrawable);
                ez localez;
                if ((paramImageView instanceof ez)) {
                    localez = (ez) paramImageView;
                    if (!paramBoolean3) {
                        break label149;
                    }
                    paramImageView = this.Cm.uri;
                    label110:
                    localez.e(paramImageView);
                    if (i == 0) {
                        break label154;
                    }
                }
                label149:
                label154:
                for (i = this.Co; ; i = 0) {
                    localez.L(i);
                    if (!paramBoolean1) {
                        break;
                    }
                    ((ex) paramDrawable).startTransition(250);
                    return;
                    paramImageView = null;
                    break label110;
                }
            }
        }

        protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
            ImageView localImageView = (ImageView) this.Cs.get();
            if (localImageView != null) {
                a(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
            }
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof b)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            Object localObject = (b) paramObject;
            paramObject = (ImageView) this.Cs.get();
            localObject = (ImageView) ((b) localObject).Cs.get();
            if ((localObject != null) && (paramObject != null) && (fo.equal(localObject, paramObject))) {
            }
            for (boolean bool = true; ; bool = false) {
                return bool;
            }
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class c
            extends a {
        private WeakReference<ImageManager.OnImageLoadedListener> Ct;

        public c(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri) {
            super(0);
            fb.d(paramOnImageLoadedListener);
            this.Ct = new WeakReference(paramOnImageLoadedListener);
        }

        protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
            if (!paramBoolean2) {
                ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener) this.Ct.get();
                if (localOnImageLoadedListener != null) {
                    localOnImageLoadedListener.onImageLoaded(this.Cm.uri, paramDrawable, paramBoolean3);
                }
            }
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof c)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            paramObject = (c) paramObject;
            ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener) this.Ct.get();
            ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener) ((c) paramObject).Ct.get();
            if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (fo.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (fo.equal(((c) paramObject).Cm, this.Cm))) {
            }
            for (boolean bool = true; ; bool = false) {
                return bool;
            }
        }

        public int hashCode() {
            return fo.hashCode(new Object[]{this.Cm});
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/images/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */