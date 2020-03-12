package coen275.project.topquiz.Model;
import java.util.ArrayList;


public class QuestionBank {
		private String name;
		
		private String difficultyLevel;
		
		private ArrayList<QASet> questionAnswerSets;		

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
		 * @return the numberOfQuestions
		 */
		public int getTotalNumberOfQuestions() {
			return getQuestionAnswerSets().size();
		}

		/**
		 * @return the questionAnswerSets
		 */
		public ArrayList<QASet> getQuestionAnswerSets() {
			return questionAnswerSets;
		}

		/**
		 * @param questionAnswerSets the questionAnswerSets to set
		 */
		public void setQuestionAnswerSets(ArrayList<QASet> questionAnswerSets) {
			this.questionAnswerSets = questionAnswerSets;
		}
	}