/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */

package EventPackage;

import java.io.Serializable;

/**
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-07
 * @version 1.0
 * @description
 *      Event 객체를 위한 클래스.
 */
public class Event implements Serializable {
    private static final long serialVersionUID = 1L; //Default serializable vale
    
    // 1개의 Event는 Event를 통해 전달할 메세지와 해당 Event를 식별할 Event ID로 구성되어 있다.
    private String message;
	private EventId eventId;

	public Event(EventId id, String text ) {
		this.message = text;
		this.eventId = id;
	}

	public Event(EventId id ) {
		this.message = null;
		this.eventId = id;
	}
	
	public EventId getEventId() {
		return eventId;
	}
	
	public String getMessage() {
		return message;
	}

}