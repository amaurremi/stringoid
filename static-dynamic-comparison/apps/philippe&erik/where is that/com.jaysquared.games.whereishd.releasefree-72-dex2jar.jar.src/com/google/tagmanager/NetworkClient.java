package com.google.tagmanager;

import java.io.IOException;
import java.io.InputStream;

abstract interface NetworkClient
{
  public static final int DEFAULT_CONNECTION_TIMEOUT_MILLIS = 20000;
  public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 20000;
  
  public abstract void close();
  
  public abstract InputStream getInputStream(String paramString)
    throws IOException;
  
  public abstract void sendPostRequest(String paramString, byte[] paramArrayOfByte)
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/NetworkClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */