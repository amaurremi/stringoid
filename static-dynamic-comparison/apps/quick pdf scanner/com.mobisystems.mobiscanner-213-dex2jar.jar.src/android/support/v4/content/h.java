package android.support.v4.content;

import android.support.v4.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class h<D>
{
  int mId;
  boolean mStarted;
  a<D> p;
  boolean r;
  boolean s;
  boolean t;
  boolean u;
  
  public void a(int paramInt, a<D> parama)
  {
    if (this.p != null) {
      throw new IllegalStateException("There is already a listener registered");
    }
    this.p = parama;
    this.mId = paramInt;
  }
  
  public void a(a<D> parama)
  {
    if (this.p == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.p != parama) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.p = null;
  }
  
  public void abandon()
  {
    this.r = true;
    onAbandon();
  }
  
  public String dataToString(D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    c.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.mId);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.p);
    if ((this.mStarted) || (this.t) || (this.u))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.mStarted);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.t);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.u);
    }
    if ((this.r) || (this.s))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.r);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.s);
    }
  }
  
  protected void onAbandon() {}
  
  protected void onReset() {}
  
  protected void onStartLoading() {}
  
  protected void onStopLoading() {}
  
  public void reset()
  {
    onReset();
    this.s = true;
    this.mStarted = false;
    this.r = false;
    this.t = false;
    this.u = false;
  }
  
  public final void startLoading()
  {
    this.mStarted = true;
    this.s = false;
    this.r = false;
    onStartLoading();
  }
  
  public void stopLoading()
  {
    this.mStarted = false;
    onStopLoading();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    c.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.mId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static abstract interface a<D> {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/content/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */