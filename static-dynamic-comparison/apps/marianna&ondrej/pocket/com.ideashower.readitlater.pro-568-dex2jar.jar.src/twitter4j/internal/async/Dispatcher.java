package twitter4j.internal.async;

public abstract interface Dispatcher
{
  public abstract void invokeLater(Runnable paramRunnable);
  
  public abstract void shutdown();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/async/Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */