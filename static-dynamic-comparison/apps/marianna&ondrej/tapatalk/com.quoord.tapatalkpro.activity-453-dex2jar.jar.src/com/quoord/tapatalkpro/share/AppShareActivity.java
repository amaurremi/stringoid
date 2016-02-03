package com.quoord.tapatalkpro.share;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.directory.WidgetSelectorAdapter;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.StyleList;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class AppShareActivity
        extends Activity {
    private Activity mActivity;
    private BaseAdapter mNetworkAdapter;
    private ListView networkItemList;
    private SharedPreferences prefs;
    private String shareType;

    public void handleSendImage(Intent paramIntent) {
        paramIntent = (Uri) paramIntent.getParcelableExtra("android.intent.extra.STREAM");
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putString("imageUri", paramIntent);
        localEditor.commit();
    }

    public void handleSendMultipleImages(Intent paramIntent) {
        paramIntent = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putString("imageUris", paramIntent);
        localEditor.commit();
    }

    public void handleSendText(Intent paramIntent) {
        String str = paramIntent.getStringExtra("android.intent.extra.SUBJECT");
        paramIntent = paramIntent.getStringExtra("android.intent.extra.TEXT");
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putString("sharedText", paramIntent);
        localEditor.putString("sharedTextTitle", str);
        localEditor.commit();
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        getActionBar().setIcon(2130837525);
        this.mActivity = this;
        this.mActivity.setTitle(getApplicationContext().getString(2131100452));
        paramBundle = getIntent();
        String str1 = paramBundle.getAction();
        String str2 = paramBundle.getType();
        this.prefs = PreferenceManager.getDefaultSharedPreferences(this.mActivity);
        this.mNetworkAdapter = new WidgetSelectorAdapter(this.mActivity, true);
        this.networkItemList = StyleList.get(this);
        this.networkItemList.setAdapter(this.mNetworkAdapter);
        this.networkItemList.setSelection(2131165212);
        this.networkItemList.setOnItemClickListener(new WidgetOnItemClickListener());
        this.mActivity.setContentView(this.networkItemList);
        if (("android.intent.action.SEND".equals(str1)) && (str2 != null)) {
            if ("text/plain".equals(str2)) {
                this.shareType = "text/plain";
                handleSendText(paramBundle);
            }
        }
        for (; ; ) {
            paramBundle = this.prefs.edit();
            paramBundle.putString("shareType", this.shareType);
            paramBundle.commit();
            return;
            if (str2.startsWith("image/")) {
                this.shareType = "image/";
                handleSendImage(paramBundle);
                continue;
                if (("android.intent.action.SEND_MULTIPLE".equals(str1)) && (str2 != null) && (str2.startsWith("image/"))) {
                    handleSendMultipleImages(paramBundle);
                }
            }
        }
    }

    class WidgetOnItemClickListener
            implements AdapterView.OnItemClickListener {
        WidgetOnItemClickListener() {
        }

        public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            paramAdapterView = (TapatalkForum) AppShareActivity.this.mNetworkAdapter.getItem(paramInt);
            paramView = new Intent(AppShareActivity.this.mActivity, SlidingMenuActivity.class);
            paramView.putExtra("forum", paramAdapterView);
            paramView.putExtra("isShare", true);
            AppShareActivity.this.mActivity.startActivity(paramView);
            AppShareActivity.this.finish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/share/AppShareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */