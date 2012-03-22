package dcll.absv.ParserXML;

import java.util.ArrayList;

public class Question {
	public enum QuestionType {
		TrueFalse(1),
		PairMatching(2),
		MultipleChoice(3);
		
		private int index;
		public int getIndex() {
			return index;
		}
		QuestionType(int index) {
			this.index = index ;
		}
	};
	
	QuestionType type;				// le type de question.
	String text;					// intitulé de la question
	Integer penalty;				// pts de pénalité si réponse fausse
	Integer defaultgrade;			// pts accordés si bonne réponse
	ArrayList<Reponse>	reponses; 	// les réponses possibles.
}
