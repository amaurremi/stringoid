package com.bluebird.mobile.tools.timecounter;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

public class BackgroundTimeCounter
  extends Observable
  implements TimeCounter
{
  private List<FireEventCondition> conditions = new ArrayList();
  private Thread thread;
  private SimpleTimeCounter timeCounter = new SimpleTimeCounter();
  private int waitingTimeInSecondsToFire = 2;
  
  private boolean allConditionsAreMet()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.conditions != null)
    {
      Iterator localIterator = this.conditions.iterator();
      do
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((FireEventCondition)localIterator.next()).canBeFired());
      bool1 = false;
    }
    return bool1;
  }
  
  public void pause()
  {
    this.timeCounter.pause();
  }
  
  public void resume()
  {
    this.timeCounter.resume();
  }
  
  public void start()
  {
    if ((this.thread != null) && (!this.thread.isInterrupted())) {
      this.thread.interrupt();
    }
    this.timeCounter.start();
    this.thread = new MyRunnable(null);
    this.thread.start();
  }
  
  public void stop()
  {
    this.timeCounter.stop(TimeUnit.MILLISECONDS);
    if ((this.thread != null) && (!this.thread.isInterrupted())) {
      this.thread.interrupt();
    }
  }
  
  public static class Builder
  {
    private List<FireEventCondition> conditions;
    private Observer observer;
    private Observer[] observers;
    private int waitingTimeInSecond = 0;
    
    private void validate()
    {
      if (this.waitingTimeInSecond == 0) {
        throw new IllegalStateException("WaitingTimeInSecond not set. Call: BackgroundTimeCounter.Builder.setWaitingTimeInSecond(value) before creating an object.");
      }
    }
    
    public Builder addObserver(Observer paramObserver)
    {
      this.observer = paramObserver;
      return this;
    }
    
    public Builder addObservers(Observer... paramVarArgs)
    {
      this.observers = paramVarArgs;
      return this;
    }
    
    public Builder checkCondition(FireEventCondition... paramVarArgs)
    {
      this.conditions = Arrays.asList(paramVarArgs);
      return this;
    }
    
    public TimeCounter create()
    {
      validate();
      BackgroundTimeCounter localBackgroundTimeCounter = new BackgroundTimeCounter(null);
      BackgroundTimeCounter.access$102(localBackgroundTimeCounter, this.waitingTimeInSecond);
      BackgroundTimeCounter.access$602(localBackgroundTimeCounter, this.conditions);
      if (this.observer != null) {
        localBackgroundTimeCounter.addObserver(this.observer);
      }
      if (this.observers != null)
      {
        Observer[] arrayOfObserver = this.observers;
        int j = arrayOfObserver.length;
        int i = 0;
        while (i < j)
        {
          localBackgroundTimeCounter.addObserver(arrayOfObserver[i]);
          i += 1;
        }
      }
      this.conditions = null;
      this.observer = null;
      this.observers = null;
      return localBackgroundTimeCounter;
    }
    
    public Builder setWaitingTimeInSecond(int paramInt)
    {
      this.waitingTimeInSecond = paramInt;
      return this;
    }
  }
  
  private class MyRunnable
    extends Thread
  {
    private MyRunnable() {}
    
    public void run()
    {
      if (!isInterrupted()) {}
      for (;;)
      {
        try
        {
          Log.d("BTC", "runnable running...");
          Thread.sleep(1000L);
          if ((int)(BackgroundTimeCounter.this.timeCounter.currentInMillis() / 1000L) <= BackgroundTimeCounter.this.waitingTimeInSecondsToFire) {
            continue;
          }
          i = 1;
          if (i == 0) {
            break;
          }
          Log.d("BTC", "Long enough.");
          boolean bool = BackgroundTimeCounter.this.allConditionsAreMet();
          Log.d("BTC", "All conditions are met: " + bool);
          if (bool)
          {
            Log.d("BTC", "Fire!!!!!!!!!");
            BackgroundTimeCounter.this.setChanged();
            BackgroundTimeCounter.this.notifyObservers();
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          int i;
          Log.d("BackgroundTC", localInterruptedException.getMessage(), localInterruptedException);
          continue;
        }
        Log.d("BTC", "Runnable finish");
        return;
        i = 0;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/timecounter/BackgroundTimeCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */