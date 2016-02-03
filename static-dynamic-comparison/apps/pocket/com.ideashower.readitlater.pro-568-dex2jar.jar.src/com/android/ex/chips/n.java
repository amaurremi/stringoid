package com.android.ex.chips;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.QwertyKeyListener;
import android.text.style.ImageSpan;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Patterns;
import android.util.SparseBooleanArray;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView.Validator;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.ideashower.readitlater.db.operation.f;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.AvatarView;
import com.ideashower.readitlater.views.ap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class n
  extends com.pocket.h.a
  implements DialogInterface.OnDismissListener, GestureDetector.OnGestureListener, View.OnClickListener, AdapterView.OnItemClickListener, TextView.OnEditorActionListener, y
{
  protected static int a = "dismiss".hashCode();
  private static int p = -1;
  private static int q = -1;
  private ImageSpan A;
  private TextView B;
  private final ArrayList C = new ArrayList();
  private int D = 0;
  private boolean E = false;
  private ArrayList F;
  private ArrayList G;
  private boolean H = true;
  private final GestureDetector I;
  private ScrollView J;
  private boolean K;
  private o L;
  private final Runnable M = new Runnable()
  {
    public void run()
    {
      n.a(n.this);
    }
  };
  private final Runnable N = new Runnable()
  {
    public void run()
    {
      n.b(n.this);
    }
  };
  private float O;
  private float P;
  private boolean Q = false;
  private final Drawable R;
  private final Drawable S;
  private Rect T;
  private Rect U;
  private Rect V;
  private Typeface W;
  private boolean Z = false;
  private Method aa;
  private boolean ab = false;
  private int[] ac;
  protected float b;
  protected float c;
  protected float d;
  protected MultiAutoCompleteTextView.Tokenizer e;
  protected z f;
  protected Handler g;
  protected Dialog h;
  protected String i;
  protected AdapterView.OnItemClickListener j;
  protected int k;
  protected TextWatcher l;
  protected boolean m = false;
  protected final Runnable n = new Runnable()
  {
    public void run()
    {
      if (n.this.l == null)
      {
        n.this.l = new r(n.this, null);
        n.this.addTextChangedListener(n.this.l);
      }
    }
  };
  public char o = ',';
  private Drawable r = null;
  private Drawable s = null;
  private Drawable t;
  private Drawable u;
  private float v;
  private int w;
  private AutoCompleteTextView.Validator x;
  private int y;
  private Bitmap z;
  
  public n(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    if (p == -1) {
      p = paramContext.getResources().getColor(17170443);
    }
    if (q == -1) {
      q = paramContext.getResources().getColor(2131165211);
    }
    if (this.W == null) {
      this.W = i.a(i.a, getContext());
    }
    setPaintFlags(getPaintFlags() | 0x80);
    this.h = a(paramContext);
    this.j = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        n.this.a(n.this.f, ((x)paramAnonymousAdapterView.getAdapter()).a(paramAnonymousInt));
        n.this.a(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        n.this.clearComposingText();
      }
    };
    setInputType(getInputType() | 0x80000);
    setOnItemClickListener(this);
    this.g = new Handler();
    this.l = new r(this, null);
    addTextChangedListener(this.l);
    this.I = new GestureDetector(paramContext, this);
    setOnEditorActionListener(this);
    setSingleLine(false);
    setMaxLines(Integer.MAX_VALUE);
    this.R = paramContext.getResources().getDrawable(2130837648);
    this.S = paramContext.getResources().getDrawable(2130837646);
    if (!com.ideashower.readitlater.util.a.p())
    {
      setDropDownBackgroundResource(2130837842);
      setDropDownVerticalOffset(j.a(-5.0F));
    }
    setDropDownHorizontalOffset(j.a(24.0F));
    addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((paramAnonymousInt2 == 0) && (paramAnonymousInt3 == 1))
        {
          char c = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
          if ((c == ',') || (c == ';')) {
            n.this.o = c;
          }
        }
      }
    });
    setTokenizer(new s(this));
  }
  
  private float a(String paramString, TextPaint paramTextPaint, int paramInt)
  {
    Rect localRect = new Rect();
    paramTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return paramInt - (paramInt - (localRect.bottom - localRect.top)) / 2 - j.a(1.0F);
  }
  
  private float a(boolean paramBoolean)
  {
    if (getWidth() == 0) {
      return j.a(150.0F);
    }
    return getWidth() - getPaddingLeft() - getPaddingRight() - this.w * 2;
  }
  
  private int a(Editable paramEditable)
  {
    int i2 = 0;
    int i1 = 0;
    int i3;
    int i4;
    do
    {
      i3 = i1;
      if (i2 >= paramEditable.length()) {
        break;
      }
      i4 = h(this.e.findTokenEnd(paramEditable, i2));
      i3 = i1 + 1;
      i2 = i4;
      i1 = i3;
    } while (i4 < paramEditable.length());
    return i3;
  }
  
  private int a(Editable paramEditable, int paramInt)
  {
    if (paramEditable.charAt(paramInt) != ' ') {
      return paramInt;
    }
    return -1;
  }
  
  private Bitmap a(aa paramaa, TextPaint paramTextPaint, Layout paramLayout)
  {
    return a(paramaa, paramTextPaint, paramLayout, b(paramaa, true), p, true);
  }
  
  private Bitmap a(aa paramaa, TextPaint paramTextPaint, Layout paramLayout, Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    boolean bool = c(paramaa);
    int i2;
    int i3;
    label51:
    int i7;
    Rect localRect2;
    Rect localRect1;
    int i1;
    int i5;
    int i4;
    label160:
    int i8;
    int i6;
    label207:
    label214:
    int i9;
    CharSequence localCharSequence;
    Bitmap localBitmap;
    Canvas localCanvas;
    if ((paramaa.i() != null) && (paramaa.i().m()))
    {
      i2 = 1;
      if ((!bool) || ((paramaa.d() == -1L) && (i2 == 0))) {
        break label692;
      }
      i3 = 1;
      i7 = (int)this.b;
      localRect2 = a(paramDrawable);
      localRect1 = new Rect(localRect2.top + j.a(3.5F), localRect2.bottom + j.a(3.5F), localRect2.left + j.a(3.0F), localRect2.right + j.a(3.0F));
      if (i3 == 0) {
        break label698;
      }
      i1 = localRect1.top;
      i5 = localRect1.bottom;
      i4 = j.a(5.0F);
      i5 = i7 - i1 - i5;
      paramLayout = new float[1];
      paramTextPaint.getTextWidths(" ", paramLayout);
      i8 = i7 - j.a(2.0F);
      if (!bool) {
        break label719;
      }
      i6 = (int)paramLayout[0];
      if (i2 == 0) {
        break label707;
      }
      i1 = this.R.getIntrinsicWidth();
      i6 = i8 + i6;
      i9 = localRect1.left + i5 + i4 + i6 + localRect1.right;
      localCharSequence = a(a(paramaa), paramTextPaint, a(false) - i9);
      int i10 = (int)Math.floor(paramTextPaint.measureText(localCharSequence, 0, localCharSequence.length()));
      i9 = Math.max(j.a(40.0F), i9 + i10);
      localBitmap = Bitmap.createBitmap(i9, i7, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      if (paramDrawable == null) {
        break label824;
      }
      paramDrawable.setState(getDrawableState());
      paramDrawable.setBounds(0, 0, i9, i7);
      paramDrawable.draw(localCanvas);
      if (i3 != 0)
      {
        paramDrawable = paramaa.g();
        paramLayout = paramDrawable;
        if (paramDrawable == null)
        {
          paramLayout = paramDrawable;
          if (paramaa.f() != null)
          {
            ((c)getAdapter()).a(paramaa, paramaa.f());
            paramLayout = paramaa.g();
          }
        }
        if (paramLayout == null) {
          break label731;
        }
      }
    }
    label692:
    label698:
    label707:
    label719:
    label731:
    for (paramaa = BitmapFactory.decodeByteArray(paramLayout, 0, paramLayout.length);; paramaa = this.z)
    {
      if (paramaa != null)
      {
        paramDrawable = new RectF(0.0F, 0.0F, paramaa.getWidth(), paramaa.getHeight());
        RectF localRectF = new RectF(localRect1.left, localRect1.top, localRect1.left + i5, localRect1.top + i5);
        paramLayout = new Matrix();
        paramLayout.setRectToRect(paramDrawable, localRectF, Matrix.ScaleToFit.FILL);
        i3 = localCanvas.saveLayer(localRectF, null, 31);
        float f1 = (localRectF.right - localRectF.left) / 2.0F;
        localCanvas.drawCircle(localRectF.left + f1, localRectF.top + f1, f1, AvatarView.getMaskPaint());
        paramDrawable = paramTextPaint.getXfermode();
        paramTextPaint.setXfermode(AvatarView.getMaskXfermode());
        localCanvas.drawBitmap(paramaa, paramLayout, paramTextPaint);
        paramTextPaint.setXfermode(paramDrawable);
        localCanvas.restoreToCount(i3);
      }
      paramTextPaint.setColor(paramInt);
      localCanvas.drawText(localCharSequence, 0, localCharSequence.length(), i4 + (i5 + localRect1.left), a((String)localCharSequence, paramTextPaint, i7), paramTextPaint);
      if (!paramBoolean) {
        break label739;
      }
      this.s.setBounds(i9 - localRect2.right - i8, localRect2.top, i9 - localRect2.right, i7 - localRect2.bottom);
      this.s.draw(localCanvas);
      return localBitmap;
      i2 = 0;
      break;
      i3 = 0;
      break label51;
      i4 = 0;
      i5 = 0;
      break label160;
      i1 = this.S.getIntrinsicWidth();
      break label207;
      i6 = (int)paramLayout[0];
      i1 = 0;
      break label214;
    }
    label739:
    if (i2 != 0) {}
    for (paramaa = this.R;; paramaa = this.S)
    {
      paramInt = (int)((this.b - paramaa.getIntrinsicHeight()) / 2.0F);
      i2 = i9 - localRect1.right - i6 + (i6 - i1) / 2;
      paramaa.setBounds(i2, paramInt, i2 + i1, (int)(this.b - paramInt));
      paramaa.draw(localCanvas);
      return localBitmap;
    }
    label824:
    Log.w("RecipientEditTextView", "Unable to draw a background for the chips as it was never set");
    return localBitmap;
  }
  
  private Rect a(Drawable paramDrawable)
  {
    if (paramDrawable == this.r)
    {
      if (this.T == null)
      {
        this.T = new Rect();
        this.r.getPadding(this.T);
      }
      return this.T;
    }
    if (paramDrawable == this.t)
    {
      if (this.U == null)
      {
        this.U = new Rect();
        this.t.getPadding(this.U);
      }
      return this.U;
    }
    if (this.V == null)
    {
      this.V = new Rect();
      this.u.getPadding(this.V);
    }
    return this.V;
  }
  
  private z a(aa paramaa, int paramInt, boolean paramBoolean)
  {
    if (this.r == null) {
      throw new NullPointerException("Unable to render any chips as setChipDimensions was not called.");
    }
    Object localObject = getLayout();
    TextPaint localTextPaint = getPaint();
    float f1 = localTextPaint.getTextSize();
    int i1 = localTextPaint.getColor();
    Typeface localTypeface = localTextPaint.getTypeface();
    localTextPaint.setTypeface(this.W);
    if (paramBoolean) {}
    for (localObject = a(paramaa, localTextPaint, (Layout)localObject);; localObject = b(paramaa, localTextPaint, (Layout)localObject))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
      localBitmapDrawable.setBounds(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      paramaa = new z(localBitmapDrawable, paramaa, paramInt);
      localTextPaint.setTextSize(f1);
      localTextPaint.setColor(i1);
      localTextPaint.setTypeface(localTypeface);
      return paramaa;
    }
  }
  
  private CharSequence a(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat)
  {
    paramTextPaint.setTextSize(this.v);
    if ((paramFloat <= 0.0F) && (Log.isLoggable("RecipientEditTextView", 3))) {
      Log.d("RecipientEditTextView", "Max width is negative: " + paramFloat);
    }
    return TextUtils.ellipsize(paramCharSequence, paramTextPaint, paramFloat, TextUtils.TruncateAt.END);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, com.ideashower.readitlater.b.RecipientEditTextView, 0, 0);
    Resources localResources = getContext().getResources();
    this.r = paramAttributeSet.getDrawable(1);
    if (this.r == null) {
      this.r = localResources.getDrawable(2130837530);
    }
    this.u = paramAttributeSet.getDrawable(2);
    if (this.u == null) {
      this.u = localResources.getDrawable(2130837554);
    }
    this.s = paramAttributeSet.getDrawable(3);
    if (this.s == null) {
      this.s = localResources.getDrawable(2130837555);
    }
    this.w = paramAttributeSet.getDimensionPixelSize(5, -1);
    if (this.w == -1) {
      this.w = ((int)localResources.getDimension(2131296272));
    }
    this.y = paramAttributeSet.getResourceId(4, -1);
    if (this.y == -1) {
      this.y = 2130903078;
    }
    this.z = BitmapFactory.decodeResource(localResources, 2130837650);
    this.B = ((TextView)LayoutInflater.from(getContext()).inflate(2130903086, null));
    this.b = paramAttributeSet.getDimensionPixelSize(6, -1);
    if (this.b == -1.0F) {
      this.b = localResources.getDimension(2131296269);
    }
    this.c = paramAttributeSet.getDimensionPixelSize(7, -1);
    if (this.c == -1.0F) {
      this.c = localResources.getDimension(2131296270);
    }
    this.v = paramAttributeSet.getDimensionPixelSize(8, -1);
    if (this.v == -1.0F) {
      this.v = localResources.getDimension(2131296278);
    }
    this.t = paramAttributeSet.getDrawable(0);
    if (this.t == null) {
      this.t = localResources.getDrawable(2130837552);
    }
    this.d = paramContext.getResources().getDimension(2131296312);
    paramAttributeSet.recycle();
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (!this.E) && (hasFocus()) && (enoughToFilter()) && (paramInt2 - paramInt1 > 0) && (!b(paramInt1, paramInt2));
  }
  
  private Bitmap b(aa paramaa, TextPaint paramTextPaint, Layout paramLayout)
  {
    return a(paramaa, paramTextPaint, paramLayout, b(paramaa, false), q, false);
  }
  
  private Drawable b(aa paramaa, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.u;
    }
    if (c(paramaa)) {
      return this.r;
    }
    return this.t;
  }
  
  private void b(int paramInt1, int paramInt2, Editable paramEditable)
  {
    if (b(paramInt1, paramInt2)) {}
    do
    {
      return;
      str = paramEditable.toString().substring(paramInt1, paramInt2);
      localObject = str;
      if (str.trim().lastIndexOf(',') == str.length() - 1) {
        localObject = str.substring(0, str.length() - 1);
      }
      localObject = d((String)localObject);
    } while (localObject == null);
    String str = d((aa)localObject);
    int i2 = str.length();
    SpannableString localSpannableString = new SpannableString(str);
    int i1 = getSelectionEnd();
    if (this.e != null) {}
    for (i1 = this.e.findTokenStart(getText(), i1);; i1 = 0)
    {
      try
      {
        if (this.E) {
          break label249;
        }
        localObject = a((aa)localObject, i1, false);
      }
      catch (NullPointerException localNullPointerException1)
      {
        for (;;)
        {
          localObject = null;
          Log.e("RecipientEditTextView", localNullPointerException1.getMessage(), localNullPointerException1);
          continue;
          localObject = null;
        }
      }
      try
      {
        localSpannableString.setSpan(localObject, 0, i2 - 1, 33);
        paramEditable.replace(paramInt1, paramInt2, localSpannableString);
        if (localObject == null) {
          break;
        }
        if (this.F == null) {
          this.F = new ArrayList();
        }
        ((z)localObject).a(localSpannableString.toString());
        this.F.add(localObject);
        return;
      }
      catch (NullPointerException localNullPointerException2)
      {
        break label227;
      }
    }
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if (this.E) {
      return true;
    }
    z[] arrayOfz = (z[])getSpannable().getSpans(paramInt1, paramInt2, z.class);
    return (arrayOfz != null) && (arrayOfz.length != 0);
  }
  
  private boolean b(z paramz, int paramInt, float paramFloat1, float paramFloat2)
  {
    return (paramz.a()) && (paramInt == f(paramz));
  }
  
  private boolean b(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    int i1;
    do
    {
      do
      {
        return false;
        i1 = paramCharSequence.length();
        int i2 = this.e.findTokenStart(paramCharSequence, i1);
        paramCharSequence = paramCharSequence.toString().substring(i2, i1).trim();
      } while (TextUtils.isEmpty(paramCharSequence));
      i1 = paramCharSequence.charAt(paramCharSequence.length() - 1);
    } while ((i1 != 44) && (i1 != 59));
    return true;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      dismissDropDown();
      return;
    }
    Editable localEditable = getText();
    setSelection(paramInt2);
    Object localObject = getText().toString().substring(paramInt1, paramInt2);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = aa.a((String)localObject);
      QwertyKeyListener.markAsReplaced(localEditable, paramInt1, paramInt2, "");
      localObject = a((aa)localObject, false);
      paramInt2 = getSelectionEnd();
      if ((localObject != null) && (paramInt1 > -1) && (paramInt2 > -1)) {
        localEditable.replace(paramInt1, paramInt2, (CharSequence)localObject);
      }
    }
    dismissDropDown();
  }
  
  private boolean c(aa paramaa)
  {
    return (paramaa.i() != null) || ((this.x != null) && (this.x.isValid(paramaa.c())));
  }
  
  private static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Patterns.PHONE.matcher(paramString).matches();
  }
  
  private aa d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = Rfc822Tokenizer.tokenize(paramString);
    String str;
    if ((e(paramString)) && (localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if (com.pocket.h.b.a((Rfc822Token)localObject)) {
        return aa.a(com.pocket.h.b.c((Rfc822Token)localObject));
      }
      str = ((Rfc822Token)localObject).getName();
      if (!TextUtils.isEmpty(str)) {
        return aa.a(str, paramString);
      }
      localObject = ((Rfc822Token)localObject).getAddress();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return aa.a((String)localObject);
      }
    }
    if ((this.x != null) && (!this.x.isValid(paramString)))
    {
      str = this.x.fixText(paramString).toString();
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        if (!str.contains(paramString)) {
          break label170;
        }
        Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(str);
        localObject = str;
        if (arrayOfRfc822Token.length > 0) {
          localObject = arrayOfRfc822Token[0].getAddress();
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        return aa.a((String)localObject);
        label170:
        localObject = null;
        break;
        localObject = paramString;
      }
      localObject = null;
    }
  }
  
  private String d(aa paramaa)
  {
    String str1 = paramaa.b();
    String str3 = paramaa.c();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.equals(str1, str3))) {
      str1 = null;
    }
    for (;;)
    {
      String str2 = str3;
      if (str3 != null)
      {
        Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(str3);
        str2 = str3;
        if (arrayOfRfc822Token != null)
        {
          str2 = str3;
          if (arrayOfRfc822Token.length > 0) {
            str2 = arrayOfRfc822Token[0].getAddress();
          }
        }
      }
      paramaa = paramaa.i();
      if (paramaa != null) {
        if (paramaa.m()) {
          paramaa = com.pocket.h.b.a(paramaa);
        }
      }
      for (;;)
      {
        str1 = paramaa.toString().trim();
        int i1 = str1.indexOf(",");
        paramaa = str1;
        if (this.e != null)
        {
          paramaa = str1;
          if (!TextUtils.isEmpty(str1))
          {
            paramaa = str1;
            if (i1 < str1.length() - 1) {
              paramaa = (String)this.e.terminateToken(str1);
            }
          }
        }
        return paramaa;
        paramaa = new Rfc822Token(null, paramaa.h(), null);
        continue;
        paramaa = new Rfc822Token(str1, str2, null);
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (this.J != null) {
      this.J.scrollBy(0, a(paramInt));
    }
  }
  
  private int e(int paramInt)
  {
    Editable localEditable = getText();
    int i2 = localEditable.length();
    int i1 = i2 - 1;
    while ((i1 >= 0) && (localEditable.charAt(i1) == ' '))
    {
      i2 -= 1;
      i1 -= 1;
    }
    if (paramInt >= i2)
    {
      i1 = paramInt;
      return i1;
    }
    localEditable = getText();
    for (;;)
    {
      i1 = paramInt;
      if (paramInt < 0) {
        break;
      }
      i1 = paramInt;
      if (a(localEditable, paramInt) != -1) {
        break;
      }
      i1 = paramInt;
      if (c(paramInt) != null) {
        break;
      }
      paramInt -= 1;
    }
  }
  
  private void e()
  {
    if (this.e == null) {
      return;
    }
    if ((this.f != null) && (this.f.e().d() != -1L))
    {
      p();
      r();
      return;
    }
    if (getWidth() <= 0)
    {
      this.g.removeCallbacks(this.N);
      this.g.post(this.N);
      return;
    }
    if (this.D > 0) {
      h();
    }
    for (;;)
    {
      this.g.post(this.n);
      break;
      Editable localEditable = getText();
      int i3 = getSelectionEnd();
      int i4 = this.e.findTokenStart(localEditable, i3);
      Object localObject = (z[])getSpannable().getSpans(i4, i3, z.class);
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = getText();
        int i2 = this.e.findTokenEnd((CharSequence)localObject, i4);
        int i1 = i2;
        if (i2 < ((Editable)localObject).length())
        {
          i1 = i2;
          if (((Editable)localObject).charAt(i2) == ',') {
            i1 = i2 + 1;
          }
        }
        if (i1 != getSelectionEnd()) {
          c(i4, i1);
        } else {
          a(i4, i3, localEditable);
        }
      }
    }
  }
  
  private boolean e(String paramString)
  {
    if (this.x == null) {
      return true;
    }
    return this.x.isValid(paramString);
  }
  
  private int f(z paramz)
  {
    return getSpannable().getSpanEnd(paramz);
  }
  
  private void f()
  {
    s();
    setCursorVisible(true);
    Editable localEditable = getText();
    if ((localEditable != null) && (localEditable.length() > 0)) {}
    for (int i1 = localEditable.length();; i1 = 0)
    {
      setSelection(i1);
      if ((this.F != null) && (this.F.size() > 0))
      {
        new q(this, null).execute(new Void[0]);
        this.F = null;
      }
      return;
    }
  }
  
  private void f(int paramInt)
  {
    Object localObject = b((aa)getAdapter().getItem(paramInt));
    if (localObject == null) {
      return;
    }
    clearComposingText();
    paramInt = getSelectionEnd();
    int i1 = this.e.findTokenStart(getText(), paramInt);
    Editable localEditable = getText();
    QwertyKeyListener.markAsReplaced(localEditable, i1, paramInt, "");
    localObject = a((aa)localObject, false);
    if ((localObject != null) && (i1 >= 0) && (paramInt >= 0)) {
      localEditable.replace(i1, paramInt, (CharSequence)localObject);
    }
    o();
    post(new Runnable()
    {
      public void run()
      {
        n.this.showDropDown();
      }
    });
  }
  
  private p g(int paramInt)
  {
    Object localObject = String.format(this.B.getText().toString(), new Object[] { Integer.valueOf(paramInt) });
    TextPaint localTextPaint = new TextPaint(getPaint());
    localTextPaint.setTextSize(this.B.getTextSize());
    localTextPaint.setColor(this.B.getCurrentTextColor());
    int i2 = (int)localTextPaint.measureText((String)localObject) + this.B.getPaddingLeft() + this.B.getPaddingRight();
    int i1 = getLineHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i2, i1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Layout localLayout = getLayout();
    if (localLayout != null) {}
    for (paramInt = i1 - localLayout.getLineDescent(0);; paramInt = i1)
    {
      localCanvas.drawText((String)localObject, 0, ((String)localObject).length(), 0.0F, paramInt, localTextPaint);
      localObject = new BitmapDrawable(getResources(), localBitmap);
      ((Drawable)localObject).setBounds(0, 0, i2, i1);
      return new p(this, (Drawable)localObject);
    }
  }
  
  private z g(z paramz)
  {
    Object localObject;
    if (paramz.c() == -1L)
    {
      localObject = paramz.b();
      Editable localEditable = getText();
      d(paramz);
      localEditable.append((CharSequence)localObject);
      setCursorVisible(true);
      setSelection(localEditable.length());
      return new z(null, aa.a((String)localObject), -1);
    }
    if (paramz.c() == -2L)
    {
      i1 = a(paramz);
      i2 = f(paramz);
      getSpannable().removeSpan(paramz);
      for (;;)
      {
        try
        {
          if (this.E) {
            return null;
          }
          paramz = a(paramz.e(), i1, true);
          localObject = getText();
          QwertyKeyListener.markAsReplaced((Spannable)localObject, i1, i2, "");
          if ((i1 == -1) || (i2 == -1))
          {
            Log.d("RecipientEditTextView", "The chip being selected no longer exists but should.");
            paramz.a(true);
            if (paramz.e().d() == -1L) {
              d(getLayout().getLineForOffset(a(paramz)));
            }
            a(paramz, getWidth(), getContext());
            setCursorVisible(false);
            return paramz;
          }
        }
        catch (NullPointerException paramz)
        {
          Log.e("RecipientEditTextView", paramz.getMessage(), paramz);
          return null;
        }
        ((Editable)localObject).setSpan(paramz, i1, i2, 33);
      }
    }
    int i1 = a(paramz);
    int i2 = f(paramz);
    getSpannable().removeSpan(paramz);
    for (;;)
    {
      try
      {
        paramz = a(paramz.e(), i1, true);
        localObject = getText();
        QwertyKeyListener.markAsReplaced((Spannable)localObject, i1, i2, "");
        if ((i1 == -1) || (i2 == -1))
        {
          Log.d("RecipientEditTextView", "The chip being selected no longer exists but should.");
          paramz.a(true);
          if (paramz.e().d() == -1L) {
            d(getLayout().getLineForOffset(a(paramz)));
          }
          if (com.ideashower.readitlater.util.a.e()) {}
          setCursorVisible(false);
          return paramz;
        }
      }
      catch (NullPointerException paramz)
      {
        Log.e("RecipientEditTextView", paramz.getMessage(), paramz);
        return null;
      }
      ((Editable)localObject).setSpan(paramz, i1, i2, 33);
    }
  }
  
  private void g()
  {
    z[] arrayOfz = getSortedRecipients();
    if (arrayOfz != null)
    {
      int i2 = arrayOfz.length;
      int i1 = 0;
      while (i1 < i2)
      {
        z localz = arrayOfz[i1];
        a(localz, localz.e());
        i1 += 1;
      }
    }
  }
  
  private Collection getContactIds()
  {
    HashSet localHashSet = new HashSet();
    z[] arrayOfz = getSortedRecipients();
    if (arrayOfz != null)
    {
      int i2 = arrayOfz.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localHashSet.add(Long.valueOf(arrayOfz[i1].c()));
        i1 += 1;
      }
    }
    return localHashSet;
  }
  
  private Collection getDataIds()
  {
    HashSet localHashSet = new HashSet();
    z[] arrayOfz = getSortedRecipients();
    if (arrayOfz != null)
    {
      int i2 = arrayOfz.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localHashSet.add(Long.valueOf(arrayOfz[i1].d()));
        i1 += 1;
      }
    }
    return localHashSet;
  }
  
  private z getLastChip()
  {
    Object localObject2 = null;
    z[] arrayOfz = getSortedRecipients();
    Object localObject1 = localObject2;
    if (arrayOfz != null)
    {
      localObject1 = localObject2;
      if (arrayOfz.length > 0) {
        localObject1 = arrayOfz[(arrayOfz.length - 1)];
      }
    }
    return (z)localObject1;
  }
  
  private ImageSpan getMoreChip()
  {
    p[] arrayOfp = (p[])getSpannable().getSpans(0, getText().length(), p.class);
    if ((arrayOfp != null) && (arrayOfp.length > 0)) {
      return arrayOfp[0];
    }
    return null;
  }
  
  private z[] getSortedRecipients()
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList((z[])getSpannable().getSpans(0, getText().length(), z.class)));
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(z paramAnonymousz1, z paramAnonymousz2)
      {
        int i = this.a.getSpanStart(paramAnonymousz1);
        int j = this.a.getSpanStart(paramAnonymousz2);
        if (i < j) {
          return -1;
        }
        if (i > j) {
          return 1;
        }
        return 0;
      }
    });
    return (z[])localArrayList.toArray(new z[localArrayList.size()]);
  }
  
  private int getViewWidth()
  {
    return getWidth();
  }
  
  private int h(int paramInt)
  {
    if (paramInt >= length()) {}
    int i1;
    do
    {
      do
      {
        return paramInt;
        int i2 = getText().toString().charAt(paramInt);
        if (i2 != 44)
        {
          i1 = paramInt;
          if (i2 != 59) {}
        }
        else
        {
          i1 = paramInt + 1;
        }
        paramInt = i1;
      } while (i1 >= length());
      paramInt = i1;
    } while (getText().toString().charAt(i1) != ' ');
    return i1 + 1;
  }
  
  private void h()
  {
    this.g.removeCallbacks(this.M);
    this.g.post(this.M);
  }
  
  private void i()
  {
    z[] arrayOfz = getSortedRecipients();
    if (arrayOfz != null)
    {
      int i2 = arrayOfz.length;
      int i1 = 0;
      while (i1 < i2)
      {
        z localz = arrayOfz[i1];
        Rect localRect = localz.getDrawable().getBounds();
        if ((getWidth() > 0) && (localRect.right - localRect.left > getWidth())) {
          a(localz, localz.e());
        }
        i1 += 1;
      }
    }
  }
  
  private void j()
  {
    if (getViewWidth() <= 0) {}
    while (this.D <= 0) {
      return;
    }
    for (;;)
    {
      synchronized (this.C)
      {
        Editable localEditable = getText();
        if (this.D <= 50)
        {
          int i1 = 0;
          if (i1 < this.C.size())
          {
            String str = (String)this.C.get(i1);
            int i4 = localEditable.toString().indexOf(str);
            int i3 = str.length() + i4;
            if (i4 >= 0)
            {
              int i2 = i3;
              if (i3 < localEditable.length() - 2)
              {
                i2 = i3;
                if (localEditable.charAt(i3) == ',') {
                  i2 = i3 + 1;
                }
              }
              b(i4, i2, localEditable);
            }
            this.D -= 1;
            i1 += 1;
            continue;
          }
          k();
          if ((this.F == null) || (this.F.size() <= 0) || (this.F.size() > 50)) {
            break label306;
          }
          if ((!hasFocus()) && (this.F.size() >= 2)) {
            break label256;
          }
          new q(this, null).execute(new Void[0]);
          this.F = null;
          this.D = 0;
          this.C.clear();
          return;
        }
      }
      this.E = true;
      continue;
      label256:
      this.L = new o(this);
      this.L.execute(new Object[] { new ArrayList(this.F.subList(0, 2)) });
      r();
      continue;
      label306:
      this.F = null;
      r();
    }
  }
  
  private void k()
  {
    if (this.D > 0) {}
    do
    {
      return;
      localObject = getSortedRecipients();
    } while ((localObject == null) || (localObject.length <= 0));
    this.A = getMoreChip();
    if (this.A != null) {}
    for (Object localObject = this.A;; localObject = getLastChip())
    {
      int i1 = getSpannable().getSpanEnd(localObject);
      localObject = getText();
      int i2 = ((Editable)localObject).length();
      if (i2 <= i1) {
        break;
      }
      if (Log.isLoggable("RecipientEditTextView", 3)) {
        Log.d("RecipientEditTextView", "There were extra characters after the last tokenizable entry." + localObject);
      }
      ((Editable)localObject).delete(i1 + 1, i2);
      return;
    }
  }
  
  private boolean l()
  {
    View localView = focusSearch(130);
    if (localView != null)
    {
      localView.requestFocus();
      return true;
    }
    return false;
  }
  
  private boolean m()
  {
    if (this.e == null) {}
    Editable localEditable;
    int i1;
    int i2;
    do
    {
      return false;
      localEditable = getText();
      i1 = getSelectionEnd();
      i2 = this.e.findTokenStart(localEditable, i1);
    } while (!a(i2, i1));
    int i3 = this.e.findTokenEnd(getText(), i2);
    if (i3 != getSelectionEnd())
    {
      c(i2, i3);
      return true;
    }
    return a(i2, i1, localEditable);
  }
  
  private void n()
  {
    if (this.e == null) {
      return;
    }
    Editable localEditable = getText();
    int i1 = getSelectionEnd();
    int i2 = this.e.findTokenStart(localEditable, i1);
    if (a(i2, i1)) {
      a(i2, i1, localEditable);
    }
    setSelection(getText().length());
  }
  
  private void o()
  {
    if (this.D > 0) {}
    for (;;)
    {
      return;
      z[] arrayOfz = getSortedRecipients();
      if ((arrayOfz != null) && (arrayOfz.length > 0))
      {
        z localz = arrayOfz[(arrayOfz.length - 1)];
        Object localObject = null;
        if (arrayOfz.length > 1) {
          localObject = arrayOfz[(arrayOfz.length - 2)];
        }
        int i3 = getSpannable().getSpanStart(localz);
        int i2;
        if (localObject != null)
        {
          i2 = getSpannable().getSpanEnd(localObject);
          localObject = getText();
          if ((i2 == -1) || (i2 > ((Editable)localObject).length() - 1)) {
            continue;
          }
          i1 = i2;
          if (((Editable)localObject).charAt(i2) != ' ') {}
        }
        for (int i1 = i2 + 1; (i1 >= 0) && (i3 >= 0) && (i1 < i3); i1 = 0)
        {
          getText().delete(i1, i3);
          return;
        }
      }
    }
  }
  
  private void p()
  {
    if (this.f != null)
    {
      c(this.f);
      this.f = null;
    }
    setCursorVisible(true);
  }
  
  private void q()
  {
    Editable localEditable = getText();
    int i1 = 0;
    int i2 = 0;
    for (int i3 = 0; i1 < 2; i3 = i2)
    {
      i2 = h(this.e.findTokenEnd(localEditable, i3));
      i1 += 1;
    }
    p localp = g(a(localEditable) - 2);
    SpannableString localSpannableString = new SpannableString(localEditable.subSequence(i2, localEditable.length()));
    localSpannableString.setSpan(localp, 0, localSpannableString.length(), 33);
    localEditable.replace(i2, localEditable.length(), localSpannableString);
    this.A = localp;
  }
  
  private void r()
  {
    if (this.E) {
      q();
    }
    while (!this.H) {
      return;
    }
    Object localObject1 = (ImageSpan[])getSpannable().getSpans(0, getText().length(), p.class);
    if (localObject1.length > 0) {
      getSpannable().removeSpan(localObject1[0]);
    }
    Object localObject2 = getSortedRecipients();
    if ((localObject2 == null) || (localObject2.length <= 2))
    {
      this.A = null;
      return;
    }
    Spannable localSpannable = getSpannable();
    int i4 = localObject2.length;
    int i5 = i4 - 2;
    localObject1 = g(i5);
    this.G = new ArrayList();
    Editable localEditable = getText();
    int i2 = i4 - i5;
    int i1 = 0;
    int i3 = 0;
    while (i2 < localObject2.length)
    {
      this.G.add(localObject2[i2]);
      if (i2 == i4 - i5) {
        i3 = localSpannable.getSpanStart(localObject2[i2]);
      }
      if (i2 == localObject2.length - 1) {
        i1 = localSpannable.getSpanEnd(localObject2[i2]);
      }
      if ((this.F == null) || (!this.F.contains(localObject2[i2])))
      {
        int i6 = localSpannable.getSpanStart(localObject2[i2]);
        int i7 = localSpannable.getSpanEnd(localObject2[i2]);
        localObject2[i2].a(localEditable.toString().substring(i6, i7));
      }
      localSpannable.removeSpan(localObject2[i2]);
      i2 += 1;
    }
    i2 = i1;
    if (i1 < localEditable.length()) {
      i2 = localEditable.length();
    }
    i1 = Math.max(i3, i2);
    i2 = Math.min(i3, i2);
    localObject2 = new SpannableString(localEditable.subSequence(i2, i1));
    ((SpannableString)localObject2).setSpan(localObject1, 0, ((SpannableString)localObject2).length(), 33);
    localEditable.replace(i2, i1, (CharSequence)localObject2);
    this.A = ((ImageSpan)localObject1);
  }
  
  private void s()
  {
    if (this.A != null)
    {
      localObject1 = getSpannable();
      ((Spannable)localObject1).removeSpan(this.A);
      this.A = null;
      if ((this.G != null) && (this.G.size() > 0))
      {
        localObject2 = getSortedRecipients();
        if ((localObject2 != null) && (localObject2.length != 0)) {
          break label62;
        }
      }
    }
    return;
    label62:
    int i1 = ((Spannable)localObject1).getSpanEnd(localObject2[(localObject2.length - 1)]);
    Object localObject1 = getText();
    Object localObject2 = this.G.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      z localz = (z)((Iterator)localObject2).next();
      String str = (String)localz.f();
      int i2 = localObject1.toString().indexOf(str, i1);
      i1 = Math.min(((Editable)localObject1).length(), str.length() + i2);
      if (i2 != -1) {
        ((Editable)localObject1).setSpan(localz, i2, i1, 33);
      }
    }
    this.G.clear();
  }
  
  private void setChipBackground(Drawable paramDrawable)
  {
    this.r = paramDrawable;
  }
  
  private void setChipHeight(int paramInt)
  {
    this.b = paramInt;
  }
  
  private void setMoreItem(TextView paramTextView)
  {
    this.B = paramTextView;
  }
  
  private boolean t()
  {
    return (this.D > 0) || ((this.G != null) && (this.G.size() > 0));
  }
  
  private void u()
  {
    if (this.J != null) {
      this.J.scrollBy(0, (int)(getLineCount() * this.b));
    }
  }
  
  private void v()
  {
    ArrayList localArrayList = c();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      new o(this).execute(new Object[] { localArrayList });
    }
  }
  
  protected int a(int paramInt)
  {
    return -((getLineCount() - (paramInt + 1)) * (int)this.b + getPaddingBottom() + getPaddingTop()) + getDropDownVerticalOffset();
  }
  
  protected int a(z paramz)
  {
    return getSpannable().getSpanStart(paramz);
  }
  
  protected Dialog a(Context paramContext)
  {
    return new Dialog(paramContext);
  }
  
  protected CharSequence a(aa paramaa, boolean paramBoolean)
  {
    Object localObject = d(paramaa);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    int i1 = getSelectionEnd();
    i1 = this.e.findTokenStart(getText(), i1);
    int i2 = ((String)localObject).length();
    localObject = new SpannableString((CharSequence)localObject);
    if (!this.E) {}
    try
    {
      paramaa = a(paramaa, i1, paramBoolean);
      ((SpannableString)localObject).setSpan(paramaa, 0, i2 - 1, 33);
      paramaa.a(((SpannableString)localObject).toString());
      return (CharSequence)localObject;
    }
    catch (NullPointerException paramaa)
    {
      com.ideashower.readitlater.util.e.a(paramaa);
    }
    return null;
  }
  
  protected String a(aa paramaa)
  {
    Object localObject1 = paramaa.b();
    Object localObject2 = paramaa.c();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramaa = (aa)localObject1;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
    }
    else
    {
      paramaa = null;
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      if (d())
      {
        localObject1 = localObject2;
        if (c((String)localObject2)) {}
      }
      else
      {
        Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize((CharSequence)localObject2);
        localObject1 = localObject2;
        if (arrayOfRfc822Token != null)
        {
          localObject1 = localObject2;
          if (arrayOfRfc822Token.length > 0) {
            localObject1 = arrayOfRfc822Token[0].getAddress();
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramaa)) {
      localObject2 = paramaa;
    }
    do
    {
      return (String)localObject2;
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    return new Rfc822Token(paramaa, (String)localObject1, null).toString();
  }
  
  protected String a(String paramString)
  {
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramString);
    String str = paramString;
    if (arrayOfRfc822Token != null)
    {
      str = paramString;
      if (arrayOfRfc822Token.length > 0) {
        str = arrayOfRfc822Token[0].getAddress();
      }
    }
    return str;
  }
  
  protected abstract void a();
  
  protected abstract void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong);
  
  public void a(z paramz, int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramz.a())
    {
      if (b(paramz, paramInt, paramFloat1, paramFloat2)) {
        d(paramz);
      }
    }
    else {
      return;
    }
    p();
  }
  
  protected abstract void a(z paramz, int paramInt, Context paramContext);
  
  protected void a(z paramz, aa paramaa)
  {
    int i1;
    int i3;
    int i2;
    if (paramz == this.f)
    {
      i1 = 1;
      if (i1 != 0) {
        this.f = null;
      }
      i3 = a(paramz);
      i2 = f(paramz);
      getSpannable().removeSpan(paramz);
      paramz = getText();
      paramaa = a(paramaa, false);
      if (paramaa != null)
      {
        if ((i3 != -1) && (i2 != -1)) {
          break label109;
        }
        Log.e("RecipientEditTextView", "The chip to replace does not exist but should.");
        paramz.insert(0, paramaa);
      }
    }
    for (;;)
    {
      setCursorVisible(true);
      if (i1 != 0) {
        p();
      }
      return;
      i1 = 0;
      break;
      label109:
      if (!TextUtils.isEmpty(paramaa))
      {
        while ((i2 >= 0) && (i2 < paramz.length()) && (paramz.charAt(i2) == ' ')) {
          i2 += 1;
        }
        paramz.replace(i3, i2, paramaa);
      }
    }
  }
  
  protected void a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return;
    }
    int i1 = getSelectionStart();
    int i2 = getSelectionEnd();
    Editable localEditable = getText();
    if ((i1 >= 0) && (i2 >= 0) && (i1 != i2)) {
      localEditable.append(paramCharSequence, i1, i2);
    }
    for (;;)
    {
      v();
      return;
      localEditable.insert(i2, paramCharSequence);
    }
  }
  
  protected boolean a(int paramInt1, int paramInt2, Editable paramEditable)
  {
    Object localObject = getAdapter();
    if ((localObject != null) && (((ListAdapter)localObject).getCount() > 0) && (enoughToFilter()) && (paramInt2 - paramInt1 > 0) && (paramInt2 == getSelectionEnd()) && (!d()))
    {
      f(0);
      dismissDropDown();
      return true;
    }
    int i2 = this.e.findTokenEnd(paramEditable, paramInt1);
    int i1 = i2;
    if (paramEditable.length() > i2 + 1)
    {
      int i3 = paramEditable.charAt(i2 + 1);
      if (i3 != 44)
      {
        i1 = i2;
        if (i3 != 59) {}
      }
      else
      {
        i1 = i2 + 1;
      }
    }
    localObject = paramEditable.toString().substring(paramInt1, i1).trim();
    clearComposingText();
    if ((localObject != null) && (((String)localObject).length() > 0) && (!((String)localObject).equals(" ")))
    {
      localObject = d((String)localObject);
      if (localObject != null)
      {
        QwertyKeyListener.markAsReplaced(paramEditable, paramInt1, paramInt2, "");
        localObject = a((aa)localObject, false);
        if ((localObject != null) && (paramInt1 > -1) && (paramInt2 > -1)) {
          paramEditable.replace(paramInt1, paramInt2, (CharSequence)localObject);
        }
      }
      if (paramInt2 == getSelectionEnd()) {
        dismissDropDown();
      }
      o();
      return true;
    }
    return false;
  }
  
  public void append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (this.l != null) {
      removeTextChangedListener(this.l);
    }
    super.append(paramCharSequence, paramInt1, paramInt2);
    if ((!TextUtils.isEmpty(paramCharSequence)) && (TextUtils.getTrimmedLength(paramCharSequence) > 0))
    {
      String str = paramCharSequence.toString();
      if ((str.indexOf(',') != 0) && (!TextUtils.isEmpty(str)) && (TextUtils.getTrimmedLength(str) > 0))
      {
        this.D += 1;
        this.C.add(paramCharSequence.toString());
      }
    }
    if (this.D > 0) {
      h();
    }
    this.g.post(this.n);
  }
  
  protected ListAdapter b(z paramz)
  {
    return new ab(getContext(), this.y, paramz.e());
  }
  
  protected aa b(aa paramaa)
  {
    aa localaa;
    if (paramaa == null) {
      localaa = null;
    }
    String str;
    do
    {
      do
      {
        do
        {
          return localaa;
          str = paramaa.c();
          localaa = paramaa;
        } while (!aa.a(paramaa.d()));
        if ((TextUtils.isEmpty(paramaa.b())) || (TextUtils.equals(paramaa.b(), str))) {
          break;
        }
        localaa = paramaa;
      } while (this.x == null);
      localaa = paramaa;
    } while (this.x.isValid(str));
    return aa.a(str);
  }
  
  protected void b()
  {
    a(com.ideashower.readitlater.objects.e.a(getContext()).a());
  }
  
  public void b(int paramInt)
  {
    ListView localListView = getAlternatesListView();
    if (((localListView != null) && (localListView.getCheckedItemPositions() == null)) || (localListView.getCheckedItemPositions().size() == 0)) {
      localListView.setItemChecked(paramInt, true);
    }
    this.k = paramInt;
  }
  
  protected void b(String paramString)
  {
    this.i = paramString;
    this.h.setTitle(paramString);
    this.h.setContentView(2130903081);
    this.h.setCancelable(true);
    this.h.setCanceledOnTouchOutside(true);
    paramString = (Button)this.h.findViewById(16908313);
    paramString.setOnClickListener(this);
    if (d()) {}
    for (int i1 = 2131492996;; i1 = 2131492995)
    {
      paramString.setText(getContext().getResources().getString(i1));
      this.h.setOnDismissListener(this);
      this.h.show();
      return;
    }
  }
  
  protected z c(int paramInt)
  {
    int i1 = 0;
    z[] arrayOfz = (z[])getSpannable().getSpans(0, getText().length(), z.class);
    while (i1 < arrayOfz.length)
    {
      z localz = arrayOfz[i1];
      int i2 = a(localz);
      int i3 = f(localz);
      if ((paramInt >= i2) && (paramInt <= i3)) {
        return localz;
      }
      i1 += 1;
    }
    return null;
  }
  
  protected ArrayList c()
  {
    String str2 = getText().toString();
    int i3 = this.e.findTokenStart(str2, getSelectionEnd());
    String str1 = str2.substring(i3);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    int i1;
    int i2;
    if (i3 != 0)
    {
      localObject = null;
      i1 = i3;
      i2 = i3;
      while ((i1 != 0) && (localObject == null))
      {
        int i4 = this.e.findTokenStart(str2, i1);
        localObject = c(i4);
        i2 = i1;
        i1 = i4;
      }
      if (i1 != i3) {
        if (localObject == null) {
          break label226;
        }
      }
    }
    for (;;)
    {
      if (i2 < i3)
      {
        a(i2, h(this.e.findTokenEnd(str2, i2)), getText());
        localObject = c(i2);
        if (localObject != null) {}
      }
      else
      {
        if (b(str1))
        {
          localObject = getText();
          i1 = localObject.toString().indexOf(str1, i3);
          a(i1, ((Editable)localObject).length(), (Editable)localObject);
          localArrayList.add(c(i1));
        }
        return localArrayList;
      }
      i2 = getSpannable().getSpanEnd(localObject) + 1;
      localArrayList.add(localObject);
      continue;
      label226:
      i2 = i1;
    }
  }
  
  protected void c(z paramz)
  {
    int i1 = a(paramz);
    int i2 = f(paramz);
    Editable localEditable = getText();
    this.f = null;
    if ((i1 == -1) || (i2 == -1))
    {
      Log.w("RecipientEditTextView", "The chip doesn't exist or may be a chip a user was editing");
      setSelection(localEditable.length());
      m();
    }
    for (;;)
    {
      setCursorVisible(true);
      setSelection(localEditable.length());
      a();
      return;
      getSpannable().removeSpan(paramz);
      QwertyKeyListener.markAsReplaced(localEditable, i1, i2, "");
      localEditable.removeSpan(paramz);
      try
      {
        if (!this.E) {
          localEditable.setSpan(a(paramz.e(), i1, false), i1, i2, 33);
        }
      }
      catch (NullPointerException paramz)
      {
        Log.e("RecipientEditTextView", paramz.getMessage(), paramz);
      }
    }
  }
  
  protected void d(z paramz)
  {
    Spannable localSpannable = getSpannable();
    int i4 = localSpannable.getSpanStart(paramz);
    int i3 = localSpannable.getSpanEnd(paramz);
    Editable localEditable = getText();
    if (paramz == this.f) {}
    int i2;
    for (int i1 = 1;; i1 = 0)
    {
      i2 = i3;
      if (i1 != 0)
      {
        this.f = null;
        i2 = i3;
      }
      while ((i2 >= 0) && (i2 < localEditable.length()) && (localEditable.charAt(i2) == ' ')) {
        i2 += 1;
      }
    }
    localSpannable.removeSpan(paramz);
    if ((i4 >= 0) && (i2 > 0)) {
      localEditable.delete(i4, i2);
    }
    if (i1 != 0) {
      p();
    }
  }
  
  protected boolean d()
  {
    return false;
  }
  
  public void dismissDropDown()
  {
    super.dismissDropDown();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (!m.a(arrayOfInt, this.ac)) {
      g();
    }
    this.ac = arrayOfInt;
  }
  
  protected void e(z paramz) {}
  
  protected abstract ListView getAlternatesListView();
  
  public ArrayList getEntries()
  {
    int i1 = 0;
    Object localObject = getSpannable();
    if (((Spannable)localObject).length() == 0) {
      return null;
    }
    localObject = (z[])((Spannable)localObject).getSpans(0, getText().length(), z.class);
    if (localObject.length == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(localObject.length);
    int i2 = localObject.length;
    while (i1 < i2)
    {
      localArrayList.add(localObject[i1].e());
      i1 += 1;
    }
    return localArrayList;
  }
  
  public Spannable getSpannable()
  {
    return getText();
  }
  
  public void onClick(View paramView)
  {
    com.ideashower.readitlater.objects.e.a(getContext()).a(this.i, null);
    this.h.dismiss();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    int i1 = paramEditorInfo.imeOptions & 0xFF;
    if ((i1 & 0x6) != 0)
    {
      paramEditorInfo.imeOptions = (i1 ^ paramEditorInfo.imeOptions);
      paramEditorInfo.imeOptions |= 0x6;
    }
    if ((paramEditorInfo.imeOptions & 0x40000000) != 0) {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
    }
    paramEditorInfo.actionLabel = getContext().getString(2131493185);
    return localInputConnection;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.i = null;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (m()) {}
      do
      {
        return true;
        if (this.f != null)
        {
          p();
          return true;
        }
      } while (l());
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
    {
      e();
      return;
    }
    f();
    performFiltering(getText(), 0);
    showDropDown();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    f(paramInt);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.f != null) && (paramInt == 67)) {
      d(this.f);
    }
    if ((paramInt == 66) && (android.support.v4.view.o.a(paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.f != null))
    {
      p();
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      do
      {
        return bool;
        if (!android.support.v4.view.o.a(paramKeyEvent)) {
          break;
        }
      } while (m());
      if (this.f != null)
      {
        p();
        return true;
      }
      if (l())
      {
        return true;
        if (android.support.v4.view.o.a(paramKeyEvent))
        {
          if (this.f != null) {
            p();
          }
          while (l())
          {
            return true;
            m();
          }
        }
      }
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.f != null) {}
    do
    {
      do
      {
        return;
        paramMotionEvent = c(e(ap.a(this, paramMotionEvent.getX(), paramMotionEvent.getY())));
      } while (paramMotionEvent == null);
      if (this.m)
      {
        e(paramMotionEvent);
        return;
      }
    } while (!this.Q);
    b(paramMotionEvent.e().c());
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!TextUtils.isEmpty(getText()))
    {
      super.onRestoreInstanceState(null);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    p();
    return super.onSaveInstanceState();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onSelectionChanged(int paramInt1, int paramInt2)
  {
    z localz = getLastChip();
    if ((localz != null) && (paramInt1 < getSpannable().getSpanEnd(localz))) {
      setSelection(Math.min(getSpannable().getSpanEnd(localz) + 1, getText().length()));
    }
    super.onSelectionChanged(paramInt1, paramInt2);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (this.D <= 0) {
        break label73;
      }
      h();
    }
    while ((this.J == null) && (!this.K))
    {
      ViewParent localViewParent = getParent();
      for (;;)
      {
        if ((localViewParent != null) && (!(localViewParent instanceof ScrollView)))
        {
          localViewParent = localViewParent.getParent();
          continue;
          label73:
          i();
          break;
        }
      }
      if (localViewParent != null) {
        this.J = ((ScrollView)localViewParent);
      }
      this.K = true;
    }
    setDropDownWidth(getWidth() - getDropDownHorizontalOffset() - j.a(15.0F));
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt == 16908322)
    {
      b();
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!isFocused())
    {
      bool2 = super.onTouchEvent(paramMotionEvent);
      return bool2;
    }
    boolean bool1 = super.onTouchEvent(paramMotionEvent);
    int i2 = paramMotionEvent.getAction();
    if (this.f == null)
    {
      if ((i2 == 1) || (i2 == 2))
      {
        this.O = paramMotionEvent.getX();
        this.P = paramMotionEvent.getY();
      }
      this.I.onTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    int i1;
    if ((this.i == null) && (i2 == 1))
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i1 = e(ap.a(this, f1, f2));
      paramMotionEvent = c(i1);
      if (paramMotionEvent != null) {
        if (i2 == 1)
        {
          if ((this.f != null) && (this.f != paramMotionEvent))
          {
            p();
            this.f = g(paramMotionEvent);
          }
        }
        else
        {
          label154:
          i1 = 1;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (i2 != 1) {
        break;
      }
      bool2 = bool1;
      if (i1 != 0) {
        break;
      }
      p();
      return bool1;
      if (this.f == null)
      {
        setSelection(getText().length());
        m();
        this.f = g(paramMotionEvent);
        break label154;
      }
      a(this.f, i1, f1, f2);
      break label154;
      if ((this.f != null) && (this.f.c() == -1L)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
  }
  
  protected void performFiltering(CharSequence paramCharSequence, int paramInt)
  {
    if ((enoughToFilter()) && (!b(paramCharSequence)))
    {
      int i1 = getSelectionEnd();
      int i2 = this.e.findTokenStart(paramCharSequence, i1);
      z[] arrayOfz = (z[])getSpannable().getSpans(i2, i1, z.class);
      if ((arrayOfz != null) && (arrayOfz.length > 0)) {
        return;
      }
    }
    super.performFiltering(paramCharSequence, paramInt);
  }
  
  public boolean performLongClick()
  {
    if (com.ideashower.readitlater.util.a.e()) {
      return super.performLongClick();
    }
    if (c(e(ap.a(this, this.O, this.P))) == null) {
      return super.performLongClick();
    }
    return true;
  }
  
  public void performValidation() {}
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    this.l = null;
    super.removeTextChangedListener(paramTextWatcher);
  }
  
  protected void replaceText(CharSequence paramCharSequence) {}
  
  public void setCopyDialogEnabled(boolean paramBoolean)
  {
    this.Q = paramBoolean;
  }
  
  public void setOnFocusListShrinkRecipients(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void setTokenizer(MultiAutoCompleteTextView.Tokenizer paramTokenizer)
  {
    this.e = paramTokenizer;
    super.setTokenizer(this.e);
  }
  
  public void setValidator(AutoCompleteTextView.Validator paramValidator)
  {
    this.x = paramValidator;
    super.setValidator(paramValidator);
  }
  
  public void showDropDown()
  {
    if (!this.ab)
    {
      super.showDropDown();
      return;
    }
    if (this.Z)
    {
      this.Z = false;
      super.showDropDown();
      return;
    }
    this.Z = true;
    try
    {
      if (this.aa == null) {
        this.aa = getClass().getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
      }
      this.aa.invoke(this, new Object[] { Boolean.valueOf(true) });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      com.ideashower.readitlater.util.e.a(localNoSuchMethodException);
      this.ab = false;
      super.showDropDown();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(localIllegalArgumentException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(localInvocationTargetException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */