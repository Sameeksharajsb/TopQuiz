package coen275.project.topquiz.Model;
import java.sql.*;
import java.util.ArrayList;

public class QuizDao {
	ArrayList<String> quiznames;
	private Quiz extractQuiz(ResultSet rs) throws SQLException {
			Quiz quiz = new Quiz();
			quiz.setName(rs.getString("Quizname"));
			quiz.setScore(rs.getInt("quizscore"));
			quiz.setTime_limit(rs.getTime("time_limit"));
			quiz.setQuestionBank(rs.getInt("QuestionBankId"));
	    	return quiz;
		}
	public ArrayList<String> getAllQuizes() {
		Connection connection = ConnectionFactory.getConnection();
        try {	
        	PreparedStatement ps = connection.prepareStatement("SELECT distinct quizname FROM topquiz.quiz");
            ResultSet rs = ps.executeQuery();
            ArrayList<String> quiznames= new ArrayList<String>();
            
            while(rs.next())
            {
            	Quiz quiz= extractQuiz(rs);
            	String quizname = quiz.getName();
            	quiznames.add(quizname);
            }
            return quiznames;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
	public Quiz findQuiz(String quizName, String DifficultyLevel)
	{
		
	}

}
