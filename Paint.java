import java.awt.event.*;
import java.applet.*;
import java.awt.*; 
import java.util.Vector;  
import java.awt.Graphics; 
import java.awt.Button;
import java.awt.Event;
import java.lang.reflect.Field;
import java.awt.Color;


public class Paint extends Applet {
	Button Oval;
	Button Rectangle;
	Button Line;
	Button Red;
	Button Blue;
	Button Green;
	Checkbox Fill;
	Button Clear;
	Button Undo;
	Button Eraser;
	Button FreeHand;


	class Coord{
		int x1,y1,x2,y2,Shape,Colour;
		boolean Solid;
		
		}
		class Remove{
		int x2,y2;
		}
		class Frhand{
		int x1,y1,x2,y2,Colour;
		}
	
	
	public int Shape;
	public int ShapeOval;
	public int ShapeRect;
	public int ShapeLine;
	public int ShapeEras;
	public int ShapeFree;
	public boolean Solid;
	public boolean SolidOval;
	public boolean SolidRect;
	public boolean SolidLine;
	public int Colour;
	public int ColourRed;
	public int ColourBlue;
	public int ColourGreen;
	Color myColor;
	public int x1,x2,y1,y2;
	public int x3,y3;
	public Vector<Coord> GeoShape = new Vector<Coord>();
	public Vector<Remove> Erase = new Vector<Remove>();
	public Vector<Frhand> Free = new Vector<Frhand>();
	
