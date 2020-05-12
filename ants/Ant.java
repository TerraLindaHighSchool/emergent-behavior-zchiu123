import greenfoot.*;

/**
 * An ant that collects food.
 * 
 * @author Zachary Chiu
 * @version 0.1
 **/
public class Ant extends Creature
{
    private boolean carryingFood;
    private GreenfootImage image1;
    private GreenfootImage image2;
    private final int MAX_PH_AVAILABLE = 16;
    private final int TIME_FOLLOWING_TRAIL = 30;
    private int phAvailable;
    private int followTrailTimeRemaining;
    /** Create an ant with a given home hill. The initial speed is zero (not moving).
     **/
    public Ant(AntHill home)
    {
        setHomeHill(home);
        image1 = getImage();
        image2 = new GreenfootImage("ant-with-food.gif");
    }

    /**
     * Do what an ant's gotta do.
     */
    public void act()
    {
        status();
    }

    private void checkForFood()
    {
        Food1 food = (Food1) getOneIntersectingObject(Food1.class);
        if (food != null) 
        {
            food.removeCrumb();
            setImage(image2);
            carryingFood = true;
        }
    } 

     private boolean atHome()
    {
         if (getHomeHill() != null) {
            return (Math.abs(getX() - getHomeHill().getX()) < 4) && 
                   (Math.abs(getY() - getHomeHill().getY()) < 4);
         }
         else {
            return false;
        }
    }
    private void searchForFood()
    {
        if(followTrailTimeRemaining == 0)
        {
            if(smellsPheromone())
            {
                walkTowardsPheromoneCenter();
            }
            randomWalk();
        }
        else
        {
            followTrailTimeRemaining--;
            walkAwayFromHome();
        }
        randomWalk();
        checkForFood();
    }
    private void status()
    {
        if(carryingFood == true)
        {
            walkTowardsHome();
            handlePheromoneDrop();
            if(atHome())
            {
                setImage(image1);
                carryingFood = false;
                getHomeHill().countFood();
            }
        }
        else
        {
            searchForFood();
        }
    }
    private void handlePheromoneDrop()
    {
        if(phAvailable == MAX_PH_AVAILABLE)
        {
            Pheromone pheromone = new Pheromone();
            getWorld().addObject(pheromone,getX(),getY());
            phAvailable = 0;
        }
        else
        {
            phAvailable++;
        }
    }
     private boolean smellsPheromone()
    { 
        if(isTouching(Pheromone.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private void walkTowardsPheromoneCenter()
    {  
        Actor ph = getOneIntersectingObject(Pheromone.class);
        if(ph != null)
        {
            headTowards(ph);
        }
        if(getX() == ph.getX() && getY() == ph.getY())
        {
            followTrailTimeRemaining = TIME_FOLLOWING_TRAIL;
        }
    }

}