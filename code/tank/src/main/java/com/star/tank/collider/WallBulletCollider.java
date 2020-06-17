package com.star.tank.collider;

import com.star.tank.entity.*;

public class WallBulletCollider implements Collider {
    @Override
    public void collide(GameObject go1, GameObject go2) {
        if(go1 instanceof BaseBullet && go2 instanceof BaseWall){
            BaseBullet bullet = (BaseBullet) go1;
            BaseWall wall = (BaseWall) go2;
            if(bullet.getRect().intersects(wall.getRect())){
                bullet.die();
            }
        }
        else if(go1 instanceof BaseWall && go2 instanceof BaseBullet){
            this.collide(go2,go1);
        }
        else
            return;
    }
}
