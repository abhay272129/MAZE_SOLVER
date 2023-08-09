
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author jeema
 */
public class NewClass extends JFrame {
  // here i am taking 2D grid in which we will perfom operation
    private final int[][] maze=
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
    //here 1==> obstacle
    // 0==> from which we can traverse
    // 9==> destination point
    
    public List<Integer> path=new ArrayList<>();
    public NewClass(){
        setTitle("Maze Solver");
        setSize(760,640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze,1, 1, path);
        
    }
    
    //we are changing the implementation of paint function which is written already over the base class 
    // According to our use we are changing the few implementation of paint function
    @Override
    public void paint(Graphics g){
        
        g.translate(50,50);
        
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color;// here i am creating the object of Color
                color = switch (maze[i][j]) {
                    case 1 -> Color.BLACK;
                    case 9 -> Color.RED;
                    default -> Color.WHITE;
                };
                g.setColor(color);
                
                g.fillRect(50*j, 50*i,50,50);
                g.setColor(Color.RED);
                g.drawRect(50*j,50*i,50,50);   
            }
        }
        for(int i=0;i<path.size();i+=2){
            int pathx=path.get(i);
            int pathy=path.get( i+1);
            g.setColor(Color.ORANGE);
            g.fillRect(50*pathx,50*pathy,30,30);
            
        }
    }
    public static void main(String[] args){
        NewClass view=new NewClass();
        view.setVisible(true);
    }
}
