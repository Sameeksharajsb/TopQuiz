package coen275.project.topquiz.Model;

public class Quiz {
	private String name;
    private int time_limit;
    private int score;
    private QuestionBank questionBank;
    
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
	
	public Integer getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(Integer time_limit) {
		this.time_limit = time_limit;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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
