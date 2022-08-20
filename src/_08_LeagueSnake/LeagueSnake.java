package _08_LeagueSnake;

import java.util.Random;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    Segment head;
    int foodX;
    int foodY;
    int direction = UP;
    int foodEaten = 0;
    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void setup() {
        head = new Segment(50, 50);
        frameRate(20);
        dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
    	foodX = new Random().nextInt(495) + 3;
    	foodY = new Random().nextInt(495) + 3;
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        background(0,0,128);
        drawFood();
        move();
        drawSnake();
        eat();
    }

    void drawFood() {
        // Draw the food
    	fill(255, 0, 0);
        ellipse(foodX, foodY, 10, 10);
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(0, 200, 0);
    	rect(head.x,head.y, 15, 15 );
    }

    void drawTail() {
        // Draw each segment of the tail
        
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.
    	
    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed(KeyEvent e) {
        // Set the direction of the snake according to the arrow keys pressed
    	int key = e.getKeyCode();
    	System.out.println(" " +key);
    	if(key == 38) {
    		direction = UP;
    		
    	} else if(key == 40 ) {
    		direction = DOWN;
    	}
    	else if(key == 39) {
    		direction = RIGHT;
    	}
    	else if(key == 37) {
    		direction = LEFT;
    	}
  
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
    	switch(direction) {
    	  case UP:
    		head.y -= 5;
    	    break;
    	  case DOWN:
    	    head.y +=5;
    	    break;
    	  case LEFT:
    	    head.x -= 5;
    	    break;
    	  case RIGHT:
    		head.x +=5;
    	    break;
    	  }
    	  checkBoundaries();
        
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if (head.x > width) {
        	head.x = 0;
        } else if(head.x < 0) {
        	head.x = width;
        } else if (head.y > height) {
        	head.y = 0;
        } else if (head.y < 0) {
        	head.y = height;
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        if(head.x == foodX+1 && head.y == foodY+1){
        	foodEaten++;
        	dropFood();
        	System.out.println(foodEaten);
        }
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
