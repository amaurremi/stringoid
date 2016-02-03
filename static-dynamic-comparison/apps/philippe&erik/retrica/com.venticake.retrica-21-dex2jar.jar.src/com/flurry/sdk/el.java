package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;

public class el<RequestObjectType, ResponseObjectType>
  extends en
{
  private el.a<RequestObjectType, ResponseObjectType> a;
  private RequestObjectType b;
  private ResponseObjectType c;
  private ex<RequestObjectType> d;
  private ex<ResponseObjectType> e;
  
  private void m()
  {
    a(new en.c()
    {
      public void a(en paramAnonymousen)
      {
        el.d(el.this);
      }
      
      public void a(en paramAnonymousen, InputStream paramAnonymousInputStream)
      {
        if (!paramAnonymousen.d()) {}
        while (el.c(el.this) == null) {
          return;
        }
        el.a(el.this, el.c(el.this).a(paramAnonymousInputStream));
      }
      
      public void a(en paramAnonymousen, OutputStream paramAnonymousOutputStream)
      {
        if ((el.a(el.this) != null) && (el.b(el.this) != null)) {
          el.b(el.this).a(paramAnonymousOutputStream, el.a(el.this));
        }
      }
    });
  }
  
  private void n()
  {
    if (this.a == null) {}
    while (b()) {
      return;
    }
    this.a.a(this, this.c);
  }
  
  public void a()
  {
    m();
    super.a();
  }
  
  public void a(el.a<RequestObjectType, ResponseObjectType> parama)
  {
    this.a = parama;
  }
  
  public void a(ex<RequestObjectType> paramex)
  {
    this.d = paramex;
  }
  
  public void a(RequestObjectType paramRequestObjectType)
  {
    this.b = paramRequestObjectType;
  }
  
  public void b(ex<ResponseObjectType> paramex)
  {
    this.e = paramex;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */