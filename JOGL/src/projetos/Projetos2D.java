package projetos;
import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public  class Projetos2D implements GLEventListener {

	@Override
	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();

		////LINHA EXEMPLO
		//		      gl.glBegin (GL2.GL_LINES);//static field
		//		      gl.glVertex3f(0.50f,-0.50f,1.0f);
		//		      gl.glVertex3f(-0.50f,0.50f,0);
		//		      gl.glEnd();

		////      TRIANGULO EXEMPLO
		//      gl.glBegin (GL2.GL_TRIANGLES);//static field
		//		      gl.glVertex2f(2.0f,1);
		//		      gl.glVertex2f(1.0f,1.0f);
		//		      gl.glVertex2f(1.0f,2.0f);
		//      gl.glEnd();
		////		QUADRADO EXEMPLO
		//		gl.glBegin (GL2.GL_QUADS);//static field
		//		gl.glColor3f(1f, 0f, 0f);
		//		gl.glVertex2f(0.50f,-0.50f);
		//		gl.glColor3f(0f, 1f, 0f);
		//		gl.glVertex2f(0.50f,0.50f);
		//		gl.glVertex2f(-0.50f,0.50f);
		//		gl.glColor3f(0f, 0f, 1f);
		//		gl.glVertex2f(-0.50f,-0.50f);
		//		gl.glEnd();


		//		//		CASA EXEMPLO
		//		//	PAREDE
		//		gl.glBegin (GL2.GL_QUADS);//static field
		//		gl.glColor3f(0f, 1f, 0f);
		//		gl.glVertex2f(0.50f,-0.50f);
		//		gl.glVertex2f(0.50f,0.50f);
		//		gl.glVertex2f(-0.50f,0.50f);
		//		gl.glVertex2f(-0.50f,-0.50f);
		//		gl.glEnd();
		//		//TELHADO
		//		gl.glBegin (GL2.GL_TRIANGLES);//static field
		//		gl.glColor3f(1f, 0f, 1f);
		//		gl.glVertex2f(0f,1.0f);
		//		gl.glVertex2f(-0.60f,0.51f);
		//		gl.glVertex2f(0.60f,0.51f);
		//		gl.glEnd();
		//		//JANELA
		//		gl.glBegin (GL2.GL_QUADS);//static field
		//		gl.glColor3f(0f, 0f, 1f);
		//		gl.glVertex2f(-0.15f,0.40f);
		//		gl.glVertex2f(-0.15f,0.20f);
		//		gl.glVertex2f(-0.40f,0.20f);
		//		gl.glVertex2f(-0.40f,0.40f);
		//		gl.glEnd();
		//		//PORTA
		//		gl.glBegin (GL2.GL_QUADS);//static field
		//		gl.glColor3f(1f, 1f, 0f);
		//		gl.glVertex2f(0.10f,-0.50f);
		//		gl.glVertex2f(0.10f,0f);
		//		gl.glVertex2f(0.40f,0f);
		//		gl.glVertex2f(0.40f,-0.50f);
		//		gl.glEnd();



		//		float i = 0.0f;
		//		gl.glColor3f(1f, 1f, 1f);
		//	      for(i=0.0f; i==1f; i=i+0.10f){
		//	      gl.glBegin (GL2.GL_LINES);//static field
		//	      gl.glVertex3f(1,-1.0f,i);
		//	      gl.glVertex3f(-1,-1.0f,i);
		//	      gl.glEnd();
		//	      }

		//gl.glBegin (GL2.GL_LINE_STRIP);
		//
		
		float i = -1.0f;
		gl.glColor3f(1f, 1f, 1f);
		gl.glBegin (GL2.GL_LINES);//static field
		while( i!=1f){
			gl.glVertex2f(1,i);
			gl.glVertex2f(-1,i);
			i=i+0.25f;
		}
		i=-1.0f;
		while( i!=1f){
			gl.glVertex2f(i,1);
			gl.glVertex2f(i,-1);
			i=i+0.25f;
		}
		gl.glEnd();
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		//method body
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// method body
	}


	public static void main(String[] args) {

		//getting the capabilities object of GL2 profile        
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		// The canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		Projetos2D line = new Projetos2D();
		glcanvas.addGLEventListener(line);
		glcanvas.setSize(400, 400);

		//creating frame
		final JFrame frame = new JFrame ("Projeto2D");

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//adicionando canvas no frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);

	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {

	}

}//end of classimport javax.media.opengl.GL2;
