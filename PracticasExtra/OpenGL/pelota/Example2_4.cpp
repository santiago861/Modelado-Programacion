//Example2_4.cpp : A bouncing ball 

//#include <windows.h> //the windows include file, required by all windows applications
#include <GL/glut.h> //the glut file for windows operations
                     // it also includes gl.h and glu.h for the openGL library calls
#include <math.h>

#define PI 3.1415926535898 

double xpos, ypos, ydir, xdir;         // x and y position for house to be drawn
double sx, sy, squash;          // xy scale factors
double rot, rdir;             // rotation 
int SPEED = 50;        // speed of timer call back in msecs
GLfloat T1[16] = {1.,0.,0.,0.,\
                  0.,1.,0.,0.,\
                  0.,0.,1.,0.,\
                  0.,0.,0.,1.};
GLfloat S[16] = {1.,0.,0.,0.,\
                 0.,1.,0.,0.,\
                 0.,0.,1.,0.,\
                 0.,0.,0.,1.};
GLfloat T[16] = {1.,0.,0.,0.,\
                 0., 1., 0., 0.,\
                 0.,0.,1.,0.,\
                 0.,0.,0.,1.};



#define PI 3.1415926535898 
GLint circle_points = 100; 
void MyCircle2f(GLfloat centerx, GLfloat centery, GLfloat radius){
  GLint i;
  GLdouble angle;
  glBegin(GL_POLYGON); 
  for (i = 0; i < circle_points; i++) {    
    angle = 2*PI*i/circle_points; 
    glVertex2f(centerx+radius*cos(angle), centery+radius*sin(angle)); 
  } 
  glEnd();
}

GLfloat RadiusOfBall = 15.;
// Draw the ball, centered at the origin
void draw_ball() {
  glColor3f(0.6,0.3,0.);
  MyCircle2f(0.,0.,RadiusOfBall);
  
}

void Display(void)
{
  // swap the buffers
  glutSwapBuffers(); 

  // clear all pixels with the specified clear color
  glClear(GL_COLOR_BUFFER_BIT);
  // 160 is max X value in our world
  // Define X position of the ball to be at center of window
  xpos = 80.;

  // Shape has hit the ground! Stop moving and start squashing down and then back up 
  if (ypos == RadiusOfBall && ydir == -1) {
    sy = sy * squash;

    if (sy < 0.8)
      // reached maximum squish, now unsquash back up 
      squash = 1.1;
    else if (sy > 1.) {
      // reset squash parameters and bounce ball back upwards
      sy = 1.;
      squash = 0.9;
      ydir = 1;
    }
    sx = 1. / sy;
  }
  // 120 is max Y value in our world
  // set Y position to increment 1.5 times the direction of the bounce
  else {
    ypos = ypos + ydir * 1.5 - (1. - sy) * RadiusOfBall;
    // If ball touches the top, change direction of ball downwards
    if (ypos == 120 - RadiusOfBall)
      ydir = -1;
    // If ball touches the bottom, change direction of ball upwards
    else if (ypos < RadiusOfBall)
      ydir = 1;
  }

  // Reset transformation state 
  glLoadIdentity();
  
  // Apply translation
  glTranslatef(xpos, ypos, 0.);

  // Translate ball back to the center
  glTranslatef(0., -RadiusOfBall, 0.);
  // Scale the ball about its bottom
  glScalef(sx, sy, 1.);
  // Translate ball up so the bottom is at the origin
  glTranslatef(0., RadiusOfBall, 0.);
  // Draw the ball
  draw_ball();
}

void Timer(int value) {
  // Actualiza la posición de la pelota en función de su dirección
  xpos += xdir;
  ypos += ydir;

  // Realiza cualquier otra operación relacionada con la temporización aquí

  // Solicita la redibujación de la ventana
  glutPostRedisplay();

  // Configura la próxima llamada al temporizador
  glutTimerFunc(SPEED, Timer, 0);
}


int main(int argc, char** argv) {
  // Inicializa GLUT y crea la ventana
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
  glutInitWindowSize(800, 600);
  glutCreateWindow("Bouncing Ball Example");

  // Configura las funciones de callback
  glutDisplayFunc(Display);
  glutTimerFunc(SPEED, Timer, 0);

  // Inicializa variables y realiza cualquier configuración adicional

  // Entra en el bucle principal de GLUT
  glutMainLoop();

  return 0;
}
