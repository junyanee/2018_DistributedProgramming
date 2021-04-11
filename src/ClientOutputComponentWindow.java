/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


/**
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-07
 * @version 1.0
 * @description
 *      ClientOutputComponent에서 받은 결과값들을 실질적으로 출력하기 위한 Graphical User Interface 컴포넌트. 
 */
public class ClientOutputComponentWindow {
    private JFrame mainWindow;
    private JTextArea textArea;

    /**
     * Constructor. 기본 윈도우를 초기화한다.
     *
     */
    public ClientOutputComponentWindow() {
        mainWindow = new JFrame("Client Output Window");
        JPanel textPanel = new JPanel();
        Dimension screenSize = mainWindow.getToolkit().getScreenSize();
        
        mainWindow.setBounds(0, 0, (int) (screenSize.width * 0.5), (int) (screenSize.height * 0.30));
        mainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        textArea = new JTextArea((int)(screenSize.height/100),(int)(screenSize.width/24));
        textArea.setLineWrap(true);
        
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        
        mainWindow.add(textPanel);
        textPanel.add(textAreaScrollPane);
        
        mainWindow.setVisible(true);
        textArea.append("Start the client output component.\n");
    }
    
    /**
     * 결과값(String text)을 출력한다.
     * @param text
     */
    public void printText(String text) {
        textArea.append("\n======== New event has been arrived ========\n");
        textArea.append(text + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    /**
     * 윈도우를 종료한다.
     */
    public void quitWindow() {
        mainWindow.dispose();
    }
}
