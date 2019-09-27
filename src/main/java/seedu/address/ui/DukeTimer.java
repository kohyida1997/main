package seedu.address.ui;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class DukeTimer {
    private Toolkit toolkit;
    private Timer timer;
    private int currentSeconds;
    private ResultDisplay resultDisplay;
    private String mainMessage;

    public DukeTimer(String mainMessage, int seconds, ResultDisplay resultDisplay) {
        this.mainMessage = mainMessage;
        this.resultDisplay = resultDisplay;
        this.currentSeconds = seconds;
        this.toolkit = Toolkit.getDefaultToolkit();
        this.timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(getTimeLeft() >= 0) {
                    resultDisplay.setFeedbackToUser(mainMessage + " :" + getTimeLeft());
                } else {
                    timer.cancel();
                    resultDisplay.setFeedbackToUser("");
                }
                updateSecondsLeft();
            }
        }, 0, 1000);
    }

    private void updateSecondsLeft() {
        currentSeconds--;
    }

    public int getTimeLeft() {
        return currentSeconds;
    }

    public void abortTimer() {
        this.timer.cancel();

    }
}
