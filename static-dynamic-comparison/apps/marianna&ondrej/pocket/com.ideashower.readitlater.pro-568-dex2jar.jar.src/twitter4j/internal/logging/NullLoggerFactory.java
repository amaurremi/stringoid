package twitter4j.internal.logging;

final class NullLoggerFactory
  extends LoggerFactory
{
  private static final Logger SINGLETON = new NullLogger();
  
  public Logger getLogger(Class paramClass)
  {
    return SINGLETON;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/logging/NullLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */