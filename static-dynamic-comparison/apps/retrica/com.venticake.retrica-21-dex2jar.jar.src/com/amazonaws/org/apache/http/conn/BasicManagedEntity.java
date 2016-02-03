package com.amazonaws.org.apache.http.conn;

import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.entity.HttpEntityWrapper;
import com.amazonaws.org.apache.http.util.EntityUtils;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicManagedEntity
  extends HttpEntityWrapper
  implements ConnectionReleaseTrigger, EofSensorWatcher
{
  protected final boolean attemptReuse;
  protected ManagedClientConnection managedConn;
  
  public BasicManagedEntity(HttpEntity paramHttpEntity, ManagedClientConnection paramManagedClientConnection, boolean paramBoolean)
  {
    super(paramHttpEntity);
    if (paramManagedClientConnection == null) {
      throw new IllegalArgumentException("Connection may not be null.");
    }
    this.managedConn = paramManagedClientConnection;
    this.attemptReuse = paramBoolean;
  }
  
  private void ensureConsumed()
  {
    if (this.managedConn == null) {
      return;
    }
    try
    {
      if (this.attemptReuse)
      {
        EntityUtils.consume(this.wrappedEntity);
        this.managedConn.markReusable();
      }
      return;
    }
    finally
    {
      releaseManagedConnection();
    }
  }
  
  public void abortConnection()
  {
    if (this.managedConn != null) {}
    try
    {
      this.managedConn.abortConnection();
      return;
    }
    finally
    {
      this.managedConn = null;
    }
  }
  
  public boolean eofDetected(InputStream paramInputStream)
  {
    try
    {
      if ((this.attemptReuse) && (this.managedConn != null))
      {
        paramInputStream.close();
        this.managedConn.markReusable();
      }
      return false;
    }
    finally
    {
      releaseManagedConnection();
    }
  }
  
  public InputStream getContent()
  {
    return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public void releaseConnection()
  {
    ensureConsumed();
  }
  
  protected void releaseManagedConnection()
  {
    if (this.managedConn != null) {}
    try
    {
      this.managedConn.releaseConnection();
      return;
    }
    finally
    {
      this.managedConn = null;
    }
  }
  
  public boolean streamAbort(InputStream paramInputStream)
  {
    if (this.managedConn != null) {
      this.managedConn.abortConnection();
    }
    return false;
  }
  
  /* Error */
  public boolean streamClosed(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/amazonaws/org/apache/http/conn/BasicManagedEntity:attemptReuse	Z
    //   4: ifeq +33 -> 37
    //   7: aload_0
    //   8: getfield 27	com/amazonaws/org/apache/http/conn/BasicManagedEntity:managedConn	Lcom/amazonaws/org/apache/http/conn/ManagedClientConnection;
    //   11: ifnull +26 -> 37
    //   14: aload_0
    //   15: getfield 27	com/amazonaws/org/apache/http/conn/BasicManagedEntity:managedConn	Lcom/amazonaws/org/apache/http/conn/ManagedClientConnection;
    //   18: invokeinterface 84 1 0
    //   23: istore_2
    //   24: aload_1
    //   25: invokevirtual 59	java/io/InputStream:close	()V
    //   28: aload_0
    //   29: getfield 27	com/amazonaws/org/apache/http/conn/BasicManagedEntity:managedConn	Lcom/amazonaws/org/apache/http/conn/ManagedClientConnection;
    //   32: invokeinterface 46 1 0
    //   37: aload_0
    //   38: invokevirtual 49	com/amazonaws/org/apache/http/conn/BasicManagedEntity:releaseManagedConnection	()V
    //   41: iconst_0
    //   42: ireturn
    //   43: astore_1
    //   44: iload_2
    //   45: ifeq -8 -> 37
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_0
    //   52: invokevirtual 49	com/amazonaws/org/apache/http/conn/BasicManagedEntity:releaseManagedConnection	()V
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	BasicManagedEntity
    //   0	57	1	paramInputStream	InputStream
    //   23	22	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   24	37	43	java/net/SocketException
    //   0	24	50	finally
    //   24	37	50	finally
    //   48	50	50	finally
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    super.writeTo(paramOutputStream);
    ensureConsumed();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/BasicManagedEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */