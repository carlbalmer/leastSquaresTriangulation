/**
 * Created by carl on 15.08.16.
 */
public class Datapoint {

    final int room;
    final int rssiAP1;
    final int rssiAP2;
    final int rssiAP3;
    final int rssiAP4;
    final int rssiAP5;
    final int XAxys;
    final int YAxys;
    final int ZAxys;
    final float XPosition;
    final float YPosition;

    float distanceAP1;
    float distanceAP2;
    float distanceAP3;
    float distanceAP4;
    float distanceAP5;

    float weightAP1;
    float weightAP2;
    float weightAP3;
    float weightAP4;
    float weightAP5;

    public Datapoint(int room, int rssiAP1, int rssiAP2, int rssiAP3, int rssiAP4, int rssiAP5, int XAxys, int YAxys, int ZAxys, float XPosition, float YPosition) {
        this.room = room;
        this.rssiAP1 = rssiAP1;
        this.rssiAP2 = rssiAP2;
        this.rssiAP3 = rssiAP3;
        this.rssiAP4 = rssiAP4;
        this.rssiAP5 = rssiAP5;
        this.XAxys = XAxys;
        this.YAxys = YAxys;
        this.ZAxys = ZAxys;
        this.XPosition = XPosition;
        this.YPosition = YPosition;
    }
}