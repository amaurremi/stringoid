package android.support.v7.internal.widget;

class q
  implements Runnable
{
  private q(l paraml) {}
  
  public void run()
  {
    if (this.a.u)
    {
      if (this.a.e() != null) {
        this.a.post(this);
      }
      return;
    }
    l.b(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */