package com.star.tank.entity;

import com.star.tank.*;
import com.star.tank.fire.DefaultTankFireStrategy;
import com.star.tank.fire.FireStrategy;

import java.awt.*;
import java.util.Random;

public class BaseTank extends GameObject{
    private Dir dir = Dir.UP;
    private Group group = null;
    private boolean moving = false;
    private static final int SPEED = 5;
    public static final int TANK_WIDTH = 30;
    public static final int TANK_HEIGHT = 30;
    private boolean living = true;
    private int previousX;
    private int previousY;
    public BaseTank(int x, int y, Dir dir, Group group ){
        super();
        this.x = x;
        this.y = y;
        this.previousX = this.x;
        this.previousY = this.y;
        this.dir = dir;
        this.group = group;
        rect = new Rectangle(x,y,TANK_WIDTH,TANK_HEIGHT);
        if(group == Group.BAD)
            moving = true;
        GameModel.getInstance().addGameObject(this);
    }


    public void paint(Graphics g) {

        //判断是否删除
        if(!living)
            GameModel.getInstance().removeGameObject(this);


        //画
        switch (dir) {
            case LEFT:
                g.drawImage(group==Group.BAD? ResourceMgr.getInstance().tankL:ResourceMgr.getInstance().goodtankL,x,y,TANK_WIDTH,TANK_HEIGHT,null);
                break;
            case RIGHT:
                g.drawImage(group==Group.BAD?ResourceMgr.getInstance().tankR:ResourceMgr.getInstance().goodtankR,x,y,TANK_WIDTH,TANK_HEIGHT,null);
                break;
            case UP:
                g.drawImage(group==Group.BAD?ResourceMgr.getInstance().tankU:ResourceMgr.getInstance().goodtankU,x,y,TANK_WIDTH,TANK_HEIGHT,null);
                break;
            case DOWN:
                g.drawImage(group==Group.BAD?ResourceMgr.getInstance().tankD:ResourceMgr.getInstance().goodtankD,x,y,TANK_WIDTH,TANK_HEIGHT,null);
                break;
        }

        //移动
        this.move();

        //随机改变方向
        this.randomChangeDir();

        //随机开火
        this.randomFir();


    }

    private void randomFir() {

        if(this.group == Group.BAD){
            if(new Random().nextInt(100)>95) {
                this.fire(DefaultTankFireStrategy.getInstance());
            }
        }
        else{
            //fire();
        }
    }

    public void fire(FireStrategy fireStrategy){

        fireStrategy.fire(this);
    }

    private void randomChangeDir() {
        if(this.group == Group.BAD) {
            if(new Random().nextInt(100)>97) {
                dir = Dir.values()[new Random().nextInt(4)];
            }
        }
    }

    private void move() {
        this.previousX = x;
        this.previousY = y;
        if(isMoving()) {
            switch (dir) {
                case LEFT:
                    x -= SPEED;
                    break;
                case RIGHT:
                    x += SPEED;
                    break;
                case UP:
                    y -= SPEED;
                    break;
                case DOWN:
                    y += SPEED;
                    break;
            }
            rect.x = x;
            rect.y = y;
        }
    }

    public void reverseDirAndFallback(){
        switch (this.dir){
            case UP:this.setDir(Dir.DOWN);break;
            case DOWN:this.setDir(Dir.UP);break;
            case LEFT:this.setDir(Dir.RIGHT);break;
            case RIGHT:this.setDir(Dir.LEFT);break;
        }
        x = previousX;
        y = previousY;
    }


    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void die() {
        living = false;
    }
}
