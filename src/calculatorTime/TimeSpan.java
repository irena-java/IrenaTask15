package calculatorTime;

public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        this.setHours(hours);
        this.setMinutes(minutes);
    }

    public void setHours(int hours) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Часы должны быть в допустимых диапазонах (0-23 часа)");
        } else {
            this.hours = hours;
        }
    }

    public void setMinutes(int minutes) {
        if (minutes > 59 || minutes < 0) {
            throw new IllegalArgumentException("Минуты должны быть в допустимых диапазонах (0-59 минут)");
        } else {
            this.minutes = minutes;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(TimeSpan timeSpan) {
        int minutesTotal = this.getHours() * 60 + this.getMinutes() + timeSpan.getHours() * 60 + timeSpan.getMinutes();
        int hoursTotal = minutesTotal / 60;
        minutesTotal = minutesTotal - hoursTotal * 60;
        System.out.printf("Сумма диапазонов - %02d : %02d\n", hoursTotal, minutesTotal);

    }

    public void sub(TimeSpan timeSpan) {
        int minutesTotal = this.getHours() * 60 + this.getMinutes() -
                timeSpan.getHours() * 60 - timeSpan.getMinutes();
        if (minutesTotal < 0) {
            throw new IllegalArgumentException("Второй диапазон доложен быть раньше первого");
        } else {
            int hoursTotal = minutesTotal / 60;
            minutesTotal = minutesTotal - hoursTotal * 60;
            System.out.printf("Разница диапазонов - %02d : %02d\n", hoursTotal, minutesTotal);
        }
    }

    public void mult(double times) {
        int minutesTotal = (int) (times * (this.getHours() * 60 + this.getMinutes()));
        int hoursTotal = minutesTotal / 60;
        if (minutesTotal < 0) {
            throw new IllegalArgumentException("Мультиплицирующий коеф.не должен быть отриц.числом");
        } else if (hoursTotal > 23) {
            throw new IllegalArgumentException("Получаемый диапазон превышает сутки");
        } else {
            minutesTotal = minutesTotal - hoursTotal * 60;
            System.out.printf("Новый диапазон - %02d : %02d\n", hoursTotal, minutesTotal);
        }
    }

    @Override
    public String toString() {
        return "TimeSpan{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}
