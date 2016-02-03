package com.squareup.okhttp.internal;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.Transport;
import java.io.IOException;

public abstract class Internal
{
  public static Internal instance;
  
  public abstract void addLine(Headers.Builder paramBuilder, String paramString);
  
  public abstract boolean clearOwner(Connection paramConnection);
  
  public abstract void closeIfOwnedBy(Connection paramConnection, Object paramObject)
    throws IOException;
  
  public abstract void connect(Connection paramConnection, int paramInt1, int paramInt2, int paramInt3, Request paramRequest)
    throws IOException;
  
  public abstract Object getOwner(Connection paramConnection);
  
  public abstract InternalCache internalCache(OkHttpClient paramOkHttpClient);
  
  public abstract boolean isConnected(Connection paramConnection);
  
  public abstract boolean isReadable(Connection paramConnection);
  
  public abstract boolean isSpdy(Connection paramConnection);
  
  public abstract Transport newTransport(Connection paramConnection, HttpEngine paramHttpEngine)
    throws IOException;
  
  public abstract void recycle(ConnectionPool paramConnectionPool, Connection paramConnection);
  
  public abstract int recycleCount(Connection paramConnection);
  
  public abstract RouteDatabase routeDatabase(OkHttpClient paramOkHttpClient);
  
  public abstract void setCache(OkHttpClient paramOkHttpClient, InternalCache paramInternalCache);
  
  public abstract void setOwner(Connection paramConnection, HttpEngine paramHttpEngine);
  
  public abstract void setProtocol(Connection paramConnection, Protocol paramProtocol);
  
  public abstract void setTimeouts(Connection paramConnection, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void share(ConnectionPool paramConnectionPool, Connection paramConnection);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */