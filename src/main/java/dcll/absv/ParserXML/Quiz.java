package dcll.absv.ParserXML;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;

import nu.xom.*;

public class Quiz {
	
	File fichierXML;
	
	ArrayList<IQuestion> questions;
	
	public Quiz() {
	}
	
	public void toXML(){
		
		Element quiz = new Element("quiz");
		for (Iterator<IQuestion> iterator = questions.iterator(); iterator.hasNext();) {
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
		if(_n<questions.size()){
			return questions.get(_n);
		}
		else{
			return null;
		}
	}
	
	public void deleteQuestion(int _n){
		if(_n<questions.size()){
			questions.remove(_n);
		}
	}
	
	public void deleteQuestion(IQuestion _question){
		questions.remove(_question);
	}
	
	public void addQuestionCategory(){
		questions.add(new QuestionCategory());		
	}
	
	public void addQuestionCalculated(){
		questions.add(new QuestionCalculated());		
	}
	
	public void addQuestionDescription(){
		questions.add(new QuestionDescription());		
	}
	
	public void addQuestionEssay(){
		questions.add(new QuestionEssay());		
	}
	
	public void addQuestionMatching(){
		questions.add(new QuestionMatching());		
	}
	
	public void addQuestionCloze(){
		questions.add(new QuestionCloze());		
	}
	
	public void addQuestionMultiChoice(){
		questions.add(new QuestionMultiChoice());		
	}
	
	public void addQuestionNumerical(){
		questions.add(new QuestionNumerical());		
	}
	
	public void addQuestionShortAnswer(){
		questions.add(new QuestionShortAnswer());		
	}
	
	public void addQuestionTrueFalse(){
		questions.add(new QuestionTrueFalse());		
	}
	
	public int getNumberQuestion(){
		return questions.size();
	}
	
	public void moveUpQuestion(int _n){
		IQuestion q;
		if(_n>0){
			q=questions.get(_n - 1);
			questions.set(_n - 1, questions.get(_n));
			questions.set(_n, q);
		}
	}
	
	public void moveDownQuestion(int _n){
		IQuestion q;
		if(_n<this.getNumberQuestion()){
			q=questions.get(_n + 1);
			questions.set(_n + 1, questions.get(_n));
			questions.set(_n, q);
		}
	}
}
