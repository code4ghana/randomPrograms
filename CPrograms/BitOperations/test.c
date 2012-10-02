#include <stdio.h>
#include <stdlib.h>
#include "bitOperations.h"

int main(int argc, char** argv){
  printf("%d \n", count_setbits(strtol(argv[1],NULL,0)));
}
