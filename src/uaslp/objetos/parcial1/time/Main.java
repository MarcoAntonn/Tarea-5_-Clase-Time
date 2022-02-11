package uaslp.objetos.parcial1.time;
//Marco Antonio Lopez Arriaga
class Time{
    private int hour;
    private int minute;
    private int second;

    //Constructor
    public Time (int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //Setters
    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //Getters
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    //Otros Metodos
    public void addHour(int delta){
        //0 a 23
        hour += delta;

        if(hour < 0){
            while (hour < 0){
                hour += 24;
            }
        }else {
            while (hour > 23){
                hour -= 24;
            }
        }

    }

    public void addMinute(int delta){
        minute += delta;

        if (minute < 0){
            while (minute < 0){
                this.addHour(-1);
                minute += 60;
            }
        }else {
            while (minute > 59){
                this.addHour(1);
                minute -= 60;
            }
        }

    }

    public void addSecond(int delta){
        second += delta;

        if (second < 0){
            while (second < 0){
                this.addMinute(-1);
                second += 60;
            }
        }else {
            while (second > 59){
                this.addMinute(1);
                second -= 60;
            }
        }
    }

    public String toString(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}

public class Main {
    public static void main(String[] x) {
        System.out.println("Add datos dentro del rango: ");
        Time time1 = new Time(1, 1, 1);
        time1.addHour(8);
        time1.addMinute(31);
        time1.addSecond(44);
        System.out.println(time1.toString());

        System.out.println();

        System.out.println("Add datos sobre el rango: ");
        Time time2 = new Time(1, 1, 1);
        time2.addHour(34);
        time2.addMinute(110);
        time2.addSecond(150);
        System.out.println(time2.toString());

        System.out.println();

        System.out.println("Add datos debajo del rango: ");
        Time time3 = new Time(1, 1, 1);
        time3.addHour(-5);
        time3.addMinute(-30);
        time3.addSecond(-44);
        System.out.println(time3.toString());
    }
}
