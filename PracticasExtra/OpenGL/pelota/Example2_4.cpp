/**
 * Practica Extra
 * 
 * Clase Main 
 * 
 * @author Santiago Iván Reyes Medina - 320308598
 * @author Carlos Yañez Diaz - 320032343
 * @version Versión 1
 */

#include <GL/glut.h>
#include <math.h>

// Number Pi
#define PI 3.1415926535898

double xpos, ypos, ydir, xdir;
double sx, sy, squash;
int SPEED = 50;
GLfloat T1[16] = {1., 0., 0., 0., 0., 1., 0., 0., 0., 0., 1., 0., 0., 0., 0., 1.};
GLfloat S[16] = {1., 0., 0., 0., 0., 1., 0., 0., 0., 0., 1., 0., 0., 0., 0., 1.};
GLfloat T[16] = {1., 0., 0., 0., 0., 1., 0., 0., 0., 0., 1., 0., 0., 0., 0., 1.};

GLint circle_points = 100;
GLfloat RadiusOfBall = 15.;

void MyCircle2f(GLfloat centerx, GLfloat centery, GLfloat radius) {
  GLint i;
  GLdouble angle;
  glBegin(GL_POLYGON);
  for (i = 0; i < circle_points; i++) {
    angle = 2 * PI * i / circle_points;
    glVertex2f(centerx + radius * cos(angle), centery + radius * sin(angle));
  }
  glEnd();
}

// Draw the ball, centered at the origin
void draw_ball() {
  glColor3f(0.7, 0.2, 9.);
  MyCircle2f(0., 0., RadiusOfBall);
}

void Display(void) {
  // Clear the color buffer
  glClear(GL_COLOR_BUFFER_BIT);

  // Set up the projection and model-view matrices
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  glOrtho(0, 800, 0, 600, -1, 1);

  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();

  // Draw the ball
  glTranslatef(xpos, ypos, 0.);
  draw_ball();

  // Swap the buffers
  glutSwapBuffers();
}

void Timer(int value) {
  xpos += xdir;
  ypos += ydir;

  // Handle bouncing logic
  if (ypos <= RadiusOfBall || ypos >= 600 - RadiusOfBall) {
    ydir = -ydir;
  }

  if (xpos <= RadiusOfBall || xpos >= 800 - RadiusOfBall) {
    xdir = -xdir;
  }

  // Redisplay the scene
  glutPostRedisplay();

  // Set the next timer callback
  glutTimerFunc(SPEED, Timer, 0);
}

int main(int argc, char** argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
  glutInitWindowSize(800, 600);
  glutCreateWindow("Bouncing Ball Example");

  // Set the initial position and direction of the ball
  xpos = 400.;
  ypos = 300.;
  xdir = 6.0;
  ydir = 6.0;

  // Initialize the scaling and squash factors
  sx = 1.0;
  sy = 1.0;
  squash = 0.9;

  // Set up the orthographic projection
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  glOrtho(0, 500, 0, 400, -1, 1);

  // Set up the model-view matrix
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();

  // Configure the callback functions
  glutDisplayFunc(Display);
  glutTimerFunc(SPEED, Timer, 0);

  // Start the main loop
  glutMainLoop();

  return 0;
}
