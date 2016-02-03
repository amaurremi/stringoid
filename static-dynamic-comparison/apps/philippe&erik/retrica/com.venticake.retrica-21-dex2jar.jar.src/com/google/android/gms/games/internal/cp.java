package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.hm;

final class cp
  extends AbstractGamesCallbacks
{
  private final RoomUpdateListener b;
  private final RoomStatusUpdateListener c;
  private final RealTimeMessageReceivedListener d;
  
  public cp(GamesClientImpl paramGamesClientImpl, RoomUpdateListener paramRoomUpdateListener)
  {
    this.b = ((RoomUpdateListener)hm.b(paramRoomUpdateListener, "Callbacks must not be null"));
    this.c = null;
    this.d = null;
  }
  
  public cp(GamesClientImpl paramGamesClientImpl, RoomUpdateListener paramRoomUpdateListener, RoomStatusUpdateListener paramRoomStatusUpdateListener, RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
  {
    this.b = ((RoomUpdateListener)hm.b(paramRoomUpdateListener, "Callbacks must not be null"));
    this.c = paramRoomStatusUpdateListener;
    this.d = paramRealTimeMessageReceivedListener;
  }
  
  public void A(DataHolder paramDataHolder)
  {
    this.a.a(new o(this.a, this.c, paramDataHolder));
  }
  
  public void a(DataHolder paramDataHolder, String[] paramArrayOfString)
  {
    this.a.a(new bt(this.a, this.c, paramDataHolder, paramArrayOfString));
  }
  
  public void b(DataHolder paramDataHolder, String[] paramArrayOfString)
  {
    this.a.a(new bu(this.a, this.c, paramDataHolder, paramArrayOfString));
  }
  
  public void c(DataHolder paramDataHolder, String[] paramArrayOfString)
  {
    this.a.a(new bv(this.a, this.c, paramDataHolder, paramArrayOfString));
  }
  
  public void d(DataHolder paramDataHolder, String[] paramArrayOfString)
  {
    this.a.a(new br(this.a, this.c, paramDataHolder, paramArrayOfString));
  }
  
  public void e(DataHolder paramDataHolder, String[] paramArrayOfString)
  {
    this.a.a(new bq(this.a, this.c, paramDataHolder, paramArrayOfString));
  }
  
  public void f(DataHolder paramDataHolder, String[] paramArrayOfString)
  {
    this.a.a(new bs(this.a, this.c, paramDataHolder, paramArrayOfString));
  }
  
  public void onLeftRoom(int paramInt, String paramString)
  {
    this.a.a(new al(this.a, this.b, paramInt, paramString));
  }
  
  public void onP2PConnected(String paramString)
  {
    this.a.a(new bo(this.a, this.c, paramString));
  }
  
  public void onP2PDisconnected(String paramString)
  {
    this.a.a(new bp(this.a, this.c, paramString));
  }
  
  public void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage)
  {
    this.a.a(new bj(this.a, this.d, paramRealTimeMessage));
  }
  
  public void u(DataHolder paramDataHolder)
  {
    this.a.a(new cs(this.a, this.b, paramDataHolder));
  }
  
  public void v(DataHolder paramDataHolder)
  {
    this.a.a(new ag(this.a, this.b, paramDataHolder));
  }
  
  public void w(DataHolder paramDataHolder)
  {
    this.a.a(new cr(this.a, this.c, paramDataHolder));
  }
  
  public void x(DataHolder paramDataHolder)
  {
    this.a.a(new co(this.a, this.c, paramDataHolder));
  }
  
  public void y(DataHolder paramDataHolder)
  {
    this.a.a(new cq(this.a, this.b, paramDataHolder));
  }
  
  public void z(DataHolder paramDataHolder)
  {
    this.a.a(new j(this.a, this.c, paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */