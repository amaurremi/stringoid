package com.amazonaws.http.conn;

import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.ServiceLatencyProvider;
import com.amazonaws.metrics.ServiceMetricCollector;
import com.amazonaws.org.apache.http.conn.ClientConnectionRequest;
import com.amazonaws.util.AWSServiceMetrics;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.logging.Log;

class ClientConnectionRequestFactory$Handler
  implements InvocationHandler
{
  private final ClientConnectionRequest orig;
  
  ClientConnectionRequestFactory$Handler(ClientConnectionRequest paramClientConnectionRequest)
  {
    this.orig = paramClientConnectionRequest;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      if ("getConnection".equals(paramMethod.getName()))
      {
        paramObject = new ServiceLatencyProvider(AWSServiceMetrics.HttpClientGetConnectionTime);
        try
        {
          paramMethod = paramMethod.invoke(this.orig, paramArrayOfObject);
          return paramMethod;
        }
        finally
        {
          AwsSdkMetrics.getServiceMetricCollector().collectLatency(((ServiceLatencyProvider)paramObject).endTiming());
        }
      }
      paramObject = paramMethod.invoke(this.orig, paramArrayOfObject);
    }
    catch (InvocationTargetException paramObject)
    {
      ClientConnectionRequestFactory.access$000().debug("", (Throwable)paramObject);
      throw ((InvocationTargetException)paramObject).getCause();
    }
    return paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/conn/ClientConnectionRequestFactory$Handler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */