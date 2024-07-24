package Refelect;

public class RectangleDemo {
    @Length(value = 50)
    private int length;
    @Width(value = 40)
    private int width;

    public RectangleDemo() {
    }

    public RectangleDemo(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPerimeter() {
        return (length + width) * 2;
    }

    public int getArea() {
        return length * width;
    }
}
