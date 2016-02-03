package com.amazonaws.org.apache.http.conn.scheme;

import java.net.Socket;

@Deprecated
public abstract interface LayeredSchemeSocketFactory
  extends SchemeSocketFactory
{
  public abstract Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/scheme/LayeredSchemeSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */