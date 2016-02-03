package a.a.a.a.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class b
  implements Iterable
{
  private final List a = new LinkedList();
  private final Map b = new HashMap();
  
  public g a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toLowerCase(Locale.US);
    paramString = (List)this.b.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (g)paramString.get(0);
    }
    return null;
  }
  
  public void a(g paramg)
  {
    if (paramg == null) {
      return;
    }
    String str = paramg.a().toLowerCase(Locale.US);
    List localList = (List)this.b.get(str);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.b.put(str, localObject);
    }
    ((List)localObject).add(paramg);
    this.a.add(paramg);
  }
  
  public Iterator iterator()
  {
    return Collections.unmodifiableList(this.a).iterator();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/a/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */