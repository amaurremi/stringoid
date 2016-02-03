package android.support.v4.view.a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class m
  extends o
{
  public Object a(final k paramk)
  {
    p.a(new q()
    {
      public Object a(int paramAnonymousInt)
      {
        a locala = paramk.a(paramAnonymousInt);
        if (locala == null) {
          return null;
        }
        return locala.a();
      }
      
      public List<Object> a(String paramAnonymousString, int paramAnonymousInt)
      {
        paramAnonymousString = paramk.a(paramAnonymousString, paramAnonymousInt);
        ArrayList localArrayList = new ArrayList();
        int i = paramAnonymousString.size();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < i)
        {
          localArrayList.add(((a)paramAnonymousString.get(paramAnonymousInt)).a());
          paramAnonymousInt += 1;
        }
        return localArrayList;
      }
      
      public boolean a(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
      {
        return paramk.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */