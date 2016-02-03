package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;

public class RateUsTool {
    private ArrayAdapter<String> adapter;
    private AlertDialog dialog;
    private ListView listView;
    private Activity mActivity;
    private TextView textView;

    public RateUsTool(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    public void showDialog() {
        this.dialog = new AlertDialog.Builder(this.mActivity).create();
        Object localObject1 = LayoutInflater.from(this.mActivity).inflate(2130903333, null);
        this.textView = ((TextView) LayoutInflater.from(this.mActivity).inflate(2130903334, null).findViewById(2131230853));
        this.dialog.setView((View) localObject1);
        this.listView = ((ListView) ((View) localObject1).findViewById(2131231560));
        Object localObject2 = this.mActivity.getResources();
        localObject1 = ((Resources) localObject2).getString(2131099744);
        String str = ((Resources) localObject2).getString(2131099745);
        localObject2 = ((Resources) localObject2).getString(2131099747);
        this.adapter = new ArrayAdapter(this.mActivity, 2130903334, 2131230853, new String[]{localObject1, str, localObject2});
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                switch (paramAnonymousInt) {
                    default:
                        return;
                }
                try {
                    paramAnonymousAdapterView = new Intent("android.intent.action.VIEW");
                    paramAnonymousAdapterView.setData(Uri.parse(TapatalkApp.rate_url));
                    RateUsTool.this.mActivity.startActivity(paramAnonymousAdapterView);
                    RateUsTool.this.dialog.cancel();
                    return;
                    paramAnonymousAdapterView = new Intent("android.intent.action.SEND");
                    paramAnonymousAdapterView.setType("plain/text");
                    paramAnonymousView = RateUsTool.this.mActivity.getResources().getString(2131099743) + Util.getMD5(Util.getMacAddress(RateUsTool.this.mActivity));
                    paramAnonymousAdapterView.putExtra("android.intent.extra.EMAIL", new String[]{"android@tapatalk.com"});
                    paramAnonymousAdapterView.putExtra("android.intent.extra.SUBJECT", paramAnonymousView);
                    RateUsTool.this.mActivity.startActivity(paramAnonymousAdapterView);
                    RateUsTool.this.dialog.cancel();
                    return;
                    RateUsTool.this.dialog.cancel();
                    return;
                } catch (Exception paramAnonymousAdapterView) {
                    for (; ; ) {
                    }
                }
            }
        });
        this.dialog.show();
    }

    public void showRateUsDialog() {
        SharedPreferences.Editor localEditor = Prefs.get(this.mActivity).edit();
        int i = Prefs.get(this.mActivity).getInt("start_count_for_rate", 0) + 1;
        localEditor.putInt("start_count_for_rate", i);
        localEditor.commit();
        if ((i == 20) && (Prefs.get(this.mActivity).getBoolean("should_rate", true))) {
            showDialog();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/RateUsTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */