package com.amazon.inapp.purchasing;

import java.util.Set;

abstract interface RequestHandler
{
  public abstract void sendContentDownloadRequest(String paramString1, String paramString2, String paramString3);
  
  public abstract void sendGetUserIdRequest(String paramString);
  
  public abstract void sendItemDataRequest(Set<String> paramSet, String paramString);
  
  public abstract void sendPurchaseRequest(String paramString1, String paramString2);
  
  public abstract void sendPurchaseResponseReceivedRequest(String paramString);
  
  public abstract void sendPurchaseUpdatesRequest(Offset paramOffset, String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/RequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */