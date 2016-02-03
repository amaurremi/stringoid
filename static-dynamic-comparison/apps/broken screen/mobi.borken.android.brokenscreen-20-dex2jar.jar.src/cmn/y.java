package cmn;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;

public final class y
{
  public static String a(String paramString, int paramInt, a parama)
  {
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      return paramString;
      Uri localUri = Uri.parse(paramString);
      String str = localUri.getHost();
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (str.endsWith("ggpht.com")) {
          localObject1 = localUri;
        }
      }
    }
    Object localObject1 = ((Uri)localObject1).buildUpon().path(((Uri)localObject1).getPath().replaceFirst("=s[0-9]+$", "")).build().toString();
    int i = paramInt;
    if (paramInt > 1600) {
      i = 1600;
    }
    paramString = (String)localObject1;
    if (i > 0) {
      paramString = (String)localObject1 + "=" + parama.a() + i;
    }
    return paramString;
  }
  
  public static enum a
  {
    private char d;
    
    private a(char paramChar)
    {
      this.d = paramChar;
    }
    
    public final char a()
    {
      return this.d;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */