package dcll.absv.ParserXML;

import java.util.ArrayList;

public class Quiz {
	
	public enum QuizType {
		TrueFalse(1),
		PairMatching(2),
		MultipleChoice(3);
		
		private int index;
		QuizType(int index) {
			this.index = index ;
		}
	};
	
	
	
	ArrayList<Question> questions;
	
}
