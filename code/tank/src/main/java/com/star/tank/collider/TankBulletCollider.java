package com.star.tank.collider;

import com.star.tank.GameModel;
import com.star.tank.entity.BaseBullet;
import com.star.tank.entity.BaseExplode;
import com.star.tank.entity.BaseTank;
import com.star.tank.entity.GameObject;

public class TankBulletCollider implements Collider {
    @Override
    public void collide(GameObject go1, GameObject go2) {
        if(go1 instanceof BaseBullet && go2 instanceof BaseTank){
            BaseBullet bullet = (BaseBullet) go1;
            BaseTank tank = (BaseTank) go2;
            if(bullet.getGroup() == tank.getGroup())
                return;
            if(bullet.getRect().intersects(tank.getRect())){
                bullet.die();
                tank.die();
                new BaseExplode(tank.getX(),tank.getY());
            }
        }
        else if(go1 instanceof BaseTank && go2 instanceof BaseBullet){
            this.collide(go2,go1);
        }
        else
            return;
    }
}
