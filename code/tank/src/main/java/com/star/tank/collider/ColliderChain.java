package com.star.tank.collider;

import com.star.tank.PropertyMgr;
import com.star.tank.entity.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider{
    private List<Collider> colliders = new LinkedList<Collider>();

    public ColliderChain(){
        //add(new TankBulletCollider());
        //add(new TankTankCollider());
        String colliderNameStr = PropertyMgr.getInstance().getString("gameObjectColliders");
        String [] colliderNameArray = colliderNameStr.split(",");
        for(String name : colliderNameArray){
            try {
                Collider collider = (Collider) Class.forName(name).newInstance();
                add(collider);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Collider c){
        colliders.add(c);
    }
    @Override
    public void collide(GameObject o1,GameObject o2){
        for(Collider collider : colliders){
            collider.collide(o1,o2);
        }
    }
}
