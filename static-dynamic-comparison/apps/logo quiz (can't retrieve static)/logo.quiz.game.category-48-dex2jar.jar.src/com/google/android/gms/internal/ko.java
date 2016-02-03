package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ac;
import com.google.android.gms.fitness.request.ae;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.request.b;
import com.google.android.gms.fitness.request.i;
import com.google.android.gms.fitness.request.l;
import com.google.android.gms.fitness.request.n;
import com.google.android.gms.fitness.request.p;
import com.google.android.gms.fitness.request.t;
import com.google.android.gms.fitness.request.v;
import com.google.android.gms.fitness.request.x;
import com.google.android.gms.fitness.request.z;

public abstract interface ko
  extends IInterface
{
  public abstract void a(DataDeleteRequest paramDataDeleteRequest, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(DataInsertRequest paramDataInsertRequest, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(DataReadRequest paramDataReadRequest, kl paramkl, String paramString)
    throws RemoteException;
  
  public abstract void a(DataSourcesRequest paramDataSourcesRequest, km paramkm, String paramString)
    throws RemoteException;
  
  public abstract void a(DataTypeCreateRequest paramDataTypeCreateRequest, kn paramkn, String paramString)
    throws RemoteException;
  
  public abstract void a(SessionInsertRequest paramSessionInsertRequest, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(SessionReadRequest paramSessionReadRequest, kq paramkq, String paramString)
    throws RemoteException;
  
  public abstract void a(StartBleScanRequest paramStartBleScanRequest, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(UnclaimBleDeviceRequest paramUnclaimBleDeviceRequest, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(ac paramac, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(ae paramae, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(ah paramah, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(b paramb, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(i parami, kn paramkn, String paramString)
    throws RemoteException;
  
  public abstract void a(l paraml, kp paramkp, String paramString)
    throws RemoteException;
  
  public abstract void a(n paramn, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(p paramp, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(t paramt, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(v paramv, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(x paramx, kr paramkr, String paramString)
    throws RemoteException;
  
  public abstract void a(z paramz, ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(ks paramks, String paramString)
    throws RemoteException;
  
  public abstract void a(le paramle, String paramString)
    throws RemoteException;
  
  public abstract void b(ks paramks, String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ko
  {
    public static ko as(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
      if ((localIInterface != null) && ((localIInterface instanceof ko))) {
        return (ko)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject11 = null;
      Object localObject12 = null;
      Object localObject13 = null;
      Object localObject14 = null;
      Object localObject15 = null;
      Object localObject16 = null;
      Object localObject17 = null;
      Object localObject18 = null;
      Object localObject19 = null;
      Object localObject20 = null;
      Object localObject21 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (DataSourcesRequest)DataSourcesRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, km.a.aq(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject2;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (n)n.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject3;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (p)p.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject4;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (ae)ae.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject5;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (ah)ah.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject6;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (l)l.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, kp.a.at(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject7;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (DataInsertRequest)DataInsertRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        localObject1 = localObject8;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (DataDeleteRequest)DataDeleteRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((DataDeleteRequest)localObject1, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject9;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (DataTypeCreateRequest)DataTypeCreateRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, kn.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject10;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (i)i.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, kn.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject11;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (DataReadRequest)DataReadRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, kl.a.ap(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject12;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (SessionInsertRequest)SessionInsertRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject13;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (SessionReadRequest)SessionReadRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, kq.a.au(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject14;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (v)v.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject15;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (x)x.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, kr.a.av(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject16;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (StartBleScanRequest)StartBleScanRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject17;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (ac)ac.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject18;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (b)b.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject19;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (UnclaimBleDeviceRequest)UnclaimBleDeviceRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject20;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (t)t.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        paramParcel2 = (Parcel)localObject21;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (z)z.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        a(ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        b(ks.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
      a(le.a.ax(paramParcel1.readStrongBinder()), paramParcel1.readString());
      return true;
    }
    
    private static class a
      implements ko
    {
      private IBinder lb;
      
      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }
      
      public void a(DataDeleteRequest paramDataDeleteRequest, ks paramks, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            if (paramDataDeleteRequest != null)
            {
              localParcel1.writeInt(1);
              paramDataDeleteRequest.writeToParcel(localParcel1, 0);
              if (paramks != null)
              {
                paramDataDeleteRequest = paramks.asBinder();
                localParcel1.writeStrongBinder(paramDataDeleteRequest);
                localParcel1.writeString(paramString);
                this.lb.transact(19, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramDataDeleteRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(DataInsertRequest paramDataInsertRequest, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 73	com/google/android/gms/fitness/request/DataInsertRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 7
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramDataInsertRequest	DataInsertRequest
        //   0	97	2	paramks	ks
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(DataReadRequest paramDataReadRequest, kl paramkl, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 77	com/google/android/gms/fitness/request/DataReadRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 80 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 8
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramDataReadRequest	DataReadRequest
        //   0	97	2	paramkl	kl
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(DataSourcesRequest paramDataSourcesRequest, km paramkm, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +63 -> 79
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 84	com/google/android/gms/fitness/request/DataSourcesRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 87 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: iconst_1
        //   63: aload 5
        //   65: aconst_null
        //   66: iconst_1
        //   67: invokeinterface 62 5 0
        //   72: pop
        //   73: aload 5
        //   75: invokevirtual 68	android/os/Parcel:recycle	()V
        //   78: return
        //   79: aload 5
        //   81: iconst_0
        //   82: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   85: goto -53 -> 32
        //   88: astore_1
        //   89: aload 5
        //   91: invokevirtual 68	android/os/Parcel:recycle	()V
        //   94: aload_1
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	a
        //   0	96	1	paramDataSourcesRequest	DataSourcesRequest
        //   0	96	2	paramkm	km
        //   0	96	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	84	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	88	finally
        //   19	32	88	finally
        //   39	46	88	finally
        //   46	73	88	finally
        //   79	85	88	finally
      }
      
      /* Error */
      public void a(DataTypeCreateRequest paramDataTypeCreateRequest, kn paramkn, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 91	com/google/android/gms/fitness/request/DataTypeCreateRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 94 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 13
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramDataTypeCreateRequest	DataTypeCreateRequest
        //   0	97	2	paramkn	kn
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(SessionInsertRequest paramSessionInsertRequest, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 98	com/google/android/gms/fitness/request/SessionInsertRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 9
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramSessionInsertRequest	SessionInsertRequest
        //   0	97	2	paramks	ks
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(SessionReadRequest paramSessionReadRequest, kq paramkq, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 102	com/google/android/gms/fitness/request/SessionReadRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 105 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 10
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramSessionReadRequest	SessionReadRequest
        //   0	97	2	paramkq	kq
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(StartBleScanRequest paramStartBleScanRequest, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 109	com/google/android/gms/fitness/request/StartBleScanRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 15
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramStartBleScanRequest	StartBleScanRequest
        //   0	97	2	paramks	ks
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(UnclaimBleDeviceRequest paramUnclaimBleDeviceRequest, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 113	com/google/android/gms/fitness/request/UnclaimBleDeviceRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 18
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramUnclaimBleDeviceRequest	UnclaimBleDeviceRequest
        //   0	97	2	paramks	ks
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(ac paramac, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 117	com/google/android/gms/fitness/request/ac:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 16
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramac	ac
        //   0	97	2	paramks	ks
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(ae paramae, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +63 -> 79
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 121	com/google/android/gms/fitness/request/ae:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: iconst_4
        //   63: aload 5
        //   65: aconst_null
        //   66: iconst_1
        //   67: invokeinterface 62 5 0
        //   72: pop
        //   73: aload 5
        //   75: invokevirtual 68	android/os/Parcel:recycle	()V
        //   78: return
        //   79: aload 5
        //   81: iconst_0
        //   82: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   85: goto -53 -> 32
        //   88: astore_1
        //   89: aload 5
        //   91: invokevirtual 68	android/os/Parcel:recycle	()V
        //   94: aload_1
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	a
        //   0	96	1	paramae	ae
        //   0	96	2	paramks	ks
        //   0	96	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	84	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	88	finally
        //   19	32	88	finally
        //   39	46	88	finally
        //   46	73	88	finally
        //   79	85	88	finally
      }
      
      /* Error */
      public void a(ah paramah, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +63 -> 79
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 125	com/google/android/gms/fitness/request/ah:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: iconst_5
        //   63: aload 5
        //   65: aconst_null
        //   66: iconst_1
        //   67: invokeinterface 62 5 0
        //   72: pop
        //   73: aload 5
        //   75: invokevirtual 68	android/os/Parcel:recycle	()V
        //   78: return
        //   79: aload 5
        //   81: iconst_0
        //   82: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   85: goto -53 -> 32
        //   88: astore_1
        //   89: aload 5
        //   91: invokevirtual 68	android/os/Parcel:recycle	()V
        //   94: aload_1
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	a
        //   0	96	1	paramah	ah
        //   0	96	2	paramks	ks
        //   0	96	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	84	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	88	finally
        //   19	32	88	finally
        //   39	46	88	finally
        //   46	73	88	finally
        //   79	85	88	finally
      }
      
      /* Error */
      public void a(b paramb, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 129	com/google/android/gms/fitness/request/b:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 17
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramb	b
        //   0	97	2	paramks	ks
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(i parami, kn paramkn, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 133	com/google/android/gms/fitness/request/i:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 94 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 14
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	parami	i
        //   0	97	2	paramkn	kn
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(l paraml, kp paramkp, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 137	com/google/android/gms/fitness/request/l:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 140 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 6
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paraml	l
        //   0	97	2	paramkp	kp
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(n paramn, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +63 -> 79
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 144	com/google/android/gms/fitness/request/n:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: iconst_2
        //   63: aload 5
        //   65: aconst_null
        //   66: iconst_1
        //   67: invokeinterface 62 5 0
        //   72: pop
        //   73: aload 5
        //   75: invokevirtual 68	android/os/Parcel:recycle	()V
        //   78: return
        //   79: aload 5
        //   81: iconst_0
        //   82: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   85: goto -53 -> 32
        //   88: astore_1
        //   89: aload 5
        //   91: invokevirtual 68	android/os/Parcel:recycle	()V
        //   94: aload_1
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	a
        //   0	96	1	paramn	n
        //   0	96	2	paramks	ks
        //   0	96	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	84	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	88	finally
        //   19	32	88	finally
        //   39	46	88	finally
        //   46	73	88	finally
        //   79	85	88	finally
      }
      
      /* Error */
      public void a(p paramp, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +63 -> 79
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 148	com/google/android/gms/fitness/request/p:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: iconst_3
        //   63: aload 5
        //   65: aconst_null
        //   66: iconst_1
        //   67: invokeinterface 62 5 0
        //   72: pop
        //   73: aload 5
        //   75: invokevirtual 68	android/os/Parcel:recycle	()V
        //   78: return
        //   79: aload 5
        //   81: iconst_0
        //   82: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   85: goto -53 -> 32
        //   88: astore_1
        //   89: aload 5
        //   91: invokevirtual 68	android/os/Parcel:recycle	()V
        //   94: aload_1
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	a
        //   0	96	1	paramp	p
        //   0	96	2	paramks	ks
        //   0	96	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	84	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	88	finally
        //   19	32	88	finally
        //   39	46	88	finally
        //   46	73	88	finally
        //   79	85	88	finally
      }
      
      /* Error */
      public void a(t paramt, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 152	com/google/android/gms/fitness/request/t:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 20
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramt	t
        //   0	97	2	paramks	ks
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(v paramv, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 156	com/google/android/gms/fitness/request/v:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 11
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramv	v
        //   0	97	2	paramks	ks
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(x paramx, kr paramkr, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 160	com/google/android/gms/fitness/request/x:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 163 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 12
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramx	x
        //   0	97	2	paramkr	kr
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      /* Error */
      public void a(z paramz, ks paramks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +64 -> 80
        //   19: aload 5
        //   21: iconst_1
        //   22: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   25: aload_1
        //   26: aload 5
        //   28: iconst_0
        //   29: invokevirtual 167	com/google/android/gms/fitness/request/z:writeToParcel	(Landroid/os/Parcel;I)V
        //   32: aload 4
        //   34: astore_1
        //   35: aload_2
        //   36: ifnull +10 -> 46
        //   39: aload_2
        //   40: invokeinterface 50 1 0
        //   45: astore_1
        //   46: aload 5
        //   48: aload_1
        //   49: invokevirtual 53	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   52: aload 5
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/google/android/gms/internal/ko$a$a:lb	Landroid/os/IBinder;
        //   62: bipush 21
        //   64: aload 5
        //   66: aconst_null
        //   67: iconst_1
        //   68: invokeinterface 62 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 68	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aload 5
        //   82: iconst_0
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: goto -54 -> 32
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 68	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramz	z
        //   0	97	2	paramks	ks
        //   0	97	3	paramString	String
        //   1	32	4	localObject	Object
        //   6	85	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	89	finally
        //   19	32	89	finally
        //   39	46	89	finally
        //   46	74	89	finally
        //   80	86	89	finally
      }
      
      public void a(ks paramks, String paramString)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramks != null) {
            localIBinder = paramks.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          localParcel.writeString(paramString);
          this.lb.transact(22, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(le paramle, String paramString)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramle != null) {
            localIBinder = paramle.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          localParcel.writeString(paramString);
          this.lb.transact(24, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.lb;
      }
      
      public void b(ks paramks, String paramString)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramks != null) {
            localIBinder = paramks.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          localParcel.writeString(paramString);
          this.lb.transact(23, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */