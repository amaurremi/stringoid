package twitter4j.internal.async;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

public final class DispatcherFactory
{
  private Configuration conf;
  private String dispatcherImpl;
  
  public DispatcherFactory()
  {
    this(ConfigurationContext.getInstance());
  }
  
  public DispatcherFactory(Configuration paramConfiguration)
  {
    this.dispatcherImpl = paramConfiguration.getDispatcherImpl();
    this.conf = paramConfiguration;
  }
  
  public Dispatcher getInstance()
  {
    try
    {
      Dispatcher localDispatcher = (Dispatcher)Class.forName(this.dispatcherImpl).getConstructor(new Class[] { Configuration.class }).newInstance(new Object[] { this.conf });
      return localDispatcher;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new AssertionError(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new AssertionError(localClassNotFoundException);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new AssertionError(localClassCastException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new AssertionError(localNoSuchMethodException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new AssertionError(localInvocationTargetException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/async/DispatcherFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */