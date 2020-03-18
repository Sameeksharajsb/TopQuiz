package coen275.project.topquiz.Model;

public class UserQuiz {
	private String quizName;
	private Integer correctCount = 0;
	private Integer wrongCount = 0;
	private Integer notAnsweredCount = 0;
	private Integer your_Totalscore = 0;
	private String difficultyLevel = "";
	
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
	public void CheckAnswer(QASet set)
	{		
		if(set.getQuestionStatus().equals(Utility.QuestionStatus.CORRECT))
		{
			this.correctCount++;
		}
		if(set.getQuestionStatus().equals(Utility.QuestionStatus.WRONG))
		{
			this.wrongCount++;
		}
		if(set.getQuestionStatus().equals(Utility.QuestionStatus.NOT_ATTEMPTED))
		{
			this.notAnsweredCount++;
		}
	}
	
	/**
	 * @return the quizName
	 */
	public String getQuizName() {
		return quizName;
	}

	/**
	 * @param quizName the quizName to set
	 */
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	/**
	 * @return the difficultyLevel
	 */
	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	/**
	 * @param difficultyLevel the difficultyLevel to set
	 */
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
}
