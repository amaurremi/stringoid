package com.quoord.tapatalkpro.tabwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.directory.WidgetSelectorAdapter;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.tabwidget.manager.FavForumWidgetManager;
import com.quoord.tapatalkpro.ui.StyleList;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.HashMap;
import java.util.Map;

public class FavForumsAppWidgetConfigure
        extends Activity {
    public static final int DIALOG_ADDWIDGET = 5;
    public static final int DIALOG_DELETE = 1;
    static int mAppWidgetId = 0;
    private FavForumsAppWidgetConfigure mActivity;
    private BaseAdapter mNetworkAdapter;
    private Handler mUIhandler;
    private ListView networkItemList;

    private void setupWidget(Integer paramInteger) {
        FavForumWidgetManager.saveWidgetPrefs(this, mAppWidgetId, paramInteger.intValue());
        FavForumWidgetManager.getInstance().getOrCreateWidget(this, mAppWidgetId).start();
        Intent localIntent = new Intent();
        localIntent.putExtra("appWidgetId", mAppWidgetId);
        localIntent.putExtra("forumId", paramInteger);
        setResult(-1, localIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        this.mActivity.setTitle(getApplicationContext().getString(2131099755));
        this.mUIhandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                if (13 == paramAnonymousMessage.what) {
                    paramAnonymousMessage = (String) ((HashMap) paramAnonymousMessage.obj).get("errormessage");
                    FavForumsAppWidgetConfigure.this.mActivity.dismissDialog(0);
                    Toast.makeText(FavForumsAppWidgetConfigure.this.mActivity, paramAnonymousMessage, 1).show();
                }
            }
        };
        this.mNetworkAdapter = new WidgetSelectorAdapter(this.mActivity, true);
        if (this.mActivity.getResources().getBoolean(2131558406)) {
            if (this.mNetworkAdapter.getCount() == 0) {
                finish();
            }
        }
        for (; ; ) {
            paramBundle = getIntent().getExtras();
            if (paramBundle != null) {
                mAppWidgetId = paramBundle.getInt("appWidgetId", 0);
            }
            ((WidgetSelectorAdapter) this.mNetworkAdapter).refresh();
            return;
            this.networkItemList = StyleList.get(this);
            this.networkItemList.setAdapter(this.mNetworkAdapter);
            this.networkItemList.setSelection(2131165212);
            this.networkItemList.setOnItemClickListener(new WidgetOnItemClickListener());
            this.mActivity.setContentView(this.networkItemList);
            continue;
            if (this.mActivity.getResources().getBoolean(2131558401)) {
                if (this.mNetworkAdapter.getCount() != 0) {
                    paramBundle = getIntent().getExtras();
                    if (paramBundle != null) {
                        mAppWidgetId = paramBundle.getInt("appWidgetId", 0);
                    }
                    setupWidget(Integer.valueOf(0));
                }
                finish();
            } else {
                if (this.mNetworkAdapter.getCount() == 0) {
                    Toast.makeText(this.mActivity, this.mActivity.getString(2131099906), 1).show();
                    finish();
                }
                this.networkItemList = StyleList.get(this);
                this.networkItemList.setAdapter(this.mNetworkAdapter);
                this.networkItemList.setSelection(2131165212);
                this.networkItemList.setOnItemClickListener(new WidgetOnItemClickListener());
                this.mActivity.setContentView(this.networkItemList);
            }
        }
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
            paramAdapterView = (TapatalkForum) FavForumsAppWidgetConfigure.this.mNetworkAdapter.getItem(paramInt);
            FavForumsAppWidgetConfigure.this.setupWidget(paramAdapterView.getId());
            FavForumsAppWidgetConfigure.this.finish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/FavForumsAppWidgetConfigure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */