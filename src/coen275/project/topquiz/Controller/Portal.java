package coen275.project.topquiz.Controller;
import coen275.project.topquiz.Model.*;
import java.util.*;

public class Portal {
	ArrayList<Quiz> quizzess;
	ArrayList<User> users;
	ArrayList<QuestionBank> questionBanks;
	
	public List<QuestionBank> getQuestionBanks() {
		return questionBanks;
	}

	public Portal() {
		quizzess = new ArrayList<Quiz>();
		users = new ArrayList<User>();
	}

	public ArrayList<Quiz> GetAllQuizzes() {
		return quizzess;
	}

	public ArrayList<User> GetAllUsers() {
		users.add(new User("Nitya", true));
		users.add(new User("Sameeksha", true));
		users.add(new User("Brithi", false));
		return users;
	}

	public void SaveQuiz(Quiz quiz) {
		quizzess.add(quiz);
	}

	public void RegisterUserToQuiz(User user, UserQuiz userQuiz) {
		user.AddQuiz(userQuiz);
	}

	public ArrayList<UserQuiz> GetAllUserQuiz(User user) {
		return user.GetAllQuiz();
	}

	public ArrayList<QuestionBank> GetAllQuestionBankRelatedtoCategory(Utility.QuizCategory category) {
		return questionBanks;
	}
	
	public User GetUser(String userName, boolean isAdmin)
	{
		User findObj = this.GetAllUsers().stream().filter(user -> user.getName().equals(userName)).findAny().orElse(null);
		// New user
		if(findObj == null)
		{
			return new User(userName, isAdmin);
		}
		
		return findObj;
	}
	
	public void UpdateUser(User user)
	{
		
	}

}
