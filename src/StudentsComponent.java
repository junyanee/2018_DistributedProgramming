
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
 * @description Student 정보와 관련된 기능을 처리하는 컴포넌트.
 */
public class StudentsComponent {
	public static void main(String args[]) throws InterruptedException {
		EventBusInterface eventBusInterface = new EventBusInterface();
		Event event = null;
		EventQueue eventQueue = null;
		boolean done = false;
		StudentsList studentsList = null;
		SincheongList sincheongList = null;

		if (eventBusInterface.getComponentId() != -1) {
			System.out.println(
					"StudentsComponent (ID:" + eventBusInterface.getComponentId() + ") is successfully registered...");
		} else {
			System.out.println("StudentsComponent is failed to register. Restart this component.");
		}

		try {
			studentsList = new StudentsList("Students.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (!done) {
			eventQueue = eventBusInterface.getEventQueue();

			for (int i = 0; i < eventQueue.getSize(); i++) {
				event = eventQueue.getEvent();
				System.out.println("Received an event(ID: " + event.getEventId() + ")...");
				
				if (event.getEventId() == EventId.ListStudents) {
					// 모든 Student들의 리스트를 한개의 String 객체로 만들어 사용자에게 출력할 수 있도록 이벤트를
					// 발생한다.
					String returnString = "";
					for (int j = 0; j < studentsList.vStudent.size(); j++) {
						returnString += (j == 0 ? "" : "\n") + ((Student) studentsList.vStudent.get(j)).toString();
					}

					System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
					System.out.println("\n ** Message: \n" + returnString + "\n  ...");
					eventBusInterface.sendEvent(new Event(EventId.ClientOutput, returnString));

				} else if (event.getEventId() == EventId.RegisterStudents) {
					// 새로운 Student를 등록한다.
					String studentInfo = event.getMessage();
					System.out.println("Not null");
					Student student = new Student(studentInfo);
					if (studentsList.isRegisteredStudent(student.studentId) == false) {
						// 만약 존재하지 않는 Student라면 studentInfo를 통해 받아온 정보들을 vStudent 어레이에 저장한다.
						studentsList.vStudent.add(new Student(studentInfo));
						System.out.println("A new student is successfully added...");
						System.out.println("\"" + studentInfo + "\"");
					} else {
						// 만약 이미 존재하는 Student라면 이미 있는 학생이라는 메세지를 띄운다.
						System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
						System.out.println("\n ** Message: This student is already registered.  ...");
						eventBusInterface
								.sendEvent(new Event(EventId.ClientOutput, "This student is already registered."));
					}

				} else if (event.getEventId() == EventId.DeleteStudents) {
					// Student를 삭제한다.
					String ID = event.getMessage();
					if (studentsList.isRemovedStudent(ID) == false) {
						// 만약 이미 존재하는 Student라면 vStudent 어레이에서 해당 ID의 학생을 삭제한다.
						studentsList.vStudent.remove(ID);
						System.out.println("A student is successfully removed...");
						System.out.println("\"" + ID + "\"");
					} else {
						// 만약 존재하지 않는 Student라면 이미 지워진 학생이라는 메세지를 띄운다.
						System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
						System.out.println("\n ** Message: This student is already removed.  ...");
						eventBusInterface.sendEvent(new Event(EventId.ClientOutput, "This student is already removed."));
					}

				} else if (event.getEventId() == EventId.CheckIfStudentExist) {
					// Student가 어레이에 존재하는지를 체크한다.
					String check = event.getMessage();
					if (studentsList.isRegisteredStudent(check) == false) {
						// 존재하지 않는 학생일 때 등록되지 않았다고 메세지를 띄운다.
						System.out.println("등록되지 않은 학생입니다.");
						eventBusInterface.sendEvent(new Event(EventId.ClientOutput, "등록되지 않은 학생입니다."));
						System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
						System.out.println("\n ** Message: 등록되지 않은 학생입니다.  ...");

					} else {
						// 존재하는 학생일 때 등록된 학생이라는 메세지를 띄우고 RegisterSincheong 이벤트를 보낸다.
						System.out.println("등록된 학생입니다.");
						System.out.println("\n ** Sending an event(ID:" + EventId.ClientOutput + ") with");
						System.out.println("\n ** Message: This student does exist  ...");
						// 신청리스트를 만들어서 신청학생의 ID 값을 넣는다
						sincheongList = new SincheongList();
						sincheongList.vSincheong.add(check);
						System.out.println(sincheongList.vSincheong);
						eventBusInterface.sendEvent(new Event(EventId.RegisterSincheong, check));
					}

				} else if (event.getEventId() == EventId.QuitTheSystem) {
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
