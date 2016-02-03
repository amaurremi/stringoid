package com.amazon.inapp.purchasing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class SandboxRequestHandler
  implements RequestHandler
{
  private static final String TAG = "SandboxRequestHandler";
  
  public void sendContentDownloadRequest(String paramString1, String paramString2, String paramString3) {}
  
  public void sendGetUserIdRequest(String paramString)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("SandboxRequestHandler", "sendGetUserIdRequest");
    }
    try
    {
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("requestId", paramString);
      localJSONObject.put("packageName", PurchasingManager.getObserverContext().getPackageName());
      localBundle.putString("userInput", localJSONObject.toString());
      paramString = new Intent("com.amazon.testclient.iap.appUserId");
      paramString.addFlags(268435456);
      paramString.putExtras(localBundle);
      PurchasingManager.getObserverContext().startService(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      Logger.error("SandboxRequestHandler", "Error in sendGetUserIdRequest.");
    }
  }
  
  public void sendItemDataRequest(Set<String> paramSet, String paramString)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("SandboxRequestHandler", "sendItemDataRequest");
    }
    try
    {
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      paramSet = new JSONArray(paramSet);
      localJSONObject.put("requestId", paramString);
      localJSONObject.put("packageName", PurchasingManager.getObserverContext().getPackageName());
      localJSONObject.put("skus", paramSet);
      localBundle.putString("itemDataInput", localJSONObject.toString());
      paramSet = new Intent("com.amazon.testclient.iap.itemData");
      paramSet.addFlags(268435456);
      paramSet.putExtras(localBundle);
      PurchasingManager.getObserverContext().startService(paramSet);
      return;
    }
    catch (JSONException paramSet)
    {
      Logger.error("SandboxRequestHandler", "Error in sendItemDataRequest.");
    }
  }
  
  public void sendPurchaseRequest(String paramString1, String paramString2)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("SandboxRequestHandler", "sendPurchaseRequest");
    }
    try
    {
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sku", paramString1);
      localJSONObject.put("requestId", paramString2);
      localJSONObject.put("packageName", PurchasingManager.getObserverContext().getPackageName());
      localBundle.putString("purchaseInput", localJSONObject.toString());
      paramString1 = new Intent("com.amazon.testclient.iap.purchase");
      paramString1.addFlags(268435456);
      paramString1.putExtras(localBundle);
      PurchasingManager.getObserverContext().startService(paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      Logger.error("SandboxRequestHandler", "Error in sendPurchaseRequest.");
    }
  }
  
  public void sendPurchaseResponseReceivedRequest(String paramString) {}
  
  public void sendPurchaseUpdatesRequest(Offset paramOffset, String paramString)
  {
    if (Logger.isTraceOn()) {
      Logger.trace("SandboxRequestHandler", "sendPurchaseUpdatesRequest");
    }
    try
    {
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("requestId", paramString);
      localJSONObject.put("packageName", PurchasingManager.getObserverContext().getPackageName());
      localJSONObject.put("offset", paramOffset.toString());
      localBundle.putString("purchaseUpdatesInput", localJSONObject.toString());
      paramOffset = new Intent("com.amazon.testclient.iap.purchaseUpdates");
      paramOffset.addFlags(268435456);
      paramOffset.putExtras(localBundle);
      PurchasingManager.getObserverContext().startService(paramOffset);
      return;
    }
    catch (JSONException paramOffset)
    {
      Logger.error("SandboxRequestHandler", "Error in sendPurchaseUpdatesRequest.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/SandboxRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */