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

public class Cubo implements GLEventListener {
	private GLU glu = new GLU();
	   private float rtri = 0.0f; 
	 public float h = 1 ;
		
	   @Override
	   public void display( GLAutoDrawable drawable ) {
		      final GL2 gl = drawable.getGL().getGL2();
		   
		      gl.glMatrixMode( GL2.GL_PROJECTION );
		      gl.glLoadIdentity();
				
		      glu.gluPerspective( 45.0f, h, 1.0, 40.0 );
		      glu.gluLookAt(Math.cos(rtri) * 6, 0, Math.sin(rtri) * 6, 0, 0, 0, 0, 1, 0);
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
	      

	      
//	      gl.glBegin (GL2.GL_LINE_STRIP);
//	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
//	      //frente
//	      gl.glVertex3f(1.0f, -1.0f, 1.0f );
//	      gl.glVertex3f( -1.0f, -1.0f, 1.0f );
//	      gl.glVertex3f( -1.0f, 1.0f, 1.0f );
//	      gl.glVertex3f( 1.0f, 1.0f, 1.0f );
//	      gl.glVertex3f( 1.0f, -1.0f, 1.0f );
//	      //esquerda
//	      
//	      gl.glEnd();
	      
	      gl.glBegin( GL2.GL_QUADS);
	      

	      //frente
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); 
			
	      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
	      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); 
			
	      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); 
	      	
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( 1.0f, -1.0f, 1.0f );
	      	
	      
	      
	      //trás
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); 
			
	      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
	      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); 
			
	      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); 
	      	
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( 1.0f, -1.0f, -1.0f );
	      	
	      
	      //cima
	      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
	      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Left
			
	      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Right)
	      	
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top
			
	      
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top
	      	
	    //baixo
	      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
	      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Left
			
	      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Right)
	      	
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top
			
	      
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top
	      	
	      
	    //esquerda
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); 
	      
	      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	      gl.glVertex3f( -1.0f, -1.0f, -1.0f );
	      
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); 
					
	      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
	      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); 
		
	    //direita
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); 
	      
	      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	      gl.glVertex3f( 1.0f, -1.0f, -1.0f );
	      
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); 
					
	      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
	      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); 
		
	      
	      
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
	      rtri += 0.001f;
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
		    Cubo triangledepthtest = new Cubo();
				
		    glcanvas.addGLEventListener( triangledepthtest );
		    glcanvas.setSize( 1200, 400 );
				
		    JFrame frame = new JFrame ( "CUBO" );
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.getContentPane().add(glcanvas);
		    frame.setSize( frame.getContentPane().getPreferredSize() );
		    frame.setVisible( true );
	      final FPSAnimator animator = new FPSAnimator( glcanvas, 300, true);
			
	      animator.start();
	   }
	
}
