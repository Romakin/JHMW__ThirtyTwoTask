package Task2;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() { position = 5; }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        if (position + steps >= MAX_POSITION) {
            return false;
        }
        if (position + steps < MIN_POSITION) {
            return false;
        }
        position += steps;
        return true;
    }

    public void printPosition() {
        StringBuilder sb = new StringBuilder();
        for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
            sb.append( i == position ? "*" : "-" );
        }
        System.out.println(sb.toString());
    }
}
