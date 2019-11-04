package javaConcurrencePractice.ch4;

import annotation.GuardedBy;
import javaConcurrencePractice.bean.MutablePoint;
import javaConcurrencePractice.gui.NumberAxis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 基于监视器模式的车辆追踪
 */
public class MonitorVehicleTracker {
    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("no such id: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    //深度拷贝
    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, MutablePoint> locations = new HashMap<>();
        locations.put("1", new MutablePoint());
        locations.put("2", new MutablePoint());
        locations.put("3", new MutablePoint());
        locations.put("4", new MutablePoint());
        locations.put("5", new MutablePoint());

        MonitorVehicleTracker tracker = new MonitorVehicleTracker(locations);

        Timer timer = new Timer();
        //修改所有车辆的位置
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 1; i < 6; i++) {
                    Random r = new Random();
                    int x = r.nextInt(450);
                    int y = r.nextInt(450);
                    String id = i + "";
                    tracker.setLocation(id, x, y);
                }
            }
        }, 0, 100);

        //渲染当前所有车辆位置
        NumberAxis numberAxis = new NumberAxis();
        numberAxis.go(numberAxis);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Map<String, MutablePoint> locations = tracker.getLocations();
                numberAxis.setPoints(new ArrayList<>(locations.values()));
            }
        }, 0, 1000);
    }
}
