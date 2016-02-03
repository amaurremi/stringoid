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
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.directory.WidgetSelectorAdapter;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.tabwidget.manager.PMWidgetManager;
import com.quoord.tapatalkpro.ui.StyleList;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PMAppWidgetConfigure
        extends Activity {
    public static final int DIALOG_ADDWIDGET = 5;
    public static final int DIALOG_DELETE = 1;
    static int mAppWidgetId = 0;
    private PMAppWidgetConfigure mActivity;
    private BaseAdapter mNetworkAdapter;
    private Handler mUIhandler;
    private ListView networkItemList;

    private void setupWidget(Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2) {
        PMWidgetManager.saveWidgetPrefs(this, mAppWidgetId, paramInteger.intValue());
        PMWidgetManager.getInstance().getOrCreateWidget(this, mAppWidgetId).start();
        Intent localIntent = new Intent();
        localIntent.putExtra("appWidgetId", mAppWidgetId);
        localIntent.putExtra("forumId", paramInteger);
        localIntent.putExtra("isPMEnable", paramBoolean1);
        localIntent.putExtra("isSupportConve", paramBoolean2);
        setResult(-1, localIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        this.mActivity.setTitle(getApplicationContext().getString(2131100452));
        this.mUIhandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                if (13 == paramAnonymousMessage.what) {
                    paramAnonymousMessage = (String) ((HashMap) paramAnonymousMessage.obj).get("errormessage");
                    PMAppWidgetConfigure.this.mActivity.dismissDialog(0);
                    Toast.makeText(PMAppWidgetConfigure.this.mActivity, paramAnonymousMessage, 1).show();
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
                ArrayList localArrayList;
                int i;
                if (this.mNetworkAdapter.getCount() != 0) {
                    paramBundle = getIntent().getExtras();
                    if (paramBundle != null) {
                        mAppWidgetId = paramBundle.getInt("appWidgetId", 0);
                    }
                    localArrayList = new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivate();
                    paramBundle = null;
                    i = 0;
                }
                for (; ; ) {
                    if (i >= localArrayList.size()) {
                        setupWidget(Integer.valueOf(0), paramBundle.isPMEnable(), paramBundle.isSupportConve());
                        finish();
                        break;
                    }
                    Object localObject = paramBundle;
                    if (((TapatalkForum) localArrayList.get(i)).getUserName() != null) {
                        localObject = paramBundle;
                        if (((TapatalkForum) localArrayList.get(i)).getUserName().length() > 0) {
                            localObject = paramBundle;
                            if (((TapatalkForum) localArrayList.get(i)).hasPassword()) {
                                localObject = (TapatalkForum) localArrayList.get(i);
                            }
                        }
                    }
                    i += 1;
                    paramBundle = (Bundle) localObject;
                }
            }
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
            paramAdapterView = (TapatalkForum) PMAppWidgetConfigure.this.mNetworkAdapter.getItem(paramInt);
            PMAppWidgetConfigure.this.setupWidget(paramAdapterView.getId(), paramAdapterView.isPMEnable(), paramAdapterView.isSupportConve());
            PMAppWidgetConfigure.this.finish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/tabwidget/PMAppWidgetConfigure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */