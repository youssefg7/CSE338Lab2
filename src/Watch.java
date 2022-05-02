public class Watch {
    private String state, subState, time, date;
    private int m, h, D, M, Y;

    public Watch() {
        state = "NORMAL";
        subState = "time";
        m = 0;
        h = 0;
        D = 1;
        M = 1;
        Y = 2000;
        time = "0 : 0";
        date = "1 - 1 - 2000";
    }

    public void setInput(char i) {
        switch (state) {
            case "NORMAL":
                if (i == 'c') {
                    state = "UPDATE";
                    subState = "min";
                } else if (i == 'b') {
                    state = "ALARM";
                    subState = "alarm";
                } else if (i == 'a' && subState.equals("time")) subState = "date";
                else if (i == 'a' && subState.equals("date")) subState = "time";
            case "UPDATE":
                if (i == 'd' || (i == 'a' && subState.equals("year"))) {
                    state = "NORMAL";
                    subState = "time";
                } else if (i == 'a') {
                    switch (subState) {
                        case "min":
                            subState = "hour";
                            break;
                        case "hour":
                            subState = "day";
                            break;
                        case "day":
                            subState = "month";
                            break;
                        case "month":
                            subState = "year";
                    }
                } else if (i == 'b') {
                    switch (subState) {
                        case "min":
                            m = (m == 59) ? 0 : m + 1;
                            break;
                        case "hour":
                            h = (h == 23) ? 0 : h + 1;
                            break;
                        case "day":
                            D = (D == 31) ? 1 : D + 1;
                            break;
                        case "month":
                            M = (M == 12) ? 1 : M + 1;
                            break;
                        case "year":
                            Y++;
                    }
                }
                time = h + " : " + m;
                date = Y + " - " + M + " - " + D;
            case "ALARM":
                if (i == 'd') {
                    state = "NORMAL";
                    subState = "time";
                } else if (subState.equals("alarm") && i == 'a') {
                    subState = "chime";
                }
        }
    }

    public void displayTime() {
        System.out.println(time);
    }

    public void displayDate() {
        System.out.println(date);
    }

    public String getState(){
        return state;
    }

    public String getSubState(){
        return subState;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
