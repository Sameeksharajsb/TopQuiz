package coen275.project.topquiz.Model;
import java.util.ArrayList;


public class QuestionBank {
		
		private String name;
		
		private String difficultyLevel;
		
		private String quizCategory;
		
		private ArrayList<QASet> questionsets = null;
		
		public ArrayList<QASet> getQuestions(){
			return questionsets;
		}
		
		public QuestionBank() {}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
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

		/**
		 * @return the quizCategory
		 */
		public String getQuizCategory() {
			return quizCategory;
		}

		/**
		 * @param quizCategory the quizCategory to set
		 */
		public void setQuizCategory(String quizCategory) {
			this.quizCategory = quizCategory;
		}
		
		/**
		 * @return the numberOfQuestions
		 */
		public int getTotalNumberOfQuestions() {
			return questionsets.size();
		}
	}