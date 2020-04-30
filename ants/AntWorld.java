import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * The world where ants live.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class AntWorld extends World
{
    public static final int SIZE = 640;

    /**
     * Create a new world. It will be initialised with a few ant hills
     * and food sources
     */
    public AntWorld()
    {
        super(SIZE, SIZE, 1);
        setPaintOrder(Ant.class, AntHill.class);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        AntHill antHill = new AntHill();
        addObject(antHill,230,236);
        Food1 food1 = new Food1();
        addObject(food1,336,282);
        Food1 food12 = new Food1();
        addObject(food12,249,429);
        Food1 food13 = new Food1();
        addObject(food13,430,464);
        Food1 food14 = new Food1();
        addObject(food14,77,435);
        AntHill antHill2 = new AntHill(40);
        addObject(antHill2,525,533);
    }
}
