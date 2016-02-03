package twitter4j.internal.async;

import twitter4j.internal.logging.Logger;

class ExecuteThread
  extends Thread
{
  private static Logger logger = Logger.getLogger(ExecuteThread.class);
  private boolean alive = true;
  DispatcherImpl q;
  
  ExecuteThread(String paramString, DispatcherImpl paramDispatcherImpl, int paramInt)
  {
    super(paramString + "[" + paramInt + "]");
    this.q = paramDispatcherImpl;
  }
  
  public void run()
  {
    while (this.alive)
    {
      Runnable localRunnable = this.q.poll();
      if (localRunnable != null) {
        try
        {
          localRunnable.run();
        }
        catch (Exception localException)
        {
          logger.error("Got an exception while running a task:", localException);
        }
      }
    }
  }
  
  public void shutdown()
  {
    this.alive = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/async/ExecuteThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */