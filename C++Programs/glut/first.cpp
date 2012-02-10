//first glut/glew program from switfless

//standard headers
#include <stdio.h>
#include <string.h>
//drawing headers
#include <GL/glew.h>
#include <GL/glut.h>


//prototypes
void display(void);
void reshape(int width,int height);
void keyPressed(unsigned char key, int x, int y);
void keyUp(unsigned char key,int x, int y);
void keyOperations(void);
void keySpecial(int key, int x, int y);
void keySpecialUp(int key, int x, int y);
void keySpecialOperations(void);
void renderPrimitive(void);
void glTranslate(void);
void drawTriangleStrips(void);
void drawPoints(void);
void drawLineLoop(void);
void drawSquare(void);
void init(void);

//globals
bool* keyStates =new bool[256];
bool* keySpecialStates= new bool[256];
int prev=0;
bool movingUp=false;
float yLocation = 0.0f;
float rotationAngle =0.0f;
int main(int argc,char** argv)
{
  //initialize glut
  glutInit(&argc,argv);
  //set up single buffer window
  glutInitDisplayMode(GLUT_SINGLE);
  //window width and height
  glutInitWindowSize(500,500);
  //window position
  glutInitWindowPosition(100,100);
  glutCreateWindow("First OpenGL window");
  //display and manipulation functions
  init();
  glutMainLoop();
}
void init(void)
{
  int size=256;
  while(size--)
    {
      keyStates[size]=false;
    }
  
  
 
  glutDisplayFunc(display);
  glutIdleFunc(display);
  glutReshapeFunc(reshape);
  // glutKeyboardFunc(keyPressed);
  //glutKeyboardUpFunc(keyUp);
  //glutSpecialFunc(keySpecial);
  // glutSpecialFunc(keySpecialUp);
}

//drawing code
void display(void)
{
  //be ready for keys
  keyOperations();
  //set background to red
  glClearColor(1.f,0.f,0.f,1.f);
  //clear color buffer
  glClear (GL_COLOR_BUFFER_BIT);
  //loading matrix resets drawing locations 
  glLoadIdentity();
  //send everything back by 5 units so that it is not culled
  glTranslatef(0.0f,0.0f,-5.0f);
  //render the primitive
  //renderPrimitive();
  glTranslatef(0.0f,yLocation,0.0f);
  glRotatef(rotationAngle,1.0f,1.0f,0.0f);
  glutWireCube(1.0f);
  //draw all by flushing
  glFlush();
  
  //rotation stuff
  if(movingUp)//are we moving up?
    {
      yLocation-=0.005f;
    }
  else//if not we must be moving down
    {
      yLocation +=0.005f;
    }
  if(yLocation<-2.5f)//if reached top, start moving down
    {
      movingUp=false;
    }
  else if (yLocation>2.5f)//if reached buttom, start going up
    {
      movingUp=true;
    }
  //increase rotation value
  rotationAngle+=0.005f;
  if(rotationAngle>360.0f)
    {
      rotationAngle-=360.0f;
    }

}
void reshape(int width,int height)
{
 
  //set viewport to instantaneous size of the window
  glViewport(0,0, (GLsizei)width, (GLsizei)height);
  //swith to the projection matrix
  glMatrixMode(GL_PROJECTION);
  //reset projection matrix
  glLoadIdentity();
  //set angular field of view and planes
  // (angle,aspect ratio,far place,near plane,far plane)
  gluPerspective(60,(GLfloat)width/(GLfloat)height,1.0,100.0);
  //go back to the original view
  glMatrixMode(GL_MODELVIEW);
}

void keyPressed(unsigned char key, int x, int y)
{
 
  keyStates[key]=true;
}
void keyUp(unsigned char key,int x, int y)
{
  //keyStates[key]=false;
}
void keyOperations(void)
{
  if(keyStates['a'])
    {
    }
}
void keySpecial(int key, int x, int y)
{
}
void keySpecialUp(int key, int x, int y)
{
}
void keySpecialOperations(void)
{
  if(keySpecialStates[GLUT_KEY_LEFT])
    {
    }
}
void renderPrimitive(void)
{
  //you have to tell openGL when you are about to draw/finish


  drawPoints();
}


//2D MODELS!
void drawSquare(void)
{
  
  //color the shape
  glColor3f(0.0f, 0.0f,1.0f);
  glBegin(GL_QUADS);
  //bottom left corner(x,y,z)
  glVertex3f(-1.0f,-1.0f,0.0f);
  //the top left corner
  glVertex3f(-1.0f,1.0f,0.0f);
  //the top right corner
  glVertex3f(1.0f,1.0f,0.0f);
  //the bottom right corner
  glVertex3f(1.0f,-1.0f,0.0f);
  glEnd();
}
void drawPoints(void)
{
  
  //color the shape
  glColor3f(0.0f, 0.0f,1.0f);
  glPointSize(20.0f);  
  glBegin(GL_POINTS);
  // The bottom left corner  
  glVertex3f(-1.0f, -1.0f, 0.0f);
  // The top left corner  
  glVertex3f(-1.0f, 1.0f, 0.0f);
  // The top right corner  
  glVertex3f(1.0f, 1.0f, 0.0f);
  // The bottom right corner 
  glVertex3f(1.0f, -1.0f, 0.0f);
  glEnd();
}

void drawLineLoop(void)
{
  
  //color the shape
  glColor3f(0.0f, 0.0f,1.0f);
  //start drawing a line pirmitive
  glBegin(GL_LINE_LOOP);
  // The bottom left corner  
  glVertex3f(-1.0f, -1.0f, 0.0f);
  // The top left corner  
  glVertex3f(-1.0f, 1.0f, 0.0f);
  // The top right corner  
  glVertex3f(1.0f, 1.0f, 0.0f);
  // The bottom right corne
  glVertex3f(1.0f, -1.0f, 0.0f);
  glEnd();
}
void drawTriangleStrips(void)
{
  
  //color the shape
  glColor3f(0.0f, 0.0f,1.0f);
  // The first triangle
  glBegin(GL_TRIANGLE_STRIP);
  // The bottom left corner
  glVertex3f(-1.0f, -1.0f, 0.0f);
  // The top left corner
  glVertex3f(-1.0f, 1.0f, 0.0f);
  // The top right corner  
  glVertex3f(1.0f, 1.0f, 0.0f);
  // The end of the second triangle
  // The bottom right corner  
  glVertex3f(1.0f, -1.0f, 0.0f);
  // The bottom left corner  
  glVertex3f(-1.0f, -1.0f, 0.0f);
  glEnd();
}


//3D Models

