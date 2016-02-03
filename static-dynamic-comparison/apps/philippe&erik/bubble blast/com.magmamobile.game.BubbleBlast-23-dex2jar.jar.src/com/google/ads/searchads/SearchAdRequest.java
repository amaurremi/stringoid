package com.google.ads.searchads;

import android.content.Context;
import android.graphics.Color;
import com.google.ads.AdRequest;
import com.google.ads.mediation.admob.AdMobAdapterExtras;
import java.util.Locale;
import java.util.Map;

public class SearchAdRequest
  extends AdRequest
{
  private String a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private String h;
  private int i;
  private int j;
  private BorderType k;
  private int l;
  private String m;
  
  private String a(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
  
  public Map<String, Object> getRequestMap(Context paramContext)
  {
    AdMobAdapterExtras localAdMobAdapterExtras2 = (AdMobAdapterExtras)getNetworkExtras(AdMobAdapterExtras.class);
    AdMobAdapterExtras localAdMobAdapterExtras1 = localAdMobAdapterExtras2;
    if (localAdMobAdapterExtras2 == null)
    {
      localAdMobAdapterExtras1 = new AdMobAdapterExtras();
      setNetworkExtras(localAdMobAdapterExtras1);
    }
    if (this.a != null) {
      localAdMobAdapterExtras1.getExtras().put("q", this.a);
    }
    if (Color.alpha(this.b) != 0) {
      localAdMobAdapterExtras1.getExtras().put("bgcolor", a(this.b));
    }
    if ((Color.alpha(this.c) == 255) && (Color.alpha(this.d) == 255))
    {
      localAdMobAdapterExtras1.getExtras().put("gradientfrom", a(this.c));
      localAdMobAdapterExtras1.getExtras().put("gradientto", a(this.d));
    }
    if (Color.alpha(this.e) != 0) {
      localAdMobAdapterExtras1.getExtras().put("hcolor", a(this.e));
    }
    if (Color.alpha(this.f) != 0) {
      localAdMobAdapterExtras1.getExtras().put("dcolor", a(this.f));
    }
    if (Color.alpha(this.g) != 0) {
      localAdMobAdapterExtras1.getExtras().put("acolor", a(this.g));
    }
    if (this.h != null) {
      localAdMobAdapterExtras1.getExtras().put("font", this.h);
    }
    localAdMobAdapterExtras1.getExtras().put("headersize", Integer.toString(this.i));
    if (Color.alpha(this.j) != 0) {
      localAdMobAdapterExtras1.getExtras().put("bcolor", a(this.j));
    }
    if (this.k != null) {
      localAdMobAdapterExtras1.getExtras().put("btype", this.k.toString());
    }
    localAdMobAdapterExtras1.getExtras().put("bthick", Integer.toString(this.l));
    if (this.m != null) {
      localAdMobAdapterExtras1.getExtras().put("channel", this.m);
    }
    return super.getRequestMap(paramContext);
  }
  
  public void setAnchorTextColor(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (Color.alpha(paramInt) == 255)
    {
      this.b = paramInt;
      this.c = 0;
      this.d = 0;
    }
  }
  
  public void setBackgroundGradient(int paramInt1, int paramInt2)
  {
    if ((Color.alpha(paramInt1) == 255) && (Color.alpha(paramInt2) == 255))
    {
      this.b = Color.argb(0, 0, 0, 0);
      this.c = paramInt1;
      this.d = paramInt2;
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setBorderThickness(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setBorderType(BorderType paramBorderType)
  {
    this.k = paramBorderType;
  }
  
  public void setCustomChannels(String paramString)
  {
    this.m = paramString;
  }
  
  public void setDescriptionTextColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setFontFace(String paramString)
  {
    this.h = paramString;
  }
  
  public void setHeaderTextColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setHeaderTextSize(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setQuery(String paramString)
  {
    this.a = paramString;
  }
  
  public static enum BorderType
  {
    private String a;
    
    private BorderType(String paramString)
    {
      this.a = paramString;
    }
    
    public String toString()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/searchads/SearchAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */