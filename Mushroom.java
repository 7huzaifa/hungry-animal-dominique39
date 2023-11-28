import greenfoot.*;
/**
 * Write a description of class Mushroom here.
 * 
 * @author Dominique
 * @version v1.0
 */
public class Mushroom extends Falling_Objs
{
    private boolean mushroomBoost = false;
    private int mushroomBoostTime = 0;

    public void act()
    {
        if(MyWorld.running = true){
            eaten();
            boostTimeCountdown();
            fall();
        }
    }

    void fall(){
        setLocation(getX(),getY()+4);
        if(getY() >= 795){
            World world = (MyWorld) getWorld();
            world.removeObject(this);
        }
    }

    private void eaten(){
        if(isTouching(Elephant.class)){
            mushroomBoost = true;
            mushroomBoostTime = 1000*15;
        }
    }

    private void boostTimeCountdown() {
        if(mushroomBoost == true){
            mushroomBoostTime--;
            MyWorld world = (MyWorld) getWorld();
            world.attractObjs();
            if(mushroomBoostTime <= 0){
                mushroomBoost = false;
            }
        }
    }
}
