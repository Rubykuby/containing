package org.nhl.containing.cranes;

import com.jme3.cinematic.MotionPathListener;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.scene.Node;

public class Crane extends Node  implements MotionPathListener{

    private int processingMessageId = -1;
    private boolean arrived = false;
    protected float speed;
    
    public void onWayPointReach(MotionEvent motionControl, int wayPointIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getProcessingMessageId() {
        return processingMessageId;
    }

    public boolean isArrived() {
        return arrived;
    }

    public void setArrived(boolean arrived) {
        this.arrived = arrived;
    }

    public void setProcessingMessageId(int processingMessageId) {
        this.processingMessageId = processingMessageId;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }
    
    public void multiplySpeed(float multiplier)
    {
        speed *= multiplier;
    }
}
