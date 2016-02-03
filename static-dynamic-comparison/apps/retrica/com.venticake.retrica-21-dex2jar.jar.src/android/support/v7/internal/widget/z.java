package android.support.v7.internal.widget;

class z
  implements Runnable
{
  private int b;
  private int c;
  private boolean d;
  
  z(ProgressBarICS paramProgressBarICS, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean;
  }
  
  public void run()
  {
    ProgressBarICS.a(this.a, this.b, this.c, this.d, true);
    ProgressBarICS.a(this.a, this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */