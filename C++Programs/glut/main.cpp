#ifdef __APPLE__
#include <GLUT/glut.h>
#include <OpenGL/gl.h>
#else
#include <GL/glut.h>
#include <GL/gl.h>
#endif

#define kWindowWidth 400
#define kWindowHeight 300

void InitGL(void);
void DrawGLScene(void);
void ReSizeGLScene(int Width, int Height);

int main(int argc, char** argv)
{
 glutInit(&argc, argv);
 glutInitDisplayMode (GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
 glutInitWindowSize (kWindowWidth, kWindowHeight);
 glutInitWindowPosition (100, 100);
 glutCreateWindow (argv[0]);

 InitGL();

 glutDisplayFunc(DrawGLScene);
 glutReshapeFunc(ReSizeGLScene);

 glutMainLoop();

 return 0;
}

void ReSizeGLScene(int width, int height)
{
 if (height==0)
 {
 height=1;
 }

 glViewport(0, 0, width, height);

 glMatrixMode(GL_PROJECTION);
 glLoadIdentity();
 gluPerspective(45.0f,(GLfloat)width/(GLfloat)height,0.1f,100.0f);

 glMatrixMode(GL_MODELVIEW);
 glLoadIdentity();
}

void InitGL(void)
{
 glShadeModel(GL_SMOOTH);
 glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
 glClearDepth(1.0f);
 glEnable(GL_DEPTH_TEST);
 glDepthFunc(GL_LEQUAL);
 glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
}

void DrawGLScene(void)
{
 glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
 glLoadIdentity();

 glTranslatef(-1.5f, 0.0f, -6.0f);
 glColor3f(1.0, 0.0, 0.0);

 glBegin(GL_TRIANGLES);
 glVertex3f( 0.0f, 1.0f, 0.0f);
 glVertex3f(-1.0f,-1.0f, 0.0f);
 glVertex3f( 1.0f,-1.0f, 0.0f);
 glEnd();

 glTranslatef(1.0, 1.0, 1.0);
 glColor3f(0.0, 1.0, 0.0);

 glBegin(GL_QUADS);
 glVertex3f(-1.0f, 1.0f, 0.0f);
 glVertex3f( 1.0f, 1.0f, 0.0f);
 glVertex3f( 1.0f,-1.0f, 0.0f);
 glVertex3f(-1.0f,-1.0f, 0.0f);
 glEnd();

 glutSwapBuffers();
}
