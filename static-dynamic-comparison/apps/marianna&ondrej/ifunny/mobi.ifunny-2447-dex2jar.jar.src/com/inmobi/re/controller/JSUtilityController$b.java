package com.inmobi.re.controller;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.inmobi.re.container.IMWebView;

class JSUtilityController$b
        extends BroadcastReceiver {
    JSUtilityController$b(JSUtilityController paramJSUtilityController) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        int i;
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals(paramIntent.getAction())) {
            long l = paramIntent.getLongExtra("extra_download_id", 0L);
            paramContext = new DownloadManager.Query();
            paramContext.setFilterById(new long[]{l});
            paramContext = this.a.a.query(paramContext);
            if (paramContext.moveToFirst()) {
                i = paramContext.getColumnIndex("status");
                if (16 != paramContext.getInt(i)) {
                    break label99;
                }
                this.a.imWebView.raiseError("download failed", "storePicture");
            }
        }
        label99:
        while (8 != paramContext.getInt(i)) {
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSUtilityController$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */