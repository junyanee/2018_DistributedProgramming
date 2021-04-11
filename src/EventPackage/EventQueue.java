/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */

package EventPackage;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;


/**
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-07
 * @version 1.0
 * @description
 *      Event들을 저장하는 Queue 객체.
 */
public class EventQueue implements Serializable
{
    private static final long serialVersionUID = 1L; // Default value for Serializable interface
    
    private Vector<Event> eventList;
	private long componentId;

	public EventQueue() {
		eventList = new Vector<Event> (15, 1);
		componentId = Calendar.getInstance().getTimeInMillis();
	}
	
	public long getId()	{
		return componentId;
	}

	public int getSize() {
		return eventList.size();
	}
	
	public void addEvent(Event newEvent) {
		eventList.add(newEvent);
	}
	
	public Event getEvent() {
		Event event = null;
		if (eventList.size() > 0) {
			event = eventList.get(0);
			eventList.removeElementAt(0);
		}
		return event;
	}
	
	public void clearEventQueue() {
		eventList.removeAllElements();
	}

	@SuppressWarnings("unchecked")
	public EventQueue getCopy() {
		EventQueue eventQueue = new EventQueue();
		eventQueue.componentId = componentId;
		eventQueue.eventList = (Vector<Event>) eventList.clone();

		return eventQueue;
	}
}