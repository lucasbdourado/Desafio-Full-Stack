package br.com.neomind.lucasbdourado;

public class Clock {
    private Integer angleHour = 360 / 12;

    private Integer angleMinute = 360 / 60;

    private Integer hour;

    private Integer min;

    public Integer getHour() {
        return hour;
    }

    public Integer getMin() {
        return min;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public int retornaAnguloRelogio(int hora, int minuto) {
        angleHour = angleHour * hora;
        angleMinute = angleMinute * minuto;

        Integer result = angleHour - angleMinute;

        if(result < 0) result = -result;

        if(result > 180) result = angleHour - angleMinute + 360;

        return result;
    }
}
