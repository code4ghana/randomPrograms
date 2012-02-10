//click x to exit out of the program
#include "SDL/SDL.h"
#include "SDL/SDL_image.h"
#include <string>
#include <iostream>
using namespace std;


//screen attributes
const int SCREEN_WIDTH=640;
const int SCREEN_HEIGHT =480;
const int SCREEN_BPP=32;

//The surfaces
SDL_Surface *image=NULL;
SDL_Surface *screen=NULL;

//The event structure that will be used
SDL_Event event;

//surface loading and blitting
SDL_Surface *load_image(std::string filename)
{
  //The image that's loaded
  SDL_Surface* loadedImage =NULL;
  //The optimized image that will be used
  SDL_Surface* optimizedImage=NULL;
  
  //Load the image
  loadedImage=IMG_Load(filename.c_str());
  
  //if the image is loaded
  if(loadedImage !=NULL)
    {
      //create an optimized image
      optimizedImage= SDL_DisplayFormat(loadedImage);
      if(optimizedImage==NULL)
	{
	  cout<<"hei\n";
	}
      else 
	{
	  printf("success loading image\n");
	}
      //Free the old image
      SDL_FreeSurface(loadedImage);
    }
  //Return the optimized image
  return optimizedImage;
}

void apply_surface(int x,int y,SDL_Surface* source, SDL_Surface* destination)
{
  printf("entering apply_surface...\n");
  //Temporary rectangle to hold offsets
  SDL_Rect offset;

  //Get the offsets
  offset.x =x;
  offset.y =y;

  //Bit the surface
  SDL_BlitSurface(source, NULL,destination,&offset);
}

bool init()
{
  //Initialize all SDL subsystems
  if(SDL_Init(SDL_INIT_EVERYTHING)==-1)
    {
      return false;
    }
  //set up the screen
  screen = SDL_SetVideoMode(SCREEN_WIDTH, SCREEN_HEIGHT,SCREEN_BPP,SDL_SWSURFACE);

  //return false in cas the screen did not set up correctly
  if(screen==NULL)
    {
      return false;
    }
  //set the window caption
  SDL_WM_SetCaption("Event test",NULL);

  //If everything initialized fine
  return true;
}

bool load_files()
{
  //Load the image
  image=load_image("x.png");

  if(image==NULL)
    {
      cout<<"couldn't load the image;"<<endl;
      return false;
    }

  cout<<"loaded the image;"<<endl;
  
  return true;
}
void clean_up()
{
  //Free the image
  SDL_FreeSurface(image);

  //Quit SDL
  SDL_Quit();
}

int main(int argc,char* args[])
{
  //Make sure the program waits for a quit
  bool quit=false;

  //Initialize
  if(init()==false)
    {
      return 1;
    }
  //Load the files
  if(load_files()==false)
    {
      //std::cout<<"couldn't load files"<<std::endl;
      return 1;
    }

  // Display the image onscreen...
  apply_surface( 0, 0, image, screen );

  //Update the screen LULZ
  if( SDL_Flip( screen ) == -1 )
    {
      return 1;
    }


  while(quit==false)
    {
      //while there's an event to handle
      while(SDL_PollEvent(&event))
	{
	  //If the user has xed out of the window
	  if(event.type==SDL_QUIT)
	    {
	      //quit the program
	      quit=true;
	    }
	}
    }
  //Free the surface and quit SDL
  clean_up();
  return 0;
}


