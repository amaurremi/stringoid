package com.amazonaws;

import java.util.EnumMap;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public final class RequestClientOptions
{
  private final Map<RequestClientOptions.Marker, String> markers = new EnumMap(RequestClientOptions.Marker.class);
  
  private String createUserAgentMarkerString(String paramString1, String paramString2)
  {
    if (paramString1.contains(paramString2)) {
      return paramString1;
    }
    return paramString1 + " " + paramString2;
  }
  
  public void appendUserAgent(String paramString)
  {
    String str2 = (String)this.markers.get(RequestClientOptions.Marker.USER_AGENT);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramString = createUserAgentMarkerString(str1, paramString);
    putClientMarker(RequestClientOptions.Marker.USER_AGENT, paramString);
  }
  
  public String getClientMarker(RequestClientOptions.Marker paramMarker)
  {
    return (String)this.markers.get(paramMarker);
  }
  
  public void putClientMarker(RequestClientOptions.Marker paramMarker, String paramString)
  {
    this.markers.put(paramMarker, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/RequestClientOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */