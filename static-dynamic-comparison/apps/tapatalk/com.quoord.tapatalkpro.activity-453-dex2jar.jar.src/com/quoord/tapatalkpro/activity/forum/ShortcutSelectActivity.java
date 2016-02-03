package com.quoord.tapatalkpro.activity.forum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.directory.WidgetSelectorAdapter;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.StyleList;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortcutSelectActivity
        extends Activity {
    public static final int DIALOG_ADDWIDGET = 5;
    public static final int DIALOG_DELETE = 1;
    static int mAppWidgetId = 0;
    private ShortcutSelectActivity mActivity;
    private BaseAdapter mNetworkAdapter;
    private Handler mUIhandler;
    private ListView networkItemList;

    public static void addWidget(int paramInt, Activity paramActivity) {
        TapatalkForum localTapatalkForum = (TapatalkForum) new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivate().get(paramInt);
        Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        Intent localIntent2;
        int i;
        if ((localTapatalkForum != null) && (localTapatalkForum.getUrl() != null)) {
            localIntent2 = new Intent(paramActivity, SlidingMenuActivity.class);
            localIntent2.putExtra("cloud_username", localTapatalkForum.getUserName());
            localIntent2.putExtra("forumId", localTapatalkForum.getId().toString());
            localIntent2.setFlags(67108864);
            localIntent2.setData(Uri.parse("custom://" + SystemClock.elapsedRealtime()));
            if (paramActivity.getResources().getBoolean(2131558401)) {
                break label353;
            }
            paramInt = Util.getPxFromDip(paramActivity, 48.0F);
            i = Util.getPxFromDip(paramActivity, 48.0F);
        }
        for (; ; ) {
            try {
                Object localObject = AvatarTool.getLocalUrl(paramActivity, 5, localTapatalkForum.getIconUrl());
                if (Util.checkLocalData((String) localObject)) {
                    localIntent1.putExtra("android.intent.extra.shortcut.ICON", Util.toRoundCorner(Util.getFoursquareForumIcon((String) localObject, paramInt), 15));
                    localIntent1.putExtra("android.intent.extra.shortcut.NAME", localTapatalkForum.getName());
                    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
                    paramActivity.sendBroadcast(localIntent1);
                    return;
                }
                try {
                    localObject = paramActivity.openFileInput(localTapatalkForum.getIconUrl().hashCode());
                    arrayOfByte = new byte['Ѐ'];
                    localByteArrayOutputStream = new ByteArrayOutputStream();
                    if (((FileInputStream) localObject).read(arrayOfByte) != -1) {
                        continue;
                    }
                    ((FileInputStream) localObject).close();
                    localByteArrayOutputStream.close();
                    localIntent1.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size()));
                } catch (Exception localException1) {
                    localIntent1.putExtra("android.intent.extra.shortcut.ICON", Bitmap.createScaledBitmap(BitmapFactory.decodeResource(paramActivity.getResources(), 2130837525), paramInt, i, true));
                }
                continue;
            } catch (Exception localException2) {
                byte[] arrayOfByte;
                ByteArrayOutputStream localByteArrayOutputStream;
                continue;
                localByteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
                continue;
            }
            label353:
            localIntent1.putExtra("android.intent.extra.shortcut.ICON", drawableToBitmap(paramActivity.getResources().getDrawable(2130837525)));
        }
    }

    public static Bitmap drawableToBitmap(Drawable paramDrawable) {
        int i = paramDrawable.getIntrinsicWidth();
        int j = paramDrawable.getIntrinsicHeight();
        if (paramDrawable.getOpacity() != -1) {
        }
        for (Object localObject = Bitmap.Config.ARGB_8888; ; localObject = Bitmap.Config.RGB_565) {
            localObject = Bitmap.createBitmap(i, j, (Bitmap.Config) localObject);
            Canvas localCanvas = new Canvas((Bitmap) localObject);
            paramDrawable.setBounds(0, 0, i, j);
            paramDrawable.draw(localCanvas);
            return (Bitmap) localObject;
        }
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        this.mActivity.setTitle(getApplicationContext().getString(2131099756));
        this.mUIhandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                if (13 == paramAnonymousMessage.what) {
                    paramAnonymousMessage = (String) ((HashMap) paramAnonymousMessage.obj).get("errormessage");
                    ShortcutSelectActivity.this.mActivity.dismissDialog(0);
                    Toast.makeText(ShortcutSelectActivity.this.mActivity, paramAnonymousMessage, 1).show();
                }
            }
        };
        this.mNetworkAdapter = new WidgetSelectorAdapter(this.mActivity, false);
        if (this.mNetworkAdapter.getCount() == 0) {
            Toast.makeText(this.mActivity, this.mActivity.getString(2131099906), 1).show();
            finish();
        }
        this.networkItemList = StyleList.get(this);
        this.networkItemList.setAdapter(this.mNetworkAdapter);
        this.networkItemList.setOnItemClickListener(new WidgetOnItemClickListener());
        this.mActivity.setContentView(this.networkItemList);
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

    public void updateUI(int paramInt, Map paramMap) {
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = paramInt;
        localMessage.obj = paramMap;
        this.mUIhandler.sendMessage(localMessage);
    }

    class WidgetOnItemClickListener
            implements AdapterView.OnItemClickListener {
        WidgetOnItemClickListener() {
        }

        public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            ShortcutSelectActivity.addWidget(paramInt, ShortcutSelectActivity.this.mActivity);
            ShortcutSelectActivity.this.finish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/ShortcutSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */