package com.star.tank.collider;

import com.star.tank.GameModel;
import com.star.tank.entity.*;

public class TankWallCollider implements Collider {
    @Override
    public void collide(GameObject go1, GameObject go2) {
        if(go1 instanceof BaseWall && go2 instanceof BaseTank){
            BaseWall wall = (BaseWall) go1;
            BaseTank tank = (BaseTank) go2;
            if(tank.getRect().intersects(wall.getRect())) {
                tank.reverseDirAndFallback();
            }
        }
        else if(go1 instanceof BaseTank && go2 instanceof BaseWall){
            this.collide(go2,go1);
        }
        else
            return;
    }
}
