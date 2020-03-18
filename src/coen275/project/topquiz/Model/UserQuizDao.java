package coen275.project.topquiz.Model;
import java.sql.*;
import java.util.ArrayList;

public class UserQuizDao {
	
	public ArrayList<String> GetAllUserQuizNames(String userName){
		Connection connection = ConnectionFactory.getConnection();
		try {
	        PreparedStatement ps = connection.prepareStatement("select distinct a.quizname" 
	        		+ " FROM"
	        		+ " topquiz.quiz_user as a"
	        		+ " left join"
	        		+ " topquiz.users as c "
	        		+ " on a.user_id=c.id"
	        		+ " where upper(c.username) like upper('"+userName+"')");
	        ResultSet rs = ps.executeQuery();
	        ArrayList<String> quizNames= new ArrayList<String>();
	        while(rs.next())
	        {
	        	quizNames.add(rs.getString("quizname"));
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	private UserQuiz extractQuizUser(ResultSet rs) throws SQLException {
		UserQuiz userQuiz = new UserQuiz();
		userQuiz.setYour_Totalscore(rs.getInt("User_score"));
		userQuiz.setCorrectCount(rs.getInt("Total_correct"));
		userQuiz.setWrongCount(rs.getInt("Total_Wrong"));
		userQuiz.setNotAnsweredCount(rs.getInt("Total_NA"));
		userQuiz.setQuizName(rs.getString("quizname"));
		userQuiz.setDifficultyLevel(rs.getString("difficultyLevel"));
		return userQuiz;
	}
	public UserQuiz GetUserQuiz(String userName, String quizName,String difficultyLevel) {
		Connection connection = ConnectionFactory.getConnection();
		try {
	        PreparedStatement ps = connection.prepareStatement("select distinct a.*" 
	        		+ " FROM"
	        		+ " topquiz.quiz_user as a"
	        		+ " left join"
	        		+ " topquiz.users as c "
	        		+ " on a.user_id=c.id"
	        		+ " where upper(c.username) like upper('"+userName+"') AND upper(a.quizname) like upper('"+quizName+"')"
	        				+ " AND upper(a.difficultyLevel) like upper('"+difficultyLevel+"')");
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	return extractQuizUser(rs);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public UserQuiz RegisterUserToQuiz(UserQuiz userQuiz, String username )
	{
		QuizDao quizDao = new QuizDao();
		int quizid=quizDao.extractquizID(userQuiz.getQuizName());
		UserDao userDao = new UserDao();
		int userid=userDao.extractUserID(username);
		Connection connection = ConnectionFactory.getConnection();
		try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO topquiz.Quiz_User "
	        		+ "(Quiz_Id, User_id,Total_correct,Total_Wrong,Total_NA,User_score,quizname,difficultyLevel)"
	        		+ " VALUES (?, ?,0,0,0,0,?,?)");
	        ps.setInt(1, quizid);
	        ps.setInt(2, userid);
	        ps.setString(3, userQuiz.getQuizName());
	        ps.setString(4, userQuiz.getDifficultyLevel());
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return userQuiz;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}

	public boolean UpdateUserQuiz(String userName, String quizName,UserQuiz userquiz)
	{
		QuizDao quizDao = new QuizDao();
		int quizid=quizDao.extractquizID(quizName);
		UserDao userDao = new UserDao();
		int userid=userDao.extractUserID(userName);
		Connection connection = ConnectionFactory.getConnection();
		try {
	        PreparedStatement ps = connection.prepareStatement("UPDATE topquiz.Quiz_User SET "
	        		+ " Total_correct=?,"
	        		+ " Total_Wrong=?,"
	        		+ " Total_NA=?,"
	        		+ " User_score=?"
	        		+ " WHERE "
	        		+ "quizname=? AND " 
	        		+ "difficultyLevel=? AND "
	        		+ "Quiz_Id=? AND"
	        		+ " User_id=?");
	        ps.setInt(1, userquiz.getCorrectCount());
	        ps.setInt(2, userquiz.getWrongCount());
	        ps.setInt(3, userquiz.getNotAnsweredCount());
	        ps.setInt(4, userquiz.getYour_Totalscore());
	        ps.setString(5, quizName);
	        ps.setString(6, userquiz.getDifficultyLevel());
	        ps.setInt(7, quizid);
	        ps.setInt(8, userid);
	        int i = ps.executeUpdate();
	        if(i == 1) {
	            return true;
	              }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	            return false;
	}
	
	public ArrayList<String> getAllUserQuizDifficultyLevels(String username,String quizname) {
		UserDao userDao = new UserDao();
		int userid=userDao.extractUserID(username);
		Connection connection = ConnectionFactory.getConnection();
		try {
	        PreparedStatement ps = connection.prepareStatement("select distinct difficultyLevel from topquiz.quiz_user"
	        		+ " WHERE"
	        		+ " quizname=? AND"
	        		+ " User_id=?");
	        ps.setString(1, quizname);
	        ps.setInt(2, userid);
	        ResultSet rs = ps.executeQuery();
	        ArrayList<String> userQuizDiff= new ArrayList<String>();
	        while(rs.next())
	        {
	        	userQuizDiff.add(rs.getString("difficultyLevel"));
	        }
	        return userQuizDiff;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
}

