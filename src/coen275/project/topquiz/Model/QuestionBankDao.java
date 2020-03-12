package coen275.project.topquiz.Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionBankDao {
	
	ArrayList<QASet> questions;
	private QASet extractQASet(ResultSet rs) throws SQLException {
		QASet question = new QASet();
		question.setQuestionId(rs.getInt("QuestionNumber"));
    	question.setQuestion( rs.getString("Question") );
    	question.setAnswerChoice1( rs.getString("AnswerChoice1") );
    	question.setAnswerChoice2( rs.getString("AnswerChoice2") );
    	question.setAnswerChoice3( rs.getString("AnswerChoice3") );
    	question.setAnswerChoice4( rs.getString("AnswerChoice4") );
    	question.setExpectedAnswer( rs.getString("CorrectAnswer") );
    	question.setQuestionType( rs.getString("QuestionType") );
    	question.setPoints(rs.getInt("Points"));
        return question;
	}

}
