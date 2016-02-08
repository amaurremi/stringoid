package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class f
  extends Activity
{
  final Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
      case 1: 
        do
        {
          return;
        } while (!f.this.f);
        f.this.a(false);
        return;
      }
      f.this.a();
      f.this.b.g();
    }
  };
  final l b = new l();
  final i c = new i()
  {
    public View a(int paramAnonymousInt)
    {
      return f.this.findViewById(paramAnonymousInt);
    }
  };
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  boolean h;
  boolean i;
  boolean j;
  boolean k;
  android.support.v4.c.l l;
  q m;
  
  private static String a(View paramView)
  {
    char c3 = 'F';
    char c2 = '.';
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append(' ');
    char c1;
    label118:
    label135:
    label152:
    label169:
    label186:
    label203:
    label220:
    label244:
    label261:
    int n;
    Object localObject;
    switch (paramView.getVisibility())
    {
    default: 
      localStringBuilder.append('.');
      if (paramView.isFocusable())
      {
        c1 = 'F';
        localStringBuilder.append(c1);
        if (!paramView.isEnabled()) {
          break label562;
        }
        c1 = 'E';
        localStringBuilder.append(c1);
        if (!paramView.willNotDraw()) {
          break label568;
        }
        c1 = '.';
        localStringBuilder.append(c1);
        if (!paramView.isHorizontalScrollBarEnabled()) {
          break label574;
        }
        c1 = 'H';
        localStringBuilder.append(c1);
        if (!paramView.isVerticalScrollBarEnabled()) {
          break label580;
        }
        c1 = 'V';
        localStringBuilder.append(c1);
        if (!paramView.isClickable()) {
          break label586;
        }
        c1 = 'C';
        localStringBuilder.append(c1);
        if (!paramView.isLongClickable()) {
          break label592;
        }
        c1 = 'L';
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        if (!paramView.isFocused()) {
          break label598;
        }
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.isSelected()) {
          break label604;
        }
        c1 = 'S';
        localStringBuilder.append(c1);
        c1 = c2;
        if (paramView.isPressed()) {
          c1 = 'P';
        }
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        localStringBuilder.append(paramView.getLeft());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getTop());
        localStringBuilder.append('-');
        localStringBuilder.append(paramView.getRight());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getBottom());
        n = paramView.getId();
        if (n != -1)
        {
          localStringBuilder.append(" #");
          localStringBuilder.append(Integer.toHexString(n));
          localObject = paramView.getResources();
          if ((n != 0) && (localObject != null)) {
            switch (0xFF000000 & n)
            {
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramView = ((Resources)localObject).getResourcePackageName(n);
        String str = ((Resources)localObject).getResourceTypeName(n);
        localObject = ((Resources)localObject).getResourceEntryName(n);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramView);
        localStringBuilder.append(":");
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
      }
      catch (Resources.NotFoundException paramView)
      {
        label562:
        label568:
        label574:
        label580:
        label586:
        label592:
        label598:
        label604:
        continue;
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append('V');
      break;
      localStringBuilder.append('I');
      break;
      localStringBuilder.append('G');
      break;
      c1 = '.';
      break label118;
      c1 = '.';
      break label135;
      c1 = 'D';
      break label152;
      c1 = '.';
      break label169;
      c1 = '.';
      break label186;
      c1 = '.';
      break label203;
      c1 = '.';
      break label220;
      c1 = '.';
      break label244;
      c1 = '.';
      break label261;
      paramView = "app";
      continue;
      paramView = "android";
    }
  }
  
  private void a(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null) {
      paramPrintWriter.println("null");
    }
    for (;;)
    {
      return;
      paramPrintWriter.println(a(paramView));
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i1 = paramView.getChildCount();
        if (i1 > 0)
        {
          paramString = paramString + "  ";
          int n = 0;
          while (n < i1)
          {
            a(paramString, paramPrintWriter, paramView.getChildAt(n));
            n += 1;
          }
        }
      }
    }
  }
  
  q a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.l == null) {
      this.l = new android.support.v4.c.l();
    }
    q localq = (q)this.l.get(paramString);
    if (localq == null)
    {
      if (paramBoolean2)
      {
        localq = new q(paramString, this, paramBoolean1);
        this.l.put(paramString, localq);
      }
      return localq;
    }
    localq.a(this);
    return localq;
  }
  
  protected void a()
  {
    this.b.o();
  }
  
  public void a(Fragment paramFragment) {}
  
  public void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt == -1)
    {
      super.startActivityForResult(paramIntent, -1);
      return;
    }
    if ((0xFFFF0000 & paramInt) != 0) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    super.startActivityForResult(paramIntent, (paramFragment.o + 1 << 16) + (0xFFFF & paramInt));
  }
  
  void a(String paramString)
  {
    if (this.l != null)
    {
      q localq = (q)this.l.get(paramString);
      if ((localq != null) && (!localq.g))
      {
        localq.h();
        this.l.remove(paramString);
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (!this.g)
    {
      this.g = true;
      this.h = paramBoolean;
      this.a.removeMessages(1);
      d();
    }
  }
  
  protected boolean a(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public Object b()
  {
    return null;
  }
  
  public void c()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a.a(this);
      return;
    }
    this.i = true;
  }
  
  void d()
  {
    if (this.k)
    {
      this.k = false;
      if (this.m != null)
      {
        if (this.h) {
          break label41;
        }
        this.m.c();
      }
    }
    for (;;)
    {
      this.b.r();
      return;
      label41:
      this.m.d();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.d);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.e);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.f);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.g);
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.k);
    if (this.m != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.m)));
      paramPrintWriter.println(":");
      this.m.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.b.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    a(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }
  
  public j e()
  {
    return this.b;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.k();
    int n = paramInt1 >> 16;
    if (n != 0)
    {
      n -= 1;
      if ((this.b.f == null) || (n < 0) || (n >= this.b.f.size()))
      {
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt1));
        return;
      }
      Fragment localFragment = (Fragment)this.b.f.get(n);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt1));
        return;
      }
      localFragment.a(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.b.e()) {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.b.a(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.b.a(this, this.c, null);
    if (getLayoutInflater().getFactory() == null) {
      getLayoutInflater().setFactory(this);
    }
    super.onCreate(paramBundle);
    h localh = (h)getLastNonConfigurationInstance();
    if (localh != null) {
      this.l = localh.e;
    }
    Parcelable localParcelable;
    l locall;
    if (paramBundle != null)
    {
      localParcelable = paramBundle.getParcelable("android:support:fragments");
      locall = this.b;
      if (localh == null) {
        break label101;
      }
    }
    label101:
    for (paramBundle = localh.d;; paramBundle = null)
    {
      locall.a(localParcelable, paramBundle);
      this.b.l();
      return;
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
      boolean bool2 = this.b.a(paramMenu, getMenuInflater());
      if (Build.VERSION.SDK_INT >= 11) {
        return bool1 | bool2;
      }
      return true;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject = null;
    if (!"fragment".equals(paramString)) {
      return super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    String str2 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, g.a);
    String str1 = str2;
    if (str2 == null) {
      str1 = localTypedArray.getString(0);
    }
    int i1 = localTypedArray.getResourceId(1, -1);
    str2 = localTypedArray.getString(2);
    localTypedArray.recycle();
    if (!Fragment.b(this, str1)) {
      return super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    if (0 != 0) {
      throw new NullPointerException();
    }
    if ((-1 == 0) && (i1 == -1) && (str2 == null)) {
      throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
    }
    paramContext = (Context)localObject;
    if (i1 != -1) {
      paramContext = this.b.a(i1);
    }
    paramString = paramContext;
    if (paramContext == null)
    {
      paramString = paramContext;
      if (str2 != null) {
        paramString = this.b.a(str2);
      }
    }
    paramContext = paramString;
    if (paramString == null)
    {
      paramContext = paramString;
      if (-1 != 0) {
        paramContext = this.b.a(0);
      }
    }
    if (l.a) {
      Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(i1) + " fname=" + str1 + " existing=" + paramContext);
    }
    int n;
    if (paramContext == null)
    {
      paramContext = Fragment.a(this, str1);
      paramContext.x = true;
      if (i1 != 0)
      {
        n = i1;
        paramContext.F = n;
        paramContext.G = 0;
        paramContext.H = str2;
        paramContext.y = true;
        paramContext.B = this.b;
        paramContext.a(this, paramAttributeSet, paramContext.m);
        this.b.a(paramContext, true);
      }
    }
    for (;;)
    {
      if (paramContext.R != null) {
        break label523;
      }
      throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
      n = 0;
      break;
      if (paramContext.y) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(i1) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(0) + " with another fragment for " + str1);
      }
      paramContext.y = true;
      if (!paramContext.L) {
        paramContext.a(this, paramAttributeSet, paramContext.m);
      }
      this.b.b(paramContext);
    }
    label523:
    if (i1 != 0) {
      paramContext.R.setId(i1);
    }
    if (paramContext.R.getTag() == null) {
      paramContext.R.setTag(str2);
    }
    return paramContext.R;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a(false);
    this.b.t();
    if (this.m != null) {
      this.m.h();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.b.u();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return this.b.a(paramMenuItem);
    }
    return this.b.b(paramMenuItem);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.b.k();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.b.b(paramMenu);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.e = false;
    if (this.a.hasMessages(2))
    {
      this.a.removeMessages(2);
      a();
    }
    this.b.p();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    this.a.removeMessages(2);
    a();
    this.b.g();
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null))
    {
      if (this.i)
      {
        this.i = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
      return a(paramView, paramMenu) | this.b.a(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.sendEmptyMessage(2);
    this.e = true;
    this.b.g();
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    int i1 = 0;
    if (this.f) {
      a(true);
    }
    Object localObject1 = b();
    ArrayList localArrayList = this.b.i();
    int i2;
    if (this.l != null)
    {
      int i3 = this.l.size();
      localObject2 = new q[i3];
      int n = i3 - 1;
      while (n >= 0)
      {
        localObject2[n] = ((q)this.l.c(n));
        n -= 1;
      }
      n = 0;
      i2 = n;
      if (i1 < i3)
      {
        Object localObject3 = localObject2[i1];
        if (((q)localObject3).g) {
          n = 1;
        }
        for (;;)
        {
          i1 += 1;
          break;
          ((q)localObject3).h();
          this.l.remove(((q)localObject3).d);
        }
      }
    }
    else
    {
      i2 = 0;
    }
    if ((localArrayList == null) && (i2 == 0) && (localObject1 == null)) {
      return null;
    }
    Object localObject2 = new h();
    ((h)localObject2).a = null;
    ((h)localObject2).b = localObject1;
    ((h)localObject2).c = null;
    ((h)localObject2).d = localArrayList;
    ((h)localObject2).e = this.l;
    return localObject2;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.b.j();
    if (localParcelable != null) {
      paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.f = false;
    this.g = false;
    this.a.removeMessages(1);
    if (!this.d)
    {
      this.d = true;
      this.b.m();
    }
    this.b.k();
    this.b.g();
    if (!this.k)
    {
      this.k = true;
      if (this.m == null) {
        break label143;
      }
      this.m.b();
    }
    int i1;
    q[] arrayOfq;
    for (;;)
    {
      this.j = true;
      this.b.n();
      if (this.l == null) {
        return;
      }
      i1 = this.l.size();
      arrayOfq = new q[i1];
      n = i1 - 1;
      while (n >= 0)
      {
        arrayOfq[n] = ((q)this.l.c(n));
        n -= 1;
      }
      label143:
      if (!this.j)
      {
        this.m = a("(root)", this.k, false);
        if ((this.m != null) && (!this.m.f)) {
          this.m.b();
        }
      }
    }
    int n = 0;
    while (n < i1)
    {
      q localq = arrayOfq[n];
      localq.e();
      localq.g();
      n += 1;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.f = true;
    this.a.sendEmptyMessage(1);
    this.b.q();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((paramInt != -1) && ((0xFFFF0000 & paramInt) != 0)) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */