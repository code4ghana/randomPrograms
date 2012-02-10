package model;
import mediators.IMediator;


public interface Observable {
void attach(IMediator mediator);
void detach(IMediator mediator);
void notifyMediators(Object event,Object option);
}
