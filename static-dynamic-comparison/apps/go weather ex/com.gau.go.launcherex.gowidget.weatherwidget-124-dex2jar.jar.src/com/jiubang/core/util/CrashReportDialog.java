package com.jiubang.core.util;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import com.gtp.a.a.b.c;

public class CrashReportDialog
  extends Activity
{
  private static final String TAG = "zyp";
  String mReportFileName = null;
  
  private void onNo()
  {
    finish();
    System.exit(0);
  }
  
  private void onYes()
  {
    try
    {
      Object localObject = ErrorReporter.getInstance();
      localObject.getClass();
      localObject = new ErrorReporter.ReportsSenderWorker((ErrorReporter)localObject);
      ((ErrorReporter.ReportsSenderWorker)localObject).setCommentReportFileName(this.mReportFileName);
      ((ErrorReporter.ReportsSenderWorker)localObject).start();
      finish();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        c.b("zyp", "", localException);
      }
    }
  }
  
  protected void cancelNotification()
  {
    ((NotificationManager)getSystemService("notification")).cancel(666);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("====", "CrashReportDialog on create");
    requestWindowFeature(1);
    setContentView(2130903268);
    getWindow().clearFlags(134217728);
    this.mReportFileName = getIntent().getStringExtra("REPORT_FILE_NAME");
    if (this.mReportFileName == null)
    {
      Log.i("====", "CrashReportDialog return");
      finish();
    }
    Log.i("====", "CrashReportDialog before button");
    paramBundle = (Button)findViewById(2131231884);
    Button localButton = (Button)findViewById(2131231885);
    paramBundle.setOnClickListener(new CrashReportDialog.1(this));
    localButton.setOnClickListener(new CrashReportDialog.2(this));
    cancelNotification();
  }
  
  protected void onStop()
  {
    super.onStop();
    finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/util/CrashReportDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */