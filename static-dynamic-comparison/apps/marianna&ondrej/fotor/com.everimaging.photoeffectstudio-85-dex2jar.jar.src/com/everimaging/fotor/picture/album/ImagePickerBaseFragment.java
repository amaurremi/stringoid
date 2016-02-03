package com.everimaging.fotor.picture.album;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.everimaging.fotor.picture.entity.Album;

import java.util.List;

public class ImagePickerBaseFragment
        extends Fragment {
    protected a a;
    protected b b;
    protected Context c;

    public void a(a parama) {
        this.a = parama;
    }

    public void a(b paramb) {
        this.b = paramb;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.c = getActivity().getApplicationContext();
    }

    public static abstract interface a {
        public abstract void a(ImagePickerBaseFragment paramImagePickerBaseFragment, Album paramAlbum);
    }

    public static abstract interface b {
        public abstract void a(ImagePickerBaseFragment paramImagePickerBaseFragment);

        public abstract void a(ImagePickerBaseFragment paramImagePickerBaseFragment, List<Album> paramList);

        public abstract void b(ImagePickerBaseFragment paramImagePickerBaseFragment);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/picture/album/ImagePickerBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */