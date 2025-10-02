package ex0819.multichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class ClientGUIChatExam extends JFrame{
	
	JTextArea textArea = new JTextArea();
	JTextField textField = new JTextField();
	
	JScrollPane scrollPane = new JScrollPane(textArea);
	Socket sk;
	PrintWriter pw;
	BufferedReader br;
	String ip;
	
	
	public ClientGUIChatExam() {
		super("채팅프로그램");
		
		Container con = getContentPane();
		con.add(textField, BorderLayout.SOUTH);
		con.add(scrollPane, BorderLayout.CENTER);
		
		//옵션 설정
		textArea.setFocusable(false);
		textArea.setBackground(Color.MAGENTA);
		
		setSize(500, 400);
		
		setLocationRelativeTo(null);
		
		setVisible(true);
		getRootPane().registerKeyboardAction(e->{
			dispose();
		},
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ip = JOptionPane.showInputDialog("ip주소 마지막자리");
		//서버에 연결
		connection();
		
		//이벤트처리(JTextFiled에 값을 입력하고 enter를 눌렀을 때)
		textField.addActionListener((e)->{
			String msg = textField.getText();
			textField.setText("");
			pw.println(msg);
		});
		
		//서버가 보내온 데이터를 받는 JTextArea에 추가하는 스레드 
		new Thread(()->{
			try {
				while(true) {
					String msg = br.readLine();	
					textArea.append(msg + "\n");
					
					//옵션
					textArea.setCaretPosition(textArea.getText().length());
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}).start();
	}
	
	/**
	 * 서버 접속 요청 메서드
	 */
	public void connection() {
		try {
			sk = new Socket("192.168.0."+ip, 8000);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			pw = new PrintWriter(sk.getOutputStream(), true);
			
			//대화명 입력 창을 띄운다.
			String nickName = JOptionPane.showInputDialog(this, "닉네임?");
			pw.println(nickName);
			
			setTitle(nickName + " 접속 중");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ClientGUIChatExam();
	}

}
