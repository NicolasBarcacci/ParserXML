/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

/**
 *
 * @author Nicolas
 */
public class QuestionTrueFalse extends QuestionClasseIntermediaire{
    private String[] answer; //De type string en attendant de définir les answer
    
    public QuestionTrueFalse(){
        super();
        answer = new String[2];
        answer[0]="";
        answer[1]="";
    }
    
    public QuestionTrueFalse(String xml){
        super("","","","","","","","","");
        answer = new String[2];
    }
    
   public QuestionTrueFalse(String _name, String _questionTextFormat, String _questionTextText, String _generalFeedBack, String _shuffleAnswer, String _defaultGrade, String _penalty, String _hidden, String _image){
        super(_name,_questionTextFormat,_questionTextText,_generalFeedBack,_shuffleAnswer,_defaultGrade,_penalty,_hidden,_image);
    }
    
    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String getAnswer1(){
        return answer[0];
    }
    
    public String getAnswer2(){
        return answer[1];
    }
    
    public void setAnswer1(String _answer){
        answer[0]=_answer;
    }
    
    public void setAnswer2(String _answer){
        answer[1]=_answer;
    }
}
