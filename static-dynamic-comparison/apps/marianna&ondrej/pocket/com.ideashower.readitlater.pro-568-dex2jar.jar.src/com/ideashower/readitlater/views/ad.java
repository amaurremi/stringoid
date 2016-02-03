package com.ideashower.readitlater.views;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.m.b.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.a.c.h;
import org.apache.a.c.k;

public class ad
  extends GridView
  implements View.OnClickListener, c
{
  private PackageManager a;
  private ProgressDialog b;
  private al c;
  private final ak d;
  private String e;
  private String f;
  private ArrayList g;
  private AlertDialog h;
  private ai i;
  private int j = -1;
  private UiContext k;
  
  public ad(Context paramContext, ak paramak)
  {
    super(paramContext);
    this.d = new ak(paramak.b(), (String)k.e(paramak.a(), ""), paramak.c(), paramak.d(), paramak.e());
    this.a = getContext().getPackageManager();
    setCacheColorHint(0);
    setVerticalFadingEdgeEnabled(false);
    setNumColumns(3);
    setStretchMode(2);
    setVerticalSpacing(j.a(0.0F));
    setHorizontalSpacing(j.a(0.0F));
    setBackgroundDrawable(getResources().getDrawable(2130837814));
    c();
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      private boolean b = false;
      
      public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (this.b) {
          return;
        }
        this.b = true;
        ad.a(ad.this, (al)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt));
      }
    });
  }
  
  private int a(List paramList1, int paramInt, List paramList2)
  {
    Iterator localIterator = paramList1.iterator();
    al localal;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localal = (al)localIterator.next();
    } while ((!(localal instanceof af)) || (((af)localal).g() != paramInt));
    for (;;)
    {
      if (localal != null)
      {
        paramList1.remove(localal);
        paramList2.add(localal);
        return 1;
      }
      return 0;
      localal = null;
    }
  }
  
  private af a(ResolveInfo paramResolveInfo, List paramList)
  {
    paramResolveInfo = paramResolveInfo.activityInfo.name;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (al)paramList.next();
      if ((localObject instanceof af))
      {
        localObject = (af)localObject;
        if (((af)localObject).a.activityInfo.name.equals(paramResolveInfo)) {
          return (af)localObject;
        }
      }
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    i.b().a(d(paramInt), System.currentTimeMillis()).a();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, UiContext paramUiContext)
  {
    paramString1 = new ad(paramContext, new ak(paramString1, paramString2, paramInt, paramString3, paramString4));
    paramString1.setUiContext(paramUiContext);
    paramContext = new AlertDialog.Builder(paramContext).setTitle(2131493523).setView(paramString1);
    paramInt = 0;
    if (paramString1.a())
    {
      paramContext.setPositiveButton(2131492940, null);
      paramInt = 1;
    }
    paramContext = paramContext.create();
    paramString1.setDialog(paramContext);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.show();
    if (paramInt != 0) {
      paramContext.getButton(-1).setOnClickListener(paramString1);
    }
  }
  
  private void a(final al paramal)
  {
    this.c = paramal;
    if ((this.e == null) && (this.c.c()))
    {
      paramal = com.ideashower.readitlater.activity.a.l.a(2131493160, true);
      paramal.N();
      com.pocket.c.e.a(this.d.b(), this.c.j(), new com.pocket.c.ak()
      {
        public void a(String paramAnonymousString)
        {
          if (paramAnonymousString != null) {
            ad.a(ad.this, paramAnonymousString);
          }
          for (;;)
          {
            ad.a(ad.this, ad.d(ad.this));
            paramal.b();
            return;
            ad.a(ad.this, ad.c(ad.this).b());
          }
        }
      });
      return;
    }
    if ((paramal.a()) && (this.f == null))
    {
      a(paramal.f());
      return;
    }
    paramal.d();
    com.pocket.stats.f.a(getUrlToShare(), paramal.e(), this.k);
    this.h.dismiss();
  }
  
  public static void a(String paramString)
  {
    i.b().a(f(paramString), System.currentTimeMillis()).a();
  }
  
  private void a(List paramList)
  {
    Collections.sort(paramList, new Comparator()
    {
      public int a(al paramAnonymousal1, al paramAnonymousal2)
      {
        return Long.signum(paramAnonymousal2.k() - paramAnonymousal1.k());
      }
    });
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.b != null) {
      return;
    }
    if (this.b == null)
    {
      this.b = ProgressDialog.show(getContext(), "", getContext().getString(2131493135), true);
      this.b.setCancelable(true);
    }
    if (com.ideashower.readitlater.e.o.m(this.d.c()))
    {
      locala = new com.pocket.m.b.a(this.d.c(), this);
      if (paramBoolean) {
        locala.a();
      }
      locala.b();
      return;
    }
    com.pocket.m.b.a locala = new com.pocket.m.b.a(this.d.b(), this);
    if (paramBoolean) {
      locala.a();
    }
    locala.b();
  }
  
  private static long c(int paramInt)
  {
    return i.a(d(paramInt));
  }
  
  private void c()
  {
    ArrayList localArrayList1 = new ArrayList(6);
    ArrayList localArrayList2 = new ArrayList();
    ae localae = new ae(this, 1);
    Object localObject2 = new ae(this, 5);
    localArrayList2.add(localae);
    Object localObject3 = com.pocket.p.o.a(getContext());
    if (!((List)localObject3).isEmpty()) {}
    for (Object localObject1 = new ag(this, (ResolveInfo)((List)localObject3).remove(0));; localObject1 = null)
    {
      localArrayList2.add(localObject1);
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList2.add(new ag(this, (ResolveInfo)((Iterator)localObject3).next()));
      }
    }
    localObject3 = new Intent("android.intent.action.SEND");
    ((Intent)localObject3).setType("text/plain");
    localObject3 = getContext().getPackageManager().queryIntentActivities((Intent)localObject3, 65536).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject3).next();
      if ((!localResolveInfo.activityInfo.packageName.startsWith("com.ideashower.readitlater.")) && (!localResolveInfo.activityInfo.name.equals("com.google.android.apps.docs.app.SendTextToClipboardActivity")) && (a(localResolveInfo, localArrayList2) == null)) {
        localArrayList2.add(new af(this, localResolveInfo));
      }
    }
    localArrayList1.add(localObject2);
    localObject2 = getAllFriendsAsOptions();
    a((List)localObject2);
    int n = ((ArrayList)localObject2).size();
    int m = 0;
    if ((m >= n) || (localArrayList1.size() >= 6) || (m >= 2))
    {
      label324:
      a(localArrayList2);
      m = 0;
      label332:
      if ((m < localArrayList2.size()) && (localArrayList1.size() < 6)) {
        break label705;
      }
      label351:
      Collections.sort(localArrayList2, new Comparator()
      {
        public int a(al paramAnonymousal1, al paramAnonymousal2)
        {
          return paramAnonymousal1.j().compareTo(paramAnonymousal2.j());
        }
      });
      n = 6 - localArrayList1.size();
      if ((n > 0) && (!localArrayList2.isEmpty()))
      {
        if ((n <= 0) || (!localArrayList2.remove(localObject1))) {
          break label776;
        }
        localArrayList1.add(localObject1);
        n -= 1;
      }
    }
    label564:
    label705:
    label773:
    label776:
    for (;;)
    {
      m = n;
      if (n > 0)
      {
        m = n;
        if (localArrayList2.remove(localae))
        {
          localArrayList1.add(localae);
          m = n - 1;
        }
      }
      n = m;
      if (m > 0) {
        n = m - a(localArrayList2, 5, localArrayList1);
      }
      m = n;
      if (n > 0) {
        m = n - a(localArrayList2, 7, localArrayList1);
      }
      n = m;
      if (m > 0) {
        n = m - a(localArrayList2, 3, localArrayList1);
      }
      m = n;
      if (n > 0) {
        m = n - a(localArrayList2, 2, localArrayList1);
      }
      if (m > 0)
      {
        localObject1 = com.pocket.p.o.a(new Intent("android.intent.action.VIEW", Uri.fromParts("sms", "1234567890", null)), getContext());
        if (!((List)localObject1).isEmpty())
        {
          localObject1 = (ResolveInfo)((List)localObject1).remove(0);
          if (localObject1 == null) {
            break label773;
          }
          localObject1 = a((ResolveInfo)localObject1, localArrayList2);
          if (localObject1 == null) {
            break label773;
          }
          localArrayList2.remove(localObject1);
          localArrayList1.add(localObject1);
          m -= 1;
        }
      }
      for (;;)
      {
        n = m;
        if (m > 0) {
          n = m - a(localArrayList2, 4, localArrayList1);
        }
        if (n > 0) {}
        for (;;)
        {
          if ((n <= 0) || (localArrayList2.isEmpty()))
          {
            this.i = new ai(this, localArrayList1, localArrayList2, null);
            setAdapter(this.i);
            return;
            localObject3 = (al)((ArrayList)localObject2).get(m);
            if (((al)localObject3).k() <= 0L) {
              break label324;
            }
            localArrayList1.add(localObject3);
            ((ah)localObject3).a(m + 1);
            m += 1;
            break;
            localObject2 = (al)localArrayList2.get(m);
            if (((al)localObject2).k() <= 0L) {
              break label351;
            }
            localArrayList1.add(localObject2);
            localArrayList2.remove(localObject2);
            m += 1;
            break label332;
            localObject1 = null;
            break label564;
          }
          localArrayList1.add(localArrayList2.remove(0));
          n -= 1;
        }
      }
    }
  }
  
  private static Spanned d(String paramString)
  {
    return Html.fromHtml(h.b(paramString));
  }
  
  private static com.ideashower.readitlater.h.e d(int paramInt)
  {
    return (com.ideashower.readitlater.h.e)com.ideashower.readitlater.h.a.bp.a(String.valueOf(paramInt));
  }
  
  private void d()
  {
    if (this.b != null) {
      this.b.cancel();
    }
  }
  
  private static long e(String paramString)
  {
    return i.a(f(paramString));
  }
  
  private static com.ideashower.readitlater.h.e f(String paramString)
  {
    return (com.ideashower.readitlater.h.e)com.ideashower.readitlater.h.a.bp.a(paramString);
  }
  
  private ArrayList getAllFriendsAsOptions()
  {
    Object localObject = com.ideashower.readitlater.a.o.c().d();
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new ah(this, ((com.ideashower.readitlater.db.operation.f)((Iterator)localObject).next()).a()));
    }
    return localArrayList;
  }
  
  private Drawable getBrightBottomBg()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(getContext()).setTitle(".").setMessage(".").setPositiveButton(".", null).create();
    localAlertDialog.show();
    ViewGroup localViewGroup = (ViewGroup)((ViewGroup)localAlertDialog.getButton(-1).getParent()).getParent();
    ((ViewGroup)localViewGroup.getParent()).setVisibility(8);
    localAlertDialog.dismiss();
    return localViewGroup.getBackground();
  }
  
  private int getNumColumnsCompat()
  {
    int n = 0;
    if (com.ideashower.readitlater.util.a.e()) {
      return getNumColumnsCompat11();
    }
    if (this.j != -1) {
      return this.j;
    }
    int m = n;
    if (getChildCount() > 0)
    {
      int i1 = getChildAt(0).getMeasuredWidth();
      m = n;
      if (i1 > 0) {
        m = getWidth() / i1;
      }
    }
    if (m > 0)
    {
      this.j = m;
      return m;
    }
    return -1;
  }
  
  @TargetApi(11)
  private int getNumColumnsCompat11()
  {
    return getNumColumns();
  }
  
  private String getUrlToShare()
  {
    if (this.e != null) {
      return this.e;
    }
    return this.d.b();
  }
  
  private void setDialog(AlertDialog paramAlertDialog)
  {
    this.h = paramAlertDialog;
  }
  
  private void setUiContext(UiContext paramUiContext)
  {
    this.k = paramUiContext;
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      b();
      return;
    }
    this.f = paramString;
    this.g = paramArrayList;
    d();
    a(this.c);
  }
  
  public boolean a()
  {
    return !ai.a(this.i).isEmpty();
  }
  
  public void b()
  {
    d();
    AlertDialog localAlertDialog = new AlertDialog.Builder(getContext()).setTitle(2131493175).setMessage(2131493045).setNeutralButton(2131492924, null).create();
    localAlertDialog.setCanceledOnTouchOutside(true);
    localAlertDialog.show();
  }
  
  public void onClick(View paramView)
  {
    this.i.a();
    paramView = (ViewGroup)((ViewGroup)paramView.getParent()).getParent();
    View localView = (View)((ViewGroup)getParent()).getParent();
    Drawable localDrawable = paramView.getBackground();
    paramView.setBackgroundDrawable(null);
    localView.setBackgroundDrawable(localDrawable);
    paramView.setVisibility(8);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */