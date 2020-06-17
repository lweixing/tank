package com.star.tank.collider;

import com.star.tank.GameModel;
import com.star.tank.entity.BaseTank;
import com.star.tank.entity.GameObject;

public class TankTankCollider implements Collider {
    @Override
    public void collide(GameObject go1, GameObject go2) {
        if(go1 instanceof BaseTank && go2 instanceof BaseTank){
            BaseTank tank1 = (BaseTank) go1;
            BaseTank tank2 = (BaseTank) go2;
            if(tank1.getRect().intersects(tank2.getRect())){
                tank1.reverseDirAndFallback();
                tank2.reverseDirAndFallback();
            }
        }
        else
            return;
    }
}
