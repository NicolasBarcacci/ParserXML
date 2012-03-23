/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

/**
 *
 * @author Nicolas
 */
public class QuestionMatching extends QuestionClasseIntermediaire{
    private String[][] subquestion;
	
	public QuestionMatching(){
        super();
        subquestion = new String[4][2];
    }
    
    public QuestionMatching(String xml){
        super("","","","","","","","","");
        subquestion = new String[4][2];
    }
    
   public QuestionMatching(String _name, String _questionTextFormat, String _questionTextText, String _generalFeedBack, String _shuffleAnswer, String _defaultGrade, String _penalty, String _hidden, String _image){
        super(_name,_questionTextFormat,_questionTextText,_generalFeedBack,_shuffleAnswer,_defaultGrade,_penalty,_hidden,_image);
        subquestion = new String[4][2];
   }
    
   public String getSubquestionXText(int i){
	   if(i<4){
		   return subquestion[i][0];
	   }
	   else{
		   return "";
	   }
   }
   
   public String getSubquestionXAnswer(int i){
	   if(i<4){
		   return subquestion[i][1];
	   }
	   else{
		   return "";
	   }
   }
   
   public void setSubquestionXText(int i, String _text){
	   if(i<4){
		   subquestion[i][0]=_text;
	   }
   }
   public void setSubquestionXAnswer(int i, String _answer){
	   if(i<4){
		   subquestion[i][1]=_answer;
	   }
   }
    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
