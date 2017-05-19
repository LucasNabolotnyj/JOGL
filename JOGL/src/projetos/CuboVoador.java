package projetos;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class CuboVoador implements GLEventListener {
	private GLU glu = new GLU();
	private float rtri = 0.0f; 
	public float h = 1 ;
	//velocidade -> eixo X por enquanto
	private float velocidade = 0.0f;
	//força -> eixo Y por enquanto
	private float forca = 0.0f;
	//******************
	//VEL E FOR SÃO CONSTANTES QUE ALTERAM DIRETAMENTE AS VARIÁVEIS VELOCIDADE E FORÇA, ATRAVÉS 
	//DO MÉTODO MOVIMENTAR  
	public static float Vel = 0.0f;
	public static float For = 0.0f;
	//*********************

	@Override
	public void display( GLAutoDrawable drawable ) {
		final GL2 gl = drawable.getGL().getGL2();

		gl.glMatrixMode( GL2.GL_PROJECTION );
		gl.glLoadIdentity();

		glu.gluPerspective( 45.0f, h, 1.0, 40.0 );
		//Câmera girando
//		glu.gluLookAt(Math.cos(rtri) * 6, 0, Math.sin(rtri) * 6, 0, 0, 0, 0, 1, 0);
		//primeiros 3 numeros: terceira pessoa(5 de Z) 4 a 6 numeros: apontando
		//para o cubo(meio do cubo ou Z=0)
				      glu.gluLookAt((6f+velocidade), (6f+forca), 0, velocidade, forca, 0, 0, 1, 0);
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


		gl.glBegin( GL2.GL_QUADS);


		//AS COORDENADAS CONSTANTES DÃO FORMA AO CUBO(OBJETO), AS VARIÁVEIS O MOVEM

		//frente
		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( -1.0f+velocidade, -1.0f+forca, 1.0f ); 

		gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
		gl.glVertex3f( -1.0f+velocidade, 1.0f+forca, 1.0f ); 

		gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
		gl.glVertex3f( 1.0f+velocidade, 1.0f+forca, 1.0f ); 

		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( 1.0f+velocidade, -1.0f+forca, 1.0f );



		//trás
		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( -1.0f+velocidade, -1.0f+forca, -1.0f ); 

		gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
		gl.glVertex3f( -1.0f+velocidade, 1.0f+forca, -1.0f ); 

		gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
		gl.glVertex3f( 1.0f+velocidade, 1.0f+forca, -1.0f ); 

		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( 1.0f+velocidade, -1.0f+forca, -1.0f );


		//cima
		gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
		gl.glVertex3f( -1.0f+velocidade, 1.0f+forca, -1.0f ); // Left

		gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
		gl.glVertex3f( 1.0f+velocidade, 1.0f+forca, -1.0f ); // Right)

		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( 1.0f+velocidade, 1.0f+forca, 1.0f ); // Top


		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( -1.0f+velocidade, 1.0f+forca, 1.0f ); // Top

		//baixo
		gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
		gl.glVertex3f( -1.0f+velocidade, -1.0f+forca, -1.0f ); // Left

		gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
		gl.glVertex3f( 1.0f+velocidade, -1.0f+forca, -1.0f ); // Right)

		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( 1.0f+velocidade, -1.0f+forca, 1.0f ); // Top


		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( -1.0f+velocidade, -1.0f+forca, 1.0f ); // Top


		//esquerda
		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( -1.0f+velocidade, -1.0f+forca, 1.0f ); 

		gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
		gl.glVertex3f( -1.0f+velocidade, -1.0f+forca, -1.0f );

		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( -1.0f+velocidade, 1.0f+forca, -1.0f ); 

		gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
		gl.glVertex3f( -1.0f+velocidade, 1.0f+forca, 1.0f ); 

		//direita
		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( 1.0f+velocidade, -1.0f+forca, 1.0f ); 

		gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
		gl.glVertex3f( 1.0f+velocidade, -1.0f+forca, -1.0f );

		gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
		gl.glVertex3f( 1.0f+velocidade, 1.0f+forca, -1.0f ); 

		gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
		gl.glVertex3f( 1.0f+velocidade, 1.0f+forca, 1.0f ); 



		gl.glEnd(); // Done Drawing 3d triangle (Pyramid)



		float i = -10.0f;
		gl.glColor3f(1f, 1f, 1f);
		gl.glBegin (GL2.GL_LINES);//static field
		while( i!=10.0f){
			gl.glVertex3f(10f,-1.0f,i);
			gl.glVertex3f(-10f,-1.0f,i);
			i=i+0.25f;
		}
		i=-10.0f;
		while( i!=10.0f){
			gl.glVertex3f(i,-1.0f,10f);
			gl.glVertex3f(i,-1.0f,-10f);
			i=i+0.25f;
		}
		gl.glVertex3f(0f,10.0f,0.0f);
		gl.glVertex3f(0f,-1.0f,0.0f);  
		gl.glEnd();




		gl.glFlush();

		Movimentar(Vel,For);
		if (velocidade>10 | forca>2 | velocidade<-10 | forca<-2){
			velocidade=0f;
			forca=0f;}
		rtri += 0.001f;
	}
	//*************************************
	//MÉTODO QUE GERA A ALTERAÇÃO DAS COORDENADAS DO CUBO
	private void Movimentar(float vel, float for1) {
		velocidade+= vel;
		forca+=for1;
	}
	//****************************************


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
		glu.gluLookAt(0, 0, 10 + rtri, 0, 0, 0, 0, 1, 0);
		gl.glMatrixMode( GL2.GL_MODELVIEW );
		gl.glLoadIdentity();


	}

	public static void main( String[] args ) {


		// TODO Auto-generated method stub
		final GLProfile profile = GLProfile.get( GLProfile.GL2 );
		GLCapabilities capabilities = new GLCapabilities( profile );

		// The canvas
		final GLCanvas glcanvas = new GLCanvas( capabilities );
		CuboVoador testecubovoador = new CuboVoador();

		glcanvas.addGLEventListener( testecubovoador );
		glcanvas.setSize( 1000, 400 );

		JFrame frame = new JFrame ( "CUBOvoador" );

		//adicionando keymapping
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				//				switch(e.getExtendedKeyCode()){
				//				case KeyEvent.VK_KP_UP:
				//					Vel+=0.04f;
				//					System.out.println("cima pressionado");
				//					break;
				//				case KeyEvent.VK_KP_RIGHT:
				//					For+=0.04f;
				//					System.out.println("direita pressionado");
				//					break;
				//				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getExtendedKeyCode()){
				case KeyEvent.VK_KP_UP:
					Vel=0f;
					System.out.println("cima Solto");
					break;
				case KeyEvent.VK_KP_RIGHT:
					For=0f;
					System.out.println("direit"
							+ "a Solto");
					break;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getExtendedKeyCode()){
				case KeyEvent.VK_UP:
					For+=0.04f;
					System.out.println("cima pressionado");
					break;
				case KeyEvent.VK_DOWN:
					For-=0.04f;
					System.out.println("baixo pressionado");
					break;
				case KeyEvent.VK_RIGHT:
					Vel+=0.04f;
					System.out.println("direita pressionado");
					break;
				case KeyEvent.VK_LEFT:
					Vel-=0.04f;
					System.out.println("esquerda pressionado");
					break;
				}
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(glcanvas);
		frame.setSize( 1000,800);
		frame.isFocusable();
		frame.setFocusable(true);
		
		frame.setVisible( true );
		final FPSAnimator animator = new FPSAnimator( glcanvas, 300, true);

		animator.start();
	}

}
