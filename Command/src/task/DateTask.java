package task;

import java.util.Date;

public class DateTask extends AbstractTask implements INoArgsTask{
    @Override
    public void run() {
        System.out.println(new Date());
    }
}
