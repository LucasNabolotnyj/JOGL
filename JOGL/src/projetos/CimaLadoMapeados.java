package projetos;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CimaLadoMapeados extends JFrame {
	public static void main(String[] args) {
			 JFrame frame = new JFrame ( "CUBOvoador" );
	    JTextField obj1 = new JTextField();
     obj1.setMinimumSize(new Dimension(200, 200));
     obj1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				switch(e.getExtendedKeyCode()){
				case KeyEvent.VK_KP_UP:
					System.out.println("cima pressionado");
					break;
				case KeyEvent.VK_KP_RIGHT:
					System.out.println("direita pressionado");
					break;
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getExtendedKeyCode()){
				case KeyEvent.VK_KP_UP:
					System.out.println("cima pressionado");
					break;
				case KeyEvent.VK_KP_RIGHT:
					System.out.println("direita pressionado");
					break;
				}
				
			
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getExtendedKeyCode()){
				case KeyEvent.VK_UP:
					System.out.println("cima pressionado");
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println("direita pressionado");
					break;
				}
				
			}
		});
     frame.add(obj1);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize( 1000,100);
	    frame.setVisible( true );
	}
}
