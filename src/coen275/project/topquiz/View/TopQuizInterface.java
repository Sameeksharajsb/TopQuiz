package coen275.project.topquiz.View;

import coen275.project.topquiz.Controller.*;
import coen275.project.topquiz.Model.*;

import java.awt.*;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.TimerTask;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import javax.imageio.ImageIO;

public class TopQuizInterface {

	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtTimeLimit;
	private JLabel lblSaveScore;

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
		user = portal.GetUser("Nithya");
		quiz = portal.GetQuiz("spacequiz", Utility.DifficultyLevel.EASY.toString());
		qaSet = quiz.getQuestionBank().getQuestionAnswerSets();
		quizIterator = qaSet.iterator();
		userQuiz = portal.GetUserQuiz(user.getName(), quiz.getName(), quiz.getQuestionBank().getDifficultyLevel());
		initialize();
	}

	Portal portal;
	User user;
	Quiz quiz;
	UserQuiz userQuiz;
	ArrayList<QASet> qaSet;
	Iterator<QASet> quizIterator;
	JLabel lblTime;
	JPanel topPanel;
	JPanel bannerPanel;
	JLabel lblHeader;
	JPanel logoPanel;
	JPanel middlePanel;
	JPanel checkboxPanel;
	JLabel lblQuestion;
	ButtonGroup rb_Group;
	JRadioButton rb_option1;
	JRadioButton rb_option2;
	JRadioButton rb_option3;
	JRadioButton rb_option4;
	JPanel loginPanel;
	JLabel lblUserName;
	JLabel lblQuestionNumber;
	JPanel selectPanel;
	JLabel lblSelectQuiz;
	JComboBox<String> cbSelectQuiz;
	JLabel lblDifficultyLevel;
	JComboBox<String> cbDifficultyLevel;
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
	JButton btnSubmit;
	Timer timer;
	int colorIndex;
	ActionListener timerListener;
	Integer minutes;
	JPanel submitPanel;
	JLabel lblstatusmessage;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1282, 834);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		try {
			CreateContainer();
			CreateLoginInterface();
			CreateQuizSelectionInterface();
			CreateQuizModificationInterface();
			CreateMcqCheckboxInterface();
			CreateFiBInterface();
			CreateImageInterface();
			CreateSubmitPanel();
			CreateViewResultsInterface();
			ShowHideControlsOnLoad();
			
			minutes = quiz.getTime_limit() * 60 * 1000;

			timerListener = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					lblTime.setVisible(true);
					minutes -= 1000;
					SimpleDateFormat originalFormat = new SimpleDateFormat("mm:ss");

					if (minutes < 0) {
						minutes = 0;
					}
					String time = originalFormat.format(minutes);

					lblTime.setText("Quiz Time: " + time);
					colorIndex++; // A number between 0 and 100.
					if (colorIndex > 100)
						colorIndex = 0;
					float hue = colorIndex / 100.0F; // Between 0.0F and 1.0F.
					bannerPanel.setBackground((Color.getHSBColor(hue, 1, 1)));
				}
			};
		} catch (Exception ex) {
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

	private void DisplayQuestionAndAnswer(QASet set) {
		currentSet = set;
		lblQuestionNumber.setVisible(true);
		lblQuestionNumber.setText("");
		lblQuestionNumber.setText("Question: " + set.getQuestionNumber().toString() + "/"
				+ quiz.getQuestionBank().getTotalNumberOfQuestions());
		if (set.getQuestionType().equals(Utility.QuestionType.MCQ)) {
			checkboxPanel.setVisible(true);
			fibPanel.setVisible(false);
			imagePanel.setVisible(false);
			lblQuestion.setText("");
			lblQuestion.setText("<html>" + set.getQuestion() + "</html>");

			rb_option1.setText("");
			rb_option1.setText(set.getAnswerChoice1());
			rb_option1.setActionCommand(rb_option1.getText());

			rb_option2.setText("");
			rb_option2.setText(set.getAnswerChoice2());
			rb_option2.setActionCommand(rb_option2.getText());

			rb_option3.setVisible(true);
			rb_option4.setVisible(true);
			rb_option3.setText("");
			rb_option3.setText(set.getAnswerChoice3());
			rb_option3.setActionCommand(rb_option3.getText());

			rb_option4.setText("");
			rb_option4.setText(set.getAnswerChoice4());
			rb_option4.setActionCommand(rb_option4.getText());
		} else if (set.getQuestionType().equals(Utility.QuestionType.FillInTheBlanks)) {
			fibPanel.setVisible(true);
			checkboxPanel.setVisible(false);
			imagePanel.setVisible(false);
			lblFibQuestion.setText("");
			lblFibQuestion.setText("<html>" + set.getQuestion() + "</html>");
		} else if (set.getQuestionType().equals(Utility.QuestionType.TF)) {
			checkboxPanel.setVisible(true);
			fibPanel.setVisible(false);
			imagePanel.setVisible(false);
			lblQuestion.setText("");
			lblQuestion.setText("<html>" + set.getQuestion() + "</html>");

			rb_option1.setText("");
			rb_option1.setText("True");
			rb_option1.setActionCommand(rb_option1.getText());

			rb_option2.setText("");
			rb_option2.setText("False");
			rb_option2.setActionCommand(rb_option2.getText());

			rb_option3.setVisible(false);
			rb_option4.setVisible(false);
		} else if (set.getQuestionType().equals(Utility.QuestionType.Image)) {
			imagePanel.setVisible(true);
			fibPanel.setVisible(false);
			checkboxPanel.setVisible(false);
			lblImageQuestion.setText("");
			lblImageQuestion.setText("<html>" + set.getQuestion() + "</html>");
		}
	}

	private void CreateMcqCheckboxInterface() {
		lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(67, 98, 750, 100);
		checkboxPanel.add(lblQuestion);

		rb_Group = new ButtonGroup();
		rb_option1 = new JRadioButton("option1");
		rb_option1.setActionCommand(rb_option1.getText());
		rb_option1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_option1.setBounds(228, 200, 250, 30);

		rb_option2 = new JRadioButton("option2");
		rb_option2.setActionCommand(rb_option2.getText());
		rb_option2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_option2.setBounds(228, 232, 250, 30);

		rb_option3 = new JRadioButton("option3");
		rb_option3.setActionCommand(rb_option3.getText());
		rb_option3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_option3.setBounds(228, 264, 250, 30);

		rb_option4 = new JRadioButton("option4");
		rb_option4.setActionCommand(rb_option4.getText());
		rb_option4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_option4.setBounds(228, 296, 250, 30);

		rb_option1.setSelected(true);
		rb_Group.add(rb_option1);
		rb_Group.add(rb_option2);
		rb_Group.add(rb_option3);
		rb_Group.add(rb_option4);

		checkboxPanel.add(rb_option1);
		checkboxPanel.add(rb_option2);
		checkboxPanel.add(rb_option3);
		checkboxPanel.add(rb_option4);
	}

	private void BindSaveData() {
		this.quiz = portal.GetQuiz(cbSelectQuiz.getSelectedItem().toString(),
				cbDifficultyLevel.getSelectedItem().toString());
		lblQuizValue.setText(this.quiz.getName());
		lbllevelValue.setText(this.quiz.getQuestionBank().getDifficultyLevel());
		txtTimeLimit.setText(this.quiz.getTime_limit().toString());
		lblSaveScore.setText(this.quiz.getScore().toString());
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
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (portal.UpdateQuiz(quiz.getName(), quiz.getQuestionBank().getDifficultyLevel(),
						Integer.valueOf(txtTimeLimit.getText()))) {
					lblstatusmessage.setText("The record is updated successfully !!");
				} else {
					lblstatusmessage.setText("Failed to update record !!");
				}
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.setBounds(412, 309, 150, 47);
		savePanel.add(btnSave);

		btnSaveBack = new JButton("BACK");
		btnSaveBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowSelectWindow();
			}
		});
		btnSaveBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSaveBack.setBounds(259, 309, 143, 47);
		savePanel.add(btnSaveBack);

		lblTimeLimit = new JLabel("Time Limit : ");
		lblTimeLimit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTimeLimit.setBounds(216, 257, 180, 24);
		savePanel.add(lblTimeLimit);

		lblTotalScore = new JLabel("Total Score : ");
		lblTotalScore.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotalScore.setBounds(216, 141, 180, 24);
		savePanel.add(lblTotalScore);

		lblQuestionBank = new JLabel("Question Bank :");
		lblQuestionBank.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuestionBank.setBounds(216, 192, 180, 24);
		savePanel.add(lblQuestionBank);

		lblQuizValue = new JLabel(quiz.getName());
		lblQuizValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuizValue.setBounds(433, 44, 169, 24);
		savePanel.add(lblQuizValue);

		lbllevelValue = new JLabel(quiz.getQuestionBank().getDifficultyLevel());
		lbllevelValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbllevelValue.setBounds(433, 92, 169, 24);
		savePanel.add(lbllevelValue);

		txtTimeLimit = new JTextField();
		txtTimeLimit.setBounds(433, 253, 169, 29);
		savePanel.add(txtTimeLimit);
		txtTimeLimit.setColumns(10);

		lblSaveScore = new JLabel();
		lblSaveScore.setBounds(433, 136, 169, 29);
		savePanel.add(lblSaveScore);

		cbQuestionBank = new JComboBox<String>();
		ArrayList<String> all_questionBankNames = portal.GetAllQuestionBankNames(quiz.getName(),
				quiz.getQuestionBank().getDifficultyLevel());
		for (String questionBankName : all_questionBankNames) {
			cbQuestionBank.addItem(questionBankName);
		}

		cbQuestionBank.setBounds(433, 190, 169, 34);
		savePanel.add(cbQuestionBank);

		lblstatusmessage = new JLabel();
		lblstatusmessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblstatusmessage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblstatusmessage.setBounds(216, 379, 386, 24);
		savePanel.add(lblstatusmessage);
	}

	JPanel fibPanel;
	JLabel lblFibQuestion;
	JLabel lblFibYourAnswer;
	private JTextField txtFibAnswer;

	private void CreateFiBInterface() {
		lblFibQuestion = new JLabel("Question");
		lblFibQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblFibQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFibQuestion.setBounds(10, 98, 818, 43);
		fibPanel.add(lblFibQuestion);

		lblFibYourAnswer = new JLabel("Your Answer :");
		lblFibYourAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblFibYourAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblFibYourAnswer.setBounds(67, 275, 275, 43);
		fibPanel.add(lblFibYourAnswer);

		txtFibAnswer = new JTextField();
		txtFibAnswer.setBounds(312, 275, 392, 43);

		fibPanel.add(txtFibAnswer);
		txtFibAnswer.setColumns(10);
	}

	JPanel imagePanel;
	JLabel lblImageQuestion;
	JLabel lblImageYourAnswer;
	private JTextField txtImageAnswer;
	JLabel lblImagePicture;

	private void CreateImageInterface() {
		lblImageQuestion = new JLabel("Question");
		lblImageQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblImageQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageQuestion.setBounds(10, 90, 818, 43);
		imagePanel.add(lblImageQuestion);

		lblImageYourAnswer = new JLabel("Your Answer :");
		lblImageYourAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageYourAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblImageYourAnswer.setBounds(66, 380, 275, 43);
		imagePanel.add(lblImageYourAnswer);

		txtImageAnswer = new JTextField();
		txtImageAnswer.setBounds(311, 380, 392, 43);
		imagePanel.add(txtImageAnswer);
		txtImageAnswer.setColumns(10);

		BufferedImage bufferImage = null;
		try {
			bufferImage = ImageIO.read(new File("Picture.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(bufferImage);
		lblImagePicture = new JLabel();
		lblImagePicture.setBounds(246, 162, 317, 195);
		imagePanel.add(lblImagePicture);
		lblImagePicture.setIcon(icon);
	}

	private void CreateQuizSelectionInterface() {
		lblSelectQuiz = new JLabel("Select Quiz : ");
		lblSelectQuiz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSelectQuiz.setBounds(164, 116, 115, 24);
		selectPanel.add(lblSelectQuiz);

		cbSelectQuiz = new JComboBox<String>();
		cbSelectQuiz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ArrayList<String> all_quizNames = portal.GetAllQuizNames();
		for (String quizName : all_quizNames) {
			cbSelectQuiz.addItem(quizName);
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
		btnViewResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowViewResultsPanel();
			}
		});
		btnViewResults.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnViewResults.setBounds(433, 275, 308, 47);
		selectPanel.add(btnViewResults);
	}

	private void ShowHideControlsInQuizSelectionPanel() {
		if (this.user.getAdmin() == false) {
			btnEdit.setVisible(false);
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

	private Integer totalScore = 0;

	private void AddBottomPanelControls() {
		btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startQuiz();
				startAnimation();
			}
		});
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btnStart.setBounds(1052, 11, 184, 55);
		bottomPanel.add(btnStart);

		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stopAnimation();
				if (portal.UpdateUserQuiz(user.getName(), userQuiz.getQuizName(), userQuiz)) {
					lblYourScore.setText("Your score: " + totalScore.toString() + "/" + quiz.getScore().toString());
				}
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btnSubmit.setBounds(1000, 11, 200, 50);
		bottomPanel.add(btnSubmit);

		btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentSet.getQuestionType().equals(Utility.QuestionType.MCQ)) {
					currentSet.setUserAnswer(rb_Group.getSelection().getActionCommand());
				} else if (currentSet.getQuestionType().equals(Utility.QuestionType.FillInTheBlanks)) {
					currentSet.setUserAnswer(txtFibAnswer.getText());
				}
				currentSet.setYour_points();
				currentSet.setQuestionStatus();
				userQuiz.CheckAnswer(currentSet);

				totalScore += currentSet.getYour_points();
				userQuiz.setYour_Totalscore(totalScore);

				if (quizIterator.hasNext()) {
					DisplayQuestionAndAnswer(quizIterator.next());
				} else {
					DisplaySubmitPanel();
				}
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

	void startAnimation() {
		if (timer == null) {
			timer = new Timer(1000, timerListener);
			timer.start();
		}
	}

	void stopAnimation() {
		if (timer != null) {
			timer.stop();
			timer = null;
		}
	}

	private void DisplaySubmitPanel() {
		btnSubmit.setVisible(true);
		submitPanel.setVisible(true);
		loginPanel.setVisible(false);
		checkboxPanel.setVisible(false);
		fibPanel.setVisible(false);
		selectPanel.setVisible(false);
		savePanel.setVisible(false);
		btnNext.setVisible(false);
		btnStart.setVisible(false);
		btnLogin.setVisible(false);
		imagePanel.setVisible(false);
		resultsPanel.setVisible(false);
	}

	QASet currentSet = null;

	private void startQuiz() {
		getQuiz();
		if (quizIterator.hasNext()) {
			currentSet = quizIterator.next();
			DisplayQuestionAndAnswer(currentSet);
		}
		btnStart.setVisible(false);
		btnLogin.setVisible(false);
		btnNext.setVisible(true);
		btnBack.setVisible(false);
		loginPanel.setVisible(false);
		selectPanel.setVisible(false);
		savePanel.setVisible(false);
		btnSubmit.setVisible(false);
		submitPanel.setVisible(false);
		checkboxPanel.setVisible(true);
		fibPanel.setVisible(false);
		imagePanel.setVisible(false);
		resultsPanel.setVisible(false);
	}

	JLabel lblYourScore;

	private void CreateSubmitPanel() {
		JLabel lblMessage = new JLabel(
				"<html>You have successfully completed the quiz !! Please submit to view your score!!</html>");
		lblMessage.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(10, 98, 818, 143);
		submitPanel.add(lblMessage);

		lblYourScore = new JLabel("Your Score :");
		lblYourScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourScore.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblYourScore.setBounds(176, 275, 459, 43);
		submitPanel.add(lblYourScore);
	}

	private void AddMiddlePanelControls() {
		lblQuestionNumber = new JLabel("Question 1:");
		lblQuestionNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionNumber.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblQuestionNumber.setBounds(0, 11, 202, 47);
		middlePanel.add(lblQuestionNumber);

		lblTime = new JLabel("Quiz Time: ");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblTime.setBounds(950, 11, 302, 47);
		middlePanel.add(lblTime);

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
		checkboxPanel.setLayout(null);
		checkboxPanel.setBounds(207, 0, 838, 448);
		middlePanel.add(checkboxPanel);

		submitPanel = new JPanel();
		submitPanel.setLayout(null);
		submitPanel.setBounds(207, 0, 838, 448);
		middlePanel.add(submitPanel);

		fibPanel = new JPanel();
		fibPanel.setBounds(207, 0, 838, 448);
		fibPanel.setLayout(null);
		middlePanel.add(fibPanel);

		imagePanel = new JPanel();
		imagePanel.setBounds(207, 0, 838, 448);
		imagePanel.setLayout(null);
		middlePanel.add(imagePanel);
		
		resultsPanel = new JPanel();
		resultsPanel.setBounds(107, 0, 1000, 500);
		resultsPanel.setLayout(null);
		middlePanel.add(resultsPanel);
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

		BufferedImage bufferImage = null;
		try {
			bufferImage = ImageIO.read(new File("logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(bufferImage);

		JLabel lbl = new JLabel();
		lbl.setBounds(0, 0, 204, 159);
		lbl.setIcon(icon);
		logoPanel.add(lbl);
	}

	private void ShowSaveWindow() {
		btnStart.setVisible(false);
		btnLogin.setVisible(false);
		lblQuestionNumber.setVisible(false);
		lblTime.setVisible(false);
		btnNext.setVisible(false);
		btnBack.setVisible(false);
		loginPanel.setVisible(false);
		checkboxPanel.setVisible(false);
		selectPanel.setVisible(false);
		savePanel.setVisible(true);
		btnSubmit.setVisible(false);
		submitPanel.setVisible(false);
		fibPanel.setVisible(false);
		imagePanel.setVisible(false);
		BindSaveData();
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
			JOptionPane.showMessageDialog(frame, "Please select quiz");
			return;
		}

		this.quiz = portal.GetQuiz(cbSelectQuiz.getSelectedItem().toString(),
				cbDifficultyLevel.getSelectedItem().toString());
		this.userQuiz = portal.GetUserQuiz(user.getName(), quiz.getName(), quiz.getQuestionBank().getDifficultyLevel());
		this.userQuiz.setCorrectCount(0);
		this.userQuiz.setWrongCount(0);
		this.userQuiz.setYour_Totalscore(0);
		this.quizIterator = qaSet.iterator();
	}

	JPanel resultsPanel;
	JLabel lblResultsQuizName;
	JButton btnResultsBack;
	JComboBox<String> cbResultsQuizName;
	ChartPanel chartPanel;
	JLabel lblResultsUserName;
	JLabel lblStatusScore;
	JComboBox<String> cbResultsUserName;
	JLabel lblResultsDifficultyLevel;
	JComboBox<String> cbResultsDifficultyLevel;
	
	private void CreateViewResultsInterface() {

		JLabel lblResultsQuizName = new JLabel("Quiz Name :");
		lblResultsQuizName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblResultsQuizName.setBounds(329, 19, 104, 24);
		resultsPanel.add(lblResultsQuizName);
		
		lblStatusScore = new JLabel("Total Score :");
		lblStatusScore.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblStatusScore.setBounds(748, 155, 200, 24);
		resultsPanel.add(lblStatusScore);

		btnResultsBack = new JButton("BACK");
		btnResultsBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowSelectWindow();
			}
		});
		
		btnResultsBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnResultsBack.setBounds(748, 403, 143, 47);
		resultsPanel.add(btnResultsBack);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Create dataset
				dataset = createDataset(cbResultsUserName.getSelectedItem().toString(), cbResultsQuizName.getSelectedItem().toString(), cbResultsDifficultyLevel.getSelectedItem().toString());

				// Create chart
				chart = createChart(dataset);
				chartPanel = new ChartPanel(chart);
				chartPanel.setBounds(39, 86, 663, 388);
				resultsPanel.add(chartPanel);
			}
		});
	    btnLoad.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    btnLoad.setBounds(748, 86, 143, 47);
	    resultsPanel.add(btnLoad);

		cbResultsQuizName = new JComboBox<String>();
		ArrayList<String> all_quizNames = portal.GetAllQuizNames();
		for (String quizName : all_quizNames) {
			cbResultsQuizName.addItem(quizName);
		}

		cbResultsQuizName.setBounds(443, 17, 169, 34);
		resultsPanel.add(cbResultsQuizName);

		lblResultsUserName = new JLabel("User Name :");
		lblResultsUserName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblResultsUserName.setBounds(25, 19, 104, 24);
		resultsPanel.add(lblResultsUserName);
		
		cbResultsUserName = new JComboBox<String>();
		ArrayList<String> all_userNames = portal.GetAllUserNames();
		for (String userName : all_userNames) {
			cbResultsUserName.addItem(userName);
		}
		cbResultsUserName.setBounds(139, 17, 169, 34);
		resultsPanel.add(cbResultsUserName);

		lblResultsDifficultyLevel = new JLabel("Difficulty Level :");
		lblResultsDifficultyLevel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblResultsDifficultyLevel.setBounds(633, 19, 143, 24);
		resultsPanel.add(lblResultsDifficultyLevel);

		cbResultsDifficultyLevel = new JComboBox<String>();
		for (Utility.DifficultyLevel difficultyLevel : Utility.DifficultyLevel.values()) {
			cbResultsDifficultyLevel.addItem(difficultyLevel.toString());
		}
		cbResultsDifficultyLevel.setBounds(775, 17, 169, 34);
		resultsPanel.add(cbResultsDifficultyLevel);


		dataset = createDataset(cbResultsUserName.getSelectedItem().toString(), cbResultsQuizName.getSelectedItem().toString(), cbResultsDifficultyLevel.getSelectedItem().toString());
		chart = createChart(dataset);
		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(39, 86, 663, 388);
		resultsPanel.add(chartPanel);
	}
	
	PieDataset dataset;
	JFreeChart chart;

	private JFreeChart createChart(final PieDataset dataset) {
		final JFreeChart chart = ChartFactory.createPieChart("Result Analysis", dataset, true, true, false);

		// Format Label
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("Marks {0} : ({2})",
				new DecimalFormat("0"), new DecimalFormat("0%"));
		((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
		return chart;
	}

	private PieDataset createDataset(String userName, String quizName, String difficultyLevel) {
		userQuiz = portal.GetUserQuiz(userName, quizName, difficultyLevel);
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Correct", userQuiz.getCorrectCount());
		dataset.setValue("Wrong", userQuiz.getWrongCount());
		dataset.setValue("Not attempted", userQuiz.getNotAnsweredCount());
		lblStatusScore.setText("Total Score: " + userQuiz.getYour_Totalscore());
		return dataset;
	}

	private void ShowSelectWindow() {
		btnStart.setVisible(false);
		btnLogin.setVisible(false);
		lblQuestionNumber.setVisible(false);
		lblTime.setVisible(false);
		btnNext.setVisible(false);
		btnBack.setVisible(false);
		loginPanel.setVisible(false);
		checkboxPanel.setVisible(false);
		selectPanel.setVisible(true);
		savePanel.setVisible(false);
		btnSubmit.setVisible(false);
		submitPanel.setVisible(false);
		fibPanel.setVisible(false);
		imagePanel.setVisible(false);
		resultsPanel.setVisible(false);
	}

	private void ShowHideControlsOnLoad() {
		btnStart.setVisible(false);
		btnLogin.setVisible(true);
		lblQuestionNumber.setVisible(false);
		lblTime.setVisible(false);
		btnNext.setVisible(false);
		btnBack.setVisible(false);
		loginPanel.setVisible(true);
		checkboxPanel.setVisible(false);
		selectPanel.setVisible(false);
		savePanel.setVisible(false);
		btnSubmit.setVisible(false);
		submitPanel.setVisible(false);
		fibPanel.setVisible(false);
		imagePanel.setVisible(false);
		resultsPanel.setVisible(false);
	}
	
	private void ShowViewResultsPanel()
	{
		btnStart.setVisible(false);
		btnLogin.setVisible(false);
		lblQuestionNumber.setVisible(false);
		lblTime.setVisible(false);
		btnNext.setVisible(false);
		btnBack.setVisible(false);
		loginPanel.setVisible(false);
		checkboxPanel.setVisible(false);
		selectPanel.setVisible(false);
		savePanel.setVisible(false);
		btnSubmit.setVisible(false);
		submitPanel.setVisible(false);
		fibPanel.setVisible(false);
		imagePanel.setVisible(false);
		resultsPanel.setVisible(true);
	}
}
