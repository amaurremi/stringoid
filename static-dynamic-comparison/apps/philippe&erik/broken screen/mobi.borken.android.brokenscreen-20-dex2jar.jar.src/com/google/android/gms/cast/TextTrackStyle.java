package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.iq;
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
  private JSONObject Ax;
  private float Bp;
  private int Bq;
  private int Br;
  private int Bs;
  private int Bt;
  private int Bu;
  private int Bv;
  private String Bw;
  private int Bx;
  private int By;
  private int ta;
  
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
    this.Bp = 1.0F;
    this.Bq = 0;
    this.ta = 0;
    this.Br = -1;
    this.Bs = 0;
    this.Bt = -1;
    this.Bu = 0;
    this.Bv = 0;
    this.Bw = null;
    this.Bx = -1;
    this.By = -1;
    this.Ax = null;
  }
  
  public static TextTrackStyle fromSystemSettings(Context paramContext)
  {
    TextTrackStyle localTextTrackStyle = new TextTrackStyle();
    if (!iq.gd()) {
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
    throws JSONException
  {
    clear();
    this.Bp = ((float)paramJSONObject.optDouble("fontScale", 1.0D));
    this.Bq = ah(paramJSONObject.optString("foregroundColor"));
    this.ta = ah(paramJSONObject.optString("backgroundColor"));
    String str;
    if (paramJSONObject.has("edgeType"))
    {
      str = paramJSONObject.getString("edgeType");
      if ("NONE".equals(str)) {
        this.Br = 0;
      }
    }
    else
    {
      this.Bs = ah(paramJSONObject.optString("edgeColor"));
      if (paramJSONObject.has("windowType"))
      {
        str = paramJSONObject.getString("windowType");
        if (!"NONE".equals(str)) {
          break label320;
        }
        this.Bt = 0;
      }
      label123:
      this.Bu = ah(paramJSONObject.optString("windowColor"));
      if (this.Bt == 2) {
        this.Bv = paramJSONObject.optInt("windowRoundedCornerRadius", 0);
      }
      this.Bw = paramJSONObject.optString("fontFamily", null);
      if (paramJSONObject.has("fontGenericFamily"))
      {
        str = paramJSONObject.getString("fontGenericFamily");
        if (!"SANS_SERIF".equals(str)) {
          break label356;
        }
        this.Bx = 0;
      }
      label203:
      if (paramJSONObject.has("fontStyle"))
      {
        str = paramJSONObject.getString("fontStyle");
        if (!"NORMAL".equals(str)) {
          break label465;
        }
        this.By = 0;
      }
    }
    for (;;)
    {
      this.Ax = paramJSONObject.optJSONObject("customData");
      return;
      if ("OUTLINE".equals(str))
      {
        this.Br = 1;
        break;
      }
      if ("DROP_SHADOW".equals(str))
      {
        this.Br = 2;
        break;
      }
      if ("RAISED".equals(str))
      {
        this.Br = 3;
        break;
      }
      if (!"DEPRESSED".equals(str)) {
        break;
      }
      this.Br = 4;
      break;
      label320:
      if ("NORMAL".equals(str))
      {
        this.Bt = 1;
        break label123;
      }
      if (!"ROUNDED_CORNERS".equals(str)) {
        break label123;
      }
      this.Bt = 2;
      break label123;
      label356:
      if ("MONOSPACED_SANS_SERIF".equals(str))
      {
        this.Bx = 1;
        break label203;
      }
      if ("SERIF".equals(str))
      {
        this.Bx = 2;
        break label203;
      }
      if ("MONOSPACED_SERIF".equals(str))
      {
        this.Bx = 3;
        break label203;
      }
      if ("CASUAL".equals(str))
      {
        this.Bx = 4;
        break label203;
      }
      if ("CURSIVE".equals(str))
      {
        this.Bx = 5;
        break label203;
      }
      if (!"SMALL_CAPITALS".equals(str)) {
        break label203;
      }
      this.Bx = 6;
      break label203;
      label465:
      if ("BOLD".equals(str)) {
        this.By = 1;
      } else if ("ITALIC".equals(str)) {
        this.By = 2;
      } else if ("BOLD_ITALIC".equals(str)) {
        this.By = 3;
      }
    }
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fontScale", this.Bp);
      if (this.Bq != 0) {
        localJSONObject.put("foregroundColor", o(this.Bq));
      }
      if (this.ta != 0) {
        localJSONObject.put("backgroundColor", o(this.ta));
      }
      switch (this.Br)
      {
      case 0: 
        if (this.Bs != 0) {
          localJSONObject.put("edgeColor", o(this.Bs));
        }
        switch (this.Bt)
        {
        case 0: 
          label156:
          if (this.Bu != 0) {
            localJSONObject.put("windowColor", o(this.Bu));
          }
          if (this.Bt == 2) {
            localJSONObject.put("windowRoundedCornerRadius", this.Bv);
          }
          if (this.Bw != null) {
            localJSONObject.put("fontFamily", this.Bw);
          }
          switch (this.Bx)
          {
          case 0: 
            label264:
            switch (this.By)
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
        if (this.Ax == null) {
          break label594;
        }
        localJSONObject.put("customData", this.Ax);
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
        if (this.Ax != null) {
          break;
        }
        i = 1;
        if (((TextTrackStyle)paramObject).Ax != null) {
          break label218;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.Ax == null) || (((TextTrackStyle)paramObject).Ax == null)) {
        break;
      }
      bool1 = bool3;
    } while (!io.d(this.Ax, ((TextTrackStyle)paramObject).Ax));
    if ((this.Bp == ((TextTrackStyle)paramObject).Bp) && (this.Bq == ((TextTrackStyle)paramObject).Bq) && (this.ta == ((TextTrackStyle)paramObject).ta) && (this.Br == ((TextTrackStyle)paramObject).Br) && (this.Bs == ((TextTrackStyle)paramObject).Bs) && (this.Bt == ((TextTrackStyle)paramObject).Bt) && (this.Bv == ((TextTrackStyle)paramObject).Bv) && (gj.a(this.Bw, ((TextTrackStyle)paramObject).Bw)) && (this.Bx == ((TextTrackStyle)paramObject).Bx) && (this.By == ((TextTrackStyle)paramObject).By)) {}
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
    return this.ta;
  }
  
  public JSONObject getCustomData()
  {
    return this.Ax;
  }
  
  public int getEdgeColor()
  {
    return this.Bs;
  }
  
  public int getEdgeType()
  {
    return this.Br;
  }
  
  public String getFontFamily()
  {
    return this.Bw;
  }
  
  public int getFontGenericFamily()
  {
    return this.Bx;
  }
  
  public float getFontScale()
  {
    return this.Bp;
  }
  
  public int getFontStyle()
  {
    return this.By;
  }
  
  public int getForegroundColor()
  {
    return this.Bq;
  }
  
  public int getWindowColor()
  {
    return this.Bu;
  }
  
  public int getWindowCornerRadius()
  {
    return this.Bv;
  }
  
  public int getWindowType()
  {
    return this.Bt;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Float.valueOf(this.Bp), Integer.valueOf(this.Bq), Integer.valueOf(this.ta), Integer.valueOf(this.Br), Integer.valueOf(this.Bs), Integer.valueOf(this.Bt), Integer.valueOf(this.Bu), Integer.valueOf(this.Bv), this.Bw, Integer.valueOf(this.Bx), Integer.valueOf(this.By), this.Ax });
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.ta = paramInt;
  }
  
  public void setCustomData(JSONObject paramJSONObject)
  {
    this.Ax = paramJSONObject;
  }
  
  public void setEdgeColor(int paramInt)
  {
    this.Bs = paramInt;
  }
  
  public void setEdgeType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4)) {
      throw new IllegalArgumentException("invalid edgeType");
    }
    this.Br = paramInt;
  }
  
  public void setFontFamily(String paramString)
  {
    this.Bw = paramString;
  }
  
  public void setFontGenericFamily(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      throw new IllegalArgumentException("invalid fontGenericFamily");
    }
    this.Bx = paramInt;
  }
  
  public void setFontScale(float paramFloat)
  {
    this.Bp = paramFloat;
  }
  
  public void setFontStyle(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid fontStyle");
    }
    this.By = paramInt;
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.Bq = paramInt;
  }
  
  public void setWindowColor(int paramInt)
  {
    this.Bu = paramInt;
  }
  
  public void setWindowCornerRadius(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invalid windowCornerRadius");
    }
    this.Bv = paramInt;
  }
  
  public void setWindowType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid windowType");
    }
    this.Bt = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/cast/TextTrackStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */