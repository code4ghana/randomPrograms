//Jeff Kusi
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int getDigits(int whole,int index,int count);
int main(int argc, char** argv)
{
  if(argc<4)
    {
     printf("Please provide 3 arguments\n");
    }

 
 printf("%i\n",getDigits(atoi(argv[1]),atoi(argv[2]),atoi(argv[3])));
}

int getDigits(int whole,int index,int count){
  //check that the number is long enough
  char* wholeStr=(char*)whole;
  wholeStr=*(&wholeStr)+index;
  char retval[count];
  strncpy(retval,*(&wholeStr)+index,count);
  //  memcpy(retval,(&wholeStr)+index,count*sizeof(int));
  return atoi(retval);
}
