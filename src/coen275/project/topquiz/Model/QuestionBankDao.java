package coen275.project.topquiz.Model;

import java.sql.*;
import java.util.ArrayList;

public class QuestionBankDao {

	private QASet extractQASet(ResultSet rs) throws SQLException {
		QASet question = new QASet();
		question.setQuestionNumber(rs.getInt("QuestionNumber"));
    	question.setQuestion( rs.getString("Question") );
    	question.setAnswerChoice1( rs.getString("AnswerChoice1") );
    	question.setAnswerChoice2( rs.getString("AnswerChoice2") );
    	question.setAnswerChoice3( rs.getString("AnswerChoice3") );
    	question.setAnswerChoice4( rs.getString("AnswerChoice4") );
    	question.setCorrectAnswer( rs.getString("CorrectAnswer") );
    	question.setQuestionType( rs.getString("QuestionType") );
    	question.setPoints(rs.getInt("Points"));
    	question.setImagePath(rs.getString("ImageFile"));
        return question;
	}
	
	public QuestionBank getQuestionBank(String difficultyLevel,String quizname) {
		QuestionBank retrivedQuestionBank = new QuestionBank();
		Connection connection = ConnectionFactory.getConnection();
        try {	
        	PreparedStatement ps = connection.prepareStatement("select * from topquiz.questions where ID in (select" + 
	        		" b.qasetid" 
	        		+ " FROM"
	        		+ " topquiz.quiz as a"
	        		+ " left join "
	        		+ " topquiz.questionbank as b"
	        		+ " on a.questionbankid=b.questionbankId"
	        		+ " WHERE quizname=? AND difficultyLevel=?)");
            ps.setString(2, difficultyLevel);
            ps.setString(1, quizname);
            ResultSet rs = ps.executeQuery();
            ArrayList<QASet> questions= new ArrayList<QASet>();
            
            while(rs.next())
            {
            	questions.add(extractQASet(rs));
            }
            retrivedQuestionBank.setQuestionAnswerSets(questions);
            retrivedQuestionBank.setDifficultyLevel(difficultyLevel);
            return retrivedQuestionBank;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
	
	
	
}