	public void init(){
		Shape =0;
		Solid = false;
		Colour = 0;
		Oval = new Button("Oval");
		Rectangle = new Button("Rectangle");
		Line = new Button("Line");
		Red = new Button("Red");
		Blue = new Button("Blue");
		Green = new Button("Green");
		Fill = new Checkbox("Fill");
		Clear = new Button ("Clear All");
		Undo = new Button ("Undo");
		Eraser = new Button ("Eraser");
		FreeHand = new Button ("Free Hand");
		
		this.addMouseListener(new Click());
		this.addMouseMotionListener (new Drag());
		
		Oval.addActionListener (new OvalListener());
		add(Oval);
		Rectangle.addActionListener (new RectangleListener());
		add(Rectangle);
		Line.addActionListener (new LineListener());
		add(Line);
		Red.addActionListener (new RedListener());
		add(Red);
		Blue.addActionListener (new BlueListener());
		add(Blue);
		Green.addActionListener (new GreenListener());
		add(Green);
		Fill.addItemListener (new FillListener());
		add(Fill);
		Undo.addActionListener (new UndoListener());
		add(Undo);
		Clear.addActionListener (new ClearListener());
		add(Clear);
		Eraser.addActionListener (new EraserListener());
		add(Eraser);
		FreeHand.addActionListener (new FhandListener());
		add(FreeHand);
	}
	
	
	public void paint(Graphics g){
		

	
for(Coord p : GeoShape){
			switch(p.Shape){
	
	case 1:
	if (p.Solid == false){
	g.drawOval(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);
	}
	if(p.Colour == 0){
			g.setColor(Color.black);
			g.drawOval(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);}
		else if(p.Colour == 1){ 
		g.setColor(Color.red);
		g.drawOval(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);}
		else if(p.Colour == 2){ 
		g.setColor(Color.blue);
		g.drawOval(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);}
		else
		{ g.setColor(Color.green);
	g.drawOval(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);}
	if (p.Solid == true){
		g.drawOval(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);
		g.fillOval(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);
	}
	break;
	
	case 2:
	
	if (p.Solid == false){
	g.drawRect(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);}
	
		
	if(p.Colour == 0){
			g.setColor(Color.black);
			g.drawRect(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);
		}
		else if(p.Colour == 1){ 
		g.setColor(Color.red);
		g.drawRect(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);
		}
		else if(p.Colour == 2){ 
		g.setColor(Color.blue);
		g.drawRect(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);
		}
		else if (p.Colour == 3) {
		g.setColor(Color.green);
	g.drawRect(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);
		}
	if (p.Solid == true){
		g.drawRect(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);
		g.fillRect(p.x1,p.y1,p.x2-p.x1,p.y2-p.y1);
	}

	break;
	
	case 3:
	g.drawLine(p.x1,p.y1,p.x2,p.y2);
	if(p.Colour == 0){
			g.setColor(Color.black);
			g.drawLine(p.x1,p.y1,p.x2,p.y2);}
		else if(p.Colour == 1){ 
		g.setColor(Color.red);
		g.drawLine(p.x1,p.y1,p.x2,p.y2);}
		else if(p.Colour == 2){ 
		g.setColor(Color.blue);
		g.drawLine(p.x1,p.y1,p.x2,p.y2);}
		else if (p.Colour == 3) {
	g.setColor(Color.green);
	g.drawLine(p.x1,p.y1,p.x2,p.y2);}
	break;
	
		case 4:
	for (Remove p2 : Erase){
	g.drawRect(p2.x2-5,p2.y2-5,10,10);
	g.setColor(Color.white);
	g.fillRect(p2.x2-5,p2.y2-5,10,10);
}
	break;
	
	case 5:
	for (Frhand p3 : Free){
	g.drawLine(p3.x1,p3.y1,p3.x2,p3.y2);
	if(p3.Colour == 0){
			g.setColor(Color.black);
			g.drawLine(p3.x1,p3.y1,p3.x2,p3.y2);}
		else if(p3.Colour == 1){ 
		g.setColor(Color.red);
		g.drawLine(p3.x1,p3.y1,p3.x2,p3.y2);}
		else if(p3.Colour == 2){ 
		g.setColor(Color.blue);
		g.drawLine(p3.x1,p3.y1,p3.x2,p3.y2);}
		else if (p3.Colour == 3) {
	g.setColor(Color.green);
	g.drawLine(p3.x1,p3.y1,p3.x2,p3.y2);}
}
	break;
}
		}
		
		
	switch(Shape){
	
	case 1:
	if(x2>x1 && y2>y1){
	if (Solid == false){
	g.drawOval(x1,y1,x2-x1,y2-y1);
	}
	if(Colour == 0){
			g.setColor(Color.black);
			g.drawOval(x1,y1,x2-x1,y2-y1);}
		else if(Colour == 1){ 
		g.setColor(Color.red);
		g.drawOval(x1,y1,x2-x1,y2-y1);}
		else if(Colour == 2){ 
		g.setColor(Color.blue);
		g.drawOval(x1,y1,x2-x1,y2-y1);}
		else
		{ g.setColor(Color.green);
	g.drawOval(x1,y1,x2-x1,y2-y1);}
	
	
	if (Solid == true){
		g.drawOval(x1,y1,x2-x1,y2-y1);
		g.fillOval(x1,y1,x2-x1,y2-y1);
	}
	}
	break;
	
	case 2:
	if(x2>x1 && y2>y1){
	if (Solid == false){
	g.drawRect(x1,y1,x2-x1,y2-y1);}
	
		
	if(Colour == 0){
			g.setColor(Color.black);
			g.drawRect(x1,y1,x2-x1,y2-y1);
		}
		else if(Colour == 1){ 
		g.setColor(Color.red);
		g.drawRect(x1,y1,x2-x1,y2-y1);
		}
		else if(Colour == 2){ 
		g.setColor(Color.blue);
		g.drawRect(x1,y1,x2-x1,y2-y1);
		}
		else if (Colour ==3)
		{ g.setColor(Color.green);
	g.drawRect(x1,y1,x2-x1,y2-y1);
		}
	if (Solid == true){
		g.drawRect(x1,y1,x2-x1,y2-y1);
		g.fillRect(x1,y1,x2-x1,y2-y1);
	}
	}
	
	break;
	
	case 3:
	g.drawLine(x1,y1,x2,y2);
	if(Colour == 0){
			g.setColor(Color.black);
			g.drawLine(x1,y1,x2,y2);}
		else if(Colour == 1){ 
		g.setColor(Color.red);
		g.drawLine(x1,y1,x2,y2);}
		else if(Colour == 2){ 
		g.setColor(Color.blue);
		g.drawLine(x1,y1,x2,y2);}
		else
		{ g.setColor(Color.green);
	g.drawLine(x1,y1,x2,y2);}

	break;
	
	case 4:
	g.drawRect(x2-5,y2-5,10,10);
	g.setColor(Color.white);
	g.fillRect(x2-5,y2-5,10,10);
	break;
	
	case 5:
	g.drawLine(x1,y1,x2,y2);
	if(Colour == 0){
			g.setColor(Color.black);
			g.drawLine(x1,y1,x3,y3);}
		else if(Colour == 1){ 
		g.setColor(Color.red);
		g.drawLine(x1,y1,x3,y3);}
		else if(Colour == 2){ 
		g.setColor(Color.blue);
		g.drawLine(x1,y1,x3,y3);}
		else
		{ g.setColor(Color.green);
	g.drawLine(x1,y1,x3,y3);}
	break;
}
}


