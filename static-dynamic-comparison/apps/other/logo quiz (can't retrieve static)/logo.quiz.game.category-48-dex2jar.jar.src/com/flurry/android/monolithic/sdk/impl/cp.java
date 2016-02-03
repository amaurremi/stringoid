package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import org.apache.http.client.utils.URIUtils;

public final class cp
{
  private static final Pattern a = Pattern.compile("/");
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    URI localURI;
    do
    {
      do
      {
        do
        {
          return paramString;
          localURI = c(paramString);
        } while (localURI == null);
        localURI = localURI.normalize();
      } while (localURI.isOpaque());
      localURI = a(localURI.getScheme(), localURI.getAuthority(), "/", null, null);
    } while (localURI == null);
    return localURI.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return paramString1;
              localObject1 = c(paramString1);
            } while (localObject1 == null);
            localObject1 = ((URI)localObject1).normalize();
            paramString2 = c(paramString2);
          } while (paramString2 == null);
          localObject2 = paramString2.normalize();
        } while ((((URI)localObject1).isOpaque()) || (((URI)localObject2).isOpaque()));
        paramString2 = ((URI)localObject1).getScheme();
        localObject3 = ((URI)localObject2).getScheme();
      } while (((localObject3 == null) && (paramString2 != null)) || ((localObject3 != null) && (!((String)localObject3).equals(paramString2))));
      paramString2 = ((URI)localObject1).getAuthority();
      localObject3 = ((URI)localObject2).getAuthority();
    } while (((localObject3 == null) && (paramString2 != null)) || ((localObject3 != null) && (!((String)localObject3).equals(paramString2))));
    Object localObject3 = ((URI)localObject1).getPath();
    paramString2 = ((URI)localObject2).getPath();
    localObject3 = a.split((CharSequence)localObject3, -1);
    paramString2 = a.split(paramString2, -1);
    int m = localObject3.length;
    int n = paramString2.length;
    int i = 0;
    StringBuilder localStringBuilder;
    boolean bool1;
    for (;;)
    {
      if ((i >= n) || (i >= m) || (!localObject3[i].equals(paramString2[i])))
      {
        paramString2 = ((URI)localObject1).getQuery();
        localObject1 = ((URI)localObject1).getFragment();
        localStringBuilder = new StringBuilder();
        if ((i != n) || (i != m)) {
          break label372;
        }
        String str = ((URI)localObject2).getQuery();
        localObject2 = ((URI)localObject2).getFragment();
        bool1 = TextUtils.equals(paramString2, str);
        boolean bool2 = TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2);
        if ((!bool1) || (!bool2)) {
          break label324;
        }
        localObject1 = null;
        paramString2 = null;
        localObject2 = localObject1;
        localObject3 = paramString2;
        label293:
        paramString2 = a(null, null, localStringBuilder.toString(), (String)localObject3, (String)localObject2);
        if (paramString2 == null) {
          break;
        }
        return paramString2.toString();
      }
      i += 1;
    }
    label324:
    if ((bool1) && (!TextUtils.isEmpty((CharSequence)localObject1))) {}
    for (Object localObject2 = null;; localObject2 = paramString2)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localStringBuilder.append(localObject3[(m - 1)]);
        break;
        label372:
        int j = i;
        int k;
        for (;;)
        {
          k = i;
          if (j >= n - 1) {
            break;
          }
          localStringBuilder.append("..");
          localStringBuilder.append("/");
          j += 1;
        }
        while (k < m - 1)
        {
          localStringBuilder.append(localObject3[k]);
          localStringBuilder.append("/");
          k += 1;
        }
        if (k < m) {
          localStringBuilder.append(localObject3[k]);
        }
        localObject3 = paramString2;
        localObject2 = localObject1;
        if (localStringBuilder.length() != 0) {
          break label293;
        }
        localStringBuilder.append(".");
        localStringBuilder.append("/");
        localObject3 = paramString2;
        localObject2 = localObject1;
        break label293;
      }
      paramString2 = (String)localObject2;
      break;
    }
  }
  
  private static URI a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = new URI(paramString1, paramString2, paramString3, paramString4, paramString5);
      return paramString1;
    }
    catch (URISyntaxException paramString1) {}
    return null;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    URI localURI;
    do
    {
      do
      {
        do
        {
          return paramString;
          localURI = c(paramString);
        } while (localURI == null);
        localURI = localURI.normalize();
      } while (localURI.isOpaque());
      localURI = URIUtils.resolve(localURI, "./");
    } while (localURI == null);
    return localURI.toString();
  }
  
  private static URI c(String paramString)
  {
    try
    {
      paramString = new URI(paramString);
      return paramString;
    }
    catch (URISyntaxException paramString) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */