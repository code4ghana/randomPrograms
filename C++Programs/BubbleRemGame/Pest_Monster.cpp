#include "IMonster.cpp"
#ifndef IMONSTER_CPP
#define IMONSTER_CPP

class Pest_Monster: public IMonster{
public:
  Pest_Monster(){
    health=2;
    power=2;
  }
  virtual int getHealth(){
    return health;
  }
  virtual int attack(){
    return power;
  }
  virtual void damage(int d){
    health-=d;
  }
  
};
#endif
