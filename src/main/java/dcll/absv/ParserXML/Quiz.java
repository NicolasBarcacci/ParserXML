package dcll.absv.ParserXML;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import nu.xom.*;

public class Quiz {
	
	File fichierXML;
	
	ArrayList<IQuestion> questions;
	
	public Quiz() {
		this.questions = new ArrayList<IQuestion>();
	}
	
	public Document toXML(String _filename){
		
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
	      FileWriter fstream = new FileWriter(_filename);
	      BufferedWriter out = new BufferedWriter(fstream);
	      out.write(doc.toString());
	      return doc;
	    }
	    catch (IOException ex) {
	       System.err.println(ex); 
	    }  
		return null;
		
	}
	
	
	public void openFile(String _file){

		try {

			Builder parser = new Builder();
			//   Document doc = parser.build(args[0]);
			Document doc = parser.build(_file);
			showElement(doc.getRootElement(), 0);
			for (int i = 0; i < doc.getRootElement().getChildElements("question").size(); i++) {
				IQuestion question = creerQuestion(doc.getRootElement().getChildElements("question").get(i).getAttributeValue("type"),doc.getRootElement().getChildElements("question").get(i));
				this.questions.add(question);
			}
		}
		catch (ValidityException ex) {
			System.err.println(_file+" : Pas valide.");
		}
		catch (java.io.IOException ex) {
			System.err.println(_file+" : Ne peux pas lire le fichier.");
		} 
		catch (ParsingException e) {
			e.printStackTrace();
		}

	}
	
	
//	private Class getClassQuestion(String attributeValue) {
		
//		return null;
//	}

	private IQuestion creerQuestion(String typeQuestion, Element questionXML) {
		IQuestion question = null;
		
		if (typeQuestion=="cloze") {
			
		} else if (typeQuestion=="truefalse") {
			question = new QuestionTrueFalse();
		} else if (typeQuestion=="calculated") {
			question = new QuestionCalculated();
		} else if (typeQuestion=="description") {
			question = new QuestionDescription();
		} else if (typeQuestion=="essay") {
			question = new QuestionEssay();
		} else  if (typeQuestion=="matching") {
			question = new QuestionMatching() ;
		} else  if (typeQuestion=="multichoice") {
			question = new QuestionMultiChoice();
		} else  if (typeQuestion=="numerical") {
			question = new QuestionNumerical();
		} else  if (typeQuestion=="shortanswer") {
			question = new QuestionShortAnswer();
		} else  if (typeQuestion=="category") {
			question = new QuestionCategory();
		}
		question.importXML(questionXML);
		return question;
	}
	
	private static void showElement(Element element, int level) {
		// preciser la balise et les attributs
		indent(level, "<"+element.getLocalName());
		for (int i=0; i < element.getAttributeCount(); i++) {
			Attribute attr = element.getAttribute(i);
			System.out.print(" "+attr.getLocalName()+"='"+attr.getValue()+"'");
		}
		System.out.println(">");

		// boucle pour les noeuds fils
		for (int i=0; i < element.getChildCount(); i++) {
			Node node = element.getChild(i);
			if (node instanceof Text) {
				String text = node.getValue();
				if (text.length() > 30) {
					indent(level+1, "|"+text.substring(0,30)+"...\n");
				}
			} else if (node instanceof Element) {
				showElement((Element)node, level+1);
			}
		}
	}

	private static void indent(int level, String string) {
		for (int i=0; i < level; i++) { System.out.print("  "); }
		System.out.print(string);
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
	
	public void deleteAllQuestion(){
		questions.clear();
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

	public static Element getElementText(String label){
		Element text = new Element("text");
		text.appendChild(label);
		return text;
	}
}