	class Click implements MouseListener{
			public void mousePressed (MouseEvent e){
				//int x1;
				//int y1;
				//int x2;
				//int y2;
				x1 = e.getX();
				y1 = e.getY();	
				if(Shape ==4){
				x2 = e.getX();
				y2 = e.getY();	}
				//if (Shape ==5){
					//x1=x2;
				//y1=y2;}

				//repaint();
			}
			public void mouseClicked (MouseEvent e){
	
			}

			public void mouseReleased  (MouseEvent e){

			Coord points = new Coord();
						points.x1 = x1;
						points.y1 = y1;
						points.x2 = x2;
						points.y2 = y2;
						points.Shape = Shape;
						points.Colour = Colour;
						points.Solid = Solid;
						GeoShape.add(points);
						//repaint();
            
			}
			public void mouseEntered (MouseEvent e){}
			public void mouseExited (MouseEvent e){}
		}

	class Drag implements MouseMotionListener{
			public void mouseDragged (MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(Shape ==4){
						Remove poi = new Remove();
						poi.x2 = x2;
						poi.y2 = y2;
						Erase.add(poi);
						//repaint();
						}
						else if(Shape ==5){
							for (Frhand p3 : Free)
							x3 = e.getX();
							y3 = e.getY();
						Frhand poi2 = new Frhand();
						poi2.x1 = x2;
						poi2.y1 = y2;
						poi2.x2 = x3;
						poi2.y2 = y3;
						poi2.Colour = Colour;
						Free.add(poi2);
						}
							
				repaint();
			}
	
			public void mouseMoved (MouseEvent e){
			}
	}

	  class OvalListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  Shape = 1;
	  if(ShapeOval == 0){
		  ShapeOval = 1;
		  ShapeRect = 0;
		  ShapeLine = 0;
		  ShapeEras = 0;
	  }
	  else{
	  ShapeOval = 0;}
	  
	
						
		  
	  //repaint();

  }
  }	
  
  	  class RectangleListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  Shape = 2;
	  	  if(ShapeRect == 0){
		  ShapeOval = 0;
		  ShapeFree =0;
		  ShapeEras =0;
		  ShapeRect = 1;
		  ShapeLine = 0;
	  }
	  else{
	  ShapeRect = 0;}
	   
						
	  //repaint();

  }
  }
  
    	  class LineListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  Shape = 3;
	  	  if(ShapeLine == 0){
		  ShapeOval = 0;
		  ShapeRect = 0;
		  ShapeEras =0;
		  ShapeFree =0;
		  ShapeLine = 1;
	  }
	  else{
	  ShapeLine = 0;}
	  
						
						
	  //repaint();

  }
  }
  
        class EraserListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  Shape = 4;
	   if(ShapeEras == 0){
		  ShapeOval = 0;
		  ShapeRect = 0;
		  ShapeLine = 0;
		  ShapeFree =0;
		  ShapeEras =1;
	  }
	  else{
	  ShapeEras = 0;}
 

  
}
  }
  
          class FhandListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  Shape = 5;
	   if(ShapeFree == 0){
		  ShapeOval = 0;
		  ShapeRect = 0;
		  ShapeLine = 0;
		  ShapeEras =0;
		  ShapeFree =1;
	  }
	  else{
	  ShapeFree = 0;}
 

  
}
  }
  
    	  class RedListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  Colour =1;
	  if(ColourRed == 0){
		  ColourBlue = 0;
		  ColourGreen = 0;
		  ColourRed = 1;
	  }
	  else{
	  ColourRed = 0;}
	   
						
	  //repaint();

  }
  }
  
      	  class BlueListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  Colour =2;
	  	  if(ColourBlue == 0){
		  ColourGreen = 0;
		  ColourRed = 0;
		  ColourBlue = 1;
	  }
	  else{
	  ColourBlue = 0;}
	  	   
	  //repaint();

  }
  }
  
      	  class GreenListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  Colour = 3;
	  	  if(ColourGreen == 0){
		  ColourBlue = 0;
		  ColourRed = 0;
		  ColourGreen = 1;
	  }
	  else{
	  ColourGreen = 0;}
	  	 
	  //repaint();

  }
  }

  
      	  class FillListener implements ItemListener{
  public void itemStateChanged(ItemEvent e){
	 if(Solid == false){
	  Solid = true;
	  }
	  else{
	  Solid = false;}
	  //repaint();

  }
  }
  
    class ClearListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  	Shape =0;
		Solid = false;
		Colour = 0;
	  GeoShape.clear();
	  Erase.clear();
	  repaint();

  
}
  }
  
  
    class UndoListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
	  	Shape =0;
		Solid = false;
		Colour = 0;
		GeoShape.remove(GeoShape.lastElement());
		
		//Erase.remove(Erase.lastElement());
 repaint();

  
}
  }
  

}