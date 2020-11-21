import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	
	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x=110;
	int y=150;
	boolean flag = true;
	Image img,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo16.png");
			img4=Image.createImage("/sayo02.png");
			img5=Image.createImage("/sayo22.png");
			img6=Image.createImage("/sayo24.png");
			img7=Image.createImage("/sayo04.png");
			img8=Image.createImage("/sayo26.png");
			img9=Image.createImage("/sayo06.png");
			img10=Image.createImage("/sayo20.png");
			img11=Image.createImage("/sayo00.png");
			currentImg=img;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
			
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			currentImg=img1;
			if(flag){
			currentImg=img4;
			flag=false;
			}
			else{
				currentImg=img5;
				flag=true;
			}
		
			x-=5;
			
			
			System.out.println("向左转");
			repaint();
		}

		if(action==UP){
			currentImg=img2;
			if(flag){
			currentImg=img6;
			flag=false;
			}
			else{
				currentImg=img7;
				flag=true;
			}
			y-=5;
			System.out.println("向上转");
			repaint();
		}

		if(action==RIGHT){
			currentImg=img3;
			if(flag){
			currentImg=img8;
			flag=false;
			}
			else{
				currentImg=img9;
				flag=true;
			}
			x+=5;
			System.out.println("向右转");
			repaint();
		}

		if(action==DOWN){
			currentImg=img;
			if(flag){
			currentImg=img10;
			flag=false;
		}
			else{
				currentImg=img11;
				flag=true;
			}
			y+=5;
			System.out.println("向下转");
			repaint();
		}
	}
}