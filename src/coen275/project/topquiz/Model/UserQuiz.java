package coen275.project.topquiz.Model;

public class UserQuiz {
	private int attempt_number;
	private int your_score;
	private Quiz myQuiz;
	private int correctCount;
	private int wrongCount;
	private int notAnsweredCount;

	public UserQuiz() {
	}

	public int getYour_score() {
		for (QASet point : getMyQuiz().getQuestionBank().getQuestions())
			this.your_score += point.getYour_points();
		return your_score;
	}

	/**
	 * @return the myQuiz
	 */
	public Quiz getMyQuiz() {
		return myQuiz;
	}

	/**
	 * @param myQuiz the myQuiz to set
	 */
	public void setMyQuiz(Quiz myQuiz) {
		this.myQuiz = myQuiz;
	}

	/**
	 * @return the attempt_number
	 */
	public int getAttempt_number() {
		return attempt_number;
	}

	/**
	 * @param attempt_number the attempt_number to set
	 */
	public void setAttempt_number(int attempt_number) {
		this.attempt_number = attempt_number;
	}

	/**
	 * @return the correctCount
	 */
	public int getCorrectCount() {
		for (QASet question : getMyQuiz().getQuestionBank().getQuestions())
		{
			if(question.getQuestionStatus().equals(Utility.QuestionStatus.CORRECT))
			{
				this.correctCount++;
			}
		}
		
		return correctCount;
	}
	
	/**
	 * @return the wrongCount
	 */
	public int getWrongCount() {
		for (QASet question : getMyQuiz().getQuestionBank().getQuestions())
		{
			if(question.getQuestionStatus().equals(Utility.QuestionStatus.WRONG))
			{
				this.wrongCount++;
			}
		}
		
		return this.wrongCount;
	}

	/**
	 * @return the notAnsweredCount
	 */
	public int getNotAnsweredCount() {
		for (QASet question : getMyQuiz().getQuestionBank().getQuestions())
		{
			if(question.getQuestionStatus().equals(Utility.QuestionStatus.NOT_ATTEMPTED))
			{
				this.notAnsweredCount++;
			}
		}
		
		return this.notAnsweredCount;
	}
}
