package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

public abstract interface IGamesService
  extends IInterface
{
  public abstract void E(boolean paramBoolean);
  
  public abstract void F(boolean paramBoolean);
  
  public abstract int a(IGamesCallbacks paramIGamesCallbacks, byte[] paramArrayOfByte, String paramString1, String paramString2);
  
  public abstract Intent a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString);
  
  public abstract Intent a(ZInvitationCluster paramZInvitationCluster, String paramString1, String paramString2);
  
  public abstract Intent a(GameRequestCluster paramGameRequestCluster, String paramString);
  
  public abstract Intent a(RoomEntity paramRoomEntity, int paramInt);
  
  public abstract Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract Intent a(int[] paramArrayOfInt);
  
  public abstract Intent a(ParticipantEntity[] paramArrayOfParticipantEntity, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2);
  
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(IBinder paramIBinder, Bundle paramBundle);
  
  public abstract void a(Contents paramContents);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt1, int paramInt2, String[] paramArrayOfString, Bundle paramBundle);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt, int[] paramArrayOfInt);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, long paramLong);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, Bundle paramBundle, int paramInt1, int paramInt2);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, IBinder paramIBinder, int paramInt, String[] paramArrayOfString, Bundle paramBundle, boolean paramBoolean, long paramLong);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, IBinder paramIBinder, String paramString, boolean paramBoolean, long paramLong);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, int[] paramArrayOfInt);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, long paramLong);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, long paramLong, String paramString2);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, IBinder paramIBinder, Bundle paramBundle);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, SnapshotMetadataChange paramSnapshotMetadataChange, Contents paramContents);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, Contents paramContents);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int[] paramArrayOfInt);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean, Bundle paramBundle);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean, String[] paramArrayOfString);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int[] paramArrayOfInt);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int[] paramArrayOfInt, int paramInt, boolean paramBoolean);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString);
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString, boolean paramBoolean);
  
  public abstract Intent aR(String paramString);
  
  public abstract Intent aU(String paramString);
  
  public abstract String aV(String paramString);
  
  public abstract String aW(String paramString);
  
  public abstract void aX(String paramString);
  
  public abstract int aY(String paramString);
  
  public abstract Uri aZ(String paramString);
  
  public abstract int b(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString);
  
  public abstract Intent b(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void b(long paramLong, String paramString);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, long paramLong);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, IBinder paramIBinder, Bundle paramBundle);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean);
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString);
  
  public abstract void b(String paramString1, String paramString2, int paramInt);
  
  public abstract void ba(String paramString);
  
  public abstract ParcelFileDescriptor bb(String paramString);
  
  public abstract void c(long paramLong, String paramString);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, long paramLong);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean);
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString);
  
  public abstract void c(String paramString1, String paramString2, int paramInt);
  
  public abstract void ch(int paramInt);
  
  public abstract void d(long paramLong, String paramString);
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, long paramLong);
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString);
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2);
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean);
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean);
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2);
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean);
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean);
  
  public abstract Bundle ef();
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2);
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean);
  
  public abstract void g(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract void g(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract String gZ();
  
  public abstract ParcelFileDescriptor h(Uri paramUri);
  
  public abstract RoomEntity h(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void h(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract DataHolder hA();
  
  public abstract void hB();
  
  public abstract Intent hC();
  
  public abstract void hD();
  
  public abstract boolean hE();
  
  public abstract String ha();
  
  public abstract Intent hd();
  
  public abstract Intent he();
  
  public abstract Intent hf();
  
  public abstract Intent hg();
  
  public abstract Intent hl();
  
  public abstract Intent hm();
  
  public abstract int hn();
  
  public abstract String ho();
  
  public abstract int hp();
  
  public abstract Intent hq();
  
  public abstract int hr();
  
  public abstract int hs();
  
  public abstract int ht();
  
  public abstract int hu();
  
  public abstract void hw();
  
  public abstract DataHolder hy();
  
  public abstract boolean hz();
  
  public abstract void i(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract void i(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void j(IGamesCallbacks paramIGamesCallbacks);
  
  public abstract void j(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void k(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void l(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void l(String paramString, int paramInt);
  
  public abstract void m(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void m(String paramString, int paramInt);
  
  public abstract void m(String paramString1, String paramString2);
  
  public abstract void n(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void n(String paramString, int paramInt);
  
  public abstract void n(String paramString1, String paramString2);
  
  public abstract void o(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void p(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void p(String paramString, int paramInt);
  
  public abstract void q(long paramLong);
  
  public abstract void q(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void q(String paramString, int paramInt);
  
  public abstract void r(long paramLong);
  
  public abstract void r(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void s(long paramLong);
  
  public abstract void s(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void t(long paramLong);
  
  public abstract void t(IGamesCallbacks paramIGamesCallbacks, String paramString);
  
  public abstract void u(long paramLong);
  
  public abstract void u(IGamesCallbacks paramIGamesCallbacks, String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/IGamesService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */