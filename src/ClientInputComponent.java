
/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import EventPackage.Event;
import EventPackage.EventId;

/**
 * 
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-07
 * @version 1.0
 * @description 시스템 사용자가 입력값을 줄 수 있는 Text-based User Interface 컴포넌트.
 */
public class ClientInputComponent {

	public static void main(String[] args) throws InterruptedException {
		ClientInputComponentInterface clientInputComponent = new ClientInputComponentInterface();

		if (clientInputComponent.registered) {
			System.out.println("ClientInputComponent (ID:" + clientInputComponent.getComponentId()
					+ ") is successfully registered...");
			clientInputComponent.start();

			while (true) {
				// 사용자가 사용 가능한 메뉴 출력
				System.out.println("Registeration System\n");
				System.out.println("1. List Students");
				System.out.println("2. List Courses");
				System.out.println("3. Register a new Student");
				System.out.println("4. Register a new Course");
				System.out.println("5. Delete Student");
				System.out.println("6. Delete Course");
				System.out.println("7. Register Sincheong");
				System.out.println("8. List Sincheong");
				System.out.println("\n 0. Quit the system");

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				try {
					String selection = br.readLine().trim();

					// 사용자가 선택한 메뉴에 따라 추가 입력값을 받고 이벤트를 전송.
					if (selection.equals("1")) {
						clientInputComponent.sendClientInput(EventId.ListStudents, null);

					} else if (selection.equals("2")) {
						clientInputComponent.sendClientInput(EventId.ListCourses, null);

					} else if (selection.equals("3")) {
						String msg = "";
						boolean inputIsDone = false;
						while (!inputIsDone) {
							System.out.println("\nEnter student ID and press return (Ex. 20131234)>> ");
							String sSID = br.readLine().trim();
							System.out.println("\nEnter family name and press return (Ex. Hong)>> ");
							String firstName = br.readLine().trim();
							System.out.println("\nEnter first name and press return (Ex. Gildong)>> ");
							String lastName = br.readLine().trim();
							System.out.println("\nEnter department and press return (Ex. CS)>> ");
							String dep = br.readLine().trim();
							System.out.println(
									"\nEnter a list of IDs (put a space between two different IDs) of the completed courses and press return >> ");
							System.out.println("(Ex. 17651 17652 17653 17654)");
							String completedCourse = br.readLine().trim();
							msg = sSID + " " + lastName + " " + firstName + " " + dep + " " + completedCourse;

							while (true) {
								System.out.println("\nIs it correct information? (Y/N)");
								System.out.println(msg);
								String ans = br.readLine().trim();
								if (ans.equalsIgnoreCase("y")) {
									inputIsDone = true;
									break;
								} else if (ans.equalsIgnoreCase("n")) {
									System.out.println("\nType again...");
									msg = "";
									break;
								} else {
									System.out.println("\nTyped wrong answer");
								}
							}
						}

						System.out.println("\n ** Sending an event(ID:" + EventId.RegisterStudents + ") with ");
						System.out.println("\n ** Message \"" + msg + "\" ...");
						clientInputComponent.sendClientInput(EventId.RegisterStudents, msg);

					} else if (selection.equals("4")) {
						String userInput = "";
						boolean inputIsDone = false;

						while (!inputIsDone) {
							System.out.println("\nEnter course ID and press return (Ex. 12345)>> ");
							userInput = br.readLine().trim();
							System.out.println(
									"\nEnter the family name of the instructor and press return (Ex. Hong)>> ");
							userInput += " " + br.readLine().trim();
							System.out.println(
									"\nEnter the name of the course ( substitute a space with ab underbar(_) ) and press return (Ex. C++_Programming)>> ");
							userInput += " " + br.readLine().trim();
							System.out.println(
									"\nEnter a list of IDs (put a space between two different IDs) of prerequisite courses and press return >> ");
							System.out.println("(Ex. 12345 17651)");
							userInput += " " + br.readLine().trim();

							while (true) {
								System.out.println("\nIs it correct information? (Y/N)");
								System.out.println(userInput);
								String ans = br.readLine().trim();
								if (ans.equalsIgnoreCase("y")) {
									inputIsDone = true;
									break;
								} else if (ans.equalsIgnoreCase("n")) {
									System.out.println("\nType again...");
									userInput = "";
									break;
								} else {
									System.out.println("\nTyped wrong answer");
								}
							}
						}

						System.out.println("\nSending an event(ID:" + EventId.RegisterCourses + ") with");
						System.out.println("\n ** Message \"" + userInput + "\" ...");
						clientInputComponent.sendClientInput(EventId.RegisterCourses, userInput);

					} else if (selection.equals("5")) {
						String aaa = "";
						StudentsList studentsList = null;
						boolean inputIsDone = false;

						while (!inputIsDone) {
							clientInputComponent.sendClientInput(EventId.ListStudents, null);
							System.out.println("!!Check Student Information!!");

							System.out.println("\nEnter student ID and press return (Ex. 20120808)>> ");
							String sSID = br.readLine().trim();
							aaa = sSID;

							while (true) {
								System.out.println("\nIs it correct information? (Y/N)");
								System.out.println(aaa);
								String ans = br.readLine().trim();
								if (ans.equalsIgnoreCase("y")) {
									inputIsDone = true;
									break;
								} else if (ans.equalsIgnoreCase("n")) {
									System.out.println("\nType again...");
									aaa = "";
									break;
								} else {
									System.out.println("\nTyped wrong answer");
								}
							}
							Thread.sleep(1000);
						}

						System.out.println("\n ** !!!!!!!Sending an event(ID:" + EventId.DeleteStudents + ") with ");
						System.out.println("\n ** Message \"" + aaa + "\" ...");
						clientInputComponent.sendClientInput(EventId.DeleteStudents, aaa);
						clientInputComponent.sendClientInput(EventId.ListStudents, null);

					} else if (selection.equals("6")) {
						String bbb = "";
						boolean inputIsDone = false;

						while (!inputIsDone) {
							clientInputComponent.sendClientInput(EventId.ListCourses, null);
							System.out.println("!!Check Course Information!!");

							System.out.println("\nEnter course ID and press return (Ex. 12345)>> ");
							bbb = br.readLine().trim();

							while (true) {
								System.out.println("\nIs it correct information? (Y/N)");
								System.out.println(bbb);
								String ans = br.readLine().trim();
								if (ans.equalsIgnoreCase("y")) {
									inputIsDone = true;
									break;
								} else if (ans.equalsIgnoreCase("n")) {
									System.out.println("\nType again...");
									bbb = "";
									break;
								} else {
									System.out.println("\nTyped wrong answer");
								}
							}
						}
						System.out.println("\n ** !!!!!!!Sending an event(ID:" + EventId.DeleteCourses + ") with ");
						System.out.println("\n ** Message \"" + bbb + "\" ...");
						clientInputComponent.sendClientInput(EventId.DeleteCourses, bbb);
						clientInputComponent.sendClientInput(EventId.ListCourses, null);

					} else if (selection.equals("7")) {
						String checkS = "";
						String checkC = "";
						boolean inputIsDone = false;
						while (!inputIsDone) {
							// 학생리스트를 띄운다.
							System.out.println("!!Check Student Information!!");
							clientInputComponent.sendClientInput(EventId.ListStudents, null);

							System.out.println("\nEnter student ID and press return (Ex. 20131234)>> ");
							// 학생 ID를 입력 받는다.
							String sSID = br.readLine().trim();
							checkS = sSID;

							while (true) {
								System.out.println("\nIs it correct student information? (Y/N)");
								System.out.println(checkS);
								String ans = br.readLine().trim();
								if (ans.equalsIgnoreCase("y")) {
									inputIsDone = true;
									break;
								} else if (ans.equalsIgnoreCase("n")) {
									System.out.println("\nType again...");
									checkS = "";
									break;
								} else {
									System.out.println("\nTyped wrong answer");
								}
							}
							System.out.println("\nSending an event(ID:" + EventId.CheckIfStudentExist + ") with");
							System.out.println("\n ** Message \"" + checkS + "\" ...");
							// StudentsComponent에 학생ID를 판별하라고 CheckIfStudentExist 이벤트 보냄
							clientInputComponent.sendClientInput(EventId.CheckIfStudentExist, checkS);
							StudentsList studentsList = new StudentsList("Students.txt");

							// 학생 ID판별
							if (studentsList.isRegisteredStudent(checkS) == false) {
							// 존재하지 않는 학생일 시
								System.out.println("존재하지 않는 학생입니다!!! 메인화면으로 돌아갑니다.");
								break;
							} else {
							// 존재하는 학생일 시 과목리스트를 띄운다.
								System.out.println("!!Check Course Information!!");
								System.out.println("Enter CourseID and press return (Ex.12345)>> ");
							}

							clientInputComponent.sendClientInput(EventId.ListCourses, null);

							// 과목 ID를 입력받는다.
							checkC = br.readLine().trim();

							while (true) {
								System.out.println("\nIs it correct information? (Y/N)");
								System.out.println(checkC);
								String ans = br.readLine().trim();
								if (ans.equalsIgnoreCase("y")) {
									inputIsDone = true;
									break;
								} else if (ans.equalsIgnoreCase("n")) {
									System.out.println("\nType again...");
									checkC = "";
									break;
								} else {
									System.out.println("\nTyped wrong answer");
								}
							}
							System.out.println("\nSending an event(ID:" + EventId.CheckIfCourseExist + ") with");
							System.out.println("\n ** Message \"" + checkC + "\" ...");
							// CoursesComponent에 과목ID를 판별하라고 CheckIfCourseExist 이벤트 보냄
							clientInputComponent.sendClientInput(EventId.CheckIfCourseExist, checkC);

							CoursesList coursesList = new CoursesList("Courses.txt");

							// 과목 ID 판별
							if (coursesList.isRegisteredCourse(checkC) == false) {
								// 존재하지 않는 과목일 시
								System.out.println("존재하지 않는 수업입니다!!! 메인화면으로 돌아갑니다.");
								break;
							} else {
								// 존재하는 과목일 시 신청이 완료됨을 띄운다.
								System.out.println("Sincheong Accessed!!!!!!");
							}
						}
					} else if (selection.equals("8")) {
						System.out.println("현재 수강신청된 목록입니다. [학생ID, 과목ID]");
						System.out.println("ex) [학생1, 과목1, 학생2, 과목2]");
						clientInputComponent.sendClientInput(EventId.ListSincheong, null);

					} else if (selection.equals("0")) {
						System.out.println("\nSending an event(ID:" + EventId.QuitTheSystem + ")...");
						clientInputComponent.sendClientInput(EventId.QuitTheSystem, null);
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				Thread.sleep(100);
			}
		}
	}

}








