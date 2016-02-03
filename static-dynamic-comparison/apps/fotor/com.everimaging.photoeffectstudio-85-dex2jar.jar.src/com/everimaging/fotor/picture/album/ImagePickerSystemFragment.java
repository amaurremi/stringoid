package com.everimaging.fotor.picture.album;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.everimaging.fotor.App;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotor.picture.entity.Album;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;

import java.util.ArrayList;
import java.util.List;

public class ImagePickerSystemFragment
        extends ImagePickerBaseFragment
        implements AdapterView.OnItemClickListener {
    private static final String d = ImagePickerSystemFragment.class.getSimpleName();
    private static final LoggerFactory.c e = LoggerFactory.a(d, LoggerFactory.LoggerType.CONSOLE);
    private int f = 0;
    private ViewSwitcher g;
    private ListView h;
    private GridView i;
    private List<Album> j = new ArrayList();
    private d k;
    private e l;
    private c m;
    private b n;
    private Handler o = new Handler();
    private Album p = null;
    private a q = null;
    private b r;
    private ArrayList<Album> s = new ArrayList();

    private void a(Cursor paramCursor, List<Album> paramList) {
        if (paramCursor.getCount() > 0) {
            paramCursor.moveToFirst();
        }
        for (; ; ) {
            String str1 = paramCursor.getString(paramCursor.getColumnIndex("_data"));
            String str2 = paramCursor.getString(paramCursor.getColumnIndex("bucket_id"));
            String str3 = paramCursor.getString(paramCursor.getColumnIndex("bucket_display_name"));
            int i3 = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
            try {
                i1 = paramCursor.getInt(paramCursor.getColumnIndex("orientation"));
                i2 = paramCursor.getColumnIndex("count");
                if (i2 != -1) {
                    i2 = paramCursor.getInt(i2);
                    Album localAlbum = new Album();
                    localAlbum.a(str2);
                    localAlbum.b(str3);
                    localAlbum.c(i3);
                    localAlbum.c(str1);
                    localAlbum.a(i1);
                    localAlbum.b(i2);
                    paramList.add(localAlbum);
                    if (paramCursor.moveToNext()) {
                        continue;
                    }
                    return;
                }
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                    int i1 = 0;
                    continue;
                    int i2 = 0;
                }
            }
        }
    }

    private void a(View paramView) {
        this.g = ((ViewSwitcher) paramView.findViewById(2131558503));
        this.h = ((ListView) paramView.findViewById(16908298));
        this.h.setOnItemClickListener(this);
        this.i = ((GridView) paramView.findViewById(2131558501));
        this.i.setOnItemClickListener(this);
        this.n = new b();
        this.i.setAdapter(this.n);
    }

    private void d() {
        try {
            if (this.q == null) {
                this.q = new a(this.o);
            }
            this.c.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.q);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private void e() {
        e.c(new Object[]{"loadAlbum"});
        if (this.k != null) {
            this.k.cancel(true);
        }
        this.k = new d();
        this.k.executeOnExecutor(FotorAsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void a() {
        try {
            this.c.getContentResolver().unregisterContentObserver(this.q);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void a(Album paramAlbum) {
        if (this.l != null) {
            this.l.cancel(true);
        }
        this.l = new e(null);
        this.l.executeOnExecutor(FotorAsyncTask.THREAD_POOL_EXECUTOR, new String[]{paramAlbum.a()});
    }

    public boolean b() {
        if (this.g.getDisplayedChild() != 0) {
            this.g.setInAnimation(this.c, 2130968604);
            this.g.setOutAnimation(this.c, 2130968607);
            this.g.showPrevious();
            if (this.l != null) {
                this.l.cancel(true);
            }
            return true;
        }
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.f = ((int) ((DeviceUtils.getScreenWidth() - getResources().getDimension(2131165422) * 5.0F) / 4.0F));
        e();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.r = new b(this.c);
        d();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903076, paramViewGroup, false);
        a(paramLayoutInflater);
        return paramLayoutInflater;
    }

    public void onDestroy() {
        a();
        if (this.r != null) {
            this.r.a();
        }
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        switch (paramAdapterView.getId()) {
        }
        do {
            for (; ; ) {
                return;
                this.p = ((Album) this.j.get(paramInt));
                a(this.p);
                return;
                try {
                    int i1 = ImagePickerSystemFragment.b.a.b((ImagePickerSystemFragment.b.a) paramView.getTag()).getVisibility();
                    if (i1 == 0) {
                    }
                } catch (Exception paramAdapterView) {
                    for (; ; ) {
                        paramAdapterView.printStackTrace();
                    }
                }
            }
            paramAdapterView = this.n.a(paramInt);
        } while (this.a == null);
        this.a.a(this, paramAdapterView);
    }

    class a
            extends ContentObserver {
        public a(Handler paramHandler) {
            super();
        }

        public void onChange(boolean paramBoolean) {
            super.onChange(paramBoolean);
            ImagePickerSystemFragment.c().c(new Object[]{"onChange:" + paramBoolean});
            if (paramBoolean) {
                if (ImagePickerSystemFragment.a(ImagePickerSystemFragment.this).getDisplayedChild() == 0) {
                    ImagePickerSystemFragment.b(ImagePickerSystemFragment.this);
                }
            } else {
                return;
            }
            ImagePickerSystemFragment.this.a(ImagePickerSystemFragment.c(ImagePickerSystemFragment.this));
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
            Album localAlbum;
            if (paramView == null) {
                paramViewGroup = new a();
                paramView = ((LayoutInflater) ImagePickerSystemFragment.this.c.getSystemService("layout_inflater")).inflate(2130903077, null);
                a.a(paramViewGroup, (AlbumImageItem) paramView.findViewById(2131558455));
                a.a(paramViewGroup, (ProgressBar) paramView.findViewById(2131558504));
                paramView.setLayoutParams(new AbsListView.LayoutParams(ImagePickerSystemFragment.i(ImagePickerSystemFragment.this), ImagePickerSystemFragment.i(ImagePickerSystemFragment.this)));
                paramView.setTag(paramViewGroup);
                localAlbum = (Album) this.b.get(paramInt);
                if (!ImagePickerSystemFragment.k(ImagePickerSystemFragment.this).contains(localAlbum)) {
                    break label184;
                }
                a.a(paramViewGroup).setChecked(true);
            }
            for (; ; ) {
                ImagePickerSystemFragment.j(ImagePickerSystemFragment.this).a(a.a(paramViewGroup), localAlbum, 0, ImagePickerSystemFragment.i(ImagePickerSystemFragment.this), ImagePickerSystemFragment.i(ImagePickerSystemFragment.this), new b.a() {
                    public void a(View paramAnonymousView, Album paramAnonymousAlbum) {
                        ImagePickerSystemFragment.b.a.b(paramViewGroup).setVisibility(0);
                    }

                    public void b(View paramAnonymousView, Album paramAnonymousAlbum) {
                        ImagePickerSystemFragment.b.a.b(paramViewGroup).setVisibility(8);
                    }

                    public void c(View paramAnonymousView, Album paramAnonymousAlbum) {
                    }
                });
                return paramView;
                paramViewGroup = (a) paramView.getTag();
                break;
                label184:
                a.a(paramViewGroup).setChecked(false);
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
            extends BaseAdapter {
        public c() {
        }

        public int getCount() {
            return ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).size();
        }

        public Object getItem(int paramInt) {
            return ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).get(paramInt);
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            if (paramView == null) {
                paramViewGroup = new a();
                paramView = ((LayoutInflater) ImagePickerSystemFragment.this.c.getSystemService("layout_inflater")).inflate(2130903078, null);
                a.a(paramViewGroup, (TextView) paramView.findViewById(2131558506));
                a.a(paramViewGroup).setTypeface(App.c);
                a.a(paramViewGroup, (ImageView) paramView.findViewById(2131558505));
                paramView.setTag(paramViewGroup);
            }
            for (; ; ) {
                Album localAlbum = (Album) ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).get(paramInt);
                String str = ImagePickerSystemFragment.this.getString(2131296570, new Object[]{localAlbum.b(), Integer.valueOf(localAlbum.e())});
                a.a(paramViewGroup).setText(str);
                ImagePickerSystemFragment.j(ImagePickerSystemFragment.this).a(a.b(paramViewGroup), localAlbum, 0, ImagePickerSystemFragment.i(ImagePickerSystemFragment.this), ImagePickerSystemFragment.i(ImagePickerSystemFragment.this), null);
                return paramView;
                paramViewGroup = (a) paramView.getTag();
            }
        }

        class a {
            private ImageView b;
            private TextView c;

            a() {
            }
        }
    }

    class d
            extends FotorAsyncTask<Void, Void, List<Album>> {
        d() {
        }

        protected List<Album> a(Void... paramVarArgs) {
            paramVarArgs = ImagePickerSystemFragment.this.c;
            if (paramVarArgs == null) {
            }
            do {
                return null;
                paramVarArgs = paramVarArgs.getContentResolver();
                localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                String str = App.g();
                paramVarArgs = paramVarArgs.query((Uri) localObject, new String[]{" count(*) as count ", "bucket_id", "bucket_display_name", "_id", "_data", "orientation"}, "bucket_display_name <>? AND 1=1) group by bucket_id order by bucket_display_name --", new String[]{str}, null);
            } while (paramVarArgs == null);
            Object localObject = new ArrayList();
            ImagePickerSystemFragment.a(ImagePickerSystemFragment.this, paramVarArgs, (List) localObject);
            paramVarArgs.close();
            return (List<Album>) localObject;
        }

        protected void a(List<Album> paramList) {
            super.onPostExecute(paramList);
            ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).clear();
            if ((paramList != null) && (!paramList.isEmpty())) {
                ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).addAll(paramList);
            }
            ImagePickerSystemFragment.a(ImagePickerSystemFragment.this, new ImagePickerSystemFragment.c(ImagePickerSystemFragment.this));
            ImagePickerSystemFragment.g(ImagePickerSystemFragment.this).setAdapter(ImagePickerSystemFragment.f(ImagePickerSystemFragment.this));
            ImagePickerSystemFragment.f(ImagePickerSystemFragment.this).notifyDataSetChanged();
            if (ImagePickerSystemFragment.this.b != null) {
                ImagePickerSystemFragment.this.b.a(ImagePickerSystemFragment.this, paramList);
            }
            ImagePickerSystemFragment.a(ImagePickerSystemFragment.this, null);
            ImagePickerSystemFragment.d(ImagePickerSystemFragment.this);
        }

        protected void onCancelled() {
            if (ImagePickerSystemFragment.this.b != null) {
                ImagePickerSystemFragment.this.b.b(ImagePickerSystemFragment.this);
            }
            ImagePickerSystemFragment.a(ImagePickerSystemFragment.this, null);
            ImagePickerSystemFragment.d(ImagePickerSystemFragment.this);
        }

        protected void onPreExecute() {
            if (ImagePickerSystemFragment.this.b != null) {
                ImagePickerSystemFragment.this.b.a(ImagePickerSystemFragment.this);
            }
            ImagePickerSystemFragment.this.a();
        }
    }

    private class e
            extends FotorAsyncTask<String, Void, List<Album>> {
        private e() {
        }

        protected List<Album> a(String... paramVarArgs) {
            ArrayList localArrayList = null;
            paramVarArgs = paramVarArgs[0];
            Object localObject = ImagePickerSystemFragment.this.c;
            if (localObject == null) {
                paramVarArgs = localArrayList;
            }
            do {
                return paramVarArgs;
                localObject = ((Context) localObject).getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "bucket_id=?", new String[]{paramVarArgs}, "date_modified desc ");
                localArrayList = new ArrayList();
                paramVarArgs = localArrayList;
            } while (localObject == null);
            ImagePickerSystemFragment.a(ImagePickerSystemFragment.this, (Cursor) localObject, localArrayList);
            ((Cursor) localObject).close();
            return localArrayList;
        }

        protected void a(List<Album> paramList) {
            super.onPostExecute(paramList);
            if ((paramList != null) && (!paramList.isEmpty())) {
                ImagePickerSystemFragment.h(ImagePickerSystemFragment.this).a(paramList);
                ImagePickerSystemFragment.h(ImagePickerSystemFragment.this).notifyDataSetChanged();
                if (ImagePickerSystemFragment.a(ImagePickerSystemFragment.this).getDisplayedChild() == 0) {
                    paramList = AnimationUtils.loadAnimation(ImagePickerSystemFragment.this.c, 2130968606);
                    ImagePickerSystemFragment.a(ImagePickerSystemFragment.this).setInAnimation(paramList);
                    ImagePickerSystemFragment.a(ImagePickerSystemFragment.this).setOutAnimation(ImagePickerSystemFragment.this.c, 2130968605);
                    ImagePickerSystemFragment.a(ImagePickerSystemFragment.this).showNext();
                }
            }
            ImagePickerSystemFragment.a(ImagePickerSystemFragment.this, null);
            ImagePickerSystemFragment.d(ImagePickerSystemFragment.this);
        }

        protected void onCancelled() {
            ImagePickerSystemFragment.d(ImagePickerSystemFragment.this);
        }

        protected void onPreExecute() {
            ImagePickerSystemFragment.this.a();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/picture/album/ImagePickerSystemFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */