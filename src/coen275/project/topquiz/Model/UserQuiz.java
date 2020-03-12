package coen275.project.topquiz.Model;

public class UserQuiz {
	private Quiz myQuiz;
	private Integer correctCount;
	private Integer wrongCount;
	private Integer notAnsweredCount;
	private Integer your_Totalscore;
	
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
	
	public Integer getYour_Totalscore() {		
		return your_Totalscore;
	}
	
	public void setYour_Totalscore(Integer your_TotalScore) {		
		 this.your_Totalscore = your_TotalScore;
	}

	/**
	 * @return the correctCount
	 */
	public Integer getCorrectCount() {
		return correctCount;
	}
	
	public void setCorrectCount(Integer correctCount) {
		this.correctCount = correctCount;
	}
	
	/**
	 * @return the wrongCount
	 */
	public Integer getWrongCount() {
		return this.wrongCount;
	}
	
	public void setWrongCount(Integer wrongCount) {
		this.wrongCount = wrongCount;
	}
	

	/**
	 * @return the notAnsweredCount
	 */
	public Integer getNotAnsweredCount() {		
		return this.notAnsweredCount;
	}
	
	public void setNotAnsweredCount(Integer notAnsweredCount) {
		this.notAnsweredCount = notAnsweredCount;
	}
	
	// access on every next button click
	public void CheckAnswer()
	{
		for (QASet question : getMyQuiz().getQuestionBank().getQuestionAnswerSets())
		{
			if(question.getQuestionStatus().equals(Utility.QuestionStatus.CORRECT))
			{
				this.correctCount++;
			}
			if(question.getQuestionStatus().equals(Utility.QuestionStatus.WRONG))
			{
				this.wrongCount++;
			}
			if(question.getQuestionStatus().equals(Utility.QuestionStatus.NOT_ATTEMPTED))
			{
				this.notAnsweredCount++;
			}
		}
	}
	
	// access on submit button click
	public void CalculateTotalScore() {
		for (QASet point : getMyQuiz().getQuestionBank().getQuestionAnswerSets())
			this.your_Totalscore += point.getYour_points();
	}
}
