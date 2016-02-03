package com.google.api.client.http.b;

import com.google.api.client.http.aa;
import com.google.api.client.http.v;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class b
  extends aa
{
  private final HttpURLConnection aci;
  private final ArrayList<String> acj = new ArrayList();
  private final ArrayList<String> ack = new ArrayList();
  private final int responseCode;
  private final String responseMessage;
  
  b(HttpURLConnection paramHttpURLConnection)
  {
    this.aci = paramHttpURLConnection;
    int j = paramHttpURLConnection.getResponseCode();
    int i = j;
    if (j == -1) {
      i = 0;
    }
    this.responseCode = i;
    this.responseMessage = paramHttpURLConnection.getResponseMessage();
    ArrayList localArrayList1 = this.acj;
    ArrayList localArrayList2 = this.ack;
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields().entrySet().iterator();
    while (paramHttpURLConnection.hasNext())
    {
      Object localObject = (Map.Entry)paramHttpURLConnection.next();
      String str1 = (String)((Map.Entry)localObject).getKey();
      if (str1 != null)
      {
        localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if (str2 != null)
          {
            localArrayList1.add(str1);
            localArrayList2.add(str2);
          }
        }
      }
    }
  }
  
  public void disconnect()
  {
    this.aci.disconnect();
  }
  
  public String eI(int paramInt)
  {
    return (String)this.acj.get(paramInt);
  }
  
  public String eJ(int paramInt)
  {
    return (String)this.ack.get(paramInt);
  }
  
  public InputStream getContent()
  {
    HttpURLConnection localHttpURLConnection = this.aci;
    if (v.eG(this.responseCode)) {
      return localHttpURLConnection.getInputStream();
    }
    return localHttpURLConnection.getErrorStream();
  }
  
  public String getContentEncoding()
  {
    return this.aci.getContentEncoding();
  }
  
  public String getContentType()
  {
    return this.aci.getHeaderField("Content-Type");
  }
  
  public String getReasonPhrase()
  {
    return this.responseMessage;
  }
  
  public int getStatusCode()
  {
    return this.responseCode;
  }
  
  public String xV()
  {
    String str = this.aci.getHeaderField(0);
    if ((str != null) && (str.startsWith("HTTP/1."))) {
      return str;
    }
    return null;
  }
  
  public int xW()
  {
    return this.acj.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */