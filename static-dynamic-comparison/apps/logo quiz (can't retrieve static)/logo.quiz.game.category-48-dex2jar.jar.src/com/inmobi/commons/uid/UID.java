package com.inmobi.commons.uid;

import android.content.Context;
import com.inmobi.commons.internal.InternalSDKUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class UID
{
  public static final boolean FBA_DEF = false;
  public static final boolean LID_DEF = true;
  public static final boolean O1_DEF = true;
  public static final boolean SID_DEF = true;
  public static final boolean UM5_DEF = true;
  public static UID commons = new UID();
  boolean a = true;
  boolean b = true;
  boolean c = true;
  boolean d = false;
  boolean e = true;
  
  public UID()
  {
    setFromJSON(new JSONObject());
  }
  
  public UID(Context paramContext)
  {
    InternalSDKUtil.setContext(paramContext);
  }
  
  public UID(Context paramContext, JSONObject paramJSONObject)
  {
    this(paramContext);
    setFromJSON(paramJSONObject);
  }
  
  public UID(JSONObject paramJSONObject)
  {
    setFromJSON(paramJSONObject);
  }
  
  public String getUidMap(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      InternalSDKUtil.initialize(InternalSDKUtil.getContext());
      return getUidMapNoReinit(paramString1, paramString2, paramInt, paramString3);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public String getUidMapNoReinit(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Context localContext = InternalSDKUtil.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    localStringBuilder.append("{");
    int j = i;
    if (paramString1 != null)
    {
      j = i;
      if (this.c)
      {
        j = i;
        if (commons.c)
        {
          paramString1 = UIDHelper.a(paramString1, paramString3);
          localStringBuilder.append("LID:'");
          localStringBuilder.append(paramString1);
          localStringBuilder.append("'");
          j = 1;
        }
      }
    }
    i = j;
    if (paramString2 != null)
    {
      i = j;
      if (this.b)
      {
        i = j;
        if (commons.b)
        {
          if (j == 1) {
            localStringBuilder.append(",");
          }
          paramString1 = UIDHelper.a(paramString2, paramString3);
          localStringBuilder.append("SID:'");
          localStringBuilder.append(paramString1);
          localStringBuilder.append("'");
          i = 1;
        }
      }
    }
    if (paramInt <= 0)
    {
      paramInt = i;
      if (this.a)
      {
        paramInt = i;
        if (commons.a)
        {
          if (i == 1) {
            localStringBuilder.append(",");
          }
          paramString1 = UIDHelper.a(UIDHelper.getODIN1(UIDHelper.getAndroidId(localContext)), paramString3);
          localStringBuilder.append("O1:'");
          localStringBuilder.append(paramString1);
          localStringBuilder.append("'");
          paramInt = 1;
        }
      }
      j = paramInt;
      if (this.d)
      {
        j = paramInt;
        if (commons.d)
        {
          paramString1 = UIDHelper.getFBId(localContext);
          j = paramInt;
          if (paramString1 != null)
          {
            if (paramInt == 1) {
              localStringBuilder.append(",");
            }
            paramString1 = UIDHelper.a(paramString1, paramString3);
            localStringBuilder.append("FBA:'");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("'");
            j = 1;
          }
        }
      }
      i = j;
      if (this.e)
      {
        i = j;
        if (commons.e)
        {
          if (j == 1) {
            localStringBuilder.append(",");
          }
          paramString1 = UIDHelper.a(UIDHelper.getUM5(UIDHelper.getAndroidId(localContext)), paramString3);
          localStringBuilder.append("UM5:'");
          localStringBuilder.append(paramString1);
          localStringBuilder.append("'");
          i = 1;
        }
      }
    }
    for (;;)
    {
      localStringBuilder.append("}");
      if (i != 1) {
        break;
      }
      return UIDHelper.encryptRSA(localStringBuilder.toString());
      j = i;
      if ((paramInt & 0x2) != 2)
      {
        j = i;
        if (this.a)
        {
          j = i;
          if (commons.a)
          {
            if (i == 1) {
              localStringBuilder.append(",");
            }
            paramString1 = UIDHelper.a(UIDHelper.getODIN1(UIDHelper.getAndroidId(localContext)), paramString3);
            localStringBuilder.append("O1:'");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("'");
            j = 1;
          }
        }
      }
      int k = j;
      if ((paramInt & 0x4) != 4)
      {
        k = j;
        if (this.d)
        {
          k = j;
          if (commons.d)
          {
            paramString1 = UIDHelper.getFBId(localContext);
            k = j;
            if (paramString1 != null)
            {
              if (j == 1) {
                localStringBuilder.append(",");
              }
              paramString1 = UIDHelper.a(paramString1, paramString3);
              localStringBuilder.append("FBA:'");
              localStringBuilder.append(paramString1);
              localStringBuilder.append("'");
              k = 1;
            }
          }
        }
      }
      i = k;
      if ((paramInt & 0x8) != 8)
      {
        i = k;
        if (this.e)
        {
          i = k;
          if (commons.e)
          {
            if (k == 1) {
              localStringBuilder.append(",");
            }
            paramString1 = UIDHelper.a(UIDHelper.getUM5(UIDHelper.getAndroidId(localContext)), paramString3);
            localStringBuilder.append("UM5:'");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("'");
            i = 1;
          }
        }
      }
    }
    return null;
  }
  
  public void setFromJSON(JSONObject paramJSONObject)
  {
    this.a = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "O1", this.a);
    this.b = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "SID", this.b);
    this.c = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "LID", this.c);
    this.d = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "FBA", this.d);
    this.e = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "UM5", this.e);
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("O1", this.a);
    localJSONObject.put("SID", this.b);
    localJSONObject.put("LID", this.c);
    localJSONObject.put("FBA", this.d);
    localJSONObject.put("UM5", this.e);
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/uid/UID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */