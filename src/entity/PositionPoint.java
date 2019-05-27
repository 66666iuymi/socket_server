package entity;

public class PositionPoint {
    private int sno;
    private double longitude;
    private double latitude;

    public PositionPoint(int sno, double longitude, double latitude) {
        this.sno = sno;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public PositionPoint() {
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
