package com.everimaging.fotorsdk.imagepicker;

import android.support.v4.app.Fragment;
import android.view.View;

import java.util.List;

public class ImagePickerBaseFragment
        extends Fragment {
    protected a a;
    protected b b;

    public void a(a parama) {
        this.a = parama;
    }

    public void a(b paramb) {
        this.b = paramb;
    }

    public static abstract interface a {
        public abstract void a(ImagePickerBaseFragment paramImagePickerBaseFragment, View paramView, Picture paramPicture);

        public abstract void a(ImagePickerBaseFragment paramImagePickerBaseFragment, Picture paramPicture);
    }

    public static abstract interface b {
        public abstract void a(ImagePickerBaseFragment paramImagePickerBaseFragment);

        public abstract void a(ImagePickerBaseFragment paramImagePickerBaseFragment, List<Picture> paramList);

        public abstract void b(ImagePickerBaseFragment paramImagePickerBaseFragment);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/imagepicker/ImagePickerBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */