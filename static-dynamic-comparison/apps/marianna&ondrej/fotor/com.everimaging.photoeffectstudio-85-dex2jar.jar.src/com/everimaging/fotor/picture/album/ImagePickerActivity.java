package com.everimaging.fotor.picture.album;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.MenuItem;
import android.widget.Toast;
import com.everimaging.fotor.b;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotor.picture.entity.Album;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.widget.lib.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

public class ImagePickerActivity
        extends b
        implements ActionBar.TabListener, ImagePickerBaseFragment.a, ImagePickerBaseFragment.b {
    private static final String a = ImagePickerActivity.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private ImagePickerSystemFragment c;
    private ImagePickerFotorFragment d;
    private ViewPager e;
    private TabPageIndicator f;
    private a g;
    private int h;

    private Fragment a(Bundle paramBundle, int paramInt) {
        if (paramBundle == null) {
            return this.g.getItem(paramInt);
        }
        return getSupportFragmentManager().findFragmentByTag(a(paramInt));
    }

    private String a(int paramInt) {
        return "android:switcher:2131558497:" + paramInt;
    }

    public void a(ImagePickerBaseFragment paramImagePickerBaseFragment) {
    }

    public void a(ImagePickerBaseFragment paramImagePickerBaseFragment, Album paramAlbum) {
        paramImagePickerBaseFragment = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(paramAlbum.f()));
        if (paramImagePickerBaseFragment == null) {
            Toast.makeText(this, getText(2131296645), 0).show();
            return;
        }
        paramAlbum = BitmapDecodeUtils.decodeImageBounds(this, paramImagePickerBaseFragment);
        if ((paramAlbum == null) || (Math.min(paramAlbum[0], paramAlbum[1]) <= 0)) {
            Toast.makeText(this, getText(2131296645), 0).show();
            return;
        }
        if (Math.max(paramAlbum[0], paramAlbum[1]) > 8000) {
            Toast.makeText(this, getString(2131296646, new Object[]{Integer.valueOf(8000)}), 0).show();
            return;
        }
        paramAlbum = new Intent();
        paramAlbum.setData(paramImagePickerBaseFragment);
        setResult(-1, paramAlbum);
        finish();
    }

    public void a(ImagePickerBaseFragment paramImagePickerBaseFragment, List<Album> paramList) {
        if ((paramImagePickerBaseFragment == this.d) && ((paramList == null) || (paramList.size() <= 0)) && (this.e.getCurrentItem() != 1)) {
            this.e.setCurrentItem(1, true);
        }
    }

    public void b(ImagePickerBaseFragment paramImagePickerBaseFragment) {
    }

    public void onBackPressed() {
        if ((this.e.getCurrentItem() == 1) && (this.c != null) && (this.c.b())) {
            return;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903074);
        final ActionBar localActionBar = getSupportActionBar();
        localActionBar.setNavigationMode(0);
        localActionBar.setDisplayHomeAsUpEnabled(true);
        this.f = ((TabPageIndicator) findViewById(2131558500));
        this.e = ((ViewPager) findViewById(2131558497));
        ArrayList localArrayList = new ArrayList();
        b.c(new Object[]{"savedInstanceState:" + paramBundle});
        if (paramBundle == null) {
            this.d = new ImagePickerFotorFragment();
            localArrayList.add(this.d);
            this.c = new ImagePickerSystemFragment();
            localArrayList.add(this.c);
            this.d.a(this);
            this.d.a(this);
            this.c.a(this);
            this.c.a(this);
            this.g = new a(getSupportFragmentManager(), localArrayList);
            this.e.setAdapter(this.g);
            this.e.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                public void onPageSelected(int paramAnonymousInt) {
                    localActionBar.setSelectedNavigationItem(paramAnonymousInt);
                }
            });
            this.f.setViewPager(this.e);
            if ((getIntent() != null) && (getIntent().getExtras() != null)) {
                if (!getIntent().getExtras().getBoolean("extra_is_choose_fotor_album", true)) {
                    break label375;
                }
            }
        }
        label375:
        for (int i = 0; ; i = 1) {
            this.h = i;
            this.e.setCurrentItem(this.h);
            return;
            this.d = ((ImagePickerFotorFragment) a(paramBundle, 0));
            if (this.d == null) {
                this.d = new ImagePickerFotorFragment();
            }
            localArrayList.add(this.d);
            this.c = ((ImagePickerSystemFragment) a(paramBundle, 1));
            if (this.c == null) {
                this.c = new ImagePickerSystemFragment();
            }
            localArrayList.add(this.c);
            break;
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 16908332) {
            finish();
        }
        return true;
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
    }

    public void onTabReselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {
    }

    public void onTabSelected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {
        this.e.setCurrentItem(paramTab.getPosition());
    }

    public void onTabUnselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {
    }

    public class a
            extends FragmentPagerAdapter {
        private List<Fragment> b;

        public a(List<Fragment> paramList) {
            super();
            List localList;
            this.b = localList;
        }

        public int getCount() {
            return this.b.size();
        }

        public Fragment getItem(int paramInt) {
            return (Fragment) this.b.get(paramInt);
        }

        public CharSequence getPageTitle(int paramInt) {
            switch (paramInt) {
                default:
                    return null;
                case 0:
                    return ImagePickerActivity.this.getString(2131296630);
            }
            return ImagePickerActivity.this.getString(2131296629);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/picture/album/ImagePickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */