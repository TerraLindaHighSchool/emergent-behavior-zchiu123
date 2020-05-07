import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Phernome here.
 * 
 * @author Zachary Chiu
 * @version (a version number or a date)
 */
public class Phernome extends Actor
{
    private GreenfootImage image;
    private static final int MAX_INTENSITY = 180;
    private int intensity;    
    public Phernome()
    {
        intensity = MAX_INTENSITY;
    }
    /**
     * Act - do whatever the Phernome wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      intensity--;
      if(intensity <= 0)
      {
            getWorld().removeObject(this);
      }
        else
      {
             if ((intensity % 6) == 0)  // prevents updating too often
          { 
                 updateImage();
          }
      }
    }    
    public void updateImage()
    {
       int size = intensity / 3 + 5;
        image = new GreenfootImage(size +1, size + 1);
        image.setColor(new Color(255, 255, 255, intensity / 3));
        image.fillOval(0,0, size, size);
        image.setColor(Color.DARK_GRAY);
        image.fillRect(size/2, size/2, 2, 2);
        setImage(image);
    }   
}
