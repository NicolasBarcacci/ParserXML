package dcll.absv.ParserXML;

import java.util.ArrayList;

public class Quiz {
	
	public enum QuizType {
		TrueFalse(1),
		PairMatching(2),
		MultipleChoice(3);
		
	};
	
	ArrayList<Question> questions;
	
}
