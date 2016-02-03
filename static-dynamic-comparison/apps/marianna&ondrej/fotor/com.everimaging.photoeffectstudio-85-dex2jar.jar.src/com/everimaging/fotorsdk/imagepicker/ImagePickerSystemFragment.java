package com.everimaging.fotorsdk.imagepicker;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
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
import com.everimaging.fotorsdk.collage.R.anim;
import com.everimaging.fotorsdk.collage.R.dimen;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.R.string;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;

import java.util.ArrayList;
import java.util.List;

public class ImagePickerSystemFragment
        extends ImagePickerBaseFragment
        implements AdapterView.OnItemClickListener {
    private static final String c = ImagePickerSystemFragment.class.getSimpleName();
    private static final FotorLoggerFactory.c d = FotorLoggerFactory.a(c, FotorLoggerFactory.LoggerType.CONSOLE);
    private int e = 0;
    private int f = 0;
    private ViewSwitcher g;
    private ListView h;
    private GridView i;
    private List<Picture> j = new ArrayList();
    private d k;
    private e l;
    private c m;
    private b n;
    private Handler o = new Handler();
    private Picture p = null;
    private a q = null;
    private c r;
    private ArrayList<Picture> s = new ArrayList();

    private void a(Cursor paramCursor, List<Picture> paramList) {
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
                    Picture localPicture = new Picture();
                    localPicture.a(str2);
                    localPicture.b(str3);
                    localPicture.c(i3);
                    localPicture.c(str1);
                    localPicture.a(i1);
                    localPicture.b(i2);
                    paramList.add(localPicture);
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
        this.g = ((ViewSwitcher) paramView.findViewById(R.id.fotor_image_picker_main_switcher));
        this.h = ((ListView) paramView.findViewById(16908298));
        this.h.setOnItemClickListener(this);
        this.i = ((GridView) paramView.findViewById(R.id.fotor_image_picker_main_grid));
        this.i.setOnItemClickListener(this);
    }

    private void d() {
    }

    private void e() {
        d.c(new Object[]{"loadAlbum"});
        if (this.k != null) {
            this.k.cancel(true);
        }
        this.k = new d();
        this.k.executeOnExecutor(FotorAsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void a() {
    }

    public void a(Picture paramPicture) {
        if (this.l != null) {
            this.l.cancel(true);
        }
        this.l = new e(null);
        this.l.executeOnExecutor(FotorAsyncTask.THREAD_POOL_EXECUTOR, new String[]{paramPicture.a()});
    }

    public boolean b() {
        if (this.g.getDisplayedChild() != 0) {
            this.g.setInAnimation(getActivity().getApplicationContext(), R.anim.fotor_image_picker_push_left_in);
            this.g.setOutAnimation(getActivity().getApplicationContext(), R.anim.fotor_image_picker_push_right_out);
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
        this.e = ((int) ((DeviceUtils.getScreenWidth() - getResources().getDimension(R.dimen.fotor_image_picker_album_grid_item_spacing) * 5.0F) / 4.0F));
        this.f = getResources().getDimensionPixelSize(R.dimen.fotor_image_picker_header_height);
        this.n = new b(this.f);
        this.i.setAdapter(this.n);
        e();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.r = new c(getActivity());
        d();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fotor_image_picker_main_fragment, paramViewGroup, false);
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
        if (paramAdapterView == this.h) {
            if (this.m != null) {
                paramInt -= this.m.a();
                if (paramInt >= 0) {
                    this.p = ((Picture) this.j.get(paramInt));
                    a(this.p);
                    if (this.a != null) {
                        this.a.a(this, this.p);
                    }
                }
            }
        }
        do {
            for (; ; ) {
                return;
                if ((paramAdapterView == this.i) && (this.n != null)) {
                    paramInt -= this.n.a();
                    if (paramInt < 0) {
                        break;
                    }
                }
                try {
                    int i1 = ImagePickerSystemFragment.b.a.b((ImagePickerSystemFragment.b.a) paramView.getTag()).getVisibility();
                    if (i1 == 0) {
                    }
                } catch (Exception paramAdapterView) {
                    for (; ; ) {
                        d.e(new Object[]{"onItemClick error:" + paramAdapterView.getMessage()});
                    }
                }
            }
            paramAdapterView = this.n.a(paramInt);
        } while (this.a == null);
        this.a.a(this, paramView, paramAdapterView);
    }

    class a
            extends ContentObserver {
        public void onChange(boolean paramBoolean) {
            super.onChange(paramBoolean);
            ImagePickerSystemFragment.c().c(new Object[]{"onChange:" + paramBoolean});
            if (paramBoolean) {
                if (ImagePickerSystemFragment.a(this.a).getDisplayedChild() == 0) {
                    ImagePickerSystemFragment.b(this.a);
                }
            } else {
                return;
            }
            this.a.a(ImagePickerSystemFragment.c(this.a));
        }
    }

    class b
            extends BaseAdapter {
        private final int b = 4;
        private int c;
        private List<Picture> d;

        public b(int paramInt) {
            this.c = paramInt;
        }

        public int a() {
            return 4;
        }

        public Picture a(int paramInt) {
            if (this.d == null) {
                return null;
            }
            return (Picture) this.d.get(paramInt);
        }

        public void a(List<Picture> paramList) {
            this.d = paramList;
        }

        public int getCount() {
            if (this.d == null) {
                return 0;
            }
            return this.d.size() + 4;
        }

        public Object getItem(int paramInt) {
            if (this.d == null) {
                return null;
            }
            return (Picture) this.d.get(paramInt - 4);
        }

        public long getItemId(int paramInt) {
            return paramInt - 4;
        }

        public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup) {
            paramInt -= 4;
            if (paramInt >= 0) {
                Picture localPicture;
                if ((paramView == null) || (paramView.getId() == -1)) {
                    paramViewGroup = new a();
                    paramView = ((LayoutInflater) ImagePickerSystemFragment.this.getActivity().getSystemService("layout_inflater")).inflate(R.layout.fotor_image_picker_main_grid_item, null);
                    a.a(paramViewGroup, (AlbumImageItem) paramView.findViewById(R.id.fotor_image_picker_grid_item_image));
                    a.a(paramViewGroup, (ProgressBar) paramView.findViewById(R.id.fotor_image_picker_grid_item_progress));
                    paramView.setLayoutParams(new AbsListView.LayoutParams(ImagePickerSystemFragment.j(ImagePickerSystemFragment.this), ImagePickerSystemFragment.j(ImagePickerSystemFragment.this)));
                    paramView.setTag(paramViewGroup);
                    localPicture = (Picture) this.d.get(paramInt);
                    if (!ImagePickerSystemFragment.l(ImagePickerSystemFragment.this).contains(localPicture)) {
                        break label208;
                    }
                    a.a(paramViewGroup).setChecked(true);
                }
                for (; ; ) {
                    ImagePickerSystemFragment.k(ImagePickerSystemFragment.this).a(a.a(paramViewGroup), localPicture, 0, ImagePickerSystemFragment.j(ImagePickerSystemFragment.this), ImagePickerSystemFragment.j(ImagePickerSystemFragment.this), new c.a() {
                        public void a(View paramAnonymousView, Picture paramAnonymousPicture) {
                            ImagePickerSystemFragment.b.a.b(paramViewGroup).setVisibility(0);
                        }

                        public void b(View paramAnonymousView, Picture paramAnonymousPicture) {
                            ImagePickerSystemFragment.b.a.b(paramViewGroup).setVisibility(8);
                        }

                        public void c(View paramAnonymousView, Picture paramAnonymousPicture) {
                        }
                    });
                    paramView.setId(0);
                    return paramView;
                    paramViewGroup = (a) paramView.getTag();
                    break;
                    label208:
                    a.a(paramViewGroup).setChecked(false);
                }
            }
            paramView = new View(ImagePickerSystemFragment.this.getActivity());
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.c));
            paramView.setVisibility(4);
            paramView.setId(-1);
            return paramView;
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
        private int b;
        private final int c = 1;

        public c(int paramInt) {
            this.b = paramInt;
        }

        public int a() {
            return 1;
        }

        public int getCount() {
            return ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).size() + 1;
        }

        public Object getItem(int paramInt) {
            return ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).get(paramInt - 1);
        }

        public long getItemId(int paramInt) {
            return paramInt - 1;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            paramInt -= 1;
            if (paramInt >= 0) {
                if ((paramView == null) || (paramView.getId() == -1)) {
                    paramViewGroup = new a();
                    paramView = ((LayoutInflater) ImagePickerSystemFragment.this.getActivity().getSystemService("layout_inflater")).inflate(R.layout.fotor_image_picker_main_list_item, null);
                    a.a(paramViewGroup, (TextView) paramView.findViewById(R.id.fotor_image_picker_list_item_name));
                    a.a(paramViewGroup, (ImageView) paramView.findViewById(R.id.fotor_image_picker_list_item_cover));
                    paramView.setTag(paramViewGroup);
                }
                for (; ; ) {
                    Picture localPicture = (Picture) ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).get(paramInt);
                    String str = ImagePickerSystemFragment.this.getString(R.string.fotor_image_picker_string_and_count, new Object[]{localPicture.b(), Integer.valueOf(localPicture.e())});
                    a.a(paramViewGroup).setText(str);
                    ImagePickerSystemFragment.k(ImagePickerSystemFragment.this).a(a.b(paramViewGroup), localPicture, 0, ImagePickerSystemFragment.j(ImagePickerSystemFragment.this), ImagePickerSystemFragment.j(ImagePickerSystemFragment.this), null);
                    return paramView;
                    paramViewGroup = (a) paramView.getTag();
                }
            }
            paramView = new View(ImagePickerSystemFragment.this.getActivity());
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.b));
            paramView.setId(-1);
            paramView.setVisibility(4);
            return paramView;
        }

        class a {
            private ImageView b;
            private TextView c;

            a() {
            }
        }
    }

    class d
            extends FotorAsyncTask<Void, Void, List<Picture>> {
        d() {
        }

        protected List<Picture> a(Void... paramVarArgs) {
            paramVarArgs = ImagePickerSystemFragment.this.getActivity();
            if (paramVarArgs == null) {
            }
            do {
                return null;
                paramVarArgs = paramVarArgs.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{" count(*) as count ", "bucket_id", "bucket_display_name", "_id", "_data", "orientation"}, " 1=1 ) group by bucket_id order by bucket_display_name --", null, null);
            } while (paramVarArgs == null);
            ArrayList localArrayList = new ArrayList();
            ImagePickerSystemFragment.a(ImagePickerSystemFragment.this, paramVarArgs, localArrayList);
            paramVarArgs.close();
            return localArrayList;
        }

        protected void a(List<Picture> paramList) {
            super.onPostExecute(paramList);
            ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).clear();
            if ((paramList != null) && (!paramList.isEmpty())) {
                ImagePickerSystemFragment.e(ImagePickerSystemFragment.this).addAll(paramList);
            }
            ImagePickerSystemFragment.a(ImagePickerSystemFragment.this, new ImagePickerSystemFragment.c(ImagePickerSystemFragment.this, ImagePickerSystemFragment.f(ImagePickerSystemFragment.this)));
            ImagePickerSystemFragment.h(ImagePickerSystemFragment.this).setAdapter(ImagePickerSystemFragment.g(ImagePickerSystemFragment.this));
            ImagePickerSystemFragment.g(ImagePickerSystemFragment.this).notifyDataSetChanged();
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
            extends FotorAsyncTask<String, Void, List<Picture>> {
        private e() {
        }

        protected List<Picture> a(String... paramVarArgs) {
            ArrayList localArrayList = null;
            paramVarArgs = paramVarArgs[0];
            Object localObject = ImagePickerSystemFragment.this.getActivity();
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

        protected void a(List<Picture> paramList) {
            super.onPostExecute(paramList);
            if ((paramList != null) && (!paramList.isEmpty())) {
                ImagePickerSystemFragment.i(ImagePickerSystemFragment.this).a(paramList);
                ImagePickerSystemFragment.i(ImagePickerSystemFragment.this).notifyDataSetChanged();
                if (ImagePickerSystemFragment.a(ImagePickerSystemFragment.this).getDisplayedChild() == 0) {
                    paramList = AnimationUtils.loadAnimation(ImagePickerSystemFragment.this.getActivity().getApplicationContext(), R.anim.fotor_image_picker_push_right_in);
                    ImagePickerSystemFragment.a(ImagePickerSystemFragment.this).setInAnimation(paramList);
                    ImagePickerSystemFragment.a(ImagePickerSystemFragment.this).setOutAnimation(ImagePickerSystemFragment.this.getActivity().getApplicationContext(), R.anim.fotor_image_picker_push_left_out);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/imagepicker/ImagePickerSystemFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */