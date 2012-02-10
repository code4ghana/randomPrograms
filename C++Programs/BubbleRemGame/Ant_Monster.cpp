#include <string>
#include "IMonster.cpp"
using namespace std;

#ifndef ANT_CPP_
#define ANT_CPP_

class Ant_Monster:public IMonster{
public:
  
  Ant_Monster(){
    health=1;
    power=1;
  }
  virtual int getHealth(){
    return health;
  }
  virtual int attack(){
    return power;
  }
  virtual void damage(int d){
    health=health-d;
  }
  
};
#endif
