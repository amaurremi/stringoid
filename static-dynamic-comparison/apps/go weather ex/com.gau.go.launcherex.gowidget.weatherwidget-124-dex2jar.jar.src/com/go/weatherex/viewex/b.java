package com.go.weatherex.viewex;

class b
  implements Runnable
{
  protected boolean a;
  
  b(FrameImageView paramFrameImageView) {}
  
  private void a()
  {
    int i = FrameImageView.a(this.b).length;
    if (i != 0)
    {
      if (!this.a)
      {
        FrameImageView.b(this.b);
        if (FrameImageView.c(this.b) >= i)
        {
          this.a = true;
          FrameImageView.d(this.b);
          FrameImageView.a(this.b, FrameImageView.c(this.b) % i);
        }
        return;
      }
      this.a = false;
      return;
    }
    FrameImageView.a(this.b, -1);
  }
  
  public void run()
  {
    a();
    if (this.a) {
      this.b.postDelayed(this, FrameImageView.e(this.b));
    }
    while (FrameImageView.c(this.b) == -1) {
      return;
    }
    this.b.setImageResource(FrameImageView.a(this.b)[FrameImageView.c(this.b)]);
    if ((FrameImageView.f(this.b) == -1) || (FrameImageView.g(this.b) < FrameImageView.f(this.b)))
    {
      this.b.postDelayed(this, FrameImageView.h(this.b));
      return;
    }
    FrameImageView.i(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */