/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\Android黑马74期--Android视频\\day08\\day08\\code\\8_远程服务\\src\\com\\itheima\\remoteservice\\Iservice.aidl
 */
package com.itheima.remoteservice;
public interface Iservice extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.itheima.remoteservice.Iservice
{
private static final java.lang.String DESCRIPTOR = "com.itheima.remoteservice.Iservice";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.itheima.remoteservice.Iservice interface,
 * generating a proxy if needed.
 */
public static com.itheima.remoteservice.Iservice asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.itheima.remoteservice.Iservice))) {
return ((com.itheima.remoteservice.Iservice)iin);
}
return new com.itheima.remoteservice.Iservice.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_callTestMethod:
{
data.enforceInterface(DESCRIPTOR);
this.callTestMethod();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.itheima.remoteservice.Iservice
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
//把想暴露的方法暴露出来

@Override public void callTestMethod() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_callTestMethod, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_callTestMethod = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
//把想暴露的方法暴露出来

public void callTestMethod() throws android.os.RemoteException;
}
