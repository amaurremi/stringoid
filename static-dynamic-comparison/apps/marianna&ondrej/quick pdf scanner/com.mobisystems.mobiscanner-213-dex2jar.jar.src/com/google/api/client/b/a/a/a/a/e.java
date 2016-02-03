package com.google.api.client.b.a.a.a.a;

public final class e
{
  public static <X extends Throwable> void a(Throwable paramThrowable, Class<X> paramClass)
  {
    if ((paramThrowable != null) && (paramClass.isInstance(paramThrowable))) {
      throw ((Throwable)paramClass.cast(paramThrowable));
    }
  }
  
  public static void e(Throwable paramThrowable)
  {
    a(paramThrowable, Error.class);
    a(paramThrowable, RuntimeException.class);
  }
  
  public static RuntimeException f(Throwable paramThrowable)
  {
    e((Throwable)c.ad(paramThrowable));
    throw new RuntimeException(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/b/a/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */