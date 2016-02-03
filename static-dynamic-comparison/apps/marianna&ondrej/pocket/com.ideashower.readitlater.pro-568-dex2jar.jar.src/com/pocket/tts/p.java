package com.pocket.tts;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;

public class p
{
  private final List a;
  private final o b;
  private final boolean c;
  
  private p()
  {
    List localList = n.a(g.c());
    Object localObject1 = d();
    boolean bool;
    if (((List)localObject1).size() != localList.size()) {
      bool = true;
    }
    for (;;)
    {
      Object localObject2 = i.a(a.aA);
      Iterator localIterator;
      if (localObject2 != null)
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (o)localIterator.next();
          if (((o)localObject1).a.equals(localObject2))
          {
            label90:
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = localObject1;
              if (!localList.isEmpty()) {
                localObject2 = (o)localList.get(0);
              }
            }
            this.a = localList;
            this.b = ((o)localObject2);
            this.c = bool;
            return;
            localObject1 = ((List)localObject1).iterator();
          }
        }
      }
      label227:
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label229;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((o)localIterator.next()).a.equals(localObject2));
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label227;
          }
          bool = true;
          break;
          localObject1 = null;
          break label90;
        }
      }
      label229:
      bool = false;
    }
  }
  
  public static p a()
  {
    return new p();
  }
  
  private void a(o paramo)
  {
    i.b().a(a.aA, paramo.a).a();
    a(this.a);
  }
  
  private void a(List paramList)
  {
    ArrayNode localArrayNode = com.ideashower.readitlater.util.l.c();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayNode.add(((o)paramList.next()).a);
    }
    i.b().a(a.aB, localArrayNode.toString()).a();
  }
  
  private List d()
  {
    Object localObject = com.ideashower.readitlater.util.l.b(i.a(a.aB));
    if (localObject != null) {}
    ArrayList localArrayList;
    for (int i = ((ArrayNode)localObject).size();; i = 0)
    {
      localArrayList = new ArrayList(i);
      if (localObject == null) {
        break;
      }
      localObject = ((ArrayNode)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((JsonNode)((Iterator)localObject).next()).asText());
      }
    }
    return localArrayList;
  }
  
  public void a(Context paramContext, final q paramq)
  {
    final List localList = this.a;
    if (localList.isEmpty())
    {
      m.a(paramContext);
      return;
    }
    int j = localList.size();
    CharSequence[] arrayOfCharSequence = new CharSequence[j];
    int i = 0;
    while (i < j)
    {
      arrayOfCharSequence[i] = ((o)localList.get(i)).b;
      i += 1;
    }
    paramContext = new AlertDialog.Builder(paramContext).setTitle(2131493777).setItems(arrayOfCharSequence, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = (o)localList.get(paramAnonymousInt);
        p.a(p.this, paramAnonymousDialogInterface);
        paramq.a(paramAnonymousDialogInterface);
      }
    }).create();
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        paramq.a();
      }
    });
    paramContext.show();
  }
  
  public boolean b()
  {
    return (this.c) && (this.a.size() > 1);
  }
  
  public o c()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */