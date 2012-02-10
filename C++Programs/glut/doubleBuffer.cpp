//Rotating a cube with double buffer to increase smoothness

#include <GL/gl.h>
#include <GL/glut.h>

//angle of rotation
GLfloat angle=0.0;

//prototypes
void display();
void cube();
void reshape(int,int);


int main(int argc,char **argv)
{
  glutInit(&argc,argv);
  //double buffering
  glutInitDisplayMode(GLUT_DOUBLE);
  glutInitWindowSize(500,500);
  glutInitWindowPosition(100,100);
  glutCreateWindow("basic window with double buffering");
  glutDisplayFunc(display);
  glutIdleFunc(display);
  glutReshapeFunc(reshape);
  glutMainLoop();
}

void cube()
{
  //rotate on x-axis
  glRotatef(angle,1.0,0.0,0.0);
  //rotate on y-axis  
  glRotatef(angle,0.0,1.0,0.0);
  //rotate on z-axis
  glRotatef(angle,0.0,0.0,1.0);
  glColor3f(1.0,0.0,0.0);
  glutWireCube(2);
}
void display()
{
  glClearColor(0.0,0.0,0.0,1.0);
  glClear(GL_COLOR_BUFFER_BIT);
  glLoadIdentity();
  gluLookAt(0.0,0.0,5.0,0.0,0.0,0.0,0.0,1.0,0.0);
  cube();
  glutSwapBuffers();
  angle+=.05;

}
void reshape(int w,int h)
{
  glViewport(0,0,(GLsizei)w,(GLsizei)h);
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluPerspective(60,(GLfloat)w/(GLfloat)h,1.0,100.0);
  glMatrixMode(GL_MODELVIEW);
}
