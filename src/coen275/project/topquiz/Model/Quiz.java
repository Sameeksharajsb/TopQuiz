package coen275.project.topquiz.Model;

public abstract class Quiz {
	private String name;
    private int time_limit;
    private int score;
    private int attempts_allowed=3;
    private QuestionBank questionBank;
    
    public Quiz()
    {
    }
    
	 /** 
	    * Setter method for Dollar. 
	    * @param dollars - Dollar value. 
	    * @return Nothing. 
	    */
	public void setName(String name) {
		this.name = name;
	}

	 /** 
	    * Getter method for Dollars. 
	    * @param Nothing. 
	    * @return Nothing. 
	    */
	public String getName() {
		return name;
	}
	
	public int getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(int time_limit) {
		this.time_limit = time_limit;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAttempts_allowed() {
		return attempts_allowed;
	}

	public void setAttempts_allowed(int attempts_allowed) {
		this.attempts_allowed = attempts_allowed;
	}

	
	/**
	 * @return the questionBank
	 */
	public QuestionBank getQuestionBank() {
		return questionBank;
	}

	/**
	 * @param questionBank the questionBank to set
	 */
	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}
	
}
