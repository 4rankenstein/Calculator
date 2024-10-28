
/**
 * calculator
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class calculator implements ActionListener {


    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons= new JButton[8];
    JButton addButton,subButton,mulButton,divButton,decButton,equButton,delButton,clrButton;
    JPanel panel;
    Font myFont = new Font("Ariel",Font.BOLD,30);
    double num1,num2,doubleres;
    int intresult;
    char operator;

    calculator(){

        /*initialising the size of the frame  */
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        /*creating and adding text field for display */
        textfield = new JTextField();
        textfield.setBounds(50,35,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        frame.add(textfield);

        /* instantiating  function  buttons*/
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        clrButton = new JButton("Clr");
        delButton = new JButton("Del");
        equButton = new JButton("=");
         
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = decButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i=0;i<functionButtons.length;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);     /* to avoid highlighting of the pdoubleressed button */  
        }

        /* instantiating numberbuttons */
        for(int j=0;j<numberButtons.length;j++){
            numberButtons[j] = new JButton(String.valueOf(j));
            numberButtons[j].addActionListener(this);
            numberButtons[j].setFont(myFont);
            numberButtons[j].setFocusable(false);     /* to avoid highlighting of the pdoubleressed button  */
        }

         /* panel inistialisation*/
         panel = new JPanel();
         panel.setBounds(50, 110, 300, 300);
         panel.setLayout(new GridLayout(4,4,10,10));    /* specifying the gap btwn buttons as 10px */
         frame.add(panel);

         /* adding buttons to panel */
         panel.add(numberButtons[1]);
         panel.add(numberButtons[2]);
         panel.add(numberButtons[3]);
         panel.add(addButton);
         panel.add(numberButtons[4]);
         panel.add(numberButtons[5]);
         panel.add(numberButtons[6]);
         panel.add(subButton);
         panel.add(numberButtons[7]);
         panel.add(numberButtons[8]);
         panel.add(numberButtons[9]);
         panel.add(mulButton);
         panel.add(decButton);
         panel.add(numberButtons[0]);
         panel.add(equButton);
         panel.add(divButton);


        /* separating del and clr */
         delButton.setBounds(50,430,145,50);
         clrButton.setBounds(205,430,145,50);
         frame.add(delButton);
         frame.add(clrButton);

    
       
        frame.setVisible(true);     /* this statement will render the frame after all components are intialised */
    }

    public static void main(String[] args) {
        calculator cal = new calculator();  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]) textfield.setText(textfield.getText().concat(String.valueOf(i)));
            /* textfield.getText() use is to get the previous input and concat with the current input */
        }
        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat("."));}
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");}
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");}
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator='x';
            textfield.setText("");}
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");}
        if(e.getSource()==equButton){
            num2 = Double.parseDouble(textfield.getText());
            textfield.setText("");
            switch (operator) {
                case '+':
                        doubleres=num1+num2;
                        break;
                case '-':
                        doubleres=num1-num2;
                        break;
                case 'x':
                        doubleres = num1*num2;
                        break;
                case '/':
                        doubleres =num1/num2;
                        break;       
            }
            if(num1%1 !=0 && num2%1 !=0 || (num1%1 !=0 && num2%1 ==0) ||(num1%1 ==0 && num2%1 !=0)) {textfield.setText(String.valueOf(doubleres));}

            else{intresult=(int)doubleres;
            textfield.setText(String.valueOf(intresult));
            // num1=intresult;
            }  
        }
        if(e.getSource()==clrButton) {textfield.setText(" ");}   
        if(e.getSource() == delButton) {
        String currentText = textfield.getText();
        textfield.setText(currentText.substring(0, currentText.length() - 1));}

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }  
}
