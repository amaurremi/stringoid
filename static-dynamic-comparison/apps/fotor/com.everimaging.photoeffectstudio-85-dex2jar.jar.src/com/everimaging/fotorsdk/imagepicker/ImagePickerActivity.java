package com.everimaging.fotorsdk.imagepicker;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import com.everimaging.fotorsdk.collage.R.dimen;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.R.string;
import com.everimaging.fotorsdk.collage.entity.ImageInfo;
import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.collage.g;
import com.everimaging.fotorsdk.collage.params.TemplateParam;
import com.everimaging.fotorsdk.collage.utils.TemplateThumbnailCreator;
import com.everimaging.fotorsdk.collage.utils.TemplateThumbnailCreator.ThumbnailState;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.plugins.h.b;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.widget.FotorButton;
import com.everimaging.fotorsdk.widget.FotorFlipperBarContainer;
import com.everimaging.fotorsdk.widget.FotorTextView;
import com.everimaging.fotorsdk.widget.FotorTitleBackButton;
import com.everimaging.fotorsdk.widget.lib.hlist.AdapterView;
import com.everimaging.fotorsdk.widget.lib.hlist.AdapterView.c;
import com.everimaging.fotorsdk.widget.lib.hlist.HListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImagePickerActivity
        extends com.everimaging.fotorsdk.b
        implements View.OnClickListener, ImagePickerBaseFragment.a, ImagePickerBaseFragment.b {
    private static final String a = ImagePickerActivity.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private ImagePickerSystemFragment c;
    private FotorFlipperBarContainer d;
    private FotorTitleBackButton e;
    private FotorTitleBackButton f;
    private FotorButton g;
    private FotorTextView h;
    private HListView i;
    private a j;
    private int k;
    private int l;
    private AdapterView.c m = new AdapterView.c() {
        public void a(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
            ImagePickerActivity.a(ImagePickerActivity.this, paramAnonymousInt);
            ImagePickerActivity.b(ImagePickerActivity.this, paramAnonymousInt);
        }
    };

    private void a() {
        int n = 0;
        Template localTemplate = com.everimaging.fotorsdk.collage.a.a.getTemplate();
        h.b localb = h.a(getApplicationContext(), com.everimaging.fotorsdk.collage.a.a.getFeaturePack());
        Object localObject = getIntent();
        if (localObject != null) {
            this.k = ((Intent) localObject).getIntExtra("extra_in_selection", 0);
        }
        if (localTemplate == null) {
            return;
        }
        localObject = new ArrayList();
        while (n < localTemplate.getNumberOfHole()) {
            b localb1 = new b();
            localb1.a(TemplateThumbnailCreator.a(getApplicationContext(), localTemplate, localb, TemplateThumbnailCreator.ThumbnailState.HOLE_NORMAL, n, 120), TemplateThumbnailCreator.a(getApplicationContext(), localTemplate, localb, TemplateThumbnailCreator.ThumbnailState.HOLE_SELECTED, n, 120));
            ImageInfo localImageInfo = g.a().b(n);
            if ((localImageInfo != null) && (localImageInfo.getPicture() != null)) {
                localb1.a(localImageInfo.getPicture());
            }
            ((List) localObject).add(localb1);
            n += 1;
        }
        this.j = new a((List) localObject);
        this.i.setOnItemClickListener(this.m);
        this.i.setAdapter(this.j);
        this.i.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ImagePickerActivity.a(ImagePickerActivity.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ImagePickerActivity.a(ImagePickerActivity.this, true, ImagePickerActivity.b(ImagePickerActivity.this));
                ImagePickerActivity.c(ImagePickerActivity.this);
            }
        });
    }

    private void a(int paramInt) {
        a(false, paramInt);
    }

    private void a(View paramView, Picture paramPicture) {
        paramView = this.j.a();
        ((b) paramView.get(this.k)).a(paramPicture);
        a(paramView, this.k);
        a(this.k);
        b();
    }

    private void a(List<b> paramList, int paramInt) {
        int n = paramInt + 1;
        if (n < paramList.size()) {
            if (((b) paramList.get(n)).a() != null) {
            }
        }
        for (; ; ) {
            int i1;
            if (n == -1) {
                i1 = 0;
                label38:
                if (i1 < paramInt) {
                    if (((b) paramList.get(i1)).a() != null) {
                    }
                }
            }
            for (; ; ) {
                if (i1 != -1) {
                    this.k = i1;
                }
                return;
                n += 1;
                break;
                i1 += 1;
                break label38;
                i1 = n;
            }
            n = -1;
        }
    }

    private void a(boolean paramBoolean, int paramInt) {
        int n = 1;
        b.c(new Object[]{"selectSlotItem first:" + paramBoolean, "position:" + paramInt});
        this.j.a(paramInt);
        int i1 = this.i.getFirstVisiblePosition();
        int i2 = this.i.getLastVisiblePosition();
        if (Math.abs(paramInt - i1) > Math.abs(paramInt - i2)) {
            if (n == 0) {
                break label144;
            }
            if (paramInt >= this.j.getCount() - 1) {
                break label164;
            }
            n = paramInt + 1;
        }
        for (; ; ) {
            if (paramBoolean) {
                this.i.e(paramInt, this.l);
                return;
                n = 0;
                break;
                label144:
                if (paramInt <= 0) {
                    break label164;
                }
                n = paramInt - 1;
                continue;
            }
            this.i.c(n);
            return;
            label164:
            n = paramInt;
        }
    }

    private void b() {
        List localList = this.j.a();
        Iterator localIterator = localList.iterator();
        int n = 0;
        if (localIterator.hasNext()) {
            if (((b) localIterator.next()).a() == null) {
                break label100;
            }
            n += 1;
        }
        label100:
        for (; ; ) {
            break;
            int i1 = R.string.fotor_image_picker_selected_desc;
            if (n == 1) {
                i1 = R.string.fotor_image_picker_selected_desc_single;
            }
            this.h.setText(getString(i1, new Object[]{Integer.valueOf(n), Integer.valueOf(localList.size())}));
            return;
        }
    }

    private void c() {
        List localList = this.j.a();
        int n = 0;
        if (n < localList.size()) {
            Object localObject = (b) localList.get(n);
            if (((b) localObject).a() == null) {
                g.a().a(n);
            }
            for (; ; ) {
                n += 1;
                break;
                g localg = g.a();
                localObject = ((b) localObject).a();
                ImageInfo localImageInfo = localg.b(n);
                if ((localImageInfo == null) || (!localImageInfo.getPicture().equals(localObject))) {
                    localImageInfo = new ImageInfo();
                    localImageInfo.setPicture((Picture) localObject);
                    localg.a(localImageInfo, n);
                } else {
                    b.c(new Object[]{"slot index:" + n, "is not change"});
                }
            }
        }
        setResult(-1);
        finish();
    }

    public void a(ImagePickerBaseFragment paramImagePickerBaseFragment) {
    }

    public void a(ImagePickerBaseFragment paramImagePickerBaseFragment, View paramView, Picture paramPicture) {
        paramImagePickerBaseFragment = paramPicture.g();
        if (paramImagePickerBaseFragment == null) {
            Toast.makeText(this, getText(R.string.fotor_image_picker_breaking_file), 0).show();
            return;
        }
        paramImagePickerBaseFragment = BitmapDecodeUtils.decodeImageBounds(this, paramImagePickerBaseFragment);
        if ((paramImagePickerBaseFragment == null) || (Math.min(paramImagePickerBaseFragment[0], paramImagePickerBaseFragment[1]) <= 0)) {
            Toast.makeText(this, getText(R.string.fotor_image_picker_breaking_file), 0).show();
            return;
        }
        if (Math.max(paramImagePickerBaseFragment[0], paramImagePickerBaseFragment[1]) > 8000) {
            Toast.makeText(this, getString(R.string.fotor_image_picker_limit_max, new Object[]{Integer.valueOf(8000)}), 0).show();
            return;
        }
        a(paramView, paramPicture);
    }

    public void a(ImagePickerBaseFragment paramImagePickerBaseFragment, Picture paramPicture) {
        this.f.setText(paramPicture.b());
        this.d.a();
    }

    public void a(ImagePickerBaseFragment paramImagePickerBaseFragment, List<Picture> paramList) {
    }

    public void b(ImagePickerBaseFragment paramImagePickerBaseFragment) {
    }

    public void onBackPressed() {
        if (this.c.b()) {
            this.f.setText("");
            this.d.b();
            return;
        }
        super.onBackPressed();
    }

    public void onClick(View paramView) {
        if ((paramView == this.f) || (paramView == this.e)) {
            onBackPressed();
        }
        while (paramView != this.g) {
            return;
        }
        c();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.fotor_image_picker_main);
        this.d = ((FotorFlipperBarContainer) findViewById(R.id.fotor_image_picker_main_header_title_container));
        findViewById(R.id.fotor_image_picker_main_header_title).setOnClickListener(this);
        this.e = ((FotorTitleBackButton) findViewById(R.id.fotor_image_picker_main_header_title));
        this.e.setOnClickListener(this);
        this.f = ((FotorTitleBackButton) findViewById(R.id.fotor_image_picker_main_header_sub_title));
        this.f.setOnClickListener(this);
        this.g = ((FotorButton) findViewById(R.id.fotor_image_picker_main_bottom_apply));
        this.g.setOnClickListener(this);
        this.h = ((FotorTextView) findViewById(R.id.fotor_image_picker_main_bottom_desc));
        this.i = ((HListView) findViewById(R.id.fotor_image_picker_main_bottom_slots));
        this.i.setDividerWidth(getResources().getDimensionPixelSize(R.dimen.fotor_image_picker_bottom_list_divider_width));
        this.l = (getResources().getDimensionPixelSize(R.dimen.fotor_image_picker_bottom_list_item_width) + this.i.getDividerWidth() + getResources().getDimensionPixelSize(R.dimen.fotor_image_picker_bottom_list_item_offset_right));
        if (paramBundle == null) {
            this.c = new ImagePickerSystemFragment();
        }
        for (; ; ) {
            this.c.a(this);
            this.c.a(this);
            getSupportFragmentManager().beginTransaction().replace(R.id.fotor_image_picker_main_container, this.c, "").commit();
            a();
            return;
            this.c = ((ImagePickerSystemFragment) getSupportFragmentManager().findFragmentByTag("frag_system_album"));
            if (this.c == null) {
                this.c = new ImagePickerSystemFragment();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 16908332) {
            finish();
        }
        return true;
    }

    class a
            extends BaseAdapter
            implements View.OnClickListener {
        private List<b> b;
        private SparseBooleanArray c;

        public a() {
            List localList;
            this.b = localList;
            this.c = new SparseBooleanArray();
        }

        private boolean c(int paramInt) {
            return this.c.get(paramInt, false);
        }

        public List<b> a() {
            return this.b;
        }

        public void a(int paramInt) {
            this.c.clear();
            if (paramInt >= 0) {
                this.c.put(paramInt, true);
            }
            notifyDataSetChanged();
        }

        public b b(int paramInt) {
            return (b) this.b.get(paramInt);
        }

        public int getCount() {
            return this.b.size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            Object localObject = (b) this.b.get(paramInt);
            if (paramView == null) {
                paramView = ImagePickerActivity.this.getLayoutInflater().inflate(R.layout.fotor_image_picker_choice_hlist_item, null);
                paramViewGroup = new a();
                paramViewGroup.a = ((ImageView) paramView.findViewById(R.id.fotor_image_picker_main_bottom_hlist_item_image));
                paramViewGroup.b = ((ImageView) paramView.findViewById(R.id.fotor_image_picker_main_bottom_hlist_item_delete));
                paramViewGroup.b.setOnClickListener(this);
                paramViewGroup.c = paramView.findViewById(R.id.fotor_image_picker_main_bottom_hlist_item_mask);
                paramView.setTag(paramViewGroup);
            }
            for (; ; ) {
                bool = c(paramInt);
                if (((b) localObject).a() == null) {
                    break;
                }
                localObject = a.a(ImagePickerActivity.this.getApplicationContext(), ((b) localObject).a(), 0, 0);
                paramViewGroup.a.setImageBitmap((Bitmap) localObject);
                paramViewGroup.c.setVisibility(0);
                paramViewGroup.c.setSelected(bool);
                paramViewGroup.b.setVisibility(0);
                paramViewGroup.b.setTag(Integer.valueOf(paramInt));
                return paramView;
                paramViewGroup = (a) paramView.getTag();
            }
            ImageView localImageView = paramViewGroup.a;
            if (!bool) {
            }
            for (boolean bool = true; ; bool = false) {
                localImageView.setImageBitmap(((b) localObject).a(bool));
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.b.setVisibility(8);
                break;
            }
        }

        public void onClick(View paramView) {
            int i = ((Integer) paramView.getTag()).intValue();
            b(i).a(null);
            ImagePickerActivity.a(ImagePickerActivity.this, i);
            ImagePickerActivity.b(ImagePickerActivity.this, i);
            ImagePickerActivity.c(ImagePickerActivity.this);
        }

        class a {
            ImageView a;
            ImageView b;
            View c;

            a() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/imagepicker/ImagePickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */