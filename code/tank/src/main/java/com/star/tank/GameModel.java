package com.star.tank;

import com.star.tank.collider.ColliderChain;
import com.star.tank.collider.TankBulletCollider;
import com.star.tank.collider.TankTankCollider;
import com.star.tank.entity.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private final static GameModel instance = new GameModel();

    public static GameModel getInstance(){
        return instance;
    }

    private BaseTank myTank;

    private List<GameObject> gameObjects = new ArrayList<GameObject>();

    private ColliderChain colliderChain = new ColliderChain();

    public void addGameObject(GameObject gameObject){
        this.gameObjects.add(gameObject);
    }
    public void removeGameObject(GameObject gameObject){
        this.gameObjects.remove(gameObject);
    }

    private GameModel(){

    }
    static{
        instance.init();
    }

    public void init(){
        myTank = new BaseTank(600,500,Dir.DOWN,Group.GOOD);

        for( int i=0;i< PropertyMgr.getInstance().getInt("badtankColumn");i++) {
            for (int j = 0; j < PropertyMgr.getInstance().getInt("badtankRow"); j++) {
                new BaseTank(i * 80 + 20, j*60 + 100, Dir.DOWN, Group.BAD);
            }
        }

        //造墙
        new BaseWall(0,0,1080,40);
        new BaseWall(0,950,1080,10);
        new BaseWall(0,0,10,960);
        new BaseWall(1070,0,10,960);

        new BaseWall(920,300,40,300);
        new BaseWall(560,600,400,40);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        //g.drawString("子弹数量："+bullets.size(),10,50);
        //g.drawString("坦克数量："+tanks.size(),100,50);
        g.setColor(c);
        myTank.paint(g);

        for(int i=0;i<gameObjects.size();i++){
            gameObjects.get(i).paint(g);
        }
        //碰撞检测
        for(int i=0;i<gameObjects.size();i++) {
            for(int j=i+1;j<gameObjects.size();j++){
                colliderChain.collide(gameObjects.get(i),gameObjects.get(j));
            }
        }

    }

    public BaseTank getMyTank() {
        return myTank;
    }

    public void setMyTank(BaseTank myTank) {
        this.myTank = myTank;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }
}
