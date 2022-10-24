
public class labotaryPoint {

    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(5, 7);
        MyPoint p2 = new MyPoint(6, 1);
        MyPoint p3 = new MyPoint(3, 9);
        
        double d = p1.distance(p2);
        System.out.println("distance of p1 and p2 : "+d);
        
        MyTriangle t1 = new MyTriangle(p1, p2, p3);
        MyPoint co = t1.getCentroid();
        System.out.println("Centroid = "+co);
        
        boolean  status = MyTriangle.isTriangleValid(p1, p2, p3);
        System.out.println("Validity of triangle : "+status);
        
        System.out.println("Area of triangle : "+t1.getArea());
        
        
    }
}

class MyPoint {

    private int x = 0;  //x1
    private int y = 0;  //y1

    public MyPoint() {

    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";

    }

    public double distance(int x, int y) {
        double a, b, c;
        a = this.x - x;
        b = this.y - y;
        c = Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0));
        return c;
    }

    public double distance(MyPoint another) {
//         int x1,x2,y1,y2;
//         double a,b,c;
//         x1=this.x;
//         y1=this.y;
//         x2=another.x;
//         y2=another.y;
//         a=x1-x2;
//         b=y1-y2;
//         c=Math.sqrt(Math.pow(a, 2.0)+Math.pow(b, 2.0));

        return distance(another.x, another.y);

    }

}

class MyTriangle {

    private MyPoint vertex_1;
    private MyPoint vertex_2;
    private MyPoint vertex_3;

    public MyPoint getVertex_1() {
        return vertex_1;
    }

    public void setVertex_1(MyPoint vertex_1) {
        this.vertex_1 = vertex_1;
    }

    public MyPoint getVertex_2() {
        return vertex_2;
    }

    public void setVertex_2(MyPoint vertex_2) {
        this.vertex_2 = vertex_2;
    }

    public MyPoint getVertex_3() {
        return vertex_3;
    }

    public void setVertex_3(MyPoint vertex_3) {
        this.vertex_3 = vertex_3;
    }

    public MyTriangle(MyPoint vertex_1, MyPoint vertex_2, MyPoint vertex_3) {
        this.vertex_1 = vertex_1;
        this.vertex_2 = vertex_2;
        this.vertex_3 = vertex_3;
    }

    public MyPoint getCentroid() {
        int ox, oy;
        ox = (this.vertex_1.getX() + this.vertex_2.getX() + this.vertex_3.getX()) / 3;
        oy = (this.vertex_1.getY() + this.vertex_2.getY() + this.vertex_3.getY()) / 3;
        MyPoint centroid = new MyPoint(ox, oy);
        return centroid;
    }

    public static boolean isTriangleValid(MyPoint vertex_1, MyPoint vertex_2, MyPoint vertex_3) {
        double a, b, c;
        a = vertex_1.distance(vertex_2);
        b = vertex_1.distance(vertex_3);
        c = vertex_3.distance(vertex_2);

        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            return true;
        } else {
            return false;
        }
    }

    public double getArea() {
        double a, b, c, s, area;
        a = vertex_1.distance(vertex_2);
        b = vertex_1.distance(vertex_3);
        c = vertex_3.distance(vertex_2);

        s = (a + b + c) / 3;

        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }

    public String getTriangleType() {
        double a, b, c, s, area;
        a = vertex_1.distance(vertex_2);
        b = vertex_1.distance(vertex_3);
        c = vertex_3.distance(vertex_2);

        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || c == a) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    @Override
    public String toString() {
        return  "MyTriangle {vertex_1=" + this.vertex_1 
                + ", vertex_2=" + this.vertex_2 
                + ", vertex_3=" + this.vertex_3 + "}";
    }

}
