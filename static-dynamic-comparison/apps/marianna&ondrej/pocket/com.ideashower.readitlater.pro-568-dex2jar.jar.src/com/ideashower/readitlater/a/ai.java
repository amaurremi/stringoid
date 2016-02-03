package com.ideashower.readitlater.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.y;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.ideashower.readitlater.activity.PocketActivity;
import com.ideashower.readitlater.activity.ReaderActivity;
import com.ideashower.readitlater.db.operation.f;
import com.ideashower.readitlater.e.z;
import com.ideashower.readitlater.h.b;
import com.ideashower.readitlater.objects.h;
import com.ideashower.readitlater.service.RespondToShareService;
import com.ideashower.readitlater.util.n;
import com.ideashower.readitlater.util.u;
import com.pocket.list.adapter.data.ItemQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ai
  implements com.ideashower.readitlater.d.c
{
  private al a;
  private final ItemQuery b = new ItemQuery();
  private aj c = new aj(this);
  private final NotificationManager d = (NotificationManager)g.c().getSystemService("notification");
  private Notification e;
  private final ArrayList f = new ArrayList();
  private com.ideashower.readitlater.g.l g;
  
  public ai()
  {
    this.b.a().b(Integer.valueOf(-1)).a(null).a();
    com.ideashower.readitlater.i.c.a(this);
  }
  
  private PendingIntent a(Intent paramIntent, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    paramIntent.putExtra("shareIds", paramArrayOfInt1);
    paramIntent.putExtra("uniqueIds", paramArrayOfInt2);
    return PendingIntent.getService(g.c(), 0, paramIntent, 1207959552);
  }
  
  private Intent a(com.ideashower.readitlater.e.o paramo, com.ideashower.readitlater.e.x paramx, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(g.c(), RespondToShareService.class);
    localIntent.setAction(paramString2);
    localIntent.putExtra("actionName", paramString1);
    localIntent.putExtra("shareId", paramx.b());
    localIntent.putExtra("uniqueId", paramo.f());
    localIntent.putExtra("noteId", 333);
    return localIntent;
  }
  
  private static Bitmap a(f paramf)
  {
    Resources localResources = g.c().getResources();
    if (com.ideashower.readitlater.util.a.e()) {}
    for (int i = Math.min((int)localResources.getDimension(17104902), (int)localResources.getDimension(17104901));; i = (int)localResources.getDimension(2131296318)) {
      return f.a(paramf, i, false);
    }
  }
  
  private void a(android.support.v4.app.x paramx)
  {
    Intent localIntent = new Intent(g.c(), PocketActivity.class);
    localIntent.putExtra("extraLaunchInbox", true);
    paramx.a(android.support.v4.app.al.a(g.c()).a(localIntent).a(0, 134217728));
  }
  
  private void a(android.support.v4.app.x paramx, com.ideashower.readitlater.e.w paramw, com.ideashower.readitlater.e.o paramo)
  {
    int j = 0;
    Object localObject1 = o.c().a(paramw);
    Object localObject2 = ((f)localObject1).h() + " shared " + paramo.i(true) + ".";
    paramx.c((CharSequence)localObject2).a((CharSequence)localObject2);
    localObject2 = a(paramo, paramw, "share_added", "actionAcceptShare");
    Intent localIntent = a(paramo, paramw, "share_ignored", "actionIgnoreShare");
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = paramw.b();
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = paramo.f();
    paramx.a(2130837677, "Add to Pocket", a((Intent)localObject2, arrayOfInt1, arrayOfInt2)).a(2130837678, "Ignore", a(localIntent, arrayOfInt1, arrayOfInt2));
    localObject1 = a((f)localObject1);
    if (localObject1 != null) {
      paramx.a((Bitmap)localObject1);
    }
    int i;
    if (!org.apache.a.c.k.c(paramw.d()))
    {
      localObject1 = paramw.d();
      paramx.b((CharSequence)localObject1);
      localObject1 = u.a();
      ((StringBuilder)localObject1).append(paramo.t()).append("\n— ").append(paramo.o()).append("\n");
      if (org.apache.a.c.k.c(paramw.d())) {
        break label383;
      }
      ((StringBuilder)localObject1).append("\n");
      j = ((StringBuilder)localObject1).length();
      ((StringBuilder)localObject1).append(paramw.d());
      i = ((StringBuilder)localObject1).length();
      ((StringBuilder)localObject1).append("\n");
    }
    for (;;)
    {
      if (!org.apache.a.c.k.c(paramw.e())) {
        ((StringBuilder)localObject1).append("\n\"").append(paramw.e()).append("\"");
      }
      paramw = new SpannableString(((StringBuilder)localObject1).toString());
      u.a((StringBuilder)localObject1);
      if (j != i) {
        paramw.setSpan(new ForegroundColorSpan(n.a(g.c())), j, i, 33);
      }
      paramx.a(new android.support.v4.app.w(paramx).a(paramw));
      return;
      localObject1 = paramo.t();
      break;
      label383:
      i = 0;
    }
  }
  
  private void a(android.support.v4.app.x paramx, ArrayList paramArrayList, h paramh)
  {
    int j = paramArrayList.size();
    Context localContext = g.c();
    Object localObject = j + " " + localContext.getString(2131493516);
    paramx.c((CharSequence)localObject).a((CharSequence)localObject).b(j);
    y localy = new y(paramx);
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = u.a();
    int i = 0;
    if (i < j)
    {
      u.b(localStringBuilder);
      localObject = (com.ideashower.readitlater.e.w)paramArrayList.get(i);
      f localf = o.c().a((com.ideashower.readitlater.e.x)localObject);
      if (!localArrayList.contains(localf)) {
        localArrayList.add(localf);
      }
      if (!org.apache.a.c.k.c(((com.ideashower.readitlater.e.w)localObject).d())) {
        localObject = ((com.ideashower.readitlater.e.w)localObject).d();
      }
      for (;;)
      {
        localObject = new SpannableString(localStringBuilder.append(localf.h()).append("  ").append((String)localObject));
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(n.a(g.c())), 0, localf.h().length(), 33);
        localy.a((CharSequence)localObject);
        i += 1;
        break;
        if (!org.apache.a.c.k.c(((com.ideashower.readitlater.e.w)localObject).e())) {
          localObject = ((com.ideashower.readitlater.e.w)localObject).e();
        } else {
          localObject = paramh.a(((com.ideashower.readitlater.e.w)localObject).a()).t();
        }
      }
    }
    u.a(localStringBuilder);
    paramx.a(localy);
    paramArrayList = u.a();
    paramArrayList.append(localContext.getString(2131493510) + " ");
    int k = localArrayList.size();
    i = 0;
    if (i < k)
    {
      if (i > 0)
      {
        if (i != j - 1) {
          break label416;
        }
        paramArrayList.append(" " + localContext.getString(2131493496) + " ");
      }
      for (;;)
      {
        paramArrayList.append(((f)localArrayList.get(i)).h());
        i += 1;
        break;
        label416:
        paramArrayList.append(", ");
      }
    }
    paramArrayList.append(".");
    paramx.b(paramArrayList.toString());
    u.a(paramArrayList);
    if (k == 1)
    {
      paramArrayList = a((f)localArrayList.get(0));
      if (paramArrayList != null) {
        paramx.a(paramArrayList);
      }
    }
    a(paramx);
  }
  
  public static void a(aj paramaj)
  {
    int j = 0;
    if (paramaj.a.isEmpty()) {
      return;
    }
    int[] arrayOfInt = new int[paramaj.a.size()];
    Object localObject = paramaj.a.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      com.ideashower.readitlater.e.x localx = (com.ideashower.readitlater.e.x)((Iterator)localObject).next();
      arrayOfInt[i] = localx.b();
      localx.a(true);
      i += 1;
    }
    localObject = new int[paramaj.e.size()];
    paramaj = paramaj.e.iterator();
    i = j;
    while (paramaj.hasNext())
    {
      localObject[i] = ((com.ideashower.readitlater.e.o)paramaj.next()).f();
      i += 1;
    }
    a(arrayOfInt, (int[])localObject);
  }
  
  private void a(z paramz)
  {
    paramz = org.apache.a.c.f.a.a(paramz.b()) + " shared something to you in Pocket.";
    paramz = c().a(System.currentTimeMillis()).c(paramz).a(paramz);
    a(paramz);
    this.d.notify(334, paramz.a());
  }
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length == 0) {
      return;
    }
    new com.ideashower.readitlater.db.operation.o(paramArrayOfInt1, paramArrayOfInt2).f();
  }
  
  private static boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (paramArrayList1 == null) {
      return paramArrayList2 == null;
    }
    return paramArrayList1.equals(paramArrayList2);
  }
  
  private void b(aj paramaj)
  {
    if (!a(this.c.a, paramaj.a)) {
      c(paramaj);
    }
    if ((this.e == null) && (paramaj.g != null))
    {
      localIterator = paramaj.g.iterator();
      while (localIterator.hasNext())
      {
        z localz = (z)localIterator.next();
        if (!com.ideashower.readitlater.h.i.a((b)com.ideashower.readitlater.h.a.bB.a(localz.a())))
        {
          com.ideashower.readitlater.h.i.b().a((b)com.ideashower.readitlater.h.a.bB.a(localz.a()), true).a();
          a(localz);
        }
      }
    }
    this.c = paramaj;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((ak)localIterator.next()).a(paramaj);
    }
  }
  
  private boolean b(com.ideashower.readitlater.e.o paramo)
  {
    if (this.c.d.size() == 0) {}
    do
    {
      return false;
      if (this.c.d.b(paramo) >= 0) {
        return true;
      }
    } while (!paramo.aq());
    return true;
  }
  
  private android.support.v4.app.x c()
  {
    android.support.v4.app.x localx = new android.support.v4.app.x(g.c()).b(true).a(2130837694).c(true);
    String str = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bk);
    if (str != null) {
      localx.a(Uri.parse(str));
    }
    if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bl)) {
      localx.a(com.pocket.i.a.i.c, 900, 5000);
    }
    return localx;
  }
  
  private void c(aj paramaj)
  {
    Object localObject1 = paramaj.a;
    int j = ((ArrayList)localObject1).size();
    if ((j > 0) && (d()))
    {
      Object localObject2 = new int[j];
      Object localObject3 = new int[paramaj.e.size()];
      int i = 0;
      while (i < j)
      {
        localObject2[i] = ((com.ideashower.readitlater.e.x)((ArrayList)localObject1).get(i)).b();
        i += 1;
      }
      i = 0;
      while (i < paramaj.e.size())
      {
        localObject3[i] = ((com.ideashower.readitlater.e.o)paramaj.e.get(i)).f();
        i += 1;
      }
      Intent localIntent = new Intent(g.c(), RespondToShareService.class);
      localIntent.setAction("actionOnDismiss");
      localObject2 = c().b(a(localIntent, (int[])localObject2, (int[])localObject3)).a(paramaj.i);
      if (j == 1)
      {
        localObject1 = (com.ideashower.readitlater.e.w)((ArrayList)localObject1).get(0);
        localObject3 = paramaj.d.a(((com.ideashower.readitlater.e.w)localObject1).a());
        a((android.support.v4.app.x)localObject2, (com.ideashower.readitlater.e.w)localObject1, (com.ideashower.readitlater.e.o)localObject3);
        if ((paramaj.g != null) && (!paramaj.g.isEmpty())) {
          a((android.support.v4.app.x)localObject2);
        }
      }
      for (;;)
      {
        this.e = ((android.support.v4.app.x)localObject2).a();
        this.d.notify(333, this.e);
        return;
        paramaj = ReaderActivity.a(g.c(), ((com.ideashower.readitlater.e.o)localObject3).f(), ((com.ideashower.readitlater.e.o)localObject3).i(), ((com.ideashower.readitlater.e.w)localObject1).b());
        ((android.support.v4.app.x)localObject2).a(android.support.v4.app.al.a(g.c()).a(new Intent(g.c(), PocketActivity.class)).a(paramaj).a(0, 134217728));
        continue;
        a((android.support.v4.app.x)localObject2, (ArrayList)localObject1, paramaj.d);
      }
    }
    b();
  }
  
  private boolean d()
  {
    if (!com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bj)) {
      return false;
    }
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      if (((ak)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public aj a(ak paramak)
  {
    this.f.add(paramak);
    a();
    return this.c;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.D();
    }
    al localal = new al(this, this.b.c());
    if (this.g == null) {
      this.g = new com.ideashower.readitlater.g.l()
      {
        public void a() {}
        
        public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousk != ai.a(ai.this)) {
            return;
          }
          paramAnonymousk = (al)paramAnonymousk;
          if (al.a(paramAnonymousk))
          {
            ai.a(ai.this, null);
            return;
          }
          ai.a(ai.this, al.b(paramAnonymousk));
          ai.a(ai.this, null);
        }
      };
    }
    localal.a(this.g, true);
    this.a = localal;
    localal.f();
  }
  
  public void a(com.ideashower.readitlater.e.o paramo)
  {
    if (b(paramo)) {
      a();
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (b((com.ideashower.readitlater.e.o)paramList.next())) {
        a();
      }
    }
  }
  
  public void aj()
  {
    a();
  }
  
  public void b()
  {
    if (this.e != null)
    {
      this.e = null;
      this.d.cancel(333);
    }
  }
  
  public void b(ak paramak)
  {
    this.f.remove(paramak);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */