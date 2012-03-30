package dcll.absv.ParserXML;


import nu.xom.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Quiz q = new Quiz();
    	q.openFile("quiz.xml");
    	
    	q.toXML("test.xml");

    }
}
