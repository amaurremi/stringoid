package b.a.d;

import b.a.c;
import b.a.c.b;
import java.util.Iterator;
import java.util.Set;

public class a
  implements e
{
  public String a(String paramString, b paramb, b.a.c.a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OAuth ");
    if (parama.containsKey("realm"))
    {
      localStringBuilder.append(parama.a("realm"));
      localStringBuilder.append(", ");
    }
    parama = parama.a();
    parama.a("oauth_signature", paramString, true);
    paramString = parama.keySet().iterator();
    while (paramString.hasNext())
    {
      localStringBuilder.append(parama.a((String)paramString.next()));
      if (paramString.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    paramString = localStringBuilder.toString();
    c.a("Auth Header", paramString);
    paramb.a("Authorization", paramString);
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */