package com.quoord.tapatalkpro.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.forum.ViewPagerAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.NonSwipeableViewPager;
import com.quoord.tapatalkpro.util.ImageItem;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

public class GalleryActivity
        extends Activity
        implements AdapterView.OnItemClickListener {
    private static final int Menu_itemid_save = 1;
    private static final int Menu_itemid_share = 0;
    public ArrayList<String> pData;
    NonSwipeableViewPager pager;
    private int position;
    ViewPagerAdapter thisAdapter;
    private ForumStatus thisForumStatus;

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        int i = this.pager.getCurrentItem();
        this.thisAdapter = new ViewPagerAdapter(this, this.thisForumStatus, this.pData, this.pager, this.position);
        this.pager.setAdapter(this.thisAdapter);
        this.pager.setOffscreenPageLimit(this.pData.size());
        this.pager.setCurrentItem(i);
        super.onConfigurationChanged(paramConfiguration);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getActionBar();
        paramBundle.setIcon(2130837525);
        paramBundle.setDisplayOptions(29);
        paramBundle.setDisplayShowHomeEnabled(true);
        paramBundle = getIntent();
        this.pData = ((ArrayList) paramBundle.getSerializableExtra("data"));
        this.position = paramBundle.getIntExtra("position", 0);
        this.thisForumStatus = ((ForumStatus) paramBundle.getSerializableExtra("forumstatus"));
        setContentView(2130903176);
        this.pager = ((NonSwipeableViewPager) super.findViewById(16842752));
        this.thisAdapter = new ViewPagerAdapter(this, this.thisForumStatus, this.pData, this.pager, this.position);
        this.pager.setAdapter(this.thisAdapter);
        this.pager.setOffscreenPageLimit(this.pData.size());
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

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
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

    public void saveCurrentImage() {
        Object localObject1 = new File(SettingsFragment.getDownloadLocation(this));
        if (!((File) localObject1).exists()) {
            ((File) localObject1).mkdir();
        }
        Object localObject2 = Util.getRemotePicData((String) this.pData.get(this.pager.getCurrentItem()));
        localObject1 = ImageItem.getImageExt((InputStream) localObject2);
        try {
            ((InputStream) localObject2).close();
            localObject1 = "tapatalk_" + System.currentTimeMillis() + (String) localObject1;
            localObject2 = SettingsFragment.getDownloadLocation(this) + File.separator + (String) localObject1;
            Util.cachePicFullPath((String) localObject2, (String) this.pData.get(this.pager.getCurrentItem()));
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
        File localFile = new File((String) this.pData.get(this.pager.getCurrentItem()));
        Intent localIntent;
        Object localObject1;
        if (localFile.exists()) {
            localIntent = new Intent("android.intent.action.SEND");
            localObject1 = null;
        }
        try {
            localObject2 = MediaStore.Images.Media.insertImage(getContentResolver(), (String) this.pData.get(this.pager.getCurrentItem()), "title", null);
            localObject1 = localObject2;
        } catch (FileNotFoundException localFileNotFoundException) {
            for (; ; ) {
                Object localObject2;
                localFileNotFoundException.printStackTrace();
            }
        }
        localIntent.setType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(localFile.getName().substring(localFile.getName().lastIndexOf(".") + 1)));
        localIntent.putExtra("android.intent.extra.STREAM", Uri.parse((String) localObject1));
        if ((!getApplicationContext().getResources().getBoolean(2131558401)) && (this.thisForumStatus != null)) {
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/GalleryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */