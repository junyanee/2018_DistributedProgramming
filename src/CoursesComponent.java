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
 *      Course 정보와 관련된 기능을 처리하는 컴포넌트.
 */
public class CoursesComponent {
    public static void main(String[] args) throws InterruptedException {
        EventBusInterface eventBusInterface = new EventBusInterface();
        Event event = null;
        EventQueue eventQueue = null;
        boolean done = false;
        CoursesList coursesList = null;
        SincheongList sincheongList = null;
        
        if(eventBusInterface.getComponentId() != -1) {
	    	System.out.println("CoursesComponent (ID:" + eventBusInterface.getComponentId() + ") is successfully registered...");
	    } else {
	    	System.out.println("CoursesComponent is failed to register. Restart this component.");
	    }
	    
        try {
            coursesList = new CoursesList("Courses.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        while(!done) {
            eventQueue = eventBusInterface.getEventQueue();
            
            for(int i = 0; i < eventQueue.getSize(); i++) {
                event = eventQueue.getEvent();
                System.out.println("Received an event(ID: " + event.getEventId() + ")...");
                
                // 모든 Course들의 리스트를 한개의 String 객체로 만들어 사용자에게 출력할 수 있도록 이벤트를 발생한다.
                if(event.getEventId() == EventId.ListCourses) {
                    String returnString = "";
                    for(int j = 0; j < coursesList.vCourse.size(); j++) {
                        returnString += ((Course) coursesList.vCourse.get(j)).toString() + "\n";
                    }
                    
                    System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
                    System.out.println("\n ** Message: \n" + returnString + "\n  ...");
                    eventBusInterface.sendEvent(new Event(EventId.ClientOutput, returnString));
                    
                } else if(event.getEventId() == EventId.RegisterCourses) {
                    // 새로운 Course를 등록한다.                   
                	String courseInfo = event.getMessage();
                	Course course = new Course(courseInfo);
                    if(coursesList.isRegisteredCourse(course.courseId) == false){
                        // 만약 존재하지 않는 Course라면 courseInfo를 통해 받아온 정보들을 vCourse 어레이에 저장한다.
                    	coursesList.vCourse.add(new Course(courseInfo));
                        System.out.println("A new course is successfully added...");
                		System.out.println("\"" + courseInfo + "\"");
                    } else{
                    	// 만약 이미 존재하는 Course라면 이미 있는 학생이라는 메세지를 띄운다.
                    	System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
                        System.out.println("\n ** Message: This course is already registered.  ...");
                        eventBusInterface.sendEvent(new Event(EventId.ClientOutput, "This course is already registered."));
                    }
                    
                }else if(event.getEventId() == EventId.DeleteCourses) {
                    // Course를 삭제한다.                   
                	String ID = event.getMessage();
                    if(coursesList.isRemovedCourse(ID) == false){
                    	// 만약 이미 존재하는 Course라면 vCourse 어레이에서 해당 ID의 학생을 삭제한다.
                    	coursesList.vCourse.remove(ID);
                        System.out.println("A course is successfully removed...");
                		System.out.println("\"" + ID + "\"");
                    } else{
                    	// 만약 존재하지 않는 Course라면 이미 지워진 수업이라는 메세지를 띄운다.
                    	System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
                        System.out.println("\n ** Message: This course is already removed.  ...");
                        eventBusInterface.sendEvent(new Event(EventId.ClientOutput, "This course is already removed."));
                    }
                    
                } 	else if(event.getEventId() == EventId.CheckIfCourseExist) {
                    // Course가 어레이에 존재하는지를 체크한다.              
                    String courseID = event.getMessage();
                    if(coursesList.isRegisteredCourse(courseID) == false){
                    	// 존재하지 않는 수업일 때 등록되지 않았다고 메세지를 띄운다.
                    	System.out.println("등록되지 않은 과목입니다");
                    	eventBusInterface.sendEvent(new Event(EventId.ClientOutput, "등록되지 않은 과목입니다."));
						System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
						System.out.println("\n ** Message: 등록되지 않은 과목입니다.  ...");
                    	
                    } else{
                    	// 존재하는 수업일 때 등록된 과목이라는 메세지를 띄우고 RegisterSincheong 이벤트를 보낸다.
                    	System.out.println("등록된 과목입니다");
                    	System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
						System.out.println("\n ** Message: This course does exist  ...");
						// 신청리스트를 만들어서 신청과목의 ID 값을 넣는다
						sincheongList = new SincheongList();
						sincheongList.vSincheong.add(courseID);
						System.out.println(sincheongList.vSincheong);
						eventBusInterface.sendEvent(new Event(EventId.RegisterSincheong, courseID));
                    }                    
                    
                } else if(event.getEventId() == EventId.QuitTheSystem) {
                    // 시스템을 종료한다.
                    eventBusInterface.unRegister();
                    done = true;
                }
            }
            Thread.sleep(100);
        }     
        System.out.println("Shut down the component....");
    }
}
