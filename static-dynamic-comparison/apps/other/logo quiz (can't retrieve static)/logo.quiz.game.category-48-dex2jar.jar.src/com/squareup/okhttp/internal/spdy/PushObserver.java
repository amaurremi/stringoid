package com.squareup.okhttp.internal.spdy;

import com.squareup.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

public abstract interface PushObserver
{
  public static final PushObserver CANCEL = new PushObserver()
  {
    public boolean onData(int paramAnonymousInt1, BufferedSource paramAnonymousBufferedSource, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      throws IOException
    {
      paramAnonymousBufferedSource.skip(paramAnonymousInt2);
      return true;
    }
    
    public boolean onHeaders(int paramAnonymousInt, List<Header> paramAnonymousList, boolean paramAnonymousBoolean)
    {
      return true;
    }
    
    public boolean onRequest(int paramAnonymousInt, List<Header> paramAnonymousList)
    {
      return true;
    }
    
    public void onReset(int paramAnonymousInt, ErrorCode paramAnonymousErrorCode) {}
  };
  
  public abstract boolean onData(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
    throws IOException;
  
  public abstract boolean onHeaders(int paramInt, List<Header> paramList, boolean paramBoolean);
  
  public abstract boolean onRequest(int paramInt, List<Header> paramList);
  
  public abstract void onReset(int paramInt, ErrorCode paramErrorCode);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/spdy/PushObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */