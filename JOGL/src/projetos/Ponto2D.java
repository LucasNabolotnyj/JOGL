package projetos;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class Ponto2D implements GLEventListener {
	private GLU glu = new GLU();
	private float velocidade = 0.0f;
	private float forca = 0.0f;
	
	public float h = 1 ;

	@Override
	public void display( GLAutoDrawable drawable ) {
		final GL2 gl = drawable.getGL().getGL2();

		gl.glMatrixMode( GL2.GL_PROJECTION );
		gl.glLoadIdentity();

		glu.gluPerspective( 45.0f, h, 1.0, 40.0 );
		glu.gluLookAt(0, 0, 11, 0, 0, 0, 0, 1, 0);
		gl.glMatrixMode( GL2.GL_MODELVIEW );
		gl.glLoadIdentity();



		gl.glShadeModel( GL2.GL_SMOOTH );
		gl.glClearColor( 0f, 0f, 0f, 0f );
		gl.glClearDepth( 1.0f );
		gl.glEnable( GL2.GL_DEPTH_TEST );
		gl.glDepthFunc( GL2.GL_LEQUAL );
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

		// Clear The Screen And The Depth Buffer
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); 
		gl.glLoadIdentity(); // Reset The View

		//gl.glRotatef( rtri, 0.0f, 1.0f, 0.0f );
		// gl.glRotatef( -rtri, 1.0f, 1.0f, 0.0f );

		gl.glColor3f(1f, 1f, 1f);

		gl.glVertex2f(0,-10);
		gl.glVertex2f(0,10);
		gl.glVertex2f(10,0);
		gl.glVertex2f(-10,0);
		gl.glEnd();
		
		//**********************
		float Vel = 0.01f;
		float For = 0.02f;
		//*********************
		gl.glColor3f(1f, 0f, 1f);
		gl.glBegin (GL2.GL_POINTS);
		gl.glVertex3f(velocidade,forca,0f);
		gl.glEnd();
		
		gl.glFlush();
		Movimentar(Vel,For);
		if (velocidade>2 | forca>2 ){
			velocidade=0f;
			forca=0f;}
	}

	private void Movimentar(float vel, float for1) {
		
		velocidade+= vel;
		forca+=for1;
	}

	@Override
	public void dispose( GLAutoDrawable drawable ) {
	}

	@Override
	public void init( GLAutoDrawable drawable ) {

		final GL2 gl = drawable.getGL().getGL2();

		gl.glShadeModel( GL2.GL_SMOOTH );
		gl.glClearColor( 0f, 0f, 0f, 0f );
		gl.glClearDepth( 1.0f );
		gl.glEnable( GL2.GL_DEPTH_TEST );
		gl.glDepthFunc( GL2.GL_LEQUAL );
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height ) {

		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
		if( height <= 0 ) 
			height = 1;

		h = ( float ) width / ( float ) height;
		gl.glViewport( 0, 0, width, height );
		gl.glMatrixMode( GL2.GL_PROJECTION );
		gl.glLoadIdentity();

		glu.gluPerspective( 45.0f, h, 1.0, 40.0 );
		glu.gluLookAt(0, 0, 10 + velocidade, 0, 0, 0, 0, 1, 0);
		gl.glMatrixMode( GL2.GL_MODELVIEW );
		gl.glLoadIdentity();


	}

	public static void main( String[] args ) {


		// TODO Auto-generated method stub
		final GLProfile profile = GLProfile.get( GLProfile.GL2 );
		GLCapabilities capabilities = new GLCapabilities( profile );

		// The canvas
		final GLCanvas glcanvas = new GLCanvas( capabilities );
		Ponto2D triangledepthtest = new Ponto2D();

		glcanvas.addGLEventListener( triangledepthtest );
		glcanvas.setSize( 1200, 1200 );

		JFrame frame = new JFrame ( "CUBO" );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(glcanvas);
		frame.setSize( frame.getContentPane().getPreferredSize() );
		frame.setVisible( true );
		final FPSAnimator animator = new FPSAnimator( glcanvas, 100, true);

		animator.start();
	}
}
