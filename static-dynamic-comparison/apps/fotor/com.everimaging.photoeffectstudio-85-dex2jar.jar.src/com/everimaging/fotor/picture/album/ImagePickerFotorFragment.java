package com.everimaging.fotor.picture.album;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;
import com.everimaging.fotor.App;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotor.picture.entity.Album;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;

import java.util.ArrayList;
import java.util.List;

public class ImagePickerFotorFragment
        extends ImagePickerBaseFragment
        implements AdapterView.OnItemClickListener {
    private static final String d = ImagePickerFotorFragment.class.getSimpleName();
    private static final LoggerFactory.c e = LoggerFactory.a(d, LoggerFactory.LoggerType.CONSOLE);
    private c f;
    private b g;
    private int h;
    private GridView i;
    private b j;
    private View k;
    private Handler l = new Handler();
    private a m;

    private void c() {
        try {
            if (this.m == null) {
                this.m = new a(this.l);
            }
            this.c.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.m);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private void d() {
        e.c(new Object[]{"loadData"});
        if (this.f != null) {
            this.f.cancel(true);
        }
        this.f = new c();
        this.f.execute(new String[]{App.g()});
    }

    public void a() {
        try {
            this.c.getContentResolver().unregisterContentObserver(this.m);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.h = ((int) ((DeviceUtils.getScreenWidth() - getResources().getDimension(2131165422) * 5.0F) / 4.0F));
        d();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.g = new b(this.c);
        c();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903075, paramViewGroup, false);
        this.i = ((GridView) paramLayoutInflater.findViewById(2131558501));
        this.i.setOnItemClickListener(this);
        this.k = paramLayoutInflater.findViewById(2131558502);
        return paramLayoutInflater;
    }

    public void onDestroy() {
        a();
        if (this.g != null) {
            this.g.a();
        }
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        try {
            int n = ImagePickerFotorFragment.b.a.b((ImagePickerFotorFragment.b.a) paramView.getTag()).getVisibility();
            if (n == 0) {
                return;
            }
        } catch (Exception paramAdapterView) {
            do {
                paramAdapterView.printStackTrace();
                paramAdapterView = this.j.a(paramInt);
            } while (this.a == null);
            this.a.a(this, paramAdapterView);
        }
    }

    class a
            extends ContentObserver {
        public a(Handler paramHandler) {
            super();
        }

        public void onChange(boolean paramBoolean) {
            super.onChange(paramBoolean);
            ImagePickerFotorFragment.b().c(new Object[]{"onChange:" + paramBoolean});
            if (paramBoolean) {
                ImagePickerFotorFragment.g(ImagePickerFotorFragment.this);
            }
        }
    }

    class b
            extends BaseAdapter {
        private List<Album> b;

        public b() {
        }

        public Album a(int paramInt) {
            if (this.b == null) {
                return null;
            }
            return (Album) this.b.get(paramInt);
        }

        public void a(List<Album> paramList) {
            this.b = paramList;
        }

        public int getCount() {
            if (this.b == null) {
                return 0;
            }
            return this.b.size();
        }

        public Object getItem(int paramInt) {
            if (this.b == null) {
                return null;
            }
            return (Album) this.b.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup) {
            if (paramView == null) {
                paramViewGroup = new a();
                paramView = ((LayoutInflater) ImagePickerFotorFragment.this.c.getSystemService("layout_inflater")).inflate(2130903077, null, false);
                a.a(paramViewGroup, (AlbumImageItem) paramView.findViewById(2131558455));
                a.a(paramViewGroup, (ProgressBar) paramView.findViewById(2131558504));
                paramView.setLayoutParams(new AbsListView.LayoutParams(ImagePickerFotorFragment.e(ImagePickerFotorFragment.this), ImagePickerFotorFragment.e(ImagePickerFotorFragment.this)));
                paramView.setTag(paramViewGroup);
            }
            for (; ; ) {
                Album localAlbum = (Album) this.b.get(paramInt);
                a.a(paramViewGroup).setChecked(false);
                ImagePickerFotorFragment.f(ImagePickerFotorFragment.this).a(a.a(paramViewGroup), localAlbum, 0, ImagePickerFotorFragment.e(ImagePickerFotorFragment.this), ImagePickerFotorFragment.e(ImagePickerFotorFragment.this), new b.a() {
                    public void a(View paramAnonymousView, Album paramAnonymousAlbum) {
                        ImagePickerFotorFragment.b.a.b(paramViewGroup).setVisibility(0);
                    }

                    public void b(View paramAnonymousView, Album paramAnonymousAlbum) {
                        ImagePickerFotorFragment.b.a.b(paramViewGroup).setVisibility(8);
                    }

                    public void c(View paramAnonymousView, Album paramAnonymousAlbum) {
                    }
                });
                return paramView;
                paramViewGroup = (a) paramView.getTag();
            }
        }

        class a {
            private AlbumImageItem b;
            private ProgressBar c;

            a() {
            }
        }
    }

    class c
            extends FotorAsyncTask<String, Void, List<Album>> {
        c() {
        }

        private void a(Cursor paramCursor, List<Album> paramList) {
            if (paramCursor.getCount() > 0) {
                paramCursor.moveToFirst();
                do {
                    String str1 = paramCursor.getString(paramCursor.getColumnIndex("_data"));
                    String str2 = paramCursor.getString(paramCursor.getColumnIndex("bucket_id"));
                    String str3 = paramCursor.getString(paramCursor.getColumnIndex("bucket_display_name"));
                    int k = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
                    int i = 0;
                    try {
                        int j = paramCursor.getInt(paramCursor.getColumnIndex("orientation"));
                        i = j;
                    } catch (Exception localException) {
                        for (; ; ) {
                            Album localAlbum;
                            localException.printStackTrace();
                        }
                    }
                    localAlbum = new Album();
                    localAlbum.a(str2);
                    localAlbum.b(str3);
                    localAlbum.c(k);
                    localAlbum.c(str1);
                    localAlbum.a(i);
                    paramList.add(localAlbum);
                } while (paramCursor.moveToNext());
            } else {
                return;
            }
        }

        protected List<Album> a(String... paramVarArgs) {
            ArrayList localArrayList = null;
            paramVarArgs = paramVarArgs[0];
            if (ImagePickerFotorFragment.this.c == null) {
                paramVarArgs = localArrayList;
            }
            Cursor localCursor;
            do {
                return paramVarArgs;
                localCursor = ImagePickerFotorFragment.this.c.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "bucket_display_name=?", new String[]{paramVarArgs}, "date_modified desc ");
                localArrayList = new ArrayList();
                paramVarArgs = localArrayList;
            } while (localCursor == null);
            a(localCursor, localArrayList);
            localCursor.close();
            return localArrayList;
        }

        protected void a(List<Album> paramList) {
            if ((paramList == null) || (paramList.size() == 0)) {
                ImagePickerFotorFragment.b(ImagePickerFotorFragment.this).setVisibility(0);
                ImagePickerFotorFragment.c(ImagePickerFotorFragment.this).setAdapter(null);
            }
            for (; ; ) {
                ImagePickerFotorFragment.a(ImagePickerFotorFragment.this, null);
                if (ImagePickerFotorFragment.this.b != null) {
                    ImagePickerFotorFragment.this.b.a(ImagePickerFotorFragment.this, paramList);
                }
                ImagePickerFotorFragment.a(ImagePickerFotorFragment.this);
                return;
                ImagePickerFotorFragment.b(ImagePickerFotorFragment.this).setVisibility(8);
                ImagePickerFotorFragment.a(ImagePickerFotorFragment.this, new ImagePickerFotorFragment.b(ImagePickerFotorFragment.this));
                ImagePickerFotorFragment.d(ImagePickerFotorFragment.this).a(paramList);
                ImagePickerFotorFragment.c(ImagePickerFotorFragment.this).setAdapter(ImagePickerFotorFragment.d(ImagePickerFotorFragment.this));
            }
        }

        protected void onCancelled() {
            if (ImagePickerFotorFragment.this.b != null) {
                ImagePickerFotorFragment.this.b.b(ImagePickerFotorFragment.this);
            }
            ImagePickerFotorFragment.a(ImagePickerFotorFragment.this);
        }

        protected void onPreExecute() {
            if (ImagePickerFotorFragment.this.b != null) {
                ImagePickerFotorFragment.this.b.a(ImagePickerFotorFragment.this);
            }
            ImagePickerFotorFragment.this.a();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/picture/album/ImagePickerFotorFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */