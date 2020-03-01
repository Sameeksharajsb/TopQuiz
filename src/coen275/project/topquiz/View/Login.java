package coen275.project.topquiz.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1252, 683);
		
		JPanel content = new JPanel();
        content.setBorder(new EmptyBorder(6, 6, 6, 6));
        content.setLayout(new GridLayout(4, 4));
        
        JPanel a  = new JPanel();
        JPanel b   = new JPanel();
        JPanel c  = new JPanel();
        JPanel d   = new JPanel();
        JPanel e = new JPanel();
        JPanel h = new JPanel();
        JPanel i = new JPanel();
        JPanel j   = new JPanel();
        JPanel k = new JPanel();
        JPanel l = new JPanel();
        JPanel m = new JPanel();
        JPanel n = new JPanel();
        JPanel p = new JPanel();
       
        content.add(a);
        content.add(b);
        content.add(c);
        content.add(d);
        content.add(e);
        
        JPanel pnlUserName = new JPanel();
        content.add(pnlUserName);
        pnlUserName.setLayout(new BorderLayout(0, 0));
        JLabel lblUserName = new JLabel("User Name:  ");
        lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlUserName.add(lblUserName, BorderLayout.SOUTH);
        
        JPanel pnlUserText = new JPanel();
        content.add(pnlUserText);
        JTextField txtUserName = new JTextField("");
        txtUserName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout gl_pnlUserText = new GroupLayout(pnlUserText);
        gl_pnlUserText.setHorizontalGroup(
        	gl_pnlUserText.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnlUserText.createSequentialGroup()
        			.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pnlUserText.setVerticalGroup(
        	gl_pnlUserText.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_pnlUserText.createSequentialGroup()
        			.addContainerGap(117, Short.MAX_VALUE)
        			.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        );
        pnlUserText.setLayout(gl_pnlUserText);
        content.add(h);
        content.add(i);
        content.add(j);
        content.add(k);
        content.add(l);
        content.add(m);
        content.add(n);
        
        JPanel pnlGo = new JPanel();
        content.add(pnlGo);
        JButton btnGo = new JButton("GO");
        btnGo.setFont(new Font("Times New Roman", Font.BOLD, 28));
        GroupLayout gl_pnlGo = new GroupLayout(pnlGo);
        gl_pnlGo.setHorizontalGroup(
        	gl_pnlGo.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnlGo.createSequentialGroup()
        			.addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(201, Short.MAX_VALUE))
        );
        gl_pnlGo.setVerticalGroup(
        	gl_pnlGo.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnlGo.createSequentialGroup()
        			.addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(111, Short.MAX_VALUE))
        );
        pnlGo.setLayout(gl_pnlGo);
        content.add(p);

        frame.getContentPane().add(content);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
	}
}
