/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */

import EventPackage.Event;
import EventPackage.EventBusInterface;
import EventPackage.EventId;
import EventPackage.EventQueue;


/**
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-07
 * @version 1.0
 * @description
 *      ClientInputComponent가 EventBus와 통신하기 위한 컴포넌트.
 */
class ClientInputComponentInterface extends Thread {
	private EventBusInterface eventBusInterface = null;
	private long componentId;
	boolean registered = true;
	
	/**
	 * Constructor. EventBus와 통신하기 위한 EventBusInterface를 초기화한다.
	 */
	public ClientInputComponentInterface() {
	    try {
	        eventBusInterface = new EventBusInterface();
	    } catch(Exception e) {
	        e.printStackTrace();
	        registered = false;
	    }
	    this.componentId = eventBusInterface.getComponentId();
	}
	
	public void run() {
	    Event event = null;
	    EventQueue eventQueue = null;
	    boolean done = false;
	    
	    if(eventBusInterface != null) {
	        while(!done) {
	            try {
	                eventQueue = eventBusInterface.getEventQueue();
	            } catch(Exception e) {
	                e.printStackTrace();
	            }
	            
	            int queueSize = eventQueue.getSize();
	            
	            for(int i = 0; i < queueSize; i++) {
	                event = eventQueue.getEvent();
	                if(event.getEventId() == EventId.QuitTheSystem) {
	                    done = true;
	                }
	            }
	        }
	    } else {
	        System.out.println("Unable to register this component");
	    }
	}
	
	/**
	 * EventBus에 Event를 보내는 Method.
	 * @param sentEventId
	 * @param sentMessage
	 */
	public void sendClientInput(EventId sentEventId, String sentMessage) {
	    Event newEvent = new Event(sentEventId, sentMessage);
        try {
            eventBusInterface.sendEvent(newEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public long getComponentId() {
		return this.componentId;
	}
} 