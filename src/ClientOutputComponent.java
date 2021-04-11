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
 *      사용자가 요청한 기능들의 결과를 확인할 수 있는 Output 컴포넌트. 모든 기능의 결과값은 이곳으로 출력된다.
 */
public class ClientOutputComponent {
    public static void main(String[] args) throws InterruptedException {
        EventBusInterface eventBusInterface = new EventBusInterface();
        EventQueue eventQueue = null;
        Event event = null;
        boolean done = false;
        ClientOutputComponentWindow mainWindow = new ClientOutputComponentWindow();
        
        if(eventBusInterface.getComponentId() != -1) {
	    	System.out.println("ClientOutputComponent (ID:" + eventBusInterface.getComponentId() + ") is successfully registered...");
	    } else {
	    	System.out.println("ClientOutputComponent is failed to register. Restart this component.");
	    }
        
        while(!done) {
            eventQueue = eventBusInterface.getEventQueue();
            
            for(int i = 0; i < eventQueue.getSize(); i++) {
                event = eventQueue.getEvent();
                System.out.println("Received an event(ID: " + event.getEventId() + ")...");

                if(event.getEventId() == EventId.ClientOutput) {    
                	System.out.println(event.getMessage());
                    mainWindow.printText(event.getMessage());
                    
                    
                } else if(event.getEventId() == EventId.QuitTheSystem) {
                    eventBusInterface.unRegister();
                    mainWindow.printText("Quit the system.");
                    done = true;
                }
            }
            Thread.sleep(100);
        }
        mainWindow.quitWindow();
    }
}
