package twitter4j.internal.logging;

final class JULLoggerFactory
  extends LoggerFactory
{
  public Logger getLogger(Class paramClass)
  {
    return new JULLogger(java.util.logging.Logger.getLogger(paramClass.getName()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/logging/JULLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */