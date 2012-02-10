#include <sstream>
using namespace std;

class Rem
{
public: enum states{
    STANDING, MOVING, JUMPING, FLYING
  }state;
  
  Rem(states s){
    gumpack=100;
    health=10;
    weaponDamage=1;
    state=s;
  }
private:
  int gumpack;
  int health;
  int weaponDamage;
  
public:
  
 
  void setState(states s){
    state=s;
  }
  int getState(){
    return state;
  }
  int getHealth(){
    return health;
  }
  
   int getPacks(){
     return gumpack;
   }
  void addPacks(int p){
    gumpack++;
  }
  void setHealth(int val){
    health=val;
  }
  
  int attack(){
    return weaponDamage;
  }
};


  
