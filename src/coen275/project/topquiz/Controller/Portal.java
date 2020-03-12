package coen275.project.topquiz.Controller;
import coen275.project.topquiz.Model.*;

import java.security.Timestamp;
import java.util.*;

public class Portal {
	private QuizDao quizDao;
	private UserDao userDao;
	private UserQuizDao userQuizDao;
	
	public Portal()
	{
		quizDao = new QuizDao();
		userDao = new UserDao();
		userQuizDao = new UserQuizDao();
	}
	
	public ArrayList<String> GetAllUserNames()
	{
		return userDao.getAllUserNames();
	}
	
	public User GetUser(String userName)
	{
		User findObj = userDao.findUser(userName);
		// New user
		if(findObj == null)
		{
			return userDao.addUser(new User(userName, false));
		}
		
		return findObj;
	}
	
	
	public ArrayList<String> GetAllQuizNames()
	{
		return quizDao.getAllQuizNames();
	}
	
    public Quiz FindQuiz(String quizName, String difficultyLevel)
    {
    	return quizDao.findQuiz(quizName, difficultyLevel);
    }
	
    public Quiz UpdateQuiz(String quizName, String difficultyLevel, java.sql.Time time)
    {
    	return quizDao.updateQuiz(quizName, difficultyLevel, time);
    }
    
    public ArrayList<String> GetAllQuestionBankNames(String quizName, String difficultyLevel)
	{
		return quizDao.getAllQuestionBankNames(quizName, difficultyLevel);
	}
    
    public ArrayList<String> GetAllUserQuizNames(String userName)
    {
    	return userQuizDao.getAllUserQuizNames(userName);
    }
    
    public UserQuiz GetUserQuiz(String userName, String quizName)
    {
    	return userQuizDao.getUserQuiz(userName, quizName);
    }
    
    public UserQuiz RegisterUserToQuiz(String userName, String quizName)
    {
    	return userQuizDao.registerUserToQuiz(userName, quizName);
    }
    
    public UserQuiz UpdateUserQuiz(String userName, String quizName)
    {
    	return userQuizDao.updateUserQuiz(userName, quizName);
    }	
}
