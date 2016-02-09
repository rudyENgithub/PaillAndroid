package com.rudysorto.inventario;


import android.app.Activity;

public class Grafica extends Activity {
/*
    private final Handler mHandler = new Handler();
    private Runnable mTimer1;
    private Runnable mTimer2;
    private GraphView graphView;
    private GraphViewSeries exampleSeries1;
    private GraphViewSeries exampleSeries2;
    private double graph2LastXValue = 5d;
    private GraphViewSeries exampleSeries3;

    //change graphType to line if bar chart not required
    private String graphType = "bar";

    private double getRandom() {
        double high = 3;
        double low = 0.5;
        return Math.random() * (high - low) + low;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);

        //example series data
        exampleSeries1 = new GraphViewSeries(new GraphViewData[] {
                new GraphViewData(1, 2.0d)
                , new GraphViewData(2, 1.5d)
                , new GraphViewData(2.5, 3.0d)
                , new GraphViewData(3, 2.5d)
                , new GraphViewData(4, 1.0d)
                , new GraphViewData(5, 3.0d)
        });
        exampleSeries3 = new GraphViewSeries(new GraphViewData[] {});
        exampleSeries3.getStyle().color = Color.CYAN;


        if (graphType.equalsIgnoreCase("bar")) {
            graphView = new BarGraphView(
                    this
                    , "GraphViewDemo"
            );
        } else {
            graphView = new LineGraphView(
                    this // context
                    , "GraphViewDemo"
            );
        }
        graphView.addSeries(exampleSeries1);
        graphView.addSeries(exampleSeries3);

        LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
        layout.addView(graphView);

        // ----------
        exampleSeries2 = new GraphViewSeries(new GraphViewData[] {
                new GraphViewData(1, 2.0d)
                , new GraphViewData(2, 1.5d)
                , new GraphViewData(2.5, 3.0d)
                , new GraphViewData(3, 2.5d)
                , new GraphViewData(4, 1.0d)
                , new GraphViewData(5, 3.0d)
        });


        if (graphType.equalsIgnoreCase("bar")) {
            graphView = new BarGraphView(
                    this
                    , "GraphViewDemo"
            );
        } else {
            graphView = new LineGraphView(
                    this
                    , "GraphViewDemo"
            );
            ((LineGraphView) graphView).setDrawBackground(true);
        }

        graphView.addSeries(exampleSeries2);
        graphView.setViewPort(1, 8);
        graphView.setScalable(true);
        graphView.getGraphViewStyle().setGridColor(Color.BLACK);
        graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.BLACK);
        graphView.getGraphViewStyle().setVerticalLabelsColor(Color.BLACK);

        layout = (LinearLayout) findViewById(R.id.graph2);
        layout.addView(graphView);
    }

    @Override
    protected void onPause() {
        mHandler.removeCallbacks(mTimer1);
        mHandler.removeCallbacks(mTimer2);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTimer1 = new Runnable() {
            @Override
            public void run() {
                exampleSeries1.resetData(new GraphViewData[] {
                        new GraphViewData(1, getRandom())
                        , new GraphViewData(2, getRandom())
                        , new GraphViewData(2.5, getRandom())
                        , new GraphViewData(3, getRandom())
                        , new GraphViewData(4, getRandom())
                        , new GraphViewData(5, getRandom())
                });
                exampleSeries3.resetData(new GraphViewData[] {
                        new GraphViewData(2, getRandom())
                        , new GraphViewData(2.5, getRandom())
                        , new GraphViewData(3, getRandom())
                        , new GraphViewData(4, getRandom())
                });
                mHandler.postDelayed(this, 300);
            }
        };
        mHandler.postDelayed(mTimer1, 300);

        mTimer2 = new Runnable() {
            @Override
            public void run() {
                graph2LastXValue += 1d;
                exampleSeries2.appendData(new GraphViewData(graph2LastXValue, getRandom()), true, 10);
                mHandler.postDelayed(this, 200);
            }
        };
        mHandler.postDelayed(mTimer2, 1000);
    }*/
}


