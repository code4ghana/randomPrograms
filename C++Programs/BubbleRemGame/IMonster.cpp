#ifndef IMonster_CPP_
#define IMonster_CPP_
class IMonster{
 public:
  int health,power;
  virtual ~IMonster(){};
  virtual int getHealth(){};
  virtual int attack(){};
  virtual void damage(int i){};
  
};
#endif


