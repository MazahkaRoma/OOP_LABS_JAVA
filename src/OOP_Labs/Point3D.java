package OOP_Labs;

public class Point3D
{
    public Point3D(double pointX, double pointY, double pointZ) //Конструктор класса принимающий 3 координаты XYZ
    {
        this.pointX=pointX; //Присвоение параметра pointX к полю pointX
        this.pointY=pointY; //Присвоение параметра pointY к полю pointY
        this.pointZ=pointZ; //Присвоение параметра pointZ к полю pointZ
    }

    public Point3D() //Стандартный консьруктор
    {
        this.pointX=0.0;
        this.pointY=0.0;
        this.pointZ=0.0;
    }
    public double getPointX() //Get'ер pointX
    {
        return pointX;
    }

    public double getPointY() //Get'ер pointY
    {
        return pointY;
    }

    public double getPointZ() //Get'ер pointZ
    {
        return pointZ;
    }

    public void setPointX(double pointX) //Set'ер pointX
    {
        this.pointX = pointX;
    }

    public void setPointY(double pointY) //Set'ер pointY
    {
        this.pointY = pointY;
    }

    public void setPointZ(double pointZ) //Set'ер pointZ
    {
        this.pointZ = pointZ;
    }

    public boolean isEqual(Point3D anotherPoint) { return (this.pointX==anotherPoint.getPointX()
                                                   && this.pointY==anotherPoint.getPointY()
                                                   && this.pointZ==anotherPoint.getPointZ());
                                                 }

    public double getDistance(Point3D toAnotherPoint) //Метод рассчета растояния до точки
    {
        return Math.sqrt(Math.pow(toAnotherPoint.getPointX()-this.getPointX(),2)+
                         Math.pow(toAnotherPoint.getPointY()-this.getPointY(),2)+
                         Math.pow(toAnotherPoint.getPointY()-this.getPointZ(),2)
                        );
    }

    private double pointX; //Приватное поле pointX
    private double pointY; //Приватное поле pointY
    private double pointZ; //Приватное поле pointZ
}
