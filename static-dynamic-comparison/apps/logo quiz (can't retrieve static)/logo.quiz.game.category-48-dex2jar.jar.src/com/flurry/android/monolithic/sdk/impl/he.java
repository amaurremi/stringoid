package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.appcloud.AppCloudModule;
import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.protocol.BasicHttpContext;

public abstract class he
  extends jf
{
  protected static final String b = he.class.getSimpleName();
  protected final HttpHost c;
  protected HttpClient d;
  protected BasicHttpContext e;
  protected fr f;
  protected fs g;
  protected HashMap<String, Object> h;
  
  public he(HashMap<String, Object> paramHashMap)
  {
    this.h = paramHashMap;
    this.c = new HttpHost(go.d(), 443, "https");
  }
  
  String a(String paramString)
  {
    if (AppCloudModule.c()) {
      return go.d() + "/" + paramString;
    }
    return "https://" + go.d() + "/" + paramString;
  }
  
  protected void a(AbstractHttpMessage paramAbstractHttpMessage, HashMap<String, Object> paramHashMap)
  {
    paramAbstractHttpMessage.setHeader("Authorization", (String)paramHashMap.get("auth"));
    paramAbstractHttpMessage.setHeader("APPCLOUD-USER-SESSION", (String)paramHashMap.get("session"));
  }
  
  protected void b(String paramString)
  {
    long l = Thread.currentThread().getId();
    Thread.currentThread().setName(paramString + " , id = " + Long.valueOf(l));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */