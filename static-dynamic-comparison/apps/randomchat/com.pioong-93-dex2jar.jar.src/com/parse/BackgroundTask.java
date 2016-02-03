package com.parse;

import android.os.AsyncTask;

abstract class BackgroundTask<T>
  extends AsyncTask<Void, Void, Void>
{
  private ParseCallback<T> callback;
  private ParseException exception = null;
  private T result = null;
  
  BackgroundTask(ParseCallback<T> paramParseCallback)
  {
    this.callback = paramParseCallback;
  }
  
  static int executeTask(BackgroundTask<?> paramBackgroundTask)
  {
    paramBackgroundTask.execute(new Void[0]);
    return 0;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    try
    {
      this.result = run();
      return null;
    }
    catch (ParseException paramVarArgs)
    {
      this.exception = paramVarArgs;
    }
    return null;
  }
  
  void executeInThisThread()
  {
    doInBackground(new Void[0]);
    onPostExecute(null);
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    if (this.callback != null) {
      this.callback.internalDone(this.result, this.exception);
    }
  }
  
  public abstract T run()
    throws ParseException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/BackgroundTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */