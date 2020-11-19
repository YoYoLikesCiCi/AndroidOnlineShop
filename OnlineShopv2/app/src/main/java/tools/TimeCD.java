package tools;

import android.os.CountDownTimer;

public class TimeCD extends CountDownTimer {
    //倒计时器
    public enum TimeCondition{
        stop,
        running
    };//计时器的两种状态
    private TimeCondition timeCondition;//计时器状态

    public TimeCD(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        timeCondition = TimeCondition.running;
    }

    public boolean getTimeCondition(){
        switch (timeCondition){
            case stop:
                return false;
            default: return true;
        }
    }

    public void setTimeCondition(TimeCondition timeCondition){
        this.timeCondition = timeCondition;
    }

    @Override
    public void onTick(long millisUntilFinished) {

    }

    @Override
    public void onFinish() {
        timeCondition = TimeCondition.stop;
    }

}
