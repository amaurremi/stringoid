package com.android.ex.chips;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.support.v4.c.e;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.ideashower.readitlater.a.x;
import com.ideashower.readitlater.f.h;
import com.ideashower.readitlater.util.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class c
  extends BaseAdapter
  implements Filterable
{
  private static ColorStateList u = com.ideashower.readitlater.a.g.c().getResources().getColorStateList(2131165791);
  private final w a;
  private boolean b = false;
  private k c;
  private final Context d;
  private final ContentResolver e;
  private final LayoutInflater f;
  private Account g;
  private final int h;
  private final Handler i = new Handler();
  private boolean j = true;
  private LinkedHashMap k;
  private List l;
  private Set m;
  private List n;
  private int o;
  private CharSequence p;
  private final e q;
  private final f r = new f(this, null);
  private float s;
  private boolean t = true;
  
  public c(Context paramContext)
  {
    this(paramContext, 10);
    this.s = paramContext.getResources().getDimension(2131296268);
  }
  
  public c(Context paramContext, int paramInt)
  {
    this.d = paramContext;
    this.e = paramContext.getContentResolver();
    this.f = LayoutInflater.from(paramContext);
    this.h = paramInt;
    this.q = new e(20);
    this.a = v.a();
  }
  
  private static int a(List paramList, aa paramaa, int paramInt)
  {
    if (paramaa.i() != null)
    {
      if (paramList.size() - 1 > paramInt)
      {
        paramList.add(0, paramaa);
        return paramInt + 1;
      }
      paramList.add(paramaa);
      return paramList.size() - 1;
    }
    paramList.add(paramaa);
    return paramInt;
  }
  
  private Cursor a(CharSequence paramCharSequence, int paramInt, Long paramLong)
  {
    paramCharSequence = this.a.b().buildUpon().appendPath(paramCharSequence.toString()).appendQueryParameter("limit", String.valueOf(paramInt + 5));
    if (paramLong != null) {
      paramCharSequence.appendQueryParameter("directory", String.valueOf(paramLong));
    }
    if (this.g != null)
    {
      paramCharSequence.appendQueryParameter("name_for_primary_account", this.g.name);
      paramCharSequence.appendQueryParameter("type_for_primary_account", this.g.type);
    }
    return this.e.query(paramCharSequence.build(), this.a.a(), null, null, null);
  }
  
  private List a(Cursor paramCursor)
  {
    PackageManager localPackageManager = this.d.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    Object localObject = null;
    for (;;)
    {
      if (paramCursor.moveToNext())
      {
        long l1 = paramCursor.getLong(0);
        if (l1 == 1L) {
          continue;
        }
        i locali = new i();
        String str = paramCursor.getString(4);
        int i1 = paramCursor.getInt(5);
        locali.a = l1;
        locali.c = paramCursor.getString(3);
        locali.d = paramCursor.getString(1);
        locali.e = paramCursor.getString(2);
        if ((str != null) && (i1 != 0)) {}
        try
        {
          locali.b = localPackageManager.getResourcesForApplication(str).getString(i1);
          if (locali.b == null) {
            Log.e("BaseRecipientAdapter", "Cannot resolve directory name: " + i1 + "@" + str);
          }
          if ((this.g != null) && (this.g.name.equals(locali.d)) && (this.g.type.equals(locali.e))) {
            localObject = locali;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Log.e("BaseRecipientAdapter", "Cannot resolve directory name: " + i1 + "@" + str, localNameNotFoundException);
            continue;
            localArrayList.add(locali);
          }
        }
      }
    }
    if (localObject != null) {
      localArrayList.add(1, localObject);
    }
    return localArrayList;
  }
  
  private void a(aa paramaa)
  {
    if (!this.t) {}
    Uri localUri;
    do
    {
      return;
      localUri = paramaa.f();
    } while (localUri == null);
    byte[] arrayOfByte = (byte[])this.q.a(localUri);
    if (arrayOfByte != null)
    {
      paramaa.a(arrayOfByte);
      return;
    }
    b(paramaa, localUri);
  }
  
  private void a(CharSequence paramCharSequence, List paramList, int paramInt)
  {
    int i2 = paramList.size();
    int i1 = 1;
    while (i1 < i2)
    {
      i locali = (i)paramList.get(i1);
      locali.f = paramCharSequence;
      if (locali.g == null) {
        locali.g = new g(this, locali);
      }
      locali.g.a(paramInt);
      locali.g.filter(paramCharSequence);
      i1 += 1;
    }
    this.o = (i2 - 1);
    this.r.a();
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) && (this.n != null)) {
      this.n.clear();
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.n = paramList;
    }
  }
  
  private void b(final aa paramaa, final Uri paramUri)
  {
    com.ideashower.readitlater.db.operation.f localf = paramaa.i();
    if (localf != null)
    {
      if (localf.e() == null) {
        return;
      }
      paramaa = new h()
      {
        protected void a(b paramAnonymousb)
        {
          if (paramAnonymousb != null)
          {
            if (paramAnonymousb.c())
            {
              org.apache.a.b.a.a locala = new org.apache.a.b.a.a();
              paramAnonymousb.b().compress(Bitmap.CompressFormat.PNG, 0, locala);
              paramaa.a(locala.b());
              c.m(c.this).a(paramUri, paramaa.g());
              c.this.notifyDataSetChanged();
              org.apache.a.b.d.a(locala);
            }
            paramAnonymousb.b(false);
          }
        }
      };
      com.ideashower.readitlater.f.f.a(localf.e(), new com.pocket.k.d(this.s, this.s), com.pocket.m.a.d.b()).a(1).a(true, com.pocket.m.a.k.a).a(paramaa, true, true).b();
      return;
    }
    new com.ideashower.readitlater.g.g()
    {
      protected void a()
      {
        Cursor localCursor = c.e(c.this).query(paramUri, l.a, null, null, null);
        if (localCursor != null) {}
        try
        {
          if (localCursor.moveToFirst())
          {
            final byte[] arrayOfByte = localCursor.getBlob(0);
            paramaa.a(arrayOfByte);
            c.n(c.this).post(new Runnable()
            {
              public void run()
              {
                c.m(c.this).a(c.2.this.a, arrayOfByte);
                c.this.notifyDataSetChanged();
              }
            });
          }
          return;
        }
        finally
        {
          localCursor.close();
        }
      }
    }.h();
  }
  
  protected int a()
  {
    return 2131230915;
  }
  
  protected List a(boolean paramBoolean, LinkedHashMap paramLinkedHashMap, List paramList, Set paramSet)
  {
    paramSet = new ArrayList();
    paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
    int i1 = 0;
    int i2 = 0;
    int i3;
    if (paramLinkedHashMap.hasNext())
    {
      List localList = (List)((Map.Entry)paramLinkedHashMap.next()).getValue();
      int i5 = localList.size();
      i3 = 0;
      int i4 = i1;
      i1 = i2;
      i2 = i4;
      while (i3 < i5)
      {
        aa localaa = (aa)localList.get(i3);
        i2 = a(paramSet, localaa, i2);
        a(localaa);
        i1 += 1;
        i3 += 1;
      }
      if (i1 <= this.h) {}
    }
    for (;;)
    {
      if (i1 <= this.h) {
        paramLinkedHashMap = paramList.iterator();
      }
      for (;;)
      {
        if (paramLinkedHashMap.hasNext())
        {
          paramList = (aa)paramLinkedHashMap.next();
          if (i1 <= this.h) {}
        }
        else
        {
          return paramSet;
          i3 = i1;
          i1 = i2;
          i2 = i3;
          break;
        }
        i2 = a(paramSet, paramList, i2);
        a(paramList);
        i1 += 1;
      }
      i3 = i2;
      i2 = i1;
      i1 = i3;
    }
  }
  
  protected void a(aa paramaa, Uri paramUri)
  {
    Object localObject1 = null;
    Object localObject2 = paramaa.i();
    if (localObject2 != null)
    {
      localObject2 = ((com.ideashower.readitlater.db.operation.f)localObject2).e();
      if (localObject2 != null) {
        localObject1 = x.b(com.ideashower.readitlater.f.f.a((com.pocket.m.a.a)localObject2, new com.pocket.k.d(this.s, this.s), com.pocket.m.a.d.b()).a(1).a());
      }
      if ((localObject1 != null) && (((b)localObject1).c()))
      {
        localObject2 = ((b)localObject1).b();
        if (localObject2 != null)
        {
          org.apache.a.b.a.a locala = new org.apache.a.b.a.a();
          ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 0, locala);
          paramaa.a(locala.b());
          this.q.a(paramUri, paramaa.g());
          org.apache.a.b.d.a(locala);
        }
        if (localObject1 != null) {
          ((b)localObject1).b(false);
        }
      }
    }
    do
    {
      return;
      localObject2 = com.ideashower.readitlater.db.operation.f.f();
      break;
      localObject1 = (byte[])this.q.a(paramUri);
      if (localObject1 != null)
      {
        paramaa.a((byte[])localObject1);
        return;
      }
      localObject1 = this.e.query(paramUri, l.a, null, null, null);
    } while (localObject1 == null);
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        localObject2 = ((Cursor)localObject1).getBlob(0);
        paramaa.a((byte[])localObject2);
        this.q.a(paramUri, localObject2);
      }
      return;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  public void a(k paramk)
  {
    this.c = paramk;
  }
  
  protected void a(m paramm, boolean paramBoolean, LinkedHashMap paramLinkedHashMap, List paramList, Set paramSet)
  {
    if ((org.apache.a.c.k.c(paramm.b)) && (paramm.f == null)) {}
    while (paramSet.contains(paramm.b)) {
      return;
    }
    if (paramm.f != null)
    {
      a(paramm.f, paramLinkedHashMap, paramSet);
      return;
    }
    paramSet.add(paramm.b);
    if (!paramBoolean)
    {
      paramList.add(aa.a(paramm.a, paramm.b, paramm.c, paramm.d, paramm.e));
      return;
    }
    if (paramLinkedHashMap.containsKey(Long.valueOf(paramm.c)))
    {
      ((List)paramLinkedHashMap.get(Long.valueOf(paramm.c))).add(aa.b(paramm.a, paramm.b, paramm.c, paramm.d, paramm.e));
      return;
    }
    paramList = new ArrayList();
    paramList.add(aa.a(paramm.a, paramm.b, paramm.c, paramm.d, paramm.e));
    paramLinkedHashMap.put(Long.valueOf(paramm.c), paramList);
  }
  
  protected void a(com.ideashower.readitlater.db.operation.f paramf, LinkedHashMap paramLinkedHashMap, Set paramSet)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(aa.a(paramf));
    paramLinkedHashMap.put(Long.valueOf(-paramf.a()), localArrayList);
    paramf = paramf.i();
    if (paramf != null)
    {
      paramf = paramf.iterator();
      while (paramf.hasNext()) {
        paramSet.add((String)paramf.next());
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, LinkedHashMap paramLinkedHashMap, List paramList, Set paramSet) {}
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  protected int b()
  {
    return 2131230916;
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  protected int c()
  {
    return 2131230733;
  }
  
  public int getCount()
  {
    if (this.n != null) {
      return this.n.size();
    }
    return 0;
  }
  
  public Filter getFilter()
  {
    return new d(this);
  }
  
  public Object getItem(int paramInt)
  {
    return this.n.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((aa)this.n.get(paramInt)).a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.f.inflate(2130903079, paramViewGroup, false);
      paramView = new j(this, localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a((aa)this.n.get(paramInt));
      return localView;
      paramViewGroup = (j)paramView.getTag();
      localView = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return ((aa)this.n.get(paramInt)).h();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */