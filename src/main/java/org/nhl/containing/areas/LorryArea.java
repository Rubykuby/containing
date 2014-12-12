package org.nhl.containing.areas;

import com.jme3.asset.AssetManager;
import org.nhl.containing.cranes.TruckCrane;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeroen
 */
public class LorryArea extends Area {

    public List<TruckCrane> truckCranes = new ArrayList();
    private AssetManager assetManager;
    private int cranes;
    private int craneXAxis = 0;

    public LorryArea(AssetManager assetManager, int cranes) {
        this.assetManager = assetManager;
        this.cranes = cranes;
        initLorryArea();
    }

    /**
     * Initialize a lorry area.
     */
    private void initLorryArea() {
        // Add truck cranes to the list and scene.
        for (int i = 0; i < cranes; i++) {
            truckCranes.add(new TruckCrane(assetManager, -1));
            truckCranes.get(i).setLocalTranslation(craneXAxis, 0, 0);
            this.attachChild(truckCranes.get(i));
            craneXAxis += 14;
        }
    }
    
    public List<TruckCrane> getTruckCranes(){
        return truckCranes;
    }
}
