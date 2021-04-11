/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */

package EventPackage;

import java.rmi.Naming;
import java.rmi.RemoteException;


/**
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-07
 * @version 1.0
 * @description
 *      RMI 서버인 EventBus와 통신하기 위한 인터페이스 역할을 하는 클래스. (Interface class는 아님) 
 */
public class EventBusInterface {
    private long componentId = -1;
	private RMIEventBusInterface rmiEventBusInterface = null;
	
	public EventBusInterface() {
		if (componentId == -1) { // 해당 컴포넌트가 아직 RMI 서버에 register 되지 않았음을 의미한다.
		    try {
                rmiEventBusInterface = (RMIEventBusInterface) Naming.lookup("EventBus");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Cannot find the EventBus.");
            }
		    
		    try {
		        componentId = rmiEventBusInterface.register();
            } catch (RemoteException e) {
                e.printStackTrace();
                System.out.println("Cannot be registered");
            }
		    
		} else {
			System.out.println("Already registered");
		}
	}

	/**
	 * Event를 전송하는 Method
	 * 
	 * @param event
	 */
	public void sendEvent(Event event) {
		if (componentId != -1) {
		   	try {
				rmiEventBusInterface.sendEvent(event);
	    	} catch (Exception e) {
				System.out.println("Cannot send an event");
			}
		}
	}

	/**
	 * 해당 컴포넌트로 자신의 EventQueue를 반환한다.
	 * 
	 * @return
	 */
	public EventQueue getEventQueue() {
		EventQueue eventQueue = null;

		if (componentId != -1) {
	    	try {
				eventQueue = rmiEventBusInterface.getEventQueue(componentId);
	    	} catch(Exception e) {
				 System.out.println("Error getting an event queue.");
	    	}
	    } else {
			System.out.println("Not registered");
		}
		return eventQueue;
	}

	/**
	 * 해당 컴포넌트를 unregister한다.
	 */
	public void unRegister() {
		if (componentId != -1) {
		   	try {
				rmiEventBusInterface.unRegister(componentId);
		   	} catch (Exception e) {
				System.out.println("Error unregistering");
		    }
	    } else {
	        System.out.println("Not registered");
		}
	}
	
	public long getComponentId() {
		return this.componentId;
	}
}