#include <iostream>
#include <string>
#include <sstream>
#include "Pest_Monster.cpp"
#include "Ant_Monster.cpp"
#include "Rem.cpp"
using namespace std;

int main(){
  Rem *rem=new Rem(Rem:: FLYING);
  Pest_Monster *pest1=new Pest_Monster();
  Ant_Monster *ant1=new Ant_Monster();
  cout<<"rem power="<<rem->attack()<<endl;
  cout<<"pest1 power="<<pest1->attack()<<endl;
  cout<<"ant1 power="<<ant1->attack()<<endl;
  while(pest1->getHealth()>0){
    cout<<"pest1 hp before attack="<<pest1->getHealth()<<endl;
    cout<<"rem attacks with power"<<rem->attack()<<endl;
    pest1->damage(rem->attack());
    cout<<"pest1 hp after attack="<<pest1->getHealth()<<endl;
  }
  cout<<"defeated pest1"<<endl;
  while(ant1->getHealth()>0){
    cout<<"antt1 hp before attack="<<ant1->getHealth()<<endl;
    cout<<"rem attacks with power"<<rem->attack()<<endl;
    ant1->damage(rem->attack());
    cout<<"ant1 hp after attack="<<ant1->getHealth()<<endl;
  }
  cout<<"defeated ant1"<<endl; 
  return (0);
}
