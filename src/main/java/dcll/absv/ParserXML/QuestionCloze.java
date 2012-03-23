/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

/**
 *
 * @author Nicolas
 */
public class QuestionCloze implements IQuestion{
    private String name;
    private String[] questionText; //Un tableau de deux case, une pour indiquer le format (s'il y a) et une pour le texte
    private String generalFeedBack;
    private String shuffleAnswer;
    
    public QuestionCloze(){
        name="";
        questionText = new String[2];
        questionText[0]="";
        questionText[1]="";
        
    }
    
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
    
    public String getName(){
        return name;
    }
    
    public String getQuestionTextFormat(){
        return questionText[0];
    }
    
    public String getQuestionTextText(){
        return questionText[1];
    }
    
    public String getGeneralFeedBack(){
        return generalFeedBack;
    }
    
    public String getShuffleAnswer(){
        return shuffleAnswer;
    }
    
    public void setName(String _name){
        name=_name;
    }
    
    public void setQuestionText(String _questionTextFormat){
        questionText[0]=_questionTextFormat;
    }
    
    public void setQuestionTextText(String _questionTextText){
        questionText[1]=_questionTextText;
    }
        
    public void setGeneralFeedBack(String _generalFeedBack){
        generalFeedBack=_generalFeedBack;
    }
    
    public void setShuffleAnswer(String _shuffleAnswer){
        shuffleAnswer=_shuffleAnswer;
    }
}
