import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] a;

public void setup()
{
  background(0);
  size(300,300);
  a=new SnowFlake[200];
  for(int i=0; i<a.length;i++)
  {
    a[i]=new SnowFlake();
  }
}
public void draw()
{
  
  for(int i=0; i<a.length; i++)
  {
    a[i].erase();
    
    a[i].lookDown();
    a[i].wrap();
    a[i].move();
    
    a[i].show();
  }

}
public void mouseDragged()
{
  noStroke();
  fill(255,0,0);
  ellipse(mouseX,mouseY,10,10);
  stroke(0);
}

public void keyPressed()
{
  if(key==ENTER)
  {
    background(0);
  }
}

class SnowFlake
{
  int x, y;
  boolean isMoving;
  SnowFlake()
  {
    x=(int)(Math.random()*300);
    y=(int)(Math.random()*300);
    isMoving=true;
  }
  public void show()
  {
    fill(255);
    ellipse(x,y,5,5);
  }
  public void lookDown()
  {
    if(y>0 && y<300 && get(x,y+4)!=color(0,0,0))
    {
      isMoving=false;
    }
    else
    {
      isMoving=true;
    }
  }
  public void erase()
  {
    
      fill(0);
      ellipse(x,y,7,7);  
    
  }
  public void move()
  {
    if(isMoving==true)
    {
      y+=1;
    }
  }
  public void wrap()
  {
    if(y>295)
    {
      y=0;
      x=(int)(Math.random()*300);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
