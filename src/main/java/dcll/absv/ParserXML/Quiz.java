package dcll.absv.ParserXML;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;

import nu.xom.*;

public class Quiz {
	
	File fichierXML;
	
	ArrayList<IQuestion> questions1;
	
	public Quiz() {
	}
	
	public void toXML(){
		
		Element quiz = new Element("quiz");
		for (Iterator<IQuestion> iterator = questions1.iterator(); iterator.hasNext();) {
			IQuestion question = (IQuestion) iterator.next();
			quiz.appendChild(question.toXML());
		}
		  
		Document doc = new Document(quiz);
	    try {
	      Serializer serializer = new Serializer(System.out, "ISO-8859-1");
	      serializer.setIndent(4);
	      serializer.setMaxLength(64);
	      serializer.write(doc);  
	    }
	    catch (IOException ex) {
	       System.err.println(ex); 
	    }  
		
		
	}
	
	public void openFile(String _file){
		
//		Element parent = new Element("parent", 1);
//		   Element child = new Element("child", 0);
//		   parent.appendChild(child);
//		   Nodes results = child.query("/*");
//		   Node result = result.get(0);
	}
	
	public IQuestion getQuestion(int _n){
		if(_n<questions1.size()){
			return questions1.get(_n);
		}
		else{
			return null;
		}
	}
	
	public void deleteQuestion(int _n){
		if(_n<questions1.size()){
			questions1.remove(_n);
		}
	}
	
	public void deleteQuestion(IQuestion _question){
		questions1.remove(_question);
	}
	
	public void addQuestionCategory(){
		questions1.add(new QuestionCategory());		
	}
	
	public void addQuestionCalculated(){
		questions1.add(new QuestionCalculated());		
	}
	
	public void addQuestionDescription(){
		questions1.add(new QuestionDescription());		
	}
	
	public void addQuestionEssay(){
		questions1.add(new QuestionEssay());		
	}
	
	public void addQuestionMatching(){
		questions1.add(new QuestionMatching());		
	}
	
	public void addQuestionCloze(){
		questions1.add(new QuestionCloze());		
	}
	
	public void addQuestionMultiChoice(){
		questions1.add(new QuestionMultiChoice());		
	}
	
	public void addQuestionNumerical(){
		questions1.add(new QuestionNumerical());		
	}
	
	public void addQuestionShortAnswer(){
		questions1.add(new QuestionShortAnswer());		
	}
	
	public void addQuestionTrueFalse(){
		questions1.add(new QuestionTrueFalse());		
	}
}
