package com.android.ex.chips;

import android.os.AsyncTask;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class q
  extends AsyncTask
{
  private q(n paramn) {}
  
  private z a(aa paramaa)
  {
    try
    {
      if (n.i(this.a)) {
        return null;
      }
      paramaa = n.a(this.a, paramaa, -1, false);
      return paramaa;
    }
    catch (NullPointerException paramaa)
    {
      Log.e("RecipientEditTextView", paramaa.getMessage(), paramaa);
    }
    return null;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    int j = 0;
    if (n.j(this.a) != null) {
      n.j(this.a).cancel(true);
    }
    final ArrayList localArrayList1 = new ArrayList();
    paramVarArgs = n.k(this.a);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localArrayList1.add(paramVarArgs[i]);
      i += 1;
    }
    if (n.l(this.a) != null) {
      localArrayList1.addAll(n.l(this.a));
    }
    paramVarArgs = new ArrayList();
    i = j;
    while (i < localArrayList1.size())
    {
      localObject = (z)localArrayList1.get(i);
      if (localObject != null) {
        paramVarArgs.add(n.a(this.a, ((z)localObject).e()));
      }
      i += 1;
    }
    Object localObject = x.a(this.a.getContext(), paramVarArgs);
    final ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    z localz;
    if (localIterator.hasNext())
    {
      localz = (z)localIterator.next();
      if ((!aa.a(localz.e().d())) || (this.a.getSpannable().getSpanStart(localz) == -1)) {
        break label328;
      }
    }
    label328:
    for (paramVarArgs = this.a.b((aa)((HashMap)localObject).get(this.a.a(localz.e().c())));; paramVarArgs = null)
    {
      if (paramVarArgs != null)
      {
        localArrayList2.add(a(paramVarArgs));
        break;
      }
      localArrayList2.add(localz);
      break;
      if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
        this.a.g.post(new Runnable()
        {
          public void run()
          {
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(q.this.a.getText().toString());
            Editable localEditable = q.this.a.getText();
            Iterator localIterator = localArrayList1.iterator();
            int i = 0;
            while (localIterator.hasNext())
            {
              z localz = (z)localIterator.next();
              int j = localEditable.getSpanStart(localz);
              if (j != -1)
              {
                int k = localEditable.getSpanEnd(localz);
                localEditable.removeSpan(localz);
                localz = (z)localArrayList2.get(i);
                localSpannableStringBuilder.setSpan(localz, j, k, 33);
                localz.a(localSpannableStringBuilder.toString().substring(j, k));
              }
              i += 1;
            }
            localArrayList1.clear();
            q.this.a.setText(localSpannableStringBuilder);
          }
        });
      }
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */