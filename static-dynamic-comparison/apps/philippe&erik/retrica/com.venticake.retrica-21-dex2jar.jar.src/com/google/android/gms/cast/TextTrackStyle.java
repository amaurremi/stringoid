package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.ip;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle
{
  public static final int COLOR_UNSPECIFIED = 0;
  public static final float DEFAULT_FONT_SCALE = 1.0F;
  public static final int EDGE_TYPE_DEPRESSED = 4;
  public static final int EDGE_TYPE_DROP_SHADOW = 2;
  public static final int EDGE_TYPE_NONE = 0;
  public static final int EDGE_TYPE_OUTLINE = 1;
  public static final int EDGE_TYPE_RAISED = 3;
  public static final int EDGE_TYPE_UNSPECIFIED = -1;
  public static final int FONT_FAMILY_CASUAL = 4;
  public static final int FONT_FAMILY_CURSIVE = 5;
  public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
  public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
  public static final int FONT_FAMILY_SANS_SERIF = 0;
  public static final int FONT_FAMILY_SERIF = 2;
  public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
  public static final int FONT_FAMILY_UNSPECIFIED = -1;
  public static final int FONT_STYLE_BOLD = 1;
  public static final int FONT_STYLE_BOLD_ITALIC = 3;
  public static final int FONT_STYLE_ITALIC = 2;
  public static final int FONT_STYLE_NORMAL = 0;
  public static final int FONT_STYLE_UNSPECIFIED = -1;
  public static final int WINDOW_TYPE_NONE = 0;
  public static final int WINDOW_TYPE_NORMAL = 1;
  public static final int WINDOW_TYPE_ROUNDED = 2;
  public static final int WINDOW_TYPE_UNSPECIFIED = -1;
  private JSONObject AA;
  private int BA;
  private int BB;
  private float Bs;
  private int Bt;
  private int Bu;
  private int Bv;
  private int Bw;
  private int Bx;
  private int By;
  private String Bz;
  private int td;
  
  public TextTrackStyle()
  {
    clear();
  }
  
  private int ah(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() == 9)
      {
        i = j;
        if (paramString.charAt(0) != '#') {}
      }
    }
    try
    {
      i = Integer.parseInt(paramString.substring(1, 3), 16);
      j = Integer.parseInt(paramString.substring(3, 5), 16);
      int k = Integer.parseInt(paramString.substring(5, 7), 16);
      i = Color.argb(Integer.parseInt(paramString.substring(7, 9), 16), i, j, k);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  private void clear()
  {
    this.Bs = 1.0F;
    this.Bt = 0;
    this.td = 0;
    this.Bu = -1;
    this.Bv = 0;
    this.Bw = -1;
    this.Bx = 0;
    this.By = 0;
    this.Bz = null;
    this.BA = -1;
    this.BB = -1;
    this.AA = null;
  }
  
  public static TextTrackStyle fromSystemSettings(Context paramContext)
  {
    TextTrackStyle localTextTrackStyle = new TextTrackStyle();
    if (!ip.gi()) {
      return localTextTrackStyle;
    }
    paramContext = (CaptioningManager)paramContext.getSystemService("captioning");
    localTextTrackStyle.setFontScale(paramContext.getFontScale());
    paramContext = paramContext.getUserStyle();
    localTextTrackStyle.setBackgroundColor(paramContext.backgroundColor);
    localTextTrackStyle.setForegroundColor(paramContext.foregroundColor);
    label117:
    boolean bool1;
    boolean bool2;
    switch (paramContext.edgeType)
    {
    default: 
      localTextTrackStyle.setEdgeType(0);
      localTextTrackStyle.setEdgeColor(paramContext.edgeColor);
      paramContext = paramContext.getTypeface();
      if (paramContext != null)
      {
        if (!Typeface.MONOSPACE.equals(paramContext)) {
          break label158;
        }
        localTextTrackStyle.setFontGenericFamily(1);
        bool1 = paramContext.isBold();
        bool2 = paramContext.isItalic();
        if ((!bool1) || (!bool2)) {
          break label202;
        }
        localTextTrackStyle.setFontStyle(3);
      }
      break;
    }
    for (;;)
    {
      return localTextTrackStyle;
      localTextTrackStyle.setEdgeType(1);
      break;
      localTextTrackStyle.setEdgeType(2);
      break;
      label158:
      if (Typeface.SANS_SERIF.equals(paramContext))
      {
        localTextTrackStyle.setFontGenericFamily(0);
        break label117;
      }
      if (Typeface.SERIF.equals(paramContext))
      {
        localTextTrackStyle.setFontGenericFamily(2);
        break label117;
      }
      localTextTrackStyle.setFontGenericFamily(0);
      break label117;
      label202:
      if (bool1) {
        localTextTrackStyle.setFontStyle(1);
      } else if (bool2) {
        localTextTrackStyle.setFontStyle(2);
      } else {
        localTextTrackStyle.setFontStyle(0);
      }
    }
  }
  
  private String o(int paramInt)
  {
    return String.format("#%02X%02X%02X%02X", new Object[] { Integer.valueOf(Color.red(paramInt)), Integer.valueOf(Color.green(paramInt)), Integer.valueOf(Color.blue(paramInt)), Integer.valueOf(Color.alpha(paramInt)) });
  }
  
  public void b(JSONObject paramJSONObject)
  {
    clear();
    this.Bs = ((float)paramJSONObject.optDouble("fontScale", 1.0D));
    this.Bt = ah(paramJSONObject.optString("foregroundColor"));
    this.td = ah(paramJSONObject.optString("backgroundColor"));
    String str;
    if (paramJSONObject.has("edgeType"))
    {
      str = paramJSONObject.getString("edgeType");
      if ("NONE".equals(str)) {
        this.Bu = 0;
      }
    }
    else
    {
      this.Bv = ah(paramJSONObject.optString("edgeColor"));
      if (paramJSONObject.has("windowType"))
      {
        str = paramJSONObject.getString("windowType");
        if (!"NONE".equals(str)) {
          break label320;
        }
        this.Bw = 0;
      }
      label123:
      this.Bx = ah(paramJSONObject.optString("windowColor"));
      if (this.Bw == 2) {
        this.By = paramJSONObject.optInt("windowRoundedCornerRadius", 0);
      }
      this.Bz = paramJSONObject.optString("fontFamily", null);
      if (paramJSONObject.has("fontGenericFamily"))
      {
        str = paramJSONObject.getString("fontGenericFamily");
        if (!"SANS_SERIF".equals(str)) {
          break label356;
        }
        this.BA = 0;
      }
      label203:
      if (paramJSONObject.has("fontStyle"))
      {
        str = paramJSONObject.getString("fontStyle");
        if (!"NORMAL".equals(str)) {
          break label465;
        }
        this.BB = 0;
      }
    }
    for (;;)
    {
      this.AA = paramJSONObject.optJSONObject("customData");
      return;
      if ("OUTLINE".equals(str))
      {
        this.Bu = 1;
        break;
      }
      if ("DROP_SHADOW".equals(str))
      {
        this.Bu = 2;
        break;
      }
      if ("RAISED".equals(str))
      {
        this.Bu = 3;
        break;
      }
      if (!"DEPRESSED".equals(str)) {
        break;
      }
      this.Bu = 4;
      break;
      label320:
      if ("NORMAL".equals(str))
      {
        this.Bw = 1;
        break label123;
      }
      if (!"ROUNDED_CORNERS".equals(str)) {
        break label123;
      }
      this.Bw = 2;
      break label123;
      label356:
      if ("MONOSPACED_SANS_SERIF".equals(str))
      {
        this.BA = 1;
        break label203;
      }
      if ("SERIF".equals(str))
      {
        this.BA = 2;
        break label203;
      }
      if ("MONOSPACED_SERIF".equals(str))
      {
        this.BA = 3;
        break label203;
      }
      if ("CASUAL".equals(str))
      {
        this.BA = 4;
        break label203;
      }
      if ("CURSIVE".equals(str))
      {
        this.BA = 5;
        break label203;
      }
      if (!"SMALL_CAPITALS".equals(str)) {
        break label203;
      }
      this.BA = 6;
      break label203;
      label465:
      if ("BOLD".equals(str)) {
        this.BB = 1;
      } else if ("ITALIC".equals(str)) {
        this.BB = 2;
      } else if ("BOLD_ITALIC".equals(str)) {
        this.BB = 3;
      }
    }
  }
  
  public JSONObject dZ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fontScale", this.Bs);
      if (this.Bt != 0) {
        localJSONObject.put("foregroundColor", o(this.Bt));
      }
      if (this.td != 0) {
        localJSONObject.put("backgroundColor", o(this.td));
      }
      switch (this.Bu)
      {
      case 0: 
        if (this.Bv != 0) {
          localJSONObject.put("edgeColor", o(this.Bv));
        }
        switch (this.Bw)
        {
        case 0: 
          label156:
          if (this.Bx != 0) {
            localJSONObject.put("windowColor", o(this.Bx));
          }
          if (this.Bw == 2) {
            localJSONObject.put("windowRoundedCornerRadius", this.By);
          }
          if (this.Bz != null) {
            localJSONObject.put("fontFamily", this.Bz);
          }
          switch (this.BA)
          {
          case 0: 
            label264:
            switch (this.BB)
            {
            }
            break;
          }
          break;
        }
        break;
      }
      for (;;)
      {
        if (this.AA == null) {
          break label594;
        }
        localJSONObject.put("customData", this.AA);
        return localJSONObject;
        localJSONObject.put("edgeType", "NONE");
        break;
        localJSONObject.put("edgeType", "OUTLINE");
        break;
        localJSONObject.put("edgeType", "DROP_SHADOW");
        break;
        localJSONObject.put("edgeType", "RAISED");
        break;
        localJSONObject.put("edgeType", "DEPRESSED");
        break;
        localJSONObject.put("windowType", "NONE");
        break label156;
        localJSONObject.put("windowType", "NORMAL");
        break label156;
        localJSONObject.put("windowType", "ROUNDED_CORNERS");
        break label156;
        localJSONObject.put("fontGenericFamily", "SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "CASUAL");
        break label264;
        localJSONObject.put("fontGenericFamily", "CURSIVE");
        break label264;
        localJSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
        break label264;
        localJSONObject.put("fontStyle", "NORMAL");
        continue;
        localJSONObject.put("fontStyle", "BOLD");
        continue;
        localJSONObject.put("fontStyle", "ITALIC");
        continue;
        localJSONObject.put("fontStyle", "BOLD_ITALIC");
        continue;
        break;
        break label156;
        break label264;
      }
      label594:
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    int i;
    int j;
    label51:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (!(paramObject instanceof TextTrackStyle));
        paramObject = (TextTrackStyle)paramObject;
        if (this.AA != null) {
          break;
        }
        i = 1;
        if (((TextTrackStyle)paramObject).AA != null) {
          break label218;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.AA == null) || (((TextTrackStyle)paramObject).AA == null)) {
        break;
      }
      bool1 = bool3;
    } while (!in.d(this.AA, ((TextTrackStyle)paramObject).AA));
    if ((this.Bs == ((TextTrackStyle)paramObject).Bs) && (this.Bt == ((TextTrackStyle)paramObject).Bt) && (this.td == ((TextTrackStyle)paramObject).td) && (this.Bu == ((TextTrackStyle)paramObject).Bu) && (this.Bv == ((TextTrackStyle)paramObject).Bv) && (this.Bw == ((TextTrackStyle)paramObject).Bw) && (this.By == ((TextTrackStyle)paramObject).By) && (gi.a(this.Bz, ((TextTrackStyle)paramObject).Bz)) && (this.BA == ((TextTrackStyle)paramObject).BA) && (this.BB == ((TextTrackStyle)paramObject).BB)) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label218:
      j = 0;
      break label51;
    }
  }
  
  public int getBackgroundColor()
  {
    return this.td;
  }
  
  public JSONObject getCustomData()
  {
    return this.AA;
  }
  
  public int getEdgeColor()
  {
    return this.Bv;
  }
  
  public int getEdgeType()
  {
    return this.Bu;
  }
  
  public String getFontFamily()
  {
    return this.Bz;
  }
  
  public int getFontGenericFamily()
  {
    return this.BA;
  }
  
  public float getFontScale()
  {
    return this.Bs;
  }
  
  public int getFontStyle()
  {
    return this.BB;
  }
  
  public int getForegroundColor()
  {
    return this.Bt;
  }
  
  public int getWindowColor()
  {
    return this.Bx;
  }
  
  public int getWindowCornerRadius()
  {
    return this.By;
  }
  
  public int getWindowType()
  {
    return this.Bw;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Float.valueOf(this.Bs), Integer.valueOf(this.Bt), Integer.valueOf(this.td), Integer.valueOf(this.Bu), Integer.valueOf(this.Bv), Integer.valueOf(this.Bw), Integer.valueOf(this.Bx), Integer.valueOf(this.By), this.Bz, Integer.valueOf(this.BA), Integer.valueOf(this.BB), this.AA });
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.td = paramInt;
  }
  
  public void setCustomData(JSONObject paramJSONObject)
  {
    this.AA = paramJSONObject;
  }
  
  public void setEdgeColor(int paramInt)
  {
    this.Bv = paramInt;
  }
  
  public void setEdgeType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4)) {
      throw new IllegalArgumentException("invalid edgeType");
    }
    this.Bu = paramInt;
  }
  
  public void setFontFamily(String paramString)
  {
    this.Bz = paramString;
  }
  
  public void setFontGenericFamily(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      throw new IllegalArgumentException("invalid fontGenericFamily");
    }
    this.BA = paramInt;
  }
  
  public void setFontScale(float paramFloat)
  {
    this.Bs = paramFloat;
  }
  
  public void setFontStyle(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid fontStyle");
    }
    this.BB = paramInt;
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.Bt = paramInt;
  }
  
  public void setWindowColor(int paramInt)
  {
    this.Bx = paramInt;
  }
  
  public void setWindowCornerRadius(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invalid windowCornerRadius");
    }
    this.By = paramInt;
  }
  
  public void setWindowType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid windowType");
    }
    this.Bw = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/TextTrackStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */