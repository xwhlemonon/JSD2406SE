package FlyDemo;

public class Sky extends FlyingObject {
    private int speed;// 速度
    private short y1;

    public Sky() {
        width = World.WIDTH;
        height = World.HEIGHT;
        x = 0;
        y = 0;
        speed = 1;
        y1 = World.HEIGHT - World.HEIGHT * 2;
    }
}
