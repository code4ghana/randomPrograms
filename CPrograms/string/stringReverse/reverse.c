//Jeff Kusi
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char* reverse(char* string);
int main(int argc,char** argv)
{
  if(argc<2)
    {
      printf("Please supply the string to reverse\n");
      exit(EXIT_SUCCESS);
    }
  char* string=argv[1];
  printf("The given string is: %s\n",string);
  printf("%s\n",reverse(string));
}

char* reverse(char* string)
{
  int i=0;
  // ptinf("%i\n",strlen(string));
  char* reversed=malloc(sizeof(string));
  int j=0;
  for(i=strlen(string)-1;i>-1;i--)
    {
      reversed[j++]=string[i];
      //printf("%c",string[i]);
    }
  //  printf("\n");
  return reversed;
}
