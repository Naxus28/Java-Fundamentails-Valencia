
import javax.swing.JOptionPane;

public class TestClass {

	public static void main(String[] args) {
       String input;
       String menu = "A. Add two numbers\n" +
               		 "B.  Cube a number\n" +
               		 "C.  Is prime?\n" +
               		 "Q.  Quit the program";
       char choice;
       input = JOptionPane.showInputDialog("What is your name", "Enter your name please.");
       //input = JOptionPane.showInputDialog("What is your name" );

       System.out.println("Hello " + input + ".");
       JOptionPane.showMessageDialog(null, "Hello " + input + ".");
       
       input = JOptionPane.showInputDialog("What is your age?");
       int age = Integer.parseInt(input);
       JOptionPane.showMessageDialog(null, "You are " + age + " in 5 years you will be " + (age + 5));
       
       do{
          input = JOptionPane.showInputDialog(menu,"Select");
          
          System.out.println("Choice " + input + ".");
          
          choice = input.toUpperCase().charAt(0);
          
//          switch(choice){
//            default:
//            	break;
//          } // end switch
          
       }while(choice != 'Q');
       
       
 	} // end of main
	
	public static int getANumber(){
	   int result;
 	   String input = JOptionPane.showInputDialog("Enter an integer.");
 	   result = Integer.parseInt(input);
 	   return result;
    }// end getANumber
    

}

