package com.quoord.tools;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.webkit.WebView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ImageItem;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.gallery.PhotoView;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class QuoordGalleryActivity
        extends Activity {
    private static final int Menu_itemid_save = 1;
    private static final int Menu_itemid_share = 0;
    private static Context context;
    private ActionBar acBar;
    private SamplePagerAdapter adapter;
    private QuoordViewPager mViewPager;
    public ArrayList<String> pData = new ArrayList();
    private int position;
    private ForumStatus thisForumStatus;
    private String titleName;

    public static String getImageType(String paramString) {
        Object localObject2 = new File(paramString);
        Object localObject1 = null;
        paramString = (String) localObject1;
        try {
            FileInputStream localFileInputStream = new FileInputStream((File) localObject2);
            paramString = (String) localObject1;
            localObject2 = ImageItem.getImageType(localFileInputStream);
            localObject1 = localObject2;
            if (localFileInputStream != null) {
                localObject1 = localObject2;
                paramString = (String) localObject2;
                if (localFileInputStream.available() > 5000000) {
                    paramString = (String) localObject2;
                    localObject1 = ImageItem.JPEG;
                }
            }
            paramString = (String) localObject1;
            localFileInputStream.close();
            paramString = (String) localObject1;
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
        }
        localObject1 = paramString;
        if (paramString == null) {
            localObject1 = ImageItem.JPEG;
        }
        return (String) localObject1;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getActionBar();
        paramBundle.setDisplayOptions(29);
        paramBundle.setDisplayShowHomeEnabled(true);
        paramBundle.setIcon(2130837525);
        paramBundle = getIntent();
        this.pData = ((ArrayList) paramBundle.getSerializableExtra("data"));
        this.thisForumStatus = ((ForumStatus) paramBundle.getSerializableExtra("forumstatus"));
        this.position = paramBundle.getIntExtra("position", 0);
        this.titleName = paramBundle.getStringExtra("auther_name");
        this.mViewPager = new QuoordViewPager(this);
        context = this;
        setContentView(this.mViewPager);
        this.adapter = new SamplePagerAdapter();
        this.mViewPager.setAdapter(this.adapter);
        this.mViewPager.setCurrentItem(this.position);
        this.acBar = getActionBar();
        if ((this.titleName != null) && (!this.titleName.equals(""))) {
            this.acBar.setTitle(this.titleName + " " + (this.position + 1) + "/" + this.pData.size());
        }
        for (; ; ) {
            GoogleAnalyticsTools.trackPageView(this, "gallery", this.thisForumStatus.getForumId(), this.thisForumStatus.getUrl());
            this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int paramAnonymousInt) {
                }

                public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {
                }

                public void onPageSelected(int paramAnonymousInt) {
                    if ((QuoordGalleryActivity.this.titleName != null) && (!QuoordGalleryActivity.this.titleName.equals(""))) {
                        QuoordGalleryActivity.this.acBar.setTitle(QuoordGalleryActivity.this.titleName + " " + (paramAnonymousInt + 1) + "/" + QuoordGalleryActivity.this.pData.size());
                        return;
                    }
                    QuoordGalleryActivity.this.acBar.setTitle(paramAnonymousInt + 1 + "/" + QuoordGalleryActivity.this.pData.size());
                }
            });
            return;
            this.acBar.setTitle(this.position + 1 + "/" + this.pData.size());
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        MenuItem localMenuItem = paramMenu.add(0, 0, 0, getResources().getString(2131100448));
        localMenuItem.setShowAsAction(2);
        localMenuItem.setIcon(2130837639);
        localMenuItem = paramMenu.add(0, 1, 0, getResources().getString(2131099793));
        localMenuItem.setShowAsAction(2);
        localMenuItem.setIcon(2130838888);
        return super.onCreateOptionsMenu(paramMenu);
    }

    protected void onDestroy() {
        try {
            Iterator localIterator;
            if (this.adapter != null) {
                localIterator = this.adapter.visibleView.entrySet().iterator();
                if (localIterator.hasNext()) {
                }
            } else {
                this.adapter.visibleView.clear();
                this.mViewPager.destroyDrawingCache();
                super.onDestroy();
                return;
            }
            localObject = (Map.Entry) localIterator.next();
            if ((((Map.Entry) localObject).getValue() instanceof LinearLayout)) {
                ((WebView) ((LinearLayout) ((Map.Entry) localObject).getValue()).getChildAt(0)).removeAllViews();
                ((WebView) ((LinearLayout) ((Map.Entry) localObject).getValue()).getChildAt(0)).destroy();
            }
        } catch (Exception localException1) {
            try {
                for (; ; ) {
                    Object localObject;
                    File localFile = new File((String) this.pData.get(this.position) + ".gif");
                    if (localFile.exists()) {
                        localFile.delete();
                    }
                    if ((((Map.Entry) localObject).getValue() instanceof PhotoView)) {
                        localObject = (BitmapDrawable) ((PhotoView) ((Map.Entry) localObject).getValue()).getDrawable();
                        if (localObject != null) {
                            if (((BitmapDrawable) localObject).getBitmap() != null) {
                                ((BitmapDrawable) localObject).getBitmap().recycle();
                            }
                            System.gc();
                        }
                    }
                }
                localException1 = localException1;
            } catch (Exception localException2) {
                for (; ; ) {
                }
            }
        }
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onMenuItemSelected(paramInt, paramMenuItem);
            shareImage();
            continue;
            saveCurrentImage();
            continue;
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        CustomTracker.comScorePause(this);
    }

    protected void onResume() {
        super.onResume();
        CustomTracker.comScoreResume(this);
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void saveCurrentImage() {
        Object localObject1 = new File(SettingsFragment.getDownloadLocation(this));
        if (!((File) localObject1).exists()) {
            ((File) localObject1).mkdir();
        }
        Object localObject2 = Util.getRemotePicData((String) this.pData.get(this.mViewPager.getCurrentItem()));
        localObject1 = ImageItem.getImageExt((InputStream) localObject2);
        try {
            ((InputStream) localObject2).close();
            localObject1 = "tapatalk_" + System.currentTimeMillis() + (String) localObject1;
            localObject2 = SettingsFragment.getDownloadLocation(this) + File.separator + (String) localObject1;
            Util.cachePicFullPath((String) localObject2, (String) this.pData.get(this.mViewPager.getCurrentItem()));
            i = 0;
        } catch (Exception localException3) {
            try {
                int j = new FileInputStream((String) localObject2).available();
                int i = j;
            } catch (Exception localException3) {
                try {
                    for (; ; ) {
                        localObject2 = new File((String) localObject2);
                        if (((File) localObject2).exists()) {
                            new MediaScannerNotifier(this, ((File) localObject2).getAbsolutePath(), "image/jpeg");
                        }
                        Toast.makeText(this, getString(2131099772) + " /sdcard/" + SettingsFragment.getDownloadLocation(this) + File.separator + (String) localObject1, 1).show();
                        return;
                        localException1 = localException1;
                        localException1.printStackTrace();
                        continue;
                        localException3 = localException3;
                        localException3.printStackTrace();
                    }
                } catch (Exception localException2) {
                    for (; ; ) {
                    }
                }
            }
        }
    }

    public void shareImage() {
        File localFile = new File((String) this.pData.get(this.mViewPager.getCurrentItem()));
        Intent localIntent;
        Object localObject1;
        if (localFile.exists()) {
            localIntent = new Intent("android.intent.action.SEND");
            localObject1 = null;
        }
        try {
            localObject2 = MediaStore.Images.Media.insertImage(getContentResolver(), (String) this.pData.get(this.mViewPager.getCurrentItem()), "title", null);
            localObject1 = localObject2;
        } catch (FileNotFoundException localFileNotFoundException) {
            for (; ; ) {
                Object localObject2;
                localFileNotFoundException.printStackTrace();
            }
        }
        MimeTypeMap.getSingleton();
        localFile.getName().substring(localFile.getName().lastIndexOf(".") + 1);
        localIntent.setType(getImageType((String) localObject1));
        localIntent.putExtra("android.intent.extra.STREAM", Uri.parse((String) localObject1));
        if ((!getResources().getBoolean(2131558401)) && (this.thisForumStatus != null)) {
        }
        try {
            localObject2 = TapatalkJsonEngine.COMMON + "?" + "device_id=" + Util.getMD5(Util.getMacAddress(this)) + "&device_type=" + Util.getDeviceName() + "&forum_id=" + this.thisForumStatus.getForumId() + "&action=share-android";
            localObject1 = localObject2;
            if (this.thisForumStatus.tapatalkForum.getUserName() != null) {
                localObject1 = localObject2 + "&username=" + URLEncoder.encode(this.thisForumStatus.tapatalkForum.getUserName(), "utf-8");
            }
            localObject2 = localObject1;
            if (this.thisForumStatus.tapatalkForum.getUserId() != null) {
                localObject2 = localObject1 + "&uid=" + this.thisForumStatus.tapatalkForum.getUserId();
            }
            TapatalkJsonEngine.callLogin(this, (String) localObject2);
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
        }
        startActivity(Intent.createChooser(localIntent, "Share Image"));
    }

    private static class MediaScannerNotifier
            implements MediaScannerConnection.MediaScannerConnectionClient {
        private MediaScannerConnection mConnection;
        private String mMimeType;
        private String mPath;

        public MediaScannerNotifier(Context paramContext, String paramString1, String paramString2) {
            this.mPath = paramString1;
            this.mMimeType = paramString2;
            this.mConnection = new MediaScannerConnection(paramContext, this);
            this.mConnection.connect();
        }

        public void onMediaScannerConnected() {
            this.mConnection.scanFile(this.mPath, this.mMimeType);
        }

        public void onScanCompleted(String paramString, Uri paramUri) {
            this.mConnection.disconnect();
        }
    }

    class SamplePagerAdapter
            extends PagerAdapter {
        public HashMap<Integer, View> visibleView = new HashMap();

        SamplePagerAdapter() {
        }

        public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
            this.visibleView.remove(Integer.valueOf(paramInt));
            if ((paramObject instanceof LinearLayout)) {
                ((WebView) ((LinearLayout) paramObject).getChildAt(0)).removeAllViews();
                ((WebView) ((LinearLayout) paramObject).getChildAt(0)).destroy();
            }
            if ((paramObject instanceof PhotoView)) {
                BitmapDrawable localBitmapDrawable = (BitmapDrawable) ((PhotoView) paramObject).getDrawable();
                if (localBitmapDrawable != null) {
                    if (localBitmapDrawable.getBitmap() != null) {
                        localBitmapDrawable.getBitmap().recycle();
                    }
                    System.gc();
                }
            }
            paramViewGroup.removeView((View) paramObject);
        }

        public int getCount() {
            return QuoordGalleryActivity.this.pData.size();
        }

        public View instantiateItem(ViewGroup paramViewGroup, int paramInt) {
            if (QuoordGalleryActivity.getImageType((String) QuoordGalleryActivity.this.pData.get(paramInt)).equals(ImageItem.GIF)) {
                paramViewGroup = setWebView(paramViewGroup, paramInt);
                this.visibleView.put(Integer.valueOf(paramInt), paramViewGroup);
                return paramViewGroup;
            }
            paramViewGroup = setPhotoView(paramViewGroup, paramInt);
            this.visibleView.put(Integer.valueOf(paramInt), paramViewGroup);
            return paramViewGroup;
        }

        public boolean isViewFromObject(View paramView, Object paramObject) {
            return paramView == paramObject;
        }

        public PhotoView setPhotoView(ViewGroup paramViewGroup, int paramInt) {
            PhotoView localPhotoView = new PhotoView(paramViewGroup.getContext());
            Object localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options) localObject).inJustDecodeBounds = true;
            BitmapFactory.decodeFile((String) QuoordGalleryActivity.this.pData.get(paramInt), (BitmapFactory.Options) localObject);
            double d2 = ((BitmapFactory.Options) localObject).outWidth;
            double d1 = ((BitmapFactory.Options) localObject).outHeight;
            localObject = ((WindowManager) QuoordGalleryActivity.this.getSystemService("window")).getDefaultDisplay();
            double d3;
            if (((Display) localObject).getWidth() <= ((Display) localObject).getHeight()) {
                i = ((Display) localObject).getWidth();
                d3 = i;
                if (((Display) localObject).getWidth() <= ((Display) localObject).getHeight()) {
                    break label237;
                }
            }
            label237:
            for (int i = ((Display) localObject).getHeight(); ; i = ((Display) localObject).getWidth()) {
                double d4 = i;
                if (d3 <= 2.0D * d2) {
                    break label247;
                }
                d2 *= 2.0D;
                d1 *= 2.0D;
                localObject = ImageTools.decodeFile((String) QuoordGalleryActivity.this.pData.get(paramInt), (int) d2, (int) d1, ScalingLogic.FIT);
                if (localObject != null) {
                    localPhotoView.setImageBitmap(ImageTools.createScaledBitmap((Bitmap) localObject, (int) d2, (int) d1, ScalingLogic.FIT));
                    localPhotoView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                }
                paramViewGroup.addView(localPhotoView, -1, -1);
                return localPhotoView;
                i = ((Display) localObject).getHeight();
                break;
            }
            label247:
            localPhotoView.setImageBitmap(Util.getRemotePicFullScreen((String) QuoordGalleryActivity.this.pData.get(paramInt)));
            paramViewGroup.addView(localPhotoView, -1, -1);
            return localPhotoView;
        }

        public LinearLayout setWebView(ViewGroup paramViewGroup, int paramInt) {
            Object localObject = (String) QuoordGalleryActivity.this.pData.get(paramInt);
            if (!new File(localObject + ".gif").exists()) {
            }
            try {
                Util.copyFile(new File((String) localObject), new File(localObject + ".gif"));
                LinearLayout localLinearLayout = new LinearLayout(QuoordGalleryActivity.context);
                localLinearLayout.setGravity(17);
                WebView localWebView = new WebView(QuoordGalleryActivity.context);
                localWebView.loadUrl("file:///" + (String) localObject + ".gif");
                localObject = new BitmapFactory.Options();
                ((BitmapFactory.Options) localObject).inJustDecodeBounds = true;
                BitmapFactory.decodeFile((String) QuoordGalleryActivity.this.pData.get(paramInt), (BitmapFactory.Options) localObject);
                double d = ((BitmapFactory.Options) localObject).outWidth;
                localObject = new DisplayMetrics();
                ((Activity) QuoordGalleryActivity.context).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
                paramInt = ((DisplayMetrics) localObject).densityDpi;
                localObject = new LinearLayout.LayoutParams((int) (d * ((DisplayMetrics) localObject).density), -2);
                ((LinearLayout.LayoutParams) localObject).gravity = 17;
                localWebView.setLayoutParams((ViewGroup.LayoutParams) localObject);
                localLinearLayout.addView(localWebView);
                paramViewGroup.addView(localLinearLayout, -1, -1);
                return localLinearLayout;
            } catch (IOException localIOException) {
                for (; ; ) {
                    localIOException.printStackTrace();
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/QuoordGalleryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */