SnowFlake [] a;

void setup()
{
  background(0);
  size(300,300);
  a=new SnowFlake[200];
  for(int i=0; i<a.length;i++)
  {
    a[i]=new SnowFlake();
  }
}
void draw()
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
void mouseDragged()
{
  noStroke();
  fill(255,0,0);
  ellipse(mouseX,mouseY,10,10);
  stroke(0);
}

void keyPressed()
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
  void show()
  {
    fill(255);
    ellipse(x,y,5,5);
  }
  void lookDown()
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
  void erase()
  {
    
      fill(0);
      ellipse(x,y,7,7);  
    
  }
  void move()
  {
    if(isMoving==true)
    {
      y+=1;
    }
  }
  void wrap()
  {
    if(y>295)
    {
      y=0;
      x=(int)(Math.random()*300);
    }
  }
}


