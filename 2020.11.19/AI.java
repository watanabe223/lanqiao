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
	int leftFlag,rightFlag,upFlag,downFlag;

    Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];

	Image currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			
			for(int i=0;i<3;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}

			for(int i=0;i<3;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}

			for(int i=0;i<3;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}

			for(int i=0;i<3;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			

			
			
			currentImg=heroDownImg[1];
			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;

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
			
			if(leftFlag==1){
			currentImg=heroLeftImg[0];
				leftFlag++;
			}
			else{
				currentImg=heroLeftImg[2];
				leftFlag=1;
			}
		
			x-=5;
			
		}

		if(action==UP){
		
			if(upFlag==1){
			currentImg=heroUpImg[0];
				upFlag++;
			}
			else{
				currentImg=heroUpImg[2];
				upFlag=1;
			}
			y-=5;
		
		}

		if(action==RIGHT){
			
			if(rightFlag==1){
			currentImg=heroRightImg[0];
				rightFlag++;
			}
			else{
				currentImg=heroRightImg[2];
				rightFlag=1;
			}
			x+=5;
			
		}

		if(action==DOWN){
		
			if(downFlag==1){
			currentImg=heroDownImg[0];
				downFlag++;
			}
			else{
				currentImg=heroDownImg[2];
				downFlag=1;
			}
			y+=5;
			
			
		}
		repaint();
	}
}