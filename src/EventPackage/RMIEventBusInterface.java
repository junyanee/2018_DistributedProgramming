/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */

package EventPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-07
 * @version 1.0
 * @description
 *      RMI 통신을 하기 위한 Interface class.
 */
public interface RMIEventBusInterface extends Remote {
	public long register() throws RemoteException;
	public void unRegister(long SenderID) throws RemoteException;
	public void sendEvent(Event m ) throws RemoteException;
	public EventQueue getEventQueue(long SenderID) throws RemoteException;
}
