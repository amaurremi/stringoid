package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class d
{
  private final a ar;
  
  public d(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, null);
  }
  
  public d(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      this.ar = new c(paramContext, paramOnGestureListener, paramHandler);
      return;
    }
    this.ar = new b(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.ar.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.ar.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  static abstract interface a
  {
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener);
  }
  
  static class b
    implements d.a
  {
    private static final int aw = ;
    private static final int ax = ViewConfiguration.getTapTimeout();
    private static final int ay = ViewConfiguration.getDoubleTapTimeout();
    private GestureDetector.OnDoubleTapListener aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private MotionEvent aG;
    private MotionEvent aH;
    private boolean aI;
    private float aJ;
    private float aK;
    private float aL;
    private float aM;
    private boolean aN;
    private VelocityTracker aO;
    private int as;
    private int at;
    private int au;
    private int av;
    private final GestureDetector.OnGestureListener az;
    private final Handler mHandler;
    
    public b(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
    {
      if (paramHandler != null) {}
      for (this.mHandler = new a(paramHandler);; this.mHandler = new a())
      {
        this.az = paramOnGestureListener;
        if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
          setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
        }
        init(paramContext);
        return;
      }
    }
    
    private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
    {
      if (!this.aF) {}
      int i;
      int j;
      do
      {
        do
        {
          return false;
        } while (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > ay);
        i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
        j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
      } while (i * i + j * j >= this.at);
      return true;
    }
    
    private void cancel()
    {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.aO.recycle();
      this.aO = null;
      this.aI = false;
      this.aB = false;
      this.aE = false;
      this.aF = false;
      this.aC = false;
      if (this.aD) {
        this.aD = false;
      }
    }
    
    private void init(Context paramContext)
    {
      if (paramContext == null) {
        throw new IllegalArgumentException("Context must not be null");
      }
      if (this.az == null) {
        throw new IllegalArgumentException("OnGestureListener must not be null");
      }
      this.aN = true;
      paramContext = ViewConfiguration.get(paramContext);
      int i = paramContext.getScaledTouchSlop();
      int j = paramContext.getScaledDoubleTapSlop();
      this.au = paramContext.getScaledMinimumFlingVelocity();
      this.av = paramContext.getScaledMaximumFlingVelocity();
      this.as = (i * i);
      this.at = (j * j);
    }
    
    private void x()
    {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.aI = false;
      this.aE = false;
      this.aF = false;
      this.aC = false;
      if (this.aD) {
        this.aD = false;
      }
    }
    
    private void y()
    {
      this.mHandler.removeMessages(3);
      this.aC = false;
      this.aD = true;
      this.az.onLongPress(this.aG);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i1 = paramMotionEvent.getAction();
      if (this.aO == null) {
        this.aO = VelocityTracker.obtain();
      }
      this.aO.addMovement(paramMotionEvent);
      int i;
      int k;
      label53:
      int n;
      int m;
      float f1;
      float f2;
      if ((i1 & 0xFF) == 6)
      {
        i = 1;
        if (i == 0) {
          break label95;
        }
        k = j.b(paramMotionEvent);
        n = j.c(paramMotionEvent);
        m = 0;
        f1 = 0.0F;
        f2 = 0.0F;
        label66:
        if (m >= n) {
          break label122;
        }
        if (k != m) {
          break label101;
        }
      }
      for (;;)
      {
        m += 1;
        break label66;
        i = 0;
        break;
        label95:
        k = -1;
        break label53;
        label101:
        f2 += j.c(paramMotionEvent, m);
        f1 += j.d(paramMotionEvent, m);
      }
      label122:
      if (i != 0)
      {
        i = n - 1;
        f2 /= i;
        f1 /= i;
      }
      float f3;
      boolean bool2;
      float f4;
      int j;
      switch (i1 & 0xFF)
      {
      case 4: 
      default: 
      case 5: 
      case 6: 
      case 0: 
      case 2: 
        do
        {
          do
          {
            return false;
            i = n;
            break;
            this.aJ = f2;
            this.aL = f2;
            this.aK = f1;
            this.aM = f1;
            x();
            return false;
            this.aJ = f2;
            this.aL = f2;
            this.aK = f1;
            this.aM = f1;
            this.aO.computeCurrentVelocity(1000, this.av);
            k = j.b(paramMotionEvent);
            i = j.b(paramMotionEvent, k);
            f1 = n.a(this.aO, i);
            f2 = n.b(this.aO, i);
            i = 0;
          } while (i >= n);
          if (i == k) {}
          do
          {
            i += 1;
            break;
            m = j.b(paramMotionEvent, i);
            f3 = n.a(this.aO, m);
          } while (n.b(this.aO, m) * f2 + f3 * f1 >= 0.0F);
          this.aO.clear();
          return false;
          if (this.aA != null)
          {
            bool2 = this.mHandler.hasMessages(3);
            if (bool2) {
              this.mHandler.removeMessages(3);
            }
            if ((this.aG != null) && (this.aH != null) && (bool2) && (a(this.aG, this.aH, paramMotionEvent))) {
              this.aI = true;
            }
          }
          for (boolean bool1 = this.aA.onDoubleTap(this.aG) | false | this.aA.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
          {
            this.aJ = f2;
            this.aL = f2;
            this.aK = f1;
            this.aM = f1;
            if (this.aG != null) {
              this.aG.recycle();
            }
            this.aG = MotionEvent.obtain(paramMotionEvent);
            this.aE = true;
            this.aF = true;
            this.aB = true;
            this.aD = false;
            this.aC = false;
            if (this.aN)
            {
              this.mHandler.removeMessages(2);
              this.mHandler.sendEmptyMessageAtTime(2, this.aG.getDownTime() + ax + aw);
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.aG.getDownTime() + ax);
            return bool1 | this.az.onDown(paramMotionEvent);
            this.mHandler.sendEmptyMessageDelayed(3, ay);
          }
        } while (this.aD);
        f3 = this.aJ - f2;
        f4 = this.aK - f1;
        if (this.aI) {
          return false | this.aA.onDoubleTapEvent(paramMotionEvent);
        }
        if (this.aE)
        {
          j = (int)(f2 - this.aL);
          k = (int)(f1 - this.aM);
          j = j * j + k * k;
          if (j <= this.as) {
            break label1136;
          }
          bool2 = this.az.onScroll(this.aG, paramMotionEvent, f3, f4);
          this.aJ = f2;
          this.aK = f1;
          this.aE = false;
          this.mHandler.removeMessages(3);
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
        }
        break;
      }
      for (;;)
      {
        if (j > this.as) {
          this.aF = false;
        }
        return bool2;
        if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
          break;
        }
        bool2 = this.az.onScroll(this.aG, paramMotionEvent, f3, f4);
        this.aJ = f2;
        this.aK = f1;
        return bool2;
        this.aB = false;
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.aI) {
          bool2 = this.aA.onDoubleTapEvent(paramMotionEvent) | false;
        }
        for (;;)
        {
          if (this.aH != null) {
            this.aH.recycle();
          }
          this.aH = localMotionEvent;
          if (this.aO != null)
          {
            this.aO.recycle();
            this.aO = null;
          }
          this.aI = false;
          this.aC = false;
          this.mHandler.removeMessages(1);
          this.mHandler.removeMessages(2);
          return bool2;
          if (this.aD)
          {
            this.mHandler.removeMessages(3);
            this.aD = false;
            bool2 = false;
          }
          else if (this.aE)
          {
            boolean bool3 = this.az.onSingleTapUp(paramMotionEvent);
            bool2 = bool3;
            if (this.aC)
            {
              bool2 = bool3;
              if (this.aA != null)
              {
                this.aA.onSingleTapConfirmed(paramMotionEvent);
                bool2 = bool3;
              }
            }
          }
          else
          {
            VelocityTracker localVelocityTracker = this.aO;
            j = j.b(paramMotionEvent, 0);
            localVelocityTracker.computeCurrentVelocity(1000, this.av);
            f1 = n.b(localVelocityTracker, j);
            f2 = n.a(localVelocityTracker, j);
            if ((Math.abs(f1) > this.au) || (Math.abs(f2) > this.au))
            {
              bool2 = this.az.onFling(this.aG, paramMotionEvent, f2, f1);
              continue;
              cancel();
              return false;
            }
            else
            {
              bool2 = false;
            }
          }
        }
        label1136:
        bool2 = false;
      }
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
    {
      this.aA = paramOnDoubleTapListener;
    }
    
    private class a
      extends Handler
    {
      a() {}
      
      a(Handler paramHandler)
      {
        super();
      }
      
      public void handleMessage(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        default: 
          throw new RuntimeException("Unknown message " + paramMessage);
        case 1: 
          d.b.b(d.b.this).onShowPress(d.b.a(d.b.this));
        }
        do
        {
          return;
          d.b.c(d.b.this);
          return;
        } while (d.b.d(d.b.this) == null);
        if (!d.b.e(d.b.this))
        {
          d.b.d(d.b.this).onSingleTapConfirmed(d.b.a(d.b.this));
          return;
        }
        d.b.a(d.b.this, true);
      }
    }
  }
  
  static class c
    implements d.a
  {
    private final GestureDetector aQ;
    
    public c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
    {
      this.aQ = new GestureDetector(paramContext, paramOnGestureListener, paramHandler);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return this.aQ.onTouchEvent(paramMotionEvent);
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
    {
      this.aQ.setOnDoubleTapListener(paramOnDoubleTapListener);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */