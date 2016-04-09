

package beamgame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import java.awt.event.*;
import java.security.SecureRandom;
//import java.util.Random;


public class BeamGame extends Application {
    final int BALL_RADIUS=10;
    final int GAMEPANE_WIDTH=600, GAMEPANE_HEIGHT=700;
    final int BOTTOM_LINE_Y=680-2;
    int slide_x, slide_y;
    int i;
    GamePane gp1=new GamePane();
    int isbusy;
   
    int scode;
    //Circle ball1=new Circle();
    int newball(){
        
        if(isbusy==1){
            return 0;
        }
        
        gp1.NewBall();
        slide_x=300;
        slide_y=0;
        
        return 1;
    }
    
    
    @Override
    public void start(Stage primaryStage) {       
                
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("BeanGame!");
            }
        });
        
        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
        
        //gp1=new GamePane();        
        Scene scene1 = new Scene(gp1, GAMEPANE_WIDTH, GAMEPANE_HEIGHT);
        //isbusy=1;
        gp1.NewBall();
        gp1.setOnMousePressed(e -> newball());
        
        //draw lines and circles
        gp1.DrawPic();
        
        slide_x=300;
        slide_y=BALL_RADIUS;
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                /*
                final double width = 0.5 * primaryStage.getWidth();
                final double height = 0.5 * primaryStage.getHeight();
                final double radius = Math.sqrt(2) * Math.max(width, height);
                for (int i=0; i<STAR_COUNT; i++) {
                    final Node node = nodes[i];
                    final double angle = angles[i];
                    final long t = (now - start[i]) % 2000000000;
                    final double d = t * radius / 2000000000.0;
                    node.setTranslateX(Math.cos(angle) * d + width);
                    node.setTranslateY(Math.sin(angle) * d + height);
                }
                */

                
                //gp1.DrawPic();
                
                if(slide_y >= (BOTTOM_LINE_Y-BALL_RADIUS))
                {
                    isbusy=0;
                }
                else
                {
                    isbusy=1;
                    slide_y=slide_y+1;
                    
                    //change direction when impacted stick ball
                    for(i=0;i<28;i++)
                    {
                        if(gp1.c1_pt[i][0]==slide_x)
                        {
                            if(gp1.c1_pt[i][1]==slide_y)
                            {
                                //bcode
                                SecureRandom srand = new SecureRandom();
                                scode = (srand.nextInt() % 128 );
                                if((scode %2)==0)
                                    slide_x=slide_x + gp1.STICK_BALL_INTERVAL;
                                else
                                    slide_x=slide_x - gp1.STICK_BALL_INTERVAL;
                                
                            }
                        }
                    }
                    gp1.drawball(slide_x, slide_y, BALL_RADIUS);
                }
            }
        }.start();                 
        
        
        primaryStage.setTitle("BeamGame");
        primaryStage.setScene(scene1);
        primaryStage.show();
        
    }
    
    
    //Game Pane
    class GamePane extends Pane{       
        final int STICK_BALL_RADIUS=5;
        final int STICK_BALL_INTERVAL=35;
        int c1_pt[][]=new int[28][2];//coordinate array for circles
        int line_xy[][]=new int[22][2];//coordinate array for lines        
        int temp[]=new int[7];
        int c1_x[][]=new int[7][7];//x arrary for circles
        Line line1;
        Circle stickp;                           
        Circle opc;
                
        public GamePane(){
            //
            //getChildren().add(C2);
        }
        
        public void NewBall(){
            opc=new Circle();
            getChildren().add(opc);
        }
        
        public void DrawPic(){
            line_xy[0][0]=275;
            line_xy[0][1]=50;
        
            line_xy[1][0]=275;
            line_xy[1][1]=100;
            
            line_xy[2][0]=20;
            line_xy[2][1]=580;
            
            line_xy[3][0]=20;
            line_xy[3][1]=680;
            
            line_xy[4][0]=580;
            line_xy[4][1]=680;
            
            line_xy[5][0]=580;
            line_xy[5][1]=580;
            
            line_xy[6][0]=325;
            line_xy[6][1]=100;
            
            line_xy[7][0]=325;
            line_xy[7][1]=50;
            
            line_xy[8][0]=90;
            line_xy[8][1]=580;
            
            line_xy[9][0]=90;
            line_xy[9][1]=680;
            
            line_xy[10][0]=160;
            line_xy[10][1]=580;
            
            line_xy[11][0]=160;
            line_xy[11][1]=680;
            
            line_xy[12][0]=230;
            line_xy[12][1]=580;
            
            line_xy[13][0]=230;
            line_xy[13][1]=680;
            
            line_xy[14][0]=300;
            line_xy[14][1]=580;
            
            line_xy[15][0]=300;
            line_xy[15][1]=680;
            
            line_xy[16][0]=370;
            line_xy[16][1]=580;
            
            line_xy[17][0]=370;
            line_xy[17][1]=680;
            
            line_xy[18][0]=440;
            line_xy[18][1]=580;
            
            line_xy[19][0]=440;
            line_xy[19][1]=680;
            
            line_xy[20][0]=510;
            line_xy[20][1]=580;
            
            line_xy[21][0]=510;
            line_xy[21][1]=680;
            
            //draw lines
            int i;
            for(i=0;i<21;i++){
                if((i>=7) && (i%2==1)){
                    continue;
                }
                
                line1=new Line(line_xy[i][0], line_xy[i][1], line_xy[i+1][0], line_xy[i+1][1]);
                line1.setStrokeWidth(5);
                line1.setStroke(Color.GREEN);
                getChildren().add(line1);                                
            }                            
            
            temp[0]=90;
            temp[1]=160;
            temp[2]=230;
            temp[3]=300;
            temp[4]=370;
            temp[5]=440;
            temp[6]=510;            
            
            c1_x[0][0]=temp[0];
            c1_x[0][1]=temp[1];
            c1_x[0][2]=temp[2];
            c1_x[0][3]=temp[3];
            c1_x[0][4]=temp[4];
            c1_x[0][5]=temp[5];
            c1_x[0][6]=temp[6];          
           
            
            //create circle X point arrary
            int g,j;
            for(g=1;g<7;g++){                              
                for(j=0;j<7-g;j++){                    
                    c1_x[g][j]=(temp[j]+temp[j+1])/2;    
                    temp[j]=c1_x[g][j];                    
                    //System.out.printf("%d ", temp[j]);
                }                
                //System.out.printf("%d\n", g);
            }              
            
            //draw circles
            i=0;
            int m,n,py=580;
            for(m=0;m<7;m++){
                for(n=0;n<7-m;n++){
                    drawcircle(c1_x[m][n], py, STICK_BALL_RADIUS);
                    
                        c1_pt[i][0]=c1_x[m][n];
                        c1_pt[i][1]=py;
                        System.out.printf("i=%d m=%d n=%d x=%d y=%d\n", i, m, n, c1_x[m][n], py);//
                        i++;
                }
                py=py-70;//Y point 
                //System.out.printf("%d\n", m);
            }
            
        }
        
        //set circle feature
        
        int drawcircle(int x, int y, int r){            
            stickp=new Circle();
                        
            stickp.setCenterX(x);
            stickp.setCenterY(y);
            stickp.setRadius(r);
            stickp.setStroke(Color.BLACK);
            stickp.setFill(Color.RED);                
            getChildren().add(stickp);                                
            return 0;
        }
        
        
        int drawball(int x, int y, int r){       
            opc.setCenterX(x);
            opc.setCenterY(y);
            opc.setRadius(r);
            opc.setStroke(Color.BLACK);
            opc.setFill(Color.BLUE);                
            
            return 0;
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
