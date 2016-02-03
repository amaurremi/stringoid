package com.bugsense.trace;

import android.util.Log;

class BugProfiler
{
  private static final int MAX_LIFETIME = 60;
  private static int currentStep;
  private static String currentTag;
  private static BugProfiler instance = null;
  private static boolean running = false;
  private static int runningFor;
  private final StringBuilder trackCpu = new StringBuilder();
  private final StringBuilder trackMem = new StringBuilder();
  
  static
  {
    currentTag = "";
    currentStep = 2;
    runningFor = 0;
  }
  
  protected static BugProfiler getProfiler()
  {
    if (instance == null) {
      instance = new BugProfiler();
    }
    return instance;
  }
  
  private void startThread()
  {
    running = true;
    runningFor = 0;
    new Thread(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          if (BugProfiler.running)
          {
            BugProfiler.this.trackCpu.append(Utils.getCPU() + "|");
            BugProfiler.this.trackMem.append(Utils.getMem() + "|");
            try
            {
              Thread.sleep(BugProfiler.currentStep * 1000);
              BugProfiler.access$412(BugProfiler.currentStep);
              if (BugProfiler.runningFor > 60)
              {
                BugProfiler.this.stopProfiling(BugProfiler.currentTag);
                Log.i(G.TAG, "Profiling exceeded max profiling time, stopping!");
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
        }
      }
    }).start();
  }
  
  protected void startProfiling(String paramString, int paramInt)
  {
    if ((paramString.equals(currentTag)) && (running))
    {
      Log.w(G.TAG, "Profiler with name " + paramString + " is already running!");
      return;
    }
    currentTag = paramString;
    Log.i(G.TAG, "Profiling tag set to " + paramString);
    int i;
    if (paramInt > 0)
    {
      i = paramInt;
      if (paramInt <= 60) {}
    }
    else
    {
      Log.i(G.TAG, "Profiling step must be greater than 0s and lower than 60s. ");
      i = 2;
    }
    currentStep = i;
    Log.i(G.TAG, "Profiling step set to " + String.valueOf(currentStep) + " seconds");
    if (this.trackCpu != null) {
      this.trackCpu.setLength(0);
    }
    if (this.trackMem != null) {
      this.trackMem.setLength(0);
    }
    startThread();
  }
  
  protected void stopProfiling(String paramString)
  {
    if ((running) && (paramString.equals(currentTag)))
    {
      Log.i(G.TAG, "Stopping profiler with tag " + paramString);
      running = false;
    }
    Log.i("CPU", this.trackCpu.toString());
    Log.i("MEM", this.trackMem.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/BugProfiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */