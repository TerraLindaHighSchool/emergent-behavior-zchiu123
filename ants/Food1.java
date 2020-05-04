

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food1 extends Actor
{
    private GreenfootImage image;
    private int crumbs = 100;
    private final int SIZE = 30;
    
    public Food1()
    {
        image = new GreenfootImage(SIZE, SIZE);
        updateImage();
    }  
    private void updateImage()
    {
        Random random = new Random();
        for (int i = 0; i < crumbs; i++)
        {
           int stDev = SIZE / 6;
           int x = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
           int y = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
            
           // keep crumbs in image
           if(x < 0) 
           {
           x = 0;
           }
           if(x >= SIZE) 
           {
           x = SIZE - 1;
           }
           if(y < 0) 
           {
               y = 0;
           }
           if(y >= SIZE) 
           {
               y = SIZE - 1;
            }
     
            Color color = new Color(100, 120, 45);  // pick the color you want by replacing r, g, b with values.
            image.setColorAt(x, y, color);
        }
        setImage(image);
    }
    public void removeCrumb()
    {   
  
    if (crumbs > 0)
    {
        image.clear();
        updateImage();
        crumbs--;
        
    }   
    if (crumbs == 0)
    {
        getWorld().removeObject(this);
        image.clear();
    }
} 
}
