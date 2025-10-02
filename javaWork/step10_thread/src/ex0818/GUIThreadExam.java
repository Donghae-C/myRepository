package ex0818;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUIThreadExam extends JFrame{
	JTextField text1 = new JTextField(5);
	JTextField text2 = new JTextField(5);
	JButton btn1 = new JButton("push");
	public GUIThreadExam() {
		super("GUIThreadExam 입니다");
		
		//JFrame의 레이아웃 변경
		setLayout(new FlowLayout());
		
		//container 위에 component 추가
		Container con = getContentPane();
		con.add(text1);
		con.add(text2);
		con.add(btn1);
		
		Thread clock = new Thread(()-> {
			StringBuilder sb = new StringBuilder();
			while(true) {
				LocalDateTime now = LocalDateTime.now();
				int y = now.getYear();
				int m = now.getMonthValue();
				int d = now.getDayOfMonth();
				
				int h = now.getHour();
				int min = now.getMinute();
				int sec = now.getSecond();
				
				sb.append(y).append("년").append(m).append("월").append(d).append("일").append(h).append(":")
				.append(min).append(":").append(sec);
				GUIThreadExam.this.setTitle(sb.toString());
				sb.setLength(0);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					
				}
			}
		}, "시계");
		
		Thread textBox1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=1;i<=1000;i++) {
					text1.setText(i+"");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread button1 = new Thread(()->{
			for(char ch='A'; ch<='Z';ch++) {
				text2.setText(ch+"");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		btn1.addActionListener((e)->button1.start());
		
		
		
		
		
		
		clock.start();
		textBox1.start();
		
		
		
		
		//옵션설정
		//창 크기
		setSize(500, 400);
		setLocationRelativeTo(null);
		
		
		
		//보이게하기
		setVisible(true);
		//x를 클릭했을때 창 닫기
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GUIThreadExam();
	}

}
