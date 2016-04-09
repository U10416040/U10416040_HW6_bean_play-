
package beamgame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class BeamGame extends Application {
    
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
                                
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(new LinePane(), 600, 800);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //draw line and circle
    class LinePane extends Pane{       	
        int pt[][]=new int[22][2];//array for lines        
        int temp[]=new int[7];
        int c1[][]=new int[7][7];//arrary for circles
        Line line1;
        Circle C1;        
                
        public LinePane(){
            pt[0][0]=275;
            pt[0][1]=50;
        
            pt[1][0]=275;
            pt[1][1]=100;
            
            pt[2][0]=20;
            pt[2][1]=580;
            
            pt[3][0]=20;
            pt[3][1]=680;
            
            pt[4][0]=580;
            pt[4][1]=680;
            
            pt[5][0]=580;
            pt[5][1]=580;
            
            pt[6][0]=325;
            pt[6][1]=100;
            
            pt[7][0]=325;
            pt[7][1]=50;
            
            pt[8][0]=90;
            pt[8][1]=580;
            
            pt[9][0]=90;
            pt[9][1]=680;
            
            pt[10][0]=160;
            pt[10][1]=580;
            
            pt[11][0]=160;
            pt[11][1]=680;
            
            pt[12][0]=230;
            pt[12][1]=580;
            
            pt[13][0]=230;
            pt[13][1]=680;
            
            pt[14][0]=300;
            pt[14][1]=580;
            
            pt[15][0]=300;
            pt[15][1]=680;
            
            pt[16][0]=370;
            pt[16][1]=580;
            
            pt[17][0]=370;
            pt[17][1]=680;
            
            pt[18][0]=440;
            pt[18][1]=580;
            
            pt[19][0]=440;
            pt[19][1]=680;
            
            pt[20][0]=510;
            pt[20][1]=580;
            
            pt[21][0]=510;
            pt[21][1]=680;
            
            //draw lines
            int i;
            for(i=0;i<21;i++){
                if((i>=7) && (i%2==1)){
                    continue;
                }
                
                line1=new Line(pt[i][0], pt[i][1], pt[i+1][0], pt[i+1][1]);
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
            
            c1[0][0]=temp[0];
            c1[0][1]=temp[1];
            c1[0][2]=temp[2];
            c1[0][3]=temp[3];
            c1[0][4]=temp[4];
            c1[0][5]=temp[5];
            c1[0][6]=temp[6];          
           
            
            //create circle X point arrary
            int g,j;
            for(g=1;g<7;g++){                              
                for(j=0;j<7-g;j++){                    
                    c1[g][j]=(temp[j]+temp[j+1])/2;    
                    temp[j]=c1[g][j];                    
                    System.out.printf("%d ", temp[j]);
                }                
                System.out.printf("%d\n", g);
            }              
            
            //draw circles
            int m,n,py=580;
            for(m=0;m<7;m++){
                for(n=0;n<7-m;n++){
                    drawcircle(c1[m][n], py, 10);
                    System.out.printf("x=%d y=%d ", c1[m][n], py);
                    
                }
                py=py-70;//Y point 
                System.out.printf("%d\n", m);
            }
            
        }
        
        //set circle feature
        int drawcircle(int x, int y, int r){            
            C1=new Circle();           
            
            C1.setCenterX(x);
            C1.setCenterY(y);
            C1.setRadius(r);
            C1.setStroke(Color.BLACK);
            C1.setFill(Color.RED);                
            getChildren().add(C1);                                
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
