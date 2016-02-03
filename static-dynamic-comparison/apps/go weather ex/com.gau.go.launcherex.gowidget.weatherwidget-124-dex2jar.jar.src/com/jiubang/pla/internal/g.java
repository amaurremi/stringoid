package com.jiubang.pla.internal;

import android.graphics.Rect;
import android.view.View;

class g
  implements Runnable
{
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private final int g;
  
  public void run()
  {
    int j = this.a.getHeight();
    int k = this.a.B;
    switch (this.b)
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                i = this.a.getChildCount() - 1;
                k += i;
              } while (i < 0);
              if (k == this.e)
              {
                this.a.post(this);
                return;
              }
              localView = this.a.getChildAt(i);
              m = localView.getHeight();
              int n = localView.getTop();
              if (k < this.a.M - 1) {}
              for (i = this.g;; i = this.a.l.bottom)
              {
                this.a.b(i + (m - (j - n)), this.f);
                this.e = k;
                if (k >= this.c) {
                  break;
                }
                this.a.post(this);
                return;
              }
              i = this.a.getChildCount();
            } while ((k == this.d) || (i <= 1) || (i + k >= this.a.M));
            i = k + 1;
            if (i == this.e)
            {
              this.a.post(this);
              return;
            }
            localView = this.a.getChildAt(1);
            j = localView.getHeight();
            k = localView.getTop();
            m = this.g;
            if (i < this.d)
            {
              this.a.b(Math.max(0, k + j - m), this.f);
              this.e = i;
              this.a.post(this);
              return;
            }
          } while (k <= m);
          this.a.b(k - m, this.f);
          return;
          if (k == this.e)
          {
            this.a.post(this);
            return;
          }
          localView = this.a.getChildAt(0);
        } while (localView == null);
        j = localView.getTop();
        if (k > 0) {}
        for (i = this.g;; i = this.a.l.top)
        {
          this.a.b(j - i, this.f);
          this.e = k;
          if (k <= this.c) {
            break;
          }
          this.a.post(this);
          return;
        }
        m = this.a.getChildCount() - 2;
      } while (m < 0);
      i = k + m;
      if (i == this.e)
      {
        this.a.post(this);
        return;
      }
      View localView = this.a.getChildAt(m);
      k = localView.getHeight();
      int m = localView.getTop();
      this.e = i;
      if (i > this.d)
      {
        this.a.b(-(j - m - this.g), this.f);
        this.a.post(this);
        return;
      }
      i = j - this.g;
      j = m + k;
    } while (i <= j);
    this.a.b(-(i - j), this.f);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */