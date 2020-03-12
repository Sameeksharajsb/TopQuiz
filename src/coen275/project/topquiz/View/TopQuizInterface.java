package coen275.project.topquiz.View;

import coen275.project.topquiz.Controller.*;
import coen275.project.topquiz.Model.*;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class TopQuizInterface {

	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtTimeLimit;
	private JTextField txtAttemptsAllowed;
	private JTextField txtTotalScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopQuizInterface window = new TopQuizInterface();
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
	public TopQuizInterface() {
		portal = new Portal();
		initialize();
	}

	Portal portal;
	User user;
	Quiz quiz;
	JPanel topPanel;
	JPanel bannerPanel;
	JLabel lblHeader;
	JPanel logoPanel;
	JPanel middlePanel;
	JPanel checkboxPanel;
	JLabel lblQuestion;
	ButtonGroup radioButtonGroup;
	JRadioButton chk_option1;
	JRadioButton chk_option2;
	JRadioButton chk_option3;
	JRadioButton chk_option4;
	JPanel loginPanel;
	JLabel lblUserName;
	JLabel lblQuestionNumber;
	JPanel selectPanel;
	JLabel lblSelectQuiz;
	JComboBox<String> cbSelectQuiz;
	JLabel lblDifficultyLevel;
	JComboBox<String> cbDifficultyLevel;
	JButton btnCreate;
	JButton btnEdit;
	JButton btnViewResults;
	JPanel savePanel;
	JLabel lblQuizName;
	JLabel lblDifficultyLevelInSave;
	JButton btnSave;
	JButton btnSaveBack;
	JLabel lblTimeLimit;
	JLabel lblAttemptsAllowed;
	JLabel lblTotalScore;
	JLabel lblQuestionBank;
	JLabel lblQuizValue;
	JLabel lbllevelValue;
	JComboBox<String> cbQuestionBank;
	JPanel bottomPanel;
	JButton btnNext;
	JButton btnBack;
	JButton btnLogin;
	JButton btnStart;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1282, 834);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 try
		 {
			CreateContainer();
			CreateLoginInterface();
			CreateQuizSelectionInterface();
			CreateQuizModificationInterface();
			CreateMcqCheckboxInterface();
			ShowHideControlsOnLoad();
		 }
		 catch(Exception ex)
		 {
			 JOptionPane.showMessageDialog(frame, ex.toString());
		 }
	}

	private void CreateLoginInterface() {
		lblUserName = new JLabel("User Name:");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblUserName.setBounds(75, 200, 182, 43);
		loginPanel.add(lblUserName);

		txtUserName = new JTextField();
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		txtUserName.setColumns(10);
		txtUserName.setBounds(260, 200, 424, 43);
		loginPanel.add(txtUserName);
	}

	private void CreateMcqCheckboxInterface() {
		lblQuestion = new JLabel("This is my question?");
		lblQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(67, 98, 567, 43);
		checkboxPanel.add(lblQuestion);
         
		radioButtonGroup = new ButtonGroup();
		chk_option1 = new JRadioButton("Option1");
		chk_option1.setActionCommand(chk_option1.getText());
		chk_option1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		chk_option1.setBounds(228, 169, 137, 23);

		chk_option2 = new JRadioButton("Option2");
		chk_option2.setActionCommand(chk_option2.getText());
		chk_option2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		chk_option2.setBounds(228, 200, 97, 23);

		chk_option3 = new JRadioButton("Option3");
		chk_option3.setActionCommand(chk_option3.getText());
		chk_option3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		chk_option3.setBounds(228, 232, 97, 23);

		chk_option4 = new JRadioButton("Option4");
		chk_option4.setActionCommand(chk_option4.getText());
		chk_option4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		chk_option4.setBounds(228, 264, 97, 23);

		chk_option1.setSelected(true);
		radioButtonGroup.add(chk_option1);
		radioButtonGroup.add(chk_option2);
		radioButtonGroup.add(chk_option3);
		radioButtonGroup.add(chk_option4);
				
		checkboxPanel.add(chk_option1);
		checkboxPanel.add(chk_option2);
		checkboxPanel.add(chk_option3);
		checkboxPanel.add(chk_option4);
		JOptionPane.showMessageDialog(frame,radioButtonGroup.getSelection().getActionCommand());
	}

	private void CreateQuizModificationInterface() {
		lblQuizName = new JLabel("Quiz Name : ");
		lblQuizName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuizName.setBounds(216, 44, 169, 24);
		savePanel.add(lblQuizName);

		lblDifficultyLevelInSave = new JLabel("Difficulty level :");
		lblDifficultyLevelInSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDifficultyLevelInSave.setBounds(216, 92, 169, 24);
		savePanel.add(lblDifficultyLevelInSave);

		btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.setBounds(414, 374, 150, 47);
		savePanel.add(btnSave);

		btnSaveBack = new JButton("BACK");
		btnSaveBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowSelectWindow();
			}
		});
		btnSaveBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSaveBack.setBounds(261, 374, 143, 47);
		savePanel.add(btnSaveBack);

		lblTimeLimit = new JLabel("Time Limit : ");
		lblTimeLimit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTimeLimit.setBounds(216, 137, 180, 24);
		savePanel.add(lblTimeLimit);

		lblAttemptsAllowed = new JLabel("Attempts Allowed : ");
		lblAttemptsAllowed.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAttemptsAllowed.setBounds(216, 182, 180, 24);
		savePanel.add(lblAttemptsAllowed);

		lblTotalScore = new JLabel("Total Score : ");
		lblTotalScore.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotalScore.setBounds(216, 235, 180, 24);
		savePanel.add(lblTotalScore);

		lblQuestionBank = new JLabel("Question Bank :");
		lblQuestionBank.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuestionBank.setBounds(216, 283, 180, 24);
		savePanel.add(lblQuestionBank);

		lblQuizValue = new JLabel("lblQuizValue");
		lblQuizValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuizValue.setBounds(433, 44, 169, 24);
		savePanel.add(lblQuizValue);

		lbllevelValue = new JLabel("lblLevelValue");
		lbllevelValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbllevelValue.setBounds(433, 92, 169, 24);
		savePanel.add(lbllevelValue);

		txtTimeLimit = new JTextField();
		txtTimeLimit.setBounds(433, 133, 169, 29);
		savePanel.add(txtTimeLimit);
		txtTimeLimit.setColumns(10);

		txtAttemptsAllowed = new JTextField();
		txtAttemptsAllowed.setColumns(10);
		txtAttemptsAllowed.setBounds(433, 183, 169, 29);
		savePanel.add(txtAttemptsAllowed);

		txtTotalScore = new JTextField();
		txtTotalScore.setColumns(10);
		txtTotalScore.setBounds(433, 230, 169, 29);
		savePanel.add(txtTotalScore);

		cbQuestionBank = new JComboBox<String>();
		ArrayList<QuestionBank> all_questionBank = portal.getAllQuestio();
		for (Quiz quiz : all_quizzess) {
			cbSelectQuiz.addItem(quiz.getName());
		}
		
		
		cbQuestionBank.addItem("test1");
		cbQuestionBank.addItem("test2");
		cbQuestionBank.addItem("test3");
		cbQuestionBank.addItem("test4");
		cbQuestionBank.setBounds(433, 283, 169, 34);
		savePanel.add(cbQuestionBank);
	}

	private void CreateQuizSelectionInterface() {
		lblSelectQuiz = new JLabel("Select Quiz : ");
		lblSelectQuiz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSelectQuiz.setBounds(164, 116, 115, 24);
		selectPanel.add(lblSelectQuiz);

		cbSelectQuiz = new JComboBox<String>();
		cbSelectQuiz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ArrayList<Quiz> all_quizzess = portal.GetAllQuizzes();
		for (Quiz quiz : all_quizzess) {
			cbSelectQuiz.addItem(quiz.getName());
		}

		cbSelectQuiz.setBounds(289, 111, 243, 34);
		selectPanel.add(cbSelectQuiz);

		lblDifficultyLevel = new JLabel("Difficulty level :");
		lblDifficultyLevel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDifficultyLevel.setBounds(136, 179, 138, 24);
		selectPanel.add(lblDifficultyLevel);

		cbDifficultyLevel = new JComboBox<String>();
		cbDifficultyLevel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		for (Utility.DifficultyLevel difficultyLevel : Utility.DifficultyLevel.values()) {
			cbDifficultyLevel.addItem(difficultyLevel.toString());
		}

		cbDifficultyLevel.setBounds(289, 177, 243, 34);
		selectPanel.add(cbDifficultyLevel);

		btnCreate = new JButton("CREATE NEW QUIZ");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowSaveWindow();
			}
		});
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCreate.setBounds(433, 275, 308, 47);
		selectPanel.add(btnCreate);

		btnEdit = new JButton("EDIT QUIZ");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowSaveWindow();
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEdit.setBounds(91, 275, 308, 47);
		selectPanel.add(btnEdit);

		btnViewResults = new JButton("VIEW RESULTS");
		btnViewResults.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnViewResults.setBounds(258, 363, 308, 47);
		selectPanel.add(btnViewResults);
	}

	private void ShowHideControlsInQuizSelectionPanel() {
		if(this.user.getAdmin() == false)
		{
			btnEdit.setVisible(false);
			btnCreate.setVisible(false);
			btnStart.setVisible(true);
		}
	}

	private void CreateContainer() {
		topPanel = new JPanel();
		topPanel.setBounds(10, 11, 1246, 159);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);

		middlePanel = new JPanel();
		middlePanel.setBounds(10, 173, 1246, 448);
		frame.getContentPane().add(middlePanel);
		middlePanel.setLayout(null);

		bottomPanel = new JPanel();
		bottomPanel.setBounds(10, 625, 1246, 159);
		frame.getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);

		AddTopPanelControls();
		AddMiddlePanelControls();
		AddBottomPanelControls();
	}

	private void AddBottomPanelControls() {
		btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startQuiz();
			}
		});
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btnStart.setBounds(1052, 11, 184, 55);
		bottomPanel.add(btnStart);
		
		btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, radioButtonGroup.getSelection().getActionCommand());
			}
		});
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btnNext.setBounds(879, 11, 160, 55);
		bottomPanel.add(btnNext);

		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btnBack.setBounds(709, 11, 160, 55);
		bottomPanel.add(btnBack);

		btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				getUser();
				ShowSelectWindow();
			}			
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btnLogin.setBounds(523, 11, 176, 55);
		bottomPanel.add(btnLogin);
	}
	
	private void startQuiz() {
		getQuiz();
		btnStart.setVisible(false);
		btnLogin.setVisible(false);
		lblQuestionNumber.setVisible(false);
		btnNext.setVisible(true);
		btnBack.setVisible(false);
		loginPanel.setVisible(false);
		checkboxPanel.setVisible(true);
		selectPanel.setVisible(false);
		savePanel.setVisible(false);
	}

	private void AddMiddlePanelControls() {
		lblQuestionNumber = new JLabel("Question 1:");
		lblQuestionNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionNumber.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblQuestionNumber.setBounds(0, 11, 202, 47);
		middlePanel.add(lblQuestionNumber);
		
		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBounds(207, 0, 838, 448);
		middlePanel.add(loginPanel);

		selectPanel = new JPanel();
		selectPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				ShowHideControlsInQuizSelectionPanel();
			}
		});
		selectPanel.setBounds(207, 0, 838, 448);
		selectPanel.setLayout(null);
		middlePanel.add(selectPanel);

		savePanel = new JPanel();
		savePanel.setBounds(207, 0, 838, 448);
		savePanel.setLayout(null);
		middlePanel.add(savePanel);

		checkboxPanel = new JPanel();
		checkboxPanel.setBounds(207, 0, 838, 448);
		middlePanel.add(checkboxPanel);
		checkboxPanel.setLayout(null);
	}

	private void AddTopPanelControls() {
		bannerPanel = new JPanel();
		bannerPanel.setBounds(206, 0, 1040, 159);
		topPanel.add(bannerPanel);
		bannerPanel.setLayout(null);

		lblHeader = new JLabel("TOP QUIZ");
		lblHeader.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(107, 69, 482, 47);
		bannerPanel.add(lblHeader);

		logoPanel = new JPanel();
		logoPanel.setBounds(0, 0, 204, 159);
		topPanel.add(logoPanel);
	}

	private void ShowSaveWindow() {
		btnStart.setVisible(false);
		btnLogin.setVisible(false);
		lblQuestionNumber.setVisible(false);
		btnNext.setVisible(false);
		btnBack.setVisible(false);
		loginPanel.setVisible(false);
		checkboxPanel.setVisible(false);
		selectPanel.setVisible(false);
		savePanel.setVisible(true);
	}

	private void getUser() {
		if (txtUserName.getText().equals("")) {
			JOptionPane.showMessageDialog(frame, "Please enter user name");
			return;
		}
		this.user = portal.GetUser(txtUserName.getText().toString());
	}
	
	private void getQuiz() {
		if (cbSelectQuiz.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(frame, "Please enter user name");
			return;
		}
		
		this.quiz = portal.GetUserQuiz(cbSelectQuiz.getSelectedItem().toString(), cbDifficultyLevel.getSelectedItem().toString());
	}
	
	private void ShowSelectWindow() {
		btnStart.setVisible(false);
		btnLogin.setVisible(false);
		lblQuestionNumber.setVisible(false);
		btnNext.setVisible(false);
		btnBack.setVisible(false);
		loginPanel.setVisible(false);
		checkboxPanel.setVisible(false);
		selectPanel.setVisible(true);
		savePanel.setVisible(false);
	}

	private void ShowHideControlsOnLoad() {
		btnStart.setVisible(false);
		btnLogin.setVisible(true);
		lblQuestionNumber.setVisible(false);
		btnNext.setVisible(false);
		btnBack.setVisible(false);
		loginPanel.setVisible(true);
		checkboxPanel.setVisible(false);
		selectPanel.setVisible(false);
		savePanel.setVisible(false);
	}
}
