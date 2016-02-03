package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

class ValueEscapeUtil
{
  private static ObjectAndStatic<TypeSystem.Value> applyEscaping(ObjectAndStatic<TypeSystem.Value> paramObjectAndStatic, TypeSystem.Value.Escaping paramEscaping)
  {
    if (!isValidStringType((TypeSystem.Value)paramObjectAndStatic.getObject()))
    {
      Log.e("Escaping can only be applied to strings.");
      return paramObjectAndStatic;
    }
    switch (paramEscaping)
    {
    default: 
      Log.e("Unsupported Value Escaping: " + paramEscaping);
      return paramObjectAndStatic;
    }
    return escapeUri(paramObjectAndStatic);
  }
  
  static ObjectAndStatic<TypeSystem.Value> applyEscapings(ObjectAndStatic<TypeSystem.Value> paramObjectAndStatic, List<TypeSystem.Value.Escaping> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramObjectAndStatic = applyEscaping(paramObjectAndStatic, (TypeSystem.Value.Escaping)paramList.next());
    }
    return paramObjectAndStatic;
  }
  
  private static ObjectAndStatic<TypeSystem.Value> escapeUri(ObjectAndStatic<TypeSystem.Value> paramObjectAndStatic)
  {
    try
    {
      ObjectAndStatic localObjectAndStatic = new ObjectAndStatic(Types.objectToValue(urlEncode(((TypeSystem.Value)paramObjectAndStatic.getObject()).getString())), paramObjectAndStatic.isStatic());
      return localObjectAndStatic;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.e("Escape URI: unsupported encoding", localUnsupportedEncodingException);
    }
    return paramObjectAndStatic;
  }
  
  private static boolean isValidStringType(TypeSystem.Value paramValue)
  {
    return (paramValue.hasType()) && (paramValue.getType().equals(TypeSystem.Value.Type.STRING)) && (paramValue.hasString());
  }
  
  static String urlEncode(String paramString)
    throws UnsupportedEncodingException
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/ValueEscapeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */