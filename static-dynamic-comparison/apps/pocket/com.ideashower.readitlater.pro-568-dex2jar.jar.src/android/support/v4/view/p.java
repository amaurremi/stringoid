package android.support.v4.view;

import android.view.KeyEvent;

class p
  implements s
{
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = 1;
    int i;
    if ((paramInt2 & paramInt3) != 0)
    {
      i = 1;
      paramInt4 |= paramInt5;
      if ((paramInt2 & paramInt4) == 0) {
        break label51;
      }
      paramInt2 = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (paramInt2 != 0)
        {
          throw new IllegalArgumentException("bad arguments");
          i = 0;
          break;
          label51:
          paramInt2 = 0;
          continue;
        }
        paramInt4 = paramInt1 & (paramInt4 ^ 0xFFFFFFFF);
      }
    }
    do
    {
      return paramInt4;
      paramInt4 = paramInt1;
    } while (paramInt2 == 0);
    return paramInt1 & (paramInt3 ^ 0xFFFFFFFF);
  }
  
  public int a(int paramInt)
  {
    if ((paramInt & 0xC0) != 0) {
      paramInt |= 0x1;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x30) != 0) {
        i = paramInt | 0x2;
      }
      return i & 0xF7;
    }
  }
  
  public void a(KeyEvent paramKeyEvent) {}
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return a(a(a(paramInt1) & 0xF7, paramInt2, 1, 64, 128), paramInt2, 2, 16, 32) == paramInt2;
  }
  
  public boolean b(int paramInt)
  {
    return (a(paramInt) & 0xF7) == 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */