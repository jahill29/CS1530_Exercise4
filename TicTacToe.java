import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
	JFrame _frame = new JFrame("Tic-Tac-Toe");
	JButton[] _buttons = new JButton[9];
	JButton _button2 = new JButton("New Game");
	boolean flip = false;

	public TicTacToe() {
	_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel _ttt = new JPanel();
		JPanel _newPanel = new JPanel();
		_ttt.setLayout(new GridLayout(3, 3));
		_newPanel.setLayout(new FlowLayout());
		_frame.add(_ttt, BorderLayout.NORTH);
		_frame.add(_newPanel, BorderLayout.SOUTH);

		for (int j=0; j<9; j++) {
			_buttons[j] = new JButton("_");
			ActionListener buttonListener = new ButtonListener();
			_buttons[j].addActionListener(buttonListener);
			_buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
			_ttt.add(_buttons[j]);
		}

		ActionListener buttonListen2 = new ButtonListener2();
		_button2.addActionListener(buttonListen2);
		_button2.setFont(new Font("Courier", Font.PLAIN, 48));
		_newPanel.add(_button2);
		
		_frame.setSize(400, 400);
		_frame.setVisible(true);
	}


		public static void main(String[] args) {
		new TicTacToe();
		}



	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			flip = !flip;
			JButton source = (JButton) e.getSource();
			String currentText = source.getText();
			if (currentText.equals("_")) {
				if (flip == true)
				{
					source.setText("X");
				}
				else
				{
					source.setText("O");
				}
				source.setEnabled(false);
			}
		}
	}

	class ButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			String currentText = source.getText();
			if (currentText.equals("New Game")) {
				for (int i=0; i<9; i++)
				{
					_buttons[i].setText("_");
					_buttons[i].setEnabled(true);
				}	
			}
		}
	}
		
}
