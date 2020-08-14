//wayne warren 2016
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
// implementation test maybe replace buttons with[ String JOptionPane.showInputDialog(Component parentComp, String question)
// and change to ints, when a textfield box has focus
// 
public class StartGUI{
	static Countdown game;
	static double testNums[] = new double[6];
	static int target = 0;
	static ArrayList<Object> allTextFields;
	static JPanel parent;
	static String message = "After entering six numbers followed by\nthe target number, the answers are\ndisplayed here.";
	static JTextArea textAnswers = new JTextArea(message); 
 	

	private static class eventHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			// clear all fields
			if(e.getActionCommand().equals("Clear") ) {
				target = 0;
				testNums = new double[6];
				textAnswers.setText(message);
				for (int x = 0; x < allTextFields.size(); x++) {
					JTextField test = (JTextField)allTextFields.get(x);
					test.setText("");
				}
			}
			if(e.getActionCommand().equals("Solve") ) { 
				// iterate through txtfield arry for checks... last one is the goal num
				for (int z = 0; z < allTextFields.size(); z++) {
					JTextField test = (JTextField)allTextFields.get(z);
					if (  test.getText().equals("")    ){
						test.requestFocus();
						JOptionPane.showMessageDialog(parent, "Enter six numbers\nfollowed by the target number.");
						
						break;
					} else {
						if(z < 6){ // try catch...
							testNums[z] = Double.parseDouble( test.getText() );
						} else if(z == 6){
							target = Integer.parseInt( test.getText() );
						}
					}
				} //end arrylist

				// if all nums added including goal num start game.
				if(testNums.length == 6 && target > 0){
					/*for (int x = 0; x < testNums.length; x++){
						System.out.println(x + "th element: " + testNums[x]); 
					}
					System.out.println(target);*/
					// start game
					game = new Countdown(target, testNums);
					game.run();
					String answers = game.getAnswers();
					if (answers.equals("pass")){
						textAnswers.setText( "No solution found." );
					}else {
						textAnswers.setText( answers ); //textfield set
					}
				}
			}
			
		}
			
		
	}


	public static void main(String[] args){
		//
		JSeparator spacer = new JSeparator();
		// textFields for nums and target
		JTextField targetNum = new JTextField();
		JTextField firstNum = new JTextField();
		JTextField secondNum = new JTextField();
		JTextField thirdNum = new JTextField();
		JTextField fourthNum = new JTextField();
		JTextField fifthNum = new JTextField();
		JTextField sixthNum = new JTextField();
		// store these for checking null  str in event handlers
		allTextFields = new ArrayList<Object>();
		allTextFields.add(firstNum);
		allTextFields.add(secondNum);	
		allTextFields.add(thirdNum);
		allTextFields.add(fourthNum);
		allTextFields.add(fifthNum);
		allTextFields.add(sixthNum);
		allTextFields.add(targetNum); // important, this is last in event listener check

		// evt handler s
		eventHandler listener = new eventHandler();
	
		// number fields
		JPanel textFields = new JPanel();
		textFields.setLayout(new GridLayout(1,8,10,5));
		//textFields.setBorder( BorderFactory.createEtchedBorder() ); 
		textFields.add(firstNum);
		textFields.add(secondNum);
		textFields.add(thirdNum);
		textFields.add(fourthNum);
		textFields.add(fifthNum);
		textFields.add(sixthNum);
		textFields.add(new JLabel(" "));
		textFields.add(targetNum);
		//JPanel txtTest = new JPanel(new FlowLayout(FlowLayout.CENTER));txtTest.add(textFields);
		
		// scroller panel
		textAnswers.setEditable(false);
		JScrollPane scrollerAnswers = new JScrollPane(textAnswers);
		

		//button container
		JPanel buttons = new JPanel(new GridLayout(1,2, 5,5)); // more elements to add later-new GridLayout(1,1, 5,5)
		JButton btnOk = new JButton( "Solve" );
		JButton btnClear = new JButton( "Clear" );
		btnOk.addActionListener(listener);
		btnClear.addActionListener(listener);
		buttons.add(btnOk);
		buttons.add(btnClear);
		
		//parent container
		parent = new JPanel(); //EmptyBorder(int top, int left, int bottom, int right)
		parent.setBorder( BorderFactory.createEmptyBorder(10,10,10,10) ); 
		//parent.setLayout(new GridLayout(4,1, 5,5)); // rows col
		parent.setLayout(new BorderLayout(10,10));
		// add fields
		
		
   
		parent.add(textFields, BorderLayout.NORTH);
		//parent.add(spacer);
		parent.add(scrollerAnswers, BorderLayout.CENTER);
		parent.add(buttons, BorderLayout.SOUTH);

		JFrame window = new JFrame("Numbers game test"); 
		window.setContentPane(parent);
		window.setSize(300,300);
		window.setLocation(100,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}
}
