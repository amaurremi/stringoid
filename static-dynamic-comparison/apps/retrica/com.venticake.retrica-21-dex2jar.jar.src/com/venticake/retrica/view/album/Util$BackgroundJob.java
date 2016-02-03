package com.venticake.retrica.view.album;

import android.app.ProgressDialog;
import android.os.Handler;

class Util$BackgroundJob
  extends MonitoredActivity.LifeCycleAdapter
  implements Runnable
{
  private final MonitoredActivity mActivity;
  private final Runnable mCleanupRunner = new Runnable()
  {
    public void run()
    {
      Util.BackgroundJob.this.mActivity.removeLifeCycleListener(Util.BackgroundJob.this);
      if (Util.BackgroundJob.this.mDialog.getWindow() != null) {
        Util.BackgroundJob.this.mDialog.dismiss();
      }
    }
  };
  private final ProgressDialog mDialog;
  private final Handler mHandler;
  private final Runnable mJob;
  
  public Util$BackgroundJob(MonitoredActivity paramMonitoredActivity, Runnable paramRunnable, ProgressDialog paramProgressDialog, Handler paramHandler)
  {
    this.mActivity = paramMonitoredActivity;
    this.mDialog = paramProgressDialog;
    this.mJob = paramRunnable;
    this.mActivity.addLifeCycleListener(this);
    this.mHandler = paramHandler;
  }
  
  public void onActivityDestroyed(MonitoredActivity paramMonitoredActivity)
  {
    this.mCleanupRunner.run();
    this.mHandler.removeCallbacks(this.mCleanupRunner);
  }
  
  public void onActivityStarted(MonitoredActivity paramMonitoredActivity)
  {
    this.mDialog.show();
  }
  
  public void onActivityStopped(MonitoredActivity paramMonitoredActivity)
  {
    this.mDialog.hide();
  }
  
  public void run()
  {
    try
    {
      this.mJob.run();
      return;
    }
    finally
    {
      this.mHandler.post(this.mCleanupRunner);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Util$BackgroundJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */