import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import EventPackage.Event;
import EventPackage.EventBusInterface;
import EventPackage.EventId;
import EventPackage.EventQueue;

public class SincheongComponent {
	SincheongList sincheongList = new SincheongList();
	
	
	public static void main(String args[]) throws InterruptedException {
		EventBusInterface eventBusInterface = new EventBusInterface();
		Event event = null;
		EventQueue eventQueue = null;
		boolean done = false;
		SincheongList sincheongList = null;
		SincheongList sincheongList2 = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		if (eventBusInterface.getComponentId() != -1) {
			System.out.println(
					"SincheongComponent (ID:" + eventBusInterface.getComponentId() + ") is successfully registered...");
		} else {
			System.out.println("SincheongComponent is failed to register. Restart this component.");
		}

		while (!done) {
			eventQueue = eventBusInterface.getEventQueue();
			for (int i = 0; i < eventQueue.getSize(); i++) {
				event = eventQueue.getEvent();
				System.out.println("Received an event(ID: " + event.getEventId() + ")...");
				if (event.getEventId() == EventId.ListSincheong) {
					ArrayList returnString = sincheongList.vSincheong;
		               String a = returnString.toString();
		               System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
		               System.out.println("\n ** Message: \n" + returnString + "\n  ...");
		               eventBusInterface.sendEvent(new Event(EventId.ClientOutput, a));
		               
				} else if (event.getEventId() == EventId.RegisterSincheong) {
					// 체크 완료된 거 받음
					String Checked = event.getMessage();
					System.out.println("Checked...");
					System.out.println("\"" + Checked + "\"");
					System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
					System.out.println("\n ** Message: " + Checked + " 신청 가능.  ...");
					
					// 신청리스트를 만들어서 신청 ID 값을 넣는다
					sincheongList.vSincheong.add(Checked);
					String a = sincheongList.vSincheong.toString();
					System.out.println(sincheongList.vSincheong);
					
					eventBusInterface.sendEvent(new Event(EventId.ListCourses, null));

				}  else if (event.getEventId() == EventId.QuitTheSystem) {
					eventBusInterface.unRegister();
					done = true;
				}
			}
			Thread.sleep(100);
		}
		System.out.println("Shut down the component....");
	}
	
}
