package com.pocket.widget.chip;

import android.content.Context;
import android.support.v4.view.o;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.u;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ThemedEditText;
import com.pocket.p.v;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.a.c.k;

class f
  extends ThemedEditText
  implements TextView.OnEditorActionListener
{
  private char[] a;
  private String b;
  private h c;
  private c d;
  private boolean e;
  
  public f(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    if (paramString != null) {
      a(paramString.toCharArray());
    }
    for (;;)
    {
      if (paramInt != 0) {
        setTextAppearance(getContext(), paramInt);
      }
      setGravity(19);
      setMinWidth(j.a(40.0F));
      z.f(this, 0);
      setBackgroundDrawable(null);
      setOnEditorActionListener(this);
      setSingleLine(true);
      setMaxLines(1);
      setInputType(getInputType() | 0x80000);
      addTextChangedListener(new v()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if (!f.a(f.this))
          {
            f.a(f.this, false);
            return;
          }
          f.b(f.this, false);
        }
      });
      return;
      a(new char[0]);
    }
  }
  
  private void a(Editable paramEditable, CharSequence paramCharSequence)
  {
    this.e = true;
    paramEditable.clear();
    paramEditable.append(paramCharSequence);
    this.e = false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((this.a == null) || (this.a.length == 0) || (this.c == null)) {
      return true;
    }
    Editable localEditable = getText();
    if (localEditable.length() == 0) {
      return true;
    }
    Object localObject2 = k.a(localEditable.toString(), this.b);
    if (localObject2.length == 0) {
      return true;
    }
    if ((localObject2.length == 1) && (!paramBoolean)) {
      return true;
    }
    Object localObject3 = new ArrayList(localObject2.length);
    Object localObject1 = new ArrayList(localObject2.length);
    ArrayList localArrayList = new ArrayList();
    int k = localObject2.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      String str1 = localObject2[i];
      String str2 = k.b(str1);
      if (str2.length() == 0) {}
      for (;;)
      {
        i += 1;
        break;
        if ((j == localObject2.length - 1) && (!paramBoolean))
        {
          ((ArrayList)localObject1).add(str1);
        }
        else
        {
          String str3 = this.c.a(str1);
          if (str3 != null)
          {
            localArrayList.add(str3);
            ((ArrayList)localObject1).add(str1);
          }
          else
          {
            ((ArrayList)localObject3).add(str2);
            j += 1;
          }
        }
      }
    }
    if (((ArrayList)localObject3).size() > 1)
    {
      this.c.a((ArrayList)localObject3);
      if (!((ArrayList)localObject1).isEmpty()) {
        break label300;
      }
      a(localEditable, "");
    }
    for (;;)
    {
      return localArrayList.isEmpty();
      if (((ArrayList)localObject3).isEmpty()) {
        break;
      }
      this.c.a((CharSequence)((ArrayList)localObject3).get(0));
      break;
      label300:
      localObject2 = u.a();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(this.a[0]);
        }
        ((StringBuilder)localObject2).append((String)localObject3);
      }
      a(localEditable, ((StringBuilder)localObject2).toString());
      setSelection(((StringBuilder)localObject2).length());
      u.a((StringBuilder)localObject2);
      if (!localArrayList.isEmpty()) {
        this.c.b(localArrayList);
      }
    }
  }
  
  private void b()
  {
    if ((getSelectionStart() == 0) && (getSelectionEnd() == 0)) {
      this.c.a();
    }
  }
  
  private void c()
  {
    if (this.d != null) {
      this.d.a();
    }
  }
  
  protected void a(c paramc)
  {
    this.d = paramc;
  }
  
  protected void a(h paramh)
  {
    this.c = paramh;
  }
  
  protected void a(char[] paramArrayOfChar)
  {
    this.a = paramArrayOfChar;
    this.b = String.valueOf(paramArrayOfChar);
  }
  
  public boolean a()
  {
    return a(true);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    g localg = new g(this, super.onCreateInputConnection(paramEditorInfo), true);
    int i = paramEditorInfo.imeOptions & 0xFF;
    if ((i & 0x6) != 0)
    {
      paramEditorInfo.imeOptions = (i ^ paramEditorInfo.imeOptions);
      paramEditorInfo.imeOptions |= 0x6;
    }
    if ((paramEditorInfo.imeOptions & 0x40000000) != 0) {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
    }
    paramEditorInfo.actionLabel = getContext().getString(2131493185);
    return localg;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      a(true);
      c();
      return true;
    }
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = super.onKeyUp(paramInt, paramKeyEvent);
    }
    do
    {
      return bool;
      if (!o.a(paramKeyEvent)) {
        break;
      }
      a(true);
    } while (paramInt == 61);
    c();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/chip/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */