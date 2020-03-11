package coen275.project.topquiz.Model;
import java.util.ArrayList;


public class QASet {
	private String question;

	/**
	 * get the question content
	 * 
	 * @return content of the question
	 */
	public String getQuestion() {
		return question;
	}

	private String questionType;

	/**
	 * get the type of the question, should be MCQ, True/False, Numeric
	 * 
	 * @return a string which gives the type of this question
	 */
	public String getQuestionType() {
		return questionType;
	}

	private ArrayList<String> answerSet;

	/**
	 * get the answer choices for the question
	 * 
	 * @return a list of answer choices
	 */
	public ArrayList<String> getAnserSet() {
		return answerSet;
	}

	private String expectedAnswer;

	/**
	 * get the right answer of the question
	 * 
	 * @return a list of all the expected answers
	 */
	
	public String getExpectedAnswers() {
		return expectedAnswer;
	}

	private int points;

	/**
	 * get points of the question
	 * 
	 * @return an integer which represents the points for the question
	 */
	public int getPoints() {
		return points;
	}

	private Utility.QuestionStatus questionStatus;

	public Utility.QuestionStatus getQuestionStatus() {		
		return questionStatus;
	}

	/**
	 * @param questionStatus the questionStatus to set
	 */
	public void setQuestionStatus() {
		if (getUserAnswer() == "")
			this.questionStatus = Utility.QuestionStatus.NOT_ATTEMPTED;
		if (!getUserAnswer().equals(expectedAnswer))
			this.questionStatus = Utility.QuestionStatus.WRONG;
		if (getUserAnswer().equals(expectedAnswer))
			this.questionStatus = Utility.QuestionStatus.CORRECT;		
	}

	private String userAnswer;

	/**
	 * @return the userAnswer
	 */
	public String getUserAnswer() {
		return userAnswer;
	}

	/**
	 * @param userAnswer the userAnswer to set
	 */
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	private int your_points;
	
	/**
	 * @return the your_points
	 */
	public int getYour_points() {
		return your_points;
	}

	/**
	 * @param your_points the your_points to set
	 */
	public void setYour_points() {
		if (this.questionStatus.equals(Utility.QuestionStatus.CORRECT)) {
			this.your_points = points;
		} else {
			this.your_points = 0;
		}
	}
}