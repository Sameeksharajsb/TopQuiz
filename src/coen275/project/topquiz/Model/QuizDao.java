package coen275.project.topquiz.Model;
import java.sql.*;
import java.util.ArrayList;

public class QuizDao {

	private String extractQuizName(ResultSet rs) throws SQLException {
			String quizName= rs.getString("Quizname");
	    	return quizName;
		}
	
	private Quiz extractQuizWithQB(ResultSet rs,String difficultyLevel,String quizName) throws SQLException {
		Quiz quiz = new Quiz();
		quiz.setName(rs.getString("Quizname"));
		quiz.setScore(rs.getInt("quizscore"));
		quiz.setTime_limit(rs.getInt("time_limit"));
		QuestionBankDao questionBankDao= new QuestionBankDao();
		quiz.setQuestionBank(questionBankDao.getQuestionBank(difficultyLevel,quizName));
		return quiz;
	}
	
    	
	public ArrayList<String> getAllQuizNames() {
		Connection connection = ConnectionFactory.getConnection();
        try {	
        	PreparedStatement ps = connection.prepareStatement("SELECT distinct quizname FROM topquiz.quiz");
            ResultSet rs = ps.executeQuery();
            ArrayList<String> quiznames= new ArrayList<String>();
            
            while(rs.next())
            {
            	
            	quiznames.add(extractQuizName(rs));
            }
            return quiznames;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
	
	public Quiz getQuiz(String quizName, String difficultyLevel)
	{
		Connection connection = ConnectionFactory.getConnection();
		try {
	        PreparedStatement ps = connection.prepareStatement("select " + 
	        		"a.quizname, a.quizscore, a.time_limit," + 
	        		"b.difficultyLevel,b.QuestionBankName" 
	        		+ " FROM"
	        		+ " topquiz.quiz as a"
	        		+ " left join"
	        		+ " topquiz.questionbank as b"
	        		+ " on a.questionbankid=b.questionbankId"
	        		+ " WHERE quizname=? AND difficultyLevel=?");
	        ps.setString(1, quizName);
	        ps.setString(2, difficultyLevel);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	return extractQuizWithQB(rs,difficultyLevel,quizName);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}

	public boolean updateQuiz(String quizName, String difficultyLevel, Integer time)
	{
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE topquiz.quiz SET time_limit=?  WHERE upper(quizname) "
			        + "like upper('"+quizName+"')"
			        + " AND"
			        + " questionbankid in(select distinct questionbankid from topquiz.questionbank WHERE upper(difficultyLevel) "
			        + "=upper('"+difficultyLevel+"'))");
			ps.setInt(1, time);
			int i = ps.executeUpdate();
	        if(i == 1) {
	            return true;
	              }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	            return false;
	        }
	       
	
	public ArrayList<String> GetAllQuestionBankNames(String quizName1, String difficultyLevel1)
	{
		Connection connection = ConnectionFactory.getConnection();
		try {
	        PreparedStatement ps = connection.prepareStatement("select DISTINCT" +  
	        		" b.QuestionBankName" 
	        		+ " FROM"
	        		+ " topquiz.quiz as a"
	        		+ " left join "
	        		+ " topquiz.questionbank as b"
	        		+ " on a.questionbankid=b.questionbankId"
	        		+ " WHERE upper(a.quizname) like upper('"+quizName1+"') AND upper(b.difficultyLevel) like upper('"+difficultyLevel1+"')");
	        ResultSet rs1 = ps.executeQuery();
	        ArrayList<String> questionBanknames= new ArrayList<String>();
	        while(rs1.next())
	        {
	        	questionBanknames.add(rs1.getString("QuestionBankName"));
	        }
	        
	        return questionBanknames;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public int extractquizID(String quizname){
		Connection connection = ConnectionFactory.getConnection();
		try {
			 PreparedStatement ps = connection.prepareStatement("select distinct quizId from topquiz.quiz WHERE quizname=?");
			 ps.setString(1, quizname);
			 ResultSet rs2 = ps.executeQuery();
			 int quizid=0;
			 if(rs2.next())
			 {
				 quizid=rs2.getInt("quizId");
			 }
			 return quizid;
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		return 0;
    }
	
}
