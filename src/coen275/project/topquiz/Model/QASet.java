package coen275.project.topquiz.Model;


public class QASet {
	private Integer questionNumber;
	private String question;
	private String answerChoice1;
	private String answerChoice2;
	private String answerChoice3;
	private String answerChoice4;
	private String correctAnswer;
	private Integer points; 
	private String questionType;
	
	// Not stored in database
	private String userAnswer;
	private Integer your_points;
	private Utility.QuestionStatus questionStatus;
	
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
	
	/**
	 * @return the your_points
	 */
	public Integer getYour_points() {
		return your_points;
	}
	
	public void setYour_points() {
		if (this.userAnswer.equals(this.correctAnswer)) {
			this.your_points = getPoints();
		} else {
			this.your_points = 0;
		}
	}
	
	/**
	 * @return the questionStatus
	 */
	public Utility.QuestionStatus getQuestionStatus() {				
		return questionStatus;
	}
	
	public void setQuestionStatus() {
		if (getUserAnswer() == "")
			this.questionStatus = Utility.QuestionStatus.NOT_ATTEMPTED;
		if (!getUserAnswer().equals(getCorrectAnswer()))
			this.questionStatus = Utility.QuestionStatus.WRONG;
		if (getUserAnswer().equals(getCorrectAnswer()))
			this.questionStatus = Utility.QuestionStatus.CORRECT;
	}

	/**
	 * @return the questionNumber
	 */
	public Integer getQuestionNumber() {
		return questionNumber;
	}

	/**
	 * @param questionNumber the questionNumber to set
	 */
	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}
	
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}


	/**
	 * @return the answerChoice1
	 */
	public String getAnswerChoice1() {
		return answerChoice1;
	}


	/**
	 * @param answerChoice1 the answerChoice1 to set
	 */
	public void setAnswerChoice1(String answerChoice1) {
		this.answerChoice1 = answerChoice1;
	}


	/**
	 * @return the answerChoice2
	 */
	public String getAnswerChoice2() {
		return answerChoice2;
	}


	/**
	 * @param answerChoice2 the answerChoice2 to set
	 */
	public void setAnswerChoice2(String answerChoice2) {
		this.answerChoice2 = answerChoice2;
	}


	/**
	 * @return the answerChoice3
	 */
	public String getAnswerChoice3() {
		return answerChoice3;
	}


	/**
	 * @param answerChoice3 the answerChoice3 to set
	 */
	public void setAnswerChoice3(String answerChoice3) {
		this.answerChoice3 = answerChoice3;
	}


	/**
	 * @return the answerChoice4
	 */
	public String getAnswerChoice4() {
		return answerChoice4;
	}

	/**
	 * @param answerChoice4 the answerChoice4 to set
	 */
	public void setAnswerChoice4(String answerChoice4) {
		this.answerChoice4 = answerChoice4;
	}


	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}


	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	/**
	 * @return the points
	 */
	public Integer getPoints() {
		return points;
	}
 

	/**
	 * @param points the points to set
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}

	/**
	 * @return the questionType
	 */
	public String getQuestionType() {
		return questionType;
	}

	/**
	 * set the type of the question, should be MCQ, True/False, Numeric
	 * 
	 * @return a string which gives the type of this question
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
}