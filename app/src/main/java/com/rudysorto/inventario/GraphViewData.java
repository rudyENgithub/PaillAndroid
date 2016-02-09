package com.rudysorto.inventario;

/**
 * Created by rsorto on 25/01/2016.
 */
public class GraphViewData implements GraphViewDataInterface {
    private double x,y;

    public GraphViewData(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }
}