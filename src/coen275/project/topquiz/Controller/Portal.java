package coen275.project.topquiz.Controller;
import coen275.project.topquiz.Model.*;
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
		return quizDao.getAllQuizNames	();
	}
	
    public Quiz GetQuiz(String quizName, String difficultyLevel)
    {
    	return quizDao.getQuiz(quizName, difficultyLevel);
    }
	
    public boolean UpdateQuiz(String quizName, String difficultyLevel, Integer time)
    {
    	return quizDao.updateQuiz(quizName, difficultyLevel, time);
    }
    
    public ArrayList<String> GetAllQuestionBankNames(String quizName, String difficultyLevel)
	{
		return quizDao.GetAllQuestionBankNames(quizName, difficultyLevel);
	}
    
    public ArrayList<String> GetAllUserQuizNames(String userName)
    {
    	return userQuizDao.GetAllUserQuizNames(userName);
    }
    
    public ArrayList<String> GetAllUserQuizDifficultyLevels(String userName, String quizName)
    {
    	return userQuizDao.getAllUserQuizDifficultyLevels(userName, quizName);
    }
    
    public UserQuiz GetUserQuiz(String userName, String quizName, String difficultyLevel)
    {
    	UserQuiz findObj = userQuizDao.GetUserQuiz(userName, quizName, difficultyLevel);
		// New user
		if(findObj == null)
		{
			UserQuiz userQuiz = new UserQuiz();
			userQuiz.setQuizName(quizName);
			userQuiz.setDifficultyLevel(difficultyLevel);
			return userQuizDao.RegisterUserToQuiz(userQuiz, userName);
		}		
		return findObj;
    }
    
    public boolean UpdateUserQuiz(String userName, String quizName, UserQuiz userquiz)
    {
    	return userQuizDao.UpdateUserQuiz(userName, quizName, userquiz);
    }	
}
