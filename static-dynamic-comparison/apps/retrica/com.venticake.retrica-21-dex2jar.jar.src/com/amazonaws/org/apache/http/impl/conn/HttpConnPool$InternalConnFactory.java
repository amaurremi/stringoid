package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.conn.OperatedClientConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.pool.ConnFactory;

class HttpConnPool$InternalConnFactory
  implements ConnFactory<HttpRoute, OperatedClientConnection>
{
  public OperatedClientConnection create(HttpRoute paramHttpRoute)
  {
    return new DefaultClientConnection();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/HttpConnPool$InternalConnFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */