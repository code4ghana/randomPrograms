#include "bitOperations.h"

int divide(int a,int b)
{
  if(b==0)
    {
      return -1;
    }
  int tmp=0;
  while(b>1)
    {
      tmp+=a<<1;
      b-=2;
    }
  if(b==1)
    {
      
    }
}
int multiply(int a,int b)
{
  
  if(a==1)
    {
      return b;
    }
  int tmp=0;
  while(b>1)
    {
      //keep multiple a by two until 
      tmp+=a>>1;
      b-=2;
    }
  if(b==1)
    {
      tmp+=a;
    }
  return tmp;
}
